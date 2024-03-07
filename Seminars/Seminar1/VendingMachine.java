package Seminars.Seminar1;


// Задача 2 - Инкапсуляция
// Реализуйте конструкторы, get/set методы, постройте логику ТорговогоАвтомата на основе кода сделанного в предыдущем задании.


// Класс VendingMachine:
// В этом классе содержится информация о товаре, который представлен торговым автоматом.
// Он содержит два приватных поля: name для хранения имени товара и price для хранения его цены.
// Конструктор VendingMachine(String name, double price) позволяет создать экземпляр товара, устанавливая его имя и цену.
// Геттеры getName() и getPrice() используются для получения имени и цены товара соответственно.
// Сеттеры setName(String name) и setPrice(double price) позволяют изменить имя и цену товара.
// Класс VendingMachineManager:
// Этот класс представляет менеджер торговых автоматов, который управляет списком торговых автоматов.
// Он содержит приватное поле vendingMachines для хранения списка торговых автоматов.
// Конструкторы VendingMachineManager() и VendingMachineManager(List<VendingMachine> vendingMachines) позволяют создать экземпляр менеджера торговых автоматов с пустым списком или с заданным списком торговых автоматов соответственно.
// Геттеры и сеттеры getVendingMachines() и setVendingMachines(List<VendingMachine> vendingMachines) используются для доступа к списку торговых автоматов.
// Методы addVendingMachine(VendingMachine vendingMachine) и removeVendingMachine(String name) позволяют добавлять новые торговые автоматы или удалять существующие из списка.
// Метод getVendingMachine(String name) позволяет получить торговый автомат по его имени.
// Класс Main:
// Этот класс содержит метод main, который является точкой входа в программу.
// В методе main создается экземпляр VendingMachineManager, который будет управлять торговыми автоматами.
// Создается список vendingMachines, содержащий несколько экземпляров VendingMachine с различными товарами и ценами.
// Этот список инициализируется в менеджере с помощью метода setVendingMachines.
// Далее в программе демонстрируется поиск торгового автомата по его имени с использованием метода getVendingMachine, и если такой автомат найден, выводится информация о нем.
// Таким образом, данный код представляет систему управления торговыми автоматами, где каждый автомат содержит информацию о товаре, а менеджер управляет списком доступных автоматов и предоставляет методы для добавления, удаления и поиска автоматов.


import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private String name;
    private double price;

    public VendingMachine(String name, double price) {
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

class VendingMachineManager {
    private List<VendingMachine> vendingMachines;

    public VendingMachineManager() {
        vendingMachines = new ArrayList<>();
    }

    public VendingMachineManager(List<VendingMachine> vendingMachines) {
        this.vendingMachines = vendingMachines;
    }

    public List<VendingMachine> getVendingMachines() {
        return vendingMachines;
    }

    public void setVendingMachines(List<VendingMachine> vendingMachines) {
        this.vendingMachines = vendingMachines;
    }

    public void addVendingMachine(VendingMachine vendingMachine) {
        vendingMachines.add(vendingMachine);
    }

    public void removeVendingMachine(String name) {
        for (int i = 0; i < vendingMachines.size(); i++) {
            if (vendingMachines.get(i).getName().equals(name)) {
                vendingMachines.remove(i);
                return;
            }
        }
    }

    public VendingMachine getVendingMachine(String name) {
        for (VendingMachine vendingMachine : vendingMachines) {
            if (vendingMachine.getName().equals(name)) {
                return vendingMachine;
            }
        }
        return null; // If vending machine not found
    }
}

class Main {
    public static void main(String[] args) {
        // Создаем объект менеджера торговых автоматов
        VendingMachineManager manager = new VendingMachineManager();

        // Создаем список торговых автоматов
        List<VendingMachine> vendingMachines = new ArrayList<>();
        vendingMachines.add(new VendingMachine("Coke", 1.5));
        vendingMachines.add(new VendingMachine("Chips", 2.0));
        vendingMachines.add(new VendingMachine("Chocolate", 1.0));

        // Инициализируем торговые автоматы в менеджере
        manager.setVendingMachines(vendingMachines);

        // Получаем торговый автомат по имени
        String vendingMachineName = "Chips";
        VendingMachine vendingMachine = manager.getVendingMachine(vendingMachineName);

        if (vendingMachine != null) {
            System.out.println("Vending machine found: " + vendingMachine.getName() + ", Price: $" + vendingMachine.getPrice());
        } else {
            System.out.println("Vending machine not found: " + vendingMachineName);
        }
    }
}


