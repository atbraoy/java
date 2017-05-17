package nano_analytics;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Configurations {

	private JFrame frame;
	private JTextField start_exprNode;
	private JTextField end_exprNode;
	private JTextField exprStart;
	static JTextField start_refNode;
	static JTextField end_refNode;
	private JTextField calibEnd;
	private JTextField calibStart;
	private JTextField exprEnd;
	
	static Integer refNode_start;
	static Integer refNode_end;
	static Integer startCalib;
	static Integer endCalib;
	
	static Integer exprNode_start;
	static Integer exprNode_end;
	static Integer startExpr;
	static Integer endExpr;
	
	

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Configurations window = new Configurations();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Configurations() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Configurations Panel");
		frame.setBounds(100, 100, 441, 359);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel exprPanel = new JPanel();
		exprPanel.setBorder(BorderFactory.createTitledBorder("   Experiments Nodes Configurations  "));
		
		JPanel refPanel = new JPanel();
		refPanel.setBorder(BorderFactory.createTitledBorder("   Reference Nodes Configurations  "));
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(refPanel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(exprPanel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 428, Short.MAX_VALUE))
					.addContainerGap(7, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(191, Short.MAX_VALUE)
					.addComponent(btnClose)
					.addGap(171))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(refPanel, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(exprPanel, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnClose)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		
		JLabel lblRefNodes = new JLabel("Select reference nodes");
		JLabel lbl_refFrom = new JLabel("From");
		start_refNode = new JTextField();
		start_refNode.setColumns(10);
		
		JLabel lbl_refTo = new JLabel("To");
		end_refNode = new JTextField();
		end_refNode.setColumns(10);
		
		JLabel lblRefNums = new JLabel("Enter number of calibrations (references)");
		JLabel lbl_calibFrom = new JLabel("From");		
		calibStart = new JTextField();
		calibStart.setColumns(10);
		
		JLabel lbl_calibTo = new JLabel("To");
		calibEnd = new JTextField();
		calibEnd.setColumns(10);
		
		JButton btn_refSubmit = new JButton("Submit");
		btn_refSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters_vault.nodes(start_refNode.getText(), end_refNode.getText());
				parameters_vault.index(calibStart.getText(), calibEnd.getText());
				
				     try {
				    	 //data_vault.generate_data();
				    	 //plotting.main(Integer.valueOf(start_refNode.getText()), Integer.valueOf(end_refNode.getText()));
				    	 //ScatterAdd.main();
				    	 //Analyze.main();
				    	 meanData_Plotter.main();
				    	 rawData_Plotter.main();
				    	// ploting_test.main();
					} catch (NumberFormatException | IOException | InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		
		GroupLayout gl_refPanel = new GroupLayout(refPanel);
		gl_refPanel.setHorizontalGroup(
			gl_refPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_refPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_refPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_refPanel.createSequentialGroup()
							.addComponent(lblRefNodes)
							.addPreferredGap(ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
							.addComponent(lbl_refFrom))
						.addGroup(gl_refPanel.createSequentialGroup()
							.addComponent(lblRefNums)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lbl_calibFrom)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_refPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btn_refSubmit, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
						.addGroup(gl_refPanel.createSequentialGroup()
							.addGroup(gl_refPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(calibStart, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
								.addComponent(start_refNode, 0, 0, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_refPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lbl_refTo)
								.addComponent(lbl_calibTo))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_refPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(calibEnd, 0, 0, Short.MAX_VALUE)
								.addComponent(end_refNode, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))))
					.addGap(75))
		);
		gl_refPanel.setVerticalGroup(
			gl_refPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_refPanel.createSequentialGroup()
					.addGroup(gl_refPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_refPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_refPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbl_refTo)
								.addComponent(end_refNode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(start_refNode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addGroup(gl_refPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(calibEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_calibTo)))
						.addGroup(gl_refPanel.createSequentialGroup()
							.addGap(16)
							.addGroup(gl_refPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbl_refFrom)
								.addComponent(lblRefNodes))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_refPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(calibStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_calibFrom)
								.addComponent(lblRefNums))))
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addComponent(btn_refSubmit)
					.addContainerGap())
		);
		refPanel.setLayout(gl_refPanel);
		
		JLabel lbExprNode = new JLabel("Select nodes to analyze");
		JLabel lblFrom = new JLabel("From");	
		start_exprNode = new JTextField();
		start_exprNode.setColumns(10);

		JLabel lblTo = new JLabel("To");
		end_exprNode = new JTextField();
		end_exprNode.setColumns(10);
		
		JLabel lblExprNums = new JLabel("Enter number of experiments executed");
		JLabel lbl_exprFrom = new JLabel("From");
		exprStart = new JTextField();
		exprStart.setColumns(10);
		
		JLabel lbl_exprTo = new JLabel("To");
		exprEnd = new JTextField();
		exprEnd.setColumns(10);
		
		JButton btn_exprSubmit = new JButton("Submit");
		btn_exprSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exprNode_start = Integer.valueOf(start_exprNode.getText());
				  exprNode_end = Integer.valueOf(end_exprNode.getText());
				  	 startExpr = Integer.valueOf(exprStart.getText());
				  	   endExpr = Integer.valueOf(exprEnd.getText());
			}
		});
		
		
//		for (int i = 0, n = ITEMS.length; i < n; i++) {
//		      list.add(ITEMS[i]);
//		    }
		

//		DefaultListModel model = new DefaultListModel();
//		String[] select = {"19", "20", "22"};
//		String i = "a";
//        model.addElement(list.i);
		
		GroupLayout gl_exprPanel = new GroupLayout(exprPanel);
		gl_exprPanel.setHorizontalGroup(
			gl_exprPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_exprPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_exprPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblExprNums)
						.addComponent(lbExprNode))
					.addGap(12)
					.addGroup(gl_exprPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFrom)
						.addComponent(lbl_exprFrom))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_exprPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btn_exprSubmit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
						.addGroup(gl_exprPanel.createSequentialGroup()
							.addGroup(gl_exprPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(exprStart, 0, 0, Short.MAX_VALUE)
								.addComponent(start_exprNode, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_exprPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lbl_exprTo)
								.addComponent(lblTo))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_exprPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(end_exprNode, 0, 0, Short.MAX_VALUE)
								.addComponent(exprEnd, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))))
					.addGap(32))
		);
		gl_exprPanel.setVerticalGroup(
			gl_exprPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_exprPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_exprPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_exprPanel.createSequentialGroup()
							.addGroup(gl_exprPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFrom)
								.addComponent(start_exprNode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTo)
								.addComponent(end_exprNode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_exprPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_exprPanel.createParallelGroup(Alignment.BASELINE)
									.addComponent(lbl_exprTo)
									.addComponent(exprEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_exprPanel.createParallelGroup(Alignment.BASELINE)
									.addComponent(lbl_exprFrom)
									.addComponent(exprStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btn_exprSubmit))
						.addGroup(Alignment.TRAILING, gl_exprPanel.createSequentialGroup()
							.addComponent(lbExprNode)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblExprNums)
							.addGap(47)))
					.addGap(15))
		);
		exprPanel.setLayout(gl_exprPanel);
		frame.getContentPane().setLayout(groupLayout);
	}
}
