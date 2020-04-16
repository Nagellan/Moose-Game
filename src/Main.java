import com.company.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Greedy greedy = new Greedy();
        Unfussy unfussy = new Unfussy();
        Random random = new Random();
        Tail tail = new Tail();

        Tournament tournament = new Tournament(new Moose[]{new Greedy(), new Unfussy(), new Random(), new Tail()});
        tournament.start(10, 50);
    }
}
