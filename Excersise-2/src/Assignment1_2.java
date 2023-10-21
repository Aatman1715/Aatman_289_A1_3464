import java.util.Scanner;
class Point1{
    private double x,y;
    public Point1(double x,double y){
        this.x = x;
        this.y = y;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
}
class Quadrilateral{
    private Point1[] vertices;
    private String type;
    public Quadrilateral(Point1[] vertices){
        this.vertices = vertices;
        calculateType();
    }
    private double calculateDistance(Point1 p1, Point1 p2){
        return Math.sqrt(Math.pow(p1.getX() - p2.getX(),2) + Math.pow(p1.getY() - p2.getY(),2));
    }
    private void calculateType(){
        double[] distances = new double[4];
        for(int i=0; i<4; i++){
            distances[i] = calculateDistance(vertices[i], vertices[(i + 1) % 4]);
        }
        boolean isParallelogram = (distances[0] == distances[2] && distances[1] == distances[3]) ||
                (distances[0] == distances[1] && distances[2] == distances[3]);
        boolean isRectangle = isParallelogram && (distances[0] == distances[2]);
        boolean isRhombus = (distances[0] == distances[1] && distances[1] == distances[2] && distances[2] == distances[3]);
        boolean isSquare = isRectangle && isRhombus;
        if (isSquare) {
            type = "Square";
        } else if (isRectangle) {
            type = "Rectangle";
        } else if (isRhombus) {
            type = "Rhombus";
        } else if (isParallelogram) {
            type = "Parallelogram";
        } else {
            type = "Unknown";
        }
    }
    public String getType() {
        return type;
    }
    public double calculatePerimeter() {
        double perimeter = 0;
        for (int i = 0; i < 4; i++) {
            perimeter += calculateDistance(vertices[i], vertices[(i + 1) % 4]);
        }
        return perimeter;
    }
    public boolean isPointInside(Point1 point) {
        // Assuming quadrilateral is convex
        double crossProduct1 = (vertices[1].getX() - vertices[0].getX()) * (point.getY() - vertices[0].getY()) -
                (vertices[1].getY() - vertices[0].getY()) * (point.getX() - vertices[0].getX());
        double crossProduct2 = (vertices[2].getX() - vertices[1].getX()) * (point.getY() - vertices[1].getY()) -
                (vertices[2].getY() - vertices[1].getY()) * (point.getX() - vertices[1].getX());
        double crossProduct3 = (vertices[3].getX() - vertices[2].getX()) * (point.getY() - vertices[2].getY()) -
                (vertices[3].getY() - vertices[2].getY()) * (point.getX() - vertices[2].getX());
        double crossProduct4 = (vertices[0].getX() - vertices[3].getX()) * (point.getY() - vertices[3].getY()) -
                (vertices[0].getY() - vertices[3].getY()) * (point.getX() - vertices[3].getX());

        return (crossProduct1 >= 0 && crossProduct2 >= 0 && crossProduct3 >= 0 && crossProduct4 >= 0) ||
                (crossProduct1 <= 0 && crossProduct2 <= 0 && crossProduct3 <= 0 && crossProduct4 <= 0);
    }
}
public class Assignment1_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of quadrilaterals: ");
        int numQuadrilaterals = scanner.nextInt();
        Quadrilateral[] quadrilaterals = new Quadrilateral[numQuadrilaterals];

        for (int i = 0; i < numQuadrilaterals; i++) {
            Point1[] vertices = new Point1[4];
            System.out.println("Enter coordinates for Quadrilateral " + (i + 1) + ":");
            for (int j = 0; j < 4; j++) {
                System.out.print("Enter x-coordinate for vertex " + (j + 1) + ": ");
                double x = scanner.nextDouble();
                System.out.print("Enter y-coordinate for vertex " + (j + 1) + ": ");
                double y = scanner.nextDouble();
                vertices[j] = new Point1(x, y);
            }
            quadrilaterals[i] = new Quadrilateral(vertices);
        }

        System.out.println("\nQuadrilaterals Information:");
        for (int i = 0; i < numQuadrilaterals; i++) {
            System.out.println("Quadrilateral " + (i + 1) + ":");
            System.out.println("Type: " + quadrilaterals[i].getType());
            System.out.println("Perimeter: " + quadrilaterals[i].calculatePerimeter());

            // Check if a point is inside the quadrilateral
            System.out.print("Enter x-coordinate of the point to check: ");
            double x = scanner.nextDouble();
            System.out.print("Enter y-coordinate of the point to check: ");
            double y = scanner.nextDouble();
            Point1 point = new Point1(x, y);
            if (quadrilaterals[i].isPointInside(point)) {
                System.out.println("The point is inside the quadrilateral.");
            } else {
                System.out.println("The point is outside the quadrilateral.");
            }
        }
    }
}