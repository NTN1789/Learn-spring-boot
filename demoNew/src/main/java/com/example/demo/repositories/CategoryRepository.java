package com.example.demo.repositories;

import com.example.demo.entities.Category;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CategoryRepository {
    private Map <Long, Category> map = new HashMap<>();
    // map e uma coleção para percorrer o array

    public  void  save(Category obj){
        map.put(obj.getId(), obj);
    }

    public  Category findById(Long id){
        return  map.get(id);
    }

    public List<Category> findAll(){
            return  new ArrayList<Category>(map.values());


    }

}
