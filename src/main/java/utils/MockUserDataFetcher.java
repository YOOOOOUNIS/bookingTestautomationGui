package utils;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;


public class MockUserDataFetcher {

    public static UserData getUserData(int userIndex) {
        HttpResponse<JsonNode> response = Unirest.get("https://jsonplaceholder.typicode.com/users")
                .asJson();

        JSONArray users = response.getBody().getArray();

        if (userIndex < 0 || userIndex >= users.length()) {
            throw new IllegalArgumentException("User index out of range");
        }

        JSONObject user = users.getJSONObject(userIndex);
        String fullName = user.getString("name");
        String[] nameParts = fullName.split(" ");
        String firstName = nameParts[0];
        String lastName = nameParts.length > 1 ? nameParts[nameParts.length - 1] : "";

        String zipCode = user.getJSONObject("address").getString("zipcode");

        return new UserData(firstName, lastName, zipCode);
    }

    public static class UserData {
        private final String firstName;
        private final String lastName;
        private final String zipCode;

        public UserData(String firstName, String lastName, String zipCode) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.zipCode = zipCode;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getZipCode() {
            return zipCode;
        }
    }
}
