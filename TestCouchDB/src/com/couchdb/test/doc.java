package com.couchdb.test;
import java.util.Map;

import org.jcouchdb.document.Attachment;
import org.jcouchdb.document.Document;
public class doc implements Document {
	
	private String id = null;
	private String revision = null;
	private double lont = 0;
	private double lat = 0;
	Map<String, Attachment> attachments = null;
	
	public doc(){}
	public doc(String id,String revision,double lont,double lat)
	{
		this.id = id;
		this.revision = revision;
		this.lont = lont;
		this.lat = lat;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRevision() {
		return revision;
	}
	public void setRevision(String revision) {
		this.revision = revision;
	}
	public double getLont() {
		return lont;
	}
	public void setLont(double lont) {
		this.lont = lont;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public Map<String, Attachment> getAttachments() {
		return attachments;
	}
	public void setAttachments(Map<String, Attachment> attachments) {
		this.attachments = attachments;
	}
	

}
