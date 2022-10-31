import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.http.client.fluent.Request;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    protected final Properties properties = new Properties();

    @BeforeSuite
    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
    }

    public void skipIfNotFixed(int issueId) throws IOException {
        if (isIssueOpen(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }

    protected boolean isIssueOpen(int issueId) throws IOException {
        String json = Request.Get(properties.getProperty("web.baseUrl") + "api/rest/issues/" + issueId).addHeader("Authorization", properties.getProperty("web.apiToken")).execute().returnContent().asString();
        JsonElement parsed = new JsonParser().parse(json);
        String  issueStatus = parsed.getAsJsonObject().get("issues").getAsJsonArray().get(0).getAsJsonObject().getAsJsonObject("status").get("name").getAsString();
        System.out.println(issueStatus);
        return !"closed".equals(issueStatus);
    }
}
