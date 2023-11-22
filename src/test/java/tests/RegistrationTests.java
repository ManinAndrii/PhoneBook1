package tests;

import manager.ProviderData;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        if(app.getHelperUser().isLogged()) {
             app.getHelperUser().logout();
        }    }

    @Test(groups = {"positive"})
    public void registrationPositiveTest() {
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "skrydj_" + i + "@mail.com";
        String password = "Ll12345$";
        app.getHelperUser().openLoginRegistrationForm();
       // app.getHelperUser().fillLoginRegistrationForm("skrydj_" + i + "@mail.com", "Ll12345$");
        app.getHelperUser().fillLoginRegistrationForm(email, password);
        app.getHelperUser().submitRegistration();
        logger.info("registrationPositiveTest starts with " + email + " & " + password);
       Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));

    }
    @Test(groups = {"positive"}, dataProvider = "registrationCSV", dataProviderClass = ProviderData.class)
    public void registrationPositiveTestCSV(User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(email, password);
        app.getHelperUser().submitRegistration();
        logger.info("registrationPositiveTest starts with:" + email + " & " + password);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
    }

    //
//    @Test
//    public void registrationPositiveTest(){
//        // open login form
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//        // fill login form
//        int i = (int)(System.currentTimeMillis()/1000)%3600;
//
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("abc_" + i + "@def.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("$Abcdef12345");
//
//        // click on button registration
//        wd.findElement(By.xpath("//button[2]")).click();
//        // assert
//        pause(3000);
//        Assert.assertTrue(wd.findElements(By.tagName("button")).size() > 0);
//    }
    @Test(groups = {"negative"})
    public void registrationNegativeTestWrongEmail(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("skrydj_" + i + "mail.com", "Ll12345$");
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent());

    }
//    @Test
//    public void registrationNegativeTestWrongEmail(){
//        // open login form
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//        // fill login form
//        int i = (int)(System.currentTimeMillis()/1000)%3600;
//
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("abc_" + i + "def.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("$Abcdef12345");
//
//        // click on button registration
//        wd.findElement(By.xpath("//button[2]")).click();
//        // assert
//        pause(3000);
//        Assert.assertTrue(isAlertPresent());
//
//
//   }
@Test(groups = {"negative"})
public void registrationNegativeTestWrongPassword(){
    int i = (int)(System.currentTimeMillis()/1000)%3600;
    app.getHelperUser().openLoginRegistrationForm();
    app.getHelperUser().fillLoginRegistrationForm("skrydj_" + i + "@mail.com", "Ll12345");
    app.getHelperUser().submitRegistration();
    Assert.assertTrue(app.getHelperUser().isAlertPresent());

}


}