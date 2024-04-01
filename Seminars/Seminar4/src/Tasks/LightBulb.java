package Tasks;
interface Switchable{
     void turnOn();

     void turnOff();
}
class tv implements Switchable{
    @Override
    public void turnOn() {
        System.out.println("tv is on");
    }

    @Override
    public void turnOff() {
        System.out.println("tv is off");

    }
}

class LightBulb implements Switchable {
    public void turnOn() {
        System.out.println("bulb is on");
    }

    public void turnOff() {
        System.out.println("bulb is off");
    }
}

class Switch {
    private Switchable bulb ;

    public Switch(Switchable switchable) {
        this.bulb = switchable;

    }

    public void operate() {
        // Работа с выключателем
        bulb.turnOn();
    }

    public static void main(String[] args) {
        Switch switch1 = new Switch(new LightBulb());
        Switch switch2 = new Switch(new tv());
        switch1.operate();
        switch2.operate();

    }
}