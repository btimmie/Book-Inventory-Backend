package BookInventory.api;

import BookInventory.Services.InventoryItemService;
import BookInventory.domain.InventoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by student on 2015/05/17.
 */
@RestController
@RequestMapping(value="/inventory/**")
public class InventoryPage {

    @Autowired
    private InventoryItemService service;
    @RequestMapping(value = "/items/", method = RequestMethod.GET)
    public ResponseEntity<List<InventoryItem>> listAllInventoryItems() {
        List<InventoryItem> InventoryItems = service.getInventoryItems();
        if(InventoryItems.isEmpty()){
            return new ResponseEntity<List<InventoryItem>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<InventoryItem>>(InventoryItems, HttpStatus.OK);
    }

    //-------------------Create a Book--------------------------------------------------------

    @RequestMapping(value = "/item/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createBook(@RequestBody InventoryItem item,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating InventoryItem " + item.getName());

//     USE THIS IF YOU WANT TO CHECK UNIQUE OBJECT
//      if (SubjectService.isSubjectExist(Subject)) {
//            System.out.println("A Subject with name " + Subject.getName() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }

        service.save(item);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/item/{id}").buildAndExpand(item.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a InventoryItem --------------------------------------------------------

    @RequestMapping(value = "/item/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<InventoryItem> updateInventoryItem(@PathVariable("id") long id, @RequestBody InventoryItem Subject) {
        System.out.println("Updating InventoryItem " + id);

        InventoryItem currentInventoryItem = service.findById(id);

        if (currentInventoryItem==null) {
            System.out.println("InventoryItem with id " + id + " not found");
            return new ResponseEntity<InventoryItem>(Subject,HttpStatus.NOT_FOUND);
        }

        InventoryItem updatedInventoryItem = new InventoryItem
                .Builder(currentInventoryItem.getCode())
                .copy(currentInventoryItem)
                .build();
        service.update(updatedInventoryItem);
        return new ResponseEntity<InventoryItem>(updatedInventoryItem, HttpStatus.OK);
    }

    //------------------- Delete a InventoryItem --------------------------------------------------------

    @RequestMapping(value = "/item/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<InventoryItem> deleteInventoryItem(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting InventoryItem with id " + id);

        InventoryItem item = service.findById(id);
        if (item == null) {
            System.out.println("Unable to delete. InventoryItem with id " + id + " not found");
            return new ResponseEntity<InventoryItem>(HttpStatus.NOT_FOUND);
        }

        service.delete(item);
        return new ResponseEntity<InventoryItem>(HttpStatus.NO_CONTENT);
    }


}
