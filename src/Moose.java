import java.util.LinkedList;
import java.util.Random;

public class Moose extends Player {
    private LinkedList<Integer> moves;
    private LinkedList<Integer> opponentMoves;

    public Moose() {
        this.reset();
    }

    @Override
    public void reset() {
        this.moves = new LinkedList<>();
        this.opponentMoves = new LinkedList<>();
    }

    @Override
    public int move(int opponentLastMove, int xA, int xB, int xC) {
        int move;

        // make the first turn into the random field without saving opponent's move
        if (opponentLastMove == 0) {
            return new Random().nextInt(3) + 1;
        } else {
            this.opponentMoves.push(opponentLastMove);
        }

        move = 1;

        this.moves.push(move);

        return move;
    }
}