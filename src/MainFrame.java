import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JPanel jpnc = new JPanel(new GridLayout(2,2,3,3));
    private JPanel jpnp = new JPanel(new GridLayout(4,4,3,3));
    private JLabel jlb = new JLabel(" ");
    private JButton jbtn[][] = new JButton[4][5];
    private Container cp;
    int op = -1;
    double v1 = 0;
    double v2 = 0;
    public MainFrame(){
        this.init();
    }
    public void init(){
        this.setBounds(200,300,600,600);
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
        jbtn[0][4] = new JButton("AC");
        jbtn[1][0] = new JButton("4");
        jbtn[1][1] = new JButton("5");
        jbtn[1][2] = new JButton("6");
        jbtn[1][3] = new JButton("*");
        jbtn[1][4] = new JButton("SQRT");
        jbtn[2][0] = new JButton("1");
        jbtn[2][1] = new JButton("2");
        jbtn[2][2] = new JButton("3");
        jbtn[2][3] = new JButton("-");
        jbtn[2][4] = new JButton("PI");
        jbtn[3][0] = new JButton("0");
        jbtn[3][1] = new JButton(".");
        jbtn[3][2] = new JButton("=");
        jbtn[3][3] = new JButton("+");
        jbtn[3][4] = new JButton("Exit");
        for(int i = 0 ; i < 4;i++){
            for(int j = 0 ; j <5;j++){
                jpnp.add(jbtn[i][j]);
                jbtn[i][j].setFont(new Font(null,Font.BOLD,25));
            }
        }
        for(int i = 0 ; i <4 ; i++){
            for(int j = 0 ; j <5 ; j++){
                jbtn[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton jbt = (JButton) e.getSource();
                        jlb.setText(jlb.getText()+jbt.getText());
                        switch (jbt.getText()){
                            case "AC":
                                jlb.setText("0");
                                break;
                            case "PI":
                                jlb.setText(Double.toString(Math.PI));
                                break;
                            case "Exit":
                                System.exit(0);
                                break;
                            case "0":
                                op = -1;
                                break;
                            case "+":
                                op = 0;
                                v1 = Double.parseDouble(jlb.getText());
                                break;
                            case "=":
                                v2 = Double.parseDouble(jlb.getText());
                                double v3 = 0;
                                switch (op){
                                    case 0:
                                        v3 = v1+v2;
                                        break;
                                }
                                jlb.setText(Double.toString(v3));
                                op = -1;
                        }
                    }
                });
            }
        }
    }
}
