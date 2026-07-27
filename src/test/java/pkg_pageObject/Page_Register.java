package pkg_pageObject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pkg_global.GlobalObjects;

import java.util.Random;

public class Page_Register extends GlobalObjects {

    private final Page page;

    public boolean registerSuccess = false;

    // Locators
    private final Locator Txtbx_FirstName;
    private final Locator Txtbx_LastName;
    private final Locator Txtbx_Address;
    private final Locator Txtbx_City;
    private final Locator Txtbx_State;
    private final Locator Txtbx_Zip;
    private final Locator Txtbx_Phone;
    private final Locator Txtbx_SSN;
    private final Locator Txtbx_UserName;
    private final Locator Txtbx_Password;
    private final Locator Txtbx_PasswordAgain;

    private final Locator Btn_Register;
    private final Locator Btn_LogOut;
    private final Locator Labl_Account;

    // Constructor
    public Page_Register(Page page) {

        this.page = page;

        Txtbx_FirstName = page.locator("#customer\\.firstName");
        Txtbx_LastName = page.locator("#customer\\.lastName");
        Txtbx_Address = page.locator("#customer\\.address\\.street");
        Txtbx_City = page.locator("#customer\\.address\\.city");
        Txtbx_State = page.locator("#customer\\.address\\.state");
        Txtbx_Zip = page.locator("#customer\\.address\\.zipCode");
        Txtbx_Phone = page.locator("#customer\\.phoneNumber");
        Txtbx_SSN = page.locator("#customer\\.ssn");
        Txtbx_UserName = page.locator("#customer\\.username");
        Txtbx_Password = page.locator("#customer\\.password");
        Txtbx_PasswordAgain = page.locator("#repeatedPassword");

        Btn_Register = page.locator("input[value='Register']");
        Btn_LogOut = page.locator("xpath=//*[text()='Log Out']");
        Labl_Account = page.locator(
                "xpath=//*[text()='Your account was created successfully. You are now logged in.']");
    }

    public void RegistrationInit() {

        // Generate random username
        hmGlobalData.put(
                "username",
                hmGlobalData.get("username")
                        + (new Random().nextInt(8999) + 1000));

        System.out.println(hmGlobalData.get("username"));

        Txtbx_FirstName.fill(hmGlobalData.get("name"));
        Txtbx_LastName.fill(hmGlobalData.get("lastName"));
        Txtbx_Address.fill(hmGlobalData.get("address"));
        Txtbx_City.fill(hmGlobalData.get("city"));
        Txtbx_State.fill(hmGlobalData.get("state"));
        Txtbx_Zip.fill(hmGlobalData.get("zip"));
        Txtbx_Phone.fill(hmGlobalData.get("phone"));
        Txtbx_SSN.fill(hmGlobalData.get("ssn"));
        Txtbx_UserName.fill(hmGlobalData.get("username"));
        Txtbx_Password.fill(hmGlobalData.get("password"));
        Txtbx_PasswordAgain.fill(hmGlobalData.get("password"));

        Btn_Register.click();

        Btn_LogOut.waitFor();
        Labl_Account.waitFor();

//        Btn_Register.waitFor(new Locator.WaitForOptions()
//                .setState(Locator.WaitForOptions.State.HIDDEN));

        registerSuccess = true;
    }
}