import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class verifyTableValues {

    WebDriver driver;
    MortgagePaymentCalculator mortgagePaymentCalculator;


    @BeforeTest
            public void setUp(){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\sam\\IdeaProjects\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.mortgageloan.com/calculator");
            }

    @Test

            public void verifyTableValues() throws InterruptedException {


                mortgagePaymentCalculator =  new MortgagePaymentCalculator(driver);

                mortgagePaymentCalculator.enterValues();

                mortgagePaymentCalculator.verifyValue1();

                mortgagePaymentCalculator.verifyValue2();

                mortgagePaymentCalculator.verifyValue3();

                System.out.println("I LOVE WHALES");
                driver.close();

    }

    }
