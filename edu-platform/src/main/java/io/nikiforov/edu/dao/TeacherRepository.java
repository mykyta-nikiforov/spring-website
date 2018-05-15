package io.nikiforov.edu.dao;

import io.nikiforov.edu.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    @Query("select t from Teacher t left join t.curatedGroup g where " +
            "g.curator is null")
    List<Teacher> findFreeCurators();
}

