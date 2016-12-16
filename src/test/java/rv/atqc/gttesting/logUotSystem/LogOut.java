package rv.atqc.gttesting.logUotSystem;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * Created by roman on 15.12.16.
 */@Test
public class LogOut {
  //  public static ChromeDriver driver;


    public static void main(String[] args) {

        ChromeDriverManager.getInstance().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://green-tourism.herokuapp.com/#!/");

        WebElement webElement = driver.findElement(By.cssSelector("html.ng-scope body header nav.navbar.navbar-default.navbar-fixed-top.navbar-style.ng-scope div.container.nav-padding div#navbar.collapse.navbar-collapse ul.nav.navbar-nav li.dropdown a.dropdown-toggle i.fa.fa-user.navtop"));
        webElement.click();

        WebElement webElementFacbook = driver.findElement(By.cssSelector("html.ng-scope body header nav.navbar.navbar-default.navbar-fixed-top.navbar-style.ng-scope div.container.nav-padding div#navbar.collapse.navbar-collapse ul.nav.navbar-nav li.dropdown.open ul.dropdown-menu.dropdown-auth.nav-ul auth.ng-isolate-scope div.ng-scope div.container.registration.ng-scope p a.btn.btn-block.btn-social.btn-facebook"));
        webElementFacbook.click();


        WebElement webElementFacLog = driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div/div/div[2]/form/div/div[1]/input"));
        //webElementFacLog.click();
        webElementFacLog.sendKeys("17141@rambler.ru");
        driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div/div/div[2]/form/div/div[2]/input")).sendKeys("RVAT1234");
        driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div/div/div[2]/form/div/div[3]/button")).click();
        WebElement greenButtonOnLoginedPage  =  driver.findElement(By.cssSelector("html.ng-scope body header nav.navbar.navbar-default.navbar-fixed-top.navbar-style.ng-scope div.container.nav-padding div#navbar.collapse.navbar-collapse ul.nav.navbar-nav li.dropdown a.dropdown-toggle i.fa.fa-user.navtop"));

        greenButtonOnLoginedPage.click();

        driver.findElement(By.xpath("/html/body/header/nav/div/div[2]/ul[1]/li/ul/li[2]/a"));


        System.out.println("You are loggined succsessfully");
        //driver.close();



    }
//    @AfterMethod
//
//    public void afterMethod() {
//
//        // Close the driver
//
//        driver.close();
//
//    }
}
