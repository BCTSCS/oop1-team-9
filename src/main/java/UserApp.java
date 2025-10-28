import javax.swing.*;
import Painting;
import Vlogger;
import Player;
class UserApp extends JFrame {
    private JPanel panel;
    private Painting painting;
    private Vlogger vlogger;
    private Player user;

    public UserApp() {
        setTitle("Users Info");
        setSize(300, 300);
        panel = new JPanel();
        painting = new Painting();
        vlogger = new Vlogger();
        user = new Player();

        panel.add(new JLabel("Player Name: "+ user.getName()));
        panel.add(new JLabel("Level: " + user.getLevel()));

        panel.add(new JLabel("Painting: " + painting.getTitle()));
        panel.add(new JLabel("Age: " + painting.getYear()));
        
        panel.add(new JLabel("Vlogger: " + vlogger.getName()));
        panel.add(new JLabel("Joined: " + painting.getYearJoined()));
    }

    public static void main(String[] args) {

    }
}