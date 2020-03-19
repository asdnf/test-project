package org.test.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String... args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/ctx.xml");
        IComponent c = (IComponent) ctx.getBean("ccc");
        assert c != null;
        c.test();
    }

    public interface IComponent {
        void test();
    }

    static class CComponent implements IComponent {
        public CComponent() {
            System.out.println(this.getClass().getCanonicalName());
        }

        public void test() {
            System.out.println("stub");
        }
    }

    static class CCComponent extends CComponent {

        @Autowired
        private CComponent compo;

        @Override
        public void test() {
            System.out.println(compo.getClass().getCanonicalName());
        }
    }


}
