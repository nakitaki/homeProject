package e12_TestPreparation.prep1.service;

import e12_TestPreparation.prep1.sports.Player;

public interface PlayerService {
    double paymentValue(Player player);

    Player sportsmanWithGreaterPayment(Player player1, Player player2);
}