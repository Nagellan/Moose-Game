import com.company.Moose;

public class Main {
    public static void main(String[] args) {
        Moose moose1 = new Moose();
        Moose moose2 = new Moose();
        Duel duel = new Duel(moose1, moose2);
        duel.play(1);
        duel.getResults();
    }
}
