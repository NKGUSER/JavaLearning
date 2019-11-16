package com.test;


import java.util.ArrayList; 
import java.util.List; 

public class Test {

	//A static method is one type of method which doesn't need any object to be initialized 
	//for it to be called. Have you noticed static is used in the main function in Java?
	//Program execution begins from there without an object being created.
	
	Test() {
    A.inception();
    
    String args[] = {"5","10","15"};
    
    C obj1=new C(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2]));
    obj1.display();
    obj1.change("Hello!!!");
    C obj2=new C(11,12,13);
    obj2.display();
    obj2.numbers(17, 18, 19);
    obj2.display();
    A obj3 = new A(100);
    obj1.Subclass();
    
    Testing obj4 ;
    //System.out.println(obj4);
    obj4 = new Testing();
    
    System.out.println(obj4);
    
//    List list = new ArrayList();
	}

}




//Decorator pattern - 
//wrapping often refers specifically to the act of 
//encapsulating a class in another class which implements the same interface 
//as the wrapped class but changes its behaviour slightly or adds new features 

//adapter pattern -
//the outer class implements a different interface, essentially 
//converting the wrapped class to make it compatible with another program


//You can also generate dynamic proxies for virtually any object at runtime 
//using java.lang.reflect.Proxy.newProxyInstance(...). You can read the official 
//guide on Dynamic Proxy Classes to learn how to use it. However, you haven't 
//given any use cases yet, so this might not be what you're looking for. 
//Proxies are usually reserved for protecting objects or delegating to a remote 
//server via RPC, and can be very complex.



//Static classes are basically a way of grouping classes together in Java. 
//Java doesn't allow you to create top-level static classes; only nested (inner) 
//static classes
//class xyz
//{
// public static class pqr{}
//
//}
//To instantiate our static class, creating an object from our static PQR class, 
//we have to use new separately on the class.
// xyz.pqr p=new xyz.pqr();


//You can't extend a class that is declared final . 
//However you can create an intermediate class, called Wrapper . 
//This Wrapper will basically contain an instance of the original class 
//and provide alternative methods to modify the state of the object according 
//what you want to do

class A
{
	int i,P;
	static String Message = "Welcome"; 
	
	//So making a constructor final is not required, so it is not used with constructor. 
	//When you set a method as final, it means : "You don't want any class override it", 
	//but constructor by JLS definition can't overridden,so it is clean. We can't make 
	//constructor to be final because constructor is never inherited.
	
	//Why can't constructors be final, static or abstract in Java? ... 
	//When you set a method as 'static', it means: “Method belong to class, 
	//not a particular object” but constructor implicitly called to initialize 
	//an object, so there is no purpose in having a static constructor
	
	//Constructor can be Private, Protected and Public
	//One such use is Singleton design patterns,1.To create an uninstantiable class 
	//that is just a collection of related static functions (this is basically a singleton,

	//•to prevent sub classing (extending). If you make only a private constructor, 
	//no class can extend your class, because it can't call the super() constructor. 
	//This is some kind of a synonym for final
	
	//Making private constructor is factory pattern
	
	// Final keyword is used to prevent sub classing
	
	//Methods called from constructors should generally be declared final. 
	//If a constructor calls a non-final method, a subclass may redefine that 
	//method with surprising or undesirable results.
	
	protected A()
	{
		i=5;
		System.out.println(i);
	}
	
	public A(int a)
	{
		i=a;	
		System.out.println(i);
	}
	//Static  method can only change the static field 
	static void inception() 
    {
		 Message = "Here you go!!!";
         System.out.println(Message);
    }
	void change(String Msg)
	{	
		this.Message=Msg;
		System.out.println(Message);
	}
	void display()
	{
	  System.out.println(P);
	}
}
class B extends A
{
	int J,Q;
	B()
	{	
		J=6;
		System.out.println(J);
	}
	void display()
	{
		super.display(); 
		System.out.println(Q);
	}
	final void Subclass()
	{
		System.out.println("This Function cannot be overridden by subclass ");
	}
}
class C extends B
{
	int K,R;
	
