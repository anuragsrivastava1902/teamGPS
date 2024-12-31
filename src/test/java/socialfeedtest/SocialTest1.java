package socialfeedtest;

import basetest.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.homepage.HomePage;
import pages.homepage.socialfeed.SocialFeedPage;

import java.util.List;

public class SocialTest1 extends BaseTest {

    @BeforeClass
    public void commonState() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSocialFeed();
    }

@Test
    public void click() throws InterruptedException {
    HomePage homePage = new HomePage(driver);
    homePage.clickOnSocialFeed();
    SocialFeedPage socialFeed= new SocialFeedPage(driver);
    Thread.sleep(4000);
    socialFeed.clickOnImageIcon();
    Thread.sleep(2000);
    socialFeed.uploadFile();
    Thread.sleep(10000);
//    socialFeed.uploadFile("C:\\Users\\hp\\Pictures\\as.jpg");

}
    @Test(priority = 1)
    public void shoutoutToSingleRecipient() throws InterruptedException {

        SocialFeedPage socialFeed= new SocialFeedPage(driver);
        Thread.sleep(5000);
        socialFeed.clickOnAddPointsIcon();
        socialFeed.clickOnAddEmployee();
        socialFeed.selectNameFromDropdown("Tanishk Patidar");
        socialFeed.clickAddHastag();
        socialFeed.selectTagFromDropdown("#Humility");
        socialFeed.clickAddEmoji();
        socialFeed.selectEmoji("\uD83D\uDE1C");
        socialFeed.clickAddEmoji();
        socialFeed.selectEmoji("\uD83D\uDE00");
        socialFeed.clickAddGif();
//        socialFeed.searchGif("welcome");
        socialFeed.selectGif(0);
        socialFeed.clickAddGif();
        Thread.sleep(2000);
        socialFeed.selectGif(1);
        socialFeed.clickGiveShoutoutsbutton();
        Thread.sleep(10000);

    }

    @Test
    public void testGetShoutoutCards() throws InterruptedException {
        SocialFeedPage socialFeed= new SocialFeedPage(driver);
        Thread.sleep(5000);
        List<WebElement> shoutoutCards = socialFeed.getAllShoutoutCards();
        for (WebElement card : shoutoutCards) {
            System.out.println(card.getText());
        }
    }
    @Test
    public void getfirstshoutoutcard() throws InterruptedException {
        SocialFeedPage socialFeed= new SocialFeedPage(driver);
        Thread.sleep(5000);
        WebElement firstCard = socialFeed.getFirstShoutoutCard();
        Assert.assertNotNull(firstCard, "First shoutout card should not be null");
        System.out.println("First Shoutout Card Text: " + firstCard.getText());
        Thread.sleep(3000);


    }


    @Test
    public void invalidcharactercheck() throws InterruptedException {
        SocialFeedPage socialFeed= new SocialFeedPage(driver);
        Thread.sleep(5000);
        socialFeed.charactercheck("3254365475687<?><>?<?><?:<?:<?:<?:<?:<?>:<?:<?:<");
        Thread.sleep(2000);
        socialFeed.clickGiveShoutoutsbutton();
        Thread.sleep(10000);
    }
    @Test
    public void pointallocationlimitcheck() throws InterruptedException {
        SocialFeedPage socialFeed= new SocialFeedPage(driver);
        Thread.sleep(5000);
        socialFeed.charactercheck("+600");
        socialFeed.clickOnAddEmployee();
        socialFeed.selectNameFromDropdown("Tanishk Patidar");
        socialFeed.clickAddHastag();
        socialFeed.selectTagFromDropdown("#Humility");
        socialFeed.clickGiveShoutoutsbutton();
        Thread.sleep(10000);
    }
    @Test
    public void pointallocationcheckmultiplerecipient() throws InterruptedException {
        SocialFeedPage socialFeed= new SocialFeedPage(driver);
        Thread.sleep(5000);
        socialFeed.charactercheck("+600");
        socialFeed.clickOnAddEmployee();
        socialFeed.selectNameFromDropdown("Tanishk Patidar");
        socialFeed.clickOnAddEmployee();
        socialFeed.selectNameFromDropdown("Anshul Uniyal");
        socialFeed.clickAddHastag();
        socialFeed.selectTagFromDropdown("#Humility");
        socialFeed.clickAddHastag();
        socialFeed.clickGiveShoutoutsbutton();
        Thread.sleep(5000);

    }

    @Test
    public void notabletoshoutoutwithouthastag() throws InterruptedException {
        SocialFeedPage socialFeed= new SocialFeedPage(driver);
        Thread.sleep(5000);
        socialFeed.clickOnAddPointsIcon();
        socialFeed.clickOnAddEmployee();
        socialFeed.selectNameFromDropdown("Tanishk Patidar");
        socialFeed.clickAddEmoji();
        socialFeed.selectEmoji("\uD83D\uDE1C");
        socialFeed.clickAddEmoji();
        socialFeed.selectEmoji("\uD83D\uDE00");
        socialFeed.clickAddGif();
        socialFeed.selectGif(0);
        socialFeed.clickAddGif();
        Thread.sleep(2000);
        socialFeed.selectGif(1);
        socialFeed.clickGiveShoutoutsbutton();
        Thread.sleep(10000);

    }

