package Indexer.Utility;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class PostitParser {

    public static DataHolder getInfo(String address) throws URISyntaxException, MalformedURLException {
        URI uri = new URI("https",
                "postit.lt",
                "/data",
                "address="+address,
                null);
        URL url = uri.toURL();
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))
        ) {
            Gson gson = new GsonBuilder().create();
            return gson.fromJson(in,DataHolder.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new DataHolder();
    }


}
