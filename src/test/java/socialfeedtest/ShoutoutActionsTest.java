//package socialfeedtest;
//
//import basetest.BaseTest;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import pages.homepage.HomePage;
//import pages.homepage.socialfeed.SocialFeedPage;
//
//public class ShoutoutActionsTest extends BaseTest {
//
//    @BeforeClass
//    public void commonState() throws InterruptedException {
//        HomePage homePage = new HomePage(driver);
//        homePage.clickOnSocialFeed();
//    }
//
//    @Test(priority = 1)
//    public void reactionToShoutout() throws InterruptedException {
//        SocialFeedPage socialFeed= new SocialFeedPage(driver);
//        Thread.sleep(5000);
//        socialFeed.giveReactionToShoutout("😀, grinning");
//        Thread.sleep(5000);
//    }
//    @Test(priority = 2)
//    public void removereactiontoshoutut() throws InterruptedException {
//        SocialFeedPage socialFeed= new SocialFeedPage(driver);
//        Thread.sleep(5000);
//        socialFeed.Removereactiontoshoutut();
//        Thread.sleep(5000);
//
//
//    }
//    @Test(priority = 3)
//    public void addcommenttoshoutout() throws InterruptedException {
//        SocialFeedPage socialFeed= new SocialFeedPage(driver);
//        Thread.sleep(4000);
//        socialFeed.clickAddComment();
//        Thread.sleep(2000);
//        socialFeed.writeComment("Good Job!");
//        Thread.sleep(2000);
//        socialFeed.clickSubmitComment();
//
//        // Upload a file if needed (adjust file path accordingly)
////        String filePath = "C:\\path\\to\\your\\image.jpg";
////        socialFeed.uploadFile(filePath);
////        Thread.sleep(2000);
//
//        // Submit the comment
////        socialFeed.submitComment();
//        Thread.sleep(5000);
//    }
//    @Test
//    public void deletecomment() throws InterruptedException {
//        SocialFeedPage socialFeed= new SocialFeedPage(driver);
//        Thread.sleep(4000);
//        socialFeed.deletecommentstoshoutout();
//        Thread.sleep(3000);
//    }
//    @Test
//    public void pointsthroughcommentsinshoutout() throws InterruptedException {
//        SocialFeedPage socialFeed= new SocialFeedPage(driver);
//        Thread.sleep(4000);
//        socialFeed.clickAddComment();
//        Thread.sleep(1000);
//        socialFeed.addpointtocomment();
//        Thread.sleep(4000);
//        socialFeed.addinghastagtocomment();
//        socialFeed.selectTagFromDropdown("#Humility");
//        Thread.sleep(4000);
//        socialFeed.clickSubmitComment();
//        Thread.sleep(4000);
//    }
//    @Test
//    public void shoutoutdelete() throws InterruptedException {
//        SocialFeedPage socialFeed= new SocialFeedPage(driver);
//        Thread.sleep(5000);
//        socialFeed.shoutoutsdelete();
//        Thread.sleep(4000);
//    }
//    @Test
//    public void scrollthroguhlist() throws InterruptedException {
//        SocialFeedPage socialFeed= new SocialFeedPage(driver);
//        Thread.sleep(5000);
//        socialFeed.scrollToEndOfPage();
//        Thread.sleep(4000);
//    }
//
//    @Test
//    public void invalidcharactercheck() throws InterruptedException {
//        SocialFeedPage socialFeed= new SocialFeedPage(driver);
//        Thread.sleep(5000);
//        socialFeed.charactercheck("3254365475687<?><>?<?><?:<?:<?:<?:<?:<?>:<?:<?:<");
//        Thread.sleep(2000);
//        socialFeed.clickGiveShoutoutsbutton();
//        Thread.sleep(10000);
//    }
//}


package socialfeedtest;

import basetest.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.homepage.HomePage;
import pages.homepage.socialfeed.SocialFeedPage;

public class ShoutoutActionsTest extends BaseTest {

    @BeforeClass
    public void commonState() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSocialFeed();
    }

    @Test(priority = 1)
    public void reactionToShoutout() throws InterruptedException {
        SocialFeedPage socialFeed = new SocialFeedPage(driver);
        socialFeed.giveReactionToShoutout("😀, grinning");
        Thread.sleep(2000); // Wait for the action to reflect
    }

    @Test(priority = 2)
    public void removeReactionToShoutout() throws InterruptedException {
        SocialFeedPage socialFeed = new SocialFeedPage(driver);
        socialFeed.Removereactiontoshoutut();
        Thread.sleep(2000); // Wait for the reaction to be removed
    }

    @Test(priority = 3)
    public void addCommentToShoutout() throws InterruptedException {
        SocialFeedPage socialFeed = new SocialFeedPage(driver);
        socialFeed.clickAddComment();
        Thread.sleep(2000);
        socialFeed.writeComment("Good Job!");
        Thread.sleep(2000);
        socialFeed.clickSubmitComment();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void deleteComment() throws InterruptedException {
        SocialFeedPage socialFeed = new SocialFeedPage(driver);
        socialFeed.deletecommentstoshoutout();
        Thread.sleep(3000);
    }

    @Test(priority = 5)
    public void pointsThroughCommentsInShoutout() throws InterruptedException {
        SocialFeedPage socialFeed = new SocialFeedPage(driver);
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


    @Test(priority = 7)
    public void scrollThroughList() throws InterruptedException {
        SocialFeedPage socialFeed = new SocialFeedPage(driver);
        socialFeed.scrollToEndOfPage();
        Thread.sleep(2000); // Wait for scrolling to complete
    }

    @Test(priority = 6)
    public void invalidCharacterCheck() throws InterruptedException {
        SocialFeedPage socialFeed = new SocialFeedPage(driver);
        socialFeed.charactercheck("3254365475687<?><>?<?><?:<?:<?:<?:<?:<?>:<?:<?:<");
        socialFeed.clickGiveShoutoutsbutton();
        Thread.sleep(2000); // Wait for the action to complete
    }
}
