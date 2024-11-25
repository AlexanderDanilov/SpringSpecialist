package ru.danilov;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private int age;
    private String name;
    private static int count = 0;

    public Person() {
        count++;
        System.out.println("Person created, count = " + count);
    }

    //add toString
    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
