import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JPanel jpnc = new JPanel(new GridLayout(2,2,3,3));
    private JPanel jpnp = new JPanel(new GridLayout(4,4,3,3));
    private JLabel jlb = new JLabel("");
    private JButton jbtn[][] = new JButton[4][4];
    private Container cp;
    public MainFrame(){
        this.init();
    }
    public void init(){
        this.setBounds(80,60,400,400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
        cp.add(jpnc,BorderLayout.NORTH);
        cp.add(jpnp,BorderLayout.CENTER);
        jpnc.add(jlb);
        jlb.setFont(new Font(null,Font.BOLD,36));
        jbtn[0][0] = new JButton("7");
        jbtn[0][1] = new JButton("8");
        jbtn[0][2] = new JButton("9");
        jbtn[0][3] = new JButton("/");
        jbtn[1][0] = new JButton("4");
        jbtn[1][1] = new JButton("5");
        jbtn[1][2] = new JButton("6");
        jbtn[1][3] = new JButton("*");
        jbtn[2][0] = new JButton("1");
        jbtn[2][1] = new JButton("2");
        jbtn[2][2] = new JButton("3");
        jbtn[2][3] = new JButton("-");
        jbtn[3][0] = new JButton("0");
        jbtn[3][1] = new JButton(".");
        jbtn[3][2] = new JButton("=");
        jbtn[3][3] = new JButton("+");
        for(int i = 0 ; i <= 3;i++){
            for(int j = 0 ; j <= 3;j++){
                jpnp.add(jbtn[i][j]);
            }
        }
        for(int i = 0 ; i <=3 ; i++){
            for(int j = 0 ; j <=3 ; j++){
                jbtn[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton jbt = (JButton) e.getSource();
                        jlb.setText(jlb.getText()+jbt.getText());
                    }
                });
            }
        }
    }
}
