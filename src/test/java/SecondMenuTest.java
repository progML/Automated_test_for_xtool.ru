import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class SecondMenuTest {
  Util util;

  private void doReverseLink(WebDriver driver) throws InterruptedException {
    util.customization(driver);
    util.auth(driver, util.getLogin(), util.getPassword());
    Thread.sleep(2000);
    driver.findElement(By.xpath("/html/body/main/div[1]/div[2]/a[2]")).click();
    assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div[2]/h1")).getText(), "Проверка обратных (внешних) ссылок");
    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/form/input")).sendKeys(util.getTestUrl());
    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[1]/form/button")).click();
    assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div[2]/h1")).getText(), "Список обратных ссылок на сайт " + util.getTestUrl());
    assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/i/i/div[1]/table[1]/tbody/tr[1]/th[1]")).getText(), "Акцептор");
    assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/i/i/div[1]/table[1]/tbody/tr[1]/th[2]")).getText(), "Количество");

    assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/i/i/div[1]/table[2]/thead[2]/tr/th[1]")).getText(), "Анкор");
    assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/i/i/div[1]/table[2]/thead[2]/tr/th[2]")).getText(), "Количество");

    driver.quit();
  }



  //проверка валидности ip
  private void checkIp(WebDriver driver)  throws InterruptedException, IOException{
    util.customization(driver);
    util.auth(driver, util.getLogin(), util.getPassword());
    URL ip = new URL("http://checkip.amazonaws.com/");
    BufferedReader in = new BufferedReader(new InputStreamReader(ip.openStream()));
    Thread.sleep(2000);
    driver.findElement(By.xpath("/html/body/main/div[1]/div[2]/a[4]")).click();
    assertEquals(driver.findElement(By.xpath("/html/body/main/div[2]/p[3]")).getText(), in.readLine());
  }


  @Before
  public void setUp() {
    util = new Util();

  }

  @Test
  public void doReverseLink() throws InterruptedException{
//    doMyLocalChecks(new FirefoxDriver());
    doReverseLink(new ChromeDriver());
  }

  @Test
  public void checkIp() throws InterruptedException, IOException{
//    checkIp(new FirefoxDriver());
    checkIp(new ChromeDriver());
  }
}
