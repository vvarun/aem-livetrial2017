package com.adobe.training.core;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class ParseJson {
	
	
	public static String URL = "http://localhost:4502/content/entities/livedemospace/LiveCopyAssetModel.caas.json";
	public ArrayList<ParseJsonBean> ParseJsonBeanList = new ArrayList<ParseJsonBean>();
	public HashMap<String, String> photoMap = new HashMap<String, String>();
	public ParseJsonBean parseJSONBean = new ParseJsonBean();
	public ParseJson(){

		Logger logger = LoggerFactory.getLogger(ParseJson.class);
		// TODO Auto-generated method stub
		try {
			URL url = new URL(URL);
			Scanner scan = new Scanner(url.openStream());
		    String str = new String();
		    while (scan.hasNext()){
		        str += scan.nextLine();
		    }
		    scan.close();
		 logger.info("inside ParseJson "+str);
		    // build a JSON object
		 
		    JSONObject obj = new JSONObject(str);
		    String title = obj.getString("title");
		    JSONObject root = obj.getJSONObject("root");
		    JSONObject hero_image = root.getJSONObject("hero_image");
		    String fileReference = hero_image.getString("fileReference");
		    fileReference = "http://localhost:4503"+fileReference; 
		    String heading = hero_image.getString("heading");
		    ArrayList<String> keyArray = new ArrayList<String>();
		    keyArray.add("title");
		    keyArray.add("lastModified");
		    keyArray.add("hideSubItemsInNav");
		    keyArray.add("root");	    
		   HashMap<String, String> hmap = new HashMap<String, String>();
		   photoMap.put(heading, fileReference);
		   String name = new String();
		   String href = new String();
		    Iterator<String>keyItr= obj.keys();
		    while(keyItr.hasNext()){
		    	String key = keyItr.next();
		    	
		    	if(keyArray.contains(key)){
		    		logger.info("skipped "+key);
		    		continue;
		    	}
		    	logger.info(key);    
		    	JSONObject newObj = (JSONObject)obj.get(key);
		    	name = newObj.getString("name");
		    	href = newObj.getString("href");
		    	hmap.put(name,href);
		    	logger.info(name+" "+href);    
		    }
		   Set<String> keySet = hmap.keySet();
		   keyItr = keySet.iterator();
		   while(keyItr.hasNext()){
			   String key = keyItr.next();
			   href = hmap.get(key);
			   URL secondaryUrl = new URL(href);
				scan = new Scanner(secondaryUrl.openStream());
			    str = new String();
			    while (scan.hasNext()){
			        str += scan.nextLine();
			    }
			    scan.close();
			    obj = new JSONObject(str);
			    title = obj.getString("title");
			    root = obj.getJSONObject("root");
			    hero_image = root.getJSONObject("hero_image");
			    fileReference = hero_image.getString("fileReference");
			    fileReference = "http://localhost:4503"+fileReference+".thumb.100.140.png";
			    parseJSONBean.setPhotoURL(fileReference);
			    parseJSONBean.setTitle(title);
			    photoMap.put(title, fileReference);
			    ParseJsonBeanList.add(parseJSONBean);
			    parseJSONBean = new ParseJsonBean();
			   
		   }
		   logger.info(photoMap.toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}
	

	
	

}
