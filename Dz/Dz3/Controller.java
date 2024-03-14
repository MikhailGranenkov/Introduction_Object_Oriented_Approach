package Dz.Dz3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

// Класс УчебнаяГруппа
class StudentGroup {
    private String name;

    // Конструктор класса УчебнаяГруппа
    public StudentGroup(String name) {
        this.name = name;
    }

    // Геттер для имени учебной группы
    public String getName() {
        return name;
    }
}

// Класс Поток, содержащий в себе список УчебныхГрупп и реализующий интерфейс Iterator
class Stream implements Iterator<StudentGroup> {
    ArrayList<StudentGroup> groups;
    private int index = 0;

    // Конструктор класса Поток
    public Stream(ArrayList<StudentGroup> groups) {
        this.groups = groups;
    }

    // Реализация метода hasNext() интерфейса Iterator
    @Override
    public boolean hasNext() {
        return index < groups.size();
    }

    // Реализация метода next() интерфейса Iterator
    @Override
    public StudentGroup next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException("Нет больше групп в потоке");
        }
        return groups.get(index++);
    }

    // Метод удаления группы из потока (не поддерживается)
    @Override
    public void remove() {
        throw new UnsupportedOperationException("Операция удаления не поддерживается");
    }
}

// Класс StreamComparator, реализующий сравнение количества групп входящих в Поток
class StreamComparator implements Comparator<Stream> {
    @Override
    public int compare(Stream s1, Stream s2) {
        return Integer.compare(s1.groups.size(), s2.groups.size());
    }
}

// Класс ПотокСервис, содержащий метод сортировки списка потоков
class StreamService {
    // Метод сортировки списка потоков по количеству групп
    public void sortStreams(ArrayList<Stream> streams) {
        Collections.sort(streams, new StreamComparator());
    }
}

// Класс Контроллер
public class Controller {
    // Метод сортировки списка потоков
    public void sortStreams(ArrayList<Stream> streams) {
        StreamService service = new StreamService();
        service.sortStreams(streams);
    }

    public static void main(String[] args) {
        // Создаем несколько учебных групп
        StudentGroup group1 = new StudentGroup("Группа 1");
        StudentGroup group2 = new StudentGroup("Группа 2");
        StudentGroup group3 = new StudentGroup("Группа 3");

        // Создаем потоки и добавляем в них группы
        ArrayList<Stream> streams = new ArrayList<>();
        Stream stream1 = new Stream(new ArrayList<>(Collections.singletonList(group1)));
        Stream stream2 = new Stream(new ArrayList<>(Collections.singletonList(group2)));
        Stream stream3 = new Stream(new ArrayList<>(Collections.singletonList(group3)));

        streams.add(stream1);
        streams.add(stream2);
        streams.add(stream3);

        // Создаем контроллер
        Controller controller = new Controller();

        // Сортируем потоки по количеству групп
        controller.sortStreams(streams);

        // Выводим отсортированный список потоков
        System.out.println("Отсортированный список потоков:");
        for (Stream stream : streams) {
            System.out.println("Поток:");
            while (stream.hasNext()) {
                System.out.println("  - " + stream.next().getName());
            }
        }
    }
}

