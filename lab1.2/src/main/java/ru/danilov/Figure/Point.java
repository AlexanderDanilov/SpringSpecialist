package ru.danilov.Figure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Point extends Shape {
    private final Cords cords;

    public Point(Cords cords,String color) {
        super(color);
        this.cords = cords;
    }

    @Override
    public void draw() {
        System.out.println(String.format("Draw point with cords: %s(color:%s)", cords,getColor()));
    }
}
