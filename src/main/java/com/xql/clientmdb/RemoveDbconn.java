package com.xql.clientmdb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;

public class RemoveDbconn {
    private String baseUrl;
    private String url;
    private String dbconn;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDbconn() {
        return dbconn;
    }

    public void setDbconn(String dbconn) {
        this.dbconn = dbconn;
    }

    public String toJsonString() {
        HashMap<String, String> queryMap = new HashMap<String, String>();

        queryMap.put("dbconn", this.dbconn);

        String jsonStr = "";
        JSONObject queryObj = new JSONObject(queryMap);
        jsonStr = queryObj.toString();

        return jsonStr;
    }

    public String removeDbconnX() {
        String responseBody = "";

        // https://www.appsdeveloperblog.com/execute-an-http-delete-request-in-java/

        String uri = "";
        uri = this.url + "/" + this.dbconn;
        System.out.println("uri: " + uri);
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpDelete httpDelete = new HttpDelete(uri);
            System.out.println("Executing request " + httpDelete.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                @Override
                public String handleResponse(final HttpResponse response)
                        throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils
                                .toString(entity) : null;
                    } else {
                        throw new ClientProtocolException(
                                "Unexpected response status: " + status);
                    }
                }

            };
            responseBody = httpclient.execute(httpDelete,
                    responseHandler);
            System.out.println(responseBody);

            // HttpUriRequest request = RequestBuilder.delete()
            // .setUri(uri)
            // .setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
            // .setHeader("Authorization", "Bearer 123token")
            // .build();

            // System.out.println("Executing DELETE request...");
            // HttpResponse response = httpclient.execute(request);

            // System.out.println("Status code: " +
            // response.getStatusLine().getStatusCode());

            // String responseString = new BasicResponseHandler().handleResponse(response);

            // System.out.println("Response: " + responseString);
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        }

        return responseBody;
    }

    public String encodeURL(String path) {
        String encPath = "";
        if (path.length() == 0) {
            // nothing to be done
        } else if (path.equals("/")) {
            // only one character '/'; done; length 1
            encPath = "/";
        } else if (path.substring(0, 1).equals("/")) {
            // begins with '/'; length more than 1
            encPath = "/";
            String nextpath = path.substring(1);
            while (true) {
                String[] paths = nextpath.split("/");
                // System.out.println("paths[0]: " + paths[0]);
                try {
                    encPath = encPath + URLEncoder.encode(paths[0], "UTF-8");
                } catch (UnsupportedEncodingException ex) {
                    System.out.println("UnsupportedEncodingException: " + ex.getMessage());
                    System.exit(0);
                }
                int slashIndex = nextpath.indexOf("/");
                // System.out.println("slashIndex: " + slashIndex);
                if (slashIndex == -1) {
                    break;
                } else {
                    encPath = encPath + "/";
                    nextpath = nextpath.substring(slashIndex + 1);
                }
            }
        } else {
            String nextpath = path.substring(0);
            while (true) {
                String[] paths = nextpath.split("/");
                // System.out.println("paths[0]: " + paths[0]);
                try {
                    encPath = encPath + URLEncoder.encode(paths[0], "UTF-8");
                } catch (UnsupportedEncodingException ex) {
                    System.out.println("UnsupportedEncodingException: " + ex.getMessage());
                    System.exit(0);
                }
                int slashIndex = nextpath.indexOf("/");
                if (slashIndex == -1) {
                    break;
                } else {
                    encPath = encPath + "/";
                    nextpath = nextpath.substring(slashIndex + 1);
                }
            }
        }
        String spacePath = encPath.replaceAll("[+]", "%20");

        return spacePath;
    }

    public String removeDbconn() {
        String responseBody = "";
        String uri = "";
        if (this.dbconn != null) {
            uri = this.url + this.dbconn;
        } else {
            uri = this.url;
        }

        int len = baseUrl.length();
        String path = uri.substring(len);
        System.out.println("path: " + path);

        String encPath = encodeURL(path);
        System.out.println("encPath: " + encPath);

        uri = baseUrl + encPath;

        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            System.out.println("DELETE " + uri);
            System.out.println();
            HttpDelete httpDelete = new HttpDelete(uri);
            System.out.println("Executing request " + httpDelete.getRequestLine());
            // Create a custom response handler
            HttpResponse response = httpclient.execute(httpDelete);
            BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            System.out.println("status code: " + response.getStatusLine().getStatusCode());

            StringBuffer result = new StringBuffer();
            String line = "";
            System.out.println("Response: ");
            while ((line = br.readLine()) != null) {
                System.out.println(result.append(line));
            }
            responseBody = result.toString();
        } catch (ClientProtocolException ex) {
            System.out.println("ClientProtocolException: " + ex.getMessage());
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
            ex.printStackTrace();
        }

        return responseBody;
    }

}
