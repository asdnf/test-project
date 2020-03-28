package org.test.sample;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FramePostProcessor implements BeanPostProcessor {

    JButton button;
    JPanel panel;
    JFrame frame;

    public FramePostProcessor(JButton button, final JPanel panel, final JFrame frame) {
        this.button = button;
        this.panel = panel;
        this.frame = frame;

        frame.add(button, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 300; i++) {
                    panel.getGraphics().drawOval(100 + i, 100, 50, 50);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        throw new IllegalStateException("", ex);
                    }
                }
            }
        });
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
