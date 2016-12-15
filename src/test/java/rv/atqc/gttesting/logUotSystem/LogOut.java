package rv.atqc.gttesting.logUotSystem;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Created by roman on 15.12.16.
 */
public class LogOut {

    @Test
    public static void main(String[] args) {
        ChromeDriverManager.getInstance().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://green-tourism.herokuapp.com/#!/");
        //driver.findElement(By.cssSelector("dropdown-toggle")).click();
        //driver.close();
        WebElement webElement = driver.findElement(By.cssSelector("html.ng-scope body header nav.navbar.navbar-default.navbar-fixed-top.navbar-style.ng-scope div.container.nav-padding div#navbar.collapse.navbar-collapse ul.nav.navbar-nav li.dropdown a.dropdown-toggle i.fa.fa-user.navtop"));
        webElement.click();

        WebElement webElementFacbook = driver.findElement(By.cssSelector("html.ng-scope body header nav.navbar.navbar-default.navbar-fixed-top.navbar-style.ng-scope div.container.nav-padding div#navbar.collapse.navbar-collapse ul.nav.navbar-nav li.dropdown.open ul.dropdown-menu.dropdown-auth.nav-ul auth.ng-isolate-scope div.ng-scope div.container.registration.ng-scope p a.btn.btn-block.btn-social.btn-facebook"));
        webElementFacbook.click();

        driver.findElement(By.cssSelector("html#facebook body.login_page._39il.UIPage_LoggedOut._-kb.b_c3pyn-ahh.gecko.x1.Locale_en_US div._li div#globalContainer.uiContextualLayerParent div#content.fb_content.clearfix div._4-u5._30ny div._4-u2._1w1t._4-u8._52jv div.login_form_container form#login_form div#loginform div.clearfix._5466._44mg input#email.inputtext._55r1.inputtext._1kbt.inputtext._1kbt")).sendKeys("testuser_1");


    }
}
//html.ng-scope body header nav.navbar.navbar-default.navbar-fixed-top.navbar-style.ng-scope div.container.nav-padding div#navbar.collapse.navbar-collapse ul.nav.navbar-nav li.dropdown.open ul.dropdown-menu.dropdown-auth.nav-ul auth.ng-isolate-scope div.ng-scope div.container.registration.ng-scope