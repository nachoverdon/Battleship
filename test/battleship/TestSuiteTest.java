/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Nacho Verdón
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({battleship.GridTest.class})
public class TestSuiteTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("About to start...");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Tested.");
    }
}
