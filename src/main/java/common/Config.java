package common;

public class Config {
    public static final String PLATFORM_AND_BROWSER = "Google Chrome";
    /**
     * Clear browser cookies after each iteration
     * if true - clear cookies
     */
    public static final Boolean CLEAR_COOKIES_AND_STORAGES = true;
    /**
     * To keep the browser open after suite
     * if true - close browser
     */
    public static final Boolean HOLD_BROWSER_OPEN = true;

    public static final String HOMEPAGE = "https://127.0.0.1:8000/telegram_auth/?token=a6bdd41d5ed04cb399eb29e325ee75fd";
}
