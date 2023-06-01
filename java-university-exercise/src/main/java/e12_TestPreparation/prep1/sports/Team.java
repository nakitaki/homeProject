package e12_TestPreparation.prep1.sports;

import java.util.HashSet;
import java.util.Set;

public class Team {
    private String name;
    private int maxPlayers;
    private Set<Player> players;

    public Team(String name, int maxPlayers) {
        this.name = name;
        this.maxPlayers = maxPlayers;
        this.players = new HashSet<>();
    }

    public Team(String name, int maxPlayers, Set<Player> players) {
        this.name = name;
        this.maxPlayers = maxPlayers;
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", maxPlayers=" + maxPlayers +
                ", players=" + players +
                '}';
    }
}
