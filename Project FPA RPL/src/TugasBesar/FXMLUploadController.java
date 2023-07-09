package TugasBesar;

import java.io.File;
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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class FXMLUploadController implements Initializable {
     ArrayList<ModelUploadFoto> foto = new ArrayList<>();
    XStream xST = new XStream(new StaxDriver());
    void bukaXML(){
        FileInputStream input = null;
        xST.addPermission(AnyTypePermission.ANY);
        xST.allowTypesByWildcard(new String[] {"TugasBesar.ModelUploadFoto"});
        try {
            input = new FileInputStream("listFoto.xml");
            int isi;
            char charnya;
            String stringnya;
            stringnya = "";
            while ((isi = input.read()) != -1){
                charnya = (char) isi;
                stringnya = stringnya + charnya;
            }
            foto = (ArrayList<ModelUploadFoto>) xST.fromXML(stringnya);
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
    private ImageView imageview;

    @FXML
    private TextField descriptionTextField;

    @FXML
    private void selectPhohotosButtonAction (ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("SELECT YOUR PHOTOS!");
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );

        Stage stage = (Stage) mainPane.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null ) {
            Image image = new Image(selectedFile.toURI().toString());
            imageview.setImage(image);
        }
    }

    @FXML
    private void uploadButtonAction (ActionEvent event) {
        foto.add(new ModelUploadFoto(descriptionTextField.getText()));
        String xml = xST.toXML(foto);
                        FileOutputStream output = null;
                        try{
                            output = new FileOutputStream("listFoto.xml");
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

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bukaXML();
        }
    }

