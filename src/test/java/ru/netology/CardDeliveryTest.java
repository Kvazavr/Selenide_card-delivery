package ru.netology;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;

import org.junit.jupiter.api.Test;

import java.util.Date;

public class CardDeliveryTest {
    @Test
    void shouldBeSuccessCardOrder() {
        open("http://localhost:9999/");
        $("[data-test-id=city]").click();
        $("[type = text]").setValue("Ижевск");
        $("[data-test-id=date]").click();
        $("[value]").clear();
        $("[data-test-id=name]").click();
        $("[name = name]").setValue("Некрасова Елена");
        $("[data-test-id=phone]").click();
        $("[name = phone]").setValue("+79085552211");
        $("[data-test-id=agreement]").click();
        $("[type = button]").click();

//        Date date = new Date();
//        System.out.println(date);
//        $("[data-test-id=date]").clear();
//        $("input value").setValue("10.05.2023");

    }


}
