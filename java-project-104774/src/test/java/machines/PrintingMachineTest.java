package machines;

import exception.ExceededPageCountException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.PageSize;
import pages.PageType;
import pages.Paper;
import printMedia.MediaType;
import printMedia.PrintMedia;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PrintingMachineTest {

    PrintingMachineServiceImp printingMachineService;
    PrintingMachine printingMachine;
    Paper paper;
    PrintMedia printMedia;

    @BeforeEach
    void init(){
        printingMachineService = new PrintingMachineServiceImp();
        printingMachine = new PrintingMachine(100, 99, true,100);
        paper = new Paper(PageSize.A2, PageType.GLOSSY_PAPER);
        printMedia = new PrintMedia("Book1", MediaType.BOOK, 20, paper, true);

    }

    @Test
    void testAddTooManyPages() {
        assertThrows(ExceededPageCountException.class, ()->printingMachineService.addPages(printingMachine,101));
    }

    //reflection
    @Test
    void testAddPages() throws ExceededPageCountException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        printingMachineService.addPages(printingMachine,1); //99+1

        Class<?> printingMachineClass = Class.forName("machines.PrintingMachine");

        Field field = printingMachineClass.getDeclaredField("availablePages");
        field.setAccessible(true);

        assertEquals(100, field.get(printingMachine));
    }

    @Test
    void testHasNotEnoughSpaceForPages() {
        assertFalse(()->printingMachineService.hasEnoughSpaceForPages(printingMachine,101));
    }

    @Test
    void testHasEnoughSpaceForPages(){
        assertTrue(()->printingMachineService.hasEnoughSpaceForPages(printingMachine,1));
    }

    @Test
    void testHasNotEnoughPages() {
        assertFalse(printingMachineService.hasEnoughPages(printingMachine,printMedia, 10));
    }

    @Test
    void testHasEnoughPages() {
        assertTrue(printingMachineService.hasEnoughPages(printingMachine,printMedia, 2));
    }

    @Test
    void testTotalPages() {
        int expected = 20*3;
        int actual = printingMachineService.totalPages(printMedia,3);
        assertEquals(expected,actual);
    }
}