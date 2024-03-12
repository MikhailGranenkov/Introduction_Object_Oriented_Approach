package Dz.Dz2;

// Реализовать класс Market и все методы, которые он обязан реализовывать.
// Методы из интерфейса QueueBehaviour, имитируют работу очереди, MarketBehaviour – помещает и удаляет человека из очереди, метод update – обновляет состояние магазина (принимает и отдает заказы)


// В методе update() сначала извлекается первый заказ из очереди методом deliverOrder(). Если заказ был извлечен успешно (не равен null), то происходит его обработка. Если очередь заказов пуста, выводится сообщение о том, что заказов для обработки нет.


import java.util.LinkedList;
import java.util.Queue;

// Интерфейс для имитации работы очереди
interface QueueBehaviour {
    void enqueue(Object person); // Метод для добавления элемента в очередь
    Object dequeue(); // Метод для извлечения элемента из очереди
}

// Интерфейс для управления заказами в магазине
interface MarketBehaviour {
    void acceptOrder(Object order); // Метод для принятия заказа
    Object deliverOrder(); // Метод для доставки заказа
}

public class Market implements QueueBehaviour, MarketBehaviour {
    private Queue<Object> queue = new LinkedList<>(); // Очередь клиентов
    private Queue<Object> orders = new LinkedList<>(); // Очередь заказов

    // Метод для добавления человека в очередь
    @Override
    public void enqueue(Object person) {
        queue.add(person);
    }

    // Метод для удаления человека из очереди
    @Override
    public Object dequeue() {
        return queue.poll();
    }

    // Метод для принятия заказа
    @Override
    public void acceptOrder(Object order) {
        orders.add(order);
    }

    // Метод для доставки заказа
    @Override
    public Object deliverOrder() {
        return orders.poll();
    }

    // Метод для обновления состояния магазина (принимает и отдает заказы)
    public void update() {
        // В данном примере обновление состояния магазина заключается в обработке первого заказа из очереди
        Object order = deliverOrder();
        if (order != null) {
            // Обработка заказа
            System.out.println("Заказ обработан: " + order.toString());
        } else {
            System.out.println("Нет заказов для обработки.");
        }
    }

    // Метод для получения текущего размера очереди клиентов
    public int getQueueSize() {
        return queue.size();
    }

    // Метод для получения текущего размера очереди заказов
    public int getOrdersSize() {
        return orders.size();
    }

    // Другие методы и свойства магазина могут быть добавлены здесь
}
