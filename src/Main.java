import com.company.Moose;

public class Main {
    public static void main(String[] args) {
        Moose moose1 = new Moose();
        Moose moose2 = new Moose();
        Tournament battle = new Tournament(moose1, moose2);
        battle.play(1);
        battle.getResults();
    }
}
