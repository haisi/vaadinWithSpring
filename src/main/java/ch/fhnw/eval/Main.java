package ch.fhnw.eval;

import ch.fhnw.eval.business.CustomerRepository;
import ch.fhnw.eval.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner initData(CustomerRepository repo) {
        return args -> {
            repo.save(new Customer("Test1", "Test1X"));
            repo.save(new Customer("Test2", "Test2X"));
            repo.save(new Customer("Test3", "Test3X"));

            repo.findAll().forEach(System.out::println);
        };
    }
}
