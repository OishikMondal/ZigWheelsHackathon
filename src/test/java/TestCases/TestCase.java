package TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClasses.BaseClass;
import PageObjects.GoogleLogin;
import PageObjects.HomePage;
import PageObjects.UpcomingBikes;
import PageObjects.UsedCars;


public class TestCase extends BaseClass {
	@Test(priority=1)
	public void goToUpcomingBikes() throws InterruptedException, IOException {
		HomePage hp=new HomePage(driver);
		hp.hoverMouse();
		captureScreenshot("goToUpcomingBikes");
		Thread.sleep(4000);
		hp.selectUpcomingBikes();
	}
	@Test(priority=2)
	@Parameters({"manufacturer"})
	public void selectHonda(String name) throws InterruptedException, IOException {
		UpcomingBikes ub=new UpcomingBikes(driver);
		ub.selectManufacturer(name);
		captureScreenshot("selectHonda");
		Thread.sleep(4000);
	}
	@Test(priority=3)
	public void showBikes() throws InterruptedException, IOException {
		UpcomingBikes ub=new UpcomingBikes(driver);
		ub.selectReadMore();
		ub.scrollDown();
		captureScreenshot("showBikes");
		Thread.sleep(4000);
	}
	@Test(priority=4)
	public void fetchBikeDetails() throws InterruptedException, IOException{
		UpcomingBikes ub=new UpcomingBikes(driver);
		ArrayList<String[]> results=ub.captureData();
		captureScreenshot("fetchBikeDetails");
		Thread.sleep(2000);
		System.out.println("Name----------Price----------Expected Launch Date");
		for(String[]result:results) {
			System.out.println(result[0]+"----------"+result[1]+"----------"+result[2]);
		}
	}
	@Test(priority=5)
//	@Parameters({"url"})
	public void moveToUsedCars() throws IOException, InterruptedException, AWTException {
		UpcomingBikes ub=new UpcomingBikes(driver);
		ub.scrollUp();
		ub.navigateToUsedCars();
		captureScreenshot("moveToUsedCars");
	}
	@Test(priority=6)
	public void findTopCars() throws IOException, InterruptedException {
		UsedCars uc=new UsedCars(driver);
		uc.clickOnReadMore();
		uc.scrollDown();
		captureScreenshot("findTopCars");
		Thread.sleep(3000);
	}
	@Test(priority=7)
	public void fetchTopCars() throws IOException {
		UsedCars uc=new UsedCars(driver);
		ArrayList<String[]> topCars=uc.findPopularUsedCars();
		captureScreenshot("fetchTopCars");
		System.out.println("Model----------Price in Chennai");
		for(String[] topCar:topCars) {
			System.out.println(topCar[0]+"----------"+topCar[1]);
		}
	}
	@Test(priority=8)
	public void backToHomePage() throws IOException, InterruptedException {
		UsedCars uc=new UsedCars(driver);
		uc.scrollUptoTop();
		captureScreenshot("backToHomePage");
		Thread.sleep(2000);
		uc.navigateBackToMainPage();
		
	}
	@Test(priority=9)
	public void logIn() {
		GoogleLogin gl=new GoogleLogin(driver);
		gl.handleLogIn();
		captureScreenshot("logIn");
		}
	@Test(priority=10)
	@Parameters({"email"})
	public void invalidLogIn(String email) throws InterruptedException {
		GoogleLogin gl=new GoogleLogin(driver);
		gl.putEmail(email);
		Thread.sleep(3000);
		captureScreenshot("invalidLogIn");
		System.out.println("gl.getErrorMsg()");
	}
}
