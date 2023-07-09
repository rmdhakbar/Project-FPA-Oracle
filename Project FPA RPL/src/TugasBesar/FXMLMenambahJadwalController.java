package TugasBesar;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class FXMLMenambahJadwalController implements Initializable {
    ArrayList<ModelJadwal> jadwal = new ArrayList<>();
    XStream xST = new XStream(new StaxDriver());

    void bukaXML(){
        FileInputStream input = null;
        xST.addPermission(AnyTypePermission.ANY);
        xST.allowTypesByWildcard(new String[]{"Menambahjadwal.ModelJadwal"});
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
    private TextField nama;

    @FXML
    private TextField tempat;

    @FXML
    private TextField waktu;

    @FXML
    private TextField barang;


    @FXML
    private void simpan(ActionEvent event){
        if(jadwal != null){
             jadwal.add(new ModelJadwal(nama.getText(), tempat.getText(), waktu.getText(), barang.getText()));
        String xml = xST.toXML(jadwal);
                        FileOutputStream output = null;
                        try{
                            output = new FileOutputStream("DaftarJadwal.xml");
                            byte[] bytes = xml.getBytes("UTF-8");
                            output.write(bytes);
                        }
                        catch (Exception e){
                            System.err.println("Perhatian: " + e.getMessage());
                        }
                        finally {
                            if (output != null){
                                try {
                                    output.close();
                                }
                                catch (IOException e){
                                    e.printStackTrace();
                                }
                            }
                        }
                        nama.setText("");
                        tempat.setText("");
                        waktu.setText("");
                        barang.setText("");
        }
       
         
    }

     @FXML
    private void keHalamanKembali(ActionEvent event){
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("Jadwal1");
        mainPane.setCenter(halaman);
    }

    



    
    @Override
    public void initialize(URL url, ResourceBundle rb) {   
        bukaXML(); 
    } 
  
}