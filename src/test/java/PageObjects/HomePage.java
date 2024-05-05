package PageObjects;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends LandingPage{

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[3]/a")
	WebElement newBikes;
	@FindBy(xpath="//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[3]/ul/li[5]/a")
	WebElement upcomingBikes;
	@FindBy(xpath="//*[@id=\"forum_login_wrap_lg\"]")
	WebElement logIn;
	Actions actions = new Actions(driver);
	public void hoverMouse(){
		try {
			actions.moveToElement(newBikes).build().perform();;
			System.out.println("-----------Hovered to the New Bikes Section-----------");
		}
		catch(ElementNotInteractableException e) {
			e.printStackTrace();
		}
	}
	public void selectUpcomingBikes() {
		try {
			upcomingBikes.click();
			System.out.println("-----------Clicked the Upcoming Bikes Section-----------");
		}
		catch(ElementClickInterceptedException e) {
			e.printStackTrace();
		}
	}
	public void ClickOnLogin() {
		logIn.click();
	}
		

}
