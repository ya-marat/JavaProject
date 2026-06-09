package org.example.test;

public class RunTests {
    public static void main(String[] args) {
        CarBuilderTest.testCreation();
        WriteToFileTest.run();
        CarYearComparatorTest.run();
        ReadFromFileTest.run();
        RandomCarDataInputTest.run();
        CarPowerComparatorTest.run();
        CarYearComparatorTest.run();
        CustomListTest.run();
        MultiThreadCount.run();
    }
}
