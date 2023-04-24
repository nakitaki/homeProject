package org.example.uni;

import java.util.ArrayList;
import java.util.List;

public class Program {
    private String name;
    private ProgramType programType;
    private List<Course> courses;

    public Program(String name, ProgramType programType) {
        this.name = name;
        this.programType = programType;
        courses = new ArrayList<>();
    }

    public boolean addCourse(Course course){
        if(this.courses.contains(course)){
            return false;
        }
        else{
            return this.courses.add(course);
        }
    }

    public boolean removeCourse(Course course){
        if(this.courses.contains(course)){
            return this.courses.remove(course);
        }
        else{
            return false;
        }
    }

    public void printCourses(){
        for (Course course: this.courses) {
            System.out.println(course);
        }
    }

    public void printCourses(CourseType courseType){
        for(Course course: courses){
            if(course.getCourseType() == courseType){
                System.out.println(course);
            }
        }
    }

    public int totalCredits(){
        int sum = 0;
        for(Course course: courses){
            sum+= course.getCredits();
        }
        return sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProgramType getProgramType() {
        return programType;
    }

    public void setProgramType(ProgramType programType) {
        this.programType = programType;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Program{" +
                "name='" + name + '\'' +
                ", programType=" + programType +
                ", courses=" + courses +
                '}';
    }
}
