package pages.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

import java.util.ArrayList;
import java.util.List;

import static constants.Constants.Locators.*;


public class HomePage extends BasePage {
    public HomePage(WebDriver driver){
        super(driver);
    }

    public WebElement clickElement(By locator){
        WebElement btnElement = driver.findElement(locator);
        waitElementIsVisible(btnElement).click();

        return btnElement;
    }

    public HomePage makeAnOrder(){
        WebElement clickSubject = clickElement(SUBJECT_LOCATOR);
        WebElement orderDescription = clickElement(ORDER_DESCRIPTION);

        orderDescription.sendKeys("Это описание моего заказа");

        WebElement priceInput = clickElement(THE_PRICE_OF_THE_ORDER);
        priceInput.sendKeys("500");

        WebElement makeOrder = clickElement(BUTTON_MAKE_AN_ORDER);

        return this;
    }
    public HomePage profile(){
        WebElement clickProfile = clickElement(CLICK_ON_THE_PROFILE);

        return this;
    }

    public HomePage deleteOrder() throws Exception{
        profile();
        WebElement deleteButton = clickElement(CLICK_ON_THE_DELETE_ORDER_BUTTON);

        return this;
    }

    public int countOrders(){
        profile();
        List<WebElement> orders = driver.findElements(LIST_OF_ORDERS);

        System.out.println(orders.size()); // 12

        return orders.size();
    }
    private String getOrderDetail(WebElement order, String cssSelector) {
        profile();
        return order.findElement(By.cssSelector(cssSelector)).getText().trim();
    }

    public List<String> parseTheFirstOrder() {
        profile();
        WebElement firstOrder = driver.findElement(PARSE_THE_FIRST_ORDER);
        WebElement orderDetails = firstOrder.findElement(ORDER_DETAILS);
        String orderInfo = orderDetails.getText().trim();

        List<String> parsedOrder = new ArrayList<>(); // Создаем список для хранения элементов заказа

        String[] lines = orderInfo.split("\n");
        for (String line : lines) {
            String[] parts = line.split(":", 2);
            if (parts.length == 2) {
                String label = parts[0].trim();
                String value = parts[1].trim();
                parsedOrder.add(label + ": " + value); // Добавляем строку в список
            }
        }

        return parsedOrder; // Возвращаем список элементов заказа
    }

    public HomePage backButton(){
        profile();

        WebElement clickBackButton = clickElement(CLICK_BACK_BUTTON);

        return this;
    }
//    public static class TheOrderWasNotFound extends Exception {
//        public TheOrderWasNotFound(String message){
//            super(message);
//        }
//    }
}
