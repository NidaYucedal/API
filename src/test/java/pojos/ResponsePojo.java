package pojos;

public class ResponsePojo {
    /*
    {
  "activated": true,
  "authorities": [
    "string"
  ],
  "createdBy": "string",
  "createdDate": "2022-11-21T15:54:55.905Z",
  "email": "string",
  "firstName": "string",
  "imageUrl": "string",
  "langKey": "string",
  "lastModifiedBy": "string",
  "lastModifiedDate": "2022-11-21T15:54:55.905Z",
  "lastName": "string",
  "login": "string",
  "ssn": "string"
}
     */
    private Boolean activated;
    private AuthoritiesPojo authorities;
    private String createdBy;
    private String createdDate;
    private String email;
    private String firstName;
    private String imageUrl;
    private String langKey;
    private String lastModifiedBy;
    private String lastModifiedDate;
    private String lastName;
    private String login;
    private String ssn;
    public ResponsePojo(Boolean activated, AuthoritiesPojo authorities, String createdBy, String createdDate, String email, String firstName, String imageUrl, String langKey, String lastModifiedBy, String lastModifiedDate, String lastName, String login, String ssn) {
        this.activated = activated;
        this.authorities = authorities;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.email = email;
        this.firstName = firstName;
        this.imageUrl = imageUrl;
        this.langKey = langKey;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
        this.lastName = lastName;
        this.login = login;
        this.ssn = ssn;
    }
    public ResponsePojo() {
    }
    public Boolean getActivated() {
        return activated;
    }
    public void setActivated(Boolean activated) {
        this.activated = activated;
    }
    public AuthoritiesPojo getAuthorities() {
        return authorities;
    }
    public void setAuthorities(AuthoritiesPojo authorities) {
        this.authorities = authorities;
    }
    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public String getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getLangKey() {
        return langKey;
    }
    public void setLangKey(String langKey) {
        this.langKey = langKey;
    }
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
    public String getLastModifiedDate() {
        return lastModifiedDate;
    }
    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSsn() {
        return ssn;
    }
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    @Override
    public String toString() {
        return "ResponsePojo{" +
                "activated=" + activated +
                ", authorities=" + authorities +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", langKey='" + langKey + '\'' +
                ", lastModifiedBy='" + lastModifiedBy + '\'' +
                ", lastModifiedDate='" + lastModifiedDate + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", ssn='" + ssn + '\'' +
                '}';
    }
}