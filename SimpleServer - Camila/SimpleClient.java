import java.io.PrintWriter;
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
    public static void main(String[] args) {
        try {
            SimpleClient a = new SimpleClient("127.0.0.1",888);
            a.sendMessage("Heyyy");
            String server = a.receiveMessage();
            System.out.println("Server : "+ server);
            while (true) {
                a.sendMessage("Client");
                String reply = a.receiveMessage();
                System.out.println(reply+" ");
                if(reply.equals("stop")){
                    break;
                }
            }
            a.close();      
        }
    catch(Exception e) {}
    }
}
