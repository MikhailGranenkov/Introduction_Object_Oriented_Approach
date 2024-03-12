package Seminars.Seminar2.Task1;


public class Human extends Actor implements ActorBehavior {
    private String job;

    public Human(String name, String job) {
        super(name);
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    @Override
    public void makeOrder() {
        if (isReadyToOrder()) {
            System.out.println(getName() + " is making an order.");
        } else {
            System.out.println(getName() + " is not ready to make an order.");
        }
    }

    @Override
    public void receiveOrder() {
        if (isOrderReceived()) {
            System.out.println(getName() + " has received the order.");
        } else {
            System.out.println(getName() + " has not received the order yet.");
        }
    }
}