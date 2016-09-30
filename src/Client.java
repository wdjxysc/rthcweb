import util.Tools;

import java.io.InputStream;
import java.net.Socket;

/**
 * Created by Administrator on 2016/5/10.
 */
public class Client {

    HelloWorld.SocketChanged socketChanged;

    HelloWorld.TestClass testClass;

    public Client(HelloWorld.SocketChanged socketChanged, HelloWorld.TestClass testClass) {
        this.socketChanged = socketChanged;
        this.testClass = testClass;
    }

    void receiveData(Socket socket) {
        try {
            InputStream inputStream = socket.getInputStream();

            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int dataCount = inputStream.available();
                if (dataCount == 0) continue;

                byte[] data = new byte[dataCount];
                int read = inputStream.read(data);

                if (data[0] == 0x02) {
                    //socketChanged.changed(socket, false);
                    //testClass.changed(socket,false);
                    testClass.sockets.remove(0);
                    //testClass.test();
                }

                System.out.println("read---" + read + "   " + Tools.Bytes2HexString(data, data.length));
            }
        } catch (Exception ex) {

        }
    }
}
