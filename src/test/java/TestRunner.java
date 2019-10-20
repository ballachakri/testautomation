import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test",
        tags = {},
        plugin = {"json:src/test/jsonfile.json",
                "html:src/test/reports/cucumberReport.html"})
public class TestRunner {
}