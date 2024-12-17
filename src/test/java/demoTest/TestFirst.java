package demoTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestFirst extends BaseTest1{

    @BeforeMethod
   public void beforeMethodTest(){
       System.out.println("this is before method inside the TestFirst class");
   }




    @Test
    public void testFirst(){
        System.out.println("this is the first test");
        Assert.assertTrue(11>2,"failed");
    }

    @Test(dependsOnMethods = {"testFirst"})
    public void testSecond(){
        System.out.println("this is the second test");
    }


}
