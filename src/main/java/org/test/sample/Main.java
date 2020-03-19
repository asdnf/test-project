package org.test.sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Main {

    public static void main(String... args) throws IOException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/ctx.xml");
        System.out.println(((RestDataProvider) ctx.getBean("restDataProvider")).getData());
    }

}
