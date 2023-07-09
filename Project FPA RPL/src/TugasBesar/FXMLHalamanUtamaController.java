/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TugasBesar;

import java.net.URI;
import java.net.URISyntaxException;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import java.awt.Desktop;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author andhika
 */
public class FXMLHalamanUtamaController implements Initializable {

    @FXML
    private BorderPane mainPane;

   
    

    @FXML
    private void keHalamanLogin(ActionEvent event){
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("Login");
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
    private void keHalamanPilihDonasi(ActionEvent event){
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("Donasi1");
        mainPane.setCenter(halaman);
    }

     @FXML
    private void keHalamanBerita1(ActionEvent event) throws URISyntaxException, IOException{
        Desktop.getDesktop().browse(new URI("https://www.bbc.com/indonesia/articles/c3gpeyyg8vlo"));
    }

     @FXML
    private void keHalamanBerita2(ActionEvent event) throws URISyntaxException, IOException{
        Desktop.getDesktop().browse(new URI("https://www.bbc.com/indonesia/articles/cpr1pnl1gqxo"));
    }

     @FXML
    private void keHalamanBerita3(ActionEvent event) throws URISyntaxException, IOException{
        Desktop.getDesktop().browse(new URI("https://www.bbc.com/indonesia/articles/c84m1jw4x30o"));
    }

     @FXML
    private void keHalamanBerita4(ActionEvent event) throws URISyntaxException, IOException{
        Desktop.getDesktop().browse(new URI("https://www.bbc.com/indonesia/articles/cpd03ezmv4vo"));
    }

     @FXML
    private void keHalamanBerita5(ActionEvent event) throws URISyntaxException, IOException{
        Desktop.getDesktop().browse(new URI("https://lestari.kompas.com/read/2023/06/06/091258786/peringati-hari-lingkungan-hidup-sedunia-masyarakat-bintan-tanam-mangrove?page=all"));
    }

     @FXML
    private void keHalamanBerita6(ActionEvent event) throws URISyntaxException, IOException{
        Desktop.getDesktop().browse(new URI("https://lestari.kompas.com/read/2023/06/12/210133586/iriana-ajak-masyarakat-kelola-sampah-organik-jadi-kompos?page=all"));
    }

    @FXML
    private void keHalamanLaporan(ActionEvent event){
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("laporan1");
        mainPane.setCenter(halaman);
    }

    @FXML
    private void keHalamanSosial(ActionEvent event){
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("Sosial1");
        mainPane.setCenter(halaman);
    }

    @FXML
    private void keHalamanJadwal(ActionEvent event){
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("Jadwal1");
        mainPane.setCenter(halaman);
    }

    @FXML
    private void keHalamanAkun(ActionEvent event){
        
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("Logout");
        mainPane.setCenter(halaman);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    
    
}

