package com.example.demo.resources;

import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@RequestMapping(value = "/products")
public class ProductResource {
    @Autowired
    private ProductRepository  productRepository;
        @GetMapping // endPointer , será a requisição GET para as categories
        public ResponseEntity<List<Product>> findAll() {       // na rquisição tem que ter o tipo da resposta  é tem qque ter o LIST com generics
            List<Product> list = productRepository.findAll() ;
            return ResponseEntity.ok(list);      // vai instanciar uma resposta do htpp como 200,404...

        }

    @GetMapping(value = "/{id}")        // pegar pelo o ID da API
    public ResponseEntity<Product> findById(@PathVariable Long id) {   // desse jeito aqui vc pegar o ID , é uma boa prática
        Product cat = productRepository.findById(id).get();
        return ResponseEntity.ok().body(cat);
    }


    }

