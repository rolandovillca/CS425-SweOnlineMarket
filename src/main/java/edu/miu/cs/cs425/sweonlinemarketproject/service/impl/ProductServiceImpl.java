package edu.miu.cs.cs425.sweonlinemarketproject.service.impl;

import edu.miu.cs.cs425.sweonlinemarketproject.model.Product;
import edu.miu.cs.cs425.sweonlinemarketproject.repository.ProductRepository;
import edu.miu.cs.cs425.sweonlinemarketproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(long id) {
        return productRepository.findById(id).orElseGet(null);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(long id, Product product) {
        product.setProductId(id);
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProductsBySellerId(long id) {
        return productRepository.findBySellerId(id);
    }

    @Override
    public List<Product> getAllProductWhichAreNotOutOfStock() {
        return productRepository.findNotOutOfStockProducts();
    }

    @Override
    public void updateProductQuantity(List<Product> productList) {
        productRepository.saveAll(productList);
    }

    @Override
    public void deleteById(long id) {
        productRepository.deleteById(id);
    }
    @Override
    public List<Product> searchProducts(String searchString) {
        return productRepository.findAllByProductName(searchString);

    }
}
