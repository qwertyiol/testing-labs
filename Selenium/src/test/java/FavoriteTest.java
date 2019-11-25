import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FavoriteTest {

    /*
10.
1) Зайти на сайт oz.by
2) В поле поиска ввести "Uno"
3) Нажать на ссылку "UNO"
4) Нажать на кнопку "Добавить в избранное"

Ожидание: Появление окна с надписью "Вход"
    */

    @Test
    public void addToFavoriteTest(){
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Nasya\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.oz.by/");
        driver.findElement(By.xpath("//*[@id=\"search-top\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"top-s\"]")).sendKeys("Uno");
        driver.findElement(By.xpath("//*[@class=\"search-tools\"]")).click();
        driver.findElements(By.className("item-type-card__inner")).get(0).click();
        driver.findElement(By.className("b-product-action__content")).click();
        Assert.assertTrue(driver.getPageSource().contains("Вход"));
        driver.close();
    }
}
