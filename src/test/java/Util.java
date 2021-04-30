
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Util {
  public String getBaseUrl() {
    return baseUrl;
  }

  private String baseUrl;
  private final String correctLogin = "matveyles@gmail.com";
  private final String correctPassword = "4S1FLA";

  public String getCorrectLogin() {
    return correctLogin;
  }

  public String getCorrectPassword() {
    return correctPassword;
  }

  public Util() {
//    System.setProperty("webdriver.gecko.driver","src\\main\\resources\\geckodriver.exe"); FIREFOX
    System.setProperty("webdriver.chrome.driver","C:\\tools\\chromedriver.exe");
    baseUrl = "https://xtool.ru/";
  }


  //ЗОЧЕМ?
  public void prepare(WebDriver driver){
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.get(getBaseUrl());
  }

  public boolean isElementPresent(WebDriver driver, By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public void tryClick(WebDriver driver, By selector) {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    element.sendKeys(Keys.ENTER);
  }


  //авторизация пользовтеля
  public void auth(WebDriver driver, String login, String password){
    driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
    String loginPath = "//input[@name='login']";
    String passwordPath = "//input[@name='pass']";
//    driver.findElement(By.xpath("//*[contains(text(), 'Войти')]")).click();
//    driver.findElement(By.xpath(loginPath)).clear();
    driver.findElement(By.xpath(loginPath)).sendKeys(login);
    driver.findElement(By.xpath(passwordPath));
    driver.findElement(By.xpath(passwordPath)).sendKeys(password);;
    driver.findElement(By.xpath("//button[text()='Войти']")).click();
  }
}