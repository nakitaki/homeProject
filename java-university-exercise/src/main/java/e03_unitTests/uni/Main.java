package e03_unitTests.uni;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Course course1 = new Course("CITB401", 6, CourseType.REQUIRED);
        Course course2 = new Course("CITB402", 3, CourseType.REQUIRED);
        Course course3 = new Course("CITB403", 6, CourseType.REQUIRED);
        System.out.println(Course.getNumberOfInstances());
        Course course4 = new Course("CITB404", 3, CourseType.ELECTIVE);
        Course course5 = new Course("CITB405", 6, CourseType.ELECTIVE);
        System.out.println(Course.getNumberOfInstances());


        List<Course> courseList = new ArrayList<>();


        courseList.add(course1);
        courseList.add(course2);
        courseList.add(course3);
        courseList.add(course4);
        courseList.add(course5);

        for (Course course: courseList) {
            System.out.println(course);
        }

        System.out.println(ProgramType.MAJOR);
        System.out.println(ProgramType.MAJOR.getCredits());
        System.out.println(ProgramType.MINOR.getCredits());
        ProgramType.MAJOR.setCredits(300);
        System.out.println(ProgramType.MAJOR.getCredits());

        Program program = new Program("IT", ProgramType.MAJOR);
        program.addCourseToProgram(course1);
        program.addCourseToProgram(course2);
        program.addCourseToProgram(course3);
        program.addCourseToProgram(course4);
        System.out.println(program.addCourseToProgram(course1));
        System.out.println(program.removeCourseToProgram(course5));
        program.printCourses();

        System.out.println(program.totalCredits());
    }
}