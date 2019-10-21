package com.test;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class App {
   @Retention( RetentionPolicy.RUNTIME )
    public @interface Cars {
        Manufacturer[] value() default{};
    }
    @Manufacturer( "Mercedes Benz")
    @Manufacturer( "Toyota")
    @Manufacturer( "BMW")
    @Manufacturer( "Range Rover")
    public interface Car { 
    }
    @Repeatable(value = Cars.class )
    public @interface Manufacturer {
        String value();
    };