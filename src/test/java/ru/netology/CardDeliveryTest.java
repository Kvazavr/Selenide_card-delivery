package ru.netology;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;
import static java.time.temporal.ChronoUnit.DAYS;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAmount;
import java.util.Date;

public class CardDeliveryTest {
    @Test
    void shouldBeSuccessCardOrder(){
        open("http://localhost:9999/");
        $("[type = text]").setValue("Ижевск");
        $("[data-test-id=date]").click();
        $("[data-test-id=date] [value]").sendKeys(Keys.CONTROL + "a");
        $("[data-test-id=date] [value]").sendKeys(Keys.BACK_SPACE);
        LocalDateTime currentDay = LocalDateTime.now();
        LocalDateTime validDate = currentDay.plus(3, DAYS);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String format = validDate.format(dateTimeFormatter);
        $("[data-test-id=date] [value]").setValue(format);
        $("[name = name]").setValue("Некрасова Елена");
        $("[name = phone]").setValue("+79085552211");
        $("[data-test-id=agreement]").click();
        $(".button__text").click();
        $x("//*[contains(text(), 'Встреча успешно забронирована')]").should(appear, Duration.ofSeconds(15));
    }
}
