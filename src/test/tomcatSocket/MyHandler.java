package test.tomcatSocket;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import org.apache.coyote.Adapter;
import org.apache.coyote.Request;
import org.apache.coyote.Response;
import org.apache.tomcat.util.buf.ByteChunk;
import org.apache.tomcat.util.net.SocketStatus;

public class MyHandler implements Adapter
{
    //支持Comet，Servlet3.0将对Comet提供支持，Tomcat6目前是非标准的实现
	@Override
    public boolean event(Request req, Response res, SocketStatus status)
            throws Exception
    {
        System.out.println("event");
        return false;
    }

    //请求处理
	@Override
    public void service(Request req, Response res) throws Exception
    {
        System.out.println("service");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(baos));
        writer.println("Hello World");
        writer.flush();

        ByteChunk byteChunk = new ByteChunk();//这个作用是 ?
        byteChunk.append(baos.toByteArray(), 0, baos.size());
        res.doWrite(byteChunk);
    }   
}