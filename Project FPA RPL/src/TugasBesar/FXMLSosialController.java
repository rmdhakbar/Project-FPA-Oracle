package TugasBesar;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class FXMLSosialController implements Initializable {

     @FXML
    private BorderPane mainPane;
    
     @FXML
    private void keHalamanDokumentasi(ActionEvent event){
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("UploadDok");
        mainPane.setCenter(halaman);
    }

      @FXML
    private void keHalamanBerita(ActionEvent event){
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("UploadBerita");
        mainPane.setCenter(halaman);
    }

     @FXML
    private void keHalamanutama(ActionEvent event){
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("HalamanUtama");
        mainPane.setCenter(halaman);
        mainPane.setTop(null);
        
    }


    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
