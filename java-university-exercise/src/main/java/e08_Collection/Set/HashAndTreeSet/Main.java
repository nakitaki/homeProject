package e08_Collection.Set.HashAndTreeSet;

public class Main {
    public static void main(String[] args) {
        Course java = new Course("Java",3);
        Course java1 = new Course("Java",6);
        Course oop = new Course("OOP",1);
        Course cPlusPlus = new Course("C++", 2);
        Course python = new Course("Python", 6);
        Course js = new Course("JS", 2);

        Program computerScience = new Program("Computer Science");
        computerScience.addCourseToHashSet(python);
        computerScience.addCourseToHashSet(java);
        computerScience.addCourseToHashSet(java1);
        computerScience.addCourseToHashSet(oop);
        computerScience.addCourseToHashSet(cPlusPlus);
        computerScience.addCourseToHashSet(python);
        computerScience.addCourseToHashSet(oop);
        computerScience.displayCoursesInHashSet();

        python.setNumberOfCredits(3);
        computerScience.displayCoursesInHashSet(); //it doesn't add new one with different credits - it changes the old one

        computerScience.addCourseToTreeSet(python);
        computerScience.addCourseToTreeSet(java);
        computerScience.addCourseToTreeSet(java1);
        computerScience.addCourseToTreeSet(oop);
        computerScience.addCourseToTreeSet(cPlusPlus);
        computerScience.addCourseToTreeSet(python);
        computerScience.addCourseToTreeSet(oop);
        computerScience.displayCoursesInTreeSet();

        python.setNumberOfCredits(9);
        computerScience.addCourseToTreeSet(js);
        computerScience.displayCoursesInTreeSet();

    }
}
