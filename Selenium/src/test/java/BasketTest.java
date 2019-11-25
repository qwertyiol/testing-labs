import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BasketTest {


    /*5.
1) Зайти на сайт oz.by
2) Выбрать пункт "Книги" в меню
3) Нажать на ссылку "План-конспект правил дорожного движения с иллюстрациями и примерами для учащихся автошкол 2019"
4) Нажать на кнопку "Положить в корзину"

Ожидание: Название кнопки поменялось на "Уже в корзине"

     */

    @Test
    public void checkBasketStatus(){
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Nasya\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.oz.by/");

        driver.findElement(By.xpath("//*[@href=\"/books/\"]")).click();
        driver.findElement(By.xpath("//*[@href=\"/books/more10686464.html\"]")).click();
        driver.findElement(By.xpath("//*[@class=\"b-product-control__button i-button i-button_large " +
                "i-button_orange addtocart-btn first-button\"]")).click();
        Assert.assertTrue(driver.getPageSource().contains("Уже в&nbsp;корзине"));
        driver.close();
    }
}
