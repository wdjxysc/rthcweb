import util.Tools;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/9.
 */
public class HelloWorld extends HttpServlet {

    private String message;


    /**
     * 定义ServletConfig对象来接收配置的初始化参数
     */
    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        message = "Hello world, this message is from servlet!";
        this.config = config;

        super.init();

        TestClass testClass = new TestClass();
        testClass.test();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }



    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();

        if (map.containsKey("download")) {
            if (map.get("download")[0].equals("switchboxupdate")) {
                response.setHeader("content-disposition", "attachment;filename=1.jpg");
                String fullFileName = getServletContext().getRealPath("/download/" + "1.jpg");
                String parentPath = getClass().getResource("../").getFile();
                String path = ResourcePath.downloadPath + "1.jpg";
                //InputStream in = this.getServletContext().getResourceAsStream("/download/1.jpg");
                InputStream in = new FileInputStream(path);
                byte buffer[] = new byte[1024];
                int len = 0;
                OutputStream out = response.getOutputStream();
                while ((len = in.read(buffer)) > 0) {
                    out.write(buffer, 0, len);
                }
            }
        } else {

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
            out.println("<HTML>");
            out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
            out.println("  <BODY>");
            out.print("    This is ");
            out.print(this.getClass());
            out.println(", using the GET method");
            out.println(map.toString());
            out.println("  </BODY>");
            out.println("</HTML>");
            out.flush();
            out.close();
        }


        String data = "xdp_gacl";
        /**
         * ServletConfig对象中维护了ServletContext对象的引用，开发人员在编写servlet时，
         * 可以通过ServletConfig.getServletContext方法获得ServletContext对象。
         */
        ServletContext context = this.getServletConfig().getServletContext();//获得ServletContext对象
        context.setAttribute("data", data);  //将data存储到ServletContext对象中


        //在另一个servlet 中使用以上存储的数据
        ServletContext context1 = this.getServletContext();
        String data1 = (String) context1.getAttribute("data");//从ServletContext对象中取出数据
        response.getWriter().print("data=" + data1);

        //获取整个web站点的初始化参数
        ServletContext context2 = this.getServletContext();
        String contextInitParam = context2.getInitParameter("url");
        response.getWriter().print(contextInitParam);

        //转发请求到另一个servlet
        String data3 = "<h1><font color='red'>abcdefghjkl</font></h1>";
        response.getOutputStream().write(data3.getBytes());
        ServletContext context3 = this.getServletContext();//获取ServletContext对象
        RequestDispatcher rd = context3.getRequestDispatcher("/servlet/ServletContextDemo5");//获取请求转发对象(RequestDispatcher)
        rd.forward(request, response);//调用forward方法实现请求转发
        response.getOutputStream().write("servletDemo5".getBytes());//此句为在servletDemo5 doGet方法里接收转发请求


        //缓存servlet数据
        String data4 = "abcddfwerwesfasfsadf";
        /**
         * 设置数据合理的缓存时间值，以避免浏览器频繁向服务器发送请求，提升服务器的性能
         * 这里是将数据的缓存时间设置为1天
         */
        response.setDateHeader("expires", System.currentTimeMillis() + 24 * 3600 * 1000);
        response.getOutputStream().write(data4.getBytes());
    }

    @Override
    public String getServletInfo() {
        return super.getServletInfo();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    interface SocketChanged{

        void changed(Socket socket,boolean b);

    }

    class TestClass implements SocketChanged{

        List<Socket> sockets = new ArrayList<Socket>();

        void test() {
            try {
                ServerSocket socket = new ServerSocket(1234);


                while (true) {
                    Socket socket1 = socket.accept();
                    sockets.add(socket1);

                    new Thread(() -> {
                        Client client = new Client(this , this);

                        client.receiveData(socket1);
                    }).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void changed(Socket socket,boolean b) {
            if(!b){
                for(int i = 0;i<sockets.size();i++){
                    if(sockets.get(i).equals(socket)){
                        sockets.remove(i);
                        break;
                    }
                }
            }
        }
    }
}
