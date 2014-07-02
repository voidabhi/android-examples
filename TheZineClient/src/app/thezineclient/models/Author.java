package app.thezineclient.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Author implements java.io.Serializable {
	
	private String id;
	private String name;
	private String image_url;
	private Contact contacts;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public Contact getContacts() {
		return contacts;
	}
	public void setContacts(Contact contacts) {
		this.contacts = contacts;
	}
	
	public static Author fromJson(JSONObject jsonObject){
        Author a = new Author();
        try {
            // Deserialize json into object fields
            a.id= jsonObject.getString("id");
            a.name = jsonObject.getString("name");
            a.image_url = jsonObject.getString("image_url");
            a.contacts = Contact.fromJson(jsonObject.getJSONObject("contacts"));

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        // Return new object
        return a;		
	}


}
