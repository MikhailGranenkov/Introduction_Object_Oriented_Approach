package Dz.Dz6;


// I - Принцип разделения интерфейса (Interface Segregation Principle):
// Создайте интерфейсы Driveable и Flyable. Реализуйте их в соответствующих классах Car и Airplane. Теперь классы Car и Airplane зависят только от интерфейсов, которые они используют.


public interface Driveable {
    void drive();
}

interface Flyable {
    void fly();
}

class Car implements Driveable {
    public void drive() {
        // Реализация для класса Car
    }
}

class Airplane implements Flyable {
    public void fly() {
        // Реализация для класса Airplane
    }
}
// Использование интерфейсов Driveable и Flyable позволяет классам Car и Airplane
// реализовать только те методы, которые им необходимы. Это соответствует принципу ISP:
// клиенты не должны зависеть от методов, которые они не используют.
