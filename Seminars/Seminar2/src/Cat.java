import java.io.Serializable;

public class Cat extends Animal implements HuntingStyle, Serializable {
    public Cat(String color){
        this.color = color;
    }

    public Cat() {
    }

    @Override
    public void voice() {
        System.out.println("мяу");
    }

    @Override
    public void hunt() {
        System.out.println("кошка охотится на корм");
    }



    @Override
    public String toString() {
        return "Cat{" +
                "color='" + color + '\'' +
                '}';
    }

    public void setName(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setName'");
    }

    public char[] getName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }

    public void bheaivour() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bheaivour'");
    }
}
