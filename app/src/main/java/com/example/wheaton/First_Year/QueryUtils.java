package com.example.wheaton.First_Year;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

public final class QueryUtils {

    private static final String LOG_TAG = QueryUtils.class.getSimpleName();

    // Create a private constructor because no one should ever create a {@link QueryUtils} object.
    private QueryUtils() {
    }


    public static ArrayList<clubs_class> fetchClubData(String requestUrl) {
        // Create URL object
        URL url = createUrl(requestUrl);

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error closing input stream", e);
        }

        ArrayList<clubs_class> clubs = new ArrayList<>();

        // Extract relevant fields from the JSON response and create an {@link Event} object
        clubs = extractFeatureFromJson(jsonResponse);

        // Return the {@link ArrayList<clubs_class>}
        return clubs;
    }

     // Returns new URL object from the given string URL.
    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Error with creating URL ", e);
        }
        return url;
    }

    // Make an HTTP request to the given URL and return a String as the response.
    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        // If the URL is null, then return early.
        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the earthquake JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    //Convert the {@link InputStream} into a String which contains the whole JSON response from the server.
    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    // Return a list of {@link clubs_class} objects that has been built up from parsing a JSON response.
    public static ArrayList<clubs_class> extractFeatureFromJson(String jsonString) {

        // Create ArrayList
        ArrayList<clubs_class> clubs = new ArrayList<>();

        try {
            JSONObject baseJsonResponse = new JSONObject(jsonString);
            JSONArray valuesArray = baseJsonResponse.getJSONArray("value");

            // If there are results in the values array
            if (valuesArray.length() > 0) {
                int i;
                int size = valuesArray.length();

                // Loop to get all earthquakes from json file
                for(i = 0; i < size; i++){
                    // Extract out the first feature (which is an earthquake)
                    JSONObject firstClub = valuesArray.getJSONObject(i);

                    // Extract out the name and decription of the club
                    String club_name = firstClub.getString("Name");
                    String club_description = firstClub.getString("Summary");

                    // If the description is empty extract the summary of the club
                    if(club_description.equals("")){
                        club_description = firstClub.getString("Description");
                    }

                    // Extract picture of the club
                    String club_picture = "https://seinfrafiles.blob.core.windows.net/images/" + firstClub.getString("ProfilePicture");

                    // Add each club in the json file to the array list
                    clubs.add(new clubs_class(club_picture, club_name, club_description));
                }
            }
        } catch (JSONException e) {
            Log.e(LOG_TAG, "Problem parsing the earthquake JSON results", e);
        }

        // Return the list of earthquakes
        return clubs;
    }
}
