package ru.danilov.JPA;


import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CourseDaoCustomized {
    double medianaLength();
    double averageLength();
    CourseDaoCustomizedImpl.medianaAverage getMedianaAverage();
}
