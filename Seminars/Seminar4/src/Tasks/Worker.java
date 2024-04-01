package Tasks;

interface Worker {
    void work();

}
interface Eatable{
    void eat();
}

class Engineer implements Worker, Eatable {
    public void work() {
        // Реализация работы инженера
    }

    public void eat() {
        // Реализация приема пищи
    }
}