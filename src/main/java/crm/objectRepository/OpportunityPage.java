package crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityPage {
	
	// Opportunity Information:
	@FindBy(xpath = "//img[@title='Create Opportunity...']")
	private WebElement createOpportunityLookUpImg;

	@FindBy(xpath = "//span[contains(text(), 'Creating New Opportunity')]")
	private WebElement opportunitFormHeader;

	@FindBy(xpath = "//input[@name='potentialname']")
	private WebElement opportunityNameEdt;

	@FindBy(xpath = "//select[@id='related_to_type']")
	private WebElement relatedToDrp;

	@FindBy(xpath = "//input[@name='related_to_display']/following-sibling::Img[@title='Select']")
	private WebElement relatedToDrpValueLookUpImg; // Related To values based on dropDown
													// Selection(Organiztions,Contacts)
	/*
	 * This will open another windows where we can open Organization
	 */
	@FindBy(name = "search_text")
	private WebElement orgSearchEdt;// common elements so used same button

	@FindBy(name = "search")
	private WebElement orgSearchBtn;// common elements so used same button

	@FindBy(xpath = "//select[@name='opportunity_type']")
	private WebElement opportunityTypeDrp;

	@FindBy(name = "leadsource")
	private WebElement leadSourceDrp;

	@FindBy(xpath = "//select[@name='assigned_user_id']") // have to select Based on Value as ts Madatoryfield**
	private WebElement assignedToDrp;

	@FindBy(xpath = "//input[@name='campaignname']/following-sibling::Img[@title='Select']")
	private WebElement campaignSourceLookUpImg; // Campaign Source

	@FindBy(name = "amount")
	private WebElement amount;

	@FindBy(name = "closingdate")
	private WebElement expectedCloseDate;

	@FindBy(name = "sales_stage")
	private WebElement salesStageDrp;

	@FindBy(xpath = "//textarea[@class='detailedViewTextBox']")
	private WebElement descriptionEdt;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement createdOpportunityHeaderTitel;

	// initialization
	public OpportunityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnOpportunityLookUpImage() {
		createOpportunityLookUpImg.click();
	}
	
	public String getOpportunitiesPageHeader() {
		return opportunitFormHeader.getText();
	}
	
	

}
