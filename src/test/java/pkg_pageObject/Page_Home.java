package pkg_pageObject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pkg_global.GlobalObjects;

public class Page_Home extends GlobalObjects {

    private final Page page;

    public boolean mainMenuItemsCheck = false;

    // Locators
    private final Locator Link_Solutions;
    private final Locator Link_AboutUs;
    private final Locator Link_Services;
    private final Locator Link_Products;
    private final Locator Link_Locations;

    private final Locator Icon_Home;
    private final Locator Icon_AboutUs;
    private final Locator Icon_Contact;

    private final Locator Txtbx_User;
    private final Locator Txtbx_Pwd;
    private final Locator Btn_LogIn;

    private final Locator Lnk_Register;
    private final Locator Btn_Register;

    // Constructor
    public Page_Home(Page page) {

        this.page = page;

        Link_Solutions = page.locator("xpath=//*[text()='Solutions']");
        Link_AboutUs = page.locator("xpath=//*[text()='About Us']").first();
        Link_Services = page.locator("xpath=//*[text()='Services']").first();
        Link_Products = page.locator("xpath=//*[text()='Products']").first();
        Link_Locations = page.locator("xpath=//*[text()='Locations']").first();

        Icon_Home = page.locator(".home");
        Icon_AboutUs = page.locator(".aboutus");
        Icon_Contact = page.locator(".contact");

        Txtbx_User = page.locator("[name='username']");
        Txtbx_Pwd = page.locator("[name='password']");
        Btn_LogIn = page.locator("//input[@value='Log In']");

        Lnk_Register = page.locator("xpath=//*[text()='Register']");
        Btn_Register = page.locator("input[value='Register']");
    }

    public void ValidateLoginElements() {

        Txtbx_User.waitFor();
        Txtbx_Pwd.waitFor();
        Btn_LogIn.waitFor();
    }

    public void ValidateMainMenuItems() {

        Link_Solutions.waitFor();
        Link_AboutUs.waitFor();
        Link_Services.waitFor();
        Link_Products.waitFor();
        Link_Locations.waitFor();

        mainMenuItemsCheck = true;
    }

    public void ValidateWelcomeSectionElements() {

        Icon_Home.waitFor();
        Icon_AboutUs.waitFor();
        Icon_Contact.waitFor();

        mainMenuItemsCheck = true;
    }

    public void NavigateRegistration() {

        Lnk_Register.click();
        Btn_Register.waitFor();
    }

    public void NavigateHome() {

        page.navigate(sUrlHome);
    }
}