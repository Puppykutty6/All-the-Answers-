package pages;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pharmacy_Pages extends StartupPage {

//	TC1-Locators
	By usernameTextbox = By.xpath("//input[@id='username_id']");
	By passwordTextbox = By.xpath("//input[@id='password']");
	By signInButton = By.xpath("//button[@id='login']");
	By homepageLogo = By.cssSelector("img[class=\"logo-default\"]");
//	TC2-Locators
	By pharmacyTabXpath = By.xpath("//a[@href='#/Pharmacy']");
//	TC3-LOcators
	private By tabXpath;
//	TC4-Locators
	By orderTabXpath = By.xpath("//ul[@class='page-breadcrumb']//a[@href='#/Pharmacy/Order']");
	By purchaseOrderSubTabXpath = By.xpath("//a[@href='#/Pharmacy/Order/PurchaseOrder']");
	By goodsReceiptSubTabXpath = By.xpath("//a[@href='#/Pharmacy/Order/GoodsReceiptList']");
	public By searchBarId = By.id("quickFilterInput");
	By calendarFromDropdown = By.xpath("(//input[@id='date'])[1]");
	By calendarToDropdown = By.xpath("(//input[@id='date'])[2]");
	public By supplierNameDropdownXpath = By.xpath("//input[@placeholder='select supplier']");
//	TC5-Locators
	By supplierTabXpath = By.xpath("//ul[@class=\"page-breadcrumb\"]//a[@href=\"#/Pharmacy/Supplier\"]");
//	TC6-Locators
	By printReceiptButtonId = By.id("saveGr");
	By closeModalButtonXpath = By.xpath("//a[@title='Cancel']");
	
	
	By reportTabXpath = By.xpath("//ul[@class='page-breadcrumb']//a[@href='#/Pharmacy/Report']");
	By settingTabXpath = By.xpath("//ul[@class='page-breadcrumb']//a[@href='#/Pharmacy/Setting']");
	By storeTabXpath = By.xpath("//ul[@class='page-breadcrumb']//a[@href='#/Pharmacy/Store']");
	By supplierLedgerTabXpath = By.xpath("//ul[@class='page-breadcrumb']//a[@href='#/Pharmacy/SupplierLedger']");
	By substoreRequestAndDispatchTabXpath = By
			.xpath("//ul[@class='page-breadcrumb']//a[@href='#/Pharmacy/SubstoreRequestAndDispatch']");
	By agingDaysFromXpath = By.xpath("//input[@placeholder='From']");
	By agingDaysToXpath = By.xpath("//input[@placeholder='To']");
//	public By showDetails = By.xpath("//button[contains(text(),'Show Details')]");
	By okButtonXpath = By.xpath("//button[contains(text(),'OK')]");
	By filterDropdownXpath = By.xpath("//div[@class='dropdown']//span[@data-hover='dropdown']");
	By radiButtonCompleteXpath = By.xpath("//input[@value='complete']/../span");
//	public By radiButtonCancelledXpath = By.xpath("//input[@value='cancelled']/../span");
	By radiButtonAllXpath = By.xpath("//input[@value='all']/../span");
//	public By updateReceiptButtonId = By.id("updateGr");
	By itemNameId = By.id("txt_ItemName");
	By batchNumberId = By.id("txt_BatchNo");
	By quantityId = By.id("ItemQTy");
	By rateId = By.id("GRItemPrice");
	By saveButtonId = By.id("btn_Save");
	By mrpId = By.id("MRP");
	By supplierNameDropdownId = By.id("SupplierName");
	By invoiceNumberFieldId = By.id("InvoiceId");
	By paymentModeDropdownId = By.id("paymentMode");
//	public By closeModalButtonXpath2 = By.xpath("//a[contains(@class,'history-del-btn')]");
	By expiryDateFieldId = By.id("ExpiryDate");
	By addNewItemModalXpath = By.xpath("(//div[@class='modelbox-div clearfix'])[2]");
	By modalXpath = By.xpath("//div[@class='modelbox-div clearfix']");
	By favouriteOrStarIcon = By.xpath("//i[contains(@class,'icon-favourite')]");
	By goodReceiptTableDataRow = By.cssSelector("div[ref=\"eCenterContainer\"] div[role=\"row\"]");
	By actualDatesOfGoodReceiptTableXpath = By
			.xpath("//div[@col-id=\"GoodReceiptDate\"]/span[not(@ref=\"cbSelectAll\")]");
	
	String pageName = this.getClass().getSimpleName();
	public pharmacy_Pages(WebDriver driver) {
		super(driver);
	}

	/**
	 * @Test1.1 about this method loginTohealthAppByGivenValidCredetial()
	 * 
	 * @param : Map<String, String>
	 * @description : fill usernameTextbox & passwordTextbox and click on sign in
	 *              button
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public boolean loginToHealthAppByGivenValidCredetial(Map<String, String> expectedData) throws Exception {
		Boolean textIsDisplayed = false;
		try {
			WebElement usernametextFieldWebElement = commonEvents.findElement(usernameTextbox);
			commonEvents.highlightElement(usernametextFieldWebElement);
			commonEvents.sendKeys(usernameTextbox, expectedData.get("username"));

			WebElement passwordtextFieldWebElement = commonEvents.findElement(passwordTextbox);
			commonEvents.highlightElement(passwordtextFieldWebElement);
			commonEvents.sendKeys(passwordTextbox, expectedData.get("password"));

			WebElement signinButtonWebElement = commonEvents.findElement(signInButton);
			commonEvents.highlightElement(signinButtonWebElement);
			commonEvents.click(signInButton);

			textIsDisplayed = true;
		} catch (Exception e) {
			throw e;
		}
		return textIsDisplayed;
	}
	/**
	 * @Test1.2 about this method clickOnHomePageLogo()
	 * 
	 * @param : null
	 * @description : This method finds the homepage logo on the screen. If the logo
	 *              is displayed, it highlights the logo and clicks on it.
	 * @return : void
	 * @author : YAKSHA
	 */
	public void clickOnHomePageLogo() {
		WebElement homePageLogo = commonEvents.findElement(homepageLogo);
		try {
			if (commonEvents.isDisplayed(homePageLogo)) {
				commonEvents.highlight(homePageLogo);
				commonEvents.click(homePageLogo);
			}
		} catch (Exception e) {
			throw e;
		}
	}


	/**
	 * @Test1.3 about this method verifyTitleOfThePage()
	 * 
	 * @param : null
	 * @description : it will navigate to the URL and validate the title of the
	 *              current page.
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyTitleOfThePage() throws Exception {
		String pageTitle = "";
		try {
			pageTitle = commonEvents.getTitle();
			System.out.println("title of the page is  :" + pageTitle);
		} catch (Exception e) {
			throw e;
		}
		return pageTitle;
	}

	/**
	 * @Test1.4 about this method verifyURLOfThePage()
	 * 
	 * @param : null
	 * @description : it will navigate to the URL and validate the URL of the
	 *              current page.
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyURLOfThePage() throws Exception {
		String urlofThepage = "";
		try {
			urlofThepage = commonEvents.getCurrentUrl();
			System.out.println("URL of the page is  :" + urlofThepage);
		} catch (Exception e) {
			throw e;
		}
		return urlofThepage;
	}

	
	/**
	 * @Test2.1 about this method scrollDownAndClickPharmacyTab()
	 * 
	 * @param : null
	 * @description : verify the pharmacy tab, scroll to it, and click it
	 * @return : String
	 * @author : YAKSHA
	 */
	public void scrollDownAndClickPharmacyTab() throws Exception {
		try {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			WebElement pharmacyTab = commonEvents.findElement(pharmacyTabXpath);
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", pharmacyTab);
			commonEvents.highlight(pharmacyTab);
			commonEvents.click(pharmacyTab);
			commonEvents.waitForUrlContains("Pharmacy/Dashboard", 10);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @Test2.2 about this method getPharmacyPageUrl()
	 * 
	 * @param : null
	 * @description : This method retrieves the current URL of the page to verify if
	 *              the user is on the Pharmacy page.
	 * @return : String - the current URL of the page
	 * @author : YAKSHA
	 */
	public String getPharmacyPageUrl() throws Exception {
		try {
			String titleToVerify = commonEvents.getCurrentUrl();
			return titleToVerify;
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * @Test3 about this method verifyAndHighlightTab()
	 * @param : String tabName - The name of the tab to verify and highlight
	 * @description : This method locates the tab specified by the tabName parameter
	 *              in the Pharmacy module, highlights it, and returns true if the
	 *              tab is displayed.
	 * @return : boolean - true if the tab is displayed, false otherwise
	 * @throws : Exception - if there is an issue locating or highlighting the tab
	 * @author : YAKSHA
	 */
	public boolean verifyAndHighlightPharmacySubModulesTab(String tabName) throws Exception {
		try {
			tabXpath = By.xpath("//ul[@class='page-breadcrumb']//a[@href='#/Pharmacy/" + tabName + "']");
			WebElement tabToHighlight = commonEvents.findElement(tabXpath);
			commonEvents.highlight(tabToHighlight);
			return tabToHighlight.isDisplayed();
		} catch (Exception e) {
			throw e;
		}
	}

	private void setTabXpath(String tabName) {
		tabXpath = By.xpath("//ul[@class='page-breadcrumb']//a[@href='#/Pharmacy/" + tabName + "']");
	}

	

	/**
	 * @Test4.1, @Test5.1, @Test6.1 @Test7.1 about
	 * this method visitOrderTabUnderPharmacy()
	 * 
	 * @param : null
	 * @description : navigates the user to the order screen
	 * @return : void
	 * @author : YAKSHA
	 */
	public void visitTabUnderPharmacy(String tabName) throws Exception {
		try {
			setTabXpath(tabName);
			WebElement orderTab = commonEvents.findElement(tabXpath);
			commonEvents.highlight(orderTab);
			commonEvents.click(orderTab);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @Test4.2 about this method isOrderTabSelected()
	 * 
	 * @param : null
	 * @description : verify whether the order tab is the currently selected tab
	 * @return : boolean
	 * @author : YAKSHA
	 */
	public boolean isOrderTabSelected() throws Exception {
		try {
			WebElement orderTab = commonEvents.findElement(orderTabXpath);
			commonEvents.highlight(orderTab);
			boolean orderTabSelected = orderTab.getAttribute("class").contains("active");
			return orderTabSelected;
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * @Test4.3 about this method areSubTabsUnderOrderPresent()
	 * 
	 * @param : null
	 * @description : verify all sub tabs under order are present
	 * @return : boolean
	 * @author : YAKSHA
	 */
	public boolean areSubTabsUnderOrderPresent() throws Exception {
		try {
			boolean allSubTabsPresent = false;
			if (commonEvents.isDisplayed(purchaseOrderSubTabXpath)
					&& commonEvents.isDisplayed(goodsReceiptSubTabXpath)) {
				allSubTabsPresent = true;
			}
			return allSubTabsPresent;
		} catch (Exception e) {
			throw e;
		}
	}



	/**
	 * @Test4.4 about this method areAgingDaysFieldsPresent()
	 * 
	 * @param : null
	 * @description : This method verifies if the 'Aging Days From' and 'Aging Days
	 *              To' fields are present and highlighted.
	 * @return : boolean - true if both fields are displayed, false otherwise
	 * @throws : Exception - if there is an issue locating or highlighting the
	 *           fields
	 * @author : YAKSHA
	 */


	public boolean isSearchBarPresent() throws Exception {
		try {
			WebElement searchBar = commonEvents.findElement(searchBarId);
			commonEvents.highlight(searchBar);
			return searchBar.isDisplayed();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @Test4.5 about this method areDateDropdownsPresent()
	 * 
	 * @param : null
	 * @description : This method verifies if the 'From' and 'To' date dropdowns are
	 *              present and highlighted on the page.
	 * @return : boolean - true if both date dropdowns are displayed, false
	 *         otherwise
	 * @throws : Exception - if there is an issue locating or highlighting the
	 *           dropdowns
	 * @author : YAKSHA
	 */
	public boolean areDateDropdownsPresent() throws Exception {
		try {
			boolean dateDropdownPresent = false;
			WebElement dateDropdownFrom = commonEvents.findElement(calendarFromDropdown);
			WebElement dateDropdownTo = commonEvents.findElement(calendarToDropdown);
			commonEvents.highlight(dateDropdownFrom);
			commonEvents.highlight(dateDropdownTo);
			if (dateDropdownFrom.isDisplayed() && dateDropdownTo.isDisplayed()) {
				dateDropdownPresent = true;
			}
			return dateDropdownPresent;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @Test4.6 about this method isSelectSupplierDropdownPresent()
	 * 
	 * @param : null
	 * @description : This method verifies if the 'Select Supplier' dropdown is
	 *              present and highlighted on the page.
	 * @return : boolean - true if the 'Select Supplier' dropdown is displayed,
	 *         false otherwise
	 * @throws : Exception - if there is an issue locating or highlighting the
	 *           dropdown
	 * @author : YAKSHA
	 */
	public boolean isSelectSupplierDropdownPresent() throws Exception {
		try {
			WebElement selectSupplierDropdown = commonEvents.findElement(supplierNameDropdownXpath);
			commonEvents.highlight(selectSupplierDropdown);
			return selectSupplierDropdown.isDisplayed();
		} catch (Exception e) {
			throw e;
		}
	}



	/**
	 * @Test5.2 about this method verifySelectedTabIsActiveOrNot()
	 * 
	 * @param : null
	 * @description : This method verifies if the "Supplier" tab is displayed and
	 *              returns its "class" attribute value. This can be used to
	 *              determine if the tab is active or not based on its class
	 *              attributes.
	 * @return : String - the value of the "class" attribute of the "Supplier" tab
	 *         if it is displayed, an empty string otherwise
	 * @throws : Exception - if there is an issue locating or highlighting the tab,
	 *           or getting its attribute
	 * @author : YAKSHA
	 */
	public String verifySelectedTabIsActiveOrNot() throws Exception {
		String locatorAttributeValue = "";
		try {
			if (commonEvents.isDisplayed(supplierTabXpath)) {
				WebElement supplierTab = commonEvents.findElement(supplierTabXpath);
				commonEvents.highlight(supplierTab);
				locatorAttributeValue = commonEvents.getAttribute(supplierTabXpath, "class");
			}
		} catch (Exception e) {
			throw e;
		}
		return locatorAttributeValue;
	}

	/**
	 * @Test6.2 @Test7.2 and @Test7.3 about this method clickButtonByText()
	 * 
	 * @param buttonText : String - The text of the button to be clicked
	 * @description : This method locates a button using its text and performs a
	 *              click action on it. If the button is found and successfully
	 *              clicked, it highlights the button first. In case of failure
	 *              (e.g., button not found or click error), an error message is
	 *              printed and an exception is thrown.
	 * @return : void
	 * @throws : Exception - if there is an issue finding the button or performing
	 *           the click action
	 * @author : YAKSHA
	 */
	public void clickButtonByText(String buttonText) throws Exception {
		try {
			WebElement buttonToClick = commonEvents
					.findElement(By.xpath("//button[contains(text(),'" + buttonText + "')]"));
			commonEvents.highlight(buttonToClick).click(buttonToClick);
		} catch (Exception e) {
			System.out.println("Either the button not found or encountered error while clicking!");
			throw e;
		}
	}

	/**
	 * @Test6.3 about this method clickPrintReceipt()
	 * 
	 * @param : null
	 * @description : This method locates the "Print Receipt" button using its
	 *              identifier and performs a click action on it. The button is
	 *              highlighted before clicking to ensure visibility. If an
	 *              exception occurs during the finding or clicking of the button,
	 *              it is re-thrown.
	 * @return : void
	 * @throws : Exception - if there is an issue finding the button or performing
	 *           the click action
	 * @author : YAKSHA
	 */
	public void clickPrintReceipt() throws Exception {
		try {
			WebElement printReceiptButton = commonEvents.findElement(printReceiptButtonId);
			commonEvents.highlight(printReceiptButton).click(printReceiptButton);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @Test6.4 @Test7.6 about this method
	 * verifyMessageByText()
	 * 
	 * @param messageText - the text to match within the message element
	 * @description : This method locates a message element on the page by searching
	 *              for a paragraph (`
	 *              <p>
	 *              `) that contains the specified text (`messageText`) or has a
	 *              class `main-message`. It highlights the message element and
	 *              returns its text content. If an exception occurs while finding
	 *              or retrieving the message, it logs an error and re-throws the
	 *              exception.
	 * @return : String - the text content of the located message element
	 * @throws : Exception - if there is an issue finding the message or retrieving
	 *           its text
	 * @author : YAKSHA
	 */
	public String verifyMessageByText(String messageText) throws Exception {
		try {
			WebElement message = commonEvents.findElement(
					By.xpath("//p[contains(@class,'main-message') or contains(text(),'" + messageText + "')]"));
			commonEvents.highlight(message);
			return message.getText();
		} catch (Exception e) {
			System.out.println("Error message didn't appear!");
			throw e;
		}
	}

	/**
	 * @Test6.5 @Test8.6 and about this method closeAddGoodReceiptModal()
	 * 
	 * @param : null
	 * @description : This method locates the "Close" button of the "Add Good
	 *              Receipt" modal using the provided XPath
	 *              (`closeModalButtonXpath`). It highlights the button and then
	 *              clicks it to close the modal. If an exception occurs while
	 *              finding or interacting with the button, it logs an error and
	 *              re-throws the exception.
	 * @return : void
	 * @throws : Exception - if there is an issue finding or clicking the "Close"
	 *           button
	 * @author : YAKSHA
	 */
	public boolean closeAddGoodReceiptModal() throws Exception {
		boolean isModalClosed = false;
		try {
			WebElement closeAddGoodReceiptModalButton = commonEvents.findElement(closeModalButtonXpath);
			commonEvents.highlight(closeAddGoodReceiptModalButton).click(closeAddGoodReceiptModalButton);
			isModalClosed = true;
			return isModalClosed;
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * @Test7.4 about this method addGriItemWithMandatoryFieldsOnly()
	 * 
	 * @param itemName    - the name of the item to be added
	 * @param batchNumber - the batch number of the item
	 * @param quantity    - the quantity of the item
	 * @param rate        - the rate of the item
	 * @param mrp         - the MRP (Maximum Retail Price) of the item
	 * @description : This method adds an item to the GRI (Goods Receipt Inventory)
	 *              with mandatory fields only. It highlights and enters values for
	 *              item name, batch number, expiry date, quantity, rate, and MRP.
	 *              If any of these fields are not provided, they are skipped. The
	 *              method then clicks the save button. If the modal appears, it
	 *              waits for the modal to fully load.
	 * @return : void
	 * @throws : Exception - if there is any issue locating elements, entering data,
	 *           or clicking the save button
	 * @author : YAKSHA
	 */
	public void addGriItemWithMandatoryFieldsOnly(String itemName, String batchNumber, String quantity, String rate,
			String mrp) throws Exception {
		try {
			WebElement itemNameField = commonEvents.findElement(itemNameId);
			WebElement batchNumberField = commonEvents.findElement(batchNumberId);
			WebElement expiryDateField = commonEvents.findElement(expiryDateFieldId);
			WebElement quantityField = commonEvents.findElement(quantityId);
			WebElement rateField = commonEvents.findElement(rateId);
			WebElement mrpField = commonEvents.findElement(mrpId);
			WebElement saveButton = commonEvents.findElement(saveButtonId);

			// Highlight and enter itemName if it's not null or empty
			if (itemName != null && !itemName.isEmpty()) {
				commonEvents.highlight(itemNameField);
				commonEvents.sendKeys(itemNameField, itemName);
				commonEvents.sendKeys(itemNameField, Keys.ENTER);
			}

			// Highlight and enter batchNumber if it's not null or empty
			if (batchNumber != null && !batchNumber.isEmpty()) {
				commonEvents.highlight(batchNumberField);
				commonEvents.sendKeys(batchNumberField, batchNumber);
			}

			// Highlight and enter expiryDate (hardcoded) if it's not null or empty
			commonEvents.highlight(expiryDateField);
			commonEvents.sendKeys(expiryDateField, "August").sendKeys(expiryDateField, Keys.ARROW_RIGHT)
					.sendKeys(expiryDateField, "2030");

			// Highlight and enter quantity if it's not null or empty
			if (quantity != null && !quantity.isEmpty()) {
				commonEvents.highlight(quantityField);
				commonEvents.sendKeys(quantityField, quantity);
			}

			// Highlight and enter rate if it's not null or empty
			if (rate != null && !rate.isEmpty()) {
				commonEvents.highlight(rateField);
				commonEvents.sendKeys(rateField, rate);
			}

			if (mrp != null && !mrp.isEmpty()) {
				commonEvents.highlight(mrpField);
				commonEvents.sendKeys(mrpField, mrp);
			}

			// Highlight and click saveButton

			commonEvents.highlight(saveButton).click(saveButton);
			System.out.println("Clicked on Save Button!!");

			// Wait for the modal to appear
			if (commonEvents.isDisplayed(modalXpath)) {
				commonEvents.waitTillNumberOfElementsToBe(modalXpath, 5, 1);
			}
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @Test7.5 about this method enterMandatoryDetailsToPrintGoodReceipt()
	 * 
	 * @param invoiceNumber - the invoice number to be entered in the field
	 * @description : This method enters mandatory details required to print a good
	 *              receipt. It locates and highlights the supplier dropdown,
	 *              invoice number field, and payment mode dropdown. It then enters
	 *              the provided invoice number and selects the necessary options
	 *              from the dropdowns before clicking the print receipt button.
	 * @return : void
	 * @throws : Exception - if there is any issue locating elements, entering data,
	 *           or clicking buttons
	 * @author : YAKSHA
	 */
	public void enterMandatoryDetailsToPrintGoodReceipt(String invoiceNumber) throws Exception {
		try {
			WebElement selectSupplierDropdown = commonEvents.findElement(supplierNameDropdownId);
			WebElement invoiceNumberField = commonEvents.findElement(invoiceNumberFieldId);
			WebElement paymentModeDropdown = commonEvents.findElement(paymentModeDropdownId);
			WebElement printReceiptButton = commonEvents.findElement(printReceiptButtonId);
			commonEvents.highlight(selectSupplierDropdown);
			commonEvents.click(selectSupplierDropdown).sendKeys(supplierNameDropdownId, Keys.ENTER);
			commonEvents.highlight(invoiceNumberField);
			commonEvents.click(invoiceNumberField).sendKeys(invoiceNumberField, invoiceNumber);
			commonEvents.highlight(paymentModeDropdown);
			commonEvents.click(paymentModeDropdown).sendKeys(paymentModeDropdownId, Keys.ENTER);
			commonEvents.highlight(selectSupplierDropdown).click(printReceiptButton);

		} catch (Exception e) {
			throw e;
		}
	}

	
	/**
	 * @Test 8.1 : Close modal by its subject name
	 * @param modalTitle : String - The title text of the modal to be closed
	 * @description : 
	 *      - Locates the modal window using the given title
	 *      - Finds and clicks the associated "Cancel" (close) button to dismiss the modal
	 * @return : void
	 * @throws : Exception - if the modal or cancel button is not found or interaction fails
	 * @author : YAKSHA
	 */
	
	public void closeModalBySubjectName(String modalTitle) throws Exception {
		try {
			WebElement closeModalButton = commonEvents
					.findElement(By.xpath("//h3/span[contains(text(),'" + modalTitle + "')]/../../a[@title='Cancel']"));
			commonEvents.highlight(closeModalButton).click(closeModalButton);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @Test8.4  about this method
	 * clickViewButtonWithInvoice()
	 * 
	 * @param : String
	 * @description : Clicks on the "view" button next to a particular invoice
	 *              number
	 * @return : void
	 * @throws : Exception - if there is an issue finding or clicking the "view"
	 *           button
	 * @author : YAKSHA
	 */
	public void clickViewButtonWithInvoice(String invoiceNumber) throws Exception {
		try {
			WebElement viewButton = commonEvents.findElement(By.xpath("//div[@col-id='InvoiceNo' and contains(text(),'"
					+ invoiceNumber + "')]/..//a[@danphe-grid-action='view']"));
			commonEvents.highlight(viewButton).click(viewButton);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @Test8.8 about this method doesPrintContainsInvoiceNumber()
	 * 
	 * @param : String
	 * @description : Verify whether the printed report contains expected invoice
	 *              number
	 * @return : boolean
	 * @throws : Exception - if there is an issue finding or clicking the invoice
	 *           number text button
	 * @author : YAKSHA
	 */
	public boolean doesPrintContainsInvoiceNumber(String invoiceNumber) throws Exception {
		try {
			WebElement actualInvoiceNumber = commonEvents
					.findElement(By.xpath("//p[contains(text(),'Invoice No: ')]/b"));
			commonEvents.highlight(actualInvoiceNumber);
			String actualInvoiceNumberText = actualInvoiceNumber.getText();
			return actualInvoiceNumberText.contains(invoiceNumber);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @Test8.2 about this method
	 * clickAndEnterValueInSearchField()
	 * 
	 * @param : String
	 * @description : Enters value in the search bar
	 * @return : boolean
	 * @throws : Exception - if there is an issue finding or typing the text
	 * @author : YAKSHA
	 */
	public boolean clickAndEnterValueInSearchField(String searchData) {
		boolean isSearchBarDisplayed = false;
		try {
			isSearchBarDisplayed = isSearchBarPresent();
			System.out.println("isSearchBarDisplayed + " + isSearchBarDisplayed);
			if (isSearchBarDisplayed) {
				WebElement searchField = commonEvents.findElement(searchBarId);
				commonEvents.clear(searchBarId);
				commonEvents.highlight(searchField).click(searchBarId).sendKeys(searchBarId, searchData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSearchBarDisplayed;
	}



	/**
	 * @Test8.3 @Test9.2
	 * about this method highlightAndClickOnButton()
	 * 
	 * @param : By, String
	 * @description : Highlights the provided element and clicks on it
	 * @return : boolean
	 * @throws : Exception - if there is an issue finding the element
	 * @author : YAKSHA
	 */
	public boolean highlightAndClickOnButton(By element, String buttonName) {
		boolean isButtonDisplayed = false;
		try {
			if (commonEvents.isDisplayed(element)) {
				WebElement webElement = commonEvents.getWebElement(element);
				commonEvents.highlight(webElement).click(webElement);
				System.out.println("Clicked on " + buttonName + " button");
				isButtonDisplayed = true;
			}
		} catch (Exception e) {
			throw e;
		}
		return isButtonDisplayed;
	}


	/**
	 * @Test9.1 about this method applyDateFilter()
	 * 
	 * @param : String, String
	 * @description : Applies the date filter with date range
	 * @return : boolean
	 * @throws : Exception - if there is an issue finding or filling the date fields
	 * @author : YAKSHA
	 */
	public boolean applyDateFilter(String fromDate, String toDate) throws Exception {
		boolean isDateApplied = false;
		try {
			String fromDay, fromMonth, fromYear, toDay, toMonth, toYear;
			fromDay = fromDate.split("-")[0];
			fromMonth = fromDate.split("-")[1];
			fromYear = fromDate.split("-")[2];
			toDay = toDate.split("-")[0];
			toMonth = toDate.split("-")[1];
			toYear = toDate.split("-")[2];
			WebElement fromDateDropdown = commonEvents.findElement(calendarFromDropdown);
			WebElement toDateDropdown = commonEvents.findElement(calendarToDropdown);
			WebElement okButton = commonEvents.findElement(okButtonXpath);
			commonEvents.highlight(fromDateDropdown).sendKeys(fromDateDropdown, fromDay)
					.sendKeys(fromDateDropdown, fromMonth).sendKeys(fromDateDropdown, fromYear);
			commonEvents.highlight(toDateDropdown).sendKeys(toDateDropdown, toDay).sendKeys(toDateDropdown, toMonth)
					.sendKeys(toDateDropdown, toYear);
			commonEvents.highlight(okButton).click(okButton);

			isDateApplied = true;
			return isDateApplied;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @Test9.3 about this method verifyActualDatesAreWithinThisRange()
	 * 
	 * @param : String, String
	 * @description : Verify whether results are within the applied date range
	 * @return : boolean
	 * @throws : Exception - if there is an issue finding the actual dates within
	 *           the results
	 * @author : YAKSHA
	 */
	public boolean verifyActualDatesAreWithinThisRange(String fromDate, String toDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		List<WebElement> actualDatesAfterFilterApplied = commonEvents
				.getWebElements(actualDatesOfGoodReceiptTableXpath);
		LocalDate from = LocalDate.parse(fromDate, formatter);
		LocalDate to = LocalDate.parse(toDate, formatter);

		for (WebElement dateElement : actualDatesAfterFilterApplied) {
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
	}

}
