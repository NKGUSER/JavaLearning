package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class MainTest {

	
	static void sort(Integer arr[]) {
		
		for(int i=0;i<arr.length-1;i++) {
			
			    if(arr[i] > arr[i+1]) {
			    	int temp = arr[i];
			        arr[i] = arr[i+1];
			        arr[i+1] = temp;
			        i=0;
			    }
			}
		for(int j=0;j<arr.length;j++) 
		  System.out.println(arr[j]+",");
    }
	public static void main(String[] args) throws Exception {
		
		Test test = new Test();
		
	    List<Integer> numbers = new ArrayList<>(Arrays.asList(1,5,4,3,2));
	    
	    Integer arr[] = numbers.toArray(new Integer[numbers.size()]);
	    
	    sort(arr); 
	  
		Java8Function<Object> f = new Java8Function<>();
		f.add(5);
		f.add("Hello");
		f.display();
		
		List a = new ArrayList();
		a.add(1);
		a.add("Nitin");
		System.out.println(a);
		
			
		// Java 9 can mention resource reference variable in try block 
		// in place of creating the resource.
		
		try(Trywithresource t = new Trywithresource()) {
			t.doIt();
			throw new RuntimeException();
		}
		catch (Exception e) {
			System.out.println("Exception caught after executing close() method");
		}
		finally {
			System.out.println("Final block executed after close() and catch block");
		}
		
		
		Ethread t1 = new Ethread();
		Thread t = new Thread(new Mthread(t1));
		
		t1.join(); // First Thread t1 is finished
		t.join();  // Second Thread t is finished
		
		t1.start();  
		t.start();	
		
		Thread t2 = new Thread( new Runnable() {
			
			@Override
			public void run() {
				
				System.out.println("Annonymous thread");
				
			}
		});
		
		t2.start();
		
		Thread t3 = new Thread (()->{System.out.println("Lambda Thread");});
		
		t3.start();
		
		
		final Queue sharedQ = new LinkedList();

        Thread producer = new Producer(sharedQ);
        Thread consumer = new Consumer(sharedQ);

        producer.start();
        consumer.start();
		
		
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
	    
	    // String Builder and Buffer are mutable classes to modify string.
	    // Where String buffer is Synchronized and builder is not.
	    
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
		
	    System.out.println("Iterate Keyset using Advance for loop");
		
        for(Emp e : store.keySet()) {
        	
        	int k= e.a;
            char v = e.name;
        	System.out.println(k+" "+v);
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
		
		List<String> x = Collections.synchronizedList(new ArrayList());
		List<String> y = new CopyOnWriteArrayList();
		Set<String> s =  new CopyOnWriteArraySet<>();
		Map<String, String> myMap = new ConcurrentHashMap<String, String>();
	
		LinkedList<Emp> list =  new LinkedList<Emp>();
	
		list.add(new Emp(4,'K'));
		list.add(new Emp(2,'V'));
		Collections.sort(list);            // comparable called
		System.out.println(list);
		
		list.add(new Emp(3,'L'));
		list.add(new Emp(1,'W'));
		list.add(new Emp(1,'W'));
		Collections.sort(list, new ComparatorSort()); // Comparator called
		
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
