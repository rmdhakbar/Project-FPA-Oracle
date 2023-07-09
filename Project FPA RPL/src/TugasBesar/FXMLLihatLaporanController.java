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

public class FXMLLihatLaporanController implements Initializable {
    ArrayList<ModelLaporan> laporan = new ArrayList<>();
    XStream xST = new XStream(new StaxDriver());

    ObservableList datalaporan = observableArrayList();

    void bukaXML(){
        FileInputStream input = null;
        xST.addPermission(AnyTypePermission.ANY);
        xST.allowTypesByWildcard(new String[]{"TugasBesar.ModelLaporan"});
        try {
            input = new FileInputStream("ListLaporan.xml");
            int isi;
            char charnya;
            String stringnya;
            stringnya = "";
            while ((isi = input.read()) != -1){
                charnya = (char) isi;
                stringnya = stringnya + charnya;
            }
            laporan = (ArrayList<ModelLaporan>) xST.fromXML(stringnya);
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
    private TableView tabellaporan;

    @FXML
    private TableColumn kolomnama;

    @FXML
    private TableColumn kolomtempat;

    @FXML
    private TableColumn kolomwaktu;

    @FXML
    private TableColumn kolomisi;

    @FXML
    private TableColumn kolomkritik;

    @FXML
    private TextField txthapus;
    
    @FXML
    private void handlehapus(ActionEvent event){
        int texthapus = Integer.parseInt(txthapus.getText());
        int x = texthapus -1;
        datalaporan.remove(x);
        txthapus.setText("");
    }

     @FXML
    private void kembali(ActionEvent event){
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("laporan1");
        mainPane.setCenter(halaman);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bukaXML();
        for(int i =0; i < laporan.size(); i++){
            ModelLaporan data = (ModelLaporan) laporan.get(i);
            
            String nama = data.getNama();
            String tempat = data.getTempat();
            String waktu = data.getWaktu();
            String isi = data.getIsi();
            String kritik = data.getKritik();

            datalaporan.add(new ModelLaporan(nama, tempat, waktu, isi, kritik));
        }

        
        kolomnama.setCellValueFactory(new PropertyValueFactory<TugasBesar.ModelJadwal, String>("nama"));
        kolomtempat.setCellValueFactory(new PropertyValueFactory<TugasBesar.ModelJadwal, String>("tempat"));
        kolomwaktu.setCellValueFactory(new PropertyValueFactory<TugasBesar.ModelJadwal, String>("waktu"));
        kolomisi.setCellValueFactory(new PropertyValueFactory<TugasBesar.ModelJadwal, String>("isi"));
        kolomkritik.setCellValueFactory(new PropertyValueFactory<TugasBesar.ModelJadwal, String>("kritik"));

        tabellaporan.setItems(datalaporan);

    }
}
