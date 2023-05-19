package e10_Reflection.ex2;

import java.util.ArrayList;
import java.util.List;

public class SportsTeam {
    private String name;
    private int maxPlayers;
    private List<Sportsman> sportsmen;

    public SportsTeam(String name, int maxPlayers) {
        this.name = name;
        this.maxPlayers = maxPlayers;
        sportsmen = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public List<Sportsman> getSportsmen() {
        return sportsmen;
    }

    @Override
    public String toString() {
        return "SportsTeam{" +
                "name='" + name + '\'' +
                ", maxPlayers=" + maxPlayers +
                ", sportsmen=" + sportsmen +
                '}';
    }
}
