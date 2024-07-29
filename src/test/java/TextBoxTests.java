import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;



public class TextBoxTests {

    @BeforeAll //та аннотация выполняет НАСТРОЙКИ которые в ней заданы ПЕРЕД ВСЕМИ тестами один раз, например настройка определенного размера браузера
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager"; //стратегия загрузки, если страница долго грузится, с ее помощью мы не будем дожидаться полной загрузки страницы
        Configuration.baseUrl = "https://demoqa.com"; //выносим основной сайт, а в тестах уже оставляем только конкретный путь к сайту
        //Configuration.holdBrowserOpen = true; оставляет браузер открытым после теста
        //Configuration.timeout = 5000; по дефолту таймаут 4000

    }

    @Test
    void fillFormTest() {

        open("/text-box"); //это так называемый относительный адрес

        $("[id=userName]").setValue("Evgeny"); //css с id можно писать полностью [id=userName]
        $("[id=userEmail]").setValue("jekkka23@mail.ru");
        $("#currentAddress").setValue("Russia"); //а можно убрать [] и сократить поставив #
        $("#permanentAddress").setValue("Russia");
        $("#submit").click();
        //прописываем проверки
        $("#output").$("#name").shouldHave(text("Evgeny"));
        //$("#output #name").shouldHave(text("Evgeny")); запись выше и эта, они идентичны, тут мы выбираем локатор от родительского к дочернему
        $("#output").$("#email").shouldHave(text("jekkka23@mail.ru"));
        $("#output").$("#currentAddress").shouldHave(text("Russia")); //проверяя currentAddress у нас их два, по этому мы сначала указали родительский элемент, а затем дочерний под ним
        //$("#currentAddress" 1).shouldHave(text("Russia")); запись эта и выше идентичны
        $("#output").$("#permanentAddress").shouldHave(text("Russia")); //но можно без родительского элемента, а после permanentAddress указать порядковый номер 1 через запятую
        //$("#permanentAddress", 1).shouldHave(text("Russia")); как тут например, то же самое что и выше только другим способом




    }
}
