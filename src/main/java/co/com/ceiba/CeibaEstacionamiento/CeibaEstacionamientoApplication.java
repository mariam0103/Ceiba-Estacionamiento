package co.com.ceiba.CeibaEstacionamiento;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableAutoConfiguration
public class CeibaEstacionamientoApplication {
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(CeibaEstacionamientoApplication.class, args);

//        System.out.println("List of beans provided by Spring Boot:");
//        String[] beanNames = ctx.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        for (String beanName : beanNames) {
//            System.out.print(beanName);
//            System.out.print(" ");
//        }
//
//        System.out.println("");
	}
}
