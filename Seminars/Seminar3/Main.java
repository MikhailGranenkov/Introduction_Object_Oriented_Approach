package Seminars.Seminar3;


// Задача 1 - Iterator
// Создать класс Студент
// Создать класс УчебнаяГруппа
// Создать класс УчебнаяГруппаИтератор, заставив его реализовать интерфейс Iterator
// Реализовать его контракты (включая удаление)


import java.util.ArrayList;
import java.util.Iterator;

// Класс Студент
class Student {
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

    // Переопределение метода iterator() для интерфейса Iterable
    @Override
    public Iterator<Student> iterator() {
        return students.iterator();
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаем несколько студентов
        Student student1 = new Student("Алиса", 1);
        Student student2 = new Student("Сергей", 2);
        Student student3 = new Student("Виктор", 3);

        // Создаем учебную группу
        StudentGroup group = new StudentGroup();

        // Добавляем студентов в учебную группу
        group.addStudent(student1);
        group.addStudent(student2);
        group.addStudent(student3);

        // Проверяем итерацию через учебную группу
        Iterator<Student> iterator = group.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Удаляем одного студента
        iterator = group.iterator();
        if (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }

        // Проверяем, что студент был удален
        System.out.println("После удаления одного студента:");
        for (Student student : group) {
            System.out.println(student);
        }
    }
}