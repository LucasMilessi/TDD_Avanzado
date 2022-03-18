import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculadoraDeCadenaTest {

    public CalculadoraDeCadena calculadoraDeCadena = new CalculadoraDeCadena();
    //An empty string returns zero
    @Test
    public void emptyStringTest() throws Exception{
        Assertions.assertEquals(0, calculadoraDeCadena.add(""));
    }
    // A single number returns the value
    @Test
    public void singleNumberReturnItsValueTest() throws Exception{
        Assertions.assertEquals(2, calculadoraDeCadena.add("2"));
        Assertions.assertEquals(1, calculadoraDeCadena.add("1"));
    }
    //Two numbers, comma delimited, returns the sum
    @Test
    public void twoNumbersCommaDelimitedReturnsTheSumTest() throws Exception {
        Assertions.assertEquals(2, calculadoraDeCadena.add("0,2"));
        Assertions.assertEquals(2, calculadoraDeCadena.add("1,1"));
        Assertions.assertEquals(3, calculadoraDeCadena.add("1,2"));
    }
    // Two numbers, newline delimited, returns the sum
    @Test
    public void sameThatBeforeButNewLineDelimitedTest() throws Exception {
        Assertions.assertEquals(2, calculadoraDeCadena.add("0\n2"));
        Assertions.assertEquals(2, calculadoraDeCadena.add("1\n1"));
        Assertions.assertEquals(3, calculadoraDeCadena.add("1\n2"));
    }

    // Three numbers, delimited either way, returns the sum
    @Test
    public void sameThatBeforeButAllDelimitersWorksTest() throws Exception {
        Assertions.assertEquals(6, calculadoraDeCadena.add("1\n2,3"));
        Assertions.assertEquals(7, calculadoraDeCadena.add("1,2\n4"));
    }

    // Negative numbers throw an exception
    @Test
    public void negativeNumbersThrowsAnExceptionTest(){
        try {
            Assertions.assertEquals("NegativeNumberException", calculadoraDeCadena.add("-1,-1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Numbers greater than 1000 are ignored
    @Test
    public void greaterThan1000AreIgnoredTest() throws Exception {
        Assertions.assertEquals(1002, calculadoraDeCadena.add("2,1000"));
        Assertions.assertEquals(2, calculadoraDeCadena.add("2,1001"));
    }
    // A single char delimiter can be defined on the first line
    @Test
    public void singleCharDelimiterTest() throws Exception {
        Assertions.assertEquals(1002, calculadoraDeCadena.add("#2#1000"));
    }
}