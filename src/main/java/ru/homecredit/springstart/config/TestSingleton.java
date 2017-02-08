package ru.homecredit.springstart.config;

/**
 * Created by dima on 01.02.17.
 */
public class TestSingleton {
    private static TestSingleton ourInstance = new TestSingleton();

    public static TestSingleton getInstance() {
        return ourInstance;
    }

    private TestSingleton() {
    }
}
