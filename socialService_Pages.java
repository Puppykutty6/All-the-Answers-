package pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class socialService_Pages extends StartupPage {

//	Locators for TC-1
	By usernameTextbox = By.xpath("//input[@id='username_id']");
	By passwordTextbox = By.xpath("//input[@id='password']");
	By signInButton = By.xpath("//button[@id='login']");
	By registeredPatientTextElement = By.xpath("//p[contains(text(), 'Registered Patient')]");	
//	Locators for TC-2
	By socialServiceModule = By.xpath("//span[.='SocialService']");	
//	Locators for TC-3
	By registerNewSSUPatientButton = By.xpath("//a[.=' Register New SSU Patient']");	
	By newSSUPatientRegistrationFormNameElement = By.xpath("//strong[contains(text(), 'New SSU Patient Registration')]");
//	Locators for TC-4
	By registrationButtonOfNewSSUPatientRegistrationForms = By.xpath("//button[contains(text(), 'Register')]");
	By errorMeesageInLastNameTextFieldElement = By.xpath("//span[contains(text(), 'Last Name is required')]");
//	Locators for TC-5
	By firstNameTextField = By.id("regPatFirstName");
	By middelNameTextField = By.id("MiddleName");
	By lastNameTextField = By.id("LastName");
//	Locators for TC-6
	By registerButtonOfNewSSUPatientRegistrationForms = By.xpath(" //button[contains(text(), 'Register')]");
	By closeButtonOfNewSsuPatientRegistrationByElement = By.xpath("//button[.=' Close ']");
//	Locators for TC-7
	By warningMessage = By.xpath("(//span[.='Membership Scheme(s) is Mandatory. '])[2]");
//	Locators for TC-8
	By hasTG_certificateDropdown = By.id("hasTG_certificate");
	By targetGroupCertificateTypeTextbox = By.xpath("//input[@id='TG_CertificateType']");
	By certificateNoTextbox = By.xpath("//input[@id='TG_CertificateNo']");
//	Locators for TC-9
	By addressTextField = By.id("address");

	String pageName = this.getClass().getSimpleName();
	public socialService_Pages(WebDriver driver) {
		super(driver);
	}
    /**@Test1.1
     * Logs in to the Health App using valid credentials provided in a map.
     *
     * @param expectedData A map containing the username and password with keys "username" and "password".
     * @return true if the login is successful and the registered patient text is displayed; false otherwise.
     * @throws Exception if any error occurs during the login process.
     *
     * This method performs the following steps:
     * 1. Finds and highlights the username textbox, then enters the username.
     * 2. Finds and highlights the password textbox, then enters the password.
     * 3. Finds and highlights the sign-in button, then clicks it.
     * 4. Verifies if the registered patient text is displayed as a confirmation of successful login.
     *
     * @Author: YAKSHA
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
	
	/**@Test1.2
     * @description : this method Retrieves and returns the title of the current page.
     * @param : null
     * @return The title of the currently loaded page as a String.
     * @throws Exception if any error occurs while fetching the title.
     *
     * This method performs the following:
     * - Navigates to the current URL (assumed to be already loaded).
     * - Retrieves the title of the page.
     * - Logs the title to the console.
     *
     * @Author: YAKSHA
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

	/**@Test1.3
     * Retrieves and returns the current URL of the loaded page.
     *
     * @param : null
     * @return : String - the current page URL.
     * @throws Exception if any error occurs while fetching the URL.
     *
     * @description :
     * This method performs the following steps:
     * 1. Fetches the current URL of the browser.
     * 2. Prints the URL to the console.
     * 3. Returns the URL as a string.
     *
     * @author : YAKSHA
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
     * Verifies the presence of the Social Service module and navigates to the Social Service tab.
     *
     * @param : null
     * @return : Boolean - true if the Social Service module is present and clickable; false otherwise.
     * @throws Exception if any error occurs during the process.
     *
     * @description :
     * This method performs the following steps:
     * 1. Checks if the Social Service module is displayed.
     * 2. If displayed, clicks on the module to navigate to the Social Service tab.
     * 3. Waits for a short duration to ensure the tab is loaded.
     * 4. Returns true if navigation is successful.
     *
     * @author : YAKSHA
     */
	public Boolean verifySocialServiceModuleisPresentAndGoToSocialServiceTab() throws Exception {
		boolean isDisplayed = false;
		try {
			if(commonEvents.isDisplayed(socialServiceModule)){
				commonEvents.click(socialServiceModule);
				Thread.sleep(2000);
				isDisplayed=true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return isDisplayed;
	}

    /**@Test3
     * Verifies the presence of the "Register New SSU Patient" button and validates the form name after clicking it.
     *
     * @param : null
     * @return : String - the name of the form displayed after clicking the "Register New SSU Patient" button.
     * @throws Exception if any error occurs during the process.
     *
     * @description :
     * This method performs the following steps:
     * 1. Checks if the "Register New SSU Patient" button is displayed inside the Social Service tab.
     * 2. Clicks on the button.
     * 3. Waits briefly to ensure the form loads.
     * 4. Retrieves and returns the form name displayed after clicking the button.
     *
     * @author : YAKSHA
     */
	public String verifyRegisterNewSSUPatientButtonisPresentAndValidateFormName() throws Exception {
		String newSSUPatientRegistrationFormName = "";
		try {
			commonEvents.isDisplayed(registerNewSSUPatientButton);
			commonEvents.click(registerNewSSUPatientButton);
			Thread.sleep(2000);
			newSSUPatientRegistrationFormName = commonEvents.getText(newSSUPatientRegistrationFormNameElement);
			System.out.println("form Name after click on " + " " + "registerNewSSUPatient" + " " +  "Button : " + newSSUPatientRegistrationFormName);
			//				return newSSUPatientRegistrationFormName;
		}catch(Exception e) {
			throw e;
		}
		return newSSUPatientRegistrationFormName;
	}
	
    /**@Test4
     * Validates the error message displayed in the Last Name text field when left empty and "Register" button is clicked.
     *
     * @param : null
     * @return : String - the error message text shown for the Last Name field.
     * @throws Exception if any error occurs during the validation process.
     *
     * @description :
     * This method performs the following steps:
     * 1. Checks if the "Register" button is displayed on the New SSU Patient Registration form.
     * 2. Clicks the "Register" button without entering any data in the form.
     * 3. Retrieves and returns the error message displayed for the Last Name field.
     *
     * @author : YAKSHA
     */
	public String validateErrorMessageInLastNameTextfield() throws Exception {
		String errorMessageText = "";
		try {
			if(commonEvents.isDisplayed(registrationButtonOfNewSSUPatientRegistrationForms)) {
				commonEvents.click(registrationButtonOfNewSSUPatientRegistrationForms);
				Thread.sleep(3000);
				errorMessageText = commonEvents.getText(errorMeesageInLastNameTextFieldElement);
				System.out.println("Error Meesage of Last Name Text Field is : " + errorMessageText );
				return errorMessageText;	
			}
		}catch(Exception e) {
			throw e;
		}	
		return errorMessageText;
	}
	
    /**@Test5
     * Fills all the text fields in the New SSU Patient Registration popup and verifies the value entered in the First Name field.
     *
     * @param : Map<String, String> - a map containing keys: "firstName", "middleName", and "lastName" with their corresponding values to input.
     * @return : String - the actual value retrieved from the First Name text field after input.
     * @throws Exception if any error occurs during data entry or verification.
     *
     * @description :
     * This method performs the following steps:
     * 1. Verifies that the First Name, Middle Name, and Last Name fields are displayed.
     * 2. Enters the provided data into each respective text field.
     * 3. Retrieves the value from the First Name text field.
     * 4. Returns the retrieved value to confirm the data entry.
     *
     * @author : YAKSHA
     */
	public String fillDataInTextfieldsAndVerifyEnteredData(Map<String, String> expectedData) throws Exception {
		String firstNameTextfieldValue = "";
		try {
			if(commonEvents.isDisplayed(firstNameTextField) && 
					commonEvents.isDisplayed(middelNameTextField) &&
					commonEvents.isDisplayed(lastNameTextField))
			{
				commonEvents.sendKeys(firstNameTextField,expectedData.get("firstName"));	
				commonEvents.sendKeys(middelNameTextField,expectedData.get("middleName"));
				commonEvents.sendKeys(lastNameTextField,expectedData.get("lastName"));

				firstNameTextfieldValue = commonEvents.getAttribute(firstNameTextField, "value");
				System.out.println("value inside the FirstName textbox is : " + firstNameTextfieldValue);
			}
		}catch(Exception e) {
			throw e;
		}
		return firstNameTextfieldValue;
	}


	 /**@Test6
     * Scrolls to the bottom of the page and verifies if the "Close" button is present.
     *
     * @param : null
     * @return : Boolean - true if the "Close" button and the "Register" button are both displayed; false otherwise.
     * @throws Exception if any error occurs during scrolling or element verification.
     *
     * @description :
     * This method performs the following steps:
     * 1. Waits briefly to ensure the page is ready.
     * 2. Scrolls the page until the "Register" button is visible.
     * 3. Checks if both the "Close" and "Register" buttons are displayed at the bottom of the page.
     * 4. Highlights both elements for visibility.
     * 5. Returns true if both elements are found and visible.
     *
     * @author : YAKSHA
     */
	public Boolean scrollToButtomOfThePageAndVerifyCloseButtonIsPresent() throws Exception {
		boolean closeButtoIsDisplayed = false;
		try {
			Thread.sleep(5000);
			//			commonEvents.jsScrollTillPageFooter();
			commonEvents.jsScrollPageTillElementVisible(registerButtonOfNewSSUPatientRegistrationForms, "pageName", "pageName");
			if(commonEvents.isDisplayed(closeButtonOfNewSsuPatientRegistrationByElement) && 
					commonEvents.isDisplayed(registerButtonOfNewSSUPatientRegistrationForms)) {

				WebElement closeButtonOfNewSsuPatientRegistrationWebElement = commonEvents.findElement(closeButtonOfNewSsuPatientRegistrationByElement);
				commonEvents.highlightElementAfterAction(closeButtonOfNewSsuPatientRegistrationWebElement);

				WebElement registerButtonOfNewSSUPatientRegistrationFormsWebElement = commonEvents.findElement(registerButtonOfNewSSUPatientRegistrationForms);
				commonEvents.highlightElementAfterAction(registerButtonOfNewSSUPatientRegistrationFormsWebElement);

				closeButtoIsDisplayed = true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return closeButtoIsDisplayed;
	}

	
	/**@Test7
	 * Validates the warning message displayed for the membership dropdown in the New SSU Patient Registration form.
	 *
	 * @param : Map<String, String> - expectedData containing expected warning message details.
	 * @return : String - the actual warning message text retrieved from the form.
	 * @throws Exception if any error occurs during validation.
	 *
	 * @description :
	 * This method performs the following steps:
	 * 1. Checks if the warning message element is displayed on the page.
	 * 2. Retrieves and stores the text of the warning message.
	 * 3. Prints the warning message text to the console for verification.
	 * 4. Returns the retrieved warning message text.
	 *
	 * @author : YAKSHA
	 */

	public String validateWarnningMessageOfNewSSUPatientRegistrationForms(Map<String, String> expectedData) throws Exception {
		String warningMessageValue = "";
		try {
			if(commonEvents.isDisplayed(warningMessage)) {
				warningMessageValue = commonEvents.getText(warningMessage);
				System.out.println("Warnning Message is : " + warningMessageValue);
			}
		}catch(Exception e) {
			throw e;
		}
		return warningMessageValue;
	}
	
	/**@Test8
	 * Verifies that the textbox appears upon selecting "Yes" from the "Has Target Group Certificate" dropdown.
	 *
	 * @param : Map<String, String> - expectedData containing values to be selected and entered.
	 * @return : String - the value selected from the "Has Target Group Certificate" dropdown.
	 * @throws Exception if any error occurs during dropdown selection or textbox verification.
	 *
	 * @description :
	 * This method performs the following steps:
	 * 1. Checks if the "Has Target Group Certificate" dropdown is displayed.
	 * 2. Selects "Yes" from the dropdown based on the provided JSON data.
	 * 3. Retrieves and logs the first selected option from the dropdown.
	 * 4. Inputs the provided "Target Group Certificate Type" and "Certificate No" into their respective textboxes.
	 * 5. Returns the selected dropdown value.
	 *
	 * @author : YAKSHA
	 */
	public String verifyTextboxIsPresentBySelectingYesFromHasTargetGroupCertificateDropdown(Map<String, String> expectedData) throws Exception {

		String HasTargetGroupCertificateDropdownValue = "" ;

		//		commonEvents.click(countryDropdownMenuElement);

		try {
			if(commonEvents.isDisplayed(hasTG_certificateDropdown)) {
				commonEvents.selectByVisibleText(hasTG_certificateDropdown, expectedData.get("HasTargetGroupCertificate?Yes"));

				HasTargetGroupCertificateDropdownValue = commonEvents.getFirstSelectedOptionFromDropdown(hasTG_certificateDropdown, "elementName", "pageName");
				System.out.println("first selected option from Has Target Group Certificate dropdown : " + HasTargetGroupCertificateDropdownValue );

				commonEvents.sendKeys(targetGroupCertificateTypeTextbox,expectedData.get("targetGroupCertificateType"));	
				commonEvents.sendKeys(certificateNoTextbox,expectedData.get("certificateNo"));
			}
		}catch(Exception e) {
			throw e;
		}
		return HasTargetGroupCertificateDropdownValue;
	}
	
	/**@Test9
	 * Retrieves and verifies the placeholder text of the address text field.
	 *
	 * @param : Map<String, String> - expectedData containing the expected placeholder text.
	 * @return : String - the actual placeholder text retrieved from the address text field.
	 * @throws Exception if any error occurs during placeholder retrieval or verification.
	 *
	 * @description :
	 * This method performs the following steps:
	 * 1. Checks if the address text field is displayed on the page.
	 * 2. Waits briefly to ensure the page elements are fully loaded.
	 * 3. Clicks the address text field to activate it.
	 * 4. Retrieves and logs the placeholder text from the address text field.
	 * 5. Returns the retrieved placeholder text for verification.
	 *
	 * @author : Yaksha
	 */
	public String getPlaceHolderNameVerifyPlaceHolderNameOfAddress(Map<String, String> expectedData) throws Exception {
		String placeHolderValue = "";
		try {
			if(commonEvents.isDisplayed(addressTextField)) {
				Thread.sleep(3000);
				commonEvents.click(addressTextField);
				placeHolderValue = commonEvents.getAttribute(addressTextField,"placeholder");
				System.out.println("Place holder value of Address field : " + placeHolderValue);
			}
		}catch(Exception e) {
			throw e;
		}
		return placeHolderValue;
	}
}