package com.espressotutorial.diegofl.espressotutorial;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by diegofl on 13/01/16.
 */

//DETERMINA QUE É UMA CLASSE DE TESTE
@RunWith(AndroidJUnit4.class)
public class LoginTest {

    //DETERMINA QUAL ACTIVITY SERÁ TESTADA
    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule =
            new ActivityTestRule<>(LoginActivity.class);


    //DETERMINA QUE É UM TESTE
    @Test
    public void successLogin(){

        //PROCURANDO O EDIT TEXT PELO ID E DIGITANDO
        onView(withId(R.id.editTextUser)).perform(typeText("test espresso"));
        onView(withId(R.id.editTextPassword)).perform(typeText("espresso123"));

        //PROCURANDO O BOTÃO PELO TEXT E CLICANDO
        onView(withText(R.string.login)).perform(click());

        //CHECANDO DE SE A MENSAGEM DE SUCESSO FOI EXIBIDA
        onView(withText(R.string.login_successful)).check(ViewAssertions.matches(isDisplayed()));
    }

    //SEM O PREENCHIMENTO DE UM CAMPO OBRIGATÓRIO PARA TESTAR A VALIDAÇÃO
    @Test
    public void invalidLogin(){
        onView(withId(R.id.editTextUser)).perform(typeText("test espresso"));

        onView(withText(R.string.login)).perform(click());

        //CHECANDO DE SE A MENSAGEM DE FALHA FOI EXIBIDA
        onView(withText(R.string.login_invalid)).check(ViewAssertions.matches(isDisplayed()));
    }

}
