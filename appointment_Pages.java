package pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class appointment_Pages extends StartupPage {

//	TC-1 Locators
	By usernameTextbox = By.xpath("//input[@id='username_id']");
	By passwordTextbox = By.xpath("//input[@id='password']");
	By signInButton = By.xpath("//button[@id='login']");
	By appointmentModuleByElement = By.xpath("//a[@href='#/Appointment']");
//	TC-2 Locators
	By appointmentModuleToggleByElement = By.xpath("//span[@data-target='#Appointment']");
	By selectCounterTitleNameByElement = By.xpath("//span[contains(text(), 'Select Counter')]");
//	TC-3 Locators
	By selectCounterNewOneLinkByElement = By.xpath("//div[@class='counter-item']//h5[contains(text(), 'New-1')]");
	By newPatientButtonLinkByElement = By.xpath("//button[@id='btnNewPatient']");
	By patientInformationTextByElement = By.xpath("//h4[contains(text(), 'Patient Information')]");
//	TC-4 Locators
	By careOfPersonContactTextboxByElement = By.xpath("//input[@id='id_CareTaker_CareTakerContact']");
//	TC-5 Locators
	By careOfPersonTextboxByElement = By.xpath("//input[@id='id_CareTaker_CareTakerName']");
//	TC-6 Locators
	By printInvoiceButtonByElement = By.xpath("//input[@id='btnPrintInvoice']");
	By confirmButtonByElement = By.xpath("//button[@id='id_btn_confirm_confirmation']");
	By errorMessageOfLastNameTextboxByElement = By.xpath("//span[contains(text(), ' Last Name is required.')]");

	By firstNameTextboxByElement = By.xpath("//input[@id='aptPatFirstName']");
	By middleNameTextboxByElement = By.xpath("//input[@formcontrolname='MiddleName']");
	By lastNameTextboxByElement = By.xpath("//input[@formcontrolname='LastName']");
	By ageTextboxByElement = By.xpath("//input[@id='txtAgeInput']");
	By phoneTextboxByElement = By.xpath("//input[@id='txtPhone']");
	
	By havDOBCheckboxByElement = By.xpath("//input[@name='IsDobAvailable']/..//span");
	By dobDatePickerByElement = By.xpath("//input[@id='date']");
	
	By externalCheckBoxByElement = By.xpath("//input[@id='id_checkbox_includeExternalReferral']/..//span");
	By plusIconClickToAddExternalReffererByElement = By.xpath("//a[@title='Click to add new external refferer']");
	By addExternalReferralTitleByElement = By.xpath("//span[contains(text(), 'Add External Referral')]");
	By referrerNameTexboxByElement = By.xpath("//input[@id='referrerName']");
	By extRefferAddressTextFieldElement = By.xpath("//input[@id='ExtRefferaddress']");
	By contactNumberTextFieldElement = By.xpath("//input[@id='contactNum']");
	By emailTextFieldElement = By.xpath("//div[@class='col-md-7']//input[@id='email']");
	By isIncentiveApplicableCheckboxElement = By.xpath("(//div[@class='icheck-inline']//span)[2]");
	By addreferrerButtonByElement = By.xpath("//button[@id='add']");
	By successNotificationPopupMessageElement = By.xpath("//div[@class='msg-text padding-8-all']");
	By successNotificationPopupMessageOneElement = By.xpath("//p[@class='msg-status']");
	By successNotificationPopupMessageTwoElement = By.xpath("//p[@class='main-message']");
	
	
	String pageName = this.getClass().getSimpleName();
	public appointment_Pages(WebDriver driver) {
		super(driver);
	}

	/**@Test1.1
	 * Method: loginToHealthAppByGivenValidCredetial
	 * 
	 * @param expectedData A Map containing login credentials with keys "username" and "password"
	 * @description This method automates the login process by:
	 *              - Waiting for the username textbox and entering the provided username
	 *              - Waiting for the password textbox and entering the provided password
	 *              - Waiting for and clicking the Sign In button using JavaScript
	 *              - Verifying if the appointment module is displayed after login
	 * @return true if the appointment module is visible after login, false otherwise
	 * @throws Exception if any step in the login process fails
	 * @author YAKSHA
	 */
	public boolean loginToHealthAppByGivenValidCredetial(Map<String, String> expectedData) throws Exception {
		Boolean textIsDisplayed = false;
		try {
			//			commonEvents.setBrowserZoomLevelTo80Percent();
			commonEvents.waitTillElementLocated(usernameTextbox, 10);
			WebElement usernametextFieldWebElement = commonEvents.findElement(usernameTextbox);
			commonEvents.highlightElement(usernametextFieldWebElement);
			commonEvents.sendKeys(usernameTextbox,expectedData.get("username"));

			commonEvents.waitTillElementLocated(passwordTextbox, 10);
			WebElement passwordtextFieldWebElement = commonEvents.findElement(passwordTextbox);
			commonEvents.highlightElement(passwordtextFieldWebElement);
			commonEvents.sendKeys(passwordTextbox,expectedData.get("password"));

			commonEvents.waitTillElementLocated(signInButton, 20);
			WebElement signinButtonWebElement = commonEvents.findElement(signInButton);
			commonEvents.highlightElement(signinButtonWebElement);
			commonEvents.jsClick(signInButton);

			if(commonEvents.isDisplayed(appointmentModuleByElement))
			{   
				WebElement operationTheatreModuleWebElement = commonEvents.findElement(appointmentModuleByElement);
				commonEvents.highlightElement(operationTheatreModuleWebElement);
				textIsDisplayed=true;
			}
		}catch(Exception e) {
			throw e;
		}
		return textIsDisplayed;
	}

	/**@Test1.2
	 * 
	 * @param none
	 * @description Retrieves and returns the current page title.
	 * @return The title of the current web page as a String
	 * @throws Exception if unable to retrieve the title
	 * @author YAKSHA
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
	 * 
	 * @param none
	 * @description Waits for a few seconds, retrieves, and returns the current page URL.
	 *              Logs the URL to the console for verification.
	 * @return The current URL of the web page as a String
	 * @throws Exception if unable to retrieve the URL or if any error occurs during execution
	 * @author YAKSHA
	 */
	public String verifyURLOfThePage() throws Exception {
		String urlofThepage = "";
		try {
			Thread.sleep(5000);
			urlofThepage = commonEvents.getCurrentUrl();
			System.out.println("URL of the page is  :" + urlofThepage );
		}catch(Exception e) {
			throw e;
		}	
		return urlofThepage;
	}
	
	/**@Test2
	 * 
	 * @param none
	 * @description Checks if the Appointment module is present and interacts with it.
	 *              If present, it clicks the module and verifies if the counter title popup page is displayed.
	 *              Returns the title of the popup page.
	 * @return The text of the "Select Counter" title.
	 * @throws Exception if any element interaction fails during the process
	 * @author YAKSHA
	 */
	public String verifyAppointmentModuleIsPresent() throws Exception {
		String selectCounterTitleIsDisplayed = "";
		try {
			if(commonEvents.isDisplayed(appointmentModuleByElement)){
				commonEvents.jsClick(appointmentModuleToggleByElement);
			}

			if(commonEvents.isDisplayed(selectCounterTitleNameByElement)) {
				selectCounterTitleIsDisplayed = commonEvents.getText(selectCounterTitleNameByElement);
				System.out.println("select counter title name is : " + selectCounterTitleIsDisplayed);
				return selectCounterTitleIsDisplayed;
			}
		}catch(Exception e) {
			throw e;
		}	
		return selectCounterTitleIsDisplayed;
	}

	/**@Test3
	 * 
	 * @param none
	 * @description Checks if the "Select Counter New One" link is present and clicks it.
	 *              Then waits for the "New Patient" button, clicks it, and retrieves the title
	 *              of the "Patient Information" section.
	 * @return The text from the "Patient Information" section if present, otherwise an empty string
	 * @throws Exception if any element is not found or an interaction fails during execution
	 * @author YAKSHA
	 */
	public String verifyButtonAndTextIsPresent() throws Exception {
		String buttonAndTextIsDisplayed = "";
		try {
			if(commonEvents.isDisplayed(selectCounterNewOneLinkByElement)){
				commonEvents.jsClick(selectCounterNewOneLinkByElement);
			}

			commonEvents.waitTillElementLocated(newPatientButtonLinkByElement, 10);			
			if(commonEvents.isDisplayed(newPatientButtonLinkByElement)) {
				commonEvents.click(newPatientButtonLinkByElement);
				commonEvents.waitTillElementLocated(patientInformationTextByElement, 10);	
				buttonAndTextIsDisplayed = commonEvents.getText(patientInformationTextByElement);
				System.out.println("select counter title name is : " + buttonAndTextIsDisplayed);
				return buttonAndTextIsDisplayed;
			}
		}catch(Exception e) {
			throw e;
		}	
		return buttonAndTextIsDisplayed;
	}

	/**@Test4
	 * 
	 * @param none
	 * @description Scrolls to the bottom of the page after ensuring the "Patient Information" section is visible.
	 *              Then waits for the "Care Of Person Contact" textbox to be located, verifies its visibility,
	 *              clicks it, highlights the element, and confirms its presence.
	 * @return true if the "Care Of Person Contact" textbox is displayed and highlighted successfully, false otherwise
	 * @throws Exception if any interaction with elements fails during execution
	 * author YAKSHA
	 */
	public Boolean scrollToBottomVerifyFieldAndHighlight() throws Exception {
		Boolean textboxIsDisplayed = false;
		try {
			commonEvents.waitTillElementLocated(patientInformationTextByElement, 10);
			commonEvents.jsScrollToBottomOfThePage();

			commonEvents.waitTillElementLocated(careOfPersonContactTextboxByElement, 10);
			if(commonEvents.isDisplayed(careOfPersonContactTextboxByElement)){
				commonEvents.click(careOfPersonContactTextboxByElement);
				WebElement careOfPersonContactTextboxWebElement = commonEvents.findElement(careOfPersonContactTextboxByElement);
				commonEvents.highlight(careOfPersonContactTextboxWebElement);
				textboxIsDisplayed = true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return textboxIsDisplayed;
	}

	/**@Test5
	 * 
	 * @param none
	 * @description Waits for the "Care Of Person" textbox to be located and verifies its visibility.
	 *              Clicks on the textbox and retrieves the value of its "placeholder" attribute.
	 * @return The placeholder text of the "Care Of Person" textbox if available, otherwise an empty string
	 * @throws Exception if the element is not found or any interaction fails during execution
	 * @author YAKSHA
	 */
	public String verifyPlaceholderNameOfTexbox() throws Exception {
		String placeholderNameOfTextbox = "";
		try {
			commonEvents.waitTillElementLocated(careOfPersonTextboxByElement, 10);
			if(commonEvents.isDisplayed(careOfPersonTextboxByElement)) {
				commonEvents.click(careOfPersonTextboxByElement);
				placeholderNameOfTextbox = commonEvents.getAttribute(careOfPersonTextboxByElement, "placeholder");
				System.out.println("place holder name of care Of Person Textbox : " + placeholderNameOfTextbox );
				return placeholderNameOfTextbox;
			}
		}catch(Exception e) {
			throw e;
		}	
		return placeholderNameOfTextbox;
	}

	/**@Test6
	 * 
	 * @param none
	 * @description Clicks on the "Print Invoice" and "Confirm" buttons, 
	 *              then waits for and retrieves the error message displayed for the "Last Name" textbox.
	 * @return The error message text if present, otherwise an empty string
	 * @throws Exception if any element interaction or retrieval fails during execution
	 * author YAKSHA
	 */
	public String verifyErrorMessage() throws Exception {
		String errorMessage = "";
		try {
			commonEvents.waitTillElementLocated(printInvoiceButtonByElement, 10);
			if(commonEvents.isDisplayed(printInvoiceButtonByElement)) {
				commonEvents.click(printInvoiceButtonByElement);

				commonEvents.waitTillElementLocated(confirmButtonByElement, 10);
				commonEvents.click(confirmButtonByElement);

				commonEvents.waitTillElementLocated(errorMessageOfLastNameTextboxByElement, 10);
				commonEvents.isDisplayed(errorMessageOfLastNameTextboxByElement);
				errorMessage = commonEvents.getText(errorMessageOfLastNameTextboxByElement);
				System.out.println("error Message of Last Name textbox : " + errorMessage );
				return errorMessage;
			}
		}catch(Exception e) {
			throw e;
		}
		return errorMessage;
	}
	
	/**@Test7
	 * about this method verifyTexboxIsPresentAndValidateEnteredValue() 
	 * @param : null
	 * @description : verify text box , then send value to that text box and validate the entered value
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyTexboxIsPresentAndValidateEnteredValue(Map<String, String> expectedData) throws Exception {

		String phoneNumberTextboxValue = "";
		try {
			commonEvents.jsScrollToTopOfThePage();
			commonEvents.waitTillElementLocated(patientInformationTextByElement, 10);
			if(commonEvents.isDisplayed(patientInformationTextByElement)) {

				commonEvents.waitTillElementLocated(firstNameTextboxByElement, 10);
				commonEvents.sendKeys(firstNameTextboxByElement, expectedData.get("firstNameValue"));

				commonEvents.waitTillElementLocated(middleNameTextboxByElement, 10);
				commonEvents.sendKeys(middleNameTextboxByElement, expectedData.get("middleNameValue"));

				commonEvents.waitTillElementLocated(lastNameTextboxByElement, 10);
				commonEvents.sendKeys(lastNameTextboxByElement, expectedData.get("lastNameValue"));

				commonEvents.waitTillElementLocated(ageTextboxByElement, 10);
				commonEvents.sendKeys(ageTextboxByElement, expectedData.get("AgeValue"));

				commonEvents.waitTillElementLocated(phoneTextboxByElement, 10);
				commonEvents.sendKeys(phoneTextboxByElement, expectedData.get("phoneNumberValue"));

				phoneNumberTextboxValue = commonEvents.getAttribute(phoneTextboxByElement, "value");
				System.out.println("attribute value of phone number Textbox : " + phoneNumberTextboxValue );
				return phoneNumberTextboxValue;
			}
		}catch(Exception e) {
			throw e;
		}	
		return phoneNumberTextboxValue;
	}

	/**@Test8
	 * about this method verifyCheckboxIsSelectedAndDatePickerIsPresent() 
	 * @param : null
	 * @description : click on check box and verify that the check box is selected  or not
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public Boolean verifyCheckboxIsSelectedAndDatePickerIsPresent() throws Exception {
		boolean datePickerIsDisplayed = false;
		try {
			commonEvents.waitTillElementLocated(havDOBCheckboxByElement, 10);
			if(commonEvents.isDisplayed(havDOBCheckboxByElement)) { 
				commonEvents.click(havDOBCheckboxByElement);
				commonEvents.isSelected(havDOBCheckboxByElement);
				System.out.println("Have DOB Checkbox is selected");
				commonEvents.waitTillElementLocated(dobDatePickerByElement, 10);
				commonEvents.isDisplayed(dobDatePickerByElement);
				WebElement dobDatePickerWebElement = commonEvents.findElement(dobDatePickerByElement);
				commonEvents.highlight(dobDatePickerWebElement);
				datePickerIsDisplayed = true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return datePickerIsDisplayed;
	}

	/**@Test9
	 * about this method verifySuccessNotificationPopupMessage() 
	 * @param : null
	 * @description : handle the notification pop up
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifySuccessNotificationPopupMessage(Map<String, String> expectedData) throws Exception {
		String successNotificationPopupMessageValue = "";
		try {
			Thread.sleep(10000);
			commonEvents.waitTillElementLocated(externalCheckBoxByElement, 10);
			if(commonEvents.isDisplayed(externalCheckBoxByElement)) {
				commonEvents.isSelected(externalCheckBoxByElement);

				commonEvents.waitTillElementLocated(plusIconClickToAddExternalReffererByElement, 10);
				commonEvents.isDisplayed(plusIconClickToAddExternalReffererByElement);
				commonEvents.jsClick(plusIconClickToAddExternalReffererByElement);

				commonEvents.waitTillElementLocated(addExternalReferralTitleByElement, 10);
				String titleNameOfaddExternalReferralForm = commonEvents.getText(addExternalReferralTitleByElement);
				System.out.println("title Name Of add External Referral Form" + titleNameOfaddExternalReferralForm);

				WebElement titleOfaddExternalReferralFormsWebElement = commonEvents.findElement(addExternalReferralTitleByElement);
				commonEvents.highlightElementAfterAction(titleOfaddExternalReferralFormsWebElement);

				commonEvents.waitTillElementLocated(referrerNameTexboxByElement, 10);
				commonEvents.sendKeys(referrerNameTexboxByElement, expectedData.get("referrerName"));

				commonEvents.waitTillElementLocated(extRefferAddressTextFieldElement, 10);
				commonEvents.sendKeys(extRefferAddressTextFieldElement, expectedData.get("ExtRefferaddress"));

				commonEvents.waitTillElementLocated(contactNumberTextFieldElement, 10);
				commonEvents.sendKeys(contactNumberTextFieldElement, expectedData.get("contactNum"));

				commonEvents.waitTillElementLocated(emailTextFieldElement, 10);
				commonEvents.sendKeys(emailTextFieldElement, expectedData.get("email"));

				commonEvents.waitTillElementLocated(isIncentiveApplicableCheckboxElement, 10);
				commonEvents.click(isIncentiveApplicableCheckboxElement);

				commonEvents.waitTillElementLocated(addreferrerButtonByElement, 10);
				commonEvents.click(addreferrerButtonByElement);

				commonEvents.waitTillElementLocated(successNotificationPopupMessageElement, 10);
				commonEvents.isDisplayed(successNotificationPopupMessageElement);

				String actualNotificationValue = commonEvents.getText(successNotificationPopupMessageElement);
				System.out.println("success notification popup message text Value : " + actualNotificationValue );

				String notificationMessageOne = commonEvents.getText(successNotificationPopupMessageOneElement);
				System.out.println("notification Message One " + notificationMessageOne);

				String notificationMessageTwo = commonEvents.getText(successNotificationPopupMessageTwoElement);
				System.out.println("notification Message two " + notificationMessageTwo);

				successNotificationPopupMessageValue = notificationMessageOne + " " +notificationMessageTwo ;
				System.out.println("success notification popup message text Value : " + successNotificationPopupMessageValue );
			}
		}catch(Exception e) {
			throw e;
		}	
		return successNotificationPopupMessageValue;
	}

}
