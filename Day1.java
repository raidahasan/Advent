import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day1Input");
        ArrayList<Integer> listOne = new ArrayList<>();
        ArrayList<Integer> listTwo = new ArrayList<>();
        for(int i = 0; i<fileData.size(); i++){
            listOne.add(Integer.valueOf((fileData.get(i).split("   ")[0])));
            listTwo.add(Integer.valueOf((fileData.get(i).split("   ")[1])));
        }
        Collections.sort(listOne);
        Collections.sort(listTwo);
        System.out.println(listOne);
        System.out.println(listTwo);
        int total = 0;
        for(int i = 0; i<fileData.size(); i++){
            int line = Math.abs(listOne.get(i) - listTwo.get(i));
            total+=line;
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