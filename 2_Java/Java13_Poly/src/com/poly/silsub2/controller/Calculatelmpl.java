package com.poly.silsub2.controller;

import com.poly.silsub2.salary.model.vo.Salary;

public class Calculatelmpl implements Calculate{

	@Override
	public void calc(Salary[] sarr) {
		for(int i=0;i<sarr.length;i++) {
			if(sarr[i].getFamily()<3) {
				sarr[i].setFamilyP(sarr[i].getFamily()*20000);
			}else {
				sarr[i].setFamilyP(60000);
			}
			sarr[i].setOvertimeP(sarr[i].getOvertime()*5000);
			sarr[i].setTax((long) (sarr[i].getPay()*0.1));
			sarr[i].setIncenP((long)(sarr[i].getIncentive()*sarr[i].getPay()));
			sarr[i].setTotalPay(sarr[i].getPay()+sarr[i].getFamilyP()
					+sarr[i].getIncenP()+sarr[i].getOvertimeP()-sarr[i].getTax());
		}
	}

}
