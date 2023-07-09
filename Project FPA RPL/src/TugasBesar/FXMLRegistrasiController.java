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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class FXMLRegistrasiController implements Initializable {
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
    private TextField Nama;

    @FXML
    private TextField Alamat;

    @FXML
    private TextField Nohp;

    @FXML
    private TextField Email;

    @FXML
    private TextField Username;

    @FXML
    private PasswordField Password;

     @FXML
    private void keHalamanTerimakasih(ActionEvent event){
        boolean cekemail = false;
        if(Nama.getText()=="" ||Alamat.getText()==""||Nohp.getText()==""||Email.getText()==""||Password.getText()==""||Username.getText()=="" ){
            Alert alert = new Alert(AlertType.ERROR, "Data Harus Diisi Secara Lengkap");
            alert.showAndWait();
        }
        else{
            for(int i =0; i<akun.size();i++){
                ModelAkun data = (ModelAkun) akun.get(i);
                if(data.getEmail().equals(Email.getText())){
                    Alert alert = new Alert(AlertType.ERROR,"Email Sudah Tersedia");
                    cekemail = true;
                    break;
                }

            }
            if(!cekemail){
                akun.add(new ModelAkun(Nama.getText(), Alamat.getText(), Nohp.getText(), Email.getText(), Username.getText(), Password.getText(), false));

            String xml = xST.toXML(akun);
                        FileOutputStream output = null;
                        try{
                            output = new FileOutputStream("DaftarAkunPengguna.xml");
                            byte[] bytes = xml.getBytes("UTF-8");
                            output.write(bytes);
                            OpenScene object = new OpenScene();
                            Pane halaman = object.getPane("RegistrasiBerhasil");
                            mainPane.setCenter(halaman);
                            mainPane.requestFocus();
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
            }
        }
                
    }
    @FXML
    private void keHalamanLogin(ActionEvent event){
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("Login");
        mainPane.setCenter(halaman);
        
    }

      


    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bukaXML();
    }    
}
