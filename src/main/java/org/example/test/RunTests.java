package org.example.test;

public class RunTests {
    public static void main(String[] args) {
        CarBuilderTest.testCreation();
        CarBuilderTest.testValidation();
        ReadFromFileTest.run();
        WriteToFileTest.run();
    }
}
