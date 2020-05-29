package macquariebank;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class InterviewTest3 {
    public static void main(String args[]) {
//        http://localhost:9090/auth
        String param = "fields=id,correlatedCustomText9,employeeType,dateBegin,dateEnd&where=candidate.id=760709";

        try{
//            callAPI(param);
            getToken(param);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    /*
    Third question is hardest, cresting a REST API Call using Java.IO
    Given the time constraint and limitations to use API, it’s pretty difficult.
    It’s not as easy just to call a REST API using Java IO,  but it involves some operations on JSON response as well.
     */

    private static void getToken(String param) throws MalformedURLException, URISyntaxException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String url = "https://rest91.bullhornstaffing.com/rest-services/2ic61/query/Placement?";

        url += param +"&BhRestToken=d97e5464-9fe9-4760-ba30-6559c8608384";

        System.out.println(url);
        URI restURL = new URI(url);

        HttpGet getRequest = new HttpGet(restURL);
        getRequest.setHeader("Accept", "application/json");
        getRequest.setHeader("Content-Type", "application/json;charset=UTF-8");
        getRequest.setHeader("Accept-Language", "en-US,en;q=0.5");
        getRequest.setHeader("Accept-Encoding", "gzip, deflate");
//        getRequest.setHeader("Authorization", "bearer " + "d97e5464-9fe9-4760-ba30-6559c8608384");

//        this.buildBody(getRequest);

        try {
            CloseableHttpResponse response = httpclient.execute(getRequest);
            HttpEntity responseEntity = response.getEntity();
            String json = EntityUtils.toString(responseEntity);

            JSONObject object = new JSONObject(json);
            JSONArray nameArray = object.names();
            JSONArray valueArray = object.toJSONArray(nameArray);

            Map<String, String> result = new HashMap<>();
            for (int i = 0; i < valueArray.length(); i++) {
                result.put(nameArray.getString(i), valueArray.get(i).toString());
                System.out.println(nameArray.getString(i) +": "+valueArray.get(i).toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void callAPI(String param) throws IOException {
        String url = "https://rest91.bullhornstaffing.com/rest-services/2ic61/query/Placement?";
        url += param;
        URL restURL = new URL(url);

        HttpURLConnection httpConn = (HttpURLConnection) restURL.openConnection();

        httpConn.setRequestMethod("GET");
        httpConn.setRequestProperty("Accept", "application/json");
        httpConn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
        httpConn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        httpConn.setRequestProperty("Accept-Encoding", "gzip, deflate");
        httpConn.setRequestProperty("Authorization", "bearer " + "cce075fe-7bbf-4fdc-8cb6-690e618454a6");
        httpConn.setDoInput(true);

        InputStreamReader reader = new InputStreamReader(httpConn.getInputStream());

        BufferedReader respBuffer = new BufferedReader(reader);
        String output;
        System.out.println("Output from Server:  \n");
        while ((output = respBuffer.readLine()) != null) {
            System.out.println(output);
        }
        httpConn.disconnect();
    }
}