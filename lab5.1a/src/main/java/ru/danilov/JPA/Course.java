package ru.danilov.JPA;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String name;
    private Integer length;

}
