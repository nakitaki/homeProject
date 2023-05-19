package e10_Reflection.ex2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SportsmanServiceImplTest {

    @InjectMocks
    private SportsmanServiceImpl sportsmanServiceImpl;

    @Mock
    private Sportsman sportsman;

    @BeforeEach
    void init(){
        this.sportsmanServiceImpl = new SportsmanServiceImpl();
    }


    @Test
    void paymentValue() {
        when(sportsman.getAnnualSalary()).thenReturn(10000.);
        when(sportsman.getSportsmanCategory()).thenReturn(SportsmanCategory.FOOTBALL);

        double expected = 11000;

        double actual = sportsmanServiceImpl.paymentValue(sportsman);

         assertEquals(expected,actual);

    }
}