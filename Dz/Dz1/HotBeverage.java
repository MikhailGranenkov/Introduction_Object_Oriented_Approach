package Dz.Dz1;


// Создать наследника реализованного класса ГорячийНапиток с дополнительным полем int температура.
// Создать класс ГорячихНапитковАвтомат реализующий интерфейс ТорговыйАвтомат и реализовать перегруженный метод getProduct(int name, int volume, int temperature), выдающий продукт соответствующий имени, объёму и температуре
// В main проинициализировать несколько ГорячихНапитков и ГорячихНапитковАвтомат и воспроизвести логику, заложенную в программе
// Всё вышеуказанное создать согласно принципам ООП, пройденным на семинаре


// Этот код содержит следующие элементы:

// Абстрактный класс HotBeverage:
// Определяет общие характеристики для всех горячих напитков: name (название), price (цена) и temperature (температура).
// Содержит конструктор для инициализации этих характеристик.
// Объявляет абстрактный метод sell(), который предполагает различные действия при продаже конкретного напитка.
// Переопределяет метод toString(), чтобы предоставлять строковое представление напитка.
// Наследник класса HotBeverage: Tea:
// Представляет конкретный тип напитка - чай.
// Имеет конструктор для создания чая с определенным названием, ценой и температурой.
// Реализует абстрактный метод sell(), который выводит информацию о продаже чая.
// Интерфейс VendingMachine:
// Определяет методы, которые должны быть реализованы для работы торгового автомата: insertCoin для внесения денег и метод getProduct для выдачи горячего напитка по имени, объему и температуре.
// Класс HotBeverageVendingMachine:
// Реализует интерфейс VendingMachine для продажи горячих напитков.
// Содержит переменную balance для отслеживания текущего баланса автомата.
// Реализует метод insertCoin, который увеличивает баланс автомата при внесении денег.
// Реализует метод getProduct, чтобы выдать горячий напиток с заданными параметрами.
// Метод main в классе Main:
// Создает экземпляр HotBeverageVendingMachine.
// Вносит деньги на баланс.
// Получает и выводит информацию о чае с заданными параметрами.


// Абстрактный класс Горячий Напиток
abstract class HotBeverage {
    private String name;
    private double price;
    private int temperature; // Новое поле для температуры напитка

    public HotBeverage(String name, double price, int temperature) {
        this.name = name;
        this.price = price;
        this.temperature = temperature;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getTemperature() {
        return temperature;
    }

    // Метод для определения действий, которые должны выполниться при продаже напитка
    public abstract void sell();

    // Переопределение метода toString для вывода информации о напитке
    @Override
    public String toString() {
        return "Напиток: " + name + ", Цена: " + price + " рублей, Температура: " + temperature + " градусов";
    }
}

// Наследник класса Горячий Напиток: Чай
class Tea extends HotBeverage {
    public Tea(String name, double price, int temperature) {
        super(name, price, temperature);
    }

    // Реализация метода продажи для чая
    @Override
    public void sell() {
        System.out.println("Продан чай: " + getName() + ", Цена: " + getPrice() + " рублей, Температура: " + getTemperature() + " градусов");
    }
}

// Интерфейс Торговый Автомат
interface VendingMachine {
    void insertCoin(double amount);

    // Перегруженный метод для выдачи напитка по имени, объему и температуре
    HotBeverage getProduct(String name, int volume, int temperature);
}

// Класс реализующий Торговый Автомат для горячих напитков
class HotBeverageVendingMachine implements VendingMachine {
    private double balance;

    @Override
    public void insertCoin(double amount) {
        balance += amount;
        System.out.println("Баланс: " + balance + " рублей");
    }

    @Override
    public HotBeverage getProduct(String name, int volume, int temperature) {
        // Пример создания чая с заданными параметрами
        return new Tea(name, volume * 1.5, temperature);
    }
}

class Main {
    public static void main(String[] args) {
        // Создание экземпляра торгового автомата для горячих напитков
        HotBeverageVendingMachine vendingMachine = new HotBeverageVendingMachine();

        // Вносим деньги на баланс
        vendingMachine.insertCoin(2.0); // Положили 2 рубля

        // Выбираем чай с заданными параметрами
        HotBeverage tea = vendingMachine.getProduct("Чай", 1, 80); // Получаем чай объемом 1 и температурой 80 градусов
        System.out.println(tea);
        tea.sell();
    }
}
