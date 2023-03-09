package Presentation.Controllers;

import Service.CatalogueService;
import Service.CatalogueServiceImpl;
import dao.CategoryDaoImpl;
import dao.ProductDaoImpl;
import dao.entities.Category;
import dao.entities.Product;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    @FXML private TextField textSearch;
    private CatalogueService catalogueService;
    ObservableList<Product> data = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listViewProt.setItems(data);
        catalogueService = new CatalogueServiceImpl(new ProductDaoImpl(),new CategoryDaoImpl());
        loadData();
        textSearch.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                data.clear();
                data.addAll(catalogueService.searchProductByQuery(newValue));

            }
        });
    }
    private void loadData(){
        data.clear();
        data.addAll(catalogueService.getAllProduct());
        ComboCategory.getItems().addAll(catalogueService.getAllCategory());
    }

    public void addProduct(){
        Product product = new Product();
        product.setName(TextNom.getText());
        product.setReference(TextRef.getText());
        product.setPrix(Float.parseFloat(TextPrix.getText()));
        product.setCategory(ComboCategory.getSelectionModel().getSelectedItem());
        catalogueService.addProduct(product);
        loadData();
    }

    public void deleteProduct(){
        Product product = listViewProt.getSelectionModel().getSelectedItem();
        catalogueService.deleteProduct(product);
        loadData();
    }

}
