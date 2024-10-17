package com.amazon.pms.presentation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.amazon.pms.pojo.Product;
import com.amazon.pms.service.ProductServiceImp;

@Configuration
@ComponentScan(basePackages = "com.amazon.pms.*")
public class Customer {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        


		ApplicationContext container = 	new AnnotationConfigApplicationContext(Customer.class);
		
		
		ProductServiceImp service =			container.getBean(ProductServiceImp.class);
		
		
			
        
        boolean flag = true;

        System.out.println("******* WELCOME TO AMAZON PRODUCTS *******");

        while (flag) {

            System.out.println("1. ADD PRODUCTS");
            System.out.println("2. UPDATE PRODUCTS");
            System.out.println("3. DELETE  PRODUCTS BY ID");
            System.out.println("4. DISPLAY  PRODUCTS BY ID");
            System.out.println("5. DISPLAY  PRODUCTS BY PURCHASE DATE");
            System.out.println("6. DISPLAY ALL  PRODUCTS");
            System.out.println("7. EXIT ");

            int choice = sc.nextInt();
            //Product prd=null;
            switch (choice) {
                case 1:
                    Product prd1 = getProduct();
                    int count1 = service.addProduct(prd1);
                    if (count1 > 0) {
                        System.out.println("Products Added Successfully...");
                    } else {
                        System.err.println("Add Failed...");
                    }
                    break;

                case 2:
                    Product  prd2 = getProduct();
                    int count2 = service.updateProduct(prd2);
                    if (count2 > 0) {
                        System.out.println("Products Updated Successfully...");
                    } else {
                        System.err.println("Update Failed...");
                    }
                    break;

                case 3:
                    System.out.print("Enter Product ID to delete: ");
                    int delId = sc.nextInt();
                    int delCount = service.deleteProductById(delId);
                    if (delCount > 0) {
                        System.out.println("Product Deleted Successfully...");
                    } else {
                        System.err.println("Delete Failed...");
                    }
                    break;

                case 4:
                    System.out.print("Enter Product ID to display: ");
                    int dispId = sc.nextInt();
                    Product product = service.getProductById(dispId);
                    if (product != null) {
                        System.out.println(product);
                    } else {
                    	
                        System.err.println("Product Not Found...");
                    }
                    
                    break;
                    

                case 5:
                    System.out.print("Enter Purchase Date (YYYY-MM-DD): ");
                    sc.nextLine();  // Consume newline
                    String dateInput = sc.nextLine();
                    LocalDate date = LocalDate.parse(dateInput, DateTimeFormatter.ISO_LOCAL_DATE);
                    List<Product> productsByDate = service.getProductsByPurchaseDate(date);
                    if (!productsByDate.isEmpty()) {
                        productsByDate.forEach(System.out::println);
                    } else {
                        System.err.println("No Products Found on this Date...");
                    }
                    break;

                case 6:
                    List<Product> allProducts = service.getAllProducts();
                    if (!allProducts.isEmpty()) {
                        allProducts.forEach(System.out::println);
                    } else {
                        System.err.println("No Products Found...");
                    }
                    break;

                case 7:
                    flag = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.err.println("Invalid Choice. Please try again.");
            }
        }
    }

    public static Product getProduct() {
        System.out.println("Enter Pid ");
        int Pid = sc.nextInt();

        sc.nextLine(); // to consume the leftover newline

        System.out.println("Enter PName ");
        String Pname = sc.nextLine();

        System.out.println("Enter Price");
        double price = sc.nextDouble();

        LocalDate purchaseDate = null; 
        while (purchaseDate == null) {
            System.out.print("Enter Purchase Date (YYYY-MM-DD): ");
            String dateInput = sc.next();
            try {
                purchaseDate = LocalDate.parse(dateInput, DateTimeFormatter.ISO_LOCAL_DATE);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
            }
        }
        Product prd = new Product(Pid, Pname, price, purchaseDate);
        return prd;
    }
}
