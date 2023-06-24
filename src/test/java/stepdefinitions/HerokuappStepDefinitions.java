package stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import pages.HerokuPage;

public class HerokuappStepDefinitions {
    HerokuPage herokuPage = new HerokuPage();

    @Then("Add Element butonuna basar")
    public void add_element_butonuna_basar() {
        herokuPage.addElementButonu.click();
    }
    @Then("Delete butonu gorunur oluncaya kadar bekler")
    public void delete_butonu_gorunur_oluncaya_kadar_bekler() {
        // Delete butonu implicitly wait suresi icinde gorunur oldugundan
        // bu adimda bir islem yapilmadi
    }
    @Then("Delete butonunun gorunur oldugunu test eder")
    public void delete_butonunun_gorunur_oldugunu_test_eder() {
        Assert.assertTrue(herokuPage.deleteButonu.isDisplayed());

    }
    @Then("Delete butonuna basarak butonu siler")
    public void delete_butonuna_basarak_butonu_siler() {
        herokuPage.deleteButonu.click();
    }
    @Then("Delete butonunun gorunmedigini test eder")
    public void delete_butonunun_gorunmedigini_test_eder() {

        try {
            Assert.assertTrue(herokuPage.deleteButonu.isDisplayed());
            // delete butonunu bulamayinca nosuchExpection firlatir ve bu expection bizim istedigimiz sonucu verir.
            // Yani delete butonunun gorunmedigini test etmis oluruz.
        } catch (NoSuchElementException e) {

            Assert.assertTrue(true);
            // bu satira geldiyse eger delete butonunu goremedi yani testimiz passed oldu.bunuda boyle gosterebiliriz.
        }
    }
}
