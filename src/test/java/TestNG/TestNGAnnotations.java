package TestNG;

import org.testng.annotations.*;

public class TestNGAnnotations {
    @Test   //this one execute the codes
    public void test(){
        System.out.println("I am test");
    }

    @Test
    public void test1(){ //this one execute the codes
        System.out.println("I am SECOND test annotation");
    }

    @BeforeMethod //this one runs before every test annotation and it is good to use for setting up your automation
    public void beforeMethod(){
        System.out.println("I am before method");
    }
    @AfterMethod //this one runs after every test annotation and it is good to use for closing up your automation
    public void afterMethod(){
        System.out.println("I am after method");
    }

    @BeforeClass
    public void beforeClass(){ //it runs before every class and people use to launch their browser river = DriverHelper.getDriver()
        System.out.println("I am beforeClass annotation");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("Developers use it after class");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }
    @BeforeSuite //it will run before everything --> clear the cookies and caches
    public void beforeSuite(){
        System.out.println("I am before SUITE");
    }

}
