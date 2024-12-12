import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Day4P2 {
    public static void main(String[] args) {
        ArrayList<String> fileData = Day4.getFileData("src/InputFile");

        int rows = fileData.size();
        int columns = fileData.get(0).length();
        String[][] grid = new String[rows][columns];

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                grid[r][c] = fileData.get(r).substring(c, c + 1);
            }
        }
        int total = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                String letter = grid[r][c];
                if (letter.equals("A")) {
                    if(rightLeft(grid, r, c) && rightRight(grid, r, c)){
                        total++;
                    }
                }
            }
        }
        System.out.println(total);
    }
    public static boolean rightLeft(String[][] list, int r, int c){
        if(r<list.length-1 && r>0 && c>0 && c<list[0].length-1){
            if(Objects.equals(list[r - 1][c - 1], "M")){
                if(Objects.equals(list[r + 1][c + 1], "S")){
                    return true;
                }
            }
            if(Objects.equals(list[r - 1][c - 1], "S")){
                if(Objects.equals(list[r + 1][c + 1], "M")){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean rightRight (String[][] list, int r, int c){
        if(r<list.length-1 && r>0 && c>0 && c<list[0].length-1){
            if(Objects.equals(list[r - 1][c + 1], "M")){
                if(Objects.equals(list[r + 1][c - 1], "S")){
                    return true;
                }
            }
            if(Objects.equals(list[r - 1][c + 1], "S")){
                if(Objects.equals(list[r + 1][c - 1], "M")){
                    return true;
                }
            }
        }
        return false;
    }
}
