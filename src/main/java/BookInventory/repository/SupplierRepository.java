package BookInventory.repository;

import BookInventory.domain.Supplier;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Yongama on 2015/11/28.
 */


public interface SupplierRepository extends CrudRepository<Supplier,Long> {
}

