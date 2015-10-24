package Tests;

import entities.DataMMSP;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Test class for DataMMSP
 * Created by Oleg on 24.10.2015.
 */
public class Test_DataMMSP {

    DataMMSP dataMMSP = new DataMMSP();

    @Test
    public void testDimensions1() {
        Assert.assertEquals(true, dataMMSP.addDimension("x"));
        Assert.assertEquals(true, dataMMSP.addDimension("y"));
        Assert.assertEquals(false, dataMMSP.addDimension("x"));
        Assert.assertEquals(false, dataMMSP.addDimension("y"));
        Assert.assertEquals("x", dataMMSP.getDimension(0));
        Assert.assertEquals("y", dataMMSP.getDimension(1));
        Assert.assertEquals(null, dataMMSP.getDimension(5));
        Assert.assertEquals(2, dataMMSP.getDimensionsCount());
        Assert.assertArrayEquals(new String[]{"x", "y"}, dataMMSP.getDimensions());
    }

    @Test
    public void testDimensions2() {
        String[] tmp = new String[]{"a", "b", "c", "d"};
        dataMMSP.setDimensions(tmp);
        Assert.assertArrayEquals(tmp, dataMMSP.getDimensions());
        Assert.assertEquals(false, dataMMSP.addDimension("b"));
    }

    @Test
    public void testData1() {
        dataMMSP.addDataset(0, new double[]{0, 1, 2, 3, 4});
        dataMMSP.addDataset(1, new double[]{0, 1, 2, 3, 5});
        List<Double> a = new ArrayList<>();
        a.add((double) 0);
        a.add(1d);
        a.add(2d);
        a.add(3d);
        a.add(4d);
        Assert.assertEquals(a, dataMMSP.getDataset(0));
        Assert.assertNotEquals(a, dataMMSP.getDataset(1));
    }

    @Test
    public void testData2() {
        List<List<Double>> tmp= new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            List<Double> a = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                a.add(random.nextDouble());
            }
            tmp.add(a);
        }
        dataMMSP.addDatasets(tmp);
        Assert.assertEquals(tmp, dataMMSP.getAllDatasets());
        Assert.assertEquals(tmp.get(2),dataMMSP.getDataset(2));
    }
}
