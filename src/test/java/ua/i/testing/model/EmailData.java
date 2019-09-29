package ua.i.testing.model;

import java.util.Objects;

public class EmailData {
    private String id = null;
    private String emailAddress;
    private String subject;
    private String emailText;



    public String getId() {
        return id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getSubject() {
        return subject;
    }

    public String getEmailText() {
        return emailText;
    }

    public EmailData withEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public EmailData withSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public EmailData withEmailText(String emailText) {
        this.emailText = emailText;
        return this;
    }

    public EmailData withId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailData emailData = (EmailData) o;
        return Objects.equals(id, emailData.id) &&
                Objects.equals(emailAddress, emailData.emailAddress);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, emailAddress);
    }

    @Override
    public String toString() {
        return "EmailData{" +
                "id='" + id + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }


}
