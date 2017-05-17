package nano_analytics;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class Analytics {

	private JFrame frame;
	private String filename;
	static JTextField exprName;
	private String name_index;
	private String exprType_index;
	static JComboBox paramType_1;
	private JComboBox settingType;
	
	static String typeSet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Analytics window = new Analytics();
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
	public Analytics() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 385, 194);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnAnalytics = new JButton("Analytics ");
		btnAnalytics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Configurations.main();
//				try {
////					name_index = exprName.getText();
////					exprType_index = String.valueOf(paramType_1.getSelectedItem());
////					filename = System.getProperty("user.dir") + "/" + name_index + exprType_index + ".csv";
////					System.out.println(filename);
////					System.out.println("Working Directory = " + System.getProperty("user.dir"));
////					reading_data.loadfile(filename);
////					Configurations.main();
//					reading_data.locate_file();
//					//data_vault.generate_XYdata();
//				} catch (NumberFormatException | IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
			}
		});
		
		JButton btnClose = new JButton("Close Application");
		btnClose.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {System.exit(0); }
			});
//		btnClose.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				//frame.dispose();
//				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			}
//		});
		
		JLabel lblEnterExperimentName = new JLabel("Enter experiment name ");
		exprName = new JTextField();
		exprName.setColumns(10);
		
		JLabel lblSelectExperimentType = new JLabel("Parameter type");
		String[] exprIDs = {"A", "B", "1", "2"};
		paramType_1 = new JComboBox(exprIDs);
		
		//JComboBox settingType = new JComboBox();
		String[] setType = {"select setting type", "experiment", "calibration"};
		settingType = new JComboBox(setType);
		settingType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//for (int i = 0; i < selectedItem.length; i++){

				Object selectedItem = settingType.getSelectedItem();
				if (selectedItem == "experiment"){
				    System.out.println(selectedItem);
				    typeSet = "experiment";
				}else if (selectedItem == "calibration"){
					System.out.println(selectedItem);
					typeSet = "calibration";
				}
				//}
			}
		});
		
		JLabel lblCalibrationExperiment = new JLabel("Calibration / Experiment");
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblEnterExperimentName)
								.addComponent(lblSelectExperimentType))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(exprName, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
								.addComponent(paramType_1, 0, 186, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnAnalytics, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblCalibrationExperiment, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(settingType, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnClose, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))))
					.addGap(26))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterExperimentName)
						.addComponent(exprName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(paramType_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSelectExperimentType))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(settingType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCalibrationExperiment))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAnalytics, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
						.addComponent(btnClose, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addGap(108))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
