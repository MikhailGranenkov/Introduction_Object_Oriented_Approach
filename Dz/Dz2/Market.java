package Dz.Dz2;

// Реализовать класс Market и все методы, которые он обязан реализовывать.
// Методы из интерфейса QueueBehaviour, имитируют работу очереди, MarketBehaviour – помещает и удаляет человека из очереди, метод update – обновляет состояние магазина (принимает и отдает заказы)


// В методе update() сначала извлекается первый заказ из очереди методом deliverOrder(). Если заказ был извлечен успешно (не равен null), то происходит его обработка. Если очередь заказов пуста, выводится сообщение о том, что заказов для обработки нет.


// QueueBehaviour<T> и MarketBehaviour<T> - это интерфейсы, которые определяют поведение для работы с очередью и магазином соответственно. Они содержат абстрактные методы, которые должны быть реализованы в классе Market.
// Market<T> - это класс, который реализует оба интерфейса и представляет собой магазин. Он содержит внутреннюю очередь для хранения заказов.
// enqueue(T element) и dequeue() - это методы интерфейса QueueBehaviour, которые реализуют добавление и удаление элементов из очереди.
// acceptOrder(T order) и deliverOrder() - это методы интерфейса MarketBehaviour, которые реализуют принятие и отдачу заказов.
// update() - это метод, который обновляет состояние магазина. В данном примере метод просто выводит сообщение о выполнении обновления, но его можно расширить для реального обновления состояния магазина, такого как обработка заказов или организация доставки.
// В методе main представлен пример использования класса Market, где создается экземпляр класса, принимаются и отдаются заказы, а затем вызывается метод обновления состояния магазина.


import java.util.LinkedList;
import java.util.Queue;

// Интерфейс, определяющий поведение очереди
interface QueueBehaviour<T> {
    void enqueue(T element); // Метод для добавления элемента в очередь
    T dequeue(); // Метод для удаления элемента из очереди
}

// Интерфейс, определяющий поведение рынка
interface MarketBehaviour<T> {
    void acceptOrder(T order); // Метод для принятия заказа
    T deliverOrder(); // Метод для отдачи заказа
}

// Класс Market, который реализует интерфейсы QueueBehaviour и MarketBehaviour
public class Market<T> implements QueueBehaviour<T>, MarketBehaviour<T> {
    private Queue<T> queue; // Очередь заказов

    public Market() {
        this.queue = new LinkedList<>(); // Создаем пустую очередь
    }

    // Метод для добавления элемента в очередь
    @Override
    public void enqueue(T element) {
        queue.add(element); // Добавляем элемент в конец очереди
    }

    // Метод для удаления элемента из очереди
    @Override
    public T dequeue() {
        return queue.poll(); // Удаляем и возвращаем первый элемент из очереди
    }

    // Метод для принятия заказа
    @Override
    public void acceptOrder(T order) {
        enqueue(order); // Добавляем заказ в очередь
    }

    // Метод для отдачи заказа
    @Override
    public T deliverOrder() {
        return dequeue(); // Удаляем и возвращаем заказ из очереди
    }

    // Метод для обновления состояния магазина
    public void update() {
        // Здесь можно добавить логику обновления состояния магазина,
        // например, обработку заказов, организацию доставки и т.д.
        // В данном примере метод просто выводит сообщение о выполнении обновления.
        System.out.println("Состояние магазина обновлено.");
    }

    // Пример использования класса Market
    public static void main(String[] args) {
        Market<String> market = new Market<>(); // Создаем экземпляр класса Market

        market.acceptOrder("Заказ 1"); // Принимаем заказ
        market.acceptOrder("Заказ 2"); // Принимаем еще один заказ

        System.out.println("Доставка заказа: " + market.deliverOrder()); // Отдаем заказ

        market.update(); // Обновляем состояние магазина
    }
}
