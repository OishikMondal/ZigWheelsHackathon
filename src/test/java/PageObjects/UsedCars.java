package PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsedCars extends LandingPage{

	public UsedCars(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//*[@id=\"seoMore\"]/span")
	WebElement readMoreUsedCars;
	@FindBy(xpath="//*[@id=\"Header\"]/div/div[1]/div[1]")
	WebElement logo;
	By popularCarsName=By.xpath("//*[@id=\"models-table\"]/table/tbody//td[1]");
	By popularCarsPrice=By.xpath("//*[@id=\"models-table\"]/table/tbody//td[2]");
	public void clickOnReadMore() {
		readMoreUsedCars.click();
		System.out.println("----------Clicked on Read More----------");
	}
	public void scrollDown(){
		//scrolling down
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		System.out.println("----------Scrolled Down----------");
	}
	@SuppressWarnings("finally")
	public ArrayList<String[]> findPopularUsedCars(){
		ArrayList<String[]> popularCarsDetails=new ArrayList<>();
		try {
			//getting all the top 5 popular cars from the list
			List<WebElement> carsName=driver.findElements(popularCarsName);
			List<WebElement> carsPrice=driver.findElements(popularCarsPrice);
			for(int i=0;i<carsName.size();i++) {
				String[] arr=new String[2];
				arr[0]=carsName.get(i).getText();
				arr[1]=carsPrice.get(i).getText();
				popularCarsDetails.add(arr);
			}
			
		}
		catch(Exception e) {	
		e.printStackTrace();
		}
		finally {
			System.out.println("----------Fetched the Popular Cars----------");
		return popularCarsDetails;
		}
	}
	public void scrollUptoTop() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-400)", "");
		System.out.println("----------Scrolled up----------");
		
	}
	public void navigateBackToMainPage() {
		//navigating to main page as per requirement in the project
		logo.click();
		System.out.println("----------Navigated Back to main Page----------");
	}
	
	
	
	

}