@Test(priority = 2)
    public void shoutoutToMultipleRecipient() throws InterruptedException {
    SocialFeedPage socialFeed= new SocialFeedPage(driver);
        Thread.sleep(40000);
        socialFeed.clickOnAddPointsIcon();
        socialFeed.clickOnAddEmployee();
        socialFeed.selectNameFromDropdown("Tanishk Patidar");
        socialFeed.clickOnAddEmployee();
        socialFeed.selectNameFromDropdown("Anshul Uniyal");
        socialFeed.clickAddHastag();
        socialFeed.selectTagFromDropdown("#Humility");
        socialFeed.clickAddHastag();
        socialFeed.selectTagFromDropdown("#Accountability");
        socialFeed.clickAddEmoji();
        socialFeed.selectEmoji("\uD83D\uDE1C");
        socialFeed.clickAddGif();
        socialFeed.selectGif(0);
        socialFeed.clickGiveShoutoutsbutton();
        Thread.sleep(10000);
    }

    @Test
    public void shoutoutGivenFilterList() throws InterruptedException {
        SocialFeedPage socialFeed= new SocialFeedPage(driver);
        Thread.sleep(10000);
        socialFeed.clickAllShoutoutsDropown("Given");
        Thread.sleep(5000);
    }
    @Test
    public void shoutoutReceivedFilterList() throws InterruptedException {
        SocialFeedPage socialFeed= new SocialFeedPage(driver);        Thread.sleep(10000);
        socialFeed.clickAllShoutoutsDropown("Received");
        Thread.sleep(5000);
    }
    @Test
    public void departmentsDropdownFilterList() throws InterruptedException {
        SocialFeedPage socialFeed= new SocialFeedPage(driver);        Thread.sleep(5000);
        socialFeed.clickDepartmentsDropdown("Test");
        Thread.sleep(5000);
    }
    @Test
    public void ReactionToShoutout() throws InterruptedException {
        SocialFeedPage socialFeed= new SocialFeedPage(driver);
        Thread.sleep(5000);
        socialFeed.giveReactionToShoutout("😀, grinning");
        Thread.sleep(4000);
    }
    @Test
    public void addcommenttoshoutout() throws InterruptedException {
        SocialFeedPage socialFeed= new SocialFeedPage(driver);
        Thread.sleep(4000);
        socialFeed.clickAddComment();
        Thread.sleep(2000);
        socialFeed.writeComment("Good Job!");
        Thread.sleep(2000);
        socialFeed.clickSubmitComment();

        // Upload a file if needed (adjust file path accordingly)
//        String filePath = "C:\\path\\to\\your\\image.jpg";
//        socialFeed.uploadFile(filePath);
//        Thread.sleep(2000);

        // Submit the comment
//        socialFeed.submitComment();
        Thread.sleep(5000);
    }
    @Test
    public void deletecomment() throws InterruptedException {
        SocialFeedPage socialFeed= new SocialFeedPage(driver);
        Thread.sleep(4000);
        socialFeed.deletecommentstoshoutout();
        Thread.sleep(3000);
    }
    @Test
    public void pointsthroughcommentsinshoutout() throws InterruptedException {
        SocialFeedPage socialFeed= new SocialFeedPage(driver);
        Thread.sleep(4000);
        socialFeed.clickAddComment();
        Thread.sleep(1000);
        socialFeed.addpointtocomment();
        Thread.sleep(4000);
        socialFeed.addinghastagtocomment();
        socialFeed.selectTagFromDropdown("#Humility");
        Thread.sleep(4000);
        socialFeed.clickSubmitComment();
        Thread.sleep(4000);
    }
    @Test
    public void shoutoutdelete() throws InterruptedException {
        SocialFeedPage socialFeed= new SocialFeedPage(driver);
        Thread.sleep(5000);
        socialFeed.shoutoutsdelete();
        Thread.sleep(4000);
    }
    @Test
    public void deleteshoutoutolderthansevenhours() throws InterruptedException {
        SocialFeedPage socialFeed= new SocialFeedPage(driver);
        Thread.sleep(5000);
        socialFeed.deleteShoutoutsOlderThan7Hours();
        Thread.sleep(4000);

    }
    @Test
    public void scrollthroguhlist() throws InterruptedException {
        SocialFeedPage socialFeed= new SocialFeedPage(driver);
        Thread.sleep(5000);
        socialFeed.scrollToEndOfPage();
        Thread.sleep(4000);
    }

    }


