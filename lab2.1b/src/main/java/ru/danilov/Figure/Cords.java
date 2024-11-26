package ru.danilov.Figure;


import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class Cords {

    private int x;
    private int y;

    @Override
    public String toString() {
        return "Cords{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

}

