package ru.danilov.JPA;


import org.springframework.transaction.annotation.Transactional;

public interface CourseDaoCustomized {
    double medianaLength();
    double averageLength();

    @Transactional(readOnly = true)
    CourseDaoCustomizedImpl.medianaAverage getMedianaAverage();
}
