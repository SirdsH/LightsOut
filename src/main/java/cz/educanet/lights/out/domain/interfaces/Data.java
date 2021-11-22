package cz.educanet.lights.out.domain.interfaces;

import java.io.*;

public class Data {

    public void saveGame(boolean[][] data) {
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter("File.txt"));
            for (int i = 0; i < data.length; i++) {
                String line = "";
                for (int j = 0; j < data[i].length; j++) {
                    if (data[i][j]) {
                        line += "1";
                    } else {
                        line += "0";
                    }
                }
                bf.write(line);
                bf.newLine();
            }
            bf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean[][] loadGame() {
        boolean[][] data = new boolean[5][5];
        try {
            BufferedReader br = new BufferedReader(new FileReader("File.txt"));
            String line = br.readLine();
            int j = 0;
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == '1') {
                        data[j][i] = true;
                    } else data[j][i] = false;
                }
                line = br.readLine();
                j++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}

