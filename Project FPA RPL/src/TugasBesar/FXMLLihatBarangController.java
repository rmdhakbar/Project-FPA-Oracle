package TugasBesar;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import static javafx.collections.FXCollections.observableArrayList;

public class FXMLLihatBarangController implements Initializable {
    ArrayList<ModelBarang> donasiBarang = new ArrayList<>();
    XStream xST = new XStream(new StaxDriver());

    ObservableList datadonbarang = observableArrayList();

    void bukaXML(){
        FileInputStream input = null;
        xST.addPermission(AnyTypePermission.ANY);
        xST.allowTypesByWildcard(new String[]{"TugasBesar.ModelBarang"});
        try {
            input = new FileInputStream("ListDonasiBarang.xml");
            int isi;
            char charnya;
            String stringnya;
            stringnya = "";
            while ((isi = input.read()) != -1){
                charnya = (char) isi;
                stringnya = stringnya + charnya;
            }
            donasiBarang = (ArrayList<ModelBarang>) xST.fromXML(stringnya);
        }
        catch (Exception e){
            System.err.println("test: " + e.getMessage());
        }
        finally {
            if (input != null){
                try{
                    input.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
    }
}
    
    @FXML
    private BorderPane mainPane;

    @FXML
    private TableView tabelbarang;

    @FXML
    private TableColumn kolomnama;

    @FXML
    private TableColumn kolomalamat;

    @FXML
    private TableColumn kolombarang;

    @FXML
    private TableColumn kolomnomor;

    @FXML
    private TextField txthapus;
    
    @FXML
    private void handlehapus(ActionEvent event){
        int texthapus = Integer.parseInt(txthapus.getText());
        int x = texthapus -1;
        datadonbarang.remove(x);
        txthapus.setText("");
    }

     @FXML
    private void kembali(ActionEvent event){
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("LihatDonasi");
        mainPane.setCenter(halaman);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bukaXML();
        for(int i =0; i < donasiBarang.size(); i++){
            ModelBarang data = (ModelBarang) donasiBarang.get(i);
            
            String nama = data.getNama();
            String  alamat = data.getAlamat();
            String barang = data.getBarang();
            String nomor = data.getNomor();

            datadonbarang.add(new ModelBarang(nama, alamat, barang, nomor));

        }

        
        kolomnama.setCellValueFactory(new PropertyValueFactory<TugasBesar.ModelJadwal, String>("nama"));
        kolomalamat.setCellValueFactory(new PropertyValueFactory<TugasBesar.ModelJadwal, String>("alamat"));
        kolomnomor.setCellValueFactory(new PropertyValueFactory<TugasBesar.ModelJadwal, String>("nomor"));
        kolombarang.setCellValueFactory(new PropertyValueFactory<TugasBesar.ModelJadwal, String>("barang"));

        tabelbarang.setItems(datadonbarang);

    }
}
