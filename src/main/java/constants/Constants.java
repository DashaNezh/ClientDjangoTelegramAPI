package constants;

import org.openqa.selenium.By;

public class Constants {
    public static class Locators{
        public static final By SUBJECT_LOCATOR = By.cssSelector("#subject > option:nth-child(4)"); // начертательная геометрия
        public static final By CLICK_ADDITIONAL = By.cssSelector("#details-button");
        public static final By CONFIRM_LOGIN_TO_THE_SITE = By.cssSelector("#proceed-link");
        public static final By ORDER_DESCRIPTION = By.cssSelector("#order-description");
        public static final By THE_PRICE_OF_THE_ORDER = By.cssSelector("#price");
        public static final By BUTTON_MAKE_AN_ORDER = By.cssSelector("#order-button");
        public static final By CLICK_ON_THE_PROFILE = By.cssSelector("body > div:nth-child(3) > a");
        public static final By CLICK_ON_THE_DELETE_ORDER_BUTTON = By.xpath(".//button[text()='Удалить']");
        public static final By LIST_OF_ORDERS = By.cssSelector(".order");
        public static final By PARSE_THE_FIRST_ORDER = By.cssSelector("body > div > ul > li:nth-child(1)");
        public static final By ORDER_DETAILS = By.className("order-details");
        public static final By CLICK_BACK_BUTTON = By.cssSelector("body > a");
        public static final By FIND_ORDER_ID = By.xpath(".//strong[contains(text(), 'Номер заказа:')]");
    }
    public static class TimeOutVariable{
        public static final int IMPLICIT_WAIT = 5;
        public static final int EXPLICIT_WAIT = 10;
    }
}
