package es.elasticsearch;

import java.net.InetAddress;
import java.net.UnknownHostException;

import junit.framework.TestCase;

import org.elasticsearch.action.get.GetRequestBuilder;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;
import org.junit.Test;

public class Connect extends TestCase{
	
	@Test
	public void test22(){
		Node node = new NodeBuilder().node();
		node.settings();
	}
	
	@Test
	public void testCon(){
		NodeBuilder nodeBuilder = new NodeBuilder();
		nodeBuilder.client(true);
		
	}
	@Test
	public void test11() throws UnknownHostException{
		Settings settings = Settings.settingsBuilder()
			      .put("cluster.name", "pangu")
			      .put("client.transport.sniff", true) //允许嗅探
			      .build();
		Client client = TransportClient.builder()
			      .settings(settings) //设置部分
			      .build()
			      .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.33.203"), 9300))
			      .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.33.204"), 9300));

		GetRequestBuilder request = client.prepareGet("ss", "ss", "ss");
		GetResponse response = request.get();
		String ss = response.getSourceAsString();
//		client.prepare
	}
	@Test
	public void test23(){
		System.out.println(1111);
	}

}
