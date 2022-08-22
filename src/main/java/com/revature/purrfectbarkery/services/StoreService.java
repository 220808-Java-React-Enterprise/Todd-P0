package com.revature.purrfectbarkery.services;

import com.revature.purrfectbarkery.daos.ProductDAO;
import com.revature.purrfectbarkery.daos.StoreDAO;
import com.revature.purrfectbarkery.models.Product;
import com.revature.purrfectbarkery.models.Store;

import java.util.List;

public class StoreService {
    private final StoreDAO storeDAO;

    public StoreService(StoreDAO storeDAO){
        this.storeDAO = storeDAO;
    }

    public void addNewStore(Store store){
        storeDAO.save(store);
    }


    public List<Store> getAllStores() {
        return storeDAO.getAll();
    }
}
