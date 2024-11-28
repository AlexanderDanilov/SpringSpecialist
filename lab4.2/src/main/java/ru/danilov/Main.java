package ru.danilov;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.danilov.dao.Course;
import ru.danilov.dao.CourseDAO;
import ru.danilov.dbjDBC.DaoConfig;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(DaoConfig.class)) {
            CourseDAO dao = context.getBean(CourseDAO.class);
            List<Course> courses = dao.findByTitle("Web");
            courses.forEach(System.out::println);
        }
    }
}