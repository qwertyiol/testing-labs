package by.bstu.unittesting.service;

import by.bstu.unittesting.model.Item;

public class ItemCreater {
    public static final String TESTDATA_ITEM_UNO = "testdata.item.uno.name";

    public static Item createItemUno() {
        return new Item(TestDataReader.getTestData(TESTDATA_ITEM_UNO));
    }

}
