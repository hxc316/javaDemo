package org.activemq.topic.demo1;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQMapMessage;

public class JMSProducer {

    //默认连接用户名
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    //默认连接密码
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    //默认连接地址
//    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static final String BROKEURL = "tcp://127.0.0.1:61616?soTimeout=5000";
    //发送的消息数量
    private static final int SENDNUM = 100;
    
    private  Destination[] destinations;
    
    static Session session;
    
    //消息生产者
    MessageProducer messageProducer;

    public static void main(String[] args) {
    	JMSProducer pro = new JMSProducer();
    	pro.init();
    }
    
    protected void init(){
        //连接工厂
        ConnectionFactory connectionFactory;
        //连接
        Connection connection = null;
        //会话 接受或者发送消息的线程
        
        //消息的目的地
        Destination destination;
        //实例化连接工厂
        connectionFactory = new ActiveMQConnectionFactory(JMSProducer.USERNAME, JMSProducer.PASSWORD, JMSProducer.BROKEURL);

        try {
            //通过连接工厂获取连接
            connection = connectionFactory.createConnection();
            //启动连接
            connection.start();
            //创建session
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //创建一个名称为HelloWorld的消息队列
//            destination = session.createQueue("topic01");
            //创建消息生产者
            messageProducer = session.createProducer(null);
            String[] topic = {"1","2"};
            try {
    			setTopics(topic);
    			sendMessage(topic);
    		} catch (JMSException e) {
    			e.printStackTrace();
    		}
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(connection != null){
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    
    }
    
    protected void setTopics(String[] stocks) throws JMSException {
    	destinations = new Destination[stocks.length];
    	for(int i = 0; i < stocks.length; i++) {
    		destinations[i] = session.createTopic("STOCKS." + stocks[i]);
    	}
    }
    
    protected void sendMessage(String[] stocks) throws JMSException {
    	for(int i = 0; i < stocks.length; i++) {
    		Message message = createStockMessage(stocks[i], session);
    		System.out.println("Sending: " + ((ActiveMQMapMessage)message).getContentMap() + " on destination: " + destinations[i]);
    		//消息生产者
            messageProducer.send(destinations[i], message);
    	}
    }

    protected Message createStockMessage(String stock, Session session) throws JMSException {
        MapMessage message = session.createMapMessage();
    	message.setString("stock", stock);
    	message.setDouble("price", 1.00);
    	message.setDouble("offer", 0.01);
    	message.setBoolean("up", true);
    	return message;
    }
}