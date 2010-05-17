import junit.framework.TestCase;

import org.springdm.service.IGreeting;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class GreetingServiceTestCase extends TestCase {
	private ApplicationContext ac;

	protected void setUp() throws Exception {
		ac = new FileSystemXmlApplicationContext(
				"META-INF/spring/greetingservice.xml");
	}

	public void testGreetingService() {
		IGreeting service = (IGreeting) ac.getBean("greetingService");
		assertNotNull(service);
		service.greet();
	}

}
