package pkg_hooks;

import com.microsoft.playwright.Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pkg_global.GlobalObjects;
import pkg_utility.Utility_Filehandler;
import pkg_utility.Utility_General;

public class Hooks extends GlobalObjects {

    private Scenario currentScenario;

    @Before
    public void setupHookBefore(Scenario scenario) {

        this.currentScenario = scenario;

        System.out.println("*** Setup Hook Before ***");

        // Launch Playwright Browser
        new GlobalObjects().LaunchBrowser();

        // Initialize Page Objects
        new Utility_General().InitAllPageObject();

        // Read Command Line Parameters
        new Utility_General().FetchCommandLineParam();

        // Initialize Property File
        new Utility_Filehandler().PropertiesDataReaderInit();

        // Initialize CSV Data
        new Utility_Filehandler().CsvDataReaderInit();
    }

    @After
    public void tearDownHookAfter() {

        System.out.println("*** Tear Down Hook After ***");

        try {

            if (currentScenario != null && currentScenario.isFailed()) {

                byte[] imgBytes = page.screenshot(
                        new Page.ScreenshotOptions()
                                .setFullPage(true)
                );

                currentScenario.attach(
                        imgBytes,
                        "image/png",
                        "Fail Screenshot Attached"
                );
            }

        } catch (Exception ex) {
            System.out.println("Screenshot Capture Failed : " + ex.getMessage());
        } finally {

            if (page != null)
                page.close();

            if (browserContext != null)
                browserContext.close();

            if (browser != null)
                browser.close();

            if (playwright != null)
                playwright.close();

            page = null;
            browserContext = null;
            browser = null;
            playwright = null;

            bBrowserInvoked = false;
            currentScenario = null;
        }
    }
}