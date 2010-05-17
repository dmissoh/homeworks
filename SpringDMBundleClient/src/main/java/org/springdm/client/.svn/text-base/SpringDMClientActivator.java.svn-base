package org.springdm.client;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.springdm.service.IGreeting;

public class SpringDMClientActivator implements BundleActivator {

	public void start(final BundleContext bundleContext) throws Exception {
		Thread t = new Thread(new Runnable() {
			boolean registered = false;
			ServiceReference ref = null;
			int safety = 0;

			public void run() {
				while (!registered && safety < 10) {
					System.out
							.println("Trying to get the reference to GreetingService");
					ref = bundleContext.getServiceReference(IGreeting.class.getName());
					if (ref != null) {
						break;
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
					safety++;
				}
				if (ref == null) {
					System.out.println("Service " + IGreeting.class.getName()
							+ " is not registered");
				} else {
					System.out.println("Found service");
					IGreeting service = (IGreeting) bundleContext.getService(ref);
					System.out.println("Retrieved service: "
							+ service.getClass().getName());
					service.greet();
				}
			}
		});
		t.start();
	}

	public void stop(BundleContext arg0) throws Exception {
		System.out.println("Stopping service");
	}

}
