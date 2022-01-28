package com.eep.controller;

import com.eep.entity.Course;
import com.eep.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    @Qualifier("courseServiceImpl")
    private CourseService courseService;

    private static final String  COURSES_VIEW="courses";

    @GetMapping("/listCourses")
    public ModelAndView listAllCourses(){
        ModelAndView mav = new ModelAndView(COURSES_VIEW);
        mav.addObject(new Course());
        mav.addObject("courses", courseService.listAllCourses());
        return mav;
    }

    @GetMapping("/eliminar/{id}")
    public String deleteCourse(@PathVariable int id){

        //System.out.println(iterador);

        courseService.removeCourse(id);

        //courseService.listCoursesParaBorrar(iterador);
        return "redirect:/courses/listCourses";
    }

    @PostMapping("/addcourse")
    public String addCourse(@ModelAttribute("course") Course course){
        courseService.addCourse(course);
        return "redirect:/courses/listCourses";
    }

    @GetMapping("/editar/{id}")
    public String editarPorId(@PathVariable int id,
                              Model model) {
        Course courseEnviado = courseService.findCourseById(id);//devolución de un course
        System.out.println(id);
        model.addAttribute("course", courseEnviado);
        return "editform";
    }

    @PostMapping("/modificacionrealizada")
    public String modificacionRealizada(@ModelAttribute("course") Course course){
        courseService.updateCourse(course);
        return "redirect:/courses/listCourses";
    }

    @GetMapping("/borrado")
    public String borrado() {
        return "borrado";
    }
}
