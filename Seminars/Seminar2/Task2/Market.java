package Seminars.Seminar2.Task2;


// Задание 2
// Необходимо реализовать строение классов, без конкретной реализации:
// 1. Интерфейс QueueBehaviour, который описывает логику очереди – помещение в/освобождение из очереди, принятие/отдача заказа
// 2. Интерфейс MarketBehaviour, который описывает логику магазина – приход/уход покупателей, обновление состояния магазина
// 3. Класс Market, который реализовывает два вышеуказанных интерфейса и хранит в списке список людей в очереди в различных статусах


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
