package com.highpeak.user.repository;

import com.highpeak.springproject.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
       public interface ItemRepository extends JpaRepository<Item,Integer> {

        @Modifying    //it modify the state of database and does not select data.
        @Query(nativeQuery = true,value = "update item_table i set i.is_deleted = true where i.id = :item_id")
        void removeItemById(@Param("item_id") int item_id);


        List<Item> getAllLostItemByIsFound(Boolean isFound);

        @Modifying
        @Query(nativeQuery = true,value = "update item_table i set i.is_found = true where i.brand = :brand")
        void updateItemByIsFound(@Param("brand") String brand);

        @Modifying
       // @Query(nativeQuery = true,value = "select * from item_table order by name asc ,reported_date asc ")
        List<Item> findAll();

       /* @Modifying
        @Query(nativeQuery = true,value = "select * from item_table i where i.is_found = true " +
                "order by name asc,reported_date desc ")
       List<Item> findFoundItemsByisFound(Boolean isFound);
       */
       @Modifying
       @Query(nativeQuery = true,value = "select * from item_table i where i.name = :iname")
       List<Item> findLostAndFoundItemByName(@Param("iname") String iname);
}

