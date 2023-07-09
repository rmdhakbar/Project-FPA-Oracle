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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.control.TextArea;

public class FXMLLaporanController implements Initializable{
    @FXML
    private BorderPane mainPane;

    @FXML
    private void keHalamanLaporanKegiatan(ActionEvent event){
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("laporan2");
        mainPane.setCenter(halaman);
    } 
    
     @FXML
    private void keHalamanRincian(ActionEvent event){
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("laporan3");
        mainPane.setCenter(halaman);
    }

    @FXML
    private void keHalamanutama(ActionEvent event){
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("HalamanUtama");
        mainPane.setCenter(halaman);
        mainPane.setTop(null);
    }

    @FXML
    private void keHalamanawal(ActionEvent event){
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("laporan1");
        mainPane.setCenter(halaman);
        mainPane.setTop(null);
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
}