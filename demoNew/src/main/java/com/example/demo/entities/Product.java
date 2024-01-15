package com.example.demo.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity

public class Product  implements Serializable {

    //mapeamentos objeto-relacional;
private  static  final  long serialVersionUid = 1L;

@Id
@GeneratedValue(strategy =  GenerationType.IDENTITY)    // vai auto incrementar no banco
private  Long id ;

private  String name ;
private Double  price;

@ManyToOne      // isso e uma relação com os objetos de memoria  com o banco de dados relacional a chave estrangeira
@JoinColumn(name = "category_id")   // nome da chave estrageira na tabela do banco
private  Category category;


public  Product(){

}

    public Product(Long id, String name, Double price, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
}
