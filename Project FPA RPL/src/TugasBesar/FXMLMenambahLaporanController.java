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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class FXMLMenambahLaporanController implements Initializable {
    ArrayList<ModelLaporan> laporan = new ArrayList<>();
    XStream xST = new XStream(new StaxDriver());

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
    private TextField txtnama;

    @FXML
    private TextField txttempat;
    
    @FXML
    private TextField txtwaktu;

    @FXML
    private TextField txtisi;

    @FXML
    private TextField txtkritik;

     @FXML
    private void HandleSimpan(ActionEvent event){
        laporan.add(new ModelLaporan(txtnama.getText(), txttempat.getText(), txtwaktu.getText(), txtisi.getText(), txtkritik.getText()));

        String xml = xST.toXML(laporan);
                        FileOutputStream output = null;
                        try{
                            output = new FileOutputStream("ListLaporan.xml");
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

        txtisi.setText("");
        txtnama.setText("");
        txtwaktu.setText("");
        txttempat.setText("");
        txtkritik.setText("");
    }

      @FXML
    private void keHalamanKembali(ActionEvent event){
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("Laporan1");
        mainPane.setCenter(halaman);
    }

     


    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bukaXML();
    }    
}
