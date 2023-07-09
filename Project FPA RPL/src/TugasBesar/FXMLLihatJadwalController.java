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

public class FXMLLihatJadwalController implements Initializable {
    ArrayList<ModelJadwal> jadwal = new ArrayList<>();
    XStream xST = new XStream(new StaxDriver());

    ObservableList datajadwal = observableArrayList();

    void bukaXML(){
        FileInputStream input = null;
        xST.addPermission(AnyTypePermission.ANY);
        xST.allowTypesByWildcard(new String[]{"TugasBesar.ModelJadwal"});
        try {
            input = new FileInputStream("DaftarJadwal.xml");
            int isi;
            char charnya;
            String stringnya;
            stringnya = "";
            while ((isi = input.read()) != -1){
                charnya = (char) isi;
                stringnya = stringnya + charnya;
            }
            jadwal = (ArrayList<ModelJadwal>) xST.fromXML(stringnya);
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
    private TableView tabeljadwal;

    @FXML
    private TableColumn kolomnama;

    @FXML
    private TableColumn kolomtempat;

    @FXML
    private TableColumn kolomwaktu;

    @FXML
    private TableColumn kolombarang;

    @FXML
    private Button hapus;

    @FXML
    private TextField txthapus;
    
    @FXML
    private void handlehapus(ActionEvent event){
        int texthapus = Integer.parseInt(txthapus.getText());
        int x = texthapus -1;
        datajadwal.remove(x);
        txthapus.setText("");
    }

     @FXML
    private void kembali(ActionEvent event){
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("Jadwal1");
        mainPane.setCenter(halaman);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bukaXML();
        for(int i =0; i < jadwal.size(); i++){
            ModelJadwal data = (ModelJadwal) jadwal.get(i);
            
            String nama =data.getNama();
            String tempat = data.getTempat();
            String waktu = data.getWaktu();
            String barang = data.getBarang();

            datajadwal.add(new ModelJadwal(nama, tempat, waktu, barang));

        }

        
        kolomnama.setCellValueFactory(new PropertyValueFactory<TugasBesar.ModelJadwal, String>("nama"));
        kolomtempat.setCellValueFactory(new PropertyValueFactory<TugasBesar.ModelJadwal, String>("tempat"));
        kolomwaktu.setCellValueFactory(new PropertyValueFactory<TugasBesar.ModelJadwal, String>("waktu"));
        kolombarang.setCellValueFactory(new PropertyValueFactory<TugasBesar.ModelJadwal, String>("barang"));

        tabeljadwal.setItems(datajadwal);

    }
}
