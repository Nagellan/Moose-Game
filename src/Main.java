import com.company.*;

public class Main {
    public static void main(String[] args) {
        Moose moose1 = new Unfussy();
        Moose moose2 = new Greedy();
        Duel duel = new Duel(moose1, moose2);
        duel.play(500);
        duel.getResults();
    }
}
