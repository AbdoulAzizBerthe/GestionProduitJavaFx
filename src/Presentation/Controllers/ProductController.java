package Presentation.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductController implements Initializable {

    @FXML
    private TextField TextNom;
    @FXML private TextField TextRef;
    @FXML private TextField TextPrix;
    @FXML private ComboBox ComboCategory;
    @FXML private ListView listViewProt ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
