package Dz.Dz5;


// Создать класс УчебнаяГруппа содержащая в себе поля Преподаватель и список Студентов
// Создать класс УчебнаяГруппаСервис, в котором реализована функция(входные параметры - (Teacher, List<Strudent>)) формирования из Студентов и Преподавателя УчебнойГруппы и возвращения его
// Создать метод в Контроллере, в котором формируется учебная группа, путем вызова метода из сервиса
// Все вышеуказанное создать согласно принципам ООП пройдённым на семинаре


import java.util.List;

// Класс, представляющий преподавателя
public class Teacher {
    private String name; // Имя преподавателя

    // Конструктор класса Teacher
    public Teacher(String name) {
        this.name = name;
    }

    // Геттер для имени преподавателя
    public String getName() {
        return name;
    }
}

// Класс, представляющий студента
class Student {
    private String name; // Имя студента

    // Конструктор класса Student
    public Student(String name) {
        this.name = name;
    }

    // Геттер для имени студента
    public String getName() {
        return name;
    }
}

// Класс, представляющий учебную группу
class StudyGroup {
    private Teacher teacher; // Преподаватель
    private List<Student> students; // Список студентов

    // Конструктор класса StudyGroup
    public StudyGroup(Teacher teacher, List<Student> students) {
        this.teacher = teacher;
        this.students = students;
    }

    // Геттер для преподавателя
    public Teacher getTeacher() {
        return teacher;
    }

    // Геттер для списка студентов
    public List<Student> getStudents() {
        return students;
    }
}

// Класс, представляющий сервис для работы с учебными группами
class StudyGroupService {
    // Метод для формирования учебной группы из преподавателя и списка студентов
    public StudyGroup formStudyGroup(Teacher teacher, List<Student> students) {
        return new StudyGroup(teacher, students);
    }
}

// Класс, представляющий контроллер
class Controller {
    private StudyGroupService studyGroupService; // Сервис учебных групп

    // Конструктор класса Controller
    public Controller() {
        this.studyGroupService = new StudyGroupService();
    }

    // Метод для создания учебной группы, вызывая метод формирования учебной группы из сервиса
    public StudyGroup createStudyGroup(Teacher teacher, List<Student> students) {
        return studyGroupService.formStudyGroup(teacher, students);
    }
}

// Основной класс программы
class Main {
    public static void main(String[] args) {
        // Пример использования классов

        // Создаем преподавателя
        Teacher teacher = new Teacher("Иван Иванов");

        // Создаем список студентов
        List<Student> students = List.of(
            new Student("Алексей"),
            new Student("Екатерина"),
            new Student("Михаил")
        );

        // Создаем контроллер
        Controller controller = new Controller();

        // Формируем учебную группу
        StudyGroup studyGroup = controller.createStudyGroup(teacher, students);

        // Выводим информацию о созданной учебной группе
        System.out.println("Преподаватель: " + studyGroup.getTeacher().getName());
        System.out.println("Студенты:");
        for (Student student : studyGroup.getStudents()) {
            System.out.println(student.getName());
        }
    }
}


// Teacher представляет преподавателя.
// Student представляет студента.
// StudyGroup представляет учебную группу и содержит поля для преподавателя и списка студентов.
// StudyGroupService предоставляет метод formStudyGroup(), который принимает преподавателя и список студентов и создает объект учебной группы.
// Controller имеет метод createStudyGroup(), который вызывает метод formStudyGroup() из StudyGroupService для формирования учебной группы.
// Main содержит пример использования контроллера для создания учебной группы и вывода информации о ней.