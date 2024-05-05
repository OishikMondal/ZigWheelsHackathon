Identify New Bikes

Project Description

	This project aims to identify and display details of upcoming bikes in India. The details include the bike name, its price, and the expected launch date. The focus is on bikes manufactured by Honda and priced less than 4 Lac.

Problem Statement

	1. Display "Upcoming" bikes details like bike name, price, and expected launch date in India, for manufacturer 'Honda' & Bike price should be less than 4 Lac.
	2. For Used cars in Chennai, extract all the popular models in a List; Display the same.
	3. Try to 'Login' with Google, give invalid account details & capture the error message.

The suggested site for this project is zigwheels.com, however, you are free to use any legitimate site.

Key Automation Scope

	The key automation scope of this project includes:

	1. Handling windows & frames**: The project will involve navigating through different windows and frames on the website.
	2. Filling simple form, Capture warning message**: The project will involve filling out forms, such as the login form, and capturing warning messages.
	3. Extract menu items from frames & store in collections**: The project will involve extracting menu items from different frames and storing them in collections for further use.
	4. Navigating back to the home page**: After performing certain actions, the project will involve navigating back to the home page.

Technologies Used

Maven Repository: Maven 3.12.1
	TestNG: 7.4.0
	Extent Report: 5.1.1
	Selenium WebDriver: 4.15.0


Getting Started

	To get started with this project, clone the repository and install the necessary dependencies. Detailed instructions will be provided in the project documentation.

creenshots
	Screenshots are captured at relevant steps for documentation and analysis.

How to Run
	Open Eclipse IDE:

		Launch Eclipse IDE on your machine.
	Import Project:

		Select File -> Import from the menu.
		Choose Existing Maven Projects and click Next.
		Browse to the directory where you cloned the repository and select the project.
	Update Maven Project:

		Right-click on the project in the Project Explorer.
		Choose Maven -> Update Project.
		Click OK to update dependencies.
	Set Up Configuration:

		Open the src/test/resources/config.properties file.
		Update any configuration parameters like browser type, URLs, etc., as needed.
	Run Test Suite:

		Locate the test suite file (CrossBrowsertestng.xml)
		Right-click on the file and choose Run As -> TestNG Suite.
	View Reports:

		After execution, open the test-output folder.
		Find the TestNG file (index.html) for detailed test case reports.
Reporting
	Locate Test Reports:

		After the execution, navigate to the test-output folder in the project directory.
	Open Extent Report:

		Inside the test-output folder, find the Extent Report HTML file named index.html.
	View Test Reports:

		Open the index.html file using any web browser. This report provides a detailed overview of test executions, including passed and failed tests, test duration, and any exceptions encountered.
	Screenshots and Logs:

		screenshots captured during test execution.
	Analyze Results:

		Utilize the visual representation in the TestNG Report to quickly identify test status and any issues encountered during the test run.

