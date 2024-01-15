package com.example.demo.repositories;

import com.example.demo.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Component  antes do macete , estava este

@Repository
public interface CategoryRepository  extends JpaRepository<Category,Long> {


    //trocamos para interface , antes do macete era class






    //usar um macete


    /*   private Map <Long, Category> map = new HashMap<>();
    // map e uma coleção para percorrer o array e retornar algo de dentro

    public  void  save(Category obj){
        map.put(obj.getId(), obj);  // essa função será chamada para salvar a categoria sendo , eletronicos,livros e outras . ela é muito últil
    }

    public  Category findById(Long id){
        return  map.get(id);                // essa função será chamada nas rotas e vai pegar o id especifico
    }

    public List<Category> findAll(){
            return  new ArrayList<Category>(map.values());      // esse aqui vai retornar todos


    }
*/
}
