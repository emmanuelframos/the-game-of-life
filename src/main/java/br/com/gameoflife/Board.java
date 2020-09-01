package br.com.gameoflife;

public class Board {

    private int[][] population;

    /** Inits population - with random values - based on matrix dimension **/
    public void init(int dimension){
        population = new int[dimension][dimension];

        for(int rowIndex = 0; rowIndex < dimension; rowIndex ++){
            for(int colIndex = 0; colIndex < dimension; colIndex ++){
                population[rowIndex][colIndex] = (int)Math.round(Math.random());
            }
        }
    }

    /** Apply Game of Life's rules **/
    public void tick(){
        for (int rowIndex = 0; rowIndex < population.length; rowIndex++){
            int[] row = population[rowIndex];

            for (int colIndex = 0; colIndex < row.length; colIndex++){
                int cell = population[rowIndex][colIndex];
                int neighborsAlive = countLivingNeighbors(rowIndex, colIndex);

                if (cell == 1){//live cell
                    population[rowIndex][colIndex] = (neighborsAlive == 2 || neighborsAlive == 3) ? 1 : 0;
                }else if (cell == 0){//dead cell
                    population[rowIndex][colIndex] = (neighborsAlive == 3) ? 1 : 0;
                }
            }
        }
    }

    /** Returns number of living neighbors **/
    private int countLivingNeighbors(int rowIndex, int colIndex){
        int aliveNeighborCounter = 0;

        //row above
        aliveNeighborCounter += isAlive(rowIndex - 1, colIndex -1)  ? 1 : 0;
        aliveNeighborCounter += isAlive(rowIndex - 1, colIndex)     ? 1 : 0;
        aliveNeighborCounter += isAlive(rowIndex - 1, colIndex + 1) ? 1 : 0;

        //same row
        aliveNeighborCounter += isAlive(rowIndex, colIndex -1)  ? 1 : 0;
        aliveNeighborCounter += isAlive(rowIndex, colIndex + 1) ? 1 : 0;

        //row below
        aliveNeighborCounter += isAlive(rowIndex + 1, colIndex -1)  ? 1 : 0;
        aliveNeighborCounter += isAlive(rowIndex + 1, colIndex)     ? 1 : 0;
        aliveNeighborCounter += isAlive(rowIndex + 1, colIndex + 1) ? 1 : 0;

        return aliveNeighborCounter;
    }

    /** Check if neighbor is alive **/
    private boolean isAlive(int rowIndex, int colIndex){
        try{
            return population[rowIndex][colIndex] == 1;
        }catch(Exception ex){
            return false;
        }
    }

    public void print(){
        System.out.println();

        for (int rowIndex = 0; rowIndex < population.length; rowIndex++){
            int[] row = population[rowIndex];

            System.out.printf("row %d =>", rowIndex + 1);

            for (int colIndex = 0; colIndex < row.length; colIndex++){
                System.out.printf(" %d", population[rowIndex][colIndex]);
            }

            System.out.println();
        }
        System.out.println();
    }
}
