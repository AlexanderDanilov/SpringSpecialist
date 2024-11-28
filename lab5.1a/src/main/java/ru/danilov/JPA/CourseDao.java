package ru.danilov.JPA;



import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface CourseDao extends CrudRepository<Course, Integer>,CourseDaoCustomized {

}
