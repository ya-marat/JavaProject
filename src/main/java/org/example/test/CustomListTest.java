package org.example.test;

import org.example.list.CustomList;

public class CustomListTest {

    public static void run() {

        System.out.println("=== CustomList Test ===");
        testAdd();
        testGet();
        testSet();
        testRemove();
        testClear();
        testEquals();
    }

    private static void testAdd() {

        CustomList<String> list = new CustomList<>();

        list.add("BMW");
        list.add("Audi");

        if (list.size() == 2) {
            System.out.println("testAdd PASSED");
        } else {
            System.out.println("testAdd FAILED");
        }
    }

    private static void testGet() {

        CustomList<String> list = new CustomList<>();

        list.add("BMW");

        if ("BMW".equals(list.get(0))) {
            System.out.println("testGet PASSED");
        } else {
            System.out.println("testGet FAILED");
        }
    }

    private static void testSet() {

        CustomList<String> list = new CustomList<>();

        list.add("BMW");
        list.set(0, "Audi");

        if ("Audi".equals(list.get(0))) {
            System.out.println("testSet PASSED");
        } else {
            System.out.println("testSet FAILED");
        }
    }

    private static void testRemove() {

        CustomList<String> list = new CustomList<>();

        list.add("BMW");
        list.add("Audi");

        list.remove(0);

        boolean passed =
                list.size() == 1 &&
                        "Audi".equals(list.get(0));

        if (passed) {
            System.out.println("testRemove PASSED");
        } else {
            System.out.println("testRemove FAILED");
        }
    }

    private static void testClear() {

        CustomList<String> list = new CustomList<>();

        list.add("BMW");
        list.add("Audi");

        list.clear();

        if (list.isEmpty()) {
            System.out.println("testClear PASSED");
        } else {
            System.out.println("testClear FAILED");
        }
    }

    private static void testEquals() {

        CustomList<String> list1 = new CustomList<>();
        CustomList<String> list2 = new CustomList<>();

        list1.add("BMW");
        list1.add("Audi");

        list2.add("BMW");
        list2.add("Audi");

        if (list1.equals(list2)) {
            System.out.println("testEquals PASSED");
        } else {
            System.out.println("testEquals FAILED");
        }
    }
}