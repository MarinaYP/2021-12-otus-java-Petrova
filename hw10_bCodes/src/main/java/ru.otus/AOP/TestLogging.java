package ru.otus.AOP;

import ru.otus.Annotations.Log;

public class TestLogging implements TestLoggingInterface {
    @Log
    public void calculation(int param) {};
}