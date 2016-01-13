package com.espressotutorial.diegofl.espressotutorial;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;


import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.instanceOf;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by diegofl on 13/01/16.
 */

@RunWith(AndroidJUnit4.class)
public class NewUserTest {

    @Rule
    public ActivityTestRule<NewUserActivity> mActivityRule =
            new ActivityTestRule<>(NewUserActivity.class);

    @Test
    public void successRegister(){
        onView(withId(R.id.editTexNewtUser)).perform(typeText("test espresso"));
        onView(withId(R.id.editTextNewPassword)).perform(typeText("espresso123"));
        onView(withId(R.id.editTextNewEmail)).perform(typeText("espresso@test.com"));

        //SELECIONANDO O SEXO MASCULINO NO SPINNER
        String selectionText = mActivityRule.getActivity().getResources().getString(R.string.male);
        onView(withId(R.id.gender_spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is(selectionText))).perform(click());
        onView(withId(R.id.gender_spinner)).check(ViewAssertions.matches(withSpinnerText(containsString(selectionText))));

        onView(withId(R.id.fabRegister)).perform(click());

        //CHECANDO DE SE A MENSAGEM DE SUCESSO FOI EXIBIDA
        onView(withText(R.string.register_success)).check(ViewAssertions.matches(isDisplayed()));
    }

    //SEM O PREENCHIMENTO DE UM CAMPO OBRIGATÓRIO PARA TESTAR A VALIDAÇÃO
    @Test
    public void invalidRegister(){
        onView(withId(R.id.editTexNewtUser)).perform(typeText("test espresso"));
        onView(withId(R.id.editTextNewPassword)).perform(typeText("espresso123"));

        onView(withId(R.id.fabRegister)).perform(click());

        //CHECANDO DE SE A MENSAGEM DE FALHA FOI EXIBIDA
        onView(withText(R.string.register_fail)).check(ViewAssertions.matches(isDisplayed()));
    }
}
