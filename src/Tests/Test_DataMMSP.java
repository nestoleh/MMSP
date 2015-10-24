package Tests;

import entities.DataMMSP;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for DataMMSP
 * Created by Oleg on 24.10.2015.
 */
public class Test_DataMMSP {

    @Test
    public void testDimensions1() {
        DataMMSP dataMMSP = new DataMMSP();
        Assert.assertEquals(dataMMSP.addDimension("x"), true);
        Assert.assertEquals(dataMMSP.addDimension("y"), true);
        Assert.assertEquals(dataMMSP.addDimension("x"), false);
        Assert.assertEquals(dataMMSP.addDimension("y"), false);
        Assert.assertEquals(dataMMSP.getDimension(0), "x");
        Assert.assertEquals(dataMMSP.getDimension(1), "y");
        Assert.assertEquals(dataMMSP.getDimension(5), null);
        Assert.assertEquals(dataMMSP.getDimensionsCount(), 2);
        Assert.assertArrayEquals(dataMMSP.getDimensions(), new String[]{"x", "y"});
    }

    @Test
    public void testDimensions2() {
        DataMMSP dataMMSP = new DataMMSP();
        String[] tmp = new String[]{"a", "b", "c", "d"};
        dataMMSP.setDimensions(tmp);
        Assert.assertArrayEquals(dataMMSP.getDimensions(), tmp);
        Assert.assertEquals(dataMMSP.addDimension("b"), false);
    }
}
