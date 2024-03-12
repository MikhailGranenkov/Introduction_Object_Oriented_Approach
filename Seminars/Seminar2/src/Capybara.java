public class Capybara extends Animal implements HuntingStyle{
    @Override
    public void voice() {
        System.out.println("звуки капибары");
    }

    @Override
    public void hunt() {
        System.out.println("капибара охотится на траву");
    }

    @Override
    public void hello() {

    }

    @Override
    public String toString() {
        return "Capybara{" +
                "color='" + color + '\'' +
                '}';
    }
}
