package com.dmissoh.org.calculation.service.consumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.dmissoh.org.calculation.api.core.ICalculator;

public class Activator implements BundleActivator {

	private ICalculator service;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {
		// Register directly with the service
		ServiceReference reference = context
				.getServiceReference(ICalculator.class.getName());
		service = (ICalculator) context.getService(reference);
		System.out.println("23 + 45 = " + service.add(23, 45));
		System.out.println("circleArea(3) = " + service.circleArea(3));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		System.err.println("Bye bye!!");
	}

}
