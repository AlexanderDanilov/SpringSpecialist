package ru.danilov.Figure;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Point extends Shape {
    private Cords cords;

    public Point(Cords cords,String color) {
        super(color);
        this.cords = cords;
    }

    @Override
    public void draw() {
        System.out.println("Draw point with cords: " + cords + " color: " + getColor());
    }

    @Override
    public void erase() {
        System.out.println("Erase point with cords: " + cords + " color: " + getColor());
    }
}
