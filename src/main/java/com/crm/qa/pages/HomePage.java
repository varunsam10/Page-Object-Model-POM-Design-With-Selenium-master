package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

    @FindBy(xpath = "//td[@class='headertext']")
    @CacheLookup //this annotation will store the element in cache, instead of looking from the page, for better performance of framework
    WebElement userNameLabel;

    @FindBy(xpath = "//a[contains(text(),'Contacts')]")
    WebElement contactsLink;

    @FindBy(xpath = "//a[contains(text(),'New Contact')]")
    WebElement newContactLink;

    @FindBy(xpath = "//a[contains(text(),'Deals')]")
    WebElement dealsLink;

    @FindBy(xpath = "//a[contains(text(),'Tasks')]")
    WebElement tasksLink;

    public HomePage() {
        PageFactory.initElements(driver, this);// 'this' means current class objects.
    }

    public String verifyHomePageTitle() {
        return driver.getTitle();
    }

    public boolean verifyCorrectUserName() {
        return userNameLabel.isDisplayed();
    }

    public ContactsPage clickOnContactsLink() {
        contactsLink.click();
        return new ContactsPage();
    }

    public DealsPage clickOnDealsLink() {
        dealsLink.click();
        return new DealsPage();
    }

    public TasksPage clickOnTasksLink() {
        tasksLink.click();
        return new TasksPage();
    }

    public void clickOnNewContactLink() {
        Actions action = new Actions(driver); //always use Actions class for mouse hover actions
        action.moveToElement(contactsLink).build().perform();
        newContactLink.click();
    }


}

