package Lectures.Lecture1.Ex004;


// Этот код демонстрирует использование различных реализаций классов роботов Robot1, Robot2 и Robot3.

// Робот1 (Robot1):
// Код, связанный с Robot1, находится в комментариях с метками #region Robot1 demo и //#endregion.
// Показано создание объекта Robot1 с именем "name_1" и уровнем 1: Robot1 robot1 = new Robot1("name_1", 1).
// Присваивается значение переменной level объекта robot1.
// Вызываются методы startBIOS(), startOS(), sayHi(), work(), sayBye(), stopOS() и stopBIOS() объекта robot1.
// Робот2 (Robot2):
// Код, связанный с Robot2, находится в комментариях с метками #region Robo2 demo и //#endregion.
// Показано создание объекта Robot2 с именем "name_2" и уровнем 1: Robot2 robot2 = new Robot2("name_2", 1).
// Выводится имя и уровень робота2 с помощью методов getName() и getLevel().
// Вызывается метод work() объекта robot2 несколько раз, а затем вызывается метод powerOff().
// Робот3 (Robot3):
// Код, связанный с Robot3, находится в комментариях с метками #region Robo3 demo и //#endregion.
// Показано создание объекта Robot3 с именем "name_3": Robot3 robot3 = new Robot3("name_3").
// Выводится строка "-------------".
// Выводится информация о роботе с помощью метода toString().
// Вызывается метод power(), work() несколько раз и снова вызывается метод power().
// Этот код представляет простой пример использования объектов различных классов роботов и их методов. Каждый класс робота имеет свои уникальные свойства и методы, которые могут быть использованы в различных сценариях.


public class Program {
    public static void main(String[] args) {
        // #region Robot1 demo

        //  Robot1 robot1 = new Robot1("name_1", 1)
        

        // robot1.level = 100500;
        // System.out.printf("%s %d\n", robot1.name, robot1.level);

         
        // //#endregion
       
        // // #region processing

        // robot1.startBIOS();
        // robot1.startOS();
        // robot1.sayHi();

        // robot1.work();

        // robot1.sayBye();
        // robot1.stopOS();
        // robot1.stopBIOS();

        // // #endregion

        System.out.println();
        // #endregion

        // #region Robo2 demo

        // Robot2 robot2 = new Robot2("name_2", 1);

        // System.out.printf("%s %d\n", 
        // robot2.getName(), robot2.getLevel());
        
        // robot2.work();
        // robot2.work();
        // robot2.work();
        // robot2.powerOff();

        // #endregion

        //#region Robo3 demo

        Robot3 robot3 = new Robot3("name_3");
        System.out.println("-------------");
        System.out.println(robot3);
        robot3.power();
        robot3.work();
        robot3.power();
        robot3.work();

        robot3.power();
        
        //#endregion
    }

}
