package e10_Reflection.ex3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GameTest {

    @InjectMocks
    Game game;

    @Mock
    Player player;


    @Test
    public void attackWithSwordTest() throws Exception {

        when(player.getWeapon()).thenReturn("Sword");

        assertEquals("Player attack with: Sword", game.attack());
    }
}