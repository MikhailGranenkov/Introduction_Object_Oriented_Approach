package Seminars.Seminar1;

  
// Задача 4 - Полиморфизм
// Переопределите метод toString для Товара, запустите программу, после этого переопределите для наследника этот метод, после запуска обратите внимание на изменение поведения.
// Создайте перегруженный метод выдачи товара ТорговымАвтоматом дополнив дополнительным входным параметром (пример: getProduct(String name) выдающий товар по имени, создайте метод возвращающий товар по имени и какому-либо параметру товара getProduct(String name, int volume)


// Код представляет собой пример использования абстрактных классов, наследования и интерфейсов в контексте реализации торгового автомата для продажи товаров, в данном случае - бутылок воды.

// Абстрактный класс Commodity:
// Определяет общие характеристики для всех товаров, такие как name (название) и price (цена).
// Содержит конструктор для инициализации этих характеристик.
// Объявляет абстрактный метод sell(), который предполагает различные действия при продаже конкретного товара.
// Переопределяет метод toString(), чтобы предоставлять строковое представление товара.
// Наследник класса Commodity: WaterBottle:
// Представляет конкретный тип товара - бутылку воды.
// Имеет конструктор для создания бутылки воды с определенным названием и ценой.
// Реализует абстрактный метод sell(), который выводит информацию о продаже бутылки воды.
// Переопределяет метод toString(), чтобы предоставлять специфическое строковое представление для бутылки воды.
// Интерфейс VendingMachine:
// Определяет методы, которые должны быть реализованы для работы торгового автомата: insertCoin для внесения денег и два перегруженных метода getProduct для выдачи товара по имени и/или дополнительному параметру.
// Класс WaterBottleVendingMachine:
// Реализует интерфейс VendingMachine для продажи бутылок воды.
// Содержит переменную balance для отслеживания текущего баланса автомата.
// Реализует метод insertCoin, который увеличивает баланс автомата при внесении денег.
// Реализует два метода getProduct, чтобы выдать бутылку воды по имени и/или объему.
// Класс Main:
// Содержит метод main, который является точкой входа в программу.
// Создает экземпляр WaterBottleVendingMachine.
// Получает товары по имени и/или объему с помощью методов getProduct и выводит информацию о них.


// Абстрактный класс Товар
abstract class Commodity {
    private String name;
    private double price;

    public Commodity(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Метод для определения действий, которые должны выполниться при продаже товара
    public abstract void sell();

    // Переопределение метода toString для вывода информации о товаре
    @Override
    public String toString() {
        return "Товар: " + name + ", Цена: " + price + " рублей";
    }
}

// Наследник класса Товар: Бутылка воды
class WaterBottle extends Commodity {
    public WaterBottle(String name, double price) {
        super(name, price);
    }

    // Реализация метода продажи для бутылки воды
    @Override
    public void sell() {
        System.out.println("Продана бутылка воды: " + getName() + " за " + getPrice() + " рублей");
    }

    // Переопределение метода toString для бутылки воды
    @Override
    public String toString() {
        return "Бутылка воды: " + getName() + ", Цена: " + getPrice() + " рублей";
    }
}

// Интерфейс Торговый Автомат
interface VendingMachine {
    void insertCoin(double amount);

    // Перегруженный метод для выдачи товара по имени
    Commodity getProduct(String name);

    // Перегруженный метод для выдачи товара по имени и какому-либо параметру товара
    Commodity getProduct(String name, int volume);
}

// Класс реализующий Торговый Автомат для продажи бутылок воды
class WaterBottleVendingMachine implements VendingMachine {
    private double balance;

    @Override
    public void insertCoin(double amount) {
        balance += amount;
        System.out.println("Баланс: " + balance + " рублей");
    }

    @Override
    public Commodity getProduct(String name) {
        return new WaterBottle(name, 1.5); // Пример создания бутылки воды с ценой 1.5 рублей
    }

    @Override
    public Commodity getProduct(String name, int volume) {
        return new WaterBottle(name, volume * 1.5); // Пример создания бутылки воды с ценой, зависящей от объема
    }
}

class Main {
    public static void main(String[] args) {
        // Создание экземпляра торгового автомата для продажи бутылок воды
        WaterBottleVendingMachine vendingMachine = new WaterBottleVendingMachine();

        // Получение товара по имени
        Commodity product1 = vendingMachine.getProduct("Минеральная вода");
        System.out.println(product1);

        // Получение товара по имени и объему
        Commodity product2 = vendingMachine.getProduct("Минеральная вода", 2);
        System.out.println(product2);
    }
}
