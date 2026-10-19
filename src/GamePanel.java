import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable, KeyListener {
    private Player pla;
    private Image CharPla;
    private boolean isRunning = false;
    private final int FPS = 60;
    private int[][] spawn = {
            { 100, 90 },
            { 900, 90 },
            { 100, 540 },
            { 900, 540 }
    };
    int[] arrsetSpaw;
    Random rnd = new Random();
    boolean Reday;
    int xP, yP;
    int imgW = 24; // ความกว้างของรูปภาพ
    int imgH = 24;
    String dataMOVE;

    GamePanel(Player pla) {
        setBackground(Color.LIGHT_GRAY);
        this.pla = pla;
        setFocusable(true);
        CharPla = Toolkit.getDefaultToolkit()
                .createImage(System.getProperty("user.dir") + "/Image/Player_dummy.png");

        arrsetSpaw = spawn[rnd.nextInt(spawn.length)];
        this.pla = new Player("Boy", arrsetSpaw[0] - 6, arrsetSpaw[1] - 6);
        System.out.printf("%s", pla);
        xP = this.pla.getPoseX();
        yP = this.pla.getPoseY();
        dataMOVE = this.pla.getMOVE();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("คลิกที่ตำแหน่ง: " + e.getX() + ", " + e.getY());
            }
        });
        addKeyListener(this);
        startGameThread();
        CharPla.getWidth(this);
    }

    public void startGameThread() {
        Thread gameThread = new Thread(this);
        isRunning = true;
        gameThread.start(); 
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (int[] point : spawn) {
            int x = point[0];
            int y = point[1];
            g2d.setColor(Color.RED);
            g2d.fillRect(x, y, 10, 10);
        }
        if (this.pla != null) {
            g2d.rotate(Math.toRadians(pla.getStatusTrun()), pla.getPoseX() + (imgW / 2), pla.getPoseY() + (imgH / 2));
            g2d.drawImage(CharPla, xP, yP, imgW, imgH, this);
            g2d.dispose();
        }
    }

    @Override
    public void run() {
        double drawInterval = 1000000000.0 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (isRunning) {
            // 1. สั่งวาดหน้าจอใหม่
            repaint();

            try {
                // 2. คำนวณเวลาที่เหลือในเฟรมนี้ก่อนถึงเวลาต้องวาดเฟรมถัดไป
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;
                if (remainingTime < 0) {
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);

                // ตั้งเวลาสำหรับเป้าหมายเฟรมถัดไป
                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (pla == null || pla.isDead())
            return;
        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
            pla.setStatusMove(+90);
             dataMOVE = this.pla.getMOVE();
        }
        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
            pla.setStatusMove(-90);
             dataMOVE = this.pla.getMOVE();
        }
        if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
            pla.move(1);
            xP = pla.getPoseX();
            yP = pla.getPoseY();
        }
        if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
            pla.move(-1);
            xP = pla.getPoseX();
            yP = pla.getPoseY();
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
}