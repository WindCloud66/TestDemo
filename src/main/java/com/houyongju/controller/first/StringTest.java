package com.houyongju.controller.first;

import org.springframework.util.ClassUtils;

public class StringTest {
    public static void main(String[] args) {
        String className = "com.spring.puzzle.class2.example3.StudentController.InnerClassDataService";
        String shortName = ClassUtils.getShortName(StringTest.Hello.class);
        System.out.println(shortName);
    }

    public static  class Hello{

    }
}
