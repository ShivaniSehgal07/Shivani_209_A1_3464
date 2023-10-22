import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static int vertices = 3;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Triangle> triangles = inputTriangles();

        System.out.println("Do you want to check if a point is inside any of the created triangle? (y/n): ");
        String choice = input.next();
        Point point = new Point(0, 0);

        if (choice.equals("y")) {
            System.out.println("Enter Point:");
            point = getPoint();
        }

        for (Triangle triangle : triangles) {
            System.out.println("------------------");
            System.out.println("Triangle: " + triangle);
            System.out.printf("Perimeter: %.2f", triangle.getPerimeter());
            System.out.println("\nType: " + triangle.getType());
            if (choice.equals("y")) {
                boolean isInsideTriangle = triangle.checkIfPointInsideTriangle(point);
                if (isInsideTriangle) {
                    System.out.println("The point "+ point + " is inside the triangle!");
                } else {
                    System.out.println("The point "+ point + " is not inside the triangle!");
                }
            }
        }

    }

    public static Point getPoint() {
        Scanner input = new Scanner(System.in);

        System.out.print("Input X: ");
        double x = input.nextDouble();

        System.out.print("Input Y: ");
        double y = input.nextDouble();

        return new Point(x, y);
    }

    public static Triangle getTriangle() {
        Point[] points = new Point[3];

        for (int vertex = 1; vertex <= vertices; vertex++) {
            System.out.println("Choose Vertex " + vertex + ": ");
            points[vertex - 1] = getPoint();
        }

        return new Triangle(points[0], points[1], points[2]);
    }

    public static ArrayList<Triangle> inputTriangles() {
        Scanner input = new Scanner(System.in);
        ArrayList<Triangle> triangles = new ArrayList<Triangle>();

        while (true) {
            System.out.println("----------------------------------");
            System.out.println("Let's create a Triangle! Enter Triangle Vertices: ");
            Triangle triangle = getTriangle();
            triangles.add(triangle);
            System.out.println("Triangle Inserted Successfully!");

            System.out.println("Do you want to create another triangle? (y/n): ");
            String choice = input.next();

            if (choice.equals("n")) break;
        }

        return triangles;
    }
}