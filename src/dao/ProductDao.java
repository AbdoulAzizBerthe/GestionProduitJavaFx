package dao;

import dao.entities.Product;

import java.util.List;

public interface ProductDao extends Dao<Product>{
    List<Product> findbyQuery(String query);


}
