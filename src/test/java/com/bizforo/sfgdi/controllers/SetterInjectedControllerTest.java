package com.bizforo.sfgdi.controllers;

import com.bizforo.sfgdi.services.SetterGreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SetterInjectedControllerTest {
    SetterInjectedController controller;

    @BeforeEach
    void setUp() {
        controller = new SetterInjectedController();
        controller.setGreetingService(new SetterGreetingServiceImpl());
    }

    @Test
    void setGreetingService() {
        System.out.println("--- Setter Test ---");
        System.out.println(controller.getGreeting());
    }
}