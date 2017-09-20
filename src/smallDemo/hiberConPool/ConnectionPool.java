package smallDemo.hiberConPool;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;
/**
 * <p>Title: </p>
 * <p>Description: test</p>
 * <p>Copyright: Copyright (c); 2003</p>
 * <p>Company: home</p>
 * @author dalong
 * @version 1.0
 */

public class ConnectionPool {

  //���ӳصĹ�����,���ȳ�ʼ����������һ�����󣬹������ӳ�
  private static HashMap connectionPoolManager=new HashMap();
  //û���ù������ӳأ���vectorʵ��ͬ��
  private static Vector noUseConnectionPool;
  //û���ù������ӳ�
  private  static HashMap nowUseConnectionPool;

  private  static String dbDriver="odbc:jdbc:OdbcJdbcDriver";
  private  static String dbUrl="dalong@XX";
  private  static String userName="dalong";
  private  static String userPassword="dalong";

  //Ĭ��Ϊ100�����ӳ�
  private  static int MAX_POOL=100;

 //singleTon ���ģʽ
  private ConnectionPool(String driver,String url,String name,String password,int max)
     throws ClassNotFoundException {
      Class.forName(driver);
      dbUrl=url;
      userName=name;
      userPassword=password;
      MAX_POOL=max;
 }
 public static ConnectionPool getConnManagerInstance(String poolName)
      throws ClassNotFoundException{
     ConnectionPool tempPool=(ConnectionPool)connectionPoolManager.get(poolName);
     if(tempPool==null){
        tempPool=new ConnectionPool(dbDriver,dbUrl,userName,userPassword,MAX_POOL);
        connectionPoolManager.put(poolName,tempPool);
        return tempPool;
     }else
       return tempPool;
 }

 //ͨ�����ӳػ������������
 public static Connection getConnection() throws java.sql.SQLException{
    Connection conn=null;
    synchronized(noUseConnectionPool){
       if(noUseConnectionPool.size()>0){
         conn=(Connection)noUseConnectionPool.firstElement();
         noUseConnectionPool.remove(conn);
        return conn;
       }
    }
    //������ݿ����ӳ�û�������ˣ��Լ�����һ��
    if(conn==null){
       conn=createConnection(dbDriver,dbUrl,userName,userPassword);
    }else if(conn.isClosed()){
       nowUseConnectionPool.remove(conn);
       conn=createConnection(dbDriver,dbUrl,userName,userPassword);
      }
    conn.setAutoCommit(false);
    nowUseConnectionPool.put(conn,conn);
    return conn;
 }

 //������ӳ�û�������ˣ�����Ҫ����һ������
 private static Connection createConnection(String driver,String url,String user,String password)
       throws java.sql.SQLException{
     Connection conn=DriverManager.getConnection(url,user,password);
     return conn;
 }
 public static void releaseConnection(Connection conn,boolean isCommit)
    throws java.sql.SQLException{
    if(isCommit)
       conn.commit();
    else
       conn.rollback();
    nowUseConnectionPool.remove(conn);
       if(noUseConnectionPool.size() + nowUseConnectionPool.size()<MAX_POOL){
          synchronized(noUseConnectionPool){
            noUseConnectionPool.add(conn);
          }
       }else{
         conn.close();
       }
 }

 public static void main(String[] args) {
  //����ģ��10���ͻ�
   for (int i = 0; i < 10; i++); {
     try {
       //xxxx һ��Ϊ�����ļ���ȡ
       ConnectionPool pool = ConnectionPool.getConnManagerInstance("xxxx");
       Connection conn = pool.getConnection();

     }catch (SQLException ex1){
        //�����쳣
      }
     catch (ClassNotFoundException ex) {
        //�����쳣
     }
   }
 }
}