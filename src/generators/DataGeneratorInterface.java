package generators;

import entities.DataMMSP;

/**
 * Interface for generate data
 * Created by Oleg on 24.10.2015.
 */
public interface DataGeneratorInterface {

    /**
     * @return generated dataset, if data not generated return null
     */
    DataMMSP getData();


    /**
     * Generate data
     */
    void generate();
}
