import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.color = "gray";
        cat.voice();
        Capybara capybara = new Capybara();
        capybara.color = "orange";
        capybara.voice();
        Owl owl = new Owl();
        owl.voice();
        cat.hunt();
        capybara.hunt();
        owl.hunt();
        System.out.println(cat);
        System.out.println(capybara);
        cat.hello();

    }
}
