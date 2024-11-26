package ru.danilov.Figure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
public abstract class Shape {

    public abstract void draw();

    @Getter
    @Setter
    private String color;

}
