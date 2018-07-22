/*
 * Automation Project #1
 * Seleumin WebDriver
 */
package test.com;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Mital Patel
 */
public class Flightclubtest {
     private WebDriver driver;
     private String baseUrl;
     
    public Flightclubtest() 
    {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp()
    {
         System.setProperty("webdriver.gecko.driver", 
                "C:\\Users\\Sujal\\Desktop\\geckodriver.exe");
         System.setProperty("webdriver.chrome.driver", 
                 "C:\\Users\\Sujal\\Desktop\\chromedriver.exe");
    }
   
    @Test
    public void FlightTestFirefoxDriver() throws InterruptedException {
        driver = new FirefoxDriver();
        baseUrl = "http://us.flightclubdarts.com/chicago/";
        driver.get(baseUrl + "/chicago/book-now/");
        Thread.sleep(2000);
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys("Gopi");
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys("Patel");
        driver.findElement(By.id("mobilePhone")).clear();
        driver.findElement(By.id("mobilePhone")).sendKeys("5565353343");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("gopi@gmail.com");
        driver.findElement(By.id("customData0tx00")).clear();
        driver.findElement(By.id("customData0tx00")).sendKeys("London");
        driver.findElement(By.id("eventDate")).click();
        driver.findElement(By.linkText("26")).click();
        Select eventList = new Select(driver.findElement(By.id("eventTime")));
        eventList.selectByVisibleText("12:00 AM");
        String selectedValue = eventList.getFirstSelectedOption().getText();
        System.out.println(selectedValue);
        if(selectedValue.equals("12:00 AM")) {
            driver.findElement(By.id("estimatedAttendance")).clear();
            driver.findElement(By.id("estimatedAttendance")).sendKeys("200");
            driver.findElement(By.id("description")).clear();
            driver.findElement(By.id("description")).sendKeys("Hello");
            driver.findElement(By.id("customData0tx00")).clear();
            driver.findElement(By.id("customData0tx00")).sendKeys("Visit");
            driver.findElement(By.id("rcFormSaveButton")).click();
            Thread.sleep(2000);
            String actualResult = driver.findElement(By.xpath("/html/body/"
                    + "div[1]/div[2]/div/div/div/main/article/div/div[1]"
                    + "/div/div/div/div/div[2]/div/div/div[2]/div/div/"
                    + "div[3]/p")).getText();
            System.out.println("FireFox Driver Result: " + actualResult);
            Assert.assertEquals("Your request has been saved. Details will "
                    + "be emailed to the address you provided.", actualResult);
        }
    }
    
    @Test
    public void FlightTestChromeDriver() throws InterruptedException
    {
        driver = new ChromeDriver();
        baseUrl = "http://us.flightclubdarts.com/chicago/";
        driver.get(baseUrl + "/chicago/book-now/");
        Thread.sleep(2000);
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys("Gopi");
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys("Patel");
        driver.findElement(By.id("mobilePhone")).clear();
        driver.findElement(By.id("mobilePhone")).sendKeys("5565353343");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("gopi@gmail.com");
        driver.findElement(By.id("customData0tx00")).clear();
        driver.findElement(By.id("customData0tx00")).sendKeys("London");
        driver.findElement(By.id("eventDate")).click();
        driver.findElement(By.linkText("26")).click();
        new Select(driver.findElement(By.id("eventTime")))
                .selectByVisibleText("12:00 AM");
        driver.findElement(By.cssSelector("option[value=\"12:00 AM\"]")).click();
        driver.findElement(By.id("estimatedAttendance")).clear();
        driver.findElement(By.id("estimatedAttendance")).sendKeys("200");
        driver.findElement(By.id("description")).clear();
        driver.findElement(By.id("description")).sendKeys("Hello");
        driver.findElement(By.id("customData0tx00")).clear();
        driver.findElement(By.id("customData0tx00")).sendKeys("Visit");
        driver.findElement(By.id("rcFormSaveButton")).click();
        Thread.sleep(2000);
        String actualResult = driver.findElement(By.xpath("/html/body/div[1]/"
                + "div[2]/div/div/div/main/article/div/div[1]/div/div/div/div/"
                + "div[2]/div/div/div[2]/div/div/div[3]/p")).getText();
        System.out.println("Chrome Driver Result: " + actualResult);
        Assert.assertEquals("Your request has been saved. Details will be "
                + "emailed to the address you provided.", actualResult);
    }
     
    @After
    public void tearDown() {
       driver.quit();
    }
}
