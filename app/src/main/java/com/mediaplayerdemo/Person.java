package com.mediaplayerdemo;

/**
 * Created by jephy on 7/18/17.
 */

public class Person {
    private int age;
    private String name;
    private static Person person =new Person();

    private Person(){

    }

    private static Person getInstance(){
//        if (null == person){
//            person = new Person();
//        }
        return person;
    }
}