                                       // Super function called by default in 
 	                                   // constructor 
	//parameter constructor 
	C(int P, int Q, int R)             // this call current object and store the value in 
	{                                  // object member fields.
		K=7;	  
		System.out.println(K);
		this.P=P;
		this.Q=Q;
		this.R=R;
	}	
	void numbers(int X,int Y,int Z)
	{		
	    P=X;
	    Q=Y;
	    R=Z;
	}
	void display()
	{
		super.display(); 
		System.out.println(R);
	}
}
final class D
{
	int i,j;
   D()
   {
	  i=1;
	  j=2;
   }
}

//Interface is the best example for encapsulation which mostly used for API CALL.

//There are a number of situations in software engineering when it is important 
//for disparate groups of programmers to agree to a "contract" that spells out 
//how their software interacts. Each group should be able to write their code 
//without any knowledge of how the other group's code is written. 
//Generally speaking, interfaces are such contracts.

//In the Java programming language, an interface is a reference type, similar to a class,
//that can contain only constants, method signatures, default methods, static methods, 
//and nested types. Method bodies exist only for default methods and static methods. 
//Interfaces cannot be instantiated—they can only be implemented by classes or 
//extended by other interfaces. Extension is discussed later in this lesson. 

//Consider an interface that you have developed called DoIt:
//Suppose that, at a later time, you want to add a third method to DoIt
//If you make this change, then all classes that implement the old DoIt interface 
//will break because they no longer implement the old interface. Programmers relying
//on this interface will protest loudly.


//Try to anticipate all uses for your interface and specify it completely from the beginning. 
//If you want to add additional methods to an interface, you have several options. 
//You could create a DoItPlus interface that extends DoIt:

//Alternatively, you can define your new methods as default methods. 
//Note that you must provide an implementation for default methods. 
//You could also define new static methods to existing interfaces. 
//Users who have classes that implement interfaces enhanced with 
//new default or static methods do not have to modify or recompile 
//them to accommodate the additional methods.

//You specify that a method definition in an interface is a default method 
//with the default keyword at the beginning of the method signature. 
//All method declarations in an interface, including default methods, 
//are implicitly public, so you can omit the public modifier.

//When you extend an interface that contains a default method, you can do the following:
//Not mention the default method at all, which lets your extended interface inherit
//the default method.
//Redeclare the default method, which makes it abstract.
//Redefine the default method, which overrides it.

//A class that implements an interface must implement all the methods declared 
//in the interface.

//After introducing Default Method, it seems that interfaces and abstract classes are same. 
//However, they are still a different concept in Java 8.

//Abstract class can define constructor. They are more structured and can have a state 
//associated with them. While in contrast, default method can be implemented only in the 
//terms of invoking other interface methods, with no reference to a particular 
//implementation's state. Hence, both are used for different purposes and choosing 
//between two really depends on the scenario context.

//Since java class can implement multiple interfaces and each interface can define 
//default method with same method signature, therefore, the inherited methods can 
//conflict with each other.

//In order to fix this class, we need to provide default method implementation,
//Further, if we want to invoke default implementation provided by any of super 
//interface rather than our own implementation. 
//InterfaceA.super.defaultA();

//Static Methods
//A static method is a method that is associated with the class in which it 
//is defined rather than with any object. Every instance of the class shares 
//its static methods

//abstract method
//If a class includes abstract methods, then the class itself must be declared abstract
//When an abstract class is subclassed, the subclass usually provides implementations 
//for all of the abstract methods in its parent class. However, if it does not, then 
//the subclass must also be declared abstract.
//Methods in an interface (see the Interfaces section) that are not declared as default 
//or static are implicitly abstract, so the abstract modifier is not used with interface 
//methods. (It can be used, but it is unnecessary.) 

class Testing
{
 int i=0;	
}

