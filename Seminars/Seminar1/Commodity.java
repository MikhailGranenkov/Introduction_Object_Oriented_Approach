package Seminars.Seminar1;


// Задача 3 - Наследование
// Сделайте класс Товар абстрактным, создайте нескольких наследников (к примеру: БутылкаВоды), сделайте интерфейсом ТорговыйАвтомат и реализуйте класс какого-то одного типа ТорговогоАвтомата (пример: ПродающийБутылкиВодыАвтомат)


// Объяснения:

// Класс Commodity: Это абстрактный класс, представляющий товар. У него есть приватные поля name и price, конструктор для установки этих полей и методы для получения их значений. Он также содержит абстрактный метод sell(), который должен быть реализован в наследниках для выполнения действий при продаже товара.
// Класс WaterBottle: Это наследник класса Commodity, представляющий бутылку воды. Он реализует метод sell(), чтобы определить действия при продаже бутылки воды.
// Интерфейс VendingMachine: Этот интерфейс определяет операции, которые должны быть поддержаны любым торговым автоматом. Он содержит методы для внесения монет и выбора товара.
// Класс WaterBottleVendingMachine: Это реализация интерфейса VendingMachine, представляющая торговый автомат для продажи бутылок воды. Он содержит баланс автомата и реализует методы для внесения монет и выбора товара.


// Абстрактный класс Товар
abstract class Commodity {
    private String name;
    private double price;

    // Конструктор класса Товар
    public Commodity(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Метод для получения имени товара
    public String getName() {
        return name;
    }

    // Метод для получения цены товара
    public double getPrice() {
        return price;
    }

    // Абстрактный метод, который должен быть реализован в наследниках для выполнения действий при продаже товара
    public abstract void sell();
}

// Наследник класса Товар: Бутылка воды
class WaterBottle extends Commodity {
    // Конструктор класса Бутылка воды
    public WaterBottle(String name, double price) {
        super(name, price);
    }

    // Реализация метода sell() для продажи бутылки воды
    @Override
    public void sell() {
        System.out.println("Продана бутылка воды: " + getName() + " за " + getPrice() + " рублей");
    }
}

// Интерфейс Торговый Автомат
interface VendingMachine {
    // Метод для внесения монет
    void insertCoin(double amount);

    // Метод для выбора товара
    void selectProduct(String productName);
}

// Класс реализующий Торговый Автомат для продажи бутылок воды
class WaterBottleVendingMachine implements VendingMachine {
    private double balance; // Баланс в автомате

    // Реализация метода внесения монет
    @Override
    public void insertCoin(double amount) {
        balance += amount;
        System.out.println("Баланс: " + balance + " рублей");
    }

    // Реализация метода выбора товара
    @Override
    public void selectProduct(String productName) {
        // Предположим, что здесь происходит поиск продукта в базе данных и его продажа
        Commodity product = new WaterBottle(productName, 1.5); // Создание объекта бутылки воды с ценой 1.5 рублей
        if (balance >= product.getPrice()) { // Если баланс позволяет купить товар
            product.sell(); // Продаем товар
            balance -= product.getPrice(); // Вычитаем цену товара из баланса
            System.out.println("Остаток на балансе: " + balance + " рублей");
        } else {
            System.out.println("Недостаточно средств на балансе для покупки товара: " + productName);
        }
    }
}

class Main {
    public static void main(String[] args) {
        // Создаем экземпляр торгового автомата для продажи бутылок воды
        WaterBottleVendingMachine vendingMachine = new WaterBottleVendingMachine();

        // Вносим деньги на баланс
        vendingMachine.insertCoin(2.0); // Положили 2 рубля

        // Выбираем товар
        vendingMachine.selectProduct("Минеральная вода");
    }
}
