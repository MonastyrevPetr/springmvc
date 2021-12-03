package ru.gb.repository;

import org.springframework.stereotype.Component;
import ru.gb.dto.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> productList;

    @PostConstruct
    public void init(){
        productList = new ArrayList<>();
        productList.add(new Product(1,"Товар1",1000));
        productList.add(new Product(2,"Товар2",2000));
        productList.add(new Product(3,"Товар3",3000));
        productList.add(new Product(4,"Товар4",4000));
        productList.add(new Product(5,"Товар5",5000));
    }

    public List<Product> getAll(){
        return List.copyOf(productList);
    }

    public void save(Product product){
        productList.add(product);
    }

    public Product findId(int id){
        return productList.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }

}
