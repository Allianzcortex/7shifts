import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 1000;

    /**
     * public util function , it will add all numbers of the array together
     * <p>
     * handle 2 cases :
     * <p>
     * 1. skip 1000(upper bound)
     * 2. thorw Exception for negative input
     */
    public int addNumbers(String[] numbersArray) throws Exception {
        int sum = 0, currentNum;
        List<String> negativeNumbers = new ArrayList<>();
        for (String number : numbersArray) {
            try {
                currentNum = Integer.parseInt(number);
                if (currentNum < LOWER_BOUND) {
                    negativeNumbers.add(number);
                }
                if (currentNum > UPPER_BOUND) {
                    continue;
                }
                sum += currentNum;
            } catch (NumberFormatException ex) {
                throw new Exception("Invalid input");
            }
        }

        if (negativeNumbers.size() != 0) {
            throw new NegativeInputException(negativeNumbers.size(), String.join(",", negativeNumbers));
        }

        return sum;
    }

    /**
     * Implement basic function 1
     *
     * @param numbers The numbers in the string are separated by a comma.
     * @return
     * @throws Exception
     */
    public int add1(String numbers) throws Exception {
        if (numbers == null || numbers.trim().length() == 0) {
            return 0;
        }

        return addNumbers(numbers.split(",+"));
    }


    /**
     * Implement basic function 2,handle \n new line
     *
     * @param numbers
     * @return
     * @throws Exception
     */
    public int add2(String numbers) throws Exception {
        if (numbers != null)
            numbers = numbers.replace("\n", "");
        return add1(numbers);
    }

    /**
     * Implement basic function 3, handle custom delimiter
     * <p>
     * Use regex "/(.*?)\n(.*)" to extract the delimiter and the target input
     *
     * @param numbers
     * @return
     * @throws Exception
     */
    public int add3(String numbers) throws Exception {
        if (numbers == null || numbers.trim().length() == 0)
            return 0;

        String delimiter = "", regexPattern = "//(.*?)\\n(.*)";
        Pattern r = Pattern.compile(regexPattern, Pattern.DOTALL);

        // Now create matcher object.
        Matcher m = r.matcher(numbers);
        if (m.find()) {
            delimiter = "[" + m.group(1) + "]+";
            numbers = m.group(2).replace("\n", "");
        } else {
            throw new Exception("Input format is invalid.");
        }

        return addNumbers(numbers.split(delimiter));
    }

    public static void main(String[] args) throws Exception {
        Calculator cal = new Calculator();
        System.out.println(cal.add1("1,,2,,5"));
        System.out.println(cal.add2("1,,2\n,,,\n3"));
        System.out.println(cal.add3("//***\n2***3******8"));
    }
}
