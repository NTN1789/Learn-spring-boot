package com.example.demo.repositories;


import com.example.demo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Component
@Repository
public interface ProductRepository   extends JpaRepository<Product,Long> {



  //usar um macete


   /* private Map <Long, Product> map = new HashMap<>();
    // map e uma coleção para percorrer o array

    public  void  save(Product obj){
        map.put(obj.getId(), obj);
    }

    public  Product findById(Long id){
        return  map.get(id);
    }

    public List<Product> findAll(){
            return  new ArrayList<Product>(map.values());


    }
*/
}
