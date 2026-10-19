package com.example;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class AppTest 
{
    @Test
    public void testIsValidTriangle() {
        Point a = new Point(0, 0);
        Point b = new Point(3, 0);
        Point c = new Point(0, 4);
        Triangle validTriangle = new Triangle(a, b, c);

        assertTrue("Треугольник с точками (0,0), (3,0), (0,4) должен быть валидным", validTriangle.isValid());
    }

    @Test
    public void testIsInvalidTriangle() {
        Point a = new Point(0, 0);
        Point b = new Point(1, 1);
        Point c = new Point(5, 5);
        Triangle invalidTriangle = new Triangle(a, b, c);

        assertFalse("Точки на одной прямой не образуют треугольник", invalidTriangle.isValid());
    }
    
    @Test
    public void testIsInvalidTriangleWithSamePoints() {
        Point a = new Point(1, 1);
        Point b = new Point(1, 1);
        Point c = new Point(5, 5);
        Triangle invalidTriangle = new Triangle(a, b, c);

        assertFalse("Если две точки совпадают, это не треугольник", invalidTriangle.isValid());
    }
}
