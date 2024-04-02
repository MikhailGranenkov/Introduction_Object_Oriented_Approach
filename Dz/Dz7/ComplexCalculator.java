package Dz.Dz7;


// Создать проект калькулятора комплексных чисел (достаточно сделать сложение, умножение и деление).
// Применить при создании программы архитектурные паттерны, добавить логирование калькулятора.
// Соблюдать принципы SOLID, паттерны проектирования.


import java.util.logging.Logger;

// Комплексное число
class ComplexNumber {
    private double real; // Действительная часть комплексного числа
    private double imaginary; // Мнимая часть комплексного числа

    // Конструктор комплексного числа
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Геттер для действительной части
    public double getReal() {
        return real;
    }

    // Геттер для мнимой части
    public double getImaginary() {
        return imaginary;
    }

    // Метод для сложения комплексных чисел
    public ComplexNumber add(ComplexNumber num) {
        return new ComplexNumber(this.real + num.getReal(), this.imaginary + num.getImaginary());
    }

    // Метод для умножения комплексных чисел
    public ComplexNumber multiply(ComplexNumber num) {
        double realPart = this.real * num.getReal() - this.imaginary * num.getImaginary();
        double imaginaryPart = this.real * num.getImaginary() + this.imaginary * num.getReal();
        return new ComplexNumber(realPart, imaginaryPart);
    }

    // Метод для деления комплексных чисел
    public ComplexNumber divide(ComplexNumber num) {
        double denominator = num.getReal() * num.getReal() + num.getImaginary() * num.getImaginary();
        double realPart = (this.real * num.getReal() + this.imaginary * num.getImaginary()) / denominator;
        double imaginaryPart = (this.imaginary * num.getReal() - this.real * num.getImaginary()) / denominator;
        return new ComplexNumber(realPart, imaginaryPart);
    }
}

// Фабрика комплексных чисел
class ComplexNumberFactory {
    public static ComplexNumber createComplexNumber(double real, double imaginary) {
        return new ComplexNumber(real, imaginary);
    }
}

// Интерфейс для операций
interface Operation {
    ComplexNumber execute(ComplexNumber num1, ComplexNumber num2);
}

// Реализация сложения
class Addition implements Operation {
    @Override
    public ComplexNumber execute(ComplexNumber num1, ComplexNumber num2) {
        return num1.add(num2);
    }
}

// Реализация умножения
class Multiplication implements Operation {
    @Override
    public ComplexNumber execute(ComplexNumber num1, ComplexNumber num2) {
        return num1.multiply(num2);
    }
}

// Реализация деления
class Division implements Operation {
    @Override
    public ComplexNumber execute(ComplexNumber num1, ComplexNumber num2) {
        return num1.divide(num2);
    }
}

// Калькулятор комплексных чисел
public class ComplexCalculator {
    private Logger logger;

    // Конструктор калькулятора
    public ComplexCalculator(Logger logger) {
        this.logger = logger;
    }

    // Метод для выполнения операции над комплексными числами
    public ComplexNumber calculate(ComplexNumber num1, ComplexNumber num2, Operation operation) {
        // Выполнение операции
        ComplexNumber result = operation.execute(num1, num2);
        // Логирование операции и результата
        logger.info("Operation: " + operation.getClass().getSimpleName() +
                ", Result: " + result.getReal() + " + " + result.getImaginary() + "i");
        return result;
    }
}

class Main {
    public static void main(String[] args) {
        // Создание логгера
        Logger logger = Logger.getLogger("CalculatorLogger");
        // Создание экземпляра калькулятора
        ComplexCalculator calculator = new ComplexCalculator(logger);

        // Создание комплексных чисел
        ComplexNumber num1 = ComplexNumberFactory.createComplexNumber(2, 3);
        ComplexNumber num2 = ComplexNumberFactory.createComplexNumber(1, 2);

        // Создание операций
        Operation addition = new Addition();
        Operation multiplication = new Multiplication();
        Operation division = new Division();

        // Выполнение операций с использованием калькулятора
        calculator.calculate(num1, num2, addition);
        calculator.calculate(num1, num2, multiplication);
        calculator.calculate(num1, num2, division);
    }
}
