package Dz.Dz6;


// L - Принцип подстановки Барбары Лисков (Liskov Substitution Principle):
// Создайте класс Square, который наследуется от класса Rectangle. Убедитесь, что все методы, работающие с Rectangle, также корректно работают с Square, не изменяя их поведения.


public class Rectangle {
    protected int width;
    protected int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int area() {
        return width * height;
    }
}

class Square extends Rectangle {
    public Square(int sideLength) {
        super(sideLength, sideLength);
    }
    
    // Здесь нет необходимости переопределять метод area(),
    // так как он уже определен в базовом классе Rectangle и корректно работает для квадрата.
    // Это демонстрирует соблюдение принципа LSP: поведение наследника (Square) не должно изменяться
    // относительно поведения базового класса (Rectangle).
}
