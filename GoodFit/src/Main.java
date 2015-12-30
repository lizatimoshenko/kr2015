import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import java.awt.TextArea;
import javax.swing.JProgressBar;

public class Main extends JFrame {

	private static JFrame frame;
	private JPanel panel;
	private ArrayList<String> a = new ArrayList<String>();
	private JTabbedPane tabbedPane;
	private ButtonGroup group;
	private BgPanel panel1;
	private BgPanel panelCacl;
	private JRadioButton femaleButton, maleButton;
	private JSpinner spinner;
	private JButton caclButton, checkButton;
	private JTextField textWeight, textHeight;
	private JLabel panelName;
	private JLabel lblWeight, lblHeight, lblAge;
	private JLabel lblMetres, lblKg;
	private BgPanel panelResults;
	private JLabel lblIW, lblBMI, lblCalory, lblResults;
	private JTextArea resultIdeal, resultCalory, resultBMI;
	private JLabel lblIdealkg;
	private BgPanel workOut;
	private JButton stop, start, pause;
	private JPanel exercisePanel;
	private JButton button2, button1, button3, button4, button5;
	private JLabel lblNewLabel;
	private JLabel timerLabel;
    WaterBalance fl;
    private BgPanel waterBalance;
    private JButton btnNewButton;
    private JComboBox comboBox;
    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd ");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					Main window = new Main();
					window.frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("GoodFit");
		ImageIcon icon = new ImageIcon("E:/icon.png");
		frame.setIconImage(icon.getImage());
		frame.getContentPane().setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 16, 444, 255);
		frame.getContentPane().add(tabbedPane);

		panel1 = new BgPanel();
		URL url36 = Main.class.getResource("/11.jpg");
		panel1.setPath("%22%2F11.jpg%22");
		tabbedPane.addTab("Calculations", null, panel1, null);
		tabbedPane.setEnabledAt(0, true);
		panel1.setLayout(null);
		panel1.setBackground(new Color(0xb0aac2));

		/* / Panel Calculations / */
		group = new ButtonGroup();

		panelCacl = new BgPanel();
		URL url64 = Main.class.getResource("/2.jpg");
		panelCacl.setPath("url64");
		panelCacl.setBackground(new Color(0xf2efe8));
		panelCacl.setBounds(10, 11, 178, 199);
		panel1.add(panelCacl);
		panelCacl.setLayout(null);

		femaleButton = new JRadioButton("Female", false);
		femaleButton.setForeground(Color.WHITE);
		femaleButton.setBackground(new Color(0xf2efe8));
		femaleButton.setBounds(86, 26, 74, 23);
		panelCacl.add(femaleButton);
		femaleButton.setContentAreaFilled(false);
		femaleButton.setBorderPainted(false);

		maleButton = new JRadioButton("Male", true);
		maleButton.setForeground(Color.WHITE);
		maleButton.setBackground(new Color(0xf2efe8));
		maleButton.setBounds(26, 26, 59, 23);
		panelCacl.add(maleButton);
		maleButton.setContentAreaFilled(false);
		maleButton.setBorderPainted(false);

		group.add(maleButton);
		group.add(femaleButton);

		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(18.0, 1.0, 100.0, 1.0));
		spinner.setBounds(57, 112, 38, 20);
		panelCacl.add(spinner);

		caclButton = new JButton("Calc");
		caclButton.setBounds(45, 165, 86, 23);
		panelCacl.add(caclButton);

		textWeight = new JTextField();
		textWeight.setBounds(57, 53, 86, 20);
		panelCacl.add(textWeight);
		textWeight.setColumns(10);

		textHeight = new JTextField();
		textHeight.setBounds(57, 84, 86, 20);
		panelCacl.add(textHeight);
		textHeight.setColumns(10);

		panelName = new JLabel("Enter your data ");
		panelName.setForeground(Color.WHITE);
		panelName.setBounds(51, 5, 109, 14);
		panelCacl.add(panelName);

		lblWeight = new JLabel("Weight");
		lblWeight.setForeground(Color.WHITE);
		lblWeight.setBounds(10, 56, 46, 14);
		panelCacl.add(lblWeight);

		lblHeight = new JLabel("Height");
		lblHeight.setForeground(Color.WHITE);
		lblHeight.setBounds(10, 87, 46, 14);
		panelCacl.add(lblHeight);

		lblAge = new JLabel("Age");
		lblAge.setForeground(Color.WHITE);
		lblAge.setBounds(10, 119, 46, 14);
		panelCacl.add(lblAge);

		lblMetres = new JLabel("m");
		lblMetres.setForeground(Color.WHITE);
		lblMetres.setBounds(148, 87, 46, 14);
		panelCacl.add(lblMetres);

		lblKg = new JLabel("kg");
		lblKg.setForeground(Color.WHITE);
		lblKg.setBounds(148, 56, 46, 14);
		panelCacl.add(lblKg);

		panelResults = new BgPanel();
		URL url66 = Main.class.getResource("/2.jpg");
		panelResults.setPath("url66");
		panelResults.setBounds(197, 11, 224, 199);
		panel1.add(panelResults);
		panelResults.setLayout(null);

		lblIW = new JLabel("Ideal weight");
		lblIW.setForeground(Color.WHITE);
		lblIW.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIW.setBounds(10, 21, 89, 23);
		panelResults.add(lblIW);

		lblBMI = new JLabel("BMI");
		lblBMI.setForeground(Color.WHITE);
		lblBMI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBMI.setBounds(10, 55, 46, 28);
		panelResults.add(lblBMI);

		lblCalory = new JLabel("Calory");
		lblCalory.setForeground(Color.WHITE);
		lblCalory.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCalory.setBounds(10, 94, 46, 28);
		panelResults.add(lblCalory);

		lblResults = new JLabel("  Result");
		lblResults.setForeground(Color.WHITE);
		lblResults.setBounds(84, 0, 78, 23);
		panelResults.add(lblResults);

		resultIdeal = new JTextArea();
		resultIdeal.setBounds(95, 21, 67, 23);
		panelResults.add(resultIdeal);

		resultBMI = new JTextArea();
		resultBMI.setBounds(95, 60, 67, 23);
		panelResults.add(resultBMI);

		resultCalory = new JTextArea();
		resultCalory.setBounds(95, 99, 67, 23);
		panelResults.add(resultCalory);

		checkButton = new JButton("?");
		checkButton.setBounds(172, 60, 52, 23);
		panelResults.add(checkButton);

		checkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JTableExample table = new JTableExample();
				table.setVisible(true);
			}
		});

		lblIdealkg = new JLabel("kg");
		lblIdealkg.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdealkg.setForeground(Color.WHITE);
		lblIdealkg.setBounds(172, 27, 52, 17);
		panelResults.add(lblIdealkg);
		
		JLabel lblNewLabel_1 = new JLabel("cl");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(168, 102, 46, 14);
		panelResults.add(lblNewLabel_1);

		caclButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double h = Double.parseDouble(textHeight.getText());
				double w = Double.parseDouble(textWeight.getText());
				double currentAge = (Double) spinner.getValue();
				// double i;
				Calculations calc = new Calculations();
				resultBMI.setText(Double.toString(calc.BMI(h, w)));
				if (maleButton.isSelected()) {
					resultIdeal.setText(Double.toString(calc.idealMale(h)));
					resultCalory.setText(Double.toString(calc.maleCalory(h, w, currentAge)));
				} else {
					resultIdeal.setText(Double.toString(calc.idealFemale(h)));
					resultCalory.setText(Double.toString(calc.femaleCalory(h, w, currentAge)));
				}

			}
		});

		///// New Tab WorkOut ///
		workOut = new BgPanel();
		URL url11 = Main.class.getResource("/11.jpg");
		workOut.setPath("%22%2F1.jpg%22");
		workOut.setBackground(new Color(255, 204, 204));
		tabbedPane.addTab("WorkOut", null, workOut, null);
		workOut.setLayout(null);

		stop = new JButton("");
		URL url88 = Main.class.getResource("/stop.png");
		stop.setIcon(new ImageIcon(url88));
		stop.setBounds(374, 5, 65, 41);
		stop.setContentAreaFilled(false);
		stop.setBorderPainted(false);
		workOut.add(stop);

		timerLabel = new JLabel("");
		timerLabel.setForeground(new Color(255, 255, 240));
		URL url77 = Main.class.getResource("/timer.png");
		timerLabel.setIcon(new ImageIcon(url77));
		timerLabel.setHorizontalAlignment(SwingConstants.LEFT);
		timerLabel.setBackground(new Color(204, 102, 204));
		timerLabel.setFont(new Font("Wide Latin", Font.ITALIC, 29));
		timerLabel.setBounds(103, 5, 188, 41);
		workOut.add(timerLabel);

		start = new JButton("");
		URL url8 = Main.class.getResource("/start.png");
		start.setIcon(new ImageIcon(url8));
		start.setBounds(273, 5, 65, 41);
		start.setContentAreaFilled(false);
		start.setBorderPainted(false);
		workOut.add(start);
		int countdown = 60;
		final Timer timer = new Timer(1000, new ActionListener() {
			int countdown = 60;
			Timer timer1;

			@Override
			public void actionPerformed(ActionEvent e) {
				countdown--;
				timerLabel.setText(String.valueOf(countdown));
				if (countdown == 0) {
					URL url3 = Main.class.getResource("/zvonok.wav");
					Sound.playSound("url3").join();
					timer1.stop();
				}

			}

		});
          
		stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					timer.stop();
				}

			
		});

		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				workOut.add(timerLabel);
				workOut.validate();
				timerLabel.repaint();
				timer.start();

			}
		});

		pause = new JButton("");
		URL url7 = Main.class.getResource("/time.png");
		pause.setIcon(new ImageIcon(url7));
		pause.setBounds(335, 11, 42, 35);
		workOut.add(pause);

		pause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.stop();
			}
		});

		exercisePanel = new JPanel();
		exercisePanel.setBackground(new Color(255, 153, 153));
		exercisePanel.setBounds(10, 5, 72, 211);
		workOut.add(exercisePanel);
		exercisePanel.setLayout(null);

		lblNewLabel = new JLabel("      Exercise");
		lblNewLabel.setBounds(0, 8, 87, 14);
		exercisePanel.add(lblNewLabel);

		button2 = new JButton("");
		button2.setBounds(12, 52, 48, 23);
		exercisePanel.add(button2);
		button2.setForeground(new Color(0, 0, 0));
		URL url9 = Main.class.getResource("/2n.png");
		button2.setIcon(new ImageIcon(url9));
		button2.setContentAreaFilled(false);
		button2.setBorderPainted(false);

		button3 = new JButton("");
		button3.setBounds(12, 77, 48, 23);
		exercisePanel.add(button3);
		button3.setForeground(new Color(0, 0, 0));
		URL url = Main.class.getResource("/3n.png");
		button3.setIcon(new ImageIcon(url));
		button3.setContentAreaFilled(false);
		button3.setBorderPainted(false);

		button4 = new JButton("");
		button4.setBounds(12, 102, 48, 23);
		exercisePanel.add(button4);
		button4.setForeground(new Color(0, 0, 0));
		URL url1 = Main.class.getResource("/4n.png");
		button4.setIcon(new ImageIcon(url1));
		button4.setContentAreaFilled(false);
		button4.setBorderPainted(false);

		button5 = new JButton("");
		button5.setBounds(12, 127, 48, 23);
		exercisePanel.add(button5);
		button5.setForeground(new Color(0, 0, 0));
		URL url2 = Main.class.getResource("/5n.png");
		button5.setIcon(new ImageIcon(url2));
		button5.setContentAreaFilled(false);
		button5.setBorderPainted(false);

		button1 = new JButton("");
		button1.setBounds(12, 27, 48, 23);
		exercisePanel.add(button1);
		button1.setForeground(new Color(0, 0, 0));
		URL url3 = Main.class.getResource("/1n.png");
		button1.setIcon(new ImageIcon(url3));
		button1.setContentAreaFilled(false);
		button1.setBorderPainted(false);

		final JLabel imageLabel = new JLabel("");
		imageLabel.setBounds(168, 57, 250, 136);
		workOut.add(imageLabel);
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		JLabel bAdd = new JLabel("  Add ");
		bAdd.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int r = chooser.showDialog(panel, "ImageChooser");
				if (r == JFileChooser.APPROVE_OPTION) {
					String name = chooser.getSelectedFile().getPath();
					ImageIcon ii = new ImageIcon(name);
					ii.getImage();
					imageLabel.setIcon(new ImageIcon(ii.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
					;

				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		bAdd.setBounds(0, 161, 72, 23);
		exercisePanel.add(bAdd);

		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				URL url3 = Main.class.getResource("/1.gif");
				ImageIcon ii = new ImageIcon(url3);
				ii.getImage();
				imageLabel.setIcon(new ImageIcon(ii.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));

			}
		});

		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				URL url3 = Main.class.getResource("/2.gif");
				ImageIcon ii = new ImageIcon(url3);
				ii.getImage();
				imageLabel.setIcon(new ImageIcon(ii.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));

			}
		});
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				URL url3 = Main.class.getResource("/3.gif");
				ImageIcon ii = new ImageIcon(url3);
				ii.getImage();
				imageLabel.setIcon(new ImageIcon(ii.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));

			}
		});

		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				URL url3 = Main.class.getResource("/4.gif");
				ImageIcon ii = new ImageIcon(url3);
				ii.getImage();
				imageLabel.setIcon(new ImageIcon(ii.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));

			}
		});

		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				URL url3 = Main.class.getResource("/5.gif");
				ImageIcon ii = new ImageIcon(url3);
				ii.getImage();
				imageLabel.setIcon(new ImageIcon(ii.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));

			}
		});

		/////////////////////////////////////////////

	    waterBalance = new BgPanel();
	    URL url4 = Main.class.getResource("/1.jpg");
		waterBalance.setPath("url4");
		tabbedPane.addTab("WaterBalance", null, waterBalance, null);
		waterBalance.setLayout(null);

	    btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Water waterForm = new Water();
				waterForm.setVisible(true);
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		URL url5 = Main.class.getResource("/c.png");
		btnNewButton.setIcon(new ImageIcon(url5));
		btnNewButton.setBounds(348, 143, 81, 73);
		waterBalance.add(btnNewButton);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);

		comboBox = new JComboBox();
		comboBox.setModel(
				new DefaultComboBoxModel(new String[] { "tea", "coffee", "vine", "beer ", "lemonade", "water" }));
		comboBox.setBounds(130, 36, 81, 20);
		waterBalance.add(comboBox);

		JSpinner spinnerML = new JSpinner();
		spinnerML.setModel(new SpinnerNumberModel(100.0, 50.0, 3000.0, 50.0));
		spinnerML.setBounds(277, 36, 63, 20);
		waterBalance.add(spinnerML);

		JButton addToLog = new JButton("Add");
		addToLog.setBounds(361, 35, 68, 23);
		waterBalance.add(addToLog);
         
		TextArea textArea = new TextArea();
		textArea.setBounds(10, 73, 332, 143);
		waterBalance.add(textArea);
		
		JTextArea daily = new JTextArea();
		daily.setBounds(359, 103, 70, 16);
		waterBalance.add(daily);
		double amount=0;
		Set<String> n;
		try {
			fl = new WaterBalance();
			n = fl.getBeverage().keySet();
			Iterator<String> itr = n.iterator();
			
			while (itr.hasNext()) {
				String s = itr.next();
				for(int i=0;i<fl.getBeverage().get(s).size();i++){
				String ml = fl.getBeverage().get(s).get(i).getName();
				Double q = fl.getBeverage().get(s).get(i).getKol();
				amount=amount+q;
				textArea.setText(textArea.getText()+"\n" +s+" "+ ml+" "+ q+" ml");
				a.add(s);
				daily.setText(Double.toString(amount));
				}
			}
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		 
		addToLog.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Date  currentDate = new Date();
				String d=date.format(currentDate).toString();
				String b = (String) comboBox.getSelectedItem();
				double tmp = (Double) spinnerML.getValue();
				String ml = Double.toString(tmp);
			    try {
					fl.addToFile(d,b,tmp);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textArea.setText(textArea.getText() + "\n" + d+ " "+(String) comboBox.getSelectedItem() + " "
						+ (Double) spinnerML.getValue()+"ml");
				textArea.repaint();
				a.add(Double.toString((Double) spinnerML.getValue()));
			}
		});
		JLabel beverage = new JLabel("Chose beverage");
		beverage.setForeground(Color.CYAN);
		beverage.setBounds(10, 39, 110, 14);
		waterBalance.add(beverage);

		JLabel amountOfBeverage = new JLabel("     ml");
		amountOfBeverage.setForeground(Color.CYAN);
		amountOfBeverage.setBounds(221, 39, 46, 14);
		waterBalance.add(amountOfBeverage);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("     Daily amount");
		lblNewLabel_2.setForeground(Color.CYAN);
		lblNewLabel_2.setBounds(348, 83, 81, 14);
		waterBalance.add(lblNewLabel_2);
		
		
	

	}
}
