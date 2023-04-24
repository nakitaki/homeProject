package org.example.uni;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private final String facultyNumber;
    private boolean graduated;
    private List<Program> programs;
    private List<Course> courses;
    private List<Course> graduatedCourses;

    public Student(String facultyNumber) {
        this.facultyNumber = facultyNumber;
        this.programs = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.graduatedCourses = new ArrayList<>();
    }

    public Student(String name, String facultyNumber, boolean graduated) {
        this.name = name;
        this.facultyNumber = facultyNumber;
        this.graduated = graduated;
        graduated = false;
        this.programs = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.graduatedCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public boolean isGraduated() {
        return graduated;
    }

    public void setGraduated(boolean graduated) {
        this.graduated = graduated;
    }

    public boolean isProgramTypeEnrolled(ProgramType programType){
        for(Program program: this.programs){
            if(program.getProgramType() == programType) return true;
        }
        return false;
    }
    public void addProgram(Program program){
        if(!isProgramTypeEnrolled(program.getProgramType())){
            this.programs.add(program);
        }
    }
    public void removeProgram(Program program){
        if(this.programs.contains(program)){
            this.programs.remove(program);
        }
    }
    public void addCourse(Course course){
        boolean isCourseAdded = false;
        for (Program program: this.programs) {
            if(program.getCourses().contains(course)){
                this.courses.add(course);
                isCourseAdded = true;
                break;
            }
        }
        System.out.println("The course is added:" + isCourseAdded);
    }

    public void removeCourse(Course course){
        if(this.courses.contains(course)){
            this.courses.remove(course);
        }
    }

    public void graduateCourse(Course course){
        boolean isCourseGraduated = false;
        if(this.courses.contains(course)){
            this.graduatedCourses.add(course);
            isCourseGraduated = true;
        }
        System.out.println("The course is graduated: " + isCourseGraduated);
    }

    public void removeGraduatedCourse(Course course){
        if(this.graduatedCourses.contains(course)){
            this.graduatedCourses.remove(course);
        }
    }

    public int numberOfCreditsGot(){
        int nunmberOfCredits = 0;
        for(Course course: this.graduatedCourses){
            nunmberOfCredits+= course.getCredits();
        }
        return nunmberOfCredits;
    }

    public int numberOfCreditsToGet(){
        return ProgramType.MAJOR.getCredits() - numberOfCreditsGot();
    }

    public void graduateStudent(){
        if(numberOfCreditsToGet() == 0){
            this.graduated = true;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", facultyNumber='" + facultyNumber + '\'' +
                ", graduated=" + graduated +
                '}';
    }
}
