/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author Nacho Verdón
 */
@RunWith(Parameterized.class)
public class GridTest {
    private Grid instance;
    private int num;
    private int result;
    
    public GridTest(int num, int result) {
        this.num = num;
        this.result = result;
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        try {
            this.instance = new Grid();
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }
    
    @After
    public void tearDown() {
        this.instance = null;
    }

    @Parameters
    public static Collection<Object[]> nums() {
        return Arrays.asList(new Object[][]{{2, 4}, {4, 8}, {5, 10}});
    }

    @Test
    public void uselessTest() {
        int x2 = this.num * 2;
        System.out.println(this.result + " " + x2);
        assertEquals(this.result, x2);
    }

    /**
     * Test of getPlayerGrid method, of class Grid.
     */
    @Test
    public void testShowPlayerGrid() {
        System.out.println("showPlayerGrid");
            String expResult = "[≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] \n" +
                               "[◊] [◊] [◊] [≈] [≈] [≈] [≈] [≈] [≈] [≈] \n" +
                               "[≈] [≈] [≈] [≈] [≈] [≈] [◊] [◊] [◊] [◊] \n" +
                               "[≈] [≈] [≈] [≈] [≈] [≈] [◊] [≈] [≈] [≈] \n" +
                               "[≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] \n" +
                               "[≈] [◊] [≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] \n" +
                               "[≈] [◊] [≈] [≈] [◊] [◊] [◊] [≈] [≈] [≈] \n" +
                               "[≈] [◊] [≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] \n" +
                               "[≈] [◊] [≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] \n" +
                               "[≈] [◊] [≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] \n";
            String result = instance.getPlayerGrid();
            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
//            fail("The test case is a prototype.");
    }

    /**
     * Test of getCPUGrid method, of class Grid.
     */
    @Test //(expected = Exception.class)
    public void testShowCPUGrid() {
        System.out.println("showCPUGrid");
        String expResult = "[≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] \n" +
                           "[≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] \n" +
                           "[≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] \n" +
                           "[≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] \n" +
                           "[≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] \n" +
                           "[≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] \n" +
                           "[≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] \n" +
                           "[≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] \n" +
                           "[≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] \n" +
                           //"[≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈]";
                           "[≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] [≈] \n";
        String result = instance.getCPUGrid();
        assertEquals("Fallo, resultados no coinciden", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of attackPlayerCell method, of class Grid.
     * @throws java.lang.Exception
     */
    @Test
    public void testAttackPlayerCell() throws Exception {
        System.out.println("attackPlayerCell");
        int index = 0;
        Grid instance = new Grid();
        String expResult = "";
        String result = instance.attackPlayerCell(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of attackCPUCell method, of class Grid.
     * @throws java.lang.Exception
     */
    @Test
    public void testAttackCPUCell() throws Exception {
        System.out.println("attackCPUCell");
        int index = 0;
        Grid instance = new Grid();
        String expResult = "";
        String result = instance.attackCPUCell(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

}
