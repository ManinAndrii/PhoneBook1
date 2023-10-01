package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddNewContactTests extends TestBase{

@BeforeMethod
    public void precondition(){
        if(!app.getHelperUser().isLogged()) app.getHelperUser().login(
            User.builder()
                    .email("skrydj1984@mail.com")
                    .password("Ll12345$")
                    .build());

}

@Test(invocationCount = 1)
    public void addNewContactPositive(){
    int i = (int)(System.currentTimeMillis()/1000)%3600;
    Contact contact = Contact.builder()
            .name("John")
            .lastName("Smith")
            .phone("12345678"+i)
            .email("john_"+i+"@mail.com")
            .address("Tell-Aviv")
            .description("driver")
            .build();


            app.getHelperContact().openContactForm();
            app.getHelperContact().fillContactForm(contact);
            app.getHelperContact().submitContactForm();
            Assert.assertTrue(app.getHelperContact().isContactCreated(contact));
            app.getHelperUser().logout();


}
}
