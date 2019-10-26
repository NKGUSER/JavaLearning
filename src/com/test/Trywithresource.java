package com.test;


public class Trywithresource implements AutoCloseable {

	public void doIt() {
        System.out.println("Resource doing it!");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing the resource");
    }
}
