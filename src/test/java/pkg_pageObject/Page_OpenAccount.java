package pkg_pageObject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pkg_global.GlobalObjects;

public class Page_OpenAccount extends GlobalObjects {

    private final Page page;

    public boolean accountOpenSuccess = false;

    // Locators
    private final Locator Lnk_OpenNewAccount;
    private final Locator Btn_OpenNewAccount;

    private final Locator Labl_AccountOpenSuccess;
    private final Locator Labl_AccountId;

    private final Locator Btn_TransferFunds;
    private final Locator Txtbx_TransferAmount;
    private final Locator Btn_Transfer;
    private final Locator Labl_TransferComplete;

    // Constructor
    public Page_OpenAccount(Page page) {

        this.page = page;

        Lnk_OpenNewAccount =
                page.locator("//a[@href='openaccount.htm']");

        Btn_OpenNewAccount =
                page.locator("//input[@value='Open New Account']");

        Labl_AccountOpenSuccess =
                page.locator("//*[text()='Account Opened!']");

        Labl_AccountId =
                page.locator("#newAccountId");

        Btn_TransferFunds =
                page.locator("//*[text()='Transfer Funds']");

        Txtbx_TransferAmount =
                page.locator("#amount");

        Btn_Transfer =
                page.locator("//input[@type='submit']");

        Labl_TransferComplete =
                page.locator("//*[text()='Transfer Complete!']");
    }

    public void OpenNewAccount() {

        Lnk_OpenNewAccount.click();

        page.waitForTimeout(utilGeneral.sleepMilliSec);

        Btn_OpenNewAccount.waitFor();

        Btn_OpenNewAccount.click();
    }

    public void NewAccountValidation() {

        Labl_AccountOpenSuccess.waitFor();

        Labl_AccountId.waitFor();

        System.out.println(
                "Account number is : "
                        + Labl_AccountId.textContent());

        accountOpenSuccess = true;
    }

    public void InitFundTransfer(String transferAmount) {

        Btn_TransferFunds.click();

        Txtbx_TransferAmount.waitFor();

        Txtbx_TransferAmount.fill(transferAmount);
    }

    public void FundTransferValidation() {

        Btn_Transfer.click();

        Labl_TransferComplete.waitFor();
    }
}