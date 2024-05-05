package PageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleLogin extends LandingPage{

	public GoogleLogin(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//*[@id=\"forum_login_wrap_lg\"]")
	WebElement logIn;
	@FindBy(xpath="//*[@id=\"myModal3-modal-content\"]/div[1]/div/div[3]/div[6]/div")
	WebElement googleBtn;
	@FindBy(xpath="//*[@id=\"identifierId\"]")
	WebElement emailId;
	@FindBy(xpath="//*[@id=\"identifierNext\"]/div/button/div[3]")
	WebElement next;
	@FindBy(xpath="//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/div/div/div[1]/form/span/section/div/div/div[1]/div/div[2]/div[2]/div")
	WebElement errorMsg;

	
	public void handleLogIn() {
		try {
		logIn.click();
		Thread.sleep(3000);
		googleBtn.click();
		Set<String> windowIDs  = driver.getWindowHandles(); // store 2 window id's
		 List<String> windowidList = new ArrayList<String>(windowIDs);
	        String childWindowID = windowidList.get(1);
	        driver.switchTo().window(childWindowID);
	        System.out.println("-----------Opened Log in through google-----------");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void putEmail(String email) throws InterruptedException {
		emailId.sendKeys(email);
		Thread.sleep(3000);
		next.click();
		Thread.sleep(5000);
		System.out.println("-----------Put EMail-----------");
	}
	public String getErrorMsg() {
		//this won't work as the website stops this automated login
		return errorMsg.getText();
		
	}

}
