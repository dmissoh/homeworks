package com.dmissoh.org.calculation.service.core;

import com.dmissoh.org.calculation.api.core.ICalculator;
import com.dmissoh.org.calculation.api.core.IConstants;

public class ServiceComponent implements ICalculator {

	private IConstants constants;

	/*
	 * (non-Javadoc)
	 *
	 * @see com.dmissoh.org.calculation.api.core.ICalculator#add(int, int)
	 */
	@Override
	public int add(int x, int y) {
		return x + y;
	}

	/* (non-Javadoc)
	 * @see com.dmissoh.org.calculation.api.core.ICalculator#circleArea(int)
	 */
	@Override
	public double circleArea(int radius) {
		return getConstants().getPI() * radius * radius;
	}

	public IConstants getConstants() {
		return constants;
	}

	public void setConstants(IConstants constants) {
		this.constants = constants;
	}

}
