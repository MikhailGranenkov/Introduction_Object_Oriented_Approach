// Decorator Pattern
interface Shape {
    void draw();
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle.");
    }
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle.");
    }
}

class ShapeDecorator implements Shape {
    protected Shape shape;

    public ShapeDecorator(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw() {
        shape.draw();
    }
}

class RedShapeDecorator extends ShapeDecorator {
    public RedShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("Adding red color.");
    }
}

// Factory Pattern
class ShapeFactory {
    public static Shape createShape(String type) {
        if (type.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        } else if (type.equalsIgnoreCase("circle")) {
            return new Circle();
        }
        return null;
    }
}

// Adapter Pattern
class LegacyRectangle {
    private int width;
    private int height;

    public LegacyRectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

class RectangleAdapter implements Shape {
    private LegacyRectangle legacyRectangle;

    public RectangleAdapter(LegacyRectangle legacyRectangle) {
        this.legacyRectangle = legacyRectangle;
    }

    @Override
    public void draw() {
        System.out.println("Drawing an adapted rectangle.");
    }
}

public class Main {
    public static void main(String[] args) {
        // Decorator Pattern
        Shape rectangle = new Rectangle();
        Shape redRectangle = new RedShapeDecorator(new Rectangle());

        rectangle.draw();
        redRectangle.draw();

        // Factory Pattern
        Shape circle = ShapeFactory.createShape("rectangle");
        circle.draw();

        // Adapter Pattern
        LegacyRectangle legacyRectangle = new LegacyRectangle(5, 7);
        Shape adaptedRectangle = new RectangleAdapter(legacyRectangle);
        adaptedRectangle.draw();

    }
}