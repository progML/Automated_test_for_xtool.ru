import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class AuthorizationTest {
  Util util;

  // Проверка авторизации
  private void doSuccessfulLogin(WebDriver driver) {
    util.customization(driver);
    util.auth(driver, util.getLogin(), util.getPassword());
    assertEquals(driver.findElement(By.xpath("//div[@class='col-sm-9']")).getText(),
        util.getLogin()); // проверка совпадения введеноого логина и авторизованного
    driver.quit(); // закрываем браузер
  }

  //  Проверка авторизации с неправельными данными
  private void doWrongLogin(WebDriver driver) throws InterruptedException {
    util.customization(driver);
    util.auth(driver, util.getLogin(), "1234");
    Thread.sleep(2000);
    assertEquals(driver.switchTo().alert().getText(),"Не верно задан пароль");
    driver.switchTo().alert().accept();
    driver.quit();
  }

  @Before
  public void setUp() {
    util = new Util();
  }

  @Test
  public void successfulLogin() {
//    doSuccessfulLogin(new FirefoxDriver());
    doSuccessfulLogin(new ChromeDriver());
  }

  @Test
  public void wrongPassword() throws InterruptedException{
//    doWrongLogin(new FirefoxDriver());
    doWrongLogin(new ChromeDriver());
  }
}
