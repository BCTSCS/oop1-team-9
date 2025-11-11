import java.net.Socket;
import java.util.Scanner;
import java.io.*;

public class SimpleClient {
    private Socket socket;
    private PrintWriter out;
    private Scanner in;
    public SimpleClient(String ip, int port) throws IOException {
        this.socket = new Socket(ip, port);
        System.out.println("Client is connecting");
        InputStream i = socket.getInputStream();
        OutputStream o = socket.getOutputStream();
        in = new Scanner(i);
        out = new PrintWriter(o, true);
    }
    public void sendMessage(String message) {
        out.println(message);
    }
    public void close() throws IOException {
        in.close();
        out.close();
        socket.close();
    }
    public String receiveMessage() {
        return in.nextLine();
    }
    public static void main(String[] args) throws IOException {
        SimpleClient a = new SimpleClient("127.0.0.1",8888);
        fileOperator file = new fileOperator("client.txt");
            while (true) {
                String message = file.readLine();
                a.sendMessage(message);
                System.out.println("Me: " + message);
                String server = a.receiveMessage();
                System.out.println("Server : "+ server);
                a.sendMessage("Client");
                if(message.equals("stop")) {
                    break;
                }
            }
        
    }
}
