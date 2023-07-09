package TugasBesar;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class FXMLLaporan1Controller implements Initializable {
    @FXML
    private BorderPane mainPane;
    
     @FXML
    private void keHalamanBuatLaporan(ActionEvent event){
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("MenambahLaporan");
        mainPane.setCenter(halaman);
    }

      @FXML
    private void keHalamanLihatLaporan(ActionEvent event){
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("LihatLaporan");
        mainPane.setCenter(halaman);
        
    }

     

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
