public class AccountOwner {
    private String prefix = null;
    private String fName = null;
    private String lName = null;
    private String email = null;
    private long phone = 0;
    private MailingAddress mail = null;

    public AccountOwner (String salutation, String firstName, String lastName,
                         String emailAddress, long phoneNumber, MailingAddress mailingAddress) {
        prefix = validateSalutation(salutation);
        fName = firstName;
        lName = lastName;
        email = validateEmailAddress(emailAddress);
        phone = validatePhoneNumber(phoneNumber);
        mail = mailingAddress;
    }

    public String getName(int format) {
        if (format == 2 && prefix != null) {
            return new String(prefix + ". " + lName);
        }
        else if (format == 3) {
            return new String(lName + ", " + fName);
        }
        else {
            return new String(fName + " " + lName);
        }
    }

    public String getFormattedPhoneNumber() {
        if (phone == 0) {
            return "N/A";
        }
        else {
            String value = String.valueOf(phone);
            value = "(" + value.substring(0,3) + ") " + value.substring(3,6) + "-"
                    + value.substring(6);
            return value;
        }
    }

    public String validateSalutation(String salutation) {
        if (salutation != null && salutation.length() > 0) {
            return salutation;
        }
        return null;
    }

    public String validateEmailAddress(String emailAddress) {
        if (emailAddress.length() >= 7 && emailAddress.length() <= 254
        && emailAddress.indexOf("@") > 0 && emailAddress.indexOf(".") > 0 &&
        emailAddress.indexOf("@") + 1 < emailAddress.lastIndexOf(".") &&
        emailAddress.substring(emailAddress.lastIndexOf(".")).length() == 4
        && emailAddress.lastIndexOf("@") != emailAddress.length() - 1) {
            return emailAddress;
        }
        return null;
    }

    public long validatePhoneNumber(long phoneNumber) {
        String tempnum = String.valueOf(phoneNumber);
        if (tempnum.length() == 10) {
            return phoneNumber;
        }
        return 0L;
    }

    public String getSalutation() {
        return this.prefix;
    }

    public void setSalutation(String salutation) {
        this.prefix = validateSalutation(salutation);
    }

    public String getFirstName() {
        return this.fName;
    }

    public void setFirstName(String firstName) {
        this.fName = firstName;
    }

    public String getLastName() {
        return this.lName;
    }

    public void setLastName(String lastName) {
        this.lName = lastName;
    }

    public String getEmailAddress() {
        return email;
    }

    public void setEmailAddress(String emailAddress) {
        this.email = validateEmailAddress(emailAddress);
    }

    public long getPhoneNumber() {
        return phone;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phone = validatePhoneNumber(phoneNumber);
    }

    public MailingAddress getMailingAddress() {
        return this.mail;
    }

    public void setMailingAddress(MailingAddress mailingAddress) {
        this.mail = mailingAddress;
    }
}
