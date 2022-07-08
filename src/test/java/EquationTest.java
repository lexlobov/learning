import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class EquationTest {

    @Test
    public void test0(){
        Equation e = new Equation(1, 1, 1);
        assertEquals(e.getN(),0);
    }

    @Test
    public void test1(){
        Equation e = new Equation(1, 2, 1);
        assertEquals(e.getN(), 1);
    }

    @Test
    public void test2(){
        Equation e = new Equation(1, 5, 6);
        assertEquals(e.getN(), 2);
    }

    @Test
    public void testLinear(){
        Equation e = new Equation(0, 1, 1);
        assertEquals(e.getN(), 1);
    }

    @Test
    public void testConstant(){
        Equation e = new Equation(0, 0, 1);
        assertEquals(e.getN(), 0);
    }

    @Test
    public void testZero(){
        Equation e = new Equation(0, 0, 0);
        assertEquals(e.getN(), -1);
    }

}