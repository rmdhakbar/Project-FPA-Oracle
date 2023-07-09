package TugasBesar;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class FXMLPilihDonasiController implements Initializable {
     @FXML
    private BorderPane mainPane;
    
     @FXML
    private void keHalamanBarang(ActionEvent event){
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("DonasiBarang");
        mainPane.setCenter(halaman);
    }

      @FXML
    private void keHalamanUang(ActionEvent event){
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("DonasiUang");
        mainPane.setCenter(halaman);
    }

     @FXML
    private void keHalamanKembali(ActionEvent event){
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("Donasi1");
        mainPane.setCenter(halaman);
    }


    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
