import com.company.*;

public class Main {
    public static void main(String[] args) {
        Moose moose1 = new Greedy();
        Moose moose2 = new GreedyRandom();
        Duel duel = new Duel(moose1, moose2);
        duel.play(5);
        duel.getResults();
    }
}
