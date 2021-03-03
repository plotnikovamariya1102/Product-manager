package ru.netology.repository;
import ru.netology.Domain.Product;

public class ProductRepository {
    private Product[] items = new Product[0];
        // Добавить товар
        public void save (Product item) {
            int length = items.length + 1;
            Product[] tmp = new Product[length];
            System.arraycopy(items,0,tmp,0,items.length);
            int lastIndex = tmp.length - 1;
            tmp [lastIndex] = item;
            items = tmp;
        }
        //    Искать все продукты
        public Product [] findAll(){
            return items;
        }
        //    Искать продукт по ID
        public Product findById(int id){
            for (Product item : items){
                if (item.getId() == id){
                    return item;
                }
            }
            return null;
        }
        //    Удалить продукт
        public void removeByd(int id){
            int length = items.length - 1;
            Product[] tmp = new Product[length];
            int index = 0;
            for (Product item : items){
                if (item.getId()!=id){
                    tmp [index] = item;
                    index ++;
                }
            }
        }
    }
