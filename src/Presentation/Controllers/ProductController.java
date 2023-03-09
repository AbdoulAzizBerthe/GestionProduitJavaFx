package Presentation.Controllers;

import Service.CatalogueService;
import Service.CatalogueServiceImpl;
import dao.CategoryDaoImpl;
import dao.ProductDaoImpl;
import dao.entities.Category;
import dao.entities.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ProductController implements Initializable {

    @FXML
    private TextField TextNom;
    @FXML private TextField TextRef;
    @FXML private TextField TextPrix;
    @FXML private ComboBox<Category> ComboCategory;
    @FXML private ListView<Product> listViewProt ;
    private CatalogueService catalogueService;
    ObservableList<Product> data = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listViewProt.setItems(data);
        catalogueService = new CatalogueServiceImpl(new ProductDaoImpl(),new CategoryDaoImpl());
        loadData();
    }
    private void loadData(){
        data.addAll(catalogueService.getAllProduct());
        ComboCategory.getItems().addAll(catalogueService.getAllCategory());
    }
}
