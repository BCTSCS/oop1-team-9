import java.io.*; 
import java.net.*; 
import java.util.Scanner;
public class SimpleServer {
    private ServerSocket serverSocket;
    private Socket socket;
    private PrintWriter out;
    private Scanner in;
    public SimpleServer(int port)  throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started and Listening on port " + port);
    }
    public void acceptClient() throws IOException {
        socket = serverSocket.accept();
        InputStream i = socket.getInputStream();
        OutputStream o = socket.getOutputStream();
        in = new Scanner(i);
        out = new PrintWriter(o, true);
    }
    public String receiveMessage() {
        return in.nextLine();
    }
    public void sendMessage(String message) {
        out.println(message);
    }
    public void close() throws IOException{
        in.close();
        out.close();
        socket.close();
        serverSocket.close();
    }
    public static void main(String[] args) {
        try{
            SimpleServer s = new SimpleServer(888);
            s.acceptClient();
            while (true) {
                String user = s.receiveMessage();
                s.sendMessage("Received: " + user);
                if (user.equals("stop")) {
                    break;
                }
            }
            s.close();
        }
    catch(IOException e) {}
    }
}

