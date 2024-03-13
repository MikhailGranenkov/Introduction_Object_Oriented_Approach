package Dz.Dz3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StreamService streamService = new StreamService();
        Controller controller = new Controller(streamService);

        List<Stream> streams = new ArrayList<>();
        // Добавление потоков и групп в список streams

        // Сортировка потоков
        controller.sortStreams(streams);
    }
}

