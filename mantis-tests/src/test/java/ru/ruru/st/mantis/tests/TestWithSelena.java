package ru.ruru.st.mantis.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


/**
 * Created by m.shoshin on 09.02.2017.
 */
public class TestWithSelena extends TestBase{


        ChromeDriver wd;

        @BeforeMethod
        public void setUp() throws Exception {
            wd = new ChromeDriver();
            wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }

        @Test
        public void testWithSelena() {
            wd.get("http://localhost/addressbook/");
            wd.findElement(By.name("user")).click();
            wd.findElement(By.name("user")).clear();
            wd.findElement(By.name("user")).sendKeys("admin");
            wd.findElement(By.name("pass")).click();
            wd.findElement(By.name("pass")).clear();
            wd.findElement(By.name("pass")).sendKeys("secret");
            wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
            wd.findElement(By.linkText("add new")).click();
            wd.findElement(By.name("firstname")).click();
            wd.findElement(By.name("firstname")).clear();
            wd.findElement(By.name("firstname")).sendKeys("sdfgseg");
            wd.findElement(By.name("lastname")).click();
            wd.findElement(By.name("lastname")).clear();
            wd.findElement(By.name("lastname")).sendKeys("sdgsg");
            wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
        }

        @AfterMethod
        public void tearDown() {
            wd.quit();
        }

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}


