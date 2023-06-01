package e12_TestPreparation.service;

import e12_TestPreparation.prep1.service.PlayerService;
import e12_TestPreparation.prep1.service.TeamServiceImpl;
import e12_TestPreparation.prep1.sports.Player;
import e12_TestPreparation.prep1.sports.Team;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TeamServiceImplTest {

    @InjectMocks
    private TeamServiceImpl teamService;
    @Mock
    private PlayerService playerService;
    @Mock
    private Team team;


    @Test
    void maxPlayerPayment() {
        //given
        Player player1 = mock(Player.class);
        Player player2 = mock(Player.class);
        Player player3 = mock(Player.class);

        Set<Player> players = new HashSet<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);

        when(team.getPlayers()).thenReturn(players);

        when(playerService.paymentValue(player1)).thenReturn(10000.);
        when(playerService.paymentValue(player2)).thenReturn(15000.);
        when(playerService.paymentValue(player3)).thenReturn(12000.);

        double expectedMaxValue = 15000;
//        when(playerService.paymentValue(player1))
//                .thenReturn(10000.)
//                .thenReturn(12000.)
//                .thenReturn(15000.);
//
//        double expectedMaxValue = 37000;

        //when
        double actualMaxValue = teamService.maxPlayerPayment(team);

        //then
        assertEquals(expectedMaxValue, actualMaxValue);
    }

    @Test
    void playersByRegistrationDateGreaterThan() {
        //given
        //p1 p2 p3 2020 2022 2022
        Player player1 = mock(Player.class);
        Player player2 = mock(Player.class);
        Player player3 = mock(Player.class);

        when(player1.getRegistrationDate()).thenReturn(LocalDate.of(2020, 1, 1));
        when(player2.getRegistrationDate()).thenReturn(LocalDate.of(2022, 1, 1));
        when(player3.getRegistrationDate()).thenReturn(LocalDate.of(2022, 3, 1));

        Set<Player> players = new HashSet<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);

        when(team.getPlayers()).thenReturn(players);

        Set<Player> expectedPLayers = new HashSet<>();
        expectedPLayers.add(player2);
        expectedPLayers.add(player3);

        //when
        Set<Player> actualPlayers =
                this.teamService.playersByRegistrationDateGreaterThan(team, LocalDate.of(2021, 1, 1));

        //then
        assertIterableEquals(expectedPLayers, actualPlayers);
    }
}