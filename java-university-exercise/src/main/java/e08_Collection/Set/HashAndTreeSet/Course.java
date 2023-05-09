package e08_Collection.Set.HashAndTreeSet;

import java.util.Comparator;

public class Course implements Comparable<Course>{
    private String name;
    private int numberOfCredits;

    public Course(String name, int numberOfCredits) {
        this.name = name;
        this.numberOfCredits = numberOfCredits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", numberOfCredits=" + numberOfCredits +
                '}';
    }

    @Override
    public int compareTo(Course course) {
        return this.name.compareTo(course.name);
    }

    public static Comparator<Course> ComparatorByCourseNumberOfCredis = new Comparator<Course>() {
        @Override
        public int compare(Course course, Course course1) {
            return Integer.compare(course.numberOfCredits, course1.numberOfCredits);
        }
    };

    public static Comparator<Course> ComparatorByCourseName = new Comparator<Course>() {
        @Override
        public int compare(Course course, Course course1) {
            return course.name.compareTo(course1.name);
        }
    };
}
