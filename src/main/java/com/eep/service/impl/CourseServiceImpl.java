package com.eep.service.impl;

import com.eep.entity.Course;
import com.eep.repository.CourseJpaRepository;
import com.eep.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {

    ArrayList<Integer> cursosParaBorrar;

    @Autowired
    @Qualifier("courseJpaRepository")
    private CourseJpaRepository courseJpaRepository;

    @Override
    public List<Course> listAllCourses() {
        // TODO Auto-generated method stub
        return courseJpaRepository.findAll();
    }

    @Override
    public List<Integer> listCoursesParaBorrar(ArrayList<Integer> id){
        cursosParaBorrar=new ArrayList<>();
        return cursosParaBorrar;
    }

    @Override
    public Course addCourse(Course course) {
        // TODO Auto-generated method stub
        return courseJpaRepository.save(course);
    }

    @Override
    public int removeCourse(int id) {
        // TODO Auto-generated method stub
        courseJpaRepository.deleteById(id);
        return 0;
    }

//    @Override
//    public int removeCourseMultiples(int id) {
//        // TODO Auto-generated method stub
//        listCoursesParaBorrar(cursosParaBorrar);
//        for (int i=0; i<cursosParaBorrar.size(); i++){
//            courseJpaRepository.deleteById(id);
//        }
//        return 0;
//    }

    @Override
    public Course findCourseById(int id){
        return courseJpaRepository.findById(id);
    }

    @Override
    public Course updateCourse(Course course) {
        // TODO Auto-generated method stub
        return courseJpaRepository.save(course);
    }

}
