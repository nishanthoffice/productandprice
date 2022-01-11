package webPage;

import org.testng.annotations.Test;

public class TestWebPage extends WebPageBaseClass{
         @Test
        public void TestWebPage(){
            driver.get(url);
            WebPage wp=new WebPage(driver);
            wp.SearchPage();
            wp.CheckSearchBox();
            wp.SearchButton();
            wp.VerifySearchTitle();
            wp.LowestPriceProductDetails();
        }
}
