package app.thezineclient.models;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Article implements java.io.Serializable {
	
	private String id;
	private String title;
	private String tagline;
	private String body;
	private int issue;
	private String link;
	private Author author;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTagline() {
		return tagline;
	}
	public void setTagline(String tagline) {
		this.tagline = tagline;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getIssue() {
		return issue;
	}
	public void setIssue(int issue) {
		this.issue = issue;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
    public static Article fromJson(JSONObject jsonObject) {
        Article a = new Article();
        try {
            // Deserialize json into object fields
        	a.id = jsonObject.getString("id");
            a.title = jsonObject.getString("title");
            a.tagline = jsonObject.getString("tagline");
            a.body = new String(jsonObject.getString("body").getBytes("UTF-8"), "UTF-8");
            a.issue = jsonObject.getInt("issue");
            a.link = jsonObject.getString("link");
            a.author = Author.fromJson(jsonObject.getJSONObject("author"));
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        // Return new object
        return a;
    }	
    
    public static ArrayList<Article> fromJson(JSONArray jsonArray) {
        ArrayList<Article> articles = new ArrayList<Article>(jsonArray.length());
        // Process each result in json array, decode and convert to business
        // object
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject articleJson = null;
            try {
                articleJson = jsonArray.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            Article business = Article.fromJson(articleJson);
            if (business != null) {
                articles.add(business);
            }
        }

        return articles;
    }    

}
