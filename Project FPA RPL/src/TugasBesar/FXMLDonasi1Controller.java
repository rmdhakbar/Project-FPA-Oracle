package TugasBesar;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class FXMLDonasi1Controller implements Initializable {
    @FXML
    private BorderPane mainPane;
    
     @FXML
    private void keHalamanPilihDOnasi(ActionEvent event){
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("PilihDonasi");
        mainPane.setCenter(halaman);
    }

      @FXML
    private void keHalamanLihatDonasi(ActionEvent event){
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("LihatDonasi");
        mainPane.setCenter(halaman);
        
    }

     

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
