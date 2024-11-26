package ru.danilov;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import ru.danilov.Figure.Circle;
import ru.danilov.Figure.Cords;
import ru.danilov.Figure.Point;

import java.util.Arrays;


@Configuration
@PropertySource("graph.properties")
@ComponentScan("ru.danilov")
public class ConfigurationGraph {

    @Setter(onMethod_ = {@Autowired})
    private ApplicationContext applicationContext;

    @Setter(onMethod_ = {@Autowired})
    private Environment environment;

    //create point bean
    @Bean
    public Point createPoint() {
        //Задача была сделать Cords через аннотации
        Cords cords = applicationContext.getBean(Cords.class);
        cords.setX(environment.getProperty("point.x", Integer.class));
        cords.setY(environment.getProperty("point.y", Integer.class));
        String color = environment.getProperty("point.color");
        return new Point(cords, color);
    }

    //create circle bean
    @Bean
    public Circle createCircle() {
        Cords cords = applicationContext.getBean(Cords.class);
        cords.setX(environment.getProperty("circle.x", Integer.class));
        cords.setY(environment.getProperty("circle.y", Integer.class));
        int radius = environment.getProperty("circle.radius", Integer.class);
        String color = environment.getProperty("circle.color");
        return new Circle(cords, color,radius);
    }

    //create scene bean
    @Bean
    public Scene createScene() {
        return new Scene(Arrays.asList(createPoint(), createCircle()));
    }
}
