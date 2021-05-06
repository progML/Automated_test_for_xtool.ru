
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Util {


  public String getTestUrl() {
    return "dribbble.com";
  }

  public String getLogin() {
    return "pitkun99@gmail.com";
  }

  public String getPassword() {
    return "icSoL";
  }

  public Util() {
//    System.setProperty("webdriver.gecko.driver","src\\main\\resources\\geckodriver.exe"); FIREFOX
    System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver.exe");

  }

  //установка ожидания
  public void customization(WebDriver driver) {
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    driver.get("https://xtool.ru/");
  }

  //авторизация на сайте
  public void auth(WebDriver driver, String login, String password) {
    driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS); // поиск элемента в течение заданного периода
    String loginPath = "//input[@name='login']";
    String passwordPath = "//input[@name='pass']";
    driver.findElement(By.xpath(loginPath)).sendKeys(login);
    driver.findElement(By.xpath(passwordPath)).sendKeys(password);
    driver.findElement(By.xpath("//button[text()='Войти']")).click();
  }

  //поис сайта
  public void doTrust(WebDriver driver) {
    driver.findElement(By.xpath("//input[@name='site']")).sendKeys(getTestUrl());
    driver.findElement(By.xpath("//button[@id='check-submit']")).click();
  }

}