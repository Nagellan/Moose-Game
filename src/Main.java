import com.company.Greedy;
import com.company.Moose;
import com.company.Random;
import com.company.Tail;

public class Main {
    public static void main(String[] args) {
        Moose moose1 = new Random();
        Moose moose2 = new Tail();
        Duel duel = new Duel(moose1, moose2);
        duel.play(100);
        duel.getResults();
    }
}
