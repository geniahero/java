package com.example;

public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    private double sizeAB;
    private double sizeBC;
    private double sizeAC;

    private double epsilon = 0.001;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;

        this.sizeAB = Point.distance(a, b);
        this.sizeBC = Point.distance(b, c);
        this.sizeAC = Point.distance(a, c);
    }

    private boolean isEqual(double a, double b) {
        return Math.abs(a - b) < epsilon;
    }

    public boolean isValid() {
    return getArea() > epsilon;
    }

    public double getPerimeter(){
        return sizeAB + sizeBC + sizeAC;
    }

    public double getArea(){
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - sizeAB) * (p - sizeBC) * (p - sizeAC));
    }

    public boolean isEquilateral() {
        return isEqual(sizeAB, sizeBC) && isEqual(sizeBC, sizeAC);
    }
    
    public boolean isIsosceles() {
        return isEqual(sizeAB, sizeBC) || isEqual(sizeAB, sizeAC) || isEqual(sizeBC, sizeAC);
    }
    
    public boolean isRight() {
        double[] sides = {sizeAB, sizeBC, sizeAC};
        java.util.Arrays.sort(sides); 
    
        double cathetusSquares = sides[0] * sides[0] + sides[1] * sides[1];
        double hypotenuseSquare = sides[2] * sides[2];
    
        return isEqual(cathetusSquares, hypotenuseSquare);
    }
}