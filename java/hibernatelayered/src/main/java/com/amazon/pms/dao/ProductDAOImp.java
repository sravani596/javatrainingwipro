package com.amazon.pms.dao;
import com.amazon.pms.pojo.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class ProductDAOImp implements IProductDAO {

     SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
     Session session = sessionFactory.openSession();

     @Override
     public int addProduct(Product prd) {
    	 Transaction transaction = session.beginTransaction();
    	 
    	 //it returns serializable
         Serializable ser = session.save(prd);
         
         // Converting the Serializable's string representation to an int
         
         int id = Integer.parseInt(ser.toString());
         transaction.commit();
         return id;
     }


    @Override
    public int updateProduct(Product prd) {
        Transaction transaction = session.beginTransaction();
        session.update(prd);
        transaction.commit();
        return 1; // Indicate success (or you could return the number of rows affected)
    }

    @Override
    public int deleteProductById(int pid) {
        Transaction transaction = session.beginTransaction();
        Product prd = session.find(Product.class, pid);
        int result = 0;
        if (prd != null) {
            session.delete(prd);
            result = 1; // Indicate success
        }
        transaction.commit();
        return result; // Return 1 if deleted, 0 if not found
    }

    @Override
    public Product getProductById(int pid) {
        return session.find(Product.class, pid);
    }
    
    	//HQL QUERY
    @Override
    public List<Product> getAllProducts() {
        Query<Product> query = session.createQuery("FROM Product", Product.class);
        return query.getResultList();
    }
  //HQL QUERY
    @Override
    public List<Product> getProductsByPurchaseDate(LocalDate date) {
        Query<Product> query = session.createQuery("FROM Product WHERE purchaseDate = :date", Product.class);
        query.setParameter("date", date);
        return query.getResultList();
    }

    public void closeSession() {
        if (session != null && session.isOpen()) {
            session.close(); // Ensure to close the session when done
        }
    }
}
