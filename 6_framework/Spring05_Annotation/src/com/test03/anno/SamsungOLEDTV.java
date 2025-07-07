package com.test03.anno;

import org.springframework.stereotype.Component;

@Component("sam")
public class SamsungOLEDTV implements TV{
	
	@Override
	public void powerOn() {
		System.out.println("samsung tv power on");
	}

	@Override
	public void powerOff() {
		System.out.println("samsung tv power off");
	}

}
