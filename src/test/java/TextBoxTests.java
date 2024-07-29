import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;



public class TextBoxTests {

    @BeforeAll //та аннотация выполняет НАСТРОЙКИ которые в ней заданы ПЕРЕД ВСЕМИ тестами один раз, например настройка определенного размера браузера
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager"; //стратегия загрузки, если страница долго грузится
        Configuration.baseUrl = "https://demoqa.com"; //выносим основной сайт, а в тестах уже оставляем только конкретный путь к сайту
    }

    @Test
    void fillFormTest() {

        open("/text-box");

        $("[id=userName]").setValue("Evgeny"); //css с id можно писать полностью [id=userName]
        $("[id=userEmail]").setValue("jekkka23@mail.ru");
        $("#currentAddress").setValue("Russia"); //а можно убрать [] и сократить поставив #
        $("#permanentAddress").setValue("Russia");
        $("#submit").click();


    }
}
