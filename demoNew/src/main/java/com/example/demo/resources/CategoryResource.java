package com.example.demo.resources;

import com.example.demo.entities.Category;
import com.example.demo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController

@RequestMapping(value = "/categories")
public class CategoryResource {
    @Autowired
    private  CategoryRepository categoryRepository;
        @GetMapping // endPointer , será a requisição GET para as categories
        public ResponseEntity<List<Category>> findAll() {       // na rquisição tem que ter o tipo da resposta  é tem qque ter o LIST com generics
            List<Category> list = categoryRepository.findAll() ;
            return ResponseEntity.ok().body(list);      // vai instanciar uma resposta do htpp como 200,404...

        }

    @GetMapping(value = "/{id}")        // pegar pelo o ID da API
    public ResponseEntity<Category> findById(@PathVariable Long id) {   // desse jeito aqui vc pegar o ID , é uma boa prática
        Category cat = categoryRepository.findById(id);
        return ResponseEntity.ok().body(cat);
    }


    }

