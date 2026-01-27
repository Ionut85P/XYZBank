package tests;

import models.CustomerModel;
import org.testng.annotations.Test;
import pages.CustomerPage;
import pages.LoginPage;
import pages.ManagerPage;
import sharedData.SharedData;

import java.util.Arrays;
import java.util.List;

public class CreateCostumersTest extends SharedData {

    @Test

    public void automationTest()  {
   //   CustomerModel testData = new CustomerModel("src/test/resources/CustomersData.json");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginBankManager();



        ManagerPage managerPage = new ManagerPage(getDriver());
        managerPage.createCustomer();

        List<String> firstNameValueList = Arrays.asList("Ioan1","Ioan2","Ioan3");
        List<String> lastNameValueList = Arrays.asList("Popaluca1","Popaluca2","Popaluca3");
        List<String> postCodeValueList = Arrays.asList("507028","507029","507030");

        CustomerPage customerPage = new CustomerPage(getDriver());
        customerPage.createCustomersProcess(firstNameValueList,lastNameValueList,postCodeValueList);

    }

}
