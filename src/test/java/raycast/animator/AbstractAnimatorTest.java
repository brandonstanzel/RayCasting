/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raycast.animator;

import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author baphucnguyen
 */
@RunWith(Parameterized.class)
public class AbstractAnimatorTest {

    double rsx;
    double rsy;
    double rex;
    double rey;
    double ssx;
    double ssy;
    double sex;
    double sey;
    boolean intersects;
    double xpoint;
    double ypoint;
    double ray;
    private AbstractAnimator a;

    public AbstractAnimatorTest(double rsx, double rsy, double rex, double rey, double ssx, double ssy, double sex, double sey, boolean intersects, double xpoint, double ypoint, double ray) {
        this.rsx = rsx;
        this.rsy = rsy;
        this.rex = rex;
        this.rey = rey;
        this.ssx = ssx;
        this.ssy = ssy;
        this.sex = sex;
        this.sey = sey;
        this.intersects = intersects;
        this.xpoint = xpoint;
        this.ypoint = ypoint;
        this.ray = ray;
    }

    @Before
    public void setUp() {
        a = new TextAnimator();
    }

    @After
    public void tearDown() {
        a = null;
    }

    @Parameters(name = "Test {index}: rsx={0} rsy={1} rex={2} rey={3} ssx={4} ssy={5} sex={6} sey={7} intersects={8} xpoint={9} ypoint={10} ray={11}")
    public static Iterable<Object[]> data() throws Throwable {
        return Arrays.asList(new Object[][]{
            {100, 100, 200, 100, 100, 100, 100, 200, true, 100, 100, 0},
            {100, 100, 200, 100, 150, 100, 150, 200, true, 150, 100, 0.5},
            {100, 100, 200, 100, 200, 100, 200, 200, true, 200, 100, 1},
            {200, 100, 100, 100, 100, 100, 100, 200, true, 100, 100, 1},
            {200, 100, 100, 100, 150, 100, 150, 200, true, 150, 100, 0.5},
            {200, 100, 100, 100, 200, 100, 200, 200, true, 200, 100, 0},
            {100, 100, 200, 100, 100, 150, 100, 200, false, 0, 0, 0},
            {100, 100, 200, 100, 150, 150, 150, 200, false, 0, 0, 0},
            {100, 100, 200, 100, 200, 150, 200, 200, false, 0, 0, 0},
            {100, 100, 200, 100, 100, 150, 200, 150, false, 0, 0, 0},
            {200, 100, 100, 100, 100, 150, 100, 200, false, 0, 0, 0},
            {200, 100, 100, 100, 150, 150, 150, 200, false, 0, 0, 0},
            {200, 100, 100, 100, 200, 150, 200, 200, false, 0, 0, 0},
            {200, 100, 100, 100, 100, 150, 200, 150, false, 0, 0, 0},
            {100, 100, 150, 100, 100, 100, 100, 200, true, 100, 100, 0},
            {100, 100, 150, 100, 150, 100, 150, 200, true, 150, 100, 1},
            {100, 100, 150, 100, 200, 100, 200, 200, true, 200, 100, 2},
            {150, 100, 100, 100, 100, 100, 100, 200, true, 100, 100, 1},
            {150, 100, 100, 100, 150, 100, 150, 200, true, 150, 100, 0},
            {150, 100, 100, 100, 200, 100, 200, 200, false, 0, 0, 0}
        });
    }

    @Test
    public void testIntersetion() {
        boolean doesIntersect = a.getIntersection(rsx, rsy, rex, rey, ssx, ssy, sex, sey);
        double[] result = a.intersect();
        assertTrue(doesIntersect == intersects);
        if (!intersects) {
            return;
        }
        assertEquals(result[0], xpoint, 0.00001);
        assertEquals(result[1], ypoint, 0.00001);
        assertEquals(result[2], ray, 0.00001);
    }
    	
}
