package com.mycompany.app;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.Arrays;
public class AppTest extends TestCase{
    public AppTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(AppTest.class);
    }
    public void testCalculateAverageWithPositiveNumbers() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int[] array = {4, 5, 6};

        float expectedAverage =  ((1 + 2 + 3 + 4 + 5 + 6) / 6);


        assertEquals(expectedAverage, App.calculateAverage(list, array));
    }


    public void testCalculateAverageWithNegativeNumbers() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(-2);
        list.add(-3);

        int[] array = {-4, -5, -6};

        float expectedAverage = -3.0F;

        assertEquals(expectedAverage, App.calculateAverage(list, array));
    }


    public void testCalculateAverageWithEmptyListAndNonEmptyArray() {
        ArrayList<Integer> list = new ArrayList<>();
        int[] array = {1, 2, 3};

        double expectedAverage = (1 + 2 + 3) / 3.0; // Expected average is the sum of array elements divided by array size.

        double actualAverage = App.calculateAverage(list, array);

        assertEquals(expectedAverage, actualAverage, 0.0001); // Add a delta value for double comparison
    }

    public void testCalculateAverageWithEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        int[] array = {1, 2, 3};

        float expectedAverage = (float) ((1 + 2 + 3) / 3.0);

        assertEquals(expectedAverage, App.calculateAverage(list, array));
    }


    public void testCalculateAverageWithEmptyArray() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int[] array = {};

        float expectedAverage = (float) ((1 + 2 + 3) / 3.0);

        assertEquals(expectedAverage, App.calculateAverage(list, array));
    }
}
