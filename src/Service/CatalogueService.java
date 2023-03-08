package Service;

import dao.entities.Category;
import dao.entities.Product;

import java.util.List;

public interface CatalogueService {
    List<Product> getAllProduct();
    void addProduct(Product p);
    void updateProduct(Product p);
    void deleteProduct(Product p);
    List<Category> getAllCategory ();
    void addCategory(Category c);
    void deleteCategory(Category c);
}
