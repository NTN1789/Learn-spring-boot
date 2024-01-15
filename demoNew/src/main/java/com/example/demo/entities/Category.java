package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity

public class Category implements Serializable {

    private  static  final  long serialVersionUid = 1L;


    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)    // vai auto incrementar no banco
    private  Long id ;
    private  String name;


@JsonIgnore  // não serializar os produtos  isso e muito últil para evitar erros


   @OneToMany(mappedBy = "category") // tem que colocar o nome do atributo que vai usar , aqui e  o category
    private  List<Product> products = new ArrayList<>();

    public  Category(){

    }

    public Category(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

 /*   public void setProducts(List<Product> products) {
        this.products = products;
    }
    não pode ter o setProducts pq em nenhum momento  eu vou modificar os produtos
*/

    // o hascode e especial para comparação

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Category other = (Category) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
