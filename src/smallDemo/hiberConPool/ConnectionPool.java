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

  //连接池的管理器,首先初始化，仅仅有一个对象，管理连接池
  private static HashMap connectionPoolManager=new HashMap();
  //没有用过的连接池，用vector实现同步
  private static Vector noUseConnectionPool;
  //没有用过的连接池
  private  static HashMap nowUseConnectionPool;

  private  static String dbDriver="odbc:jdbc:OdbcJdbcDriver";
  private  static String dbUrl="dalong@XX";
  private  static String userName="dalong";
  private  static String userPassword="dalong";

  //默认为100个连接池
  private  static int MAX_POOL=100;

 //singleTon 设计模式
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

 //通过连接池获得真正的链接
 public static Connection getConnection() throws java.sql.SQLException{
    Connection conn=null;
    synchronized(noUseConnectionPool){
       if(noUseConnectionPool.size()>0){
         conn=(Connection)noUseConnectionPool.firstElement();
         noUseConnectionPool.remove(conn);
        return conn;
       }
    }
    //如果数据库连接池没有链接了，自己创建一个
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

 //如果连接池没有链接了，就需要产生一个链接
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
  //测试模拟10个客户
   for (int i = 0; i < 10; i++); {
     try {
       //xxxx 一般为属性文件读取
       ConnectionPool pool = ConnectionPool.getConnManagerInstance("xxxx");
       Connection conn = pool.getConnection();

     }catch (SQLException ex1){
        //处理异常
      }
     catch (ClassNotFoundException ex) {
        //处理异常
     }
   }
 }
}