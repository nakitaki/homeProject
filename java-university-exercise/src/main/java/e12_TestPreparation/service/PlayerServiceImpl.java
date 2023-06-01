package e12_TestPreparation.service;

import e12_TestPreparation.sports.Player;

public class PlayerServiceImpl implements PlayerService {

    public double paymentValue(Player player) {
        return player.getAnnualSalary() +
                player.getAnnualSalary()
                        * player.getSportCategory().getIncreasePercentage() / 100;

    }

    public Player sportsmanWithGreaterPayment(Player player1, Player player2) {
        return paymentValue(player1) > paymentValue(player2) ? player1 : player2;
    }
}
