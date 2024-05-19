package tests.homepage;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.homepage.HomePage;
import tests.base.BaseTest;

import java.util.List;

import static org.testng.Assert.*;

public class HomePageTest extends BaseTest {
    @Test (groups = "order")
    void testMakeAnOrder(){
        homePage.profile();
        final int expectedResult = homePage.countOrders() + 1;
        int actualResult;
        homePage.backButton();
        homePage.makeAnOrder();

        homePage.profile();
        actualResult = homePage.countOrders();

        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test (groups = "positive")
    void testProfile(){
        final String expectedResult = "https://127.0.0.1:8000/profile/";
        String actualResult;
        homePage.profile();

        actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test (groups = "order")
    void testDeleteOrderPositive() throws Exception{
        int existingOrderId = 57;

        boolean expectedResult = true;

        boolean actualResult = false;

        try {
            homePage.deleteOrder(existingOrderId);
            actualResult = true;
        } catch (HomePage.TheOrderWasNotFound e) {
            actualResult = false;
        }

        Assert.assertEquals(actualResult, expectedResult, "Заказ с указанным Order ID должен существовать, но не найден.");
    }
    @Test (groups = "order")
    void testCountOrders(){
        homePage.profile();
        final int expectedResult = 8;
        int actualResult;

        actualResult = homePage.countOrders();

        Assert.assertEquals(actualResult, expectedResult, "Текущее кол-во заказов должно быть 8");
    }
    @Test (groups = "order")
    void testParseTheFirstOrder(){
        // Вызываем метод parseTheFirstOrder
        List<String> parsedOrder = homePage.parseTheFirstOrder();

        // Проверяем, что список содержит пять элементов
        assertEquals(5, parsedOrder.size());

        // Проверяем, что значения каждого элемента соответствуют ожидаемым
        assertEquals("Номер заказа: 10", parsedOrder.get(0));
        assertEquals("Предмет: 3", parsedOrder.get(1));
        assertEquals("Описание: Это описание моего заказа", parsedOrder.get(2));
        assertEquals("Цена: $500.00", parsedOrder.get(3));
        assertEquals("Статус: Неизвестно", parsedOrder.get(4));
    }
    @Test (groups = "positive")
    void testBackButton(){
        final String expectedResult = "https://127.0.0.1:8000/order/";
        String actualResult;

        homePage.profile();
        homePage.backButton();

        actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test (expectedExceptions= {HomePage.TheOrderWasNotFound.class}, groups = "negative")
    void testDeleteOrderNegative() throws Exception{
        homePage.deleteOrder(100);
    }
}
