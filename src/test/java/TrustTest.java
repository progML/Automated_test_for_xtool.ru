import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class TrustTest {
  Util util;
//  String URL = "dribbble.com";


  //Проврка информации анализируемого сайта (Основные данные)
  private void checkSite(WebDriver driver) throws InterruptedException {
    util.customization(driver);
    util.auth(driver, util.getLogin(), util.getPassword());
    Thread.sleep(2000);
    util.doTrust(driver);
    assertEquals(driver.findElement(By.xpath("/html/body/main/div[2]/p[3]")).getText(),
        util.getTestUrl()); // Проверка требуемого сайта
    //проверки вывода всех метрик
    assertEquals(driver.findElement(By.xpath("/html/body/main/div[2]/div[6]/ul/li[1]/ul/li[2]")).getText(),
        "Дата проверки: 2021-04-26 11:42:37");
    assertEquals(driver.findElement(By.xpath("/html/body/main/div[2]/div[6]/ul/li[1]/ul/li[3]")).getText(), "Ссылки:");
    assertEquals(driver.findElement(By.xpath("/html/body/main/div[2]/div[6]/ul/li[1]/ul/li[11]")).getText(),
        "Санкции:");
    assertEquals(driver.findElement(By.xpath("/html/body/main/div[2]/div[6]/ul/li[1]/ul/li[16]")).getText(),
        "Индексация:");
    assertEquals(driver.findElement(By.xpath("/html/body/main/div[2]/div[6]/ul/li[1]/ul/li[21]")).getText(),
        "Возраст:");
    assertEquals(driver.findElement(By.xpath("/html/body/main/div[2]/div[6]/ul/li[1]/ul/li[24]")).getText(),
        "Популярность:");
    driver.quit(); // закрываем браузер
  }


  //Проврка  видимости в яндекс
  private void checkYandexAndGoogle(WebDriver driver) throws InterruptedException {
    util.customization(driver);
    util.auth(driver, util.getLogin(), util.getPassword());
    Thread.sleep(2000);
    util.doTrust(driver);
    driver.findElement(By.xpath("/html/body/main/div[2]/ul[2]/li[10]")).click();

    //Yandex
    String y = driver.findElement(By.xpath("/html/body/main/div[2]/div[3]/div[3]/table/tbody/tr[1]")).getText();
    driver.findElement(By.xpath("/html/body/main/div[2]/div[3]/div[2]/div[3]/div/select/option[2]")).click();
    String y2 = driver.findElement(By.xpath("/html/body/main/div[2]/div[3]/div[3]/table/tbody/tr[1]")).getText();
    assertNotNull(y);
    assertNotNull(y2);
    assertNotEquals(y, y2);

    Thread.sleep(2000);

    //Google
    driver.findElement(By.xpath("/html/body/main/div[2]/ul[2]/li[11]")).click();
    String g = driver.findElement(By.xpath("/html/body/main/div[2]/div[4]/div[3]/table/tbody/tr[1]")).getText();
    System.out.println(g);
    driver.findElement(By.xpath("/html/body/main/div[2]/div[4]/div[2]/div[3]/div/select/option[2]")).click();
    String g2 = driver.findElement(By.xpath("/html/body/main/div[2]/div[3]/div[3]/table/tbody/tr[1]")).getText();
    assertNotNull(g);
    assertNotNull(g2);
    assertNotEquals(g, g2);



    driver.quit();
  }


  //Проврка загрузки (Whios данных)
  private void checkWhios(WebDriver driver) throws InterruptedException {
    util.customization(driver);
    util.auth(driver, util.getLogin(), util.getPassword());
    Thread.sleep(2000);
    util.doTrust(driver);
    driver.findElement(By.xpath("/html/body/main/div[2]/ul[2]/li[14]")).click();
    assertEquals(driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/span/span")).getText(),
        "Данные Whois для сайта");
    assertEquals(driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/p/b")).getText(), util.getTestUrl());
    driver.quit();

  }

  @Before
  public void setUp() {
    util = new Util();

  }

  //Проврка  вывода информации анализируемого сайта
  @Test
  public void checkSite() throws InterruptedException {
//    checkSite(new FirefoxDriver());
    checkSite(new ChromeDriver());
  }

  @Test
  public void checkWhios() throws InterruptedException {
    //    checkWhios(new FirefoxDriver());
    checkWhios(new ChromeDriver());
  }


  @Test
  public void checkYandexAndGoogle() throws InterruptedException {
    //    checkWhios(new FirefoxDriver());
    checkYandexAndGoogle(new ChromeDriver());
  }


}
