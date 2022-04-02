package edu.miu.cs.cs425.sweonlinemarketproject.service;

import edu.miu.cs.cs425.sweonlinemarketproject.model.Product;
import edu.miu.cs.cs425.sweonlinemarketproject.model.Review;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(long id);

    Product saveProduct(Product product);

    Product updateProduct(long id, Product product);

    List<Product> getAllProductsBySellerId(long id);

    List<Product> getAllProductWhichAreNotOutOfStock();

    void updateProductQuantity(List<Product> productList);
    List<Product> searchProducts(String searchString);

//    void updateReview(Review review, String productId);

//    List<Product> getPendingReviewProducts();

//    void saveAll(List<Product> productList);

//    void updateProductReviewStatus(ProductComment productComment);

    void deleteById(long id);
}
