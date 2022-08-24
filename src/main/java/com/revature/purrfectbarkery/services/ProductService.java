package com.revature.purrfectbarkery.services;

import com.revature.purrfectbarkery.daos.ProductDAO;
import com.revature.purrfectbarkery.models.Cart;
import com.revature.purrfectbarkery.models.Product;

import java.util.List;

public class ProductService {
    private final ProductDAO productDAO;

    public void addProductToStore(Product product){
        productDAO.save(product);
    }

    public void updateProd(Product product){
        productDAO.update(product);
    }

    public ProductService(ProductDAO productDAO){
        this.productDAO = productDAO;
    }

    public List<Product> getAllProducts(){
        return productDAO.getAllProducts();
    }

    public List<Product> getAllProductsByStoreId(String storeid) {
        return productDAO.getAllByStoreId(storeid);
    }
}
