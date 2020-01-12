import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;


public class Second extends JPanel implements ActionListener, KeyListener {
    Timer t = new Timer(3, this);
    double x = 800, y = 1000;
    int x1 = 800, y1 = 500;
    private int ranX = (int) (Math.random() * 1000) + 50;
    private int ranY = (int) (Math.random() * 400);
    private double velX = 1;
    private double velY = 1;
    double velx, vely;

    public Second() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1600, 1000);
        g.setColor(Color.WHITE);
        g.fillRect(70, 90, 25, 420);
        g.fillRect(1150, 90, 25, 420);
        g.fillRect(70, 90, 1100, 25);
        for (int i = 70; i < 1170; i += 20) {
            g.drawLine(i, 90, i, 510);
        }
        for (int i = 120; i < 520; i += 20) {
            g.drawLine(70, i, 1170, i);
        }
        Graphics2D g2 = (Graphics2D) g;
        t.start();
        g.setColor(Color.GREEN);
        g2.fillRect(x1, y1, 70, 70);
        g.setColor(Color.DARK_GRAY);
        Ellipse2D c1 = new Ellipse2D.Double(x, y, 50, 50);
        g2.fill(c1);
        g.setColor(Color.RED);
        Ellipse2D c2 = new Ellipse2D.Double(ranX, ranY, 50, 50);
        g2.fill(c2);
    }

    public void actionPerformed(ActionEvent e) {
        if (Math.abs(ranX - x) <= 5 && (y - ranY) <= 5) {
            //System.out.println("You Lost!");

            return;
        } else if (Math.abs(ranX - x1) <= 10 && (y - ranY) <= 10) {
            System.out.println("You Won!");
            return;
        }
        if (ranX > ranY) {
            velX = (ranX - x) / (y - ranY);
            velY = 1;
        } else {
            if (ranX < x) {
                velY = (y - ranY) / (x - ranX);
                velX = -1;
            } else {
                velY = (y - ranY) / (ranX - x);
                velX = 1;
            }
        }
        x += 7 * velX;
        y -= 7 * velY;
        x1 += velx;
        y1 += vely;
        repaint();
    }

    public void up() {
        vely = -10;
        velx = 0;
    }

    public void down() {
        vely = 10;
        velx = 0;
    }

    public void left() {
        velx = -10;
        vely = 0;
    }

    public void right() {
        velx = 10;
        vely = 0;
    }

    public void Space() {
    velx =0;
    vely =0;
        if (Math.abs(ranX-x1) <= 50 || Math.abs(ranY-y1) <=50 ){
            System.out.println("YOU WON! CONGRATS, THAT IS VERY IMPRESSIVE!");
            System.out.println (ranX-x1);
            System.out.println (ranY-y1);

        }else{
            System.out.println("Better luck next time");
        }
}
    public void keyPressed(KeyEvent e){
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_UP){
            up();
        }
        if(code == KeyEvent.VK_DOWN){
            down();
        }
        if(code == KeyEvent.VK_LEFT){
            left();
        }
        if(code == KeyEvent.VK_RIGHT){
            right();
        }
        if (code == KeyEvent.VK_SPACE){
            Space();
        }
    }
    public void keyTyped(KeyEvent e){}
    public void keyReleased(KeyEvent e){}
}

