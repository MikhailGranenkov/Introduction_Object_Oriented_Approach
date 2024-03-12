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

    public void setName(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setName'");
    }

    public String getName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }
}
