import java.util.*;
public class MailingAddress {
    private String street = null;
    private String secondStreet = null;
    private String town = null;
    private String state1 = null;
    private String zipcode = null;
    private static final Map<String, String> stateCodeToNameMap = new HashMap<>();

    private static final Map<String, String> stateNameToCodeMap = new HashMap<>();

    static {
        // Load US Codes.
        stateCodeToNameMap.put("AK", "Alaska");
        stateCodeToNameMap.put("AL", "Alabama");
        stateCodeToNameMap.put("AR", "Arkansas");
        stateCodeToNameMap.put("AZ", "Arizona");
        stateCodeToNameMap.put("CA", "California");
        stateCodeToNameMap.put("CO", "Colorado");
        stateCodeToNameMap.put("CT", "Connecticut");
        stateCodeToNameMap.put("DE", "Delaware");
        stateCodeToNameMap.put("FL", "Florida");
        stateCodeToNameMap.put("GA", "Georgia");
        stateCodeToNameMap.put("HI", "Hawaii");
        stateCodeToNameMap.put("IA", "Iowa");
        stateCodeToNameMap.put("ID", "Idaho");
        stateCodeToNameMap.put("IL", "Illinois");
        stateCodeToNameMap.put("IN", "Indiana");
        stateCodeToNameMap.put("KS", "Kansas");
        stateCodeToNameMap.put("KY", "Kentucky");
        stateCodeToNameMap.put("LA", "Louisiana");
        stateCodeToNameMap.put("MA", "Massachusetts");
        stateCodeToNameMap.put("MD", "Maryland");
        stateCodeToNameMap.put("ME", "Maine");
        stateCodeToNameMap.put("MI", "Michigan");
        stateCodeToNameMap.put("MN", "Minnesota");
        stateCodeToNameMap.put("MO", "Missouri");
        stateCodeToNameMap.put("MS", "Mississippi");
        stateCodeToNameMap.put("MT", "Montana");
        stateCodeToNameMap.put("NC", "North Carolina");
        stateCodeToNameMap.put("ND", "North Dakota");
        stateCodeToNameMap.put("NE", "Nebraska");
        stateCodeToNameMap.put("NH", "New Hampshire");
        stateCodeToNameMap.put("NJ", "New Jersey");
        stateCodeToNameMap.put("NM", "New Mexico");
        stateCodeToNameMap.put("NV", "Nevada");
        stateCodeToNameMap.put("NY", "New York");
        stateCodeToNameMap.put("OH", "Ohio");
        stateCodeToNameMap.put("OK", "Oklahoma");
        stateCodeToNameMap.put("OR", "Oregon");
        stateCodeToNameMap.put("PA", "Pennsylvania");
        stateCodeToNameMap.put("RI", "Rhode Island");
        stateCodeToNameMap.put("SC", "South Carolina");
        stateCodeToNameMap.put("SD", "South Dakota");
        stateCodeToNameMap.put("TN", "Tennessee");
        stateCodeToNameMap.put("TX", "Texas");
        stateCodeToNameMap.put("UT", "Utah");
        stateCodeToNameMap.put("VA", "Virginia");
        stateCodeToNameMap.put("VT", "Vermont");
        stateCodeToNameMap.put("WA", "Washington");
        stateCodeToNameMap.put("WI", "Wisconsin");
        stateCodeToNameMap.put("WV", "West Virginia");
        stateCodeToNameMap.put("WY", "Wyoming");

        // Load US State Names.
        stateNameToCodeMap.put("Alabama","AL");
        stateNameToCodeMap.put("Alaska","AK");
        stateNameToCodeMap.put("Arizona","AZ");
        stateNameToCodeMap.put("Arkansas","AR");
        stateNameToCodeMap.put("California","CA");
        stateNameToCodeMap.put("Colorado","CO");
        stateNameToCodeMap.put("Connecticut","CT");
        stateNameToCodeMap.put("Delaware","DE");
        stateNameToCodeMap.put("Florida","FL");
        stateNameToCodeMap.put("Georgia","GA");
        stateNameToCodeMap.put("Hawaii","HI");
        stateNameToCodeMap.put("Idaho","ID");
        stateNameToCodeMap.put("Illinois","IL");
        stateNameToCodeMap.put("Indiana","IN");
        stateNameToCodeMap.put("Iowa","IA");
        stateNameToCodeMap.put("Kansas","KS");
        stateNameToCodeMap.put("Kentucky","KY");
        stateNameToCodeMap.put("Louisiana","LA");
        stateNameToCodeMap.put("Maine","ME");
        stateNameToCodeMap.put("Maryland","MD");
        stateNameToCodeMap.put("Massachusetts","MA");
        stateNameToCodeMap.put("Michigan","MI");
        stateNameToCodeMap.put("Minnesota","MN");
        stateNameToCodeMap.put("Mississippi","MS");
        stateNameToCodeMap.put("Missouri","MO");
        stateNameToCodeMap.put("Montana","MT");
        stateNameToCodeMap.put("Nebraska","NE");
        stateNameToCodeMap.put("Nevada","NV");
        stateNameToCodeMap.put("New Hampshire","NH");
        stateNameToCodeMap.put("New Jersey","NJ");
        stateNameToCodeMap.put("New Mexico","NM");
        stateNameToCodeMap.put("New York","NY");
        stateNameToCodeMap.put("North Carolina","NC");
        stateNameToCodeMap.put("North Dakota","ND");
        stateNameToCodeMap.put("Ohio","OH");
        stateNameToCodeMap.put("Oklahoma","OK");
        stateNameToCodeMap.put("Oregon","OR");
        stateNameToCodeMap.put("Pennsylvania","PA");
        stateNameToCodeMap.put("Rhode Island","RI");
        stateNameToCodeMap.put("South Carolina","SC");
        stateNameToCodeMap.put("South Dakota","SD");
        stateNameToCodeMap.put("Tennessee","TN");
        stateNameToCodeMap.put("Texas","TX");
        stateNameToCodeMap.put("Utah","UT");
        stateNameToCodeMap.put("Vermont","VT");
        stateNameToCodeMap.put("Virginia","VA");
        stateNameToCodeMap.put("Washington","WA");
        stateNameToCodeMap.put("West Virginia","WV");
        stateNameToCodeMap.put("Wisconsin","WI");
        stateNameToCodeMap.put("Wyoming","WY");
    }

