package tests;

import manager.NGListener;
import manager.ProviderData;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(NGListener.class)
public class LoginTest extends TestBase{

//    WebDriver wd;
//
//    @BeforeMethod
//    public void init(){
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//    }

    @Test(groups = {"positive"})
    public void loginPositiveTest(){


        // open login form
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        app.getHelperUser().openLoginRegistrationForm();
        // fill login form
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("Ll12345$");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("skrydj1984@mail.com");
        app.getHelperUser().fillLoginRegistrationForm("skrydj1984@mail.com", "Ll12345$");
        // click on button login
//        wd.findElement(By.xpath("//button[1]")).click();
        app.getHelperUser().submitLogin();
        // assert
        app.getHelperUser().pause(3000);
//        Assert.assertTrue(wd.findElements(By.tagName("button")).size() > 0);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
        app.getHelperUser().logout();

    }
    @Test(groups = {"positive"})
    public void loginPositiveTestProperties(){


        // open login form
        app.getHelperUser().openLoginRegistrationForm();

        app.getHelperUser().fillLoginRegistrationForm(app.getEmail(), app.getPassword());
        // click on button login
        app.getHelperUser().submitLogin();
        // assert
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
        app.getHelperUser().logout();

    }

    @Test(groups = {"positive"})
    public void loginPositiveTestModel(){

        User user = User.builder()
                .email("skrydj1984@mail.com")
                .password("Ll12345$")
                .build();
        // open login form
        app.getHelperUser().openLoginRegistrationForm();
        // fill login form
        app.getHelperUser().fillLoginRegistrationForm(user.getEmail(), user.getPassword());
        // click on button login
        app.getHelperUser().submitLogin();
        // assert
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
    }

    @Test(groups = {"positive"}, dataProvider = "userDTO", dataProviderClass = ProviderData.class)
    public void loginPositiveUserDTO(User user){
        // open login form
        app.getHelperUser().openLoginRegistrationForm();
        // fill login form
        app.getHelperUser().fillLoginRegistrationForm(user.getEmail(), user.getPassword());
        // click on button login
        app.getHelperUser().submitLogin();
        // assert
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
    }

    @Test(groups = {"negative","smoke"})
    public void loginNegativeTestWrongEmail(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("skrydj1984mail.com", "Ll12345$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
    }
//    @Test
//    public void loginNegativeTestWrongEmail(){
//        // open login form
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//        // fill login form
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("skrydj1984mail.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("Ll12345$");
//
//        // click on button login
//        wd.findElement(By.xpath("//button[1]")).click();
//        // assert
//        pause(3000);
//        Assert.assertTrue(isAlertPresent());
//    }
    @Test(groups = {"negative"})
        public void loginNegativeTestWrongPassword(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("skrydj1984@mail.com", "Ll12345");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
    }
//
//    @Test
//    public void loginNegativeTestWrongPassword(){
//        // open login form
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//        // fill login form
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("skrydj1984@mail.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("Ll12345");
//
//        // click on button login
//        wd.findElement(By.xpath("//button[1]")).click();
//        // assert
//        pause(3000);
//
//    }


//
//    public void pause(int millis){
//        try {
//            Thread.sleep(millis);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public boolean isAlertPresent(){
//        Alert alert = new WebDriverWait(wd, 5)
//                .until(ExpectedConditions.alertIsPresent());
//        if(alert == null) return false;
//        wd.switchTo().alert();
//        System.out.println(alert.getText());
//        alert.accept();
//        return true;
//    }
//

}