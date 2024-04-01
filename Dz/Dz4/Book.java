package Dz.Dz4;


// Создайте обобщенный класс Book<T>, который представляет книгу в библиотеке. Каждая книга должна содержать параметр типа T для ее названия.
// Создайте обобщенный класс LibraryCard<K, V>, который представляет библиотечную карточку для определенной книги. Каждая карточка должна содержать параметры типов K для номера карточки и V для информации о книге.
// Создайте класс Library, который будет представлять библиотеку. У этого класса должны быть методы для добавления книг и выдачи библиотечных карточек.
// Добавьте метод для вывода информации о всех выданных книгах с их библиотечными карточками.


import java.util.HashMap;
import java.util.Map;

// Класс, представляющий книгу в библиотеке
public class Book<T> {
    private T title; // Параметр типа T для названия книги

    // Конструктор класса Book
    public Book(T title) {
        this.title = title;
    }

    // Метод для получения названия книги
    public T getTitle() {
        return title;
    }
}

// Класс, представляющий библиотечную карточку для определенной книги
class LibraryCard<K, V> {
    private K cardNumber; // Параметр типа K для номера карточки
    private V bookInfo;    // Параметр типа V для информации о книге

    // Конструктор класса LibraryCard
    public LibraryCard(K cardNumber, V bookInfo) {
        this.cardNumber = cardNumber;
        this.bookInfo = bookInfo;
    }

    // Метод для получения номера карточки
    public K getCardNumber() {
        return cardNumber;
    }

    // Метод для получения информации о книге
    public V getBookInfo() {
        return bookInfo;
    }
}

// Класс, представляющий библиотеку
class Library {
    private Map<LibraryCard<Integer, Book<String>>, Boolean> issuedBooks; // Хранение информации о книгах и их статусе

    // Конструктор класса Library
    public Library() {
        this.issuedBooks = new HashMap<>();
    }

    // Метод для добавления книги в библиотеку
    public void addBook(Book<String> book) {
        // Создание карточки для книги с уникальным номером
        LibraryCard<Integer, Book<String>> libraryCard = new LibraryCard<>(issuedBooks.size() + 1, book);
        // Добавление карточки в коллекцию выданных книг с начальным статусом false (не выдана)
        issuedBooks.put(libraryCard, false);
    }

    // Метод для выдачи книги по номеру карточки
    public LibraryCard<Integer, Book<String>> issueBook(int cardNumber) {
        // Проверка каждой карточки в коллекции
        for (LibraryCard<Integer, Book<String>> libraryCard : issuedBooks.keySet()) {
            // Если номер карточки совпадает и книга не выдана, выдать книгу и пометить как выданную
            if (libraryCard.getCardNumber() == cardNumber && !issuedBooks.get(libraryCard)) {
                issuedBooks.put(libraryCard, true);
                return libraryCard;
            }
        }
        // Если книга не найдена или уже выдана, вернуть null
        return null;
    }

    // Метод для вывода информации о всех выданных книгах
    public void printIssuedBooks() {
        System.out.println("Issued Books:");
        for (Map.Entry<LibraryCard<Integer, Book<String>>, Boolean> entry : issuedBooks.entrySet()) {
            if (entry.getValue()) {
                LibraryCard<Integer, Book<String>> libraryCard = entry.getKey();
                Book<String> book = libraryCard.getBookInfo();
                System.out.println("Card Number: " + libraryCard.getCardNumber() + ", Book Title: " + book.getTitle());
            }
        }
    }
}

// Основной класс программы
class Main {
    public static void main(String[] args) {
        // Создание объекта библиотеки
        Library library = new Library();

        // Создание книг
        Book<String> book1 = new Book<>("Java Programming");
        Book<String> book2 = new Book<>("Data Structures and Algorithms");

        // Добавление книг в библиотеку
        library.addBook(book1);
        library.addBook(book2);

        // Выдача книги и получение карточки для каждой книги
        LibraryCard<Integer, Book<String>> card1 = library.issueBook(1);
        LibraryCard<Integer, Book<String>> card2 = library.issueBook(2);

        // Вывод информации о выданных книгах
        library.printIssuedBooks();
    }
}

