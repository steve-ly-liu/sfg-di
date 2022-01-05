package com.bizforo.sfgdi;

import com.bizforo.sfgdi.config.SfgConfiguration;
import com.bizforo.sfgdi.controllers.*;
import com.bizforo.sfgdi.datasource.FakeDataSource;
import com.bizforo.sfgdi.services.PrototypeBean;
import com.bizforo.sfgdi.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan({"com.bizforo.sfgdi", "gurn.springframework.pets"})
@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		PetController petController = ctx.getBean("petController", PetController.class);
		System.out.println("--- The Best Pet is ---");
		System.out.println(petController.whichPetIsTheBest());

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println("====== Spring Profile ======");
		System.out.println(i18nController.sayHello());

		System.out.println("====== Primary Bean ======");
		MyController myController = (MyController) ctx.getBean("myController");
		String greeting = myController.sayHello();
		System.out.println(greeting);

		System.out.println("====== Property Spring Injection ======");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("====== Setter Spring Injection ======");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("====== Constructor Spring Injection ======");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());

		System.out.println("========= Bean Scope =============");
		SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean1.getMyScope());
		SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean2.getMyScope());

		PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean1.getMyScope());
		PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean2.getMyScope());

		/* print properties */
		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
		System.out.println("--------- Fake data source: ");
		System.out.println(fakeDataSource.getUsername() + " | "
				+ fakeDataSource.getPassword() + " | " + fakeDataSource.getJdbcurl());

		System.out.println("-------- Config Props Bean:");
		SfgConfiguration sfgConfiguration = ctx.getBean(SfgConfiguration.class);
		System.out.println(sfgConfiguration.getUsername() + " | "
						+ sfgConfiguration.getPassword() + " | "
						+ sfgConfiguration.getJdbcurl());


	}

}
