import io.github.cdimascio.dotenv.Dotenv;
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;

public class Main {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        String botToken = dotenv.get("ACCESS_TOKEN");

        try (TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication()) {
            botsApplication.registerBot(botToken, new MyAmazingBot(botToken));
            System.out.println("MyAmazingBot successfully started!");
            Thread.currentThread().join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
