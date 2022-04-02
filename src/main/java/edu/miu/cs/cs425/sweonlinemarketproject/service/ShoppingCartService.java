package edu.miu.cs.cs425.sweonlinemarketproject.service;

import edu.miu.cs.cs425.sweonlinemarketproject.model.Product;
import edu.miu.cs.cs425.sweonlinemarketproject.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {


    ShoppingCart getShoppingCartById(long id);

    void deleteShoppingCartById(long id);

    ShoppingCart getShoppingCartByBuyer(Long id);

    ShoppingCart addProductToShoppingCart(Long cartId, Product product);

    void deleteProductFromCart(Long productId, Long cartId);

    void deleteAllProductsFromCart(Long cartId);






}
