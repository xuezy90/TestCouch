package com.couchdb.test;

import java.util.ArrayList;
import java.util.List;

import org.jcouchdb.db.Database;
import org.jcouchdb.db.Server;
import org.jcouchdb.db.ServerImpl;
import org.slf4j.LoggerFactory;

public class TestCouch {
	private static org.slf4j.Logger log = LoggerFactory.getLogger(TestCouch.class);
	public static void conn()
	{
		doc doc1= null;
		Server server = new ServerImpl("localhost", 5984);
		List<doc> ls = new ArrayList<doc>();
		for(int i=10000;i<100000;i++)
		{
			doc1 = new doc(i+"",i+"_version",Math.random()*1000,Math.random()*1000);
			ls.add(doc1);
		}
		Database db = new Database(server, "test_xue");
		db.bulkCreateDocuments(ls);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		conn();
	}

}
