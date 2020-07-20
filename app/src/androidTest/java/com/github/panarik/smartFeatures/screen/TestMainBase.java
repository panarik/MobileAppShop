package com.github.panarik.smartFeatures.screen;

import com.github.panarik.smartFeatures.R;
import com.github.panarik.smartFeatures.base.TestBase;

import org.junit.Test;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.anything;
import static org.junit.Assert.assertThat;

public class TestMainBase extends TestBase {

    //отображение активити
    @Test
    public void test_currentActivity_onScreen() {
        onView(withId(R.id.activity_main))
                .check(matches(isDisplayed()));
    }

    //ввод имени
    @Test
    public void editTextNameTest() {
        onView(withId(R.id.editText))
                .perform(typeText("alex"))
                .check(matches(withText("alex")));
    }


    @Test
    public void editTextSpinnerTest() {
        onView(withId(R.id.spinner))
                .perform(click());
        onData(anything())
                .atPosition(0)
                .perform(click())
                .check(matches(withText("Интерьер - 3м")));
    }


    @Test
    public void viewTextQuantityTest() {
        onView(withId(R.id.textView5))
                .check(matches(withText("0")));
    }


    @Test
    public void viewTextPriceTest() {
        onView(withId(R.id.textView4))
                .check(matches(withText("0.0 $")));
    }


    @Test
    public void editAddToCardTest() {
        //вводим имя
        onView(withId(R.id.editText))
                .perform(typeText("alex"))
                .check(matches(withText("alex")));

        //выбираем товар
        onView(withId(R.id.spinner))
                .perform(click());
        onData(anything())
                .atPosition(0)
                .perform(click())
                .check(matches(withText("Интерьер - 3мм")));

        //закрываем ввод текста
        mDevice.pressBack();

        //указываем количество
        onView(withId(R.id.button2))
                .perform(click());

    }

    @Test
    public void checkPreconditionsTest() {
        assertThat(mDevice, is(notNullValue()));
    }

/*
    @Test
    public void OkHttpTest() throws Exception {

        //run Get Request
        responseBody = getRequest(client, serverUrl);

        //matcher
        Assert.assertEquals("test body", responseBody); //body equals
    }
 */


    @Test
    public void textOnScreen() {
        onView(withText("Quantity"))
                .check(matches(isDisplayed()));
    }


    @Test
    public void anyContentViews() {
        onView(hasContentDescription())
                .check(matches(isDisplayed()));
    }

}