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

@RequestMapping(value = "/categories")      // rota que vai ser
public class CategoryResource {
    @Autowired
    private  CategoryRepository categoryRepository;     // o import de repositories
        @GetMapping // endPointer , será a requisição GET para as categories
        public ResponseEntity<List<Category>> findAll() {       // na rquisição tem que ter o tipo da resposta  é tem que ter o LIST com generics

            List<Category> list = categoryRepository.findAll();        // categoryRepository e importante para pegar as coisas e colocar na rota
            return ResponseEntity.ok().body(list);      // vai instanciar uma resposta do htpp como 200,404...  e vai retornar o uqe tiver certo

        }

    @GetMapping(value = "/{id}")        // pegar pelo o ID da API
    public ResponseEntity<Category> findById(@PathVariable Long id) {   // desse jeito aqui vc pegar o ID , é uma boa prática   , o PathVariable e importante para isso acontecer
        Category cat = categoryRepository.findById(id).get();    // fiz uma função no categoryRepository para pegar  o id
        return ResponseEntity.ok().body(cat);
    }


    }

