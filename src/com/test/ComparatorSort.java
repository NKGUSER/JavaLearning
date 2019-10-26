package com.test;

import java.util.Comparator;


class ComparatorSort implements Comparator<Emp>{

	@Override
	public int compare(Emp o1, Emp o2) {
	
		if(o1.a < o2.a)
			return -1;
		else
			return 1;
			
	}
	
}

