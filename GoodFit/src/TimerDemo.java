import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
 
 
public class TimerDemo extends JPanel {
    
    private JLabel timeLabel;
    private Timer timer;
    private JButton start;
    
    public TimerDemo() {
   
        setLayout(new FlowLayout());
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Monospaced", Font.BOLD, 8));
        timer = new Timer(1000, new TimerTick());
        start = new JButton("Start");
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                remove(start);
                add(timeLabel);
                validate();
                repaint();
                timer.start();
            }
        });
        
        add(start);
        setPreferredSize(new Dimension(300, 150));
       
    }
 
    public static void main(String[] args) {
        new TimerDemo().setVisible(true);
    }
    
    class TimerTick implements ActionListener {
        
        int countdown = 60;
    
        @Override
        public void actionPerformed(ActionEvent e) {
            countdown--;
            timeLabel.setText(String.valueOf(countdown));
            if (countdown == 0) {
                timer.stop();
                timeLabel.setText("START!");
            }
        }
        
    }
}