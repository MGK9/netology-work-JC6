import org.junit.jupiter.api.*;

public class CalculatorTest {

    Calculator calc = Calculator.instance.get();

    @BeforeAll
    public static void beforeAllMethod() {
        System.out.println("BeforeAll call");
    }

    @BeforeEach
    public void beforeEachMethod() {
        System.out.println("BeforeEach call");
        calc = new Calculator();
    }

    @AfterEach
    public void afterEachMethod() {
        System.out.println("AfterEach call");
    }

    @AfterAll
    public static void afterAllMethod() {
        System.out.println("AfterAll call");
    }

    @Test
    public void testPlus() {
        //arrange
        int a = 5, b = 1, expected = 6;
        //act
        int result = calc.plus.apply(a,b);
        //assert
        Assertions.assertEquals(expected, result);
        System.out.println("TestPlus call");
    }

    @Test
    public void testDivideByZero() {
        int a = 6, b = 0;
        Class<ArithmeticException> expected = ArithmeticException.class;
        Assertions.assertThrows(expected, () -> calc.divide.apply(a, b));
        System.out.println("TestDivideByZero call");
    }

    @Test
    public void testPositive() {
        int a = 40;
        Assertions.assertTrue(calc.isPositive.test(a));
        System.out.println("TestPositive call");
    }

    @Test
    public void testNegative() {
        int a = -40;
        Assertions.assertFalse(calc.isPositive.test(a));
        System.out.println("TestNegative call");
    }
}
