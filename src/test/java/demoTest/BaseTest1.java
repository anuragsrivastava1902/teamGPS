package demoTest;

import org.testng.annotations.*;

public class BaseTest1 {

    @BeforeClass
    public void beforeClassTest(){
        System.out.println("this is before class inside the TestFirst class");
    }

    @BeforeMethod
    public void login(){
        System.out.println("this is login");
    }

    @AfterMethod
    public void logOut(){
        System.out.println("this is logout");
    }

    @BeforeSuite
    public void beforeSuitetest(){
        System.out.println("this is before suit in the BaseTest1 class");
    }


}
