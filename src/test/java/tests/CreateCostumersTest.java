package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class CreateCostumersTest {
    public WebDriver driver;

    @Test

    public void automationTest()  {
        driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));


        WebElement bankManagerElement = driver.findElement(By.xpath("//button[normalize-space()='Bank Manager Login']"));
        bankManagerElement.click();

        WebElement addCustomerElement = driver.findElement(By.xpath("//button[@ng-click='addCust()']"));
        addCustomerElement.click();

        List<String> firstNameValueList = Arrays.asList("Ioan1","Ioan2","Ioan3");
        List<String> lastNameValueList = Arrays.asList("Popaluca1","Popaluca2","Popaluca3");
        List<String> postCodeValueList = Arrays.asList("507028","507029","507030");
        String fullName ="";
        int index = 0;
        while (index<firstNameValueList.size()){

            WebElement firstNameElement = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
            firstNameElement.sendKeys(firstNameValueList.get(index));

            WebElement lastNameElement = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
            lastNameElement.sendKeys(lastNameValueList.get(index));

            WebElement postCodeElement = driver.findElement(By.xpath("//input[@placeholder='Post Code']"));
            postCodeElement.sendKeys(postCodeValueList.get(index));

            WebElement submitCustomerElement = driver.findElement(By.xpath("//button[@type='submit']"));
            submitCustomerElement.click();

            Alert costumerAlert = driver.switchTo().alert();
            String costumerAlertText = costumerAlert.getText();

            System.out.println(costumerAlertText);
            costumerAlert.accept();
            fullName = firstNameValueList.get(index) + " " + lastNameValueList.get(index);
            index++;

        }


    }

}
