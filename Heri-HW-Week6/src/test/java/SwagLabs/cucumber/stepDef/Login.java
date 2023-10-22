package SwagLabs.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    WebDriver driver;
    String baseurl = "https://www.saucedemo.com/";

    public Login() {
        WebDriverManager.chromedriver().driverVersion("LATEST").setup();
    }
    @Given("Halaman Login Web")
    public void HalamanLoginWeb(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECODS);
        driver.get(baseurl);
    }
    @When("Input user-name")
    public void inputUsername(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input password")
    public void inputPassword(){
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("click login button")
    public void clickLoginButtong(){
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User in on Dashboard Page")
    public void userInDashboard(){
        boolean isLogoPresent = driver.findElements(By.className("app_logo")).size() > 0;
        Assert.assertTrue(isLogoPresent);
        driver.close();
    }

    @And("Input Invalid password")
    public void inputInvalidPassword(){
        driver.findElement(By.id("password")).sendKeys("1234567" );
    }

    @Then("User get error message")
    public void userGetErrorMessage(){
        String info_error = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(info_error,"Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }
}
