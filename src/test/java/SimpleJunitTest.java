import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

//В JUnit есть возможность выполнять какой то общий код перед каждым тестом при помощи аннотации @BeforeEach


public class SimpleJunitTest {

    int result;


    @BeforeEach //эта аннотация выполняет условие которое в ней задано перед каждым тестом
    void beforeEach() {
        System.out.println("###   beforeEach");
        result = getResult();
    }

    @Test
    void firstTest() {
        System.out.println("###   firstTest"); //выводим на экран результат
        Assertions.assertTrue(result > 2); //с помощью assert можно что-то сравнивать
    }

    @Test
    void secondTest() {
        System.out.println("###   secondTest"); //выводим на экран результат
        Assertions.assertTrue(result > 2); //с помощью assert можно что-то сравнивать
    }


    private int getResult() { //создаем метод который будет возвращать нам это условие
        return 3;
    }



}
