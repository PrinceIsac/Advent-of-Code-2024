package advent.of.code._4.advent.of.code._4;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {

    public static int solutionOne(String input) {
        //Regex pattern to search for
        String regex = "mul\\((\\d{1,3}),(\\d{1,3})\\)";

        //Compile the regex into a pattern
        Pattern pattern = Pattern.compile(regex);

        //Matcher to find matches in the string
        Matcher matcher = pattern.matcher(input);

        //List of all multiplication equations
        ArrayList<String> list = new ArrayList<>();

        //Sum of all multiplications
        int sum = 0;

        //Find all matches in the string
        while (matcher.find()) {
            list.add(matcher.group());
        }

        //Iterate over the expressions and multiply then sum all multiplications
        for (String s : list) {
            String[] number = s.replace("mul(", "").replace(")", "").split(",");
            sum += (Integer.parseInt(number[0]) * Integer.parseInt(number[1]));
        }
        return sum;
    }
}
