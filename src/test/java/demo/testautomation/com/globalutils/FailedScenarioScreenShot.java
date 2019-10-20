package demo.testautomation.com.globalutils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

/**
 * Captures the screen shot of the failed test cases and appends with test scenario name
 */
public class FailedScenarioScreenShot extends BaseUIPageObject<FailedScenarioScreenShot> {

    public void getScreenShotOfFailedTest(final String testScenarioName) {

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShot = takesScreenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileHandler.copy(screenShot,
                    new File("C:\\Users\\sball\\IdeaProjects\\testautomation\\src\\test\\screenshots\\" + testScenarioName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
