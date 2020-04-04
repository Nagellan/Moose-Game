import java.util.LinkedList;
import java.util.Random;

public class Moose extends Player {
    private double score;
    private LinkedList<Integer> moves;
    private LinkedList<Integer> opponentMoves;

    public Moose() {
        this.reset();
    }

    @Override
    public void reset() {
        this.score = 0;
        this.moves = new LinkedList<>();
        this.opponentMoves = new LinkedList<>();
    }

    @Override
    public int move(int opponentLastMove, int xA, int xB, int xC) {
        int move;
        int lastMove;
        int[] fields = {xA, xB, xC};

        // make the first turn into the random field without saving opponent's move
        if (opponentLastMove == 0) {
            move = new Random().nextInt(3) + 1;
            this.moves.push(move);
            return move;
        }

        this.opponentMoves.push(opponentLastMove);
        lastMove = this.moves.peek();

        // if both moose are in one field, reset score and don't eat
        if (opponentLastMove == lastMove) {
            this.score = 0;
        } else {
            this.eat(fields[lastMove - 1]);
        }

        move = this.decide();
        this.moves.push(move);

        return move;
    }

    private void eat(int x) {
        this.score += 10 * Math.pow(Math.E, x) / (1 + Math.pow(Math.E, x)) - 5;
    }

    private int decide() {
        return 1;
    }

    public double getScore() {
        return score;
    }
}