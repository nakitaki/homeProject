package e12_TestPreparation.service;

import e12_TestPreparation.exceptions.MaxNumberOfPlayersExceededException;
import e12_TestPreparation.sports.Player;
import e12_TestPreparation.sports.SportCategory;
import e12_TestPreparation.sports.Team;

import java.time.LocalDate;
import java.util.Set;

public interface TeamService {

    //TODO
    /**
     * @param team
     * prints players in the team
     */
    void printPlayers(Team team);

    //TODO
    /**
     * @param team
     * @param player
     * @return true if the player is added to the team collection of players and false if the player is not added
     * @throws MaxNumberOfPlayersExceededException
     */
    boolean addPlayer(Team team, Player player) throws MaxNumberOfPlayersExceededException;

    //TODO
    /**
     * @param team
     * @return the total value of all payments of the team's players
     */
    double totalPayment(Team team);

    /**
     * @param team
     * @return the value of the max payment of the team's players
     */
    double maxPlayerPayment(Team team);

    /**
     * @param team
     * @param localDate
     * @return set of players in the team, registered after localDate
     */
    Set<Player> playersByRegistrationDateGreaterThan(Team team, LocalDate localDate);

    /**
     * @param team
     * @param name
     * @param sportCategory
     * @return set of players in the team, with given name and sportCategory
     */
    Set<Player> playersByNameAndSportCategory(Team team, String name, SportCategory sportCategory);

    /**
     * @param team
     * @param startDate
     * @param endDate
     * @return set of players in the team, registered between startDate and endDate
     */
    Set<Player> playersByRegistrationDateBetween(Team team, LocalDate startDate, LocalDate endDate);

    //TODO
    /**
     * @param team
     * @param sportCategory
     * @return total value of the payment for players in given sportCategory
     */
    double totalPaymentBySportCategory(Team team, SportCategory sportCategory);

    //TODO
    /**
     * @param team
     * @return average payment of the players in the team
     */
    double averagePayment(Team team);

    //TODO
    /**
     * @param team
     * @return set of players in the team, ordered by name
     */
    Set<Player> playersOrderedByName(Team team);

    //TODO
    /**
     * @param team
     * @param nameStart
     * @return set of players in the team, whose name starts with nameStart, ordered by registrationDate
     */
    Set<Player> playersNameStartsWithOrderedByRegistrationDate(Team team, String nameStart);

    //TODO
    /**
     * @param team
     * @param uuid
     * @return player with a given uuid
     */
    Player playerByUuid(Team team, String uuid);
}
