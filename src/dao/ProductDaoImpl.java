package dao;

import dao.entities.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public Product find(long id) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        //mapping objet relationnel
        List<Product> products = new ArrayList<>();
        Connection connection = ConnexionDBSingleton.getConnection();
        try {
            PreparedStatement pstm = connection.prepareStatement("select * from product");
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()){
                Product p = new Product();
                p.setId(resultSet.getLong("ID"));
                p.setName(resultSet.getString("NAME"));
                p.setReference(resultSet.getString("REFERENCE"));
                p.setPrix(resultSet.getFloat("PRIX"));
                products.add(p);
//                p.setCategory();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public void save(Product o) {
        Connection connection = ConnexionDBSingleton.getConnection();
        try {
            PreparedStatement pstm = connection.prepareStatement("insert into product (NAME, REFERENCE,PRIX) values (?,?,?)");
            pstm.setString(1,o.getName());
            pstm.setString(2,o.getReference());
            pstm.setFloat(3,o.getPrix());
            pstm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Product o) {

    }

    @Override
    public void update(Product o) {

    }

    @Override
    public List<Product> findbyQuery(String query) {
        return null;
    }
}
