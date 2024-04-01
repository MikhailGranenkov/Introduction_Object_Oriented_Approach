package Tasks;
interface Shape{
    double calculateArea();
}
class Rectangle implements Shape{


    public double width;
    public double height;

    @Override
    public double calculateArea() {
        return width * height;
    }

}
class triangle implements Shape{
    int a;
    int b;
    int c;

    @Override
    public double calculateArea() {
        return 0;
    }
}

