import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/InputFile");
        int rows = fileData.size();
        String[][] grid = new String[rows][];

        for(int i = 0; i< fileData.size(); i++){
            String string = (fileData.get(i));
            String[] words = string.split(" ");
            grid[i] = new String[words.length];
            int k = 0;
            for (String word : words) {
                grid[i][k] = word;
                k++;
            }
        }

        int total = 0;

        for (int r = 0; r < grid.length; r++) {
            boolean safe = true;
            boolean increasing = false;
            boolean decreasing = false;
            for (int c = 0; c < grid[r].length-1; c++) {
//                    if ((Math.abs(Integer.parseInt(grid[r][c]) - Integer.parseInt(grid[r][c + 1]))) > 3) {
//                        safe = false;
//                    }
                if(true){
                    if(Integer.parseInt(grid[r][c]) - Integer.parseInt(grid[r][c + 1])>=-3 && Integer.parseInt(grid[r][c]) - Integer.parseInt(grid[r][c + 1])<=-1){
                        decreasing = true;
                    }else if(Integer.parseInt(grid[r][c]) - Integer.parseInt(grid[r][c + 1])<=3 && Integer.parseInt(grid[r][c]) - Integer.parseInt(grid[r][c + 1])>=1){
                        increasing = true;
                    }else{
                        safe = false;
                    }
                }
            }
            boolean sameDir = (decreasing && !increasing) || (increasing && !decreasing);
            if(safe && sameDir){
                total++;
                System.out.println(Arrays.stream(grid[r]).toList());
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