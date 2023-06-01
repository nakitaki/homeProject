package e12_TestPreparation.service;

import e12_TestPreparation.prep1.service.PlayerService;
import e12_TestPreparation.prep1.service.PlayerServiceImpl;
import e12_TestPreparation.prep1.sports.Player;
import e12_TestPreparation.prep1.sports.SportCategory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class PlayerServiceImplTest {
    @InjectMocks
    private PlayerServiceImpl sportsmanService;
    @Mock
    private Player player;
    @Mock
    private SportCategory sportCategory;

    @Test
    void paymentValue() {
        // given
        when(sportCategory.getIncreasePercentage()).thenReturn(10.);

        when(player.getSportCategory()).thenReturn(sportCategory);
        when(player.getAnnualSalary()).thenReturn(10000.);

        double expected = 11000;

        // when
        double actual = sportsmanService.paymentValue(player);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void sportsmanWithGreaterPayment() {
        // given
        PlayerService spyPlayerService = spy(PlayerServiceImpl.class);

        Player player1 = mock(Player.class);
        Player player2 = mock(Player.class);

        doReturn(17000.).when(spyPlayerService).paymentValue(player1);
        doReturn(16000.).when(spyPlayerService).paymentValue(player2);

        // when
        Player actual = spyPlayerService.sportsmanWithGreaterPayment(player1, player2);

        // then
        assertEquals(player1, actual);
    }
}
