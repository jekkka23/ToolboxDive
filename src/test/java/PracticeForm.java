import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeForm {

    @BeforeAll
    //эта аннотация выполняет НАСТРОЙКИ которые в ней заданы ПЕРЕД ВСЕМИ тестами один раз, например настройка определенного размера браузера
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager"; //стратегия загрузки, если страница долго грузится, с ее помощью мы не будем дожидаться полной загрузки страницы
        Configuration.baseUrl = "https://demoqa.com"; //выносим основной сайт, а в тестах уже оставляем только конкретный путь к сайту
        //Configuration.holdBrowserOpen = true; //оставляет браузер открытым после теста
        //Configuration.timeout = 5000; по дефолту таймаут 4000

    }

    @Test
    void practiceFormTest() {

        open("/automation-practice-form");

        $("#firstName").setValue("Evgeny");

        $("#lastName").setValue("Mihailov");

        $("#userEmail").setValue("jekkka23@mail.ru");

        $(byText("Female")).click();

        $("#userNumber").setValue("1111111111");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__day--023").click();

        $("#subjectsContainer input").setValue("History").pressEnter();

        //$("label[for='hobbies-checkbox-1']").click(); //можем кликнуть с помощью lable и for
        $(byText("Sports")).click();

        //загрузка файла
        File file = new File("/Users/evgenymikhailov/Downloads/testsPhoto.png");
        $("#uploadPicture").uploadFile(file);

        $("#currentAddress").setValue("Russia");

        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();

        $("#submit").click();

        //проверки
        $(".modal-dialog").should(appear); //проверка, что окно появилось и мы его видим
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Evgeny"), text("Mihailov"), text("jekkka23@mail.ru"), text("1111111111"));

    }


}
