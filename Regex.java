import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

        public class Regex{
            public static void main(String[] args) throws FileNotFoundException {
                ArrayList<String> found = new ArrayList<>();
                String output = "";

                File f = new File("src/Day2Input");
                String regex = "mul\\(\\d+,\\d+\\)";
                Scanner s = new Scanner(f);
                while (s.hasNextLine()) {
                    String line = s.nextLine();
                    output+=line;
                }
                System.out.println(output);

                Matcher m = Pattern.compile(regex).matcher(output);
        while (m.find()) {
            found.add(m.group());
        }
        System.out.println(found);

        ArrayList<String> numbers = new ArrayList<>();
        String nums = "\\d+";

        String foundList = "";
        for(int i = 0; i< found.size(); i++){
            foundList += found.get(i) + " ";
        }
        System.out.println(foundList);
        Matcher l = Pattern.compile(nums).matcher(foundList);
        while (l.find()) {
            numbers.add(l.group());
        }
        System.out.println(numbers);

        int total = 0;
        for(int i = 0; i<numbers.size()-1; i+=2){
               total+= Integer.parseInt(numbers.get(i))*Integer.parseInt(numbers.get(i+1));
        }
        System.out.println(total);
    }

}
