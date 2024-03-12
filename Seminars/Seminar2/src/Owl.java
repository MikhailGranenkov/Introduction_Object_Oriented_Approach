public class Owl extends Animal implements HuntingStyle{
    @Override
    public void voice() {
        System.out.println("звуки совы");
    }

    @Override
    public void hunt() {
        System.out.println("сова охотится на мышей");
    }

    @Override
    public void hello() {
        System.out.println("сова говорит привет!");
    }
    public void hello(String name){
        System.out.println("привет " + name);

    }

}
