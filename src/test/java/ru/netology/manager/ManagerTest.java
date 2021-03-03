package ru.netology.manager;
import org.junit.jupiter.api.Test;
import ru.netology.Domain.Book;
import ru.netology.Domain.Product;
import ru.netology.Domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {
    private ProductRepository repository = new ProductRepository();
    private Manager manager = new Manager(repository);

    Product first = new Book(1, "Отверженные", 500, "В.Гюго");
    Product second = new Book(2, "Ревизор", 400, "Н.Гоголь");
    Product third = new Book(3, "Обломов", 350, "И.Гончаров");
    Product fourth = new Smartphone(4, "Honor", 11600, "Huawei");
    Product fifth = new Smartphone(5, "OPPO", 5, "BBK Electronics");

    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }
    @Test
    void searchAll() {

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("В.Гюго");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAll() {
        setUp();

        Product[] expected = new Product[]{first, second, third, fourth, fifth};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchInProduct() {
        setUp();

        Product[] expected = new Product[]{fifth};
        Product[] actual = manager.searchBy("OPPO");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchAllByAuthor() {
        setUp();

        Product[] expected = new Product[]{first};
        Product[] actual = manager.searchBy("В.Гюго");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByName() {
        setUp();

        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy("Обломов");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchMatchesNameBook() {
        setUp();

        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("Ревизор");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchMatchesAuthor() {
        setUp();

        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy("И.Гончаров");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchMatchesManufacture() {
        setUp();

        Product[] expected = new Product[]{fourth};
        Product[] actual = manager.searchBy("Huawei");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchMatchesNameSmartphone() {
        setUp();

        Product[] expected = new Product[]{fifth};
        Product[] actual = manager.searchBy("OPPO");
        assertArrayEquals(expected, actual);
    }
}
