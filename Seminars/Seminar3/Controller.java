package Seminars.Seminar3;


// Задача 2 - Iterable
// Модифицировать класс УчебнаяГруппа, заставив его реализовать интерфейс Iterable
// Реализовать метод iterator() возвращающий экземпляр созданного нами итератора
// Создать класс УчебнаяГруппаСервис, добавив в него метод удаления студента по ФИО
// Создать класс Контроллер, добавив в него метод удаления студента и вызывать в нем созданный метод из УчебнаяГруппаСервис


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

// Класс УчебнаяГруппаСервис
class StudentGroupService {
    // Метод удаления студента по ФИО
    public void removeStudentByName(StudentGroup group, String name) {
        for (Iterator<Student> iterator = group.iterator(); iterator.hasNext();) {
            Student student = iterator.next();
            if (student.getName().equals(name)) {
                iterator.remove();
                return; // Выходим из метода после удаления студента
            }
        }
        // Если студент с заданным именем не найден
        System.out.println("Студент с именем " + name + " не найден.");
    }
}

// Класс Контроллер
public class Controller {
    // Метод удаления студента
    public void removeStudent(StudentGroup group, String name) {
        StudentGroupService service = new StudentGroupService();
        service.removeStudentByName(group, name);
    }

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

        // Создаем контроллер
        Controller controller = new Controller();

        // Удаляем студента по имени
        controller.removeStudent(group, "Сергей");

        // Проверяем, что студент был удален
        System.out.println("После удаления студента:");
        for (Student student : group) {
            System.out.println(student);
        }
    }
}
