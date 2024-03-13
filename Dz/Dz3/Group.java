package Dz.Dz3;

// Создать класс Поток содержащий в себе список УчебныхГрупп и реализующий интерфейс Iterator
// Создать класс StreamComparator, реализующий сравнение количества групп входящих в Поток
// Создать класс ПотокСервис, добавив в него метод сортировки списка потоков, используя созданный StreamComparator
// Модифицировать класс Контроллер, добавив в него созданный сервис
// Модифицировать класс Контроллер, добавив в него метод сортирующий список потоков, путем вызова созданного сервиса


// Group - это класс, представляющий учебную группу. Он может содержать любую информацию о группе.
// Stream - это класс, представляющий поток, который содержит список учебных групп. Он реализует интерфейс Iterable<Group>, чтобы его можно было использовать в цикле foreach.
// StreamComparator - это класс, который реализует интерфейс Comparator<Stream>, чтобы потоки можно было сравнивать между собой по количеству групп. Он сравнивает потоки по их размеру (количеству групп).
// StreamService - это класс, содержащий методы для работы с потоками. В данном случае, он содержит метод для сортировки списка потоков с использованием StreamComparator.
// Controller - это класс, который использует StreamService для работы с потоками. Он содержит метод для сортировки списка потоков.


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Класс, представляющий учебную группу
class Group {
    // Допустим, здесь содержится информация о группе
}

// Класс, представляющий поток, содержащий список учебных групп
class Stream implements Iterable<Group> {
    List<Group> groups; // Список учебных групп

    public Stream(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public Iterator<Group> iterator() {
        return groups.iterator();
    }
}

// Класс, реализующий сравнение количества групп в потоке
class StreamComparator implements java.util.Comparator<Stream> {
    @Override
    public int compare(Stream stream1, Stream stream2) {
        return Integer.compare(stream1.groups.size(), stream2.groups.size());
    }
}

// Класс сервиса для работы с потоками
class StreamService {
    // Метод для сортировки списка потоков с использованием StreamComparator
    public void sortStreams(List<Stream> streams) {
        streams.sort(new StreamComparator());
    }
}

// Класс контроллера, который использует сервис для работы с потоками
class Controller {
    private StreamService streamService; // Сервис для работы с потоками

    public Controller(StreamService streamService) {
        this.streamService = streamService;
    }

    // Метод для сортировки списка потоков
    public void sortStreams(List<Stream> streams) {
        streamService.sortStreams(streams);
    }
}

