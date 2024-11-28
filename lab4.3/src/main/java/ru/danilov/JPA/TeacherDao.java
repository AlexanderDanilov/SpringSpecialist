package ru.danilov.JPA;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TeacherDao extends CrudRepository<Teacher, Long> {

    //@Query("SELECT t FROM Teacher t WHERE t.name LIKE '%' || ?1 || '%'")
    @Query("SELECT t FROM Teacher t WHERE t.name LIKE %:name%")
    Iterable<Teacher> findByName(@Param(value = "name" ) String name);

}
