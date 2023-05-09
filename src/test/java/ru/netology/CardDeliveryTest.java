package ru.netology;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;
import static java.time.temporal.ChronoUnit.DAYS;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAmount;
import java.util.Date;

public class CardDeliveryTest {
    public String generateDate(long addDays, String pattern) {
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern(pattern));
    }

    @Test
    void shouldBeSuccessCardOrder() {
        open("http://localhost:9999/");
        $("[type = text]").setValue("Ижевск");
        $("[data-test-id=date]").click();
        $("[data-test-id=date] [value]").sendKeys(Keys.CONTROL + "a");
        $("[data-test-id=date] [value]").sendKeys(Keys.BACK_SPACE);
        String planningDate = generateDate(4, "dd.MM.yyyy");
        $("[data-test-id=date] [value]").setValue(planningDate);
        $("[name = name]").setValue("Некрасова Елена");
        $("[name = phone]").setValue("+79085552211");
        $("[data-test-id=agreement]").click();
        $(".button__text").click();
        $(".notification__content").shouldHave(Condition.text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15)).shouldBe(Condition.visible);
    }
}
