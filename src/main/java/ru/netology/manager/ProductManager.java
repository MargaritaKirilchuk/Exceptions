package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    public ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product item){
        repository.save(item);
    }

    public Product[] findAll(){
        Product[] items = repository.findAll();
        Product[] result = new Product[items.length];
        for (int i = 0; i < items.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public void removeById (int id){
        repository.removeById(id);
    }

    public Product findById(int id) {
        return repository.findById(id);
    }

}
