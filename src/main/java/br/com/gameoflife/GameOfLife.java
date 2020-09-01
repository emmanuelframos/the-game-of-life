package br.com.gameoflife;

public class GameOfLife {

    /** Matrix Dimension **/
    private final static Integer DIMENSION = 6;

    /** Ticks to run **/
    private final static Integer TICKS = 6;

    public static void main(String[] args) {

        Board board = new Board();
        board.init(DIMENSION);

        System.out.println("Printing initial population...");
        board.print();

        for (int tickIndex = 0; tickIndex < TICKS; tickIndex++){
            board.tick();
            System.out.printf("Printing after tick #%d...\n", tickIndex+1);
            board.print();
        }
    }
}
