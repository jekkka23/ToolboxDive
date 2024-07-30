import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.PageObjectWithPracticeForm;

import static com.codeborne.selenide.Selenide.open;

public class PracticeFormPageObjectTests {

    @BeforeAll
    //эта аннотация выполняет НАСТРОЙКИ которые в ней заданы ПЕРЕД ВСЕМИ тестами один раз, например настройка определенного размера браузера
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager"; //стратегия загрузки, если страница долго грузится, с ее помощью мы не будем дожидаться полной загрузки страницы
        Configuration.baseUrl = "https://demoqa.com"; //выносим основной сайт, а в тестах уже оставляем только конкретный путь к сайту
        //Configuration.holdBrowserOpen = true; //оставляет браузер открытым после теста
        //Configuration.timeout = 5000; по дефолту таймаут 4000
    }
    PageObjectWithPracticeForm pageObjectWithPracticeForm = new PageObjectWithPracticeForm();


    @Test

    void successfulRegistrationTest() {
        open("/automation-practice-form");
        //executeJavaScript(jsCode: "$('#fixedban').remove()"); - удаление элементов со страницы, например баннера, нужен для подготовки страницы к дальнейшему тестированию или анализу.
        pageObjectWithPracticeForm.playTest();





    }
}
