package com.qa.ilCarro.tests;

import com.qa.ilCarro.model.UserData;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @Test
    public void registrationFromHeader(){
     app.getUser().clickSignUpButton();
     app.getUser().fillRegistrationForm(new UserData()
             .withfName("A")
             .withlName("Kogann")
             .withEmail("adkogan+3@gmail.com")
             .withPassword("12345zxc"));

     app.getUser().confirmRegistration();




    }






}
