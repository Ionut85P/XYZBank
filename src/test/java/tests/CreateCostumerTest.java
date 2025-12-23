package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class CreateCostumerTest {
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


        WebElement firstNameElement = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        String firstNameValue = "Ioan";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        String lastNameValue = "Popaluca";
        lastNameElement.sendKeys(lastNameValue);

        WebElement postCodeElement = driver.findElement(By.xpath("//input[@placeholder='Post Code']"));
        String postCodeValue = "507028";
        postCodeElement.sendKeys(postCodeValue);

        WebElement submitCustomerElement = driver.findElement(By.xpath("//button[@type='submit']"));
        submitCustomerElement.click();

        Alert costumerAlert = driver.switchTo().alert();
        String costumerAlertText = costumerAlert.getText();

        System.out.println(costumerAlertText);
        costumerAlert.accept();

            WebElement openAccount = driver.findElement(By.xpath("//button[@ng-click='openAccount()']"));
            openAccount.click();
            WebElement customerName = driver.findElement(By.id("userSelect"));
        Select customerSelect = new Select(customerName);
        String fullName = firstNameValue + " " + lastNameValue;
        customerSelect.selectByVisibleText(fullName);

        WebElement currency = driver.findElement(By.id("currency"));
        Select currencySelect = new Select(currency);
        String currencyValue = "Dollar";
        currencySelect.selectByVisibleText(currencyValue);


    WebElement process = driver.findElement(By.xpath("//button[@type ='submit']"));
    process.click();

        Alert accountAlert = driver.switchTo().alert();
        String accountAlertText = accountAlert.getText();
        System.out.println(accountAlertText);
        String [] accountsArray = accountAlertText.split(":");
        String accountNumber = accountsArray[1];
        System.out.println(accountsArray[1]);
        accountAlert.accept();



        WebElement customers = driver.findElement(By.xpath("//button[@ng-click='showCust()']"));
        customers.click();


        WebElement searchCustomerElement = driver.findElement(By.xpath("//input[@placeholder='Search Customer']"));
        searchCustomerElement.sendKeys(firstNameValue);

        List<WebElement> tableRows = driver.findElements(By.xpath("//tbody/tr"));
        String customerTableRow = tableRows.get(0).getText();
        Assert.assertTrue(customerTableRow.contains(firstNameValue));
        Assert.assertTrue(customerTableRow.contains(lastNameValue));
        Assert.assertTrue(customerTableRow.contains(postCodeValue));
        Assert.assertTrue(customerTableRow.contains(accountNumber));

        WebElement deleteCustomerElement = driver.findElement(By.xpath("//button[@ng-click='deleteCust(cust)']"));
        deleteCustomerElement.click();


    }

}
