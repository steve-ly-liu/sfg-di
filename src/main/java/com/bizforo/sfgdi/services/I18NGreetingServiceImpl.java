package com.bizforo.sfgdi.services;


import com.bizforo.sfgdi.repositories.GreetingRepository;

//@Profile({"EN", "default"})
//@Service("i18nGreetingService")
public class I18NGreetingServiceImpl implements GreetingService {
    private final GreetingRepository greetingRepository;

    public I18NGreetingServiceImpl(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String sayGreeting() {
        return this.greetingRepository.getGreeting();
    }
}
