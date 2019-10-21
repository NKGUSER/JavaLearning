package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda {
	
	//Now with Java 8, you have got the ability to 
	//pass function to another function in form of lambda expression,


	//An anonymous class can be used to create a subclass of an abstract class,
	//a concrete class and can be used to implement an interface in Java. 
	//It can even add state fields. 
	//An instance of anonymous class can also be refereed by using this keyword 
	//inside its methods, which means you can call other methods and state 
	//can be changed. Since the most common use of Anonymous class is to provide 
	//throwaway, stateless implementation of abstract class and interface with 
	//single function, those can be replaced by lambda expressions, 
	//but when you have a state field or implementing more than one interface, 
	//you cannot use lambdas to replace anonymous class.


	
	
	List<Integer> list = new ArrayList<>();
	Set<Integer> set = new HashSet<>();
	
	public void l() {
		
		list.add(1);
		list.add(4);
		list.add(4);
		list.add(5);
		list.add(8);
		list.add(4);
		
		
		//Filter list element not divisible by 2
		list = list.stream().filter(s->s%2 == 0).collect(Collectors.toList());
		System.out.println(list);
		
		//Remove Duplicates
		set = list.stream().collect(Collectors.toSet());
		System.out.println(set);
		
		List<String> alphabets = new ArrayList<>(Arrays.asList("aa", "bbb", "cac", "dog"));
		alphabets.forEach(s -> System.out.println(s));
		alphabets.forEach(System.out::println);
		alphabets.forEach(s -> System.out.print(s + ","));
		alphabets.stream().forEach(System.out::println);
		
		alphabets.stream()
        .filter(s -> s.startsWith("a"))
        .forEach(System.out::println);
		
		alphabets.stream()
        .filter(s -> s.length() > 2)
        .forEach(System.out::println);

		alphabets.stream()
        .mapToInt(s -> s.length())
        .forEach(System.out::println);
		
		int a = alphabets.stream()
        .mapToInt(s -> s.length())
        .sum();
		
		List<Emp> l = new ArrayList<>();
		
		l.add(new Emp('A'));
		l.add(new Emp('B'));
		l.add(new Emp('C'));
		
		//Collector need final value so Atomic variable is the solution which
		//provide inbuilt method to perform arithmetic operation.
		
		AtomicInteger i = new AtomicInteger(0);
		l.stream()
        .forEach(s->{ int r=0;
        r = i.incrementAndGet();
		s.a = r;
		System.out.print(s.a + " ");
		System.out.println(s.name);});
		
		 List<String> list = Arrays.asList("5.6", "7.4", "4", 
                 "1", "2.3"); 
		 list.stream().flatMap(num -> Stream.of(num)). 
         forEach(System.out::println);
		 
		 List<Integer> PrimeNumbers = Arrays.asList(5, 7, 11,13);  
	     List<Integer> OddNumbers = Arrays.asList(1, 3, 5);  
	     List<Integer> EvenNumbers = Arrays.asList(2, 4, 6, 8); 
	  
	     List<List<Integer>> listOfListofInts = 
	                Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers); 
	  
	     System.out.println("The Structure before flattening is : " + 
	                                                  listOfListofInts); 
	          
	        // Using flatMap for transformating and flattening. 
	     List<Integer> listofInts  = listOfListofInts.stream() 
	                                    .flatMap(li -> li.stream()) 
	                                    .collect(Collectors.toList()); 
	  
	     System.out.println("The Structure after flattening is : " + 
	                                                         listofInts);
	     
	     List<Integer> lis = Arrays.asList(2, 4, 6, 8, 10); 
	     
	     Optional<Integer> answer = lis.stream().findAny(); 
	     
	     // if the stream is empty, an empty 
	        // Optional is returned. 
	        if (answer.isPresent()) { 
	            System.out.println(answer.get()); 
	        } 
	        else { 
	            System.out.println("no value"); 
	        } 
	        
	        
	        List<Integer> Distinct = new ArrayList<>();
			
	        Distinct.add(5);
	        Distinct.add(6);
	        Distinct.add(4);
	        Distinct.add(5);
	        
	        
	        List<Integer> d = Distinct.stream().distinct().sorted().collect(Collectors.toList());
	        
	        System.out.println(d);
	        
            List<Emp> sorted = new ArrayList<>();
			
	        sorted.add(new Emp(1,'N'));
	        sorted.add(new Emp(6,'N'));
	        sorted.add(new Emp(4,'I'));
	        sorted.add(new Emp(2,'I'));
	        sorted.add(new Emp(3,'T'));
	        
	        Comparator<Emp> reverseComparator = (o1,o2) -> { return (o1.a - o2.a);};
	        sorted.stream().distinct()
	                       .skip(2)
	                       .peek(s -> System.out.print(s.a+" "))
	        		       .sorted(reverseComparator)
	                       .forEach(s -> System.out.print(s.a+" "));
	        
	      
	                                
	         
			
		
	}
}
