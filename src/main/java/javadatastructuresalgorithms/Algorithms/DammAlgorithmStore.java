package javadatastructuresalgorithms.Algorithms;

import java.util.ArrayList;

public class DammAlgorithmStore {

    private DammAlgorithm DA;
    private ArrayList<DammAlgorithm> dataStore = new ArrayList<>();

    public DammAlgorithmStore(DammAlgorithm DA) {
        this.DA = DA;
        add(DA);
    }

    public DammAlgorithmStore() {
        this.DA = null;
    }

    public void add(DammAlgorithm DA) {
        dataStore.add(DA);
    }

    public void remove(int index) {
        dataStore.remove(index);
    }

    public ArrayList<DammAlgorithm> getData() {
        return dataStore;
    }

    public DammAlgorithm getData(int index) {
        return dataStore.get(index);
    }
}
