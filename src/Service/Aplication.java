package Service;

import dao.CategoryDaoImpl;
import dao.ProductDaoImpl;
import dao.entities.Product;

public class Aplication {
    public static void main(String[] args) {
        CatalogueService catalogueService = new CatalogueServiceImpl(new ProductDaoImpl(),new CategoryDaoImpl());
        Product p1 = new Product();
        p1.setName("HP");
        p1.setReference("REF001");
        p1.setPrix(13000);
        catalogueService.addProduct(p1);
    }
}
