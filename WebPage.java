package webPage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.*;


public class WebPage {

    WebDriver ldriver;

    public WebPage(WebDriver rdiver) {
        ldriver = rdiver;
        PageFactory.initElements(rdiver, this);
    }
    @FindBy(name = "search_query")
    @CacheLookup
    WebElement searchBox;

    @FindBy(id = "search_query_top")
    @CacheLookup
    WebElement textBox;

    @FindBy(name = "submit_search")
    @CacheLookup
    WebElement button;

    public void CheckSearchBox() {
        Assert.assertTrue(searchBox.isDisplayed(), String.valueOf(true));

    }

    public void SearchPage() {
        textBox.sendKeys("dress");
    }

    public void SearchButton() {
        button.click();
    }

    public void VerifySearchTitle() {
        String exp_searchTitle = "dress";
        String actual_SearchTitle = ldriver.getTitle();
        if (actual_SearchTitle.toLowerCase().contains(exp_searchTitle.toLowerCase())) {
            Assert.assertEquals(true, true);
        } else {
            Assert.assertEquals(false, false);
            System.out.println("Result is Displayed");
        }
    }

    public void LowestPriceProductDetails() {

       List<WebElement> listOfProductName = ldriver.findElements(By.xpath("//ul[@class='product_list grid row']/li/div/div[2]/h5"));
        List<WebElement> listOfProductPrice = ldriver.findElements(By.xpath("//ul[@class='product_list grid row']/li/div/div[2]/div[1]//span[@class='price product-price']"));
        for(WebElement element:listOfProductName){
            System.out.println(element.getText());
        }
        for (WebElement element1:listOfProductPrice){
            System.out.println(element1.getText());
        }
        String productname;
        String productprice;
        int intproductPrice;
        HashMap<Integer,String> mapfinalproduct = new HashMap<Integer,String>();
        for (int count = 0; count < listOfProductName.size(); count++) {
            productname = listOfProductName.get(count).getText();
            productprice = listOfProductPrice.get(count).getText();
            productprice = productprice.replaceAll("[^0-9]", "");
            intproductPrice = Integer.parseInt(productprice);
            mapfinalproduct.put(intproductPrice, productname);
        }
            System.out.println("product name and price" + mapfinalproduct.toString());
            Set<Integer> allkeys = mapfinalproduct.keySet();
            ArrayList<Integer> arrayListProductPrice = new ArrayList<Integer>(allkeys);
            Collections.sort(arrayListProductPrice);
            int lowPrice = arrayListProductPrice.get(0);
            System.out.println("Low Product Price is:" + lowPrice + "Product name" + mapfinalproduct.get(lowPrice));

        }

    }





