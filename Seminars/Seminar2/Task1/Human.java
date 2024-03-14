package Seminars.Seminar2.Task1;


// Задача 1
// Необходимо реализовать:
// Класс Human, который должен наследоваться от Actor и реализовывать ActorBehavoir
// Интерфейс ActorBehavoir, который будет содержать описание возможных действий актора в очереди/магазине
// Абстрактный класс Actor, который хранит в себе параметры актора, включая состояние готовности сделать заказ и факт получения заказа.
// Дополнение: для большего понимания, можно сделать методы-геттеры для имени и прочих “персональных данных” abstract


// Интерфейс описывающий поведение актора
interface ActorBehaviour {
    void act(); // Метод, описывающий действие актора
}

// Абстрактный класс, описывающий актора
abstract class Actor {
    private String name;
    private boolean readyToOrder;
    private boolean hasOrdered;

    public Actor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isReadyToOrder() {
        return readyToOrder;
    }

    public void setReadyToOrder(boolean readyToOrder) {
        this.readyToOrder = readyToOrder;
    }

    public boolean hasOrdered() {
        return hasOrdered;
    }

    public void setHasOrdered(boolean hasOrdered) {
        this.hasOrdered = hasOrdered;
    }
}

// Класс, представляющий человека
public class Human extends Actor implements ActorBehaviour {
    public Human(String name) {
        super(name);
    }

    @Override
    public void act() {
        if (isReadyToOrder() && !hasOrdered()) {
            System.out.println(getName() + " готов к заказу.");
            setHasOrdered(true);
        } else {
            System.out.println(getName() + " ожидает.");
        }
    }
}
