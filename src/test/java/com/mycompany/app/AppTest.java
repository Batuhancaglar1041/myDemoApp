package com.mycompany.app;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;


import java.util.ArrayList;

public class AppTest {

    void testCalculateAverageWithPositiveNumbers() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int[] array = {4, 5, 6};

        double expectedAverage = (1 + 2 + 3 + 4 + 5 + 6) / 6.0;

        assertEquals(expectedAverage, App.calculateAverage(list, array));
    }


    void testCalculateAverageWithNegativeNumbers() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(-2);
        list.add(-3);

        int[] array = {-4, -5, -6};

        double expectedAverage = (-1 - 2 - 3 - 4 - 5 - 6) / 6.0;

        assertEquals(expectedAverage, App.calculateAverage(list, array));
    }


    void testCalculateAverageWithEmptyListAndArray() {
        ArrayList<Integer> list = new ArrayList<>();
        int[] array = {};

        double expectedAverage = 0.0; // Since both list and array are empty, expected average is 0.

        double actualAverage = App.calculateAverage(list, array);

        assertEquals(expectedAverage, actualAverage);
    }


    void testCalculateAverageWithEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        int[] array = {1, 2, 3};

        double expectedAverage = (1 + 2 + 3) / 3.0;

        assertEquals(expectedAverage, App.calculateAverage(list, array));
    }


    void testCalculateAverageWithEmptyArray() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int[] array = {};

        double expectedAverage = (1 + 2 + 3) / 3.0;

        assertEquals(expectedAverage, App.calculateAverage(list, array));
    }
}
