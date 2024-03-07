package Lectures.Lecture1.Ex002;


// Этот код представляет класс Program, который содержит методы для вычисления расстояния между двумя точками на плоскости.

// Метод distance(int x1, int y1, int x2, int y2):
// Этот метод принимает координаты двух точек (x1, y1) и (x2, y2) в виде четырех аргументов типа int.
// Используется формула расстояния между двумя точками на плоскости: sqrt((x2 - x1)^2 + (y2 - y1)^2).
// Для вычисления расстояния используются методы Math.sqrt и Math.pow.
// Расстояние вычисляется и возвращается в виде значения типа double.
// Метод distance(Point2D a, Point2D b):
// Этот метод принимает два объекта Point2D, представляющих точки на плоскости.
// Используется формула расстояния между двумя точками на плоскости: sqrt((a.x - b.x)^2 + (a.y - b.y)^2).
// Расстояние вычисляется и возвращается в виде значения типа double.
// Метод main:
// Создаются два объекта Point2D - точки a и b, и им присваиваются координаты.
// Координаты точек выводятся на консоль с помощью метода toString(), который возвращает строковое представление точки.
// Вызывается метод distance(a, b), чтобы вычислить расстояние между точками a и b, и результат выводится на консоль.


public class Program {
    static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    static double distance(Point2D a, Point2D b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    public static void main(String[] args) {
        Point2D a = new Point2D();
        a.x = 0;
        a.y = 2;
        System.out.println(a.toString());

        Point2D b = new Point2D();
        b.x = 0;
        b.y = 10;
        System.out.println(b.toString());
        System.out.println(distance(a, b));
        
    }
}
