package ru.danilov;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        //Person не создан так как контекст еще не создан
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("Number of beans: " + context.containsBean("person")); //context.getBeanDefinitionCount()
        Person person1 = context.getBean(Person.class);
        System.out.println(String.format("I`m one person: %s", person1));
        Person person2 = context.getBean(Person.class);
        if(person1 == person2)
            System.out.println("I`m same person, person is SINGLETON");
        else
            System.out.println("I`m different person, person is PROTOTYPE");
    }
}