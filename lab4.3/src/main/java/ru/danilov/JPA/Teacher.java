package ru.danilov.JPA;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "teachers")
@Getter
@Setter
@NoArgsConstructor
public class Teacher extends AbstractEntity{
    private String name;
    private String addr;
    private String phone;

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + super.getId() +
                " name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}