    public MailingAddress (String primaryStreet, String secondaryStreet, String city,
                           String state, String postalCode) {
        street = validateStreet(primaryStreet);
        secondStreet = validateStreet(secondaryStreet);
        town = validateCity(city);
        state1 = validateState(state);
        zipcode = validatePostalCode(postalCode);
    }

    public String getFormattedAddress(){
        String formattedAddress = "";
        if (validateStreet(street) != null) {
            formattedAddress += street + "\n";
        }
        else {
            formattedAddress += "N/A\n";
        }
        if (validateStreet(secondStreet) != null) {
            formattedAddress += secondStreet + "\n";
        }
        else {
            formattedAddress += "N/A\n ";
        }
        if (validateCity(town) != null) {
            formattedAddress += town + ", ";
        }
        else {
            formattedAddress += "N/A, ";
        }
        if (validateState(state1) != null) {
            formattedAddress += state1 + ", ";
        }
        else {
            formattedAddress += "N/A, ";
        }
        if (validatePostalCode(zipcode) != null) {
            formattedAddress += zipcode + ". ";
        }
        else {
            formattedAddress += "N/A. ";
        }
        return formattedAddress;
    }

    public String validateStreet(String street) {
        if (street != null && street.length() > 0) {
            return street;
        }
        return null;
    }

    public String validateCity(String city) {
        if (city != null && street.length() > 0) {
            return city;
        }
        return null;
    }

    public String validateState(String state) {
        if (state == null) {
            return null;
        }
        state = toTitleCase(state);
        String temp = stateNameToCodeMap.get(state);
        if (temp != null) {
            return temp;
        }
        state = state.toUpperCase();
        temp = stateCodeToNameMap.get(state);
        if (temp != null) {
            return state;
        }
        return null;
    }

    public String validatePostalCode(String postalCode) {
        if (postalCode.length() == 5) {
            return postalCode;
        }
        return null;
    }

    public String getPrimaryStreet() {
        return street;
    }

    public void setPrimaryStreet(String primaryStreet) {
        street = validateStreet(primaryStreet);
    }

    public String getSecondaryStreet() {
        return secondStreet;
    }

    public void setSecondaryStreet(String secondaryStreet) {
        secondStreet = validateStreet(secondaryStreet);
    }

    public String getCity() {
        return town;
    }

    public void setCity(String city) {
        town = validateCity(city);
    }

    public String getState() {
        return state1;
    }

    public void setState(String state) {
        state1 = validateState(state);
    }

    public String getPostalCode() {
        return zipcode;
    }

    public void setPostalCode(String postalCode) {
        zipcode = validatePostalCode(postalCode);
    }

    public static String toTitleCase(String givenString) {
        String[] arr = givenString.split(" ");
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < arr.length; i++) {
            sb.append(Character.toUpperCase(arr[i].charAt(0)))
                    .append(arr[i].substring(1)).append(" ");
        }
        return sb.toString().trim();
    }
}
