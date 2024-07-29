import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {

    void cssXpath() {


            // <input type="email" class="inputtext Login_form_input_box" name="email" id="email" data-testid="email">

        $("[data-testid=email]").setValue("1"); // data-testid сильнее чем id - css
        $(by("data-testid", "email")).setValue("1"); //то же самое что и выше только без скобочек - css

        $x("//*[@data-testid='email']").setValue("1"); // с помощью xPath



            // <input type="email" class="inputtext Login_form_input_box" name="email" id="email"> ОБРАЩЕНИЕ К ID

        $("[id=email]").setValue("1"); // css обращение к id
        $(byId("email")).setValue("1"); //обращение только когда есть ID
        $("#email").setValue("1"); //сокращенное обращение к id с помощью #

        $x("//*[@id='email']").setValue("1"); // с помощью xPath


            // <input type="email" class="inputtext Login_form_input_box" name="email"> КОГДА НЕТ ID, можно обратиться к name например

        $("[name=email]").setValue("1"); // css
        $(byName("email")).setValue("1"); //обращение к name

        $x("//*[@name='email']").setValue("1"); // с помощью xPath


            // <input type="email" class="inputtext Login_form_input_box"> когда нет id нет name, но есть class

        $("[class=Login_form_input_box][class=inputtext]").setValue("1"); //делаем так если текст длинный класс
        $(".inputtext.Login_form_input_box").setValue("1"); //еще один вариант делаем так если текст длинный класс
        $(".Login_form_input_box").setValue("1"); //самый сокращенный вариант

        $x("//*[@class='inputtext'][@class='Login_form_input_box']").setValue("1"); // с помощью xPath



            // <div class="inputtext">
            //          <input type="email" class= "login_form_input_box">
            // </div>
        $(".inputtext .Login_form_input_box").setValue("1"); //ставим пробел после inputtext если в классе текст идет не сплошной, а как в примере/делаем так если у нас есть родительский элемент
        $(".inputtext").$(".Login_form_input_box").setValue("1"); //то же самое что и выше, но по другому/делаем так если у нас есть родительский элемент


        // <div>Hello, qa.guru!</div>    НАПРИМЕР НУЖНО НАЙТИ ЭЛЕМЕНТ ПО ТАКОМУ ПРИЗНАКУ (ПО ТЕКСТУ)

        $(byText("Hello, qa.guru!")); //поиск элемента по тексту (по всему)
        $(withText("Ho, qa.gu!")); //поиск элемента по тексту (по куску текста)

















    }
}
