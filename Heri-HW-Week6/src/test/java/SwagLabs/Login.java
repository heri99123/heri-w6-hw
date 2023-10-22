package SwagLabs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    @Test
    public void succes_login(){
        WebDriver driver;

        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        //apply chrome driver
        driver = new ChromeDriver();

        //Membuka url website
        driver.manage().window().maximize();
        driver.get(baseUrl);

        //Input User
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Input Password
        driver.findElement(By.id("password")).sendKeys("secret_sauce" );

        //Klik Login
        driver.findElement(By.id("login-button")).click();

        //Logo Toko
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div")).getText();
        String LogoToko = driver.findElement(By.className("app_logo")).getText();
        Assert.assertEquals(LogoToko,"Swag Labs");

        //Quit
        driver.close();

    }

    @Test
    public void failed_login(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        //apply chrome driver
        driver = new ChromeDriver();

        //Membuka url website
        driver.manage().window().maximize();
        driver.get(baseUrl);

        //Input User
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Input Password
        driver.findElement(By.id("password")).sendKeys("123" );

        //Klik Login
        driver.findElement(By.id("login-button")).click();

        //Error Message //h3[@data-test='error']
        String info_error = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(info_error,"Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void add_cart(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        //apply chrome driver
        driver = new ChromeDriver();

        //Membuka url website
        driver.manage().window().maximize();
        driver.get(baseUrl);

        //Input User
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Input Password
        driver.findElement(By.id("password")).sendKeys("secret_sauce" );

        //Klik Login
        driver.findElement(By.id("login-button")).click();

        //Add Cart product Backpack
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        driver.close();
    }

    @Test
    public void remove_cart(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        //apply chrome driver
        driver = new ChromeDriver();

        //Membuka url website
        driver.manage().window().maximize();
        driver.get(baseUrl);

        //Input User
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Input Password
        driver.findElement(By.id("password")).sendKeys("secret_sauce" );

        //Klik Login
        driver.findElement(By.id("login-button")).click();

        //Add Cart product Backpack
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        //Remove Cart product Backpack
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();

        driver.close();
    }
}
