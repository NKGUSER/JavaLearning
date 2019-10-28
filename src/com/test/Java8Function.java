package com.test;

import java.util.ArrayList;
import java.util.List;

public class Java8Function<E extends Object> {
	
	List<? super E> type = new ArrayList<>();
	
	public void add(E e) {
		type.add(e);
	}
	public void display() {
		for(Object types: type)
			System.out.println(types);
	}

}
