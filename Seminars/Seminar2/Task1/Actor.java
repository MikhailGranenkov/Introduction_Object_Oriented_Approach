package Seminars.Seminar2.Task1;


public abstract class Actor {
    private String name;
    private boolean readyToOrder;
    private boolean orderReceived;

    public Actor(String name) {
        this.name = name;
        this.readyToOrder = false;
        this.orderReceived = false;
    }

    public String getName() {
        return name;
    }

    public boolean isReadyToOrder() {
        return readyToOrder;
    }

    public void setReadyToOrder(boolean readyToOrder) {
        this.readyToOrder = readyToOrder;
    }

    public boolean isOrderReceived() {
        return orderReceived;
    }

    public void setOrderReceived(boolean orderReceived) {
        this.orderReceived = orderReceived;
    }
}