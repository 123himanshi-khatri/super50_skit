/*
 ============================================================================
 Name        : GeometryHierarchy.java
 Author      : Himanshi Khatri
 Description : Coordinate Geometry Library for Drone Mapping System
               Demonstrates OOP concepts — Inheritance, Abstraction,
               Encapsulation, and Method Overriding.
 ============================================================================
*/

import java.util.*;

// --------------------- Base Class: Point ---------------------
class Point {
    private double x;
    private double y;

    // Constructor to initialize coordinates
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Method: Returns Euclidean distance between current point and another point
    public double distance(Point other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Method: Moves the point by dx and dy
    public void translate(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    // Method: Returns coordinates in format (x, y)
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

// --------------------- Abstract Class: Shape ---------------------
abstract class Shape {
    // Abstract method: Must be overridden by subclasses
    public abstract double getArea();
}

// --------------------- Derived Class: Circle ---------------------
class Circle extends Shape {
    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Override method to compute area
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

// --------------------- Derived Class: Square ---------------------
class Square extends Shape {
    private double side;

    // Constructor
    public Square(double side) {
        this.side = side;
    }

    // Override method to compute area
    @Override
    public double getArea() {
        return side * side;
    }
}

// --------------------- Main Class ---------------------
public class GeometryHierarchy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input points
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);

        // Compute and print distance
        System.out.printf("Distance: %.1f%n", p1.distance(p2));

        // Input circle radius and square side
        double radius = sc.nextDouble();
        Circle c = new Circle(radius);
        System.out.printf("Circle Area: %.2f%n", c.getArea());

        double side = sc.nextDouble();
        Square s = new Square(side);
        System.out.printf("Square Area: %.1f%n", s.getArea());

        // Input translation values
        double dx = sc.nextDouble();
        double dy = sc.nextDouble();

        p1.translate(dx, dy);
        System.out.println("Translated Point1: " + p1);

        sc.close();
    }
}
