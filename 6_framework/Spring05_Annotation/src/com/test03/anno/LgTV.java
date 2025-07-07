package com.test03.anno;

import org.springframework.stereotype.Component;

@Component
public class LgTV implements TV{

	@Override
	public void powerOn() {
		System.out.println("lg tv power on");
	}

	@Override
	public void powerOff() {
		System.out.println("lg tv power off");
	}

}
