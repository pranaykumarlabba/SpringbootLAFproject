package com.highpeak.service;

import com.highpeak.springproject.Item;
import com.highpeak.springproject.ItemModel;
import com.highpeak.springproject.Role;
import com.highpeak.springproject.User;
import com.highpeak.user.repository.ItemRepository;
import com.highpeak.user.repository.UserRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {

    @Mock
    ItemRepository itemRepository;
    @Mock
    UserRepository userRepository;

    @Rule
   public MockitoRule mockitoRule = MockitoJUnit.rule();

    @InjectMocks
    ItemService itemService = new ItemService();

    @Test
    public void testaddLostItem(){

        Item item = new Item();
        Role role = new Role();
        User user = new User();
        ItemModel itemModel = new ItemModel();

        role.setRole_id(2);
        role.setRoleName("User");

        user.setUserid(1);
        user.setName("kumar");
        user.setEmail("kumar@gmail.com");
        user.setPassword("something");
        user.setAge(21);
        user.setPhone(775489245);
        user.setRole(role);

        itemModel.setItem_id(1);
        itemModel.setName("Phone");
        itemModel.setColor("Blue");
        itemModel.setBrand("Apple");
        itemModel.setSize(5.5);
        itemModel.setDeleted(false);
        itemModel.setFound(true);
        itemModel.setReportedDate("22/05/2018");
        itemModel.setUserid(1);

        item.setItem_id(1);
        item.setName("Phone");
        item.setColor("Blue");
        item.setBrand("Apple");
        item.setSize(5.5);
        item.setDeleted(false);
        item.setFound(true);
        item.setReportedDate("22/05/2018");
        item.setUser(user);

        when(itemRepository.save(any(Item.class))).thenReturn(item);
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(userRepository.findUserByUserid(anyInt())).thenReturn(user);
        Item items = itemService.addLostItem(itemModel);
        assertEquals(itemModel.getName(),item.getName());

        }

        @Test
        public void testRemoveItemById(){

       doNothing().when(itemRepository).removeItemById(anyInt());
        String result =itemService.removeItemById(1);
        assertEquals("deletedSuccessfully",result);
        }

        @Test
        public void testFindAllItems(){

        when(itemRepository.getAllLostItemByIsFound(anyBoolean())).thenReturn(anyList());
       List<Item> item = itemService.findAllItems(true);
       assertTrue(true);
        }

        @Test
        public void testupdateLostAndFoundItem(){

        doNothing().when(itemRepository).updateItemByIsFound(anyString());
        String str = itemService.updateLostAndFoundItem("Apple");
        assertEquals("Updated...",str);
        }
        @Test
        public void testGetItem(){
        Item item = new Item();
        item.setItem_id(1);
        item.setName("Laptop");
        item.setColor("Blue");
        item.setSize(5.5);
        item.setFound(true);
        item.setDeleted(false);
        item.setReportedDate("07/03/2017");

        List<Item> itemList = new ArrayList<>();
        itemList.add(item);

        when(itemRepository.findLostAndFoundItemByName(anyString())).thenReturn(itemList);
        List<Item> items = itemService.getItem("phone");
        assertEquals(itemList,items);
        }

        @Test
        public void testGetAllItems(){

        List<Item> itemList = new ArrayList<>();

            Item item=new Item();
            item.setItem_id(1);
            item.setName("Laptop");
            item.setColor("Blue");
            item.setSize(5.5);
            item.setFound(true);
            item.setDeleted(false);
            item.setReportedDate("07/03/2017");

            itemList.add(item);

            when(itemRepository.findAll()).thenReturn(itemList);
            List<Item> list = itemService.getAllItem();
            assertEquals(itemList,list);



        }
}
