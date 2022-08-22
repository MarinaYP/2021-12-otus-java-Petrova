package ru.otus.AOP;

import ru.otus.Annotations.Log;

public class TestLogging implements TestLoggingInterface {

    public void calculation(int param) {}
    @Log
    public void calculation(int param1, int param2) {}
    public void calculation(int param1, int param2, String param3) {}
}