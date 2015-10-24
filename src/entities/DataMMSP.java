package entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class for save datasets for all dimensions
 * Created by Oleg on 24.10.2015.
 */
public class DataMMSP {
    private List<String> dimensions;
    private List<List<Double>> data;

    public DataMMSP() {
        setStartData();
    }

    private void setStartData() {
        this.dimensions = new ArrayList<>();
        this.data = new ArrayList<>();
    }

    /**
     * @param d - dimensionName
     * @return true if dimension added; false if dimension with this name already contains
     */
    public boolean addDimension(String d) {
        if (!dimensions.contains(d)) {
            dimensions.add(d);
            return true;
        }
        return false;
    }

    /**
     * Set all new dimensions list. DELETE ALL DIMENSIONS DATA
     *
     * @param list array of dimensions
     */
    public void setDimensions(String[] list) {
        setStartData();
        Collections.addAll(this.dimensions, list);
    }

    public int getDimensionsCount() {
        return this.dimensions.size();
    }

    /**
     * @param index index of dimension
     * @return name of dimension with index; null if dimension not created
     */
    public String getDimension(int index) {
        try {
            return this.dimensions.get(index);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    /**
     * @return array of all dimensions name
     */
    public String[] getDimensions() {
        String[] tmp = new String[this.dimensions.size()];
        return this.dimensions.toArray(tmp);
    }

    /**
     * @param indexOfDimension index of needed dimension
     * @return List of data for dimension, null if this dataset not created
     */
    public List<Double> getDataset(int indexOfDimension) {
        try {
            return data.get(indexOfDimension);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    /**
     * @return all datasets
     */
    public List<List<Double>> getAllDatasets() {
        return data;
    }

    /**
     * Add new dataset with index
     *
     * @param index   index of new dataset
     * @param dataset dataset in double[]
     */
    public void addDataset(int index, double[] dataset) {
        List<Double> dset = new ArrayList<>();
        for (double item : dataset) {
            dset.add(item);
        }
        this.data.add(index, dset);
    }

    /**
     * @param datasets - array of generated data
     */
    public void addDatasets(List<List<Double>> datasets){
        this.data = datasets;
    }
}
