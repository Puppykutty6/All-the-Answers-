package pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class verification_page extends StartupPage {


//	TC-1 to 4 Locators
	
	public By getUsernameTextfieldLocator() {
		return By.id("username_id");
	}
	public By getUsernameTextboxLocator() {
		return By.xpath("//input[@id='username_id']");
	}

	public By getPasswordTextboxLocator() {
		return By.xpath("//input[@id='password']");
	}

	public By getSignInButtonLocator() {
		return By.xpath("//button[@id='login']");
	}

	public By getVerificationLocator() {
		return By.xpath("//a[@href='#/Verification']");
	}
	
//	TC-5 Locators
	public By getPageBarFixedLocator(String navBarName) {
		return By.xpath("//ul[@class='page-breadcrumb']/li/a[@href='#/Verification/" + navBarName + "']");
	}
	
	public By getSubNavTabLocator(String subNavName) {
		return By.xpath("//div[@class=\"sub-navtab\"]/ul/li/a[text()='" + subNavName + "']");
	}
	
//	TC-6 Locators
	
	public By getActualRequestedOnDates() {
		return By.xpath("//div[@col-id=\"RequisitionDate\"]/span[not(contains(@class,'hidden'))]");
	}
//	TC-7 Locators
	public By favouriteOrStarIcon() {
		return By.xpath("//i[contains(@class,'icon-favourite')]");
	}
	
//	TC-8 LOcators
	public By calendarFromDropdown() {
		return By.xpath("(//input[@id='date'])[1]");
	}

	public By calendarToDropdown() {
		return By.xpath("(//input[@id='date'])[2]");
	}
	
	public By getOkButtonLocator() {
		return By.xpath("//button[@class='btn green btn-success']");
	}
	
	public By getStarIconLocator() {
		return By.xpath("//i[contains(@class,'icon-favourite')]/..");
	}
//	TC-9 Locators
	public By getDateRangeButton() {
		return By.cssSelector("td [data-hover='dropdown']");
	}
	
	public By getAnchorTagLocatorByText(String anchorTagName) {
		return By.xpath("//a[contains(text(),'" + anchorTagName + "')]");
	}



	public verification_page(WebDriver driver) {
		super(driver);
	}

	/**
	 * @Test1.1 - Test method for logging into the HealthApp with valid credentials.
	 * 
	 * @param expectedData A Map containing the username and password as key-value pairs.
	 * @description This method fills in the username and password text boxes and clicks the sign-in button.
	 *              It then verifies if the login was successful.
	 * @return boolean indicating whether the login process was executed successfully.
	 * @author Yaksha
	 * @throws Exception If any error occurs during the login process.
	 */
	public boolean loginToHealthAppByGivenValidCredetial(Map<String, String> expectedData) throws Exception {
		Boolean textIsDisplayed = false;
		try {
			WebElement usernametextFieldWebElement = commonEvents.findElement(getUsernameTextfieldLocator());
			commonEvents.highlightElement(usernametextFieldWebElement);
			commonEvents.sendKeys(getUsernameTextfieldLocator(), expectedData.get("username"));

			WebElement passwordtextFieldWebElement = commonEvents.findElement(getPasswordTextboxLocator());
			commonEvents.highlightElement(passwordtextFieldWebElement);
			commonEvents.sendKeys(getPasswordTextboxLocator(), expectedData.get("password"));

			WebElement signinButtonWebElement = commonEvents.findElement(getPasswordTextboxLocator());
			commonEvents.highlightElement(signinButtonWebElement);
			commonEvents.click(getSignInButtonLocator());
			textIsDisplayed = true;
		} catch (Exception e) {
			throw e;
		}
		return textIsDisplayed;
	}

	/**
	 * @Test1.2 - Scroll down and click the verification tab.
	 * 
	 * @description This method verifies the presence of the verification tab, scrolls to it,
	 *              highlights it, and clicks on it. It then waits for the page URL to update accordingly.
	 * @return void
	 * @author YAKSHA
	 * @throws Exception If an error occurs during execution.
	 */
	public void scrollDownAndClickVerificationTab() throws Exception {
		try {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			WebElement verificationTab = commonEvents.findElement(getVerificationLocator());
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", verificationTab);
			commonEvents.highlight(verificationTab);
			commonEvents.click(verificationTab);

			// Wait for the URL to contain "Verification/Inventory"
			commonEvents.waitForUrlContains("Verification/Inventory", 10);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @Test1.3 - Verify the verification page URL.
	 * 
	 * @description This method retrieves and returns the current page URL to verify if 
	 *              the user has navigated to the verification page.
	 * @return The current URL as a String.
	 * @author YAKSHA
	 * @throws Exception If an error occurs while retrieving the URL.
	 */
	public String verifyVerificationPageUrl() throws Exception {
		try {
			String titleToVerify = commonEvents.getCurrentUrl();
			return titleToVerify;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @Test2 - Highlight and verify whether an element is displayed.
	 * 
	 * @param element The locator (By) of the element to be highlighted and verified.
	 * @description This method checks if the specified element is displayed on the page. 
	 *              If the element is visible, it highlights it and returns true.
	 * @return true if the element is displayed, otherwise false.
	 * @author YAKSHA
	 */
	public boolean verifyVerificationSubModules(By element) {
		boolean isElementDisplayed = false;
		try {
			if (commonEvents.isDisplayed(element)) {
				WebElement elementToHighlight = commonEvents.findElement(element);
				commonEvents.highlight(elementToHighlight);
				isElementDisplayed = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isElementDisplayed;
	}

	/**
	 * @Test3 about this method highlightAndClickOnElement
	 * 
	 * @param element     : By - Locator of the element to be highlighted and
	 *                    clicked
	 * @param elementName : String - Name of the element to be clicked (used for
	 *                    logging purposes)
	 * @description : This method highlights the element and clicks on it. It
	 *              returns true if the element is clicked successfully.
	 * @return : boolean - true if the element is clicked successfully, otherwise
	 *         false
	 * @author : YAKSHA
	 */
	
	public boolean verifyInventoryTabsAndButtonsAreDisplayed(By element) {
		boolean isElementDisplayed = false;
		try {
			if (commonEvents.isDisplayed(element)) {
				WebElement elementToFind = commonEvents.findElement(element);
				commonEvents.highlight(elementToFind);
				commonEvents.click(elementToFind);
				System.out.println("Clicked on " + elementToFind);
				isElementDisplayed = true;
			}}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return isElementDisplayed;
	}

	/**
	 * @Test4 about this method verifySelectedTabIsActiveOrNot()
	 * @param : element - the locator of the tab to be verified
	 * @description : This method verifies if the specified tab is displayed, clicks
	 *              it, and returns whether its "class" attribute contains "active".
	 *              This can be used to determine if the tab is active based on its
	 *              class attributes.
	 * @return : boolean - true if the "class" attribute of the tab contains
	 *         "active", false otherwise
	 * @throws : Exception - if there is an issue locating, highlighting, clicking
	 *           the tab, or getting its attribute
	 * @author : YAKSHA
	 */
	public boolean verifyPharmacyTabIsActiveOrNot(By element) throws Exception {
		boolean isActive = false;
		try {
			if (commonEvents.isDisplayed(element)) {
				WebElement tabs = commonEvents.findElement(element);
				commonEvents.highlight(tabs);
				commonEvents.click(tabs);
				String locatorAttributeValue = commonEvents.getAttribute(tabs, "class");
				isActive = locatorAttributeValue.contains("active");
			}
		} catch (Exception e) {
			throw e;
		}
		return isActive;
	}

	/**
	 * @Test5 about this method verifyNavigationOfTabs()
	 * @param : element - the locator of the tab to be verified
	 * @description : This method verifies if the specified tab is displayed, clicks
	 *              it, and returns whether its "class" attribute contains "active".
	 *              This can be used to determine if the tab is active based on its
	 *              class attributes. It also navigates through "Inventory" and
	 *              "Requisition" tabs before verifying the "Purchase Request" tab.
	 * @return : boolean - true if the "class" attribute of the tab contains
	 *         "active", false otherwise
	 * @throws : Exception - if there is an issue locating, highlighting, clicking
	 *           the tab, or getting its attribute
	 * @author : YAKSHA
	 */
	
	//Helper code for TC-5 and 8
	public boolean highlightAndClickOnElement(By element, String elementName) {
		boolean isElementDisplayed = false;
		try {
			WebElement elementToBeClicked = commonEvents.findElement(element);
			commonEvents.highlight(elementToBeClicked);
			commonEvents.click(elementToBeClicked);
			System.out.println("Clicked on " + elementName);
			isElementDisplayed = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isElementDisplayed;
	}
	
	
	public boolean verifyNavigationOfTabs() throws Exception {
		boolean isActive = false;
		try {
			if (commonEvents.isDisplayed(getPageBarFixedLocator("Inventory"))) {

				highlightAndClickOnElement(getPageBarFixedLocator("Inventory"), "inventory tab");
				highlightAndClickOnElement(getSubNavTabLocator("Requisition"), "inventory tab");

				WebElement purchaseReqTab = commonEvents.findElement(getSubNavTabLocator("Purchase Request"));
				commonEvents.highlight(purchaseReqTab);
				commonEvents.click(purchaseReqTab);

				String locatorAttributeValue = commonEvents.getAttribute(purchaseReqTab, "class");
				System.out.println("locatorAttributeValue > " + locatorAttributeValue);
				isActive = locatorAttributeValue.contains("active");

				highlightAndClickOnElement(getSubNavTabLocator("Requisition"), "inventory tab");
			}
		} catch (Exception e) {
			throw e;
		}
		return isActive;
	}

	/**
	 * @Test6, 9.2 about this method
	 *        verifyTheResultsDateRangeIsWithinTheSelectedRange()
	 * 
	 * @param : String, String - from date - to date
	 * @description : This method verifies whether the "Requested On" dates for all
	 *              the result requisitions are within the specified date range.
	 * @return : boolean - true if the actual dates fall within the specified date
	 *         and false if they don't.
	 * @throws : Exception - if there is an issue finding the actual data
	 * @author : YAKSHA
	 */
	public boolean verifyTheResultsDateRangeIsWithinTheSelectedRange(String fromDate, String toDate) throws Exception {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			List<WebElement> actualDatesAfterFilterApplied = commonEvents.getWebElements(getActualRequestedOnDates());
			LocalDate from = LocalDate.parse(fromDate, formatter);
			LocalDate to = LocalDate.parse(toDate, formatter);

			for (WebElement dateElement : actualDatesAfterFilterApplied) {
				commonEvents.highlight(dateElement);
				String dateText = dateElement.getText();

				LocalDate date;
				LocalDate newDate;
				try {
					date = LocalDate.parse(dateText, inputFormatter);
					newDate = LocalDate.parse(date.format(formatter), formatter);

				} catch (Exception e) {
					System.out.println("Date parsing failed for: " + dateText);
					return false;
				}

				if (newDate.isBefore(from) || newDate.isAfter(to)) {
					return false;
				}
			}
			return true;

		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @Test7 - Verify the text of a tooltip.
	 * 
	 * @description This method retrieves and returns the text of a tooltip associated 
	 *              with the favorite (star) icon after highlighting it.
	 * @return The tooltip text as a String.
	 * @throws Exception If an error occurs while finding or retrieving the tooltip text.
	 * @author YAKSHA
	 */
	public String verifyToolTipText() {
		String toolTipValue = "";
		try {
			WebElement toolTip = commonEvents.findElement(favouriteOrStarIcon());
			toolTipValue = commonEvents.highlight(toolTip).getAttribute(toolTip, "title");
			System.out.println("Tool tip title : " + toolTipValue);
		} catch (Exception e) {
			throw e;
		}
		return toolTipValue;
	}

	/**
	 * @Test8 about this method verifyDatesAreRememberedCorrectly()
	 * 
	 * @param fromDate - the expected "from" date in the format "dd-MM-yyyy"
	 * @param toDate   - the expected "to" date in the format "dd-MM-yyyy"
	 * @description : This method selects the "from" and "to" dates in the calendar,
	 *              clicks the OK button, navigates away to another tab, returns to
	 *              the original tab, and verifies if the dates are remembered
	 *              correctly.
	 * @return : boolean - true if the dates are remembered correctly, false
	 *         otherwise
	 * @throws : Exception - if there is an issue locating, highlighting, or
	 *           clicking elements, or if there is an issue with date selection or
	 *           verification
	 * @author : YAKSHA
	 * @throws Exception
	 */
	public boolean verifyDatesAreRememberedCorrectly(String fromDate, String toDate) throws Exception {
		try {
			// Split the fromDate and toDate into day, month, and year components
			String[] fromDateComponents = fromDate.split("-");
			String fromDay = fromDateComponents[0];
			String fromMonth = fromDateComponents[1];
			String fromYear = fromDateComponents[2];

			String[] toDateComponents = toDate.split("-");
			String toDay = toDateComponents[0];
			String toMonth = toDateComponents[1];
			String toYear = toDateComponents[2];

			// Locate the date dropdowns and OK button
			WebElement fromDateDropdown = commonEvents.findElement(calendarFromDropdown());
			WebElement toDateDropdown = commonEvents.findElement(calendarToDropdown());
			WebElement okButton = commonEvents.findElement(getOkButtonLocator());

			// Highlight and set the "from" date
			commonEvents.highlight(fromDateDropdown).sendKeys(fromDateDropdown, fromDay)
					.sendKeys(fromDateDropdown, fromMonth).sendKeys(fromDateDropdown, fromYear);

			// Highlight and set the "to" date
			commonEvents.highlight(toDateDropdown).sendKeys(toDateDropdown, toDay).sendKeys(toDateDropdown, toMonth)
					.sendKeys(toDateDropdown, toYear);

			// Locate and click the tooltip
			WebElement toolTip = commonEvents.findElement(getStarIconLocator());
			commonEvents.click(toolTip);

			// Highlight and click the OK button
			commonEvents.highlight(okButton).click(okButton);

			// Navigate to Pharmacy tab and back to Inventory tab
			highlightAndClickOnElement(getPageBarFixedLocator("Pharmacy"), "Pharmacy");
			highlightAndClickOnElement(getPageBarFixedLocator("Inventory"), "Inventory");
			highlightAndClickOnElement(getSubNavTabLocator("Requisition"), "Requisition");

			// Wait for the OK button to be visible
			commonEvents.waitTillElementVisible(getOkButtonLocator(), 10000);

			// Construct the actual dates from the selected components
			String actualFromDate = fromDay + "-" + fromMonth + "-" + fromYear;
			String actualToDate = toDay + "-" + toMonth + "-" + toYear;

			System.out.println("Actual from date : " + actualFromDate);
			System.out.println("Actual to date : " + actualToDate);

			// Verify if the remembered dates match the expected dates
			if (actualFromDate.equals(fromDate) && actualToDate.equals(toDate)) {
				System.out.println("Returned true");

				return true;
			}

		} catch (Exception e) {
			throw e;
		}
		return false;
	}
	
	/**
	 * @Test9.1 about this method clickDateRangeDropdownAndSelect()
	 * 
	 * @param : String - Text of the value to select from dropdown
	 * @description : This method clicks on the date range button and selects a
	 *              value by its text
	 * @return : boolean - true if successfully selected the intended value and
	 *         false if the value is not selected
	 * @throws : Exception - if there is an issue finding the dropdown or its values
	 * @author : YAKSHA
	 */
	public boolean clickDateRangeDropdownAndSelect(String valueToSelect) throws Exception {
		try {
			WebElement dateRangeButton = commonEvents.findElement(getDateRangeButton());
			commonEvents.highlight(dateRangeButton).click(dateRangeButton);
			WebElement valueToSelectElement = commonEvents.findElement(getAnchorTagLocatorByText(valueToSelect));
			commonEvents.highlight(valueToSelectElement).click(valueToSelectElement);
			commonEvents.highlight(dateRangeButton).click(dateRangeButton);
			commonEvents.highlight(valueToSelectElement).click(valueToSelectElement);
			boolean isValueSelected = commonEvents.getAttribute(valueToSelectElement, "class")
					.contains("selected-range");
			WebElement okButton = commonEvents.findElement(getOkButtonLocator());
			commonEvents.highlight(okButton).click(okButton);
			return isValueSelected;

		} catch (Exception e) {
			throw e;
		}
	}


}
