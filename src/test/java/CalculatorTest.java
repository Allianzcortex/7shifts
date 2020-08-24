import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class CalculatorTest {

    private Calculator calculator;
    private Map<String, Integer> basicTestCases;
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();


    @Before
    public void setUp() {

        calculator = new Calculator();
        basicTestCases = new HashMap<>();
        basicTestCases.put(null, 0);
        basicTestCases.put("", 0);
        basicTestCases.put(" ", 0);
    }


    @Test
    public void addNumberShouldThrowExceptionWithNegativeNumbers() throws Exception {
        exceptionRule.expect(NegativeInputException.class);
        exceptionRule.expectMessage("There is/are 2 negative number(s) in the input : -7,-2");
        calculator.addNumbers(new String[]{
                "1", "3", "-7", "4", "25", "-2"
        });

    }

    @Test
    public void addNumberShouldSkipUpperBoundValue() throws Exception {
        assertEquals(calculator.addNumbers(new String[]{
                "1", "2", "3"
        }), 6);
        assertEquals(calculator.addNumbers(new String[]{
                "1", "2", "3", "1001"
        }), 6);
    }

    @Test
    public void testAdd1() throws Exception {
        for (Map.Entry<String, Integer> entry : basicTestCases.entrySet()) {
            assertEquals(calculator.add1(entry.getKey()), (long) entry.getValue());
        }
        assertEquals(calculator.add1("1,,2,,5"), 8);
        assertEquals(calculator.add1("1,,4,,,8,,"), 13);
    }

    @Test
    public void testAdd2() throws Exception {
        for (Map.Entry<String, Integer> entry : basicTestCases.entrySet()) {
            assertEquals(calculator.add2(entry.getKey()), (long) entry.getValue());
        }

        assertEquals(calculator.add2("1,,2\n3"), 24);
        assertEquals(calculator.add2("1,,2\n,3"), 6);
        assertEquals(calculator.add2("1,,2\n,3\n,\n\n4\n"), 10);

    }


    @Test
    public void testAdd3() throws Exception {
        for (Map.Entry<String, Integer> entry : basicTestCases.entrySet()) {
            assertEquals(calculator.add3(entry.getKey()), (long) entry.getValue());
        }
        assertEquals(calculator.add3("//@\n2@3@8"), 13);
        assertEquals(calculator.add3("//$\n1$2$3"), 6);
        assertEquals(calculator.add3("//***\n1***2**\n*3"), 6);
        assertEquals(calculator.add3("//***\n1***2******3***4***\n\n***5"), 15);
    }

}