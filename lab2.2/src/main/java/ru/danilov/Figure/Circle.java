package ru.danilov.Figure;



public class Circle extends Shape{
    private Cords center;
    private int radius;


    public Circle(Cords cords, String color,int radius) {
        super(color);
        this.center = cords;
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println(String.format("Draw circle with cords: %s(color:%s) radius: %d", center,getColor(),radius));
    }
}
