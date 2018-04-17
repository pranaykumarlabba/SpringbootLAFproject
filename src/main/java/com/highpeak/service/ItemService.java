package com.highpeak.service;

import com.highpeak.springproject.Item;
import com.highpeak.springproject.ItemModel;
import com.highpeak.user.repository.ItemRepository;
import com.highpeak.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    public Item addLostItem(ItemModel itemModel){


        Item item = new Item();
        item.setName(itemModel.getName());
        item.setBrand(itemModel.getBrand());
        item.setColor((itemModel.getColor()));
        item.setSize(itemModel.getSize());
        item.setDeleted(false);
        item.setFound(itemModel.isFound());
        item.setReportedDate(itemModel.getReportedDate());
        item.setUser(userRepository.findUserByUserid(itemModel.getUserid()));
        return itemRepository.save(item);
    }

    @Transactional // persisting and deleting objects requires a transaction in JPA.

    public String removeItemById(int item_id){

        itemRepository.removeItemById(item_id);

        return "deletedSuccessfully";

    }

    public List<Item> findAllItems(Boolean isFound){
        return itemRepository.getAllLostItemByIsFound(isFound);
    }

    @Transactional
    public String updateLostAndFoundItem(String brand){

        itemRepository.updateItemByIsFound(brand);

        return "Updated...";
    }

   public List<Item> getAllItem()
   {
        return itemRepository.findAll();
   }


   public List<Item> getItem(String name){

        return itemRepository.findLostAndFoundItemByName(name);
   }


}
