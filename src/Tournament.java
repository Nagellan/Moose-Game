public class Tournament {
    private int xA;
    private int xB;
    private int xC;
    private int numRounds;
    private Moose moose1;
    private Moose moose2;

    public Tournament(Moose moose1, Moose moose2) {
        this.xA = 1;
        this.xB = 1;
        this.xC = 1;
        this.numRounds = 0;
        this.moose1 = moose1;
        this.moose2 = moose2;
    }

    public void play(int numRounds) {
        this.numRounds = numRounds;
        int[] fieldsChange = {1, 1, 1};

        int moose1LastMove = 0;
        int moose2LastMove = 0;

        for (int r = 0; r < numRounds; r++) {
            int moose1Move = this.moose1.move(moose2LastMove, this.xA, this.xB, this.xC);
            int moose2Move = this.moose2.move(moose1LastMove, this.xA, this.xB, this.xC);

            fieldsChange[moose1Move - 1] = -1;
            fieldsChange[moose2Move - 1] = -1;

            this.xA = Math.max(0, this.xA + fieldsChange[0]);
            this.xB = Math.max(0, this.xB + fieldsChange[1]);
            this.xC = Math.max(0, this.xC + fieldsChange[2]);

            moose1LastMove = moose1Move;
            moose2LastMove = moose2Move;
        }
    }

    public void getResults() {
        System.out.println("Amount of rounds: " + this.numRounds);
        System.out.println("Fields stats: xA=" + this.xA + ", xB=" + this.xB + ", xC=" + xC);
        System.out.println("Moose 1 score: " + this.moose1.getScore());
        System.out.println("Moose 2 score: " + this.moose2.getScore());
    }
}
