package com.couchdb.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jcouchdb.db.Database;
import org.jcouchdb.db.Options;
import org.jcouchdb.db.Server;
import org.jcouchdb.db.ServerImpl;
import org.jcouchdb.document.ValueRow;
import org.jcouchdb.document.ViewResult;
import org.slf4j.LoggerFactory;
import org.svenson.JSONParser;

public class TestCouch {
	private static org.slf4j.Logger log = LoggerFactory.getLogger(TestCouch.class);
	public static void deleteAll(String dbname)
	{
		Server server = getServer();
		if(server.listDatabases().contains(new Database(server,dbname))) server.delete(dbname);
		server.createDatabase(dbname);
	}
	public static void bulkCreat(String dbname,int start,int end)
	{
		Database db = getDb(dbname);
		doc doc1= null;
		List<doc> ls = new ArrayList<doc>();
		for(int i=start;i<=end;i++)
		{
			doc1 = new doc(i+"",i+"_version",Math.random()*1000,Math.random()*1000);
			ls.add(doc1);
		}
		long stime = System.currentTimeMillis();
		db.bulkCreateDocuments(ls);
		System.out.println("insert cost: " + (System.currentTimeMillis()-stime));
		System.out.println("Completed!");
	}
	public static Database getDb(String dbname)
	{
		Server server = getServer();
		if(!server.listDatabases().contains(new Database(server,dbname))) server.createDatabase(dbname);
		Database db = new Database(server,dbname);
		return db;
	}
	
	public static Server getServer()
	{
		Server server = new ServerImpl("127.0.0.1", 5984);
		return server;
	}
	
	public static void queryView(String dbname,String viewname)
	{
		Database db = getDb(dbname);
		Options option = new Options();
		option.group(true);
		option.limit(100);
		ViewResult<Map> m = db.queryView(viewname, Map.class, option, null);
		List<ValueRow<Map>> list = m.getRows();
		for (int i = 0; i < 1; i++) {
		     System.out.println("================");
		     System.out.println("id :"+list.get(i).getId());
		     System.out.println("key :"+list.get(i).getKey());
		     System.out.println("value :"+list.get(i).getValue());
		     System.out.println("================");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dbname = "test";
		String viewname = "shows/lont";
//		int s = 0;
//		int e = 100000;
//		deleteAll(dbname);
//		bulkCreat(dbname, s, e);
		long stime = System.currentTimeMillis();
		queryView(dbname, viewname);
		long etime = System.currentTimeMillis();
		System.out.println("+++++++++++++++++++++++++++cost: "+ (etime -stime));
		queryView(dbname, viewname);
		System.out.println("+++++++++++++++++++++++++++cost: "+ (System.currentTimeMillis()-etime));
	}

}
