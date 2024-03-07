public class Cat extends Animal implements AnimalBehaivour {
    @Override
    public void voice() {
        System.out.println("мяу");
    }

    @Override
    public void test() {

    }

    @Override
    public void bheaivour() {
        System.out.println("Кошка охотится на мышей");

    }
}
