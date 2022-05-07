package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void whenDistance3d000to001() {
        Point p1 = new Point(0, 0, 0);
        Point p2 = new Point(0, 0, 1);
        double expected = 1;
        double out = p1.distance3d(p2);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void whenDistance3d000to11and00() {
        Point p1 = new Point(0, 0, 0);
        Point p2 = new Point(11, 0, 0);
        double expected = 11;
        double out = p1.distance3d(p2);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void whenDistance3d222to222() {
        Point p1 = new Point(2, 2, 2);
        Point p2 = new Point(2, 2, 2);
        double expected = 0;
        double out = p1.distance3d(p2);
        Assert.assertEquals(expected, out, 0.01);
    }
}