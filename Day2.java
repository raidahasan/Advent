import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/InputFile");
        int rows = fileData.size();
        int columns = fileData.get(0).length();
        String[][] grid = new String[rows][columns];

        for(int i = 0; i< fileData.size(); i++){
            String string = (fileData.get(i));
            String[] words = string.split(" ");
            int k = 0;
            for (String word : words) {
                grid[i][k] = word;
                k++;
            }
        }

        int total = 0;

        for (int r = 0; r < grid.length; r++) {
            boolean safe = true;
            for (int c = 0; c < grid[r].length; c++) {
                if((Math.abs(Integer.parseInt(grid[r][c])-Integer.parseInt(grid[r][c+1])))>3){
                    safe = false;
                }
            }
            if(safe){
                total++;
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

