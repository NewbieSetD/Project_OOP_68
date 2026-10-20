import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuiGame extends JFrame implements ActionListener {
    CardLayout cardLayout;
    JPanel mainPanel;
    JButton goToPage2Btn, backToPage1Btn;
    JPanel page2, page1;
    JTextField datauser;
    JMenuItem AboutD;
    JOptionPane JOP;
    GamePanel game;
    private String inputstatus = "Unknow";
    String aboutContent;
    JLabel AmmoS, DeadS, KillS,KingS;
    String As, Ds, Ks,Kgs;

    GuiGame() {
        set_up();
        JMenuBar menuBar = new JMenuBar();
        JMenu About = new JMenu("[ ? ]");
        AboutD = new JMenuItem("About Dev");
        AboutD.addActionListener(this);
        About.add(AboutD);
        menuBar.add(About);
        add(menuBar, BorderLayout.NORTH);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        // page1 = new JPanel();
        // page1.setLayout(new GridBagLayout());
        // page1.setBackground(Color.LIGHT_GRAY);
        goToPage2Btn = new JButton("ไปหน้า 2");
        goToPage2Btn.setPreferredSize(new Dimension(180, 70));

        // gbc.gridx = 0;
        // gbc.gridy = 3;
        // page1.add(new JLabel("หน้า 1: Menu"),gbc);
        // gbc.gridx = 0;
        // gbc.gridy = 1;
        // page1.add(new JLabel("หน้า 1: เมนูหลัก"),gbc);
        // gbc.gridx = 0;
        // gbc.gridy = 2;
        // page1.add(goToPage2Btn,gbc);

        // page2 = new JPanel();
        // page2.setBackground(Color.CYAN);
        backToPage1Btn = new JButton("กลับหน้า 1");
        // page2.add(new JLabel("หน้า 2: การตั้งค่า"));
        // page2.add(backToPage1Btn);

        goToPage2Btn.addActionListener(e -> cardLayout.show(mainPanel, "SETTINGS_PAGE"));
        backToPage1Btn.addActionListener(e -> cardLayout.show(mainPanel, "MENU_PAGE"));

        // mainPanel.add(page1,"MENU_PAGE");
        // mainPanel.add(page2,"SETTINGS_Player player;PAGE");
        game = new GamePanel(this,"Myboy");
        game.requestFocusInWindow();
        mainPanel.add(game);
        cardLayout.show(mainPanel, "Main");
        add(mainPanel, BorderLayout.CENTER);
        JPanel statusPanel = new JPanel();
        statusPanel.setBackground(Color.WHITE);
        AmmoS = new JLabel("Ammo:: " + As);
        DeadS = new JLabel("Alive:: " + Ds);
        KillS = new JLabel("Kill:: " + Ks);
        KingS = new JLabel("Rank:: " + Kgs);
        statusPanel.add(AmmoS);
        statusPanel.add(DeadS);
        statusPanel.add(KillS);
        statusPanel.add(KingS);
        add(statusPanel, BorderLayout.SOUTH);
        // add(new JLabel("Hi"),BorderLayout.SOUTH);
        // add(new Button("Hi"));
        setStatusPanel();
    }

    private void set_up() {
        setTitle("Game");
        setSize(1024, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        JOP = new JOptionPane();
    }

    void Log_input(JTextField DT) {
        new Thread() {
            public void run() {
                try {
                    DT.setText(inputstatus);
                    Thread.sleep(2500);
                } catch (Exception e) {
                }
                DT.setText("");
            }

        }.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == AboutD) {
            setAboutDev();
            JOptionPane.showMessageDialog(
                    this,
                    aboutContent,
                    "เกี่ยวกับโปรแกรม (Aboutเบื้องต้น)",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void setAboutDev() {
        aboutContent = "<html>"
                + "<body style='width: 250px; font-family: Tahoma;'>"
                + "<h2 style='color: #1877F2; margin-bottom: 2px;'>Larp Pig Game</h2>"
                + "<b>Version:</b> Ahpla 0.0.1<br><br>"
                + "Project Game<br><hr>"
                + "<b>ผู้พัฒนา:</b><br>"
                + "• นาย ปานพรรณ จันอ่อน 68011212045<br>"
                + "• นาย ข. (รหัสนักศึกษา 650XXXXX)<br><br>"
                + "<small style='color: gray;'>© 2026 OOP Assignment. All rights reserved.</small>"
                + "</body>"
                + "</html>";
    }

    public void setStatusPanel() {
        if (game == null || game.getPlayer() == null) {
            As = "Unknow";
            Ds = "Unknow";
            Ks = "Unknow";
            Kgs = "Unknow";
        } else {
            As = String.format("%d", game.getAmmo());
            Ds = game.getAlive();
            Ks = String.format("%d", game.getKill());
            Kgs = game.getPlayer().status_rank();
        }
        if (AmmoS != null)
            AmmoS.setText("Ammo:: " + As);
        if (DeadS != null)
            DeadS.setText("Alive:: " + Ds);
        if (KillS != null)
            KillS.setText("Kill:: " + Ks);
        if (KingS != null)
            KingS.setText("Rank:: " + Kgs);
    }
}