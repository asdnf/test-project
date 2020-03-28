package org.test.sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;

public class Graph {

    public static void main(String... args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/ctx.xml");
        JFrame frame = (JFrame) ctx.getBean("frame");
        frame.setVisible(true);
    }

}
