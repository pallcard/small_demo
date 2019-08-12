package cn.wishhust.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringTest {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext(
                "applicationContext.xml");
        Animal animal = (Animal) context.getBean("animal");
        animal.say();
    }

}
