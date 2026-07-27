package pkg_utility;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pkg_global.GlobalObjects;
import pkg_pageObject.*;

public class Utility_General extends GlobalObjects {

    // Playwright default timeout
    public void ExplicitWaitNormal() {
        page.setDefaultTimeout(10000);
    }

    public void ExplicitWaitLow() {
        page.setDefaultTimeout(5000);
    }

    public void ExplicitWaitHigh() {
        page.setDefaultTimeout(15000);
    }

    // Wait for page load
    public void ImplicitWait(int nMilliSec) {
        page.waitForTimeout(nMilliSec);
    }

    public static void Sleep(int nMilliSec) {
        try {
            Thread.sleep(nMilliSec);
        } catch (Exception ex) {
            System.out.println();
        }
    }

    // Scroll vertically
    public void ScrollUsingJavaScript(String sHeightInPixel) {

        page.evaluate(
                "window.scrollBy(0," + sHeightInPixel + ");"
        );
    }

    // Scroll to bottom
    public void ScrollUsingJavaScriptBottom() {

        page.evaluate(
                "window.scrollTo(0, document.body.scrollHeight);"
        );
    }

    // Click using JavaScript
    public void ClickUsingJavaScriptBottom(Locator locator) {

        locator.evaluate("element => element.click()");
    }

    // Select dropdown by value
    public void DropDownChoose(String selector, String optionValue) {

        page.locator(selector).selectOption(optionValue);
    }

    // Mouse hover
    public void MouseHoverTopMenu() {

        try {

            page.locator("a[href='Index.html']").hover();
            page.waitForTimeout(1500);

            page.locator("a[href='WebTable.html']").hover();
            page.waitForTimeout(1500);

            page.locator("a[href='SwitchTo.html']").hover();
            page.waitForTimeout(1500);

            page.locator("a[href='Widgets.html']").hover();
            page.waitForTimeout(1500);

            page.locator("a[href*='practice']").hover();
            page.waitForTimeout(1500);

        } catch (Exception ex) {

            System.out.println();
        }
    }

    public void FetchCommandLineParam() {

        hmGlobalData.put("sUrlHome", sUrlHome);
    }

    // Factory Pattern
    public void InitAllPageObject() {

        utilGeneral = new Utility_General();

        pgHome = new Page_Home(page);
        pgRegister = new Page_Register(page);
        pgOpenNewAccount = new Page_OpenAccount(page);
        pgSearch = new Page_Search(page);
        pgCheckout = new Page_Checkout(page);
    }

    public void MyThreadSleep(int customSleepValueMilliSec) {

        try {

            Thread.sleep(customSleepValueMilliSec);

        } catch (Exception ex) {

            System.out.println();
        }
    }

    public static final String sBootText = "";
}