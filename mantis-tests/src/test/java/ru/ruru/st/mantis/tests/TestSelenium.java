package ru.ruru.st.mantis.tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.*;


/**
 * Created by m.shoshin on 26.01.2017.
 */
// ссылка : http://internetka.in.ua/selenium-basic-authorization/
//autoit

public class TestSelenium {
        FirefoxDriver wd;

    private final String username = "m.shoshin";
    private final String password = "Qw123456";

    @BeforeTest
    public void start() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test
        public void testBasicAuthenticationFirefox() throws Exception {
            File autoIt = new File("src/test/resources/backoffice.exe");

            // запуск exe с передачей учетных данных
            // в качестве параметра
            Runtime.getRuntime().exec(
                   autoIt.getAbsolutePath() + " "
                           + username + " " + password);

        wd.get("http://192.168.20.22/Estylesoft.JV.BackOffice/index.aspx");
        wd.findElement(By.className("sign-out"));
        Assert.assertEquals(1, 1);
    }

    @AfterTest
    public void tearDown() {
        wd.quit();
    }
}


