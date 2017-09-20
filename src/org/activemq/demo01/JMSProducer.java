package org.activemq.demo01;

import java.io.Serializable;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

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

    public static void main(String[] args) {
        //连接工厂
        ConnectionFactory connectionFactory;
        //连接
        Connection connection = null;
        //会话 接受或者发送消息的线程
        Session session;
        //消息的目的地
        Destination destination;
        //消息生产者
        MessageProducer messageProducer;
        //实例化连接工厂
        connectionFactory = new ActiveMQConnectionFactory(JMSProducer.USERNAME, JMSProducer.PASSWORD, JMSProducer.BROKEURL);

        try {
            //通过连接工厂获取连接
            connection = connectionFactory.createConnection();
            //启动连接
            connection.start();
            //创建session
            session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            //创建一个名称为HelloWorld的消息队列
            destination = session.createQueue("user");
            //创建消息生产者
            messageProducer = session.createProducer(destination);
            //发送消息
            sendMessage1(session, messageProducer);

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
    
    
    public static void sendMessageFail(Session session,MessageProducer messageProducer) throws Exception{
            TextMessage message = session.createTextMessage("ActiveMQ 发送消息");
            System.out.println("发送消息：Activemq 发送消息");
            //通过消息生产者发出消息 
            messageProducer.send(message);
            try{
            	session.commit();
            }catch(Exception e){
            	e.printStackTrace();
            }
            	
    }
    /**
     * 发送消息
     * @param session
     * @param messageProducer  消息生产者
     * @throws Exception
     */
    public static void sendMessage(Session session,MessageProducer messageProducer) throws Exception{
        for (int i = 0; i < JMSProducer.SENDNUM; i++) {
            //创建一条文本消息 
            TextMessage message = session.createTextMessage("ActiveMQ 发送消息" +i);
            System.out.println("发送消息：Activemq 发送消息" + i);
            //通过消息生产者发出消息 
            messageProducer.send(message);
        }
    }
    
    public static void sendMessage1(Session session,MessageProducer messageProducer) throws Exception{
        for (int i = 0; i < JMSProducer.SENDNUM; i++) {
            //创建一条文本消息 
        	ObjectMessage obMessage = session.createObjectMessage();
        	User user = new User();
        	user.setId(1);
        	obMessage.setObject(user);
            messageProducer.send(obMessage);
            session.commit();
            Thread.currentThread().sleep(1000);
        }
    }
}


class User implements Serializable{
	private static final long serialVersionUID = 1L;
	public User(){}
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}


