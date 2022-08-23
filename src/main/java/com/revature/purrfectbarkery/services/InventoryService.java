package com.revature.purrfectbarkery.services;

import com.revature.purrfectbarkery.daos.InventoryDAO;
import com.revature.purrfectbarkery.models.Inventory;

import java.util.List;

public class InventoryService {
    private final InventoryDAO inventoryDAO;

    public InventoryService(InventoryDAO inventoryDAO) {
        this.inventoryDAO = inventoryDAO;
    }


    public List<Inventory> getAllByStoreId(String storeid) {
        return inventoryDAO.getAllByStoreId(storeid);
    }

    public List<Inventory> getAllByProdId(String productid) {
        return inventoryDAO.getAllByProdId(productid);
    }
}
