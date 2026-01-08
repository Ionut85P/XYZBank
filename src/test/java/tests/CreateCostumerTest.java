package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

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


//        WebElement bankManagerElement = driver.findElement(By.xpath("//button[normalize-space()='Bank Manager Login']"));
//        bankManagerElement.click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginBankManager();
//        WebElement addCustomerElement = driver.findElement(By.xpath("//button[@ng-click='addCust()']"));
//        addCustomerElement.click();
        ManagerPage managerPage = new ManagerPage(driver);
        managerPage.createCustomer();

//        WebElement firstNameElement = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        String firstNameValue = "Ioan";
//        firstNameElement.sendKeys(firstNameValue);

//        WebElement lastNameElement = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        String lastNameValue = "Popaluca";
//        lastNameElement.sendKeys(lastNameValue);

//        WebElement postCodeElement = driver.findElement(By.xpath("//input[@placeholder='Post Code']"));
        String postCodeValue = "507028";
//        postCodeElement.sendKeys(postCodeValue);

//        WebElement submitCustomerElement = driver.findElement(By.xpath("//button[@type='submit']"));
//        submitCustomerElement.click();
//
//        Alert costumerAlert = driver.switchTo().alert();
//        String costumerAlertText = costumerAlert.getText();
//
//        System.out.println(costumerAlertText);
//        costumerAlert.accept();

        CustomerPage customerPage = new CustomerPage(driver);
        customerPage.createCustomerProcess(firstNameValue,lastNameValue,postCodeValue);
        customerPage.openAccount();

//            WebElement openAccount = driver.findElement(By.xpath("//button[@ng-click='openAccount()']"));
//            openAccount.click();
//            WebElement customerName = driver.findElement(By.id("userSelect"));
//        Select customerSelect = new Select(customerName);
        String fullName = firstNameValue + " " + lastNameValue;
//        customerSelect.selectByVisibleText(fullName);

//        WebElement currency = driver.findElement(By.id("currency"));
//        Select currencySelect = new Select(currency);
        String currencyValue = "Dollar";
//        currencySelect.selectByVisibleText(currencyValue);


//
//    WebElement process = driver.findElement(By.xpath("//button[@type ='submit']"));
//    process.click();

//        Alert accountAlert = driver.switchTo().alert();
//        String accountAlertText = accountAlert.getText();
//        System.out.println(accountAlertText);
//        String [] accountsArray = accountAlertText.split(":");
//        String accountNumber = accountsArray[1];
//        System.out.println(accountsArray[1]);
//        accountAlert.accept();

        AccountPage accountPage = new AccountPage(driver);
        accountPage.createAccountProcess(fullName,currencyValue);
        accountPage.goToCustomers();

//        WebElement customers = driver.findElement(By.xpath("//button[@ng-click='showCust()']"));
//        customers.click();
//
        CustomersPage customersPage = new CustomersPage(driver);
        customersPage.searchCustomer(firstNameValue);
        customersPage.validateCustomer(firstNameValue, lastNameValue, postCodeValue);
        customersPage.deleteCustomer();


    }

}
