package ru.danilov;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import ru.danilov.Figure.Shape;

import java.util.List;

@AllArgsConstructor
public class Scene {

    private final List<Shape> shapes;

    public void draw() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
