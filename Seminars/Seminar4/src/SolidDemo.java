// Пример классов, демонстрирующих SOLID

// Принцип единственной ответственности (SRP)
class Animal {
    private String name;
    private double weight;

    public Animal(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    // Геттеры и сеттеры для name и weight
}

class AnimalDatabase {
    public void saveAnimal(Animal animal) {
        // Сохранение данных животного в базу данных
    }
}

// Принцип открытости/закрытости (OCP)
interface Movable {
    void move();
}

class Dog extends Animal implements Movable {
    public Dog(String name, double weight) {
        super(name, weight);
    }

    @Override
    public void move() {
        // Реализация движения собаки
    }
}

class Bird extends Animal implements Movable {
    public Bird(String name, double weight) {
        super(name, weight);
    }

    @Override
    public void move() {
        // Реализация полета птицы
    }
}

// Принцип подстановки Барбары Лисков (LSP)
class Penguin extends Bird {
    public Penguin(String name, double weight) {
        super(name, weight);
    }

    // Пингвины не летают, поэтому метод move() не переопределяется
}

// Принцип разделения интерфейса (ISP)
interface Eatable {
    void eat();
}

class Bear extends Animal implements Eatable, Movable {
    public Bear(String name, double weight) {
        super(name, weight);
    }

    @Override
    public void move() {
        // Реализация движения медведя
    }

    @Override
    public void eat() {
        // Реализация приема пищи медведем
    }
}

public class SolidDemo {
    public static void main(String[] args) {
        AnimalDatabase database = new AnimalDatabase();

        Animal dog = new Dog("Rex", 20.5);
        database.saveAnimal(dog);

        Animal penguin = new Penguin("Tux", 10.2);
        // Также можно сохранить пингвина в базу данных

        Animal bear = new Bear("Baloo", 200);
        database.saveAnimal(bear);
    }
}