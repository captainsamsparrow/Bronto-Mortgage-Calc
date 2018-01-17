import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class verifyTableValues {


    public static void main(String[] args) throws InterruptedException  {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sam\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.mortgageloan.com/calculator");
        driver.manage().window().maximize();

        //driver.wait(until.elementLocated(By.id("calculator_widget_amount"),5000));

        driver.findElement(By.id(locators.loanAmountTextField)).click();
        driver.findElement(By.id(locators.loanAmountTextField)).sendKeys("200000");

        driver.findElement(By.id(locators.interestRateTextField)).click();
        driver.findElement(By.id(locators.interestRateTextField)).sendKeys("5");

        driver.findElement(By.id(locators.loanLengthTextField)).click();
        driver.findElement(By.id(locators.loanLengthTextField)).sendKeys("30");

        driver.findElement(By.id(locators.homeValueTextField)).click();
        driver.findElement(By.id(locators.homeValueTextField)).sendKeys("235000");

        driver.findElement(By.className(locators.nextButton)).click();

        driver.findElement(By.id(locators.annualTaxesTextField)).click();
        driver.findElement(By.id(locators.annualTaxesTextField)).sendKeys("2000");

        driver.findElement(By.id(locators.annualInsuranceTextField)).click();
        driver.findElement(By.id(locators.annualInsuranceTextField)).sendKeys("1865");

        driver.findElement(By.id(locators.annualPMITextField)).click();
        driver.findElement(By.id(locators.annualPMITextField)).sendKeys("0.52");

        //driver.wait(until.elementLocated(By.className("finish-button"),5000));
        driver.findElement(By.xpath(locators.showResultsButton)).click();

        Thread.sleep(1000);

        String tableValue = driver.findElement(By.xpath(locators.monthlyPandI)).getText();
        Assert.assertEquals(tableValue,"$1,073.64");
        System.out.println("Monthly Principal & Interests: Value Match");

        String tableValue1 = driver.findElement(By.xpath(locators.loanValueRatioValue)).getText();
        Assert.assertEquals(tableValue1,"85.11%");
        System.out.println("Loan To Value Ratio: Value Match");

        String tableValue2 = driver.findElement(By.xpath(locators.totalMonthlyPayment)).getText();
        Assert.assertEquals(tableValue2,"$1,482.39");
        System.out.println("Total Monthly Payments: Value Match");

        System.out.println("I LOVE WHALES");
        driver.close();


    }
}
