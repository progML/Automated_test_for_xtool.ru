import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class MyChecksTests {
  Util util;


  //хосты
  public void doMyChecks(WebDriver driver) throws InterruptedException{
    util.customization(driver);
    util.auth(driver, util.getLogin(), util.getPassword());
    Thread.sleep(2000);
    driver.findElement(By.xpath("/html/body/main/div[1]/div[1]/a[3]")).click();
    assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div[2]/h1")).getText(), "Мои проверки - Хосты");
    String website = driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr[2]/td[2]/a")).getText();
    String url =  "https://xtool.ru/analyze/_" + website;
    driver.get(url);
    assertEquals(driver.findElement(By.xpath("/html/body/main/div[2]/p[3]")).getText(),
        website);
    driver.quit();
  }


  //внутренние проверки
  public void doMyLocalChecks(WebDriver driver) throws InterruptedException{
    util.customization(driver);
    util.auth(driver, util.getLogin(), util.getPassword());
    Thread.sleep(2000);
    driver.findElement(By.xpath("/html/body/main/div[1]/div[1]/a[3]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/a[2]")).click();
    assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div[2]/h1")).getText(), "Мои проверки - Внутренние");
    assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr[1]/td[1]")).getText(), "Дата и время");
    assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr[1]/td[2]")).getText(), "Страница");
    assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr[1]/td[3]")).getText(), "Траст");

    driver.quit();
  }

  @Before
  public void setUp() {
    util = new Util();

  }

  @Test
  public void doMyChecks() throws InterruptedException {
//    doMyChecks(new FirefoxDriver());
    doMyChecks(new ChromeDriver());
  }

  @Test
  public void doMyLocalChecks() throws InterruptedException {
//    doMyLocalChecks(new FirefoxDriver());
    doMyLocalChecks(new ChromeDriver());
  }
}
