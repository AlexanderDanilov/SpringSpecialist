package ru.danilov;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.danilov.Figure.Shape;

import java.util.List;

@AllArgsConstructor
@Component
public class Scene {

    @Setter(onMethod_ = @__({@Autowired}))
    private final List<Shape> shapes;

    public void draw() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
