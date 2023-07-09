package TugasBesar;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.w3c.dom.ls.LSException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class FXMLLogoutController implements Initializable {
    ArrayList<ModelAkun> akun = new ArrayList<>();
    XStream xST = new XStream(new StaxDriver());

     @FXML
    private Label Lusername;

    @FXML
    private Label Lnomor;

    @FXML
    private Label Lalamat;

    @FXML
    private Label Lemail;


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
    private void handleLogout(ActionEvent event){
        for(int i =0; i < akun.size(); i++){
            ModelAkun data = (ModelAkun) akun.get(i);
            if(Lusername.getText()==data.getUsername()){
                data.setpilih(false);
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
                Lalamat.setText("");
                Lusername.setText("");
                Lnomor.setText("");
                Lemail.setText("");
                OpenScene object = new OpenScene();
                Pane halaman = object.getPane("Login");
                mainPane.setCenter(halaman);
                mainPane.setTop(null);
            }
        }
      
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bukaXML();
        for(int i =0; i < akun.size(); i++){
            ModelAkun data = (ModelAkun) akun.get(i);
            if(data.getpilih()==true){
                Lusername.setText(data.getUsername());
                Lnomor.setText(data.getNohp());
                Lalamat.setText(data.getAlamat());
                Lemail.setText(data.getEmail());
            }
        }
    }
}
