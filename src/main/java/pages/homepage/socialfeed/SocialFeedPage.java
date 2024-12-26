package pages.homepage.socialfeed;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class SocialFeedPage {
    WebDriver driver;
    WebDriverWait wait;

    public SocialFeedPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    //locators
    By createFeedBox = By.cssSelector(".create-feed-box");
    By addPointsIcon = By.cssSelector(".fa.fa-solid.fa-plus");
    By specificOption = By.xpath("//ul[contains(@class, 'dropdown-menu') and contains(@class, 'mention-menu')]//span[normalize-space()='+10']");
    By addEmployee = By.cssSelector(".fa.fa-solid.fa-user");
    By specificOptionEmployee = By.xpath("//ul[contains(@class, 'dropdown-menu') and contains(@class, 'mention-menu')]//span[normalize-space()='Anshul Uniyal']");
    By addHastag = By.cssSelector(".fa.fa-solid.fa-hashtag");
    By createFeed = By.cssSelector("#createFeedDiv");
    By tagUser = By.cssSelector("div[ngbtooltip='Tag a user']");
    By addEmoji = By.cssSelector("div[ngbtooltip='Add an emoji']");
    By addReactiontoShoutout = By.xpath("(//div[@class='feed-reactions-col'])[1]");
    By addGif = By.cssSelector("div[ngbtooltip='Add a gif']");
    //  By imgInputbutton =  By.xpath("//input[@id='image_file_input'])[1]");
    By imgInputbutton = By.xpath("(//span[@class='footer-reactions-label exOpt'])[2]");
    By giveShoutoutButton = By.cssSelector("button[class='btn btn-primary']");
    By allShoutoutsDropown = By.cssSelector("div[class='ng-select-container ng-has-value'] span[class='ng-arrow-wrapper']");
    By departmentsDropdown = By.cssSelector("div[class='ng-select-container'] span[class='ng-arrow-wrapper']");
    By redeemPointsButton = By.xpath("//app-social-feed-points-info[@class='isDesktop']//button[@id='redeem_Uguide']");
    By editShoutout = By.cssSelector("div[class='d-inline-block download-report-ui ng-star-inserted show dropdown'] img[alt='edit-icon']");
    By deleteDropdown = By.cssSelector(".dropdown-menu.show");
    By addComment = By.xpath("(//span[@class='d-none d-sm-inline-block'][normalize-space()='Comment'])[1]");
    By socialFeedAction = By.cssSelector("button[class='btn btn-outline-primary']");
    By socialFeedActionClose = By.cssSelector(".close.focused");
    By socialFeedSubmit = By.cssSelector("button[type='submit']");
    By submitComment = By.cssSelector("div[class='create-feed-layout comment-card-div ng-star-inserted'] button[class='btn btn-primary']");

    public void clickOnAddPointsIcon() throws InterruptedException {
       WebElement addpoint =  wait.until(ExpectedConditions.elementToBeClickable(addPointsIcon));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",addpoint);

        wait.until(ExpectedConditions.elementToBeClickable(specificOption)).click();
    }

    public void selectNameFromDropdown(String name) {

        By dropdownLocator = By.xpath("//ul[contains(@class, 'dropdown-menu') and contains(@class, 'mention-menu')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownLocator));

        By nameLocator = By.xpath("//ul[contains(@class, 'dropdown-menu') and contains(@class, 'mention-menu')]//span[contains(@class, 'font-weight-bold') and normalize-space(text())='" + name + "']");

        WebElement nameElement = wait.until(ExpectedConditions.elementToBeClickable(nameLocator));
        nameElement.click();
    }

    public void clickOnAddEmployee() {
        wait.until(ExpectedConditions.elementToBeClickable(addEmployee)).click();
    }

    public void clickAddHastag() {
        wait.until(ExpectedConditions.elementToBeClickable(addHastag)).click();
    }

    public void selectTagFromDropdown(String tagName) {
        // Wait for the dropdown to be visible
        By dropdownLocator = By.xpath("//ul[contains(@class, 'dropdown-menu') and contains(@class, 'mention-menu')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownLocator));

        // Build dynamic XPath for the tag
        By tagLocator = By.xpath("//ul[contains(@class, 'dropdown-menu') and contains(@class, 'mention-menu')]//span[normalize-space(text())='" + tagName + "']");

        // Click on the tag
        WebElement tagElement = wait.until(ExpectedConditions.elementToBeClickable(tagLocator));
        tagElement.click();
    }

    public void clickCreateFeed() {
        wait.until(ExpectedConditions.elementToBeClickable(createFeed)).click();
    }

    public void clickTagUser() {
        wait.until(ExpectedConditions.elementToBeClickable(tagUser)).click();
    }

    public void clickAddEmoji() {
        wait.until(ExpectedConditions.elementToBeClickable(addEmoji)).click();
    }

    public void selectEmoji(String emojiLabel) {
        By emojiLocator = By.xpath("//section[@aria-label='Frequently Used']//ngx-emoji//span[@aria-label[contains(., '" + emojiLabel + "')]]");
        WebElement emojiElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emojiLocator));
        emojiElement.click();
    }

    public void clickAddGif() {
        wait.until(ExpectedConditions.elementToBeClickable(addGif)).click();
    }

    public void searchGif(String searchQuery) {
        // Locate and enter search query
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input[placeholder='Search Gif']")
        ));
        searchInput.sendKeys(searchQuery);

        // Wait for results to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".gif-results-grid")));
    }

    public void selectGif(int gifIndex) {
        // Ensure the GIFs have loaded
        List<WebElement> gifItems = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".gif-item img")));
        // Click on the specified GIF by index
        if (gifIndex >= 0 && gifIndex < gifItems.size()) {
            gifItems.get(gifIndex).click();
        } else {
            System.out.println("Invalid GIF index.");
        }
    }

    public void scrollToLoadMoreGifs() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        // Scroll down the page to trigger loading of more GIFs
        jsExecutor.executeScript("window.scrollBy(0, document.body.scrollHeight)");

        // Wait for additional GIFs to load
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.cssSelector(".gif-item img"), 10 // Adjust number based on expected new GIFs
        ));
    }

    public void clickOnImageIcon() {
        // Locate the second <span> element containing the image icon and the file input
        WebElement iconContainer = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//span[@class='footer-reactions-label exOpt'])[2]")
        ));

        // Click on the <span> element that contains the image
        iconContainer.click();
    }
    public void uploadFile() {
        String filePath = "C:\\Users\\hp\\Pictures\\test.jpg"; // File path
        String autoITExe = "C:\\Users\\hp\\Desktop\\FileUpload.exe"; // Path to AutoIt executable

        try {
            // Print the file path to verify
            System.out.println("Uploading file: " + filePath);

            // Use ProcessBuilder to call the AutoIt script with the file path
            ProcessBuilder pb = new ProcessBuilder(autoITExe, filePath);
            pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void clickGiveShoutoutsbutton() {
        wait.until(ExpectedConditions.elementToBeClickable(giveShoutoutButton)).click();
    }
    public void clickAllShoutoutsDropown(String optionTitle) {
        wait.until(ExpectedConditions.elementToBeClickable(allShoutoutsDropown)).click();

        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[title='" + optionTitle + "']")));
        option.click();
    }
    public void clickDepartmentsDropdown(String optionTitle) {
        wait.until(ExpectedConditions.elementToBeClickable(departmentsDropdown)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ng-dropdown-panel[role='listbox']")));
        // Select the option using a dynamic CSS selector
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("div.ng-option span.ng-option-label")
        ));
        // Click on the selected option
        option.click();
    }

    public void giveReactionToShoutout(String emojiAriaLabel) {
    try {
        // Step 1: Open the emoji selection section
        wait.until(ExpectedConditions.elementToBeClickable(addReactiontoShoutout)).click();
        System.out.println("Opened the emoji selection section.");

        // Step 2: Wait for the emoji picker to be visible
        WebElement emojiSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section[aria-label='Frequently Used']")));
        System.out.println("Emoji selection section is visible.");
        WebElement emoji = emojiSection.findElement(By.cssSelector(
                String.format("span[aria-label='%s'] span", emojiAriaLabel)
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", emoji);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", emoji);
        System.out.println("Selected the emoji: " + emojiAriaLabel);

    } catch (NoSuchElementException e) {
        System.err.println("Emoji not found: " + emojiAriaLabel);
    } catch (TimeoutException e) {
        System.err.println("Timeout while waiting for emoji picker or emoji: " + emojiAriaLabel);
    } catch (Exception e) {
        System.err.println("Unexpected error: " + e.getMessage());
    }
}


    public void clickEditShoutout() {
        wait.until(ExpectedConditions.elementToBeClickable(editShoutout)).click();
    }

    public void clickDeleteShoutout() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteDropdown)).click();
    }

    public void clickAddComment() {
        wait.until(ExpectedConditions.elementToBeClickable(addComment)).click();
    }

    public void writeComment(String commentText) {
        try {
            // Assuming the comment box is already focused, directly send the keys to the already-clicked box
            driver.switchTo().activeElement().sendKeys(commentText);  // Sends the text directly to the focused element
        } catch (Exception e) {
            System.err.println("Error while writing comment: " + e.getMessage());
        }
        }

    // Tag a user dynamically
    public void tagUser(String userName) {
        try {
            WebElement commentBox = driver.findElement(By.cssSelector("div[contenteditable='true']"));
            commentBox.sendKeys("@");

            WebElement mentionList = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("ul.dropdown-menu.mention-menu")
            ));

            WebElement userToTag = mentionList.findElement(By.xpath("//span[text()='" + userName + "']"));
            userToTag.click();
        } catch (Exception e) {
            System.err.println("Error while tagging user: " + e.getMessage());
        }
    }

    // Add an emoji dynamically
    public void addEmoji(String emojiAriaLabel) {
        try {
            WebElement emojiButton = driver.findElement(By.cssSelector("div[ngbtooltip='Add an emoji']"));
            emojiButton.click();

            WebElement emoji = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("span[aria-label='" + emojiAriaLabel + "'] span")
            ));
            emoji.click();
        } catch (Exception e) {
            System.err.println("Error while adding emoji: " + e.getMessage());
        }
    }

    // Upload a file dynamically
    public void uploadFile(String filePath) {
        try {
            WebElement imageUploadInput = driver.findElement(By.id("image_file_input"));
            imageUploadInput.sendKeys(filePath);
        } catch (Exception e) {
            System.err.println("Error while uploading file: " + e.getMessage());
        }
    }

    // Submit the comment
    public void submitComment() {
        try {
            WebElement addButton = driver.findElement(By.cssSelector(".feed-btn .btn-primary"));
            addButton.click();
        } catch (Exception e) {
            System.err.println("Error while submitting comment: " + e.getMessage());
        }
    }

    // Combine all actions into one reusable method
    public void addCommentWithDetails(String commentText, String userName, String emojiAriaLabel, String filePath) {
        clickAddComment(); // Ensure comment box is open
        writeComment(commentText);
        tagUser(userName);
        addEmoji(emojiAriaLabel);
        uploadFile(filePath);
        submitComment();
    }

    public void clickSocialFeedAction() {
        wait.until(ExpectedConditions.elementToBeClickable(socialFeedAction)).click();
    }

    public void clickSocialFeedActionClose() {
        wait.until(ExpectedConditions.elementToBeClickable(socialFeedActionClose)).click();
    }

    public void clickSocialFeedSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(socialFeedSubmit)).click();
    }

    public void clickSubmitComment() {
        wait.until(ExpectedConditions.elementToBeClickable(submitComment)).click();
    }

    public void clickOnRedeemPointsButton() {
        WebElement redeemPointsButtonElement = wait.until(ExpectedConditions.elementToBeClickable(redeemPointsButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", redeemPointsButtonElement);
    }
}
