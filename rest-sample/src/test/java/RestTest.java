import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.sun.net.httpserver.Headers;
import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.testng.AssertJUnit.assertEquals;

public class RestTest {

    final String baseUrl = "http://localhost/mantis/";
    final String apiToken = "K_yAHD3aqx3VV_9ds70j-sn3Dyrs3VqQ";
    @Test
    public void testCreateIssue() throws IOException {
        Set<Issue> oldIssues = getIssues();
        Issue newIssue = new Issue().withSummary("FU").withDescription("Yeah yeah yeah").withCategory(new Category().withName("General")).withProject(new Project().withName("Test project 1"));
        List<Integer> ids = createIssue(newIssue);
        int issueId = ids.get(0);
        int projectId = ids.get(1);
        Set<Issue> newIssues = getIssues();
        oldIssues.add(newIssue.withId(issueId)
                .withProject(newIssue.getProject().withId(projectId)));
        assertEquals(newIssues, oldIssues);
    }

    private List<Integer> createIssue(Issue newIssue) throws IOException {




        Gson gson = new Gson();
        String body = gson.toJson(newIssue);

//        CloseableHttpClient client = HttpClients.createDefault();
//            HttpPost request = new HttpPost(baseUrl + "api/rest/issues");
//            request.addHeader("Authorization", "K_yAHD3aqx3VV_9ds70j-sn3Dyrs3VqQ");
//            request.setEntity(new StringEntity(body));
//        System.out.println(request.toString());
//
//            CloseableHttpResponse response = client.execute(request);
//            JsonReader jsonReader = gson.newJsonReader(new InputStreamReader(
//                    response.getEntity().getContent()
//            ));
        String json = Request.Post(baseUrl + "api/rest/issues")
                .addHeader("Authorization", apiToken)
                .bodyString(body, ContentType.APPLICATION_JSON)
                .execute().returnContent().asString();
        JsonElement parsed = new JsonParser().parse(json);
        int issueId = parsed.getAsJsonObject()
                .getAsJsonObject("issue")
                .get("id")
                .getAsInt();
        int projectId = parsed.getAsJsonObject()
                .getAsJsonObject("issue")
                .getAsJsonObject("project")
                .get("id")
                .getAsInt();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(issueId);
        ids.add(projectId);

        return ids;
    }

    private Set<Issue> getIssues() throws IOException {
        String json = Request.Get(baseUrl + "api/rest/issues").addHeader("Authorization", apiToken).execute().returnContent().asString();
        JsonElement parsed = new JsonParser().parse(json);
        JsonElement issues = parsed.getAsJsonObject().get("issues");
        return new Gson().fromJson(issues, new TypeToken<Set<Issue>>(){}.getType());
    }


}
