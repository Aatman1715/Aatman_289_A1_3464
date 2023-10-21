import java.util.Scanner;
class Point {
    private double x;
    private double y;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}

class Circle {
    private double radius;
    private Point center;

    public Circle(double radius, Point center) {
        this.radius = radius;
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double surface() {
        return Math.PI * radius * radius;
    }

    public boolean isInternal(double x, double y) {
        double distance = Math.sqrt(Math.pow(x - center.getX(), 2) + Math.pow(y - center.getY(), 2));
        return distance <= radius;
    }
}

public class Exercise_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Circle[] circles = new Circle[3];


        for (int i = 0; i < circles.length; i++) {
            System.out.println("Enter the radius for Circle " + (i + 1) + ":");
            double radius = scanner.nextDouble();
            System.out.println("Enter the x-coordinate for the center of Circle " + (i + 1) + ":");
            double centerX = scanner.nextDouble();
            System.out.println("Enter the y-coordinate for the center of Circle " + (i + 1) + ":");
            double centerY = scanner.nextDouble();
            circles[i] = new Circle(radius, new Point(centerX, centerY));
        }

        System.out.println("Enter the x-coordinate of a point:");
        double xCoord = scanner.nextDouble();
        System.out.println("Enter the y-coordinate of a point:");
        double yCoord = scanner.nextDouble();


        for (int i = 0; i < circles.length; i++) {
            Circle circle = circles[i];
            boolean isInside = circle.isInternal(xCoord, yCoord);
            double surface = circle.surface();
            String location = isInside ? "inside" : "outside";
            System.out.println("Point (" + xCoord + ", " + yCoord + ") is " + location + " Circle " + (i + 1));
            System.out.println("Surface of Circle " + (i + 1) + ": " + surface);
        }
    }
}
