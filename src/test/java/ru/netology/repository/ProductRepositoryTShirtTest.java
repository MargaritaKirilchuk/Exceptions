package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.exception.NotFoundException;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTShirtTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    private TShirt firstTShirt = new TShirt(1,"Polo1", 3000, "U.S.Polo Assn");
    private TShirt secondTShirt = new TShirt(2,"Polo2", 3000, "U.S.Polo Assn");

    @BeforeEach
    public void setUp(){
        repository.save(firstTShirt);
        repository.save(secondTShirt);
    }

    @Test
    public void shouldRemoveIfExist(){
        repository.removeById(1);

        Product[] actual = repository.findAll();
        Product[] expected = {secondTShirt};

        assertArrayEquals (expected, actual);
    }

    @Test
    public void shouldRemoveIfNoExist(){
        assertThrows(NotFoundException.class,()->repository.removeById(3));

    }

}