package com.poly.silsub2.salary.view;

import com.poly.silsub2.salary.model.vo.Salary;

public class Outputlmpl implements Output{

	@Override
	public void out(Salary[] sarr) {
		System.out.println("                                        **** 급여명세서 ****");
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("이름      기본급    가족수   가족수당   시간외근무  시간외수당 세금  인센티브(%)  성과금   실수령액");
		System.out.println("---------------------------------------------------------------------------------------------------");
		for(int i=0;i<sarr.length;i++) {
			System.out.print(sarr[i].getName()+"\t");
			System.out.print(sarr[i].getPay()+"\t");
			System.out.print(sarr[i].getFamily()+"\t");
			System.out.print(sarr[i].getFamilyP()+"\t");
			System.out.print(sarr[i].getOvertime()+"\t");
			System.out.print(sarr[i].getOvertimeP()+"\t");
			System.out.print(sarr[i].getTax()+"\t");
			System.out.print(sarr[i].getIncentive()+"\t");
			System.out.print(sarr[i].getIncenP()+"\t");
			System.out.print(sarr[i].getTotalPay());
			
			System.out.println();	
		}
		
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("인원수:"+sarr.length+"명");
	}

}
