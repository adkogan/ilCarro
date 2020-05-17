package com.qa.ilCarro.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    String browser;
    WebDriver wd;
    SessionHelper session;
    UserHelper user;



    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void init() throws InterruptedException {

        if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        }
        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        }//if(browser.equals(BrowserType.EDGE)){
        //wd = new EdgeDriver();
        //  }


        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.navigate().to("https://ilcarro-1578153671498.web.app");
        user = new UserHelper(wd);

        session = new SessionHelper(wd);
        session.login("adkogan@gmail.com", "5605105zxc");
// Thread.sleep(2000);

       // new WebDriverWait(wd, 20).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-test-id=header-member-menu-button]"))

    }


    public boolean isOnBoardsPage() {
        String url = wd.getCurrentUrl();
        return url.contains("boards");
    }

    public void stop() {
        wd.quit();
    }


    public SessionHelper getSession() {
        return session;
    }

    public UserHelper getUser() {
        return user;
    }
}




