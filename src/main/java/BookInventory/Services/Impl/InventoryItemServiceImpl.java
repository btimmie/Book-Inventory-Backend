package BookInventory.Services.Impl;

import BookInventory.Services.InventoryItemService;
import BookInventory.domain.InventoryItem;
import BookInventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/17.
 */
@Service
public class InventoryItemServiceImpl implements InventoryItemService {

    @Autowired
    private InventoryRepository repository;


    @Override
    public List<InventoryItem> getInventoryItems() {

        List<InventoryItem> inventoryItemList = new ArrayList<InventoryItem>();
        Iterable<InventoryItem> inventoryItems = repository.findAll();
        for (InventoryItem i : inventoryItems) {
            inventoryItemList.add(i);
        }
        return inventoryItemList;
    }


    @Override
    public InventoryItem findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public InventoryItem save(InventoryItem entity) {
        return repository.save(entity);
    }

    @Override
    public InventoryItem update(InventoryItem entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(InventoryItem entity) {
        repository.delete(entity);

    }
}
