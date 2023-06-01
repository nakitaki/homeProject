package e12_TestPreparation.prep1.service;

import e12_TestPreparation.prep1.exceptions.MaxNumberOfPlayersExceededException;
import e12_TestPreparation.prep1.sports.Player;
import e12_TestPreparation.prep1.sports.SportCategory;
import e12_TestPreparation.prep1.sports.Team;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public class TeamServiceImpl implements TeamService{
    private PlayerService playerService;

    public TeamServiceImpl(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Override
    public void printPlayers(Team team) {

    }

    public boolean addPlayer(Team team, Player player) throws MaxNumberOfPlayersExceededException {
        if(team.getMaxPlayers() <= team.getPlayers().size()){
            throw new MaxNumberOfPlayersExceededException();
        }
        else {
            return team.getPlayers().add(player);
        }
    }

    @Override
    public double totalPayment(Team team) {
        return 0;
    }

    @Override
    public double maxPlayerPayment(Team team) {
        return team.getPlayers()
                .stream()
                .map(player -> this.playerService
                        .paymentValue(player))
                .max(Double::compareTo)
                .get();
    }

    @Override
    public Set<Player> playersByRegistrationDateGreaterThan(Team team, LocalDate localDate) {
        return team.getPlayers()
                .stream()
                .filter(player -> player.getRegistrationDate().isAfter(localDate))
                .collect(Collectors.toSet());
        //.count() -> if we want just to count them
        //.limit(5) -> if we want only 5 of them
    }

    @Override
    public Set<Player> playersByNameAndSportCategory(Team team, String name, SportCategory sportCategory) {
        return team.getPlayers()
                .stream()
                .filter(player -> player.getName().equals(name) && player.getSportCategory().equals(sportCategory))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Player> playersByRegistrationDateBetween(Team team, LocalDate startDate, LocalDate endDate) {
        return team.getPlayers()
                .stream()
                .filter(player -> player.getRegistrationDate().isAfter(startDate) && player.getRegistrationDate().isAfter(endDate))
                .collect(Collectors.toSet());
    }

    @Override
    public double totalPaymentBySportCategory(Team team, SportCategory sportCategory) {
        return 0;
    }

    @Override
    public double averagePayment(Team team) {
        return 0;
    }

    @Override
    public Set<Player> playersOrderedByName(Team team) {
        return null;
    }

    @Override
    public Set<Player> playersNameStartsWithOrderedByRegistrationDate(Team team, String nameStart) {
        return null;
    }

    @Override
    public Player playerByUuid(Team team, String uuid) {
        return null;
    }


}
