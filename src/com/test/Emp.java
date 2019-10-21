package com.test;

public class Emp implements Comparable<Emp>{
	
	int a;
	char name;
	
	public Emp(int a, char name) {
		
		this.a = a;
		this.name = name;
	}
	
    public Emp(char name) {
		this.name = name;
	}
	
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public char getName() {
		return name;
	}
	public void setName(char name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj)
		   return true;
		if(obj == null || obj.getClass()!= this.getClass()) 
            return false; 
          
		Emp emp = (Emp)obj;
		return (emp.name ==  this.name)&& (emp.a == this.a);
		
	}
	
	@Override
	public int hashCode() {
		
		return this.a;
	}

	@Override
	public int compareTo(Emp o) {
		return this.a - o.a;
	}
}
