package Service;

import dao.CategoryDaoImpl;
import dao.ProductDaoImpl;
import dao.entities.Category;
import dao.entities.Product;

import java.util.List;

public class Aplication {
    public static void main(String[] args) {
        CatalogueService catalogueService = new CatalogueServiceImpl(new ProductDaoImpl(),new CategoryDaoImpl());
        Category c1 = new Category();
        c1.setName("Gaming");
        c1.setId(1);
        Product p1 = new Product();
        p1.setName("MSI");
        p1.setReference("REF0002");
        p1.setPrix(23000);
        p1.setCategory(c1);
//        catalogueService.addProduct(p1);
        List<Product> products = catalogueService.getAllProduct();

        for (Product product: products){
            System.out.println("ID: "+ product.getId()+ " Name: "+product.getName()+" Prix: "+product.getPrix());
        }
    }
}
