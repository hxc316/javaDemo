package es;

import junit.framework.TestCase;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.junit.Test;

public class Client extends TestCase{
	
	
	@Test
	public void testQ(){
		String s ="/_count";
		String s1  = "/.marvel-es-2015.11.17";
//		mm("/_count");   {\"query\":	{\"match_all\":	{}}}
		
		String m = "{\"query\":	{\"match_all\":	{}}}";
		
		String q = ".marvel-es-2015.11.17";
		
		mm(s1,q);
	}
	
	public void mm(String direct,String ss){
		HttpClient client = new HttpClient();
		client.getHostConfiguration().setHost("192.168.33.204", 9200);
		GetMethod get = new GetMethod(direct);
//		get.setQueryString(ss);
		try {
			client.executeMethod(get);
			byte[] b = get.getResponseBody();
			get.releaseConnection();
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}

}
