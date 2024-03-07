public class Main {
    public static void main(String[] args) {
        Cat animal = new Cat();
        Dog animal1 = new Dog();

        animal.setName("barsik");
       animal1.setName("sharik");
        animal.voice();
        animal1.voice();
        System.out.println(animal.getName());
        System.out.println(animal1.getName());
        animal.bheaivour();
        animal1.bheaivour();

    }
}
