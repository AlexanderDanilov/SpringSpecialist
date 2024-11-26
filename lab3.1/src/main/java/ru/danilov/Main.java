package ru.danilov;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(ConfigurationGraph.class)) {
            context.getBean(Scene.class).draw();
        }
    }
}