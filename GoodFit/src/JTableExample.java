
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Color;
 
public class JTableExample {
 
    
    Object[] headers = { "Categories", "BMI " };
 
   
    Object[][] data = {
    		{"Underweight", "<18"},
    		{"Normal ", "18-25"},
    		{"Overweight", "25-29.9"},
    		{"Obesity", ">30"},
    };
 
    
    JTable jTab;
    JFrame jfrm = new JFrame("BMI Categories");
 
    JTableExample() {
        jfrm.getContentPane().setBackground(new Color(255, 228, 196));
       
        jfrm.setSize(304, 241);
        jfrm.setBounds(200, 200, 350, 250);
        jfrm.getContentPane().setLayout(null);
        
        JButton btnNewButton = new JButton("OK");
        btnNewButton.setBounds(143, 157, 47, 23);
        jfrm.getContentPane().add(btnNewButton);
        
        jTab = new JTable(data, headers);
        jTab.setModel(new DefaultTableModel(
        	new Object[][] {
        		{"UnderWeight", "<18"},
        		{"Normal ", "18-25"},
        		{"Overweight", "25-29.9"},
        		{"Obesity", ">30"},
        	},
        	new String[] {
        		"Categories", "BMI "
        	}
        ) {
        	Class[] columnTypes = new Class[] {
        		String.class, String.class
        	};
        	public Class getColumnClass(int columnIndex) {
        		return columnTypes[columnIndex];
        	}
        });

        JScrollPane jscrlp = new JScrollPane(jTab);
        jscrlp.setBounds(10, 37, 314, 93);
        jscrlp.setToolTipText("");
 
        jTab.setPreferredScrollableViewportSize(new Dimension(250, 100));

        jfrm.getContentPane().add(jscrlp);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jfrm.dispose();
            }
        });
    }
       
    


    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JTableExample();
            }
        });
    }




	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		jfrm.setVisible(true);
		
	}
}