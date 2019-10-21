package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class Testing {

	public static void main(String[] args) throws InterruptedException {
		
		
		Thread t = new Thread(new Mthread());
		
		Thread t1 = new Thread(new Ethread());
		
		
		t1.join(); // First Thread t1 is finished
		t.join();  // Second Thread t is finished
		
		t.start();  
		t1.start();
		
		
		Thread t2 = new Thread( new Runnable() {
			
			@Override
			public void run() {
				
				System.out.println("Annonymous thread");
				
			}
		});
		
		t2.start();
		
		Thread t3 = new Thread (()->{System.out.println("Lambda Thread");});
		
		t3.start();
		
		Lambda J8 = new Lambda();
		J8.l();
		
		Scanner input = new Scanner(System.in);
		int i = 0;
	
		int reverse = 0;
		int Numr = input.nextInt();
		
		while(Numr!=0) {
			
			int digit = Numr%10;
			
			reverse = reverse*10 + digit;

			Numr = Numr/10;		
		}
		
		System.out.println(reverse);
		
		
		while(input.hasNextInt()) {
			int num = input.nextInt();
			i++;
			if(num%15 == 0)
				System.out.println("FizzBuzz");
			else if(num % 3 == 0)
				System.out.println("Fizz");
			else if (num  % 5 == 0)
				System.out.println("Buzz");
			if(i == 3)
				break;
		}
		
	    String str = input.next();
	    
	    StringBuilder sb = new StringBuilder(str);
	    sb.reverse();
	    if(sb.toString().equals(str))
	    	System.out.println("String input is palindrome");
	    
	    char[] c = str.toCharArray();
	    for(int ii=0;ii<str.length();ii++)
	    {
	    	for (int j=ii+1;j<str.length();j++) {
	    		if(c[ii] == c[j]) {
	    			System.out.println(c[j]);
	    			break;
	    		}
	    	}
	    }
		
		Map<Emp, String> store = new HashMap<>();
		
		store.put(new Emp(1,'H'),"baba");
		store.put(new Emp(2,'H'), "Check it");
		store.putIfAbsent(new Emp(1,'H'), "Hello");
		
	    System.out.println("Iterate Map entry using Advance for loop");
		
        for(Entry e : store.entrySet()) {
        	
        	Emp k= (Emp) e.getKey();
            String v = (String) e.getValue();
        	System.out.println(k.a+" "+v);
        }
        
        System.out.println("Iterate Map entry using Foreach entryset");
        
        store.forEach((k, v) -> System.out.println(k.a + " " + v)); 
	
        System.out.println("Loop map entry using entryset iterator");
        
        Iterator<Entry<Emp, String>> itr = store.entrySet().iterator();
        
		while(itr.hasNext()) {
			Entry<Emp, String> m = itr.next();
			Emp K = m.getKey();
			System.out.println(K.getName()+ " "+ m.getValue());
		}
		
		
	
		LinkedList<Emp> list =  new LinkedList<Emp>();
		
		List<String> x = Collections.synchronizedList(new ArrayList());
		List<String> y = new CopyOnWriteArrayList();
		Set<String> s =  new CopyOnWriteArraySet<>();
		Map<String, String> myMap = new ConcurrentHashMap<String, String>();
		
		
		list.add(new Emp(4,'K'));
		list.add(new Emp(2,'V'));
		Collections.sort(list);            // comparable called
		System.out.println(list);
		list.add(new Emp(3,'L'));
		list.add(new Emp(1,'W'));
		list.add(new Emp(1,'W'));
		Collections.sort(list, new abc()); // Comparator called
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);
		
		Set<Emp> removedup = new LinkedHashSet<Emp>(list);
		list.clear();
		list.addAll(removedup);
		System.out.println(list);		
		
		list.add(new Emp(1,'W'));
		list.add(new Emp(3,'L'));
		System.out.println(list);
		
		Iterator<Emp> it = list.iterator();
		while(it.hasNext()) {	
			Emp next = it.next();
			for (int l = 0; l < list.size()-1; l++){
	            if (next.equals(list.get(i))){
	                it.remove();
	                break;
		}
     	}
			}
	            
	    System.out.println(list);
	}
}
