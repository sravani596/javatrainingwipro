package com.amazon.pms.dao;

import com.amazon.pms.pojo.Product;
import com.amazon.springhibernate.util.DButil;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImp implements IProductDAO {

    // Assuming DButil is a utility class that manages database connections
    private Connection conn = DButil.getDBConnection();

    @Override
    public int addProduct(Product prd) {
    	
        String insertQuery = "INSERT INTO Products (product_id, name, price, purchase_date) VALUES (?, ?, ?, ?)";
        int count = 0;
        
        try  {
        	PreparedStatement pstmt = conn.prepareStatement(insertQuery);
        	
            pstmt.setInt(1, prd.getPid());  // Assuming pid is an int. If varchar, use setString.
            pstmt.setString(2, prd.getPname());
            pstmt.setDouble(3, prd.getPrice());
            pstmt.setDate(4, Date.valueOf(prd.getPurchaseDate()));

            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int updateProduct(Product prd) {
        String query = "UPDATE Products SET name = ?, price = ?, purchase_date = ? WHERE product_id = ?";
        int count = 0;
        try  {
        	PreparedStatement stmt = conn.prepareStatement(query);
        	
            stmt.setString(1, prd.getPname());
            stmt.setDouble(2, prd.getPrice());
            stmt.setDate(3, Date.valueOf(prd.getPurchaseDate()));
            stmt.setInt(4, prd.getPid());  // Assuming pid is an int. If varchar, use setString.

            
            count = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int deleteProductById(int pid) {
        String deleteQuery = "DELETE FROM Products WHERE product_id = ?";
        int count = 0;
        try  {
        	PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
            pstmt.setInt(1, pid);  // Assuming pid is an int. If varchar, use setString.
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public Product getProductById(int pid) {
    	
        String selectQueryById = "SELECT * FROM Products WHERE product_id = ?";
        Product prd = null;
        try  {
        	PreparedStatement stmt = conn.prepareStatement(selectQueryById);
            stmt.setInt(1, pid);  // Assuming pid is an int. If varchar, use setString.
            ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                   
                    prd = new Product(rs.getInt("product_id"),rs.getString("name"),rs.getDouble("price"),rs.getDate("purchase_date").toLocalDate());
                    
                }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prd;
    }

    @Override
    public List<Product> getAllProducts() {
    	
        List<Product> list = new ArrayList<>();
        
        Product prd = null;
        try  {
        	String selectQuery = "SELECT * FROM Products";
        	PreparedStatement pstmt = conn.prepareStatement(selectQuery);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                

                 prd = new Product(rs.getInt("product_id"),rs.getString("name"),rs.getDouble("price"),rs.getDate("purchase_date").toLocalDate());
                list.add(prd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> getProductsByPurchaseDate(LocalDate date) {
        
        String query = "SELECT * FROM Products WHERE purchase_date = ?";
        List<Product> list = new ArrayList<>();
        
        Product prd = null;

        try  {
        	PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setDate(1, Date.valueOf(date));
            ResultSet rs = stmt.executeQuery(); 

                while (rs.next()) {
                    
                     prd = new Product(rs.getInt("product_id"),rs.getString("name"),rs.getDouble("price"),rs.getDate("purchase_date").toLocalDate());
                   list.add(prd);
                }
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
/*package com.amazon.pms.dao;

import com.amazon.pms.pojo.Product;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImp implements IProductDAO {

    private Connection conn = DButil.getDBConnection();

    @Override
    public int addProduct(Product prd) {
        String insertQuery = "INSERT INTO Products (product_id, name, price, purchase_date) VALUES (?, ?, ?, ?)";
        int count = 0;
        try {
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
            pstmt.setInt(1, prd.getPid());
            pstmt.setString(2, prd.getPname());
            pstmt.setDouble(3, prd.getPrice());
            pstmt.setDate(4, Date.valueOf(prd.getPurchaseDate()));
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int updateProduct(Product prd) {
        String query = "UPDATE Products SET name = ?, price = ?, purchase_date = ? WHERE product_id = ?";
        int count = 0;
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, prd.getPname());
            stmt.setDouble(2, prd.getPrice());
            stmt.setDate(3, Date.valueOf(prd.getPurchaseDate()));
            stmt.setInt(4, prd.getPid());
            count = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int deleteProductById(int pid) {
        String deleteQuery = "DELETE FROM Products WHERE product_id = ?";
        int count = 0;
        try {
            PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
            pstmt.setInt(1, pid);
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public Product getProductById(int pid) {
        String selectQueryById = "SELECT * FROM Products WHERE product_id = ?";
        Product prd = null;
        try {
            PreparedStatement stmt = conn.prepareStatement(selectQueryById);
            stmt.setInt(1, pid);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                prd = new Product(
                    rs.getInt("product_id"),
                    rs.getString("name"),
                    rs.getDouble("price"),
                    rs.getDate("purchase_date").toLocalDate()
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prd;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        try {
            String selectQuery = "SELECT * FROM Products";
            PreparedStatement pstmt = conn.prepareStatement(selectQuery);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Product prd = new Product(
                    rs.getInt("product_id"),
                    rs.getString("name"),
                    rs.getDouble("price"),
                    rs.getDate("purchase_date").toLocalDate()
                );
                list.add(prd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> getProductsByPurchaseDate(LocalDate date) {
        String query = "SELECT * FROM Products WHERE purchase_date = ?";
        List<Product> list = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setDate(1, Date.valueOf(date));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Product prd = new Product(
                    rs.getInt("product_id"),
                    rs.getString("name"),
                    rs.getDouble("price"),
                    rs.getDate("purchase_date").toLocalDate()
                );
                list.add(prd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}*/


