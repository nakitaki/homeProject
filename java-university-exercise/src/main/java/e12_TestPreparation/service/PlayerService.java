package e12_TestPreparation.service;

import e12_TestPreparation.sports.Player;

public interface PlayerService {
    double paymentValue(Player player);

    Player sportsmanWithGreaterPayment(Player player1, Player player2);
}