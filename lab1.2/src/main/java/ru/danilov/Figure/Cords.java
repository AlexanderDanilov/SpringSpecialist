package ru.danilov.Figure;





public record Cords(int x, int y) {
    @Override
    public String toString() {
        return "Cords{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
