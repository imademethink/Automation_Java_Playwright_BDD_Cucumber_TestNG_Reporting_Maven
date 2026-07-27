package pkg_pageObject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pkg_global.GlobalObjects;

public class Page_Checkout extends GlobalObjects {

    private final Page page;

    // Locators
    private final Locator Element_OverallProductsCheckout;
    private final Locator lstBtn_SignOut;

    // Constructor
    public Page_Checkout(Page page) {

        this.page = page;

        Element_OverallProductsCheckout =
                page.locator("tr[id*='product_']");

        // Represents all matching Sign Out links
        lstBtn_SignOut =
                page.locator("a[title='Log me out']");
    }

    // Returns number of checkout products
    public int getCheckoutProductCount() {

        return Element_OverallProductsCheckout.count();
    }

    // Returns number of sign out links
    public int getSignOutButtonCount() {

        return lstBtn_SignOut.count();
    }

    // Click first Sign Out button
    public void clickSignOut() {

        if (lstBtn_SignOut.count() > 0) {
            lstBtn_SignOut.first().click();
        }
    }
}