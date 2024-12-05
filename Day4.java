import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day4 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/InputFile");

        int rows = fileData.size();
        int columns = fileData.get(0).length();
        String[][] grid = new String[rows][columns];

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                grid[r][c] = fileData.get(r).substring(c, c+1);
            }
        }
        int total = 0;
//        for(int i = 0; i<grid.length; i++) {
//                String line = Arrays.toString(grid[i]);
//                while (line.contains("XMAS")) {
//                    total++;
//                    line = line.substring(line.indexOf("XMAS") + 2);
//                }
//        }
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length-3; c++) {
                // get the letter at this position
                String letter = grid[r][c];
                // if that letter is an X
                // search up, down, right, left, up/left, up/right, down/left, down/right
                if(letter.equals("X")){
                    if(grid[r][c+1]!=null){
                        if(grid[r][c+1].equals("M")){
                            if(grid[r][c+2]!=null){
                                if(grid[r][c+2].equals("A")){
                                    if(grid[r][c+3]!=null){
                                        if(grid[r][c+3].equals("S")){
                                            System.out.println(grid[r][c]+grid[r][c+1]+grid[r][c+2]+grid[r][c+3]);
                                            total++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(total);

    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}