/*
package BookInventory.api;

*/
/**
 * Created by student on 2015/05/17.
 *//*


import BookInventory.Services.SupplierService;
import BookInventory.domain.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value="/api*/
/**")
public class SupplerPage {

    @Autowired
    private SupplierService service;

//    @RequestMapping(value = "/supplier",method = RequestMethod.GET)
//    public Supplier getSupplier(){
//        Supplier supplier = new Supplier.Builder("ABC")
//                .name("Book world").address("45 Lower Main Road Observatory").build();
//        return supplier;
//    }

    //-------------------Retrieve All Suppliers--------------------------------------------------------

    @RequestMapping(value = "/Suppliers/", method = RequestMethod.GET)
    public ResponseEntity<List<Supplier>> listAllSubjects() {
        List<Supplier> suppliers = service.findAll();
        if(suppliers.isEmpty()){
            return new ResponseEntity<List<Supplier>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Supplier>>(suppliers, HttpStatus.OK);
    }


    //-------------------Retrieve Single Supplier--------------------------------------------------------

    @RequestMapping(value = "/Supplier/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Supplier> getSubject(@PathVariable("id") long id) {
        System.out.println("Fetching Supplier with id " + id);
        Supplier supplier = service.findById(id);
        if (supplier == null) {
            System.out.println("Subject with id " + id + " not found");
            return new ResponseEntity<Supplier>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Supplier>(supplier, HttpStatus.OK);
    }

    //-------------------Create a Supplier--------------------------------------------------------

    @RequestMapping(value = "/Supplier/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createSuppler(@RequestBody Supplier suppler,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Suppler " + suppler.getName());


        service.save(suppler);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/supplier/{id}").buildAndExpand(suppler.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


    //------------------- Update a Supplier --------------------------------------------------------

    @RequestMapping(value = "/suppler/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Supplier> updateSubject(@PathVariable("id") long id, @RequestBody Supplier Subject) {
        System.out.println("Updating Subject " + id);

        Supplier currentSupplier = service.findById(id);

        if (currentSupplier==null) {
            System.out.println("Subject with id " + id + " not found");
            return new ResponseEntity<Supplier>(HttpStatus.NOT_FOUND);
        }

        Supplier updatedSupplier = new Supplier
                .Builder(currentSupplier.getCode())
                .copy(currentSupplier)
                .build();
        service.update(updatedSupplier);
        return new ResponseEntity<Supplier>(updatedSupplier, HttpStatus.OK);
    }



    //------------------- Delete a Subject --------------------------------------------------------

    @RequestMapping(value = "/suppler/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Supplier> deleteSubject(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Supplier with id " + id);

        Supplier supplier = service.findById(id);
        if (supplier == null) {
            System.out.println("Unable to delete. Subject with id " + id + " not found");
            return new ResponseEntity<Supplier>(HttpStatus.NOT_FOUND);
        }

        service.delete(supplier);
        return new ResponseEntity<Supplier>(HttpStatus.NO_CONTENT);
    }

}
*/
