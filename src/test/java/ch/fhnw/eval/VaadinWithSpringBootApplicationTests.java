package ch.fhnw.eval;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = VaadinWithSpringBootApplication.class)
@WebAppConfiguration
public class VaadinWithSpringBootApplicationTests {

	@Test
	public void contextLoads() {
	}

}