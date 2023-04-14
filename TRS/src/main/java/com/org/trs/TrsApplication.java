package com.org.trs;

import com.org.trs.model.User;
import com.org.trs.seivice.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Scanner;

@SpringBootApplication
@PropertySource(value = {"classpath:configuration.properties"})
public class TrsApplication implements CommandLineRunner {

	@Autowired
	RegistrationService registrationService;
	@Autowired
	Environment environment;
	@Autowired
	ApplicationContext applicationContext;


	public static void main(String[] args) {
		SpringApplication.run(TrsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			User u = new User();
			Scanner s = new Scanner(System.in);
			System.out.println("Enter User id : ");
			String uid = s.next();
			System.out.println("Enter Password : ");
			String password = s.next();
			System.out.println("Enter name : ");
			String name = s.next();
			System.out.println("Enter city : ");
			String city = s.next();
			System.out.println("Enter email : ");
			String email = s.next();
			System.out.println("Enter phone Number : ");
			String phone = s.next();

			u.setName(name);
			u.setCity(city);
			u.setUserId(uid);
			u.setEmail(email);
			u.setPhone(phone);
			u.setPassword(password);
			registrationService = (RegistrationService) applicationContext.getBean("registrationService");
			String a = registrationService.registerUser(u);
			System.out.println(environment.getProperty(a));

		}catch (Exception e){
			System.out.println(environment.getProperty(e.getMessage()));
		}


	}
}
