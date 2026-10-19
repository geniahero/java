package com.example;

import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        List<Triangle> triangles = new ArrayList<>();

        int countEquilateral = 0;
        int countIsosceles = 0;
        int countRight = 0;
        int countArbitrary = 0;

        Triangle maxAreaEq = null, minAreaEq = null, maxPerimEq = null, minPerimEq = null;
        Triangle maxAreaIso = null, minAreaIso = null, maxPerimIso = null, minPerimIso = null;
        Triangle maxAreaRight = null, minAreaRight = null, maxPerimRight = null, minPerimRight = null;
        Triangle maxAreaArb = null, minAreaArb = null, maxPerimArb = null, minPerimArb = null;

        // 1. РАВНОСТОРОННИЕ
        triangles.add(new Triangle(new Point(0, 0), new Point(2, 0), new Point(1, 1.732)));
        triangles.add(new Triangle(new Point(0, 0), new Point(10, 0), new Point(5, 8.660)));
        
        // 2. РАВНОБЕДРЕННЫЕ
        triangles.add(new Triangle(new Point(0, 0), new Point(2, 0), new Point(1, 3.873)));
        triangles.add(new Triangle(new Point(0, 0), new Point(8, 0), new Point(4, 3)));
        
        // 3. ПРЯМОУГОЛЬНЫЕ
        triangles.add(new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 4)));
        triangles.add(new Triangle(new Point(0, 0), new Point(6, 0), new Point(0, 8)));
        triangles.add(new Triangle(new Point(0, 0), new Point(1, 0), new Point(0, 1)));
        
        // 4. ПРОИЗВОЛЬНЫЕ
        triangles.add(new Triangle(new Point(0, 0), new Point(7, 1), new Point(2, 5)));
        triangles.add(new Triangle(new Point(1, 1), new Point(6, 2), new Point(4, 6)));
        triangles.add(new Triangle(new Point(0, 0), new Point(20, 1), new Point(10, 1.5)));

        for (Triangle t : triangles) {
            if (t.isEquilateral()) {
                countEquilateral++;
                maxAreaEq = getMaxArea(maxAreaEq, t);
                minAreaEq = getMinArea(minAreaEq, t);
                maxPerimEq = getMaxPerim(maxPerimEq, t);
                minPerimEq = getMinPerim(minPerimEq, t);
            } 
            
            if (t.isIsosceles()) {
                countIsosceles++;
                maxAreaIso = getMaxArea(maxAreaIso, t);
                minAreaIso = getMinArea(minAreaIso, t);
                maxPerimIso = getMaxPerim(maxPerimIso, t);
                minPerimIso = getMinPerim(minPerimIso, t);   
            } 
            
            if (t.isRight()) {
                countRight++;
                maxAreaRight = getMaxArea(maxAreaRight, t);
                minAreaRight = getMinArea(minAreaRight, t);
                maxPerimRight = getMaxPerim(maxPerimRight, t);
                minPerimRight = getMinPerim(minPerimRight, t);
            } 
            
                countArbitrary++;
                maxAreaArb = getMaxArea(maxAreaArb, t);
                minAreaArb = getMinArea(minAreaArb, t);
                maxPerimArb = getMaxPerim(maxPerimArb, t);
                minPerimArb = getMinPerim(minPerimArb, t);
        }

        System.out.println("--- Статистика ---");
        System.out.println("Равносторонних: " + countEquilateral);
        System.out.println("Равнобедренных: " + countIsosceles);
        System.out.println("Прямоугольных: " + countRight);
        System.out.println("Произвольных: " + countArbitrary);

        printGroupStats("Равносторонние", maxAreaEq, minAreaEq, maxPerimEq, minPerimEq);
        printGroupStats("Равнобедренные", maxAreaIso, minAreaIso, maxPerimIso, minPerimIso);
        printGroupStats("Прямоугольные", maxAreaRight, minAreaRight, maxPerimRight, minPerimRight);
        printGroupStats("Произвольные", maxAreaArb, minAreaArb, maxPerimArb, minPerimArb);
    }

    private static Triangle getMaxArea(Triangle currentMax, Triangle newT) {
        if (currentMax == null) return newT;
        return newT.getArea() > currentMax.getArea() ? newT : currentMax;
    }

    private static Triangle getMinArea(Triangle currentMin, Triangle newT) {
        if (currentMin == null) return newT;
        return newT.getArea() < currentMin.getArea() ? newT : currentMin;
    }

    private static Triangle getMaxPerim(Triangle currentMax, Triangle newT) {
        if (currentMax == null) return newT;
        return newT.getPerimeter() > currentMax.getPerimeter() ? newT : currentMax;
    }

    // Возвращает треугольник с меньшим периметром
    private static Triangle getMinPerim(Triangle currentMin, Triangle newT) {
        if (currentMin == null) return newT;
        return newT.getPerimeter() < currentMin.getPerimeter() ? newT : currentMin;
    }

    private static void printGroupStats(String groupName, Triangle maxA, Triangle minA, Triangle maxP, Triangle minP) {
        if (maxA == null) {
            System.out.println("\n[" + groupName + "] нет в списке.");
            return;
        }
        System.out.println("\n--- " + groupName + " ---");
        System.out.printf("Макс. площадь: %.2f | Мин. площадь: %.2f%n", maxA.getArea(), minA.getArea());
        System.out.printf("Макс. периметр: %.2f | Мин. периметр: %.2f%n", maxP.getPerimeter(), minP.getPerimeter());
    }
}
