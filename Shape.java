public abstract class Shape {
    public abstract double getArea();
}

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }
}

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}

public abstract class Triangle extends Shape {
    protected double side1;
    protected double side2;
    protected double side3;
    protected double area;
    protected double perimeter;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        calculatePerimeter();
        calculateArea();
    }

    public void calculatePerimeter() {
        perimeter = side1 + side2 + side3;
    }

    public void calculateArea() {
        double s = perimeter / 2;
        area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public static class RightTriangle extends Triangle {
        public RightTriangle(double base, double height) {
            super(base, height, Math.sqrt(base * base + height * height));
        }
    }

    public static class EquilateralTriangle extends Triangle {
        public EquilateralTriangle(double side) {
            super(side, side, side);
        }
    }

    public static class IsoscelesTriangle extends Triangle {
        public IsoscelesTriangle(double base, double equalSide) {
            super(base, equalSide, equalSide);
        }
    }

    public static class AnyTriangle extends Triangle {
        public AnyTriangle(double side1, double side2, double side3) {
            super(side1, side2, side3);
        }
    }
}
