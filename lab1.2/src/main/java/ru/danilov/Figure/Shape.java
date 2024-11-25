package ru.danilov.Figure;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public abstract class Shape {

    public abstract void draw();

    @Getter
    private final String color;

}
