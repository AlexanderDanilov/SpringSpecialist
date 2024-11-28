package ru.danilov;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.danilov.JPA.DaoConfig;
import ru.danilov.JPA.TeacherDao;


public class Main {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(DaoConfig.class, Main.class)){
            TeacherDao dao = context.getBean(TeacherDao.class);
            dao.findByName("Пуп").forEach(System.out::println);
        }
    }
}