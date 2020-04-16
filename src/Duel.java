import com.company.Moose;

public class Duel {
    private int xA;
    private int xB;
    private int xC;

    private int numRounds;

    final private Moose moose1;
    final private Moose moose2;
    private double moose1Score;
    private double moose2Score;

    public Duel(Moose moose1, Moose moose2) {
        this.xA = 1;
        this.xB = 1;
        this.xC = 1;

        this.numRounds = 0;

        this.moose1 = moose1;
        this.moose2 = moose2;

        this.moose1Score = 0;
        this.moose2Score = 0;
    }

    public void play(int numRounds) {
        this.numRounds = numRounds;

        int moose1LastMove = 0;
        int moose2LastMove = 0;

        for (int r = 0; r < numRounds; r++) {
            int[] fields = {this.xA, this.xB, this.xC};
            int[] fieldsChange = {1, 1, 1};

            // make moves
            int moose1Move = this.moose1.move(moose2LastMove, this.xA, this.xB, this.xC);
            int moose2Move = this.moose2.move(moose1LastMove, this.xA, this.xB, this.xC);

            // update moose scores
            this.moose1Score += moose1Move == moose2Move ? 0 : this.getScore(fields[moose1Move - 1]);
            this.moose2Score += moose1Move == moose2Move ? 0 : this.getScore(fields[moose2Move - 1]);

            // calculate changes in fields' stats
            fieldsChange[moose1Move - 1] = -1;
            fieldsChange[moose2Move - 1] = -1;

            // update fields stats
            this.xA = Math.max(0, this.xA + fieldsChange[0]);
            this.xB = Math.max(0, this.xB + fieldsChange[1]);
            this.xC = Math.max(0, this.xC + fieldsChange[2]);

            moose1LastMove = moose1Move;
            moose2LastMove = moose2Move;
        }

        // reset both moose memory
        this.moose1.reset();
        this.moose2.reset();
    }

    public void getResults() {
        System.out.println("Amount of rounds: " + this.numRounds);
        System.out.println("Fields stats: xA=" + this.xA + ", xB=" + this.xB + ", xC=" + xC);
        System.out.println(this.moose1.getName() + "'s score: " + this.moose1Score);
        System.out.println(this.moose2.getName() + "'s score: " + this.moose2Score);
    }

    private double getScore(int x) {
        return 10 * Math.pow(Math.E, x) / (1 + Math.pow(Math.E, x)) - 5;
    }
}
