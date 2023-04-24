package org.example.uni;

public class Course {
    private String name;
    private final long id;
    private int credits;
    private CourseType courseType;
    private static int numberOfCourses = 0;

    public Course(String name, int credits, CourseType courseType) {
        Course.numberOfCourses++;
        id = Course.numberOfCourses;
        this.name = name;
        this.credits = credits;
        this.courseType = courseType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public static int getNumberOfCourses() {
        return numberOfCourses;
    }

    public static void setNumberOfCourses(int numberOfCourses) {
        Course.numberOfCourses = numberOfCourses;
    }


    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", credits=" + credits +
                ", courseType=" + courseType +
                '}';
    }
}
