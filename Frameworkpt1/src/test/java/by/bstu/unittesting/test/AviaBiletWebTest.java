package by.bstu.unittesting.test;

import by.bstu.unittesting.model.*;


import by.bstu.unittesting.page.IncorrectOrderPage;
import by.bstu.unittesting.page.OrderPage;

import by.bstu.unittesting.service.*;

import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AviaBiletWebTest extends GeneralConfig {


    private static final String ALPHABET_PAGE_ERROR_TEXT = "Введите корректный номер мобильного телефона";
    private static final String NUMBER_PAGE_ERROR_TEXT = "Этот номер телефона не зарегистрирован. Проверьте его на ошибки, введите другой или зарегистрируйтесь";

    @Test
    public void testIncorrectOrder() throws InterruptedException {


        Order testOrder = OrderCreator.createOrderWithWrongNumber();

        String errorText = new IncorrectOrderPage(driver).openPage()
                .clickSignInButton()
                .inputPhone(testOrder)
                .clickGetSmsButton()
                .getErrorText();

        assertThat(errorText, is(equalTo(ALPHABET_PAGE_ERROR_TEXT)));

    }

    @Test
    public void testSignInWithoutPHoneNumber() throws InterruptedException {


        Order testOrder = OrderCreator.createOrderWithAllFieldsFromProperty();

        String errorText = new IncorrectOrderPage(driver).openPage()
                .clickSignInButton()
                .clickGetSmsButton()
                .getErrorTextt();

        assertThat(errorText, is(equalTo(NUMBER_PAGE_ERROR_TEXT)));

    }




}
