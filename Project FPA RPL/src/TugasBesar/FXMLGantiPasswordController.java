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

public class FXMLGantiPasswordController implements Initializable {
    ArrayList<ModelAkun> akun = new ArrayList<>();
    XStream xST = new XStream(new StaxDriver());

    void bukaXML(){
        FileInputStream input = null;
        xST.addPermission(AnyTypePermission.ANY);
        xST.allowTypesByWildcard(new String[]{"TugasBesar.ModelAkun"});
        try {
            input = new FileInputStream("DaftarAkunPengguna.xml");
            int isi;
            char charnya;
            String stringnya;
            stringnya = "";
            while ((isi = input.read()) != -1){
                charnya = (char) isi;
                stringnya = stringnya + charnya;
            }
            akun = (ArrayList<ModelAkun>) xST.fromXML(stringnya);
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
    private TextField txtemail;

    @FXML
    private TextField txtpassword;

    @FXML
    private void handlesimpan(ActionEvent event){
        for(int i =0; i < akun.size(); i++){
            ModelAkun data = (ModelAkun) akun.get(i);
            if(txtemail.getText().equals(data.getEmail())){
                data.setPassword(txtpassword.getText());
                 String xml = xST.toXML(akun);
                        FileOutputStream output = null;
                        try{
                            output = new FileOutputStream("DaftarAkunPengguna.xml");
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
                Pane halaman = object.getPane("Login");
                mainPane.setCenter(halaman);
                
                
            }
        }
    }

    @FXML
    private void handlekembali(ActionEvent event){
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("Login");
        mainPane.setCenter(halaman);
        mainPane.setTop(null);
    }


    
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bukaXML();
    }
}
