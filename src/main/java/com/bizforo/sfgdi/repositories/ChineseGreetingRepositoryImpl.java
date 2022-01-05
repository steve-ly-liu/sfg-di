package com.bizforo.sfgdi.repositories;

public class ChineseGreetingRepositoryImpl implements GreetingRepository {
    @Override
    public String getGreeting() {
        return "世界，你好！-- CN";
    }
}
