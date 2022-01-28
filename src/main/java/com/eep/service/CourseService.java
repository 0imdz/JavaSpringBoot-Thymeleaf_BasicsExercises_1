package com.eep.service;

import com.eep.entity.Course;

import java.util.ArrayList;
import java.util.List;

public interface CourseService {
    public abstract Course findCourseById(int id);
    public abstract List<Course> listAllCourses();
    public abstract Course addCourse (Course course);
    public Course updateCourse(Course course);
    public List<Integer> listCoursesParaBorrar(ArrayList<Integer> id);
    public int removeCourse(int id);
}
