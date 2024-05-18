package tests.homepage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.homepage.HomePage;
import tests.base.BaseTest;

import java.time.Duration;
import java.util.List;

import static constants.Constants.Locators.ORDER_DELETE_MESSAGE;
import static constants.Constants.Locators.ORDER_SUCCESS_MESSAGE;
import static constants.Constants.TimeOutVariable.EXPLICIT_WAIT;
import static org.testng.Assert.*;

public class HomePageTest extends BaseTest {
    @Test
    void testMakeAnOrder(){
        homePage.makeAnOrder();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(ORDER_SUCCESS_MESSAGE));

        assertEquals("Заказ успешно отправлен!", successMessage.getText());
    }
    @Test
    void testProfile(){
        final String expectedResult = "https://127.0.0.1:8000/profile/";
        String actualResult;
        homePage.profile();

        actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test (groups = "order")
    void testDeleteOrderPositive() throws Exception{
        homePage.deleteOrder();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        WebElement deleteOrderMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(ORDER_DELETE_MESSAGE));

        assertEquals("Заказ успешно удален!", deleteOrderMessage.getText());
    }
    @Test (groups = "order")
    void testCountOrders(){
        final int expectedResult = 5;
        int actualResult;

        actualResult = homePage.countOrders();

        Assert.assertEquals(actualResult, expectedResult, "Текущее кол-во заказов должно быть 12");
    }
    @Test (groups = "order")
    void testParseTheFirstOrder(){
        // Вызываем метод parseTheFirstOrder
        List<String> parsedOrder = homePage.parseTheFirstOrder();

        // Проверяем, что список содержит четыре элемента
        assertEquals(4, parsedOrder.size());

        // Проверяем, что значения каждого элемента соответствуют ожидаемым
        assertEquals("Order ID: 10", parsedOrder.get(0)); // Order ID
        assertEquals("Subject: 3", parsedOrder.get(1)); // Subject
        assertEquals("Description: Это описание моего заказа", parsedOrder.get(2)); // Description
        assertEquals("Price: $500.00", parsedOrder.get(3)); // Price
    }
    @Test
    void testBackButton(){
        final String expectedResult = "https://127.0.0.1:8000/order/";
        String actualResult;

        homePage.backButton();

        actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
    }
//    @Test (expectedExceptions= {HomePage.TheOrderWasNotFound.class})
//    void testDeleteOrderNegative() throws Exception{
//        homePage.deleteOrder();
//    }
}
