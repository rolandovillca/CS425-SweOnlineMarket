package edu.miu.cs.cs425.sweonlinemarketproject.service.impl;

import edu.miu.cs.cs425.sweonlinemarketproject.model.Product;
import edu.miu.cs.cs425.sweonlinemarketproject.model.ShoppingCart;
import edu.miu.cs.cs425.sweonlinemarketproject.repository.ShoppingCartRepository;
import edu.miu.cs.cs425.sweonlinemarketproject.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }


    @Override
    public ShoppingCart getShoppingCartById(long id) {
        return shoppingCartRepository.getById(id);

    }

    @Override
    public void deleteShoppingCartById(long id) {
        shoppingCartRepository.deleteById(id);

    }

    @Override
    public ShoppingCart getShoppingCartByBuyer(Long id) {
        return shoppingCartRepository.findByBuyerUserId(id).orElseGet(null);
    }

    @Override
    public ShoppingCart addProductToShoppingCart(Long cartId,Product product) {
        ShoppingCart cart= shoppingCartRepository.findById(cartId).orElseGet(null);
        List<Product> products=  cart.getProducts();
        products.add(product);
        cart.setProducts(products);
        return shoppingCartRepository.save(cart);
    }

    @Override
    public void deleteProductFromCart(Long productId, Long cartId) {
        ShoppingCart cart= shoppingCartRepository.findById(cartId).orElseGet(null);
        List<Product> products=  cart.getProducts();
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getProductId()==productId){
                products.remove(i);
                return;
            }
        }
        cart.setProducts(products);
        shoppingCartRepository.save(cart);

    }

    @Override
    public void deleteAllProductsFromCart(Long cartId) {
        ShoppingCart cart= shoppingCartRepository.findById(cartId).orElseGet(null);
        List<Product> products=  cart.getProducts();
        products.clear();
        cart.setProducts(products);
        shoppingCartRepository.save(cart);

    }

}
