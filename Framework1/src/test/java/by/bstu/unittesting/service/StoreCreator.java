package by.bstu.unittesting.service;

import by.bstu.unittesting.model.Store;

public class StoreCreator {
    public static final String TESTDATA_STORE_GRUSHEVKA = "testdata.store.Grushevka";
    public static final String TESTDATA_STORE_URUCHE = "testdata.store.Uruche";

    public static Store createStoreInGrushevka() {
        return new Store(TestDataReader.getTestData(TESTDATA_STORE_GRUSHEVKA));
    }

    public static Store createStoreInUruche() {
        return new Store(TestDataReader.getTestData(TESTDATA_STORE_URUCHE));
    }
}
