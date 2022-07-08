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

}