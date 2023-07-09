package TugasBesar;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class FXMLJadwal1Controller implements Initializable {
    @FXML
    private BorderPane mainPane;
    
     @FXML
    private void keHalamanBuatJadwal(ActionEvent event){
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("MenambahJadwal");
        mainPane.setCenter(halaman);
    }

      @FXML
    private void keHalamanLihatJadwal(ActionEvent event){
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("LihatJadwal");
        mainPane.setCenter(halaman);
        
    }

     

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
