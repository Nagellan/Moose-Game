import com.company.Moose;

import java.util.LinkedList;

public class Tournament {
    private Moose[] agents;

    public Tournament(Moose[] agents) {
        this.agents = agents;
    }

    public void start(int numPlayers, int numRounds) throws Exception {
        if (numPlayers >= this.agents.length) {
            LinkedList<Moose> players = createPlayers(numPlayers);
            LinkedList<Duel> duels = createDuels(players);

            for (Duel duel : duels) {
                duel.play(numRounds);
                duel.printResults();
            }
        } else {
            throw new Exception("The amount of players must be greater than the amount of agents!");
        }
    }

    private LinkedList<Moose> createPlayers(int numPlayers) {
        int groupSize = Math.floorDiv(numPlayers, this.agents.length);
        LinkedList<Moose> players = new LinkedList<>();

        for (Moose agent : this.agents) {
            for (int i = 0; i < groupSize; i++) {
                players.push(agent.clone());
            }
        }

        return players;
    }

    private LinkedList<Duel> createDuels(LinkedList<Moose> players) {
        LinkedList<Duel> duels = new LinkedList<>();

        for (int i = 0; i < players.size(); i++) {
            for (int j = 0; j < players.size(); j++) {
                if (i != j) {
                    duels.push(new Duel(players.get(i), players.get(j)));
                }
            }
        }

        return duels;
    }
}
