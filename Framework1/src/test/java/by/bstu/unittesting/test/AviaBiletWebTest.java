package by.bstu.unittesting.test;

import by.bstu.unittesting.model.*;


import by.bstu.unittesting.page.*;

import by.bstu.unittesting.service.*;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AviaBiletWebTest extends GeneralConfig {

    private static final String HELP_ITEM_TEXT = "Реквизиты, лицензии OZ.by";
    private static final String VK_TITLE = "ВКонтакте";
    private static final String ADDRESS_GRUSHEVKA = "Минск, Дзержинского, 19,\nст. метро «Грушевка»\nПосмотреть ассортимент";
    private static final String ADDRESS_URUCHE = "Минск, Руссиянова, 4,\nст. метро «Уручье»\nПосмотреть ассортимент";
    private static final String COUPON_ERROR_MESSAGE = "авторизоваться";
    private static final String EMPTY_VACANCY_ALERT = "А что посылать? Надо что-то сначала набрать...";
    private static final String UNO_ITEM_NAME = "UNO";
    private static final String ALPHABET_PAGE_ERROR_TEXT = "Введите корректный номер мобильного телефона";
    private static final String NUMBER_PAGE_ERROR_TEXT = "Этот номер телефона не зарегистрирован. Проверьте его на ошибки, введите другой или зарегистрируйтесь";
    private static final String BOOK_NAME = "НИ СЫ. Будь уверен в своих силах и не позволяй сомнениям мешать тебе двигаться вперед";

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

    @Test
    public void testCheckBookNameInBasket() throws InterruptedException {
        BookPage page = new BookPage(driver);
        page.openPage()
                .clickMenuItem()
                .clickBook()
                .clickAddToBasket()
                .clickGoToBasket();
        BasketPage basket = new BasketPage(driver);
        assertThat(basket.returnBookNameInBasket(), is(equalTo(BOOK_NAME)));

    }

    @Test
    public void testCheckCouponErrorMessage() throws InterruptedException {
        Coupon coupon = CouponCreator.createCoupon();
        BookPage page = new BookPage(driver);
        page.openPage()
                .clickMenuItem()
                .clickBook()
                .clickAddToBasket()
                .clickGoToBasket();
        BasketPage basket = new BasketPage(driver);
        basket.couponInput.sendKeys(coupon.name);
        basket.submitCouponButton.click();
        assertThat(basket.errorCouponMessage.findElement(new By.ByTagName("a")).getText(), is(equalTo(COUPON_ERROR_MESSAGE)));
    }

    @Test
    public void testCheckItemName() {
        Item testItem = ItemCreater.createItemUno();
        String testItemName = new SearchItemPage(driver).openPage()
                .setNameInInput(testItem)
                .clickSearchButton()
                .clickUnoItem()
                .getItemName();
        assertThat(testItemName, is(equalTo(UNO_ITEM_NAME)));
    }

    /*@Test
    public void testCheckVacancyInBorisov() throws InterruptedException {
        Vacancy vacancy = VacancyCreator.createVacancyInBorisov();
        VacancyPage vacancyPage = new VacancyPage(driver).openPage()
                .goToVacancyPage()
                .viewBorisovVacancy();
        String vacancyTitle = vacancyPage.vacancyTitile.getText().toString();

        assertThat(vacancyTitle, is(equalTo(vacancy.title)));

    }

    @Test
    public void testCheckVacancyInOstrovec() throws InterruptedException {
        Vacancy vacancy = VacancyCreator.createVacancyInOstrovec();
        VacancyPage vacancyPage = new VacancyPage(driver).openPage()
                .goToVacancyPage()
                .viewOstrovecVacancy();
        String vacancyTitle = vacancyPage.vacancyTitile.getText();
        assertThat(vacancyTitle, is(equalTo(vacancy.getTitle())));

    }*/

    @Test
    public void testSendEmptyVacancy() throws InterruptedException {
        VacancyPage vacancyPage = new VacancyPage(driver).openPage()
                .goToVacancyPage()
                .clickWriteUs();
        vacancyPage.sendVacancy.click();
        Thread.sleep(3000);
        assertThat(driver.switchTo().alert().getText(), is(equalTo(EMPTY_VACANCY_ALERT)));
    }

    @Test
    public void testCheckGrushevkaStoreAddress() throws InterruptedException {
        StorePage storePage=new StorePage(driver).openPage();
        storePage.storeButtonInMenu.click();
        Thread.sleep(3000);
        storePage.storeItemGrushevka.click();
        Thread.sleep(4000);
        assertThat(storePage.address.getText(),is(equalTo(ADDRESS_GRUSHEVKA)));

    }

    @Test
    public void testCheckUrucheStoreAddress() throws InterruptedException {
        StorePage storePage=new StorePage(driver).openPage();
        storePage.storeButtonInMenu.click();
        Thread.sleep(3000);
        storePage.storeItemUruche.click();
        Thread.sleep(4000);
        assertThat(storePage.address.getText(),is(equalTo(ADDRESS_URUCHE)));

    }

    /*@Test
    public void testCheckHelpItem() {
        HelpPage helpItemPage = new HelpPage(driver);
        String title = helpItemPage.openPage()
                .clickHelp()
                .clickHelpItem()
                .getTitle();
        assertThat(title, is(equalTo(HELP_ITEM_TEXT)));
    }

    @Test
    public void testCheckShareWithVK() throws InterruptedException {
        VacancyPage vacancyPage = new VacancyPage(driver).openPage()
                .goToVacancyPage()
                .checkVK();
        String url = driver.getCurrentUrl();
        driver.switchTo().alert();
        assertThat(vacancyPage.vk.getText(), is(equalTo(VK_TITLE)));
    }*/
}
