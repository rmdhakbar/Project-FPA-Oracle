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

public class FXMLDonasiBarangController implements Initializable {
    ArrayList<ModelBarang> donasiBarang = new ArrayList<>();
    XStream xST = new XStream(new StaxDriver());

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
    private TextField txtnama;

    @FXML
    private TextField txtalamat;

    @FXML
    private TextField txtbarang;

    @FXML
    private TextField txtnomor;
      
     @FXML
    private void keHalamanTerimakasih(ActionEvent event){
        donasiBarang.add(new ModelBarang(txtnama.getText(), txtalamat.getText(), txtbarang.getText(), txtnomor.getText()));

        String xml = xST.toXML(donasiBarang);
                        FileOutputStream output = null;
                        try{
                            output = new FileOutputStream("ListDonasiBarang.xml");
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

        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("TerimakasihDonasi");
        mainPane.setCenter(halaman);
    }

      @FXML
    private void keHalamanKembali(ActionEvent event){
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("PilihDonasi");
        mainPane.setCenter(halaman);
        
    }

     

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bukaXML();
    }
}
