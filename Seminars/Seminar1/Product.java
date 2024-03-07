package Seminars.Seminar1;


// Задача 1 - Абстракция
// Реализуйте класс Товар, содержащий данные о товаре, и ТорговыйАвтомат,
// содержащий в себе методы initProducts (List <Product>) сохраняющий в себе
// список исходных продуктов и getProduct(String name)


// Класс Product:
// Этот класс представляет собой модель товара. У него есть два поля: name (название товара) и price (цена товара).
// Конструктор Product(String name, double price) принимает на вход имя и цену товара и инициализирует соответствующие поля объекта.
// Методы getName() и getPrice() возвращают значение соответствующих полей.
// Методы setName(String name) и setPrice(double price) устанавливают новые значения для имени и цены товара соответственно.
// Класс VendingMachine:
// Этот класс представляет торговый автомат. Он содержит список продуктов и методы для работы с этим списком.
// Конструктор VendingMachine() инициализирует пустой список продуктов.
// Метод initProducts(List<Product> productList) принимает список продуктов и добавляет их в список продуктов торгового автомата.
// Метод getProduct(String name) принимает на вход имя продукта и ищет его в списке продуктов. Если продукт найден, метод возвращает объект Product, если нет - возвращает null.
// Класс Main:
// В методе main создается объект торгового автомата (VendingMachine).
// Создается список продуктов и добавляются три продукта (Coke, Chips, Chocolate) с их ценами.
// Продукты инициализируются в торговом автомате.
// Затем выполняется поиск продукта по его имени (в данном случае, "Chips") с помощью метода getProduct.
// Если продукт найден, его название и цена выводятся на экран, иначе выводится сообщение о том, что продукт не найден.
// Таким образом, код демонстрирует создание классов для представления товаров и торгового автомата, а также использование этих классов для добавления продуктов в торговый автомат и поиска продукта по его имени.

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class VendingMachine {
    private List<Product> products;

    public VendingMachine() {
        products = new ArrayList<>();
    }

    public void initProducts(List<Product> productList) {
        products.addAll(productList);
    }

    public Product getProduct(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null; // If product not found
    }
}

class Main {
    public static void main(String[] args) {
        // Создаем объект торгового автомата
        VendingMachine vendingMachine = new VendingMachine();

        // Создаем список продуктов
        List<Product> products = new ArrayList<>();
        products.add(new Product("Coke", 1.5));
        products.add(new Product("Chips", 2.0));
        products.add(new Product("Chocolate", 1.0));

        // Инициализируем продукты в торговом автомате
        vendingMachine.initProducts(products);

        // Получаем продукт по имени
        String productName = "Chips";
        Product product = vendingMachine.getProduct(productName);

        if (product != null) {
            System.out.println("Product found: " + product.getName() + ", Price: $" + product.getPrice());
        } else {
            System.out.println("Product not found: " + productName);
        }
    }
}
