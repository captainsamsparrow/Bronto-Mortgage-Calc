import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MortgagePaymentCalculator {

    WebDriver driver;

    @FindBy(id="calculator_widget_amount")
    WebElement loanAmountTextField;

    @FindBy(id="calculator_widget_interest")
    WebElement interestRateTextField;

    @FindBy(id="calculator_widget_Length")
    WebElement loanLengthTextField;

    @FindBy(id="calculator_widget_HomeValue")
    WebElement homeValueTextField;

    @FindBy(className="next-button")
    WebElement nextButton;

    @FindBy(id="calculator_widget_PropertyTaxes")
    WebElement annualTaxesTextField;

    @FindBy(id="calculator_widget_Insurance")
    WebElement annualInsuranceTextField;

    @FindBy(id="calculator_widget_PMI")
    WebElement annualPMITextField;

    @FindBy(xpath ="//*[@id='wizard-pager']/li[5]/a")
    WebElement showResultsButton;

    @FindBy(xpath ="//*/table/thead/tr[1]/td")
    WebElement monthlyPandI;

    @FindBy(xpath ="//*/table/thead/tr[4]/td")
    WebElement loanValueRatioValue;

    @FindBy(xpath ="//*/table/thead/tr[7]/td")
    WebElement totalMonthlyPayment;


    public MortgagePaymentCalculator(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);

    }

    //============action constructor methods

    public void enterValues() throws InterruptedException {

        Thread.sleep(2000);

        loanAmountTextField.click();
        loanAmountTextField.sendKeys("200000");

        interestRateTextField.click();
        interestRateTextField.sendKeys("5");

        loanLengthTextField.click();
        loanLengthTextField.sendKeys("30");

        homeValueTextField.click();
        homeValueTextField.sendKeys("235000");

        nextButton.click();

        annualTaxesTextField.click();
        annualTaxesTextField.sendKeys("2000");

        annualInsuranceTextField.click();
        annualInsuranceTextField.sendKeys("1865");

        annualPMITextField.click();
        annualPMITextField.sendKeys("0.52");

        showResultsButton.click();

    }

    public void verifyValue1() throws InterruptedException {

        Thread.sleep(2000);

        String tableValue = monthlyPandI.getText();
        Assert.assertEquals(tableValue,"$1,073.64");
        System.out.println("Monthly Principal & Interests: Value Match");

    }

    public void verifyValue2(){

        String tableValue1 = loanValueRatioValue.getText();
        Assert.assertEquals(tableValue1,"85.11%");
        System.out.println("Loan To Value Ratio: Value Match");

    }
    public void verifyValue3(){

        String tableValue2 = totalMonthlyPayment.getText();
        Assert.assertEquals(tableValue2,"$1,482.39");
        System.out.println("Total Monthly Payments: Value Match");

    }

}
