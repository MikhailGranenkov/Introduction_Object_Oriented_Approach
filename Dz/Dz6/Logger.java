package Dz.Dz6;


// D - Принцип инверсии зависимостей (Dependency Inversion Principle):
// Создайте абстракцию Logger, которая будет иметь методы для логирования различных типов сообщений. Затем создайте классы FileLogger и DatabaseLogger, реализующие эту абстракцию. Теперь классы, которые требуют логирования, будут зависеть только от Logger, а не от конкретных реализаций.


public interface Logger {
    void log(String message);
}

class FileLogger implements Logger {
    public void log(String message) {
        // Логирование в файл
    }
}

class DatabaseLogger implements Logger {
    public void log(String message) {
        // Логирование в базу данных
    }
}
// Создание абстракции Logger и реализация конкретных логгеров (FileLogger и DatabaseLogger)
// позволяет классам, требующим логирования, зависеть только от абстракции Logger,
// а не от конкретных реализаций логгеров. Это соответствует принципу DIP:
// модули высокого уровня не должны зависеть от модулей низкого уровня;
// оба должны зависеть от абстракций.
