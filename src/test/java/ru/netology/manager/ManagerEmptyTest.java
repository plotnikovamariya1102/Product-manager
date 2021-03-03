package ru.netology.manager;
import org.junit.jupiter.api.Test;
import ru.netology.Domain.Book;
import ru.netology.Domain.Product;
import ru.netology.Domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerEmptyTest {
    private ProductRepository repository = new ProductRepository();
    private Manager manager = new Manager(repository);
    private Book first = new Book(1, "Отверженные", 500, "В.Гюго");

    @Test
    void shouldGetAll() {
        Product[] expected = new Product[0];
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByInEmpty() {
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Отверженные");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByInOneItem() {
        manager.add(first);
        Product[] expected = new Product[]{first};
        Product[] actual = manager.searchBy("Отверженные");
        assertArrayEquals(expected, actual);
    }
  }
