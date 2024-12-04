import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

        public class RegexPartTwo {
            public static void main(String[] args) throws FileNotFoundException {
                String output = "";

                File f = new File("src/Day2Input");
                Scanner s = new Scanner(f);
                while (s.hasNextLine()) {
                    String line = s.nextLine();
                    output+=line;
                }
                System.out.println(output);

                String validAll = output.substring(0, output.indexOf("don't()"));
                String valid = "[^do\\(\\).*don't\\(\\)$]";
                Matcher j = Pattern.compile(valid).matcher(output);
                while (j.find()) {
                    validAll+=(j.group());
                }
                System.out.println(validAll);

                ArrayList<String> found = new ArrayList<>();
                String regex = "mul\\(\\d+,\\d+\\)";
                Matcher m = Pattern.compile(regex).matcher(validAll);
                while (m.find()) {
                    found.add(m.group());
                }
                System.out.println(found);

                ArrayList<String> numbers = new ArrayList<>();
                String foundList = "";
                for(int i = 0; i< found.size(); i++){
                    foundList += found.get(i) + " ";
                }
                System.out.println(foundList);

                String nums = "\\d+";
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
