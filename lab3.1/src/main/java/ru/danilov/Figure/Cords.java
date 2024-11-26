package ru.danilov.Figure;


import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Getter
@Setter
public class Cords {
    private int x;
    private int y;

    public Cords() {
        System.out.println("cords prototype created");
    }

    @Override
    public String toString() {
        return String.format("x: %d, y: %d", x, y);
    }
}
