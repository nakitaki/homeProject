package e10_Reflection.ex2;

public class SportsTeamService {
    private SportsmanServiceImpl sportsmanServiceImpl;

    public SportsTeamService(SportsmanServiceImpl sportsmanServiceImpl) {
        this.sportsmanServiceImpl = sportsmanServiceImpl;
    }

    public void printPlayers(SportsTeam sportsTeam){
        sportsTeam
                .getSportsmen()
                .stream()
                .forEach(System.out::println);
    }

    public boolean addPlayer(SportsTeam sportsTeam, Sportsman sportsman) throws MaxNumberOfPlayersExceededException {
        if (sportsTeam.getMaxPlayers()>=sportsTeam.getSportsmen().size()){
            throw new MaxNumberOfPlayersExceededException();
        }
        return sportsTeam.getSportsmen().add(sportsman);
    }

    public double totalPayment(SportsTeam sportsTeam){
        return sportsTeam
                .getSportsmen()
                .stream()
                .map(sportsman -> sportsmanServiceImpl.paymentValue(sportsman))
                .reduce(0., Double::sum);
    }
}

