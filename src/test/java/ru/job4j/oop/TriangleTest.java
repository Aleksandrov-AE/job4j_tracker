package ru.job4j.oop;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.oop.Point;
import ru.job4j.oop.Triangle;

public class TriangleTest {

    @Test
    public void when00and40and04Then8() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        Assert.assertThat(result, Matchers.closeTo(8, 0.001));
    }

    @Test
    public void when00and10and40Then8() {
        Point a = new Point(0, 0);
        Point b = new Point(1, 0);
        Point c = new Point(4, 0);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        double expected = -1;
        Assert.assertEquals(rsl, expected, 0);
    }

    @Test
    public void when00and00and00Then8() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 0);
        Point c = new Point(0, 0);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        double expected = -1;
        Assert.assertEquals(rsl, expected, 0);
    }
}