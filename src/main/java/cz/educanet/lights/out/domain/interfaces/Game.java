package cz.educanet.lights.out.domain.interfaces;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Random;

public class Game implements ILightsOut {
    private int moves;
    private boolean[][] grid = new boolean[5][5];
    private boolean gameOver = true;

    public Game() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                Random random = new Random();
                grid[i][j] = random.nextBoolean();
            }
        }
    }

    @Override
    public int getMoveCount() {
        return moves;
    }

    @Override
    public boolean isGameOver() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j]) {
                    gameOver = false;
                }
            }
        }
        return gameOver;
    }

    @Override
    public boolean[][] getGrid() {
        return grid;
    }

    @Override
    public void makeMove(int x, int y) {
        getGrid()[x][y] = !getGrid()[x][y];
        if (x + 1 <= 4) {
            getGrid()[x + 1][y] = !getGrid()[x + 1][y];
        }
        if (x - 1 >= 0) {
            getGrid()[x - 1][y] = !getGrid()[x - 1][y];
        }
        if (y + 1 <= 4) {
            getGrid()[x][y + 1] = !getGrid()[x][y + 1];
        }
        if (y - 1 >= 0) {
            getGrid()[x][y - 1] = !getGrid()[x][y - 1];
        }
        moves++;
    }

    @Override
    public void save() {
        Data data = new Data();
        data.saveGame(grid);
    }

    @Override
    public void load() {
        Data data = new Data();
        this.grid = data.loadGame();
    }
}


