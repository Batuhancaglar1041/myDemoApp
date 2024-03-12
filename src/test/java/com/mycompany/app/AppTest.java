package com.mycompany.app;
import junit.framework.Assert;
import junit.framework.TestCase;
import java.util.ArrayList;

public class AppTest extends TestCase {

    public void testCustomMethod_PositiveNumbers() {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        int result = App.customMethod(list1, list2, 5, 6);
        Assert.assertEquals(44, result);
    }


    public void testCustomMethod_NegativeNumbersAndEmptyLists() {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        int result = App.customMethod(list1, list2, -2, -3);
        Assert.assertEquals(0, result);
    }


    public void testCustomMethod_SingleElementLists() {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(5);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(6);
        int result = App.customMethod(list1, list2, 1, 2);
        Assert.assertEquals(3, result);
    }


    public void testCustomMethod_DifferentListLengthAndNumberTypes() {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        int result = App.customMethod(list1, list2, 7, 8);
        assertEquals(90, result);
    }



    public void testCustomMethod_ZeroNumbersAndEmptyLists() {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(0);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(0);
        int result = App.customMethod(list1, list2, 0, 0);
        Assert.assertEquals(0, result);
    }
}
