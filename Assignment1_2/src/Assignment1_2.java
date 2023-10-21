import java.util.Scanner;
class Point {
    double x, y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double distanceTo(Point other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
}
class Triangle {
    Point p1, p2, p3;
    Triangle(Point p1, Point p2, Point p3){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }
    double calculatePerimeter(){
        double side1 = p1.distanceTo(p2);
        double side2 = p2.distanceTo(p3);
        double side3 = p3.distanceTo(p1);
        return side1 + side2 + side3;
    }
    String classifyTriangle(){
        double side1 = p1.distanceTo(p2);
        double side2 = p2.distanceTo(p3);
        double side3 = p3.distanceTo(p1);
        if(side1 == side2 && side2 == side3){
            return "Equilateral";
        }
        else if(side1 == side2 || side2 == side3 || side3 == side1){
            return "Isosceles";
        }
        else{
            return "Unknown";
        }
    }
    boolean isPointInside(Point point){
        double area = 0.5 * Math.abs((p1.x * (p2.y - p3.y) + p2.x * (p3.y - p1.y) + p3.x * (p1.y - p2.y)));
        double subArea1 = 0.5 * Math.abs((point.x * (p2.y - p3.y) + p2.x * (p3.y - point.y) + p3.x * (point.y - p2.y)));
        double subArea2 = 0.5 * Math.abs((p1.x * (point.y - p3.y) + point.x * (p3.y - p1.y) + p3.x * (p1.y - point.y)));
        double subArea3 = 0.5 * Math.abs((p1.x * (p2.y - point.y) + p2.x * (point.y - p1.y) + point.x * (p1.y - p2.y)));
        return area == subArea1 + subArea2 + subArea3;
    }
    double calculateArea(){
        double area = 0.5 * Math.abs((p1.x * (p2.y - p3.y) + p2.x * (p3.y - p1.y) + p3.x * (p1.y - p2.y)));
        return area;
    }
}
public class Assignment1_2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number Of Triangles:");
        int numTriangles = sc.nextInt();
        Triangle[] triangles = new Triangle[numTriangles];
        for(int i=0; i<numTriangles; i++){
            System.out.println("Enter The Co-ordinates Of The Vertices For Triangle" + (i+1) + ":");
            System.out.print("Vertex 1 (x, y):");
            Point p1 = new Point(sc.nextDouble(),sc.nextDouble());
            System.out.print("Vertex 2 (x, y):");
            Point p2 = new Point(sc.nextDouble(),sc.nextDouble());
            System.out.print("Vertex 3 (x, y):");
            Point p3 = new Point(sc.nextDouble(),sc.nextDouble());
            triangles[i] = new Triangle(p1, p2, p3);
            double perimeter = triangles[i].calculatePerimeter();
            String triangleType = triangles[i].classifyTriangle();
            System.out.println("Triangle " +( i + i ) +":");
            System.out.println("Perimeter: " + perimeter);
            System.out.println("Type: " + triangleType);
        }
        //Checking whether the point is inside the triangle
        System.out.print("Enter The Co-ordinates Of A Point To Check If It's Inside A Triangle (x,y): ");
        Point pointToCheck = new Point(sc.nextDouble(), sc.nextDouble());
        for(int i=0; i<numTriangles; i++){
            boolean isInside = triangles[i].isPointInside(pointToCheck);
            System.out.println("Point Is Inside Triangle " + (i+1) + ":" + isInside);

        }
        //Calculating the area of each triangle
        for(int i=0; i<numTriangles; i++){
            double area = triangles[i].calculateArea();
            System.out.println("Area Of Triangle " + (i+1) + ":" + area);
        }
    }
}