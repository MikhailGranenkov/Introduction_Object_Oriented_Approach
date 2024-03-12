package Seminars.Seminar2.Task2;

import java.util.List;

interface QueueBehaviour {
    void enqueue(Person person);
    void dequeue(Person person);
    void acceptOrder(Person person);
    void releaseOrder(Person person);
}

interface MarketBehaviour {
    void customerArrival(Person person);
    void customerDeparture(Person person);
    void updateMarketState();
}

class Market implements QueueBehaviour, MarketBehaviour {
    private List<Person> queue;
    private List<Person> customers;

    // Реализация методов интерфейса QueueBehaviour
    @Override
    public void enqueue(Person person) {
        queue.add(person);
    }

    @Override
    public void dequeue(Person person) {
        queue.remove(person);
    }

    @Override
    public void acceptOrder(Person person) {
        // Логика принятия заказа
    }

    @Override
    public void releaseOrder(Person person) {
        // Логика отдачи заказа
    }

    // Реализация методов интерфейса MarketBehaviour
    @Override
    public void customerArrival(Person person) {
        customers.add(person);
    }

    @Override
    public void customerDeparture(Person person) {
        customers.remove(person);
    }

    @Override
    public void updateMarketState() {
        // Логика обновления состояния магазина
    }
}

class Person {
    // Поля и методы для представления человека
}
