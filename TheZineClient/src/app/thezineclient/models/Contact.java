package app.thezineclient.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Contact implements java.io.Serializable{
	
	private String email;
	private String facebook;
	private String twitter;
	private String link;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	public static Contact fromJson(JSONObject jsonObject){
        Contact c = new Contact();
        try {
            // Deserialize json into object fields
            c.email= jsonObject.getString("facebook");
            c.facebook = jsonObject.getString("facebook");
            c.twitter = jsonObject.getString("twitter");
            c.link = jsonObject.getString("link");

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        // Return new object
        return c;		
	}
}
