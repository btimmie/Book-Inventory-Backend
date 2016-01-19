package BookInventory.Services;

import BookInventory.domain.InventoryItem;

import java.util.List;

/**
 * Created by student on 2015/05/17.
 */
public interface InventoryItemService {

    List<InventoryItem> getInventoryItems();

    InventoryItem findById(Long id);

    InventoryItem save(InventoryItem entity);

    InventoryItem update(InventoryItem entity);

    void delete(InventoryItem entity);


}
