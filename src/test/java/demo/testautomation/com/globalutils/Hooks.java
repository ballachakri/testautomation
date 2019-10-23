package demo.testautomation.com.globalutils;


import cucumber.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



/**
 * The Hooks class will choose the Test Environment and executes before and after Tests
 */
public class Hooks extends BaseUIPageObject<Hooks> {
    /**
     * set up the browser type and configured Log4j framework for logging information
     */
    final static Logger logger = Logger.getLogger(Hooks.class);

    @Before
    public void navigateToHomePage()
    {
        BasicConfigurator.configure();
        PropertyConfigurator.configure("log4j.properties");
        setUpTheBrowser();
        maximizeBrowser();
        logger.info("Launched the Browser ...........!");
    }

    /**
     * Captures screen shot, if the test fails and close the browser.
     */
    @After
    public void closeTheBrowser(Scenario scenario) {
        final String scenarioName = scenario.getName();
        if (scenario.isFailed()) {
            new FailedScenarioScreenShot().getScreenShotOfFailedTest(scenarioName);
        }
        tearDown();
    }
}
