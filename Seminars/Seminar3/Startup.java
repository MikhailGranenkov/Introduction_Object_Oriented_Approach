package Seminars.Seminar3;


// Задача 3 - Comparable
// Модифицировать класс Студент, заставив его реализовать интерфейс Comparable
// Реализовать контракт compareTo () со сравнением по какому-либо параметру (пример studentId)
// Модифицировать класс УчебнаяГруппаСервис, добавив в него метод сортировки списка студентов по id
// Модифицировать класс Контроллер, добавив в него метод сортировки списка студентов по id и вызывать в нем созданный метод из УчебнаяГруппаСервис


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

// Класс Студент, реализующий интерфейс Comparable
class Student implements Comparable<Student> {
    private String name;
    private int id;

    // Конструктор класса Студент
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Геттеры для имени и идентификатора студента
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // Переопределение метода toString() для удобства вывода информации о студенте
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    // Реализация метода compareTo() для сравнения по id
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.id, other.id);
    }
}

// Класс УчебнаяГруппа
class StudentGroup implements Iterable<Student> {
    private ArrayList<Student> students;

    // Конструктор класса УчебнаяГруппа
    public StudentGroup() {
        students = new ArrayList<>();
    }

    // Метод добавления студента в группу
    public void addStudent(Student student) {
        students.add(student);
    }

    // Метод удаления студента из группы
    public void removeStudent(Student student) {
        students.remove(student);
    }

    // Метод сортировки списка студентов по id
    public void sortStudentsById() {
        Collections.sort(students);
    }

    // Переопределение метода iterator() для интерфейса Iterable
    @Override
    public Iterator<Student> iterator() {
        return students.iterator();
    }
}

// Класс Стартап (другой public class)
public class Startup {
    public static void main(String[] args) {
        // Создаем несколько студентов
        Student student1 = new Student("Алиса", 3);
        Student student2 = new Student("Сергей", 1);
        Student student3 = new Student("Виктор", 2);

        // Создаем учебную группу
        StudentGroup group = new StudentGroup();

        // Добавляем студентов в учебную группу
        group.addStudent(student1);
        group.addStudent(student2);
        group.addStudent(student3);

        // Сортируем студентов по id
        group.sortStudentsById();

        // Выводим отсортированный список студентов
        System.out.println("Отсортированный список студентов по id:");
        for (Student student : group) {
            System.out.println(student);
        }
    }
}
