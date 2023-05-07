package e03_unitTests.uni;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {

    private Program program;

    @BeforeEach
    public void init(){
        Course course1 = new Course("CITB401", 6, CourseType.REQUIRED);
        Course course2 = new Course("CITB402", 3, CourseType.REQUIRED);
        Course course3 = new Course("CITB403", 6, CourseType.REQUIRED);

        List<Course> courses = Arrays.asList(course1, course2,course3);

        program = new Program("IT", ProgramType.MAJOR, courses);
    }
    @Test
    void testTotalCreditsWhenListIsEmpty() {
        Program program = new Program("IT", ProgramType.MAJOR);
        assertEquals(0, program.totalCredits());
    }

    @Test
    void testTotalCreditsWhenListIsNotEmpty() {
        assertEquals(15, program.totalCredits());
    }

    @Test
    void testTotalCreditsWhenListIsWithZeroValues() {
        Course course1 = new Course("CITB401", 0, CourseType.REQUIRED);
        Course course2 = new Course("CITB402", 0, CourseType.REQUIRED);
        Course course3 = new Course("CITB403", 0, CourseType.REQUIRED);

        List<Course> courses = Arrays.asList(course1, course2,course3);

        Program program = new Program("IT", ProgramType.MAJOR, courses);
        assertEquals(0, program.totalCredits());
    }
}