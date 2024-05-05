package PageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UpcomingBikes extends LandingPage{

	public UpcomingBikes(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//*[@id=\"makeId\"]")
	WebElement manufacturer;
	@FindBy(xpath="/html/body/main/div/div/div[1]/div[1]/div[1]/div/div[2]/span/span")
	WebElement readMore;
	@FindBy(xpath="//*[@id=\"Header\"]/div/div[1]/div[1]/a/img")
	WebElement logo;
	public void selectManufacturer(String name) {
		try {
			Select select=new Select(manufacturer);
			select.selectByVisibleText(name);
			System.out.println("-----------Selected the Honda as manufacturer-----------");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	public void selectReadMore() {
		try {
			readMore.click();
			System.out.println("-----------Clicked on the read more button-----------");
		}
		catch(ElementClickInterceptedException e) {
			e.printStackTrace();
		}
	}
	public void scrollDown() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,375)", "");
			System.out.println("-----------Scrolled Down to the list-----------");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("finally")
	public ArrayList<String[]> captureData() {
		ArrayList<String[]> selectedBikes=new ArrayList<>();
		try {
			Thread.sleep(5000);
			//Storing price,name and revealed date in three different lists
			List<WebElement> pricesList =driver.findElements(By.xpath("/html/body/main/div/div/div[1]/div[1]/div[1]/div/div[2]/div/table/tbody//td[2]"));
			List<WebElement> nameList=driver.findElements(By.xpath("/html/body/main/div/div/div[1]/div[1]/div[1]/div/div[2]/div/table/tbody//td[1]"));
			List<WebElement> revealedList=driver.findElements(By.xpath("/html/body/main/div/div/div[1]/div[1]/div[1]/div/div[2]/div/table/tbody//td[3]")); 
			//Iterating through the prices to see which is less than 4.00 Lakhs
			for(int i=0;i<pricesList.size();i++) {
				//getting all the texts 
				String priceOfBike=pricesList.get(i).getText();
				String nameOfBike=nameList.get(i).getText();
				String dateOfReveal=revealedList.get(i).getText();
				//replacing Rs. from the string of price
				String specificPrice=(priceOfBike.replaceAll("Rs. ", ""));
				//See if the price is in Lakhs
				if(specificPrice.contains("Lakh")) {
					//Replacing Lakh
				
					specificPrice=specificPrice.replaceAll(" Lakh", "");
					//Checking in Lakhs
					if(Float.parseFloat(specificPrice)<4.00) {
						String arr[]=new String[3];
						arr[0]=nameOfBike;
						arr[1]=priceOfBike;
						arr[2]=dateOfReveal;
						selectedBikes.add(arr);
//						ExcelUtilities.writeExcel("HondaBikes", i, 0,nameOfBike);
//						ExcelUtilities.writeExcel("HondaBikes", i, 1,priceOfBike);
//						ExcelUtilities.writeExcel("HondaBikes", i, 2,dateOfReveal);
				}
			}
			else {
					String arr[]=new String[3];
					arr[0]=nameOfBike;
					arr[1]=priceOfBike;
					arr[2]=dateOfReveal;
					selectedBikes.add(arr);
//					ExcelUtilities.writeExcel("HondaBikes", i, 0,nameOfBike);
//					ExcelUtilities.writeExcel("HondaBikes", i, 1,priceOfBike);
//					ExcelUtilities.writeExcel("HondaBikes", i, 2,dateOfReveal);
					
				}
					
		}	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("-----------Fetched the list of Bikes under 4.00 Lakhs-----------");
		return selectedBikes;
		}
	}
	public void scrollUp() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-400)", "");
			System.out.println("-----------Scrolled up to the top-----------");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void navigateToUsedCars() throws InterruptedException, AWTException{
			//moving to the element used cars in the web page
		//driver.navigate().to(url);
		logo.click();
		System.out.println("-----------Navigated back to Home Page-----------");
		//used robot class becuase mouse hover was not working
		Robot robot=new Robot();
		Thread.sleep(3000);
		robot.mouseMove(850, 200);
		Thread.sleep(3000);
		robot.mouseMove(1200,350);
		Thread.sleep(3000);
		//findChennai.click();
		WebElement el=driver.findElement(By.xpath("//a[@href=\"/used-car/Chennai\"]"));
		Actions action=new Actions(driver);
		action.moveToElement(el).click().build().perform();
		System.out.println("-----------Navigated to the Used Cars-----------");
		
	}

	
	
	
}