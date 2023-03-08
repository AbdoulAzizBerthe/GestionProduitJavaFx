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
        Connection connection = ConnexionDBSingleton.getConnection();
        Product p = new Product();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product where ID=?");
            preparedStatement.setLong(1,id);
            ResultSet resultSet= preparedStatement.executeQuery();
            if(resultSet.next()){
                p.setId(resultSet.getLong("ID"));
                p.setName(resultSet.getString("NAME"));
                p.setReference(resultSet.getString("REFERENCE"));
                p.setPrix(resultSet.getFloat("PRIX"));

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return p;
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
            PreparedStatement pstm = connection.prepareStatement("insert into product (NAME, REFERENCE,PRIX,ID_CAT) values (?,?,?,?)");
            pstm.setString(1,o.getName());
            pstm.setString(2,o.getReference());
            pstm.setFloat(3,o.getPrix());
            pstm.setLong(4,o.getCategory().getId());
            pstm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);}
    }

    @Override
    public void delete(Product o) {
        Connection connection = ConnexionDBSingleton.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from product where ID=?");
            preparedStatement.setLong(1,o.getId());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product o) {
        Connection connection = ConnexionDBSingleton.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update product set NAME=?,REFERENCE=?,PRIX=? where ID=?");
            preparedStatement.setString(1,o.getName());
            preparedStatement.setString(2,o.getReference());
            preparedStatement.setFloat(3,o.getPrix());
            preparedStatement.setLong(4,o.getId());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findbyQuery(String query) {
        List<Product> products = new ArrayList<>();
        Connection connection = ConnexionDBSingleton.getConnection();
        try {
            PreparedStatement pstm = connection.prepareStatement("select * from product where NAME like ? or REFERENCE like ? or PRIX like ?");
            pstm.setString(1,"%"+query+"%");
            pstm.setString(1,"%"+query+"%");
            pstm.setString(1,"%"+query+"%");
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
}
