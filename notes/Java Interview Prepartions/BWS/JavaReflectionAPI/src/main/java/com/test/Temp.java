package com.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openjdk.jol.vm.VM;

public class Temp {


	public static void main(String[] args) {
		Double Sip=5500d;
		Double P=Sip;
		Double AR=20d;
		Double MR=AR/12;
		Integer T=15;
		Double intrest=null;
		for(int i=1;i<=T*12;i++) {
			 intrest=(P*T*AR)/(100*12);
			System.out.println(String.format("P :: %s    interset %s", P,intrest));
			P+=intrest+Sip;
			
		}
		BigDecimal dd=new BigDecimal(P);
		System.out.println(dd);
	}
}
