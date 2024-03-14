package Seminars.Seminar3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

// Класс Студент
class Student {
    private String firstName;
    private String lastName;
    private int id;

    // Конструктор класса Студент
    public Student(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    // Геттеры для имени, фамилии и идентификатора студента
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    // Переопределение метода toString() для удобства вывода информации о студенте
    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }
}

// Класс для сравнения студентов по ФИО
class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        // Сравниваем сначала по фамилии, затем по имени
        int lastNameComparison = s1.getLastName().compareTo(s2.getLastName());
        if (lastNameComparison != 0) {
            return lastNameComparison;
        }
        return s1.getFirstName().compareTo(s2.getFirstName());
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

    // Метод сортировки списка студентов по ФИО
    public void sortStudentsByName() {
        Collections.sort(students, new StudentComparator());
    }

    // Переопределение метода iterator() для интерфейса Iterable
    @Override
    public Iterator<Student> iterator() {
        return students.iterator();
    }
}

// Класс Управление группой студентов
public class StudentGroupManager {
    public static void main(String[] args) {
        // Создаем несколько студентов
        Student student1 = new Student("Алиса", "Иванова", 3);
        Student student2 = new Student("Сергей", "Петров", 1);
        Student student3 = new Student("Виктор", "Сидоров", 2);

        // Создаем учебную группу
        StudentGroup group = new StudentGroup();

        // Добавляем студентов в учебную группу
        group.addStudent(student1);
        group.addStudent(student2);
        group.addStudent(student3);

        // Сортируем студентов по ФИО
        group.sortStudentsByName();

        // Выводим отсортированный список студентов
        System.out.println("Отсортированный список студентов по ФИО:");
        for (Student student : group) {
            System.out.println(student);
        }
    }
}

