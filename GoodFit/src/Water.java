import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;

public class Water extends JFrame {

	private JPanel contentPane;
	private JTextField textWeight;
    private JFrame frame;
	/**
	 * Launch the application.
	 */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Water();
            }
        });
    }


	/**
	 * Create the frame.
	 */
	public Water() {
		setBounds(100, 100, 200, 200);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel waterLabel = new JLabel("Your water norm");
		waterLabel.setBounds(50, 11, 108, 14);
		contentPane.add(waterLabel);
		
		textWeight = new JTextField();
		textWeight.setBounds(50, 36, 97, 20);
		contentPane.add(textWeight);
		textWeight.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Weight");
		lblNewLabel.setBounds(10, 36, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("kl");
		lblNewLabel_1.setBounds(155, 36, 37, 14);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(153, 204, 255));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"female ", "male "}));
		comboBox.setBounds(10, 67, 79, 20);
		contentPane.add(comboBox);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(99, 67, 59, 16);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_2 = new JLabel("ml");
		lblNewLabel_2.setBounds(165, 70, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton calcButton = new JButton("Calc");
		calcButton.setBounds(50, 97, 89, 23);
		contentPane.add(calcButton);
	
		JButton oK = new JButton("Ok");
		oK.setBounds(50, 131, 89, 23);
		contentPane.add(oK);
		
		calcButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				double w=Double.parseDouble(textWeight.getText());
				String male="male"; 
				String q=(String)comboBox.getSelectedItem();
				double i;
				if (q.equals(male)){
					i=w*35;
				}
				else { i=w*31;}
				
			 textArea.setText(Double.toString(i));
			}
		});
		
		oK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
	}
}
