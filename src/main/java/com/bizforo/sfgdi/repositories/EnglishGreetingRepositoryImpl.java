package com.bizforo.sfgdi.repositories;

public class EnglishGreetingRepositoryImpl implements GreetingRepository {
    @Override
    public String getGreeting() {
        return "Hello World -- EN";
    }
}
