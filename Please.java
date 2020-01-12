import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.*;

public class Please extends JFrame implements ActionListener{
    JPanel jp = new JPanel();
    JButton jb = new JButton();


    public Please() {
        setTitle("Penalty Defense!");
        setVisible(true);
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        URL url = null;
        try {
            url = new URL("https://cdn.discordapp.com/attachments/357657033547448323/665959917148045340/Soccerballs.jpg");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Image image= null;
        try {
            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        jb.setIcon(new ImageIcon(url));
        jp.add(jb);
        add(jp);
        jb.addActionListener(this);
        validate();
    }
    public static void main(String[]args){

        Please po = new Please();

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==jb){
            JFrame window = new JFrame();
            Second s = new Second();
            window.setSize(1600,1000);
            window.setTitle("Soccer");
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setVisible(true);
            window.setResizable(false);
            window.add(s);
        }

    }
}

