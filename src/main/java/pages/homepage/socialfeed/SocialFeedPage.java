package pages.homepage.socialfeed;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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
    By addpointstocomment = By.cssSelector("div[ngbtooltip='Add more points']");
    By addhastagtocomment = By.cssSelector("div[ngbtooltip='Hashtag']");
    By addemojitocomment = By.xpath("(//div[@class='footer-reactions-col'])[6]");
    By socialFeedAction = By.cssSelector("button[class='btn btn-outline-primary']");
    By socialFeedActionClose = By.cssSelector(".close.focused");
    By socialFeedSubmit = By.cssSelector("button[type='submit']");
    By deletecommenttoshoutout = By.cssSelector(".px-1.feed-delete");
    By submitcomment = By.xpath("//button[normalize-space()='Add']");
    By shoutoutdelete = By.cssSelector("div[class='feed-list-card feedListDiv4885'] div[class='d-flex'] div[class='feed-detail-row'] div[class='feed-detail-header'] div img[alt='edit-icon']");
    By textvalidationcheck = By.xpath("//textarea[@id='createFeedDiv']");

    public void clickOnAddPointsIcon() throws InterruptedException {
        WebElement addpoint = wait.until(ExpectedConditions.elementToBeClickable(addPointsIcon));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", addpoint);

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
            // Wait and click on the 'tag user' button (change the selector if needed)
            WebElement element = driver.findElement(By.xpath("//div[@class='feed-list-layout']//div[@class='footer-reactions-row']//div[1]//img[1]"));
            element.click();
            System.out.println("Element is clicked");
            // Wait for the dropdown to appear
            WebElement userDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mention-menu")));

            // Find the user you want to tag (search by name)
            WebElement user = userDropdown.findElement(By.xpath("//span[text()='" + userName + "']"));

            // Click on the user
            user.click();
        } catch (Exception e) {
            System.err.println("Error while tagging user: " + e.getMessage());
        }
    }

    public void addpointtocomment() {
        wait.until(ExpectedConditions.elementToBeClickable(addpointstocomment)).click();
        wait.until(ExpectedConditions.elementToBeClickable(specificOption)).click();
    }

    public void addinghastagtocomment() {
        wait.until(ExpectedConditions.elementToBeClickable(addhastagtocomment)).click();
    }

    public void addingEmojiToComment(String emojiName) {
        try {
            // Step 1: Click to open the emoji picker
            wait.until(ExpectedConditions.elementToBeClickable(addemojitocomment)).click();

            // Step 2: Wait for the emoji picker to become visible
            WebElement emojiPicker = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='emoji-mart']")));

            // Step 3: Locate and click the specified emoji
            String emojiXPath = "//section[@class='emoji-mart-scroll']//span[contains(@aria-label, '" + emojiName + "')]";
            WebElement emoji = emojiPicker.findElement(By.xpath(emojiXPath));
            emoji.click();

        } catch (Exception e) {
            System.err.println("Error while adding emoji to comment: " + e.getMessage());
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
        wait.until(ExpectedConditions.elementToBeClickable(submitcomment)).click();
    }

    public void clickOnRedeemPointsButton() {
        WebElement redeemPointsButtonElement = wait.until(ExpectedConditions.elementToBeClickable(redeemPointsButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", redeemPointsButtonElement);
    }

    public void deletecommentstoshoutout() {
        wait.until(ExpectedConditions.elementToBeClickable(deletecommenttoshoutout)).click();
        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        confirmButton.click();

    }

    public void shoutoutsdelete() {
        wait.until(ExpectedConditions.elementToBeClickable(shoutoutdelete)).click();
        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='dropdown-menu show']//button[@class='dropdown-item'][normalize-space()='Delete']")));
        confirmButton.click();

        WebElement yesbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Yes']")));
        yesbutton.click();
    }

//    public void scrollToCardFeed() {
//        try {
//            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(cardfeedscroll));
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", element);
//        } catch (Exception e) {
//            System.err.println("Error while scrolling to the card feed: " + e.getMessage());
//        }
//    }

    //public void scrollToCardFeed() {
//    try {
//        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(cardfeedscroll));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", element);
//    } catch (Exception e) {
//        System.err.println("Error while scrolling to the end: " + e.getMessage());
//    }
//}
    public void scrollToPageBottom() {
        try {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        } catch (Exception e) {
            System.err.println("Error while scrolling to the bottom of the page: " + e.getMessage());
        }
    }

    public void scrollToEndOfPage() {
        try {
            long lastHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");

            while (true) {
                // Scroll down to the bottom of the page
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

                // Wait for the page to load new content
                Thread.sleep(2000); // Adjust the wait time based on the page's behavior

                // Get the new height of the page
                long newHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");

                // Break the loop if no new content is loaded
                if (newHeight == lastHeight) {
                    System.out.println("Reached the end of the page.");
                    break;
                }

                lastHeight = newHeight; // Update the height for the next iteration
            }
        } catch (InterruptedException e) {
            System.err.println("Error while scrolling to the end of the page: " + e.getMessage());
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }

    public void charactercheck(String inputText) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(textvalidationcheck));
            element.click();
//            element.sendKeys("3254365475687<?><>?<?><?:<?:<?:<?:<?:<?>:<?:<?:<");
            element.sendKeys(inputText);
        } catch (Exception e) {
            System.err.println("Error while sending text: " + e.getMessage());
        }


    }

    public void deleteShoutoutIfOlderThan7Hours(WebElement shoutoutTimeElement, WebElement shoutoutDeleteButton) {
        // Get the timestamp of the shoutout (this should be fetched from the web element)
        String shoutoutTimeText = shoutoutTimeElement.getText(); // e.g., "2 days ago"

        // Convert the shoutout time to a LocalDateTime (example: shoutoutTimeText could be "2 days ago")
        LocalDateTime shoutoutTime = parseShoutoutTime(shoutoutTimeText);
        LocalDateTime currentTime = LocalDateTime.now();

        // Calculate the difference in hours between the current time and the shoutout time
        long hoursDifference = ChronoUnit.HOURS.between(shoutoutTime, currentTime);

        // Check if the shoutout is older than 7 hours
        if (hoursDifference > 7) {
            // Use the already defined shoutoutsdelete() method to delete the shoutout
            shoutoutsdelete();

            // Handle the validation message after the shoutout is deleted
            WebElement validationMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='validation-message']")));
            String validationMessage = validationMessageElement.getText();

            // Log or assert the validation message for verification
            System.out.println(validationMessage);  // Example: "Shoutout has been deleted successfully. Points not reverted as seven hours have passed."
        } else {
            System.out.println("Shoutout is not older than 7 hours. Deletion not performed.");
        }
    }

    private LocalDateTime parseShoutoutTime(String shoutoutTimeText) {
        // Convert the shoutout time to LocalDateTime, e.g., "2 days ago" -> LocalDateTime
        // This method should handle different time formats based on the application's response
        // For now, assuming a simple time difference
        if (shoutoutTimeText.contains("days ago")) {
            int days = Integer.parseInt(shoutoutTimeText.split(" ")[0]);
            return LocalDateTime.now().minusDays(days);
        } else if (shoutoutTimeText.contains("hours ago")) {
            int hours = Integer.parseInt(shoutoutTimeText.split(" ")[0]);
            return LocalDateTime.now().minusHours(hours);
        } else if (shoutoutTimeText.contains("minutes ago")) {
            int minutes = Integer.parseInt(shoutoutTimeText.split(" ")[0]);
            return LocalDateTime.now().minusMinutes(minutes);
        }

        // Default to current time if parsing fails (this should be extended for other formats)
        return LocalDateTime.now();
    }


    }



