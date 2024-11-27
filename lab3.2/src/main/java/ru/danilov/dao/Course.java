package ru.danilov.dao;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Course implements Serializable {

    private int id;
    private String title;
    private int length;
    private String description;

    @Override
    public String toString() {
        return String.format("%-3d %-50s %-4d",
                getId(), getTitle(), getLength());
    }

}
