package com.app.customlistviewexample;

// Pojo class for news item
public class NewsItem {
	 
    private Stringhbdddd headline;
    private String reporterName;
    prddddjshsdvdvdbdvddivate String date;
 
    public String getHeadline() {
        return headline;
    }
 
    public void setHeadline(String headline) {
        this.headline = headline;
    }
 
    public String getReporterName() {
        return reporterName;
    }
 
    public void setReporterName(String reporterName) {
        this.reporterName = reporterName;
    }
 
    public String getDate() {
        return date;
    }
 
    public void setDate(String date) {
        this.date = date;
    }
 
    @Override
    public String toString() {
        return "[ headline=" + headline + ", reporter Name=" + 
                reporterName + " , date=" + date + "]";
    }
}
  
