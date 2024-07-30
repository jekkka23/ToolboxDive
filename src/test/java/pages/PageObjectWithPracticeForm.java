package pages;


import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PageObjectWithPracticeForm {

     public static SelenideElement firstNameInput = $("#firstName");
     public static SelenideElement lastNameInput = $("#lastName");
     public static SelenideElement emailInput = $("#userEmail");
     public static SelenideElement genderInput = $(byText("Female"));
     public static SelenideElement userNumberInput = $("#userNumber");
     public static SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
     public static SelenideElement yearDateInput = $(".react-datepicker__year-select");
     public static SelenideElement monthDateInput = $(".react-datepicker__month-select");
     public static SelenideElement dayDateInput = $(".react-datepicker__day--023");
     public static SelenideElement subjectInput = $("#subjectsContainer input");
     public static SelenideElement hobbiesInput = $(byText("Sports"));
     public static SelenideElement uploadFileInput = $("#uploadPicture");
     public static SelenideElement currentAddressInput = $("#currentAddress");
     public static SelenideElement stateInput = $("#state");
     public static SelenideElement selectStateInput = $(byText("NCR"));
     public static SelenideElement cityInput = $("#city");
     public static SelenideElement selectCityInput = $(byText("Delhi"));
     public static SelenideElement submitInput = $("#submit");
     public static SelenideElement assertModalDialogInput = $(".modal-dialog");
     public static SelenideElement assertExampleModalSizeInput = $("#example-modal-sizes-title-lg");
     public static SelenideElement assertTableResponsiveInput = $(".table-responsive");



     public void setFirstName() {
          firstNameInput.setValue("Evgeny");
     }
     public void setLastName() {
          lastNameInput.setValue("Mihailov");
     }
     public void setEmail() {
          emailInput.setValue("jekkka23@mail.ru");
     }
     public void setGender() {
          genderInput.click();
     }
     public void setUserNumber() {
          userNumberInput.setValue("1111111111");
     }
     public void setDateOfBirth() {
          dateOfBirthInput.click();
          yearDateInput.selectOption("1995");
          monthDateInput.selectOption("February");
          dayDateInput.click();
     }
     public void setSubject() {
          subjectInput.setValue("History").pressEnter();
     }
     public void setHobbies() {
          hobbiesInput.click();
     }
     public void setUploadFile() {
          File file = new File("/Users/evgenymikhailov/Downloads/testsPhoto.png");
          uploadFileInput.uploadFile(file);
     }
     public void setCurrentAddress() {
          currentAddressInput.setValue("Russia");
     }
     public void setStateAndCity() {
          stateInput.click();
          selectStateInput.click();
          cityInput.click();
          selectCityInput.click();
     }
     public void setSubmit() {
          submitInput.click();
     }
     public void setAssertSuccess() {
          assertModalDialogInput.should(appear);
          assertExampleModalSizeInput.shouldHave(text("Thanks for submitting the form"));
          assertTableResponsiveInput.shouldHave(text("Evgeny"), text("Mihailov"), text("jekkka23@mail.ru"), text("1111111111"));
     }



     public void playTest() {
          setFirstName();
          setLastName();
          setEmail();
          setGender();
          setUserNumber();
          setDateOfBirth();
          setSubject();
          setHobbies();
          setUploadFile();
          setCurrentAddress();
          setStateAndCity();
          setSubmit();
          setAssertSuccess();

     }















}
