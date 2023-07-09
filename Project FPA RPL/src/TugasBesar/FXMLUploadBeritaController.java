package TugasBesar;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.net.URL;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class FXMLUploadBeritaController implements Initializable {

    ArrayList<ModelUploadBerita> berita = new ArrayList<>();
    XStream xST = new XStream(new StaxDriver());
    void bukaXML(){
        FileInputStream input = null;
        xST.addPermission(AnyTypePermission.ANY);
        xST.allowTypesByWildcard(new String[] {"UploadBerita.ModelUploadBerita"});
        try {
            input = new FileInputStream("listBerita.xml");
            int isi;
            char charnya;
            String stringnya;
            stringnya = "";
            while ((isi = input.read()) != -1){
                charnya = (char) isi;
                stringnya = stringnya + charnya;
            }
            berita = (ArrayList<ModelUploadBerita>) xST.fromXML(stringnya);
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
    private TextField judul;

    @FXML
    private TextField isi;

    @FXML
    private void simpan (ActionEvent event) {
        berita.add(new ModelUploadBerita(judul.getText(),isi.getText()));
        String xml = xST.toXML(berita);
                        FileOutputStream output = null;
                        try{
                            output = new FileOutputStream("listBerita.xml");
                            byte[] bytes = xml.getBytes("UTF-8");
                            output.write(bytes);
                            // OpenScene object = new OpenScene();
                            // Pane halaman = object.getPane("FXMLMain");
                            // mainPane.setCenter(halaman);
                            // mainPane.requestFocus();
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
                        judul.setText("");
                        isi.setText("");
    }

   @Override
   public void initialize(URL url, ResourceBundle rb) {
    bukaXML();
   }


        
   }


    
