package com.bizforo.sfgdi.repositories;

public class GreetingRepositoryFactory {

    public GreetingRepository getGreeting(String lang) {
        switch (lang) {
            case "EN":
                return new EnglishGreetingRepositoryImpl();
            case "CN":
                return new ChineseGreetingRepositoryImpl();
            default:
                return new EnglishGreetingRepositoryImpl();
        }
    }
}
