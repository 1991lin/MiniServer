import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.SortedMap;

/**
 * @program: MiniServer
 * @author: Eric
 * @create: 2019-03-19 07:58
 **/
public class MiniClientMain {


    public static void main(String[] arg) throws IOException {

        for (int i = 0; i < 50; i++) {
            Socket socket = new Socket("192.168.199.236", 8089);
            OutputStream outputStream = socket.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, Charset.forName("UTF-8"));
            outputStreamWriter.write("您好，这是MiniServer");
            outputStreamWriter.flush();
            outputStreamWriter.close();
        }


        SortedMap<String, Charset> charset = Charset.availableCharsets();
        charset.forEach((x, y) -> System.out.println(x + " " + y));

    }
}
