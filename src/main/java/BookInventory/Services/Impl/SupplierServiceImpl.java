package BookInventory.Services.Impl;

import BookInventory.Services.SupplierService;
import BookInventory.domain.Supplier;
import BookInventory.repository.SupplierRepository;
import BookInventory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/17.
 */
@Service
public class SupplierServiceImpl implements SupplierService{

    @Autowired
    private SupplierRepository repository;

    @Override
    public Supplier findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Supplier save(Supplier entity) {
        return repository.save(entity);
    }

    @Override
    public Supplier update(Supplier entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Supplier entity) {
        repository.delete(entity);
    }

    @Override
    public List<Supplier> findAll() {
        List<Supplier> allSuppliers = new ArrayList<Supplier>();
        Iterable<Supplier> suppliers = repository.findAll(); //repository.findAll();
        for(Supplier supplier:suppliers){
            allSuppliers.add(supplier);
        }
        return allSuppliers;
    }
}
