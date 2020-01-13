package by.bstu.unittesting.service;

import by.bstu.unittesting.model.Coupon;

public class CouponCreator {
    public static final String TESTDATA_COUPON_NAME = "testdata.coupon.name";

    public static Coupon createCoupon() {
        return new Coupon(TestDataReader.getTestData(TESTDATA_COUPON_NAME));
    }
}
