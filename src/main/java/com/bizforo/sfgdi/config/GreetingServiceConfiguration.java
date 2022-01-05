package com.bizforo.sfgdi.config;

import com.bizforo.sfgdi.datasource.FakeDataSource;
import com.bizforo.sfgdi.repositories.*;
import com.bizforo.sfgdi.services.*;
import gurn.springframework.pets.PetService;
import gurn.springframework.pets.PetServiceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

//@PropertySource("classpath:datasource.properties")
@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfiguration {

    @Bean
    FakeDataSource fakeDataSource(@Value("${com.bizforo.username}") String username,
                                  @Value("${com.bizforo.password}") String password,
                                  @Value("${com.bizforo.jdbcurl}") String jdbcurl) {

        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcurl(jdbcurl);
        return fakeDataSource;


    }

    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }

    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("dog");
    }

    @Profile("cat")
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("cat");
    }

//    @Bean
/*    ConstructorGreetingServiceImpl constructorGreetingServiceImpl() {
        return new ConstructorGreetingServiceImpl();
    }*/

    @Bean
    PropertyGreetingServiceImpl propertyGreetingServiceImpl() {
        return new PropertyGreetingServiceImpl();
    }

    @Bean
    SetterGreetingServiceImpl setterGreetingServiceImpl() {
        return new SetterGreetingServiceImpl();
    }

    @Primary
    @Bean
    PrimaryGreetingServiceImpl primaryGreetingServiceImpl() {
        return new PrimaryGreetingServiceImpl();
    }

    @Bean
    GreetingRepositoryFactory greetingRepositoryFactory() {
        return new GreetingRepositoryFactory();
    }

    @Profile("CN")
    @Bean("i18nGreetingService")
    I18NGreetingServiceImpl i18NChineseGreetingServiceImpl(GreetingRepositoryFactory greetingRepositoryFactory) {
        return new I18NGreetingServiceImpl(greetingRepositoryFactory.getGreeting("CN"));
    }

    @Profile({"EN", "default"})
    @Bean("i18nGreetingService")
    I18NGreetingServiceImpl i18NEnglishGreetingServiceImpl(GreetingRepositoryFactory greetingRepositoryFactory) {
        return new I18NGreetingServiceImpl(greetingRepositoryFactory.getGreeting("EN"));
    }

/*    @Bean
    SingletonBean singletonBean() {
        return new SingletonBean();
    }*/
}
