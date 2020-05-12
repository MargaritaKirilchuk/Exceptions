package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryBookTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    private Book firstBook = new Book(1,"Война и Мир",1000, "Л.Н.Толстой");
    private Book secondBook = new Book(2,"Мастер и Маргарита", 1000, "М.А.Булгаков");

    @BeforeEach
    public void setUp(){
        repository.save(firstBook);
        repository.save(secondBook);
    }

    @Test
    public void ShouldRemoveIfExist(){
        repository.removeById(1);

        Product[] actual = repository.findAll();
        Product[] expected = {secondBook};

        assertArrayEquals (expected, actual);
    }

    @Test
    public void ShouldRemoveIfNoExist(){

        assertThrows(RuntimeException.class,()->repository.removeById(3));

    }

}