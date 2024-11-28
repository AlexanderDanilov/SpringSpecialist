package ru.danilov;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.danilov.JPA.Course;
import ru.danilov.JPA.CourseDao;
import ru.danilov.JPA.DaoConfig;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(DaoConfig.class)) {
            CourseDao dao = context.getBean(CourseDao.class);
            System.out.println("Average length:" + dao.averageLength());
            System.out.println("Mediana length:" + dao.medianaLength());
            System.out.println("Mediana and Average without new transaction " + dao.getMedianaAverage());
        }
    }
}