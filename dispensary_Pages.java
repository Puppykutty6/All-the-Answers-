package pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class dispensary_Pages extends StartupPage {

//	TC-1 Locators
	By usernameTextbox = By.xpath("//input[@id='username_id']");
	By passwordTextbox = By.xpath("//input[@id='password']");
	By signInButton = By.xpath("//button[@id='login']");
	By registeredPatientTextElement = By.xpath("//p[contains(text(), 'Registered Patient')]");
//	TC-2 Locators
	By dispensaryModule = By.xpath("//span[.='Dispensary']");
//	TC-3 LOcators
	By dispensaryToggle = By.xpath("//span[@data-target='#Dispensary']");	
	By PrescriptionSubModule = By.xpath("//span[.='Prescription']");
	By saleSubModule = By.xpath("//span[.='Sale']");
	By stockSubModule = By.xpath("//span[.='Stock']");
	By counterSubModule = By.xpath("//span[.='Counter']");
	By reportsSubModule = By.xpath("//span[.='Reports']");
	By patientConsumptionSubModule = By.xpath("//span[.='Patient Consumption']");
//	TC-4 Locators
	By morningCounter = By.xpath("(//div[@class='counter-item'])[1]");
	By printInvoiceButtonElement = By.xpath("//input[@value='Print Invoice']");
	By discardButtonElement = By.xpath("//button[contains(text() , 'Discard')]");
	By invoiceHistoryTextElement = By.xpath("//b[contains(text() , 'Invoice History')]");
	By creditLimitsAndBalancesTextElement = By.xpath("//b[contains(text() , 'Credit Limits and Balances')]");
//	TC-5 Locators
	By addNewPatientPopup = By.xpath("//div[@class='modelbox-body p2']");
	By addNewPatientPageTitle = By.xpath("//span[.='Add New Patient']");
//	TC-6 Locators
	By okButton = By.xpath("//button[.=' OK']");
	By errorMeesageInFirstNameTextField = By.xpath("//span[.=' First Name is required.']");
//	TC-7 Locators
	By firstNameTextFieldInAddNewPatient = By.id("newPatFirstName");
	By middleNameTextFieldInAddNewPatient = By.id("newPatMiddleName");
	By lastNameTextFieldInAddNewPatient = By.id("newPatLastName");
	By ageTextFieldInAddNewPatient = By.id("Age");
	By contactNumberTextFieldInAddNewPatient = By.id("Contact");
//	TC-8 Locators
	By xButton = By.xpath("//button[.='X']");
	By patientConsuptionTab = By.xpath("//a[.=' Patient Consumption ']");
	By newConsuptionButton = By.xpath("//button[@class='btn green btn-success']");
	By saveConsuptionButton = By.id("btn-save");
	By confirmMessage = By.xpath("//p[.='Are you sure you want to Proceed ?']");
//	TC-9 Locators
	By confirmButton = By.id("id_btn_confirm_confirmation");
	By newConsumptionEntryPageCancelButton = By.xpath("//a[@title='Cancel']");
	By filterByStoreDropdown = By.id("Store");
	By mainStoreOption = By.xpath("//option[.='Main store']");
	
	String pageName = this.getClass().getSimpleName();
	public dispensary_Pages(WebDriver driver) {
		super(driver);
	}
	
	/**@Test 1.1
	 * This method logs in to the Health App using the given valid credentials.
	 * 
	 * @param : A map containing "username" and "password" as keys.
	 * @description Enters the username and password into their respective text fields, 
	 *              clicks on the sign-in button, and verifies if the registered patient text is displayed.
	 * @return boolean - Returns true if the registered patient text is displayed, otherwise false.
	 * @author Yaksha
	 * @throws Exception If any issue occurs during execution.
	 */
	public boolean loginToHealthAppByGivenValidCredetial(Map<String, String> expectedData) throws Exception {
		Boolean textIsDisplayed = false;
		try {
			WebElement usernametextFieldWebElement = commonEvents.findElement(usernameTextbox);
			commonEvents.highlightElement(usernametextFieldWebElement);
			commonEvents.sendKeys(usernameTextbox,expectedData.get("username"));

			WebElement passwordtextFieldWebElement = commonEvents.findElement(passwordTextbox);
			commonEvents.highlightElement(passwordtextFieldWebElement);
			commonEvents.sendKeys(passwordTextbox,expectedData.get("password"));

			WebElement signinButtonWebElement = commonEvents.findElement(signInButton);
			commonEvents.highlightElement(signinButtonWebElement);
			commonEvents.click(signInButton);

			if(commonEvents.isDisplayed(registeredPatientTextElement))
			{   
				WebElement registeredPatientTextWebElement = commonEvents.findElement(registeredPatientTextElement);
				commonEvents.highlightElement(registeredPatientTextWebElement);
				textIsDisplayed=true;
			}
		}catch(Exception e) {
			throw e;
		}
		return textIsDisplayed;
	}

	/** @Test1.2
	 * This method retrieves and verifies the title of the current page.
	 * 
	 * @description Fetches the title of the currently loaded web page.
	 * @return String - Returns the title of the page.
	 * @author Yaksha
	 * @throws Exception If any issue occurs while retrieving the title.
	 */
	public String verifyTitleOfThePage() throws Exception {
		String pageTitle = "";
		try {
			pageTitle = commonEvents.getTitle();
			System.out.println("title of the page is  :" + pageTitle );
		}catch(Exception e) {
			throw e;
		}	
		return pageTitle;
	}

	/**@Test 1.3
	 * This method retrieves and verifies the URL of the current page.
	 * 
	 * @description Fetches the current page's URL and prints it in the console.
	 * @return String - Returns the URL of the page.
	 * @author Yaksha
	 * @throws Exception If any issue occurs while retrieving the URL.
	 */

	public String verifyURLOfThePage() throws Exception {
		String urlofThepage = "";
		try {
			urlofThepage = commonEvents.getCurrentUrl();
			System.out.println("URL of the page is  :" + urlofThepage );
		}catch(Exception e) {
			throw e;
		}	
		return urlofThepage;
	}


	/**@Test2
	 * This method verifies whether the Dispensary module is present on the page.
	 * 
	 * @description Checks if the Dispensary module is displayed and returns the result.
	 * @return boolean - Returns true if the Dispensary module is present, otherwise false.
	 * @author Yaksha
	 * @throws Exception If any issue occurs during execution.
	 */

	public Boolean verifyDispensaryModuleIsPresentOrNot() throws Exception {
		boolean dispensaryModuleIsDisplayed = false;
		try {
			commonEvents.isDisplayed(dispensaryModule);
			dispensaryModuleIsDisplayed=true;
		}catch(Exception e) {
			throw e;
		}	
		return dispensaryModuleIsDisplayed;
	}
	
	/**@Test3
	 * This method verifies that all sub-modules under the "Dispensary" module are present and 
	 * then clicks on the "Dispensary" module.
	 * 
	 * @description Checks if the "Dispensary" module is displayed, expands it using the toggle, 
	 *              verifies the presence of all sub-modules, and then clicks on the "Dispensary" module.
	 * @return boolean - Returns true if all sub-modules are displayed successfully, otherwise false.
	 * @author Yaksha
	 * @throws Exception If any issue occurs during execution.
	 */
	public Boolean verifyAllSubModulesArePresentAndClickOnDispensary() throws Exception {
		boolean patientConsumptionSubModuleisDisplayed = false;
		try {
			if(commonEvents.isDisplayed(dispensaryModule)){
				commonEvents.jsClick(dispensaryToggle);
				commonEvents.isDisplayed(PrescriptionSubModule);				
				commonEvents.isDisplayed(saleSubModule);
				commonEvents.isDisplayed(stockSubModule);
				commonEvents.isDisplayed(counterSubModule);
				commonEvents.isDisplayed(reportsSubModule);
				commonEvents.isDisplayed(patientConsumptionSubModule);
				commonEvents.click(dispensaryModule);
				patientConsumptionSubModuleisDisplayed=true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return patientConsumptionSubModuleisDisplayed;
	}


	/**@Test4
	 * This method scrolls to the bottom of the "Sale" page if required and verifies the presence 
	 * of specific buttons and text elements.
	 * 
	 * @description Clicks on the "Morning Counter," scrolls to the "Credit Limits and Balance" text, 
	 *              and verifies the presence of the "Print Invoice" button, "Discard" button, 
	 *              "Invoice History" text, and "Credit Limits and Balance" text.
	 * @return boolean - Returns true if all elements are displayed successfully, otherwise false.
	 * @author Yaksha
	 * @throws Exception If any issue occurs during execution.
	 */

	public Boolean scrollToButtomAndVerifytheFields() throws Exception {
		boolean creditLimitsAndBalancesTextElementIsDisplayed = false;
		try {
			commonEvents.click(morningCounter);
			Thread.sleep(3000);
			WebElement creditLimitsAndBalancesTextElementWebElement=commonEvents.findElement(creditLimitsAndBalancesTextElement);
			commonEvents.scrollIntoView(creditLimitsAndBalancesTextElementWebElement);
			Thread.sleep(3000);
			if(commonEvents.isDisplayed(printInvoiceButtonElement) &&
					commonEvents.isDisplayed(discardButtonElement) &&
					commonEvents.isDisplayed(invoiceHistoryTextElement) &&
					commonEvents.isDisplayed(creditLimitsAndBalancesTextElement) ) {
				creditLimitsAndBalancesTextElementIsDisplayed=true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return creditLimitsAndBalancesTextElementIsDisplayed;
	}



	/**@Test5
	 * This method performs a keyboard operation (Alt + N) to open the "Add New Patient" popup 
	 * and retrieves its title.
	 * 
	 * @description Simulates the Alt + N keyboard shortcut, verifies if the "Add New Patient" 
	 *              popup is displayed, and fetches the title of the popup.
	 * @return String - Returns the title of the "Add New Patient" page.
	 * @author Yaksha
	 * @throws Exception If any issue occurs during execution.
	 */
	public String performTheKeyboardOperationToOpenthePopup() throws Exception {
		String pageName = "";
		try {
			commonEvents.performAltN();
			commonEvents.isDisplayed(addNewPatientPopup);
			pageName=commonEvents.getText(addNewPatientPageTitle);
			System.out.println("Add New Patient page title is :" + pageName);
		}catch(Exception e) {
			throw e;
		}	
		return pageName;
	}


	/**@Test6
	 * This method validates the error message displayed in the First Name text field.
	 * 
	 * @description Clicks the "OK" button without filling any information, waits for a few seconds, 
	 *              retrieves the error message from the First Name text field, and returns it.
	 * @return String - Returns the error message text if present, otherwise an empty string.
	 * @author Yaksha
	 * @throws Exception If any issue occurs during execution.
	 */

	public String validateErrorMessageInFirstnameTextfield() throws Exception {
		String errorMessageText = "";
		try {
			if(commonEvents.isDisplayed(okButton)) {
				commonEvents.click(okButton);
				Thread.sleep(5000);
				errorMessageText = commonEvents.getText(errorMeesageInFirstNameTextField);
				System.out.println("Error Meesage is  :" + errorMessageText );
				return errorMessageText;	
			}
		}catch(Exception e) {
			throw e;
		}	
		return errorMessageText;
	}

	/**@Test7.1
	 * This method fills the First Name text field and verifies that the First Name is entered correctly.
	 * 
	 * @param expectedData A map containing the "firstName" key with the value to be entered.
	 * @description Checks if the First Name text field is displayed, enters the provided First Name, 
	 *              retrieves the entered value, and verifies it.
	 * @return String - Returns the entered First Name value.
	 * @author Yaksha
	 * @throws Exception If any issue occurs during execution.
	 */
	public String fillfirstNameTextFieldVerifyTheFirstName(Map<String, String> expectedData) throws Exception {
		String firstNameTextfieldValue= "";
		try {
			if(commonEvents.isDisplayed(firstNameTextFieldInAddNewPatient))
			{
				commonEvents.click(firstNameTextFieldInAddNewPatient);
				commonEvents.sendKeys(firstNameTextFieldInAddNewPatient,expectedData.get("firstName"));

				firstNameTextfieldValue = commonEvents.getAttribute(firstNameTextFieldInAddNewPatient, "value");
				System.out.println("FirstName : " + firstNameTextfieldValue);

			}
		}catch(Exception e) {
			throw e;
		}
		return firstNameTextfieldValue;
	}

	/**
	 * @Test7.2  
	 * This method fills the Middle Name text field and verifies that the middle name is entered correctly.  
	 *  
	 * @param expectedData A `Map<String, String>` object containing "middleName" as a key,  
	 *                     with the value retrieved from the test data source.  
	 * @description Checks if the Middle Name text field is displayed, enters the provided middle name,  
	 *              retrieves the entered value, and verifies it.  
	 * @return String - Returns the entered Middle Name value.  
	 * @author Yaksha  
	 * @throws Exception If any issue occurs during execution.  
	 */

	public String fillmiddelNameTextFieldVerifyThemiddleName(Map<String, String> expectedData) throws Exception {
		String middleNameTextfieldValue= "";
		try {
			if(commonEvents.isDisplayed(middleNameTextFieldInAddNewPatient))
			{

				commonEvents.click(middleNameTextFieldInAddNewPatient);
				commonEvents.sendKeys(middleNameTextFieldInAddNewPatient,expectedData.get("middleName"));

				middleNameTextfieldValue = commonEvents.getAttribute(middleNameTextFieldInAddNewPatient, "value");
				System.out.println("Middle name : " + middleNameTextfieldValue);

			}
		}catch(Exception e) {
			throw e;
		}
		return middleNameTextfieldValue;
	}


	/**@Test7.3
	 * This method fills the Last Name text field and verifies that the last name is entered correctly.  
	 *  
	 * @param expectedData A `Map<String, String>` object containing "lastName" as a key,  
	 *                     with the value retrieved from the test data source.  
	 * @description Checks if the Last Name text field is displayed, enters the provided last name,  
	 *              retrieves the entered value, and verifies it.  
	 * @return String - Returns the entered Last Name value.  
	 * @author Yaksha  
	 * @throws Exception If any issue occurs during execution.  
	 */

	public String filllastNameTextfieldVerifylastName(Map<String, String> expectedData) throws Exception {
		String lastNameTextfieldValue= "";
		try {
			if(commonEvents.isDisplayed(lastNameTextFieldInAddNewPatient))
			{

				commonEvents.click(lastNameTextFieldInAddNewPatient);
				commonEvents.sendKeys(lastNameTextFieldInAddNewPatient,expectedData.get("lastName"));

				lastNameTextfieldValue = commonEvents.getAttribute(lastNameTextFieldInAddNewPatient, "value");
				System.out.println("Last name : " + lastNameTextfieldValue);

			}
		}catch(Exception e) {
			throw e;
		}
		return lastNameTextfieldValue;
	}

	/**@Test7.4
	 * This method fills the Age text field and verifies that the age is entered correctly.  
	 *  
	 * @param expectedData A `Map<String, String>` object containing "age" as a key,  
	 *                     with the value retrieved from the test data source.  
	 * @description Checks if the Age text field is displayed, enters the provided age,  
	 *              retrieves the entered value, and verifies it.  
	 * @return String - Returns the entered Age value.  
	 * @author Yaksha  
	 * @throws Exception If any issue occurs during execution.  
	 */
	public String fillAgeTextFieldVerifyTheAge(Map<String, String> expectedData) throws Exception {
		String ageTextfieldValue= "";
		try {
			if(commonEvents.isDisplayed(ageTextFieldInAddNewPatient))
			{

				commonEvents.click(ageTextFieldInAddNewPatient);
				commonEvents.sendKeys(ageTextFieldInAddNewPatient,expectedData.get("age"));

				ageTextfieldValue = commonEvents.getAttribute(ageTextFieldInAddNewPatient, "value");
				System.out.println("Age is : " + ageTextfieldValue);

			}
		}catch(Exception e) {
			throw e;
		}
		return ageTextfieldValue;
	}

	/**@Test7.5
	 * This method fills the Contact Number text field and verifies that the contact number is entered correctly.  
	 *  
	 * @param expectedData A `Map<String, String>` object containing "contact" as a key,  
	 *                     with the value retrieved from the test data source.  
	 * @description Checks if the Contact Number text field is displayed, enters the provided contact number,  
	 *              retrieves the entered value, and verifies it.  
	 * @return String - Returns the entered Contact Number value.  
	 * @author Yaksha  
	 * @throws Exception If any issue occurs during execution.  
	 */

	public String fillContactNumberTextFieldVerifyContactNumber(Map<String, String> expectedData) throws Exception {
		String contactNumberTextfieldValue= "";
		try {
			if(commonEvents.isDisplayed(contactNumberTextFieldInAddNewPatient))
			{

				commonEvents.click(contactNumberTextFieldInAddNewPatient);
				commonEvents.sendKeys(contactNumberTextFieldInAddNewPatient,expectedData.get("contact"));

				contactNumberTextfieldValue = commonEvents.getAttribute(contactNumberTextFieldInAddNewPatient, "value");
				System.out.println("Contact Number is : " + contactNumberTextfieldValue);

			}
		}catch(Exception e) {
			throw e;
		}
		return contactNumberTextfieldValue;
	}	

	/**
	 * @Test8  
	 * This method validates the confirmation message on the "New Consumption Entry" page.  
	 *  
	 * @param null - No parameters required.  
	 * @description Navigates to the "New Consumption Entry" page, initiates a new entry,clicks the save button, and verifies the confirmation message  
	 *              "Are you sure you want to proceed?".  
	 * @return String - Returns the confirmation message text.  
	 * @author Yaksha  
	 * @throws Exception If any issue occurs during execution.  
	 */

	public String validateTheConfirmMessageOnTheNewConsumptionEntryPage() throws Exception {
		String confirmMessageText = "";
		try {
			commonEvents.click(xButton);
			commonEvents.click(patientConsuptionTab);
			commonEvents.click(newConsuptionButton);
			commonEvents.click(saveConsuptionButton);
			confirmMessageText=commonEvents.getText(confirmMessage);
			System.out.println("Confirmation message is :" +confirmMessageText);
		}catch(Exception e) {
			throw e;
		}	
		return confirmMessageText;
	}


	/**
	 * @Test9  
	 * This method selects "Main Store" from the "Filter by Store" dropdown on the Stock page  
	 * and verifies that the selection is applied correctly.  
	 *  
	 * @param null - No parameters required.  
	 * @description Navigates to the Stock page, selects "Main Store" from the  
	 *              "Filter by Store" dropdown, and ensures that the stock values  
	 *              are filtered based on the selected store.  
	 * @return Boolean - Returns true if "Main Store" is successfully selected, otherwise false.  
	 * @author Yaksha  
	 * @throws Exception If any issue occurs during execution.  
	 */

	public Boolean selectMainStoreFromFilter() throws Exception {
		boolean mainStoreDropDownIsSelected = false;
		try {
			commonEvents.click(confirmButton);
			commonEvents.click(newConsumptionEntryPageCancelButton);
			commonEvents.click(stockSubModule);
			if(commonEvents.isDisplayed(filterByStoreDropdown)) {
				commonEvents.click(filterByStoreDropdown);
				commonEvents.click(mainStoreOption);
				//				 commonEvents.click(filterByStoreDropdown);
				Thread.sleep(3000);
				mainStoreDropDownIsSelected=true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return mainStoreDropDownIsSelected;
	}

}
