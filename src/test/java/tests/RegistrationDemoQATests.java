package tests;

import utils.RandomUtils;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationDemoQATests extends TestBase {

    private final RegistrationPage registrationPage = new RegistrationPage();
    private final RandomUtils random = new RandomUtils();

     String
            firstName = random.FirstName(),
            lastName = random.LastName(),
            userEmail = random.UserEmail(),
            gender = random.Gender(),
            phoneNumber = random.PhoneNumber(),
            dayOfBirth = random.DayOfBirth(),
            monthOfBirth = random.MonthOfBirth(),
            yearOfBirth = random.YearOfBirth(),
            subjects = random.Subjects(),
            hobbies = random.Hobbies(),
            picName = "avva.jpg",
            currentAddress = random.CurrentAddress(),
            state = random.State(),
            city = random.City(state);

    @Test
    void successfulRegistrationTest() {

        registrationPage
                .openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setPicture(picName)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        registrationPage
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth",dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", picName)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    void successfulRegistrationWithMinDataTest() {
        String firstName = "Mihail";
        String lastName = "Zubenko";
        String gender = "Male";
        String phoneNumber = "8999665533";

        registrationPage
                .openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .clickSubmit();

        registrationPage
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber);
    }

    @Test
    void negativeRegistrationTest() {
        registrationPage.openPage();
        registrationPage.removeBanners();
        registrationPage.clickSubmit();

        registrationPage.negativeCheck();
    }
}

