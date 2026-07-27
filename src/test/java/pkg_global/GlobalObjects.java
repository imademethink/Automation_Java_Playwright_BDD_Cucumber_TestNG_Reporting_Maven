package pkg_global;

import com.microsoft.playwright.*;

import pkg_pageObject.Page_Checkout;
import pkg_pageObject.Page_Home;
import pkg_pageObject.Page_OpenAccount;
import pkg_pageObject.Page_Register;
import pkg_pageObject.Page_Search;
import pkg_utility.Utility_General;

import java.util.HashMap;

public class GlobalObjects {

    // Playwright Objects
    public static Playwright playwright = null;
    public static Browser browser = null;
    public static BrowserContext browserContext = null;
    public static Page page = null;

    public static boolean bBrowserInvoked = false;

    // Urls
    public static String sUrlHome =
            "https://parabank.parasoft.com/parabank/index.htm";

    // Global Test Data
    public static HashMap<String, String> hmGlobalData = new HashMap<>();

    // Properties File
    public static final String sPropertiesFilePath =
            System.getProperty("user.dir")
                    + "\\src\\test\\resources\\externalData\\Config.properties";

    // CSV File
    public static final String sCsvFilePath =
            System.getProperty("user.dir")
                    + "\\src\\test\\resources\\externalData\\Searchterm.csv";

    // Utility Objects
    public static Utility_General utilGeneral = null;

    // Page Objects
    public static Page_Home pgHome = null;
    public static Page_Register pgRegister = null;
    public static Page_OpenAccount pgOpenNewAccount = null;
    public static Page_Search pgSearch = null;
    public static Page_Checkout pgCheckout = null;

    // Wait Constants
    public final int sleepMilliSecShort = 8000;
    public final int sleepMilliSec = 10000;
    public final int sleepMilliSecLong = 10000;

    // Launch Browser
    public void LaunchBrowser() {

        if (bBrowserInvoked) {
            return;
        }

        playwright = Playwright.create();

        BrowserType.LaunchOptions launchOptions =
                new BrowserType.LaunchOptions()
                        .setHeadless(false);

        browser = playwright.chromium().launch(launchOptions);

        Browser.NewContextOptions contextOptions =
                new Browser.NewContextOptions()
                        .setViewportSize(1920, 1080);

        browserContext = browser.newContext(contextOptions);

        browserContext.clearCookies();

        page = browserContext.newPage();

        page.setDefaultTimeout(30000);
        page.setDefaultNavigationTimeout(30000);

        System.out.println("Log: Chrome browser is launched using Playwright");

        bBrowserInvoked = true;
    }
}