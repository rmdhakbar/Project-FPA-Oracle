package TugasBesar;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class FXMLLihatDonasiController implements Initializable {
    @FXML
    private BorderPane mainPane;
    
     @FXML
    private void keHalamanLihatUang(ActionEvent event){
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("LihatUang");
        mainPane.setCenter(halaman);
    }

      @FXML
    private void keHalamanLihatBarang(ActionEvent event){
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("LihatBarang");
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
