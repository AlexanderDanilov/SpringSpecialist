package ru.danilov.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;




public class JdbcCourseDAO implements CourseDAO {

    private static final String SQL_SELECT_COURSE =
            "SELECT id, title, length, description FROM courses";

    private static final String SQL_SELECT_COURSE_BY_ID =
            SQL_SELECT_COURSE + " WHERE id = ?";

    private static final String SQL_SELECT_COURSE_BY_TITLE =
            SQL_SELECT_COURSE+" WHERE title LIKE ?";

    private static final String SQL_DELETE_COURSE_BY_ID =
            "DELETE FROM courses WHERE id = ?";

    private static final String SQL_INSERT_COURSE =
            "INSERT INTO courses (title, length, description) VALUES (?, ?, ?)";

    private static final String SQL_UPDATE_COURSE =
            "UPDATE courses SET title = ?, length = ?, description = ? WHERE id = ?";


    @Getter
    @Setter
    private JdbcTemplate jdbcTemplate;


    @Override
    public Course findById(int id) {
        Course course = getJdbcTemplate().queryForObject(
                SQL_SELECT_COURSE_BY_ID, new Object[] {id},
                new CourseRowMapper() );
        return course;
    }

    @Override
    public List<Course> findAll() {
        List<Course> courses = getJdbcTemplate().query(SQL_SELECT_COURSE,
                //new CourseRowMapper());
                new BeanPropertyRowMapper(Course.class));
        return courses;
    }

    @Override
    public List<Course> findByTitle(String title) {

        return  jdbcTemplate.query(SQL_SELECT_COURSE_BY_TITLE,
                new Object[] { "%"+title+"%"},
                new BeanPropertyRowMapper(Course.class));
    }

    @Override
    public void insert(Course course) {
        PreparedStatementCreatorFactory f =
                new PreparedStatementCreatorFactory(SQL_INSERT_COURSE,
                        Types.NVARCHAR, Types.INTEGER, Types.NVARCHAR);

        f.setGeneratedKeysColumnNames("id");
        KeyHolder kh = new GeneratedKeyHolder();

        getJdbcTemplate().update(
                f.newPreparedStatementCreator(new Object[] {
                        course.getTitle(), course.getLength(), course.getDescription()}),
                kh);

        course.setId(kh.getKey().intValue());

    }

    @Override
    public void update(Course course) {
        getJdbcTemplate().update(SQL_UPDATE_COURSE,
                course.getTitle(), course.getLength(),
                course.getDescription(), course.getId());

    }

    @Override
    public void delete(int id) {
        getJdbcTemplate().update(SQL_DELETE_COURSE_BY_ID, id);
    }


    private static class CourseRowMapper implements RowMapper<Course> {

        @Override
        public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
            Course c = new Course();
            c.setId( rs.getInt("id") );
            c.setTitle( rs.getString("title") );
            c.setLength( rs.getInt("length") );
            c.setDescription( rs.getString("description") );
            return c;
        }
    }

}
