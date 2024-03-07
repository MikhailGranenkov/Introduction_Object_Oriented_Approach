public class Dog extends Animal implements AnimalBehaivour{
    @Override
    public void voice() {
        System.out.println("гав");
    }

    @Override
    public void test() {

    }

    @Override
    public void bheaivour() {
        System.out.println("Собака виляет хвостом");
    }
}
