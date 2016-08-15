package com.citic.wechat.web.entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;

import javax.servlet.ServletException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

public class AccessToken  {
	private static Date getAccessTokenTime;
	private static int expiresPeriod = 7200;
	private static String mAccessToken;
	public static String accessToken()
	{
		if (mAccessToken==null||mAccessToken.equals(""))
		{
			
		}
		return mAccessToken;
	}
	 
    /// <param name="appId"></param>
    /// <param name="appSecret"></param>
    /// <returns></returns>
    @SuppressWarnings("unused")
	private static String GetAccessToken(String appId, String appSecret) throws  IOException, JSONException 
    {
        String url = String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={0}&secret={1}", appId, appSecret);
     // 创建HttpClient实例     
        HttpClient httpclient = new DefaultHttpClient();  
        // 创建Get方法实例     
        HttpGet httpgets = new HttpGet(url);    
        HttpResponse response1 = httpclient.execute(httpgets);    
        HttpEntity entity = response1.getEntity();  
        String str = "" ;
        if (entity != null) {    
            InputStream instreams = entity.getContent();    
            str = convertStreamToString(instreams);  
           // System.out.println("Do something");   
            System.out.println(str);  
            // Do not need the rest    
            httpgets.abort();    
        }  
        JSONObject json = new JSONObject(str);  
        
        if (json.getString("access_token")!=null)
        {
        	mAccessToken = json.getString("access_token");
        	getAccessTokenTime= new Date();
        	expiresPeriod = Integer.parseInt(json.getString("expires_in"));
        }
        else
        {
        	getAccessTokenTime = new Date(0) ;
        	
        }
        

        return null;
    }
    private  static String convertStreamToString(InputStream is) {      
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));      
        StringBuilder sb = new StringBuilder();      
       
        String line = null;      
        try {      
            while ((line = reader.readLine()) != null) {
            	sb.append(line+"\n");
            }      
        } catch (IOException e) {      
            e.printStackTrace();      
        } finally {      
            try {      
                is.close();      
            } catch (IOException e) {      
               e.printStackTrace();      
            }      
        }      
        return sb.toString();      
    }  
    /// <summary>
 
    /// </summary>
    /// <returns>bool</returns>
    private static boolean HasExpired()
    {
        if (getAccessTokenTime != null)
        {
        	Date temp= new Date() ;
        	temp.setTime(getAccessTokenTime.getTime()+(expiresPeriod-60)*1000);
            
            if ((new Date()).after(temp))
            {
                return true;
            }
        }
        return false;
    }
    
}
