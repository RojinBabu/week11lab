package com.rojin.flightstatus;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainApp {

    // Set your API URL and API Key
    private static final String API_URL = "https://api.aviationstack.com/v1/flights"; // Replace with your API URL
    private static final String API_KEY = "63841875fa696ed14580997da3eb7b93"; // Replace with your actual API key

    public static void main(String[] args) {
        try {
            // Call the API to get flight data for a specific flight (e.g., "AB123")
            String flightNumber = "sq296";  // Example flight number
            String jsonResponse = getFlightData(flightNumber);

            // Print the API response to the console
            System.out.println("API Response: " + jsonResponse);

        } catch (Exception e) {
            // Handle any exceptions and print the error
            e.printStackTrace();
        }
    }

    // Method to fetch flight data
    public static String getFlightData(String flightNumber) throws Exception {
        // Construct the URL with the API key and flight number
        String urlString = API_URL + "?access_key=" + API_KEY + "&flight_iata=" + flightNumber;
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET"); // Set HTTP method to GET

        // Read the response from the API
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close(); // Close the connection

        // Return the response as a string (the API response)
        return response.toString();
    }
}
