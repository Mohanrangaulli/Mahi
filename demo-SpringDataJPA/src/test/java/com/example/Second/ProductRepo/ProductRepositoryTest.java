package com.example.Second.ProductRepo;

import com.example.Second.Entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class ProductRepositoryTest {
     @Autowired
    private ProductRepository productRepository;
     @Test
    void saveMethod(){
         // create Product
         Product product=new Product();
         product.setName("saop");
         product.setActive(true);
         product.setDescription("mysore sandle");
         product.setPrice(new BigDecimal(150));
         product.setSku("100rs");
         product.setImageUrl("saopImg.png");

         // save Product
         Product savedData =productRepository.save(product);
         // display the product information
         System.out.println(savedData.getId());
         System.out.println(savedData.toString());
         }
         @Test
         void updateUsingSaveMethod(){
         //find or retrieve data
              Long id=6L;
            Product product= productRepository.findById(id).get();
            product.setName("santhoor");
            product.setDescription("santhoor gold");

            // save updated the data
             productRepository.save(product);


         }
         //findById
         @Test
         void findByIdMethod(){
         Long id=6L;
         Optional<Product> product=productRepository.findById(id);
         }

         @Test
    void saveAllMethod(){
     Product product1=new Product();
             product1.setName("Hamam");
             product1.setActive(true);
             product1.setDescription("Hamam sandle");
             product1.setPrice(new BigDecimal(750));
             product1.setSku("60rs");
             product1.setImageUrl("Hamam.png");

             Product product2=new Product();
             product2.setName("rexonm");
             product2.setActive(true);
             product2.setDescription("rexona sandle");
             product2.setPrice(new BigDecimal(650));
             product2.setSku("50rs");
             product2.setImageUrl("rexona.png");
             productRepository.saveAll(List.of(product1,product2));
     }
     @Test
     void findAllMethod(){
         List<Product> products=productRepository.findAll();
         products.forEach((product -> {
             System.out.println(product.getDescription());
         }));


     }
     @Test
    void deleteMethod(){
         Long id=6L;
         productRepository.deleteById(id);

     }
     @Test
    void existingByIdMethod(){
         Long id=5L;
         productRepository.existsById(id);
     }

}