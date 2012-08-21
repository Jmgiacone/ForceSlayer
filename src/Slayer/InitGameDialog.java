package Slayer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Quest;
import org.powerbot.game.api.methods.tab.Quest$QUEST;
import org.powerbot.game.api.methods.tab.Skills;
import javax.swing.JCheckBox;

public class InitGameDialog extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private String[] slayerMasters = new String[7];
	private String[] copy;
	private int slayerLevel = Skills.getRealLevel(Skills.SLAYER);
	private int combatLevel = Players.getLocal().getLevel();
	private int index = 0;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InitGameDialog dialog = new InitGameDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InitGameDialog() {
		setTitle("Force Slayer v0.01");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Setup", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Slayer Master:");
		lblNewLabel.setBounds(10, 11, 70, 14);
		panel.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		if (combatLevel >= 3) {
			slayerMasters[index] = "Turael";
			index++;
		}
		if (combatLevel >= 20) {
			slayerMasters[index] = "Mazchna";
			index++;
		}
		if (combatLevel >= 40) {
			slayerMasters[index] = "Vannaka";
			index++;
		}
		if (combatLevel >= 70 && Quest.isDoneWithQuest(Quest$QUEST.LOST_CITY)) {
			slayerMasters[index] = "Chaeldar";
			index++;
		}
		if (combatLevel >= 85 && slayerLevel >= 35 && Quest.isDoneWithQuest(Quest$QUEST.SMOKING_KILLS)) {
			slayerMasters[index] = "Sumona";
			index++;
		}
		if (combatLevel >= 100 && slayerLevel >= 50 && Quest.isDoneWithQuest(Quest$QUEST.SHILO_VILLAGE)) {
			slayerMasters[index] = "Duradel";
			index++;
		}
		if (combatLevel >= 110 && slayerLevel >= 75) {
			slayerMasters[index] = "Kuradal";
		}
		copy = Arrays.copyOfRange(slayerMasters, 0, index);
		comboBox.setModel(new DefaultComboBoxModel(copy));
		comboBox.setBounds(90, 8, 70, 20);
		panel.add(comboBox);
		
		JCheckBox chckbxNpcContactFor = new JCheckBox("NPC contact for new tasks?");
		chckbxNpcContactFor.setBounds(6, 30, 167, 23);
		panel.add(chckbxNpcContactFor);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Combat Options", null, panel_1, null);
		
		JRadioButton rdbtnUseSafespots = new JRadioButton("Use safespots");
		
		JRadioButton rdbtnUseMagic = new JRadioButton("Use magic");
		
		JRadioButton rdbtnUseRange = new JRadioButton("Use range");
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Strength potion", "Super strength potion", "Extreme strength potion"}));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount:");
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Attack potion", "Super attack potion", "Extreme attack potion"}));
		
		JLabel lblAmount_1 = new JLabel("Amount:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Defense potion", "Super defense potion", "Extreme defense potion"}));
		
		JLabel lblAmount_2 = new JLabel("Amount:");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblFood = new JLabel("Food:");
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Trout", "Cod", "Pike", "Salmon", "Tuna", "Bass", "Lobster", "Swordfish", "Monkfish", "Shark", "Cavefish", "Sea turtle", "Manta ray", "Tuna potato", "Rocktail"}));
		
		JLabel lblAmount_3 = new JLabel("Amount:");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(rdbtnUseMagic)
						.addComponent(rdbtnUseRange)
						.addComponent(rdbtnUseSafespots)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblAmount)
							.addGap(4)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblAmount_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_1, 0, 0, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblAmount_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_2, 0, 0, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblFood)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblAmount_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_3, 0, 0, Short.MAX_VALUE)))
					.addContainerGap(191, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(rdbtnUseMagic)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnUseRange)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnUseSafespots)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAmount)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAmount_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAmount_2)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFood)
						.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAmount_3)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Loot options", null, panel_2, null);
		
		JCheckBox chckbxGoldCharms = new JCheckBox("Gold charms");
		
		JCheckBox chckbxGreenCharms = new JCheckBox("Green charms");
		
		JCheckBox chckbxCrimsonCharms = new JCheckBox("Crimson charms");
		
		JCheckBox chckbxBlueCharms = new JCheckBox("Blue charms");
		
		JCheckBox chckbxRingOfWealth = new JCheckBox("Ring of wealth drop table");
		
		JCheckBox chckbxUsingBonecrusher = new JCheckBox("Using bone crusher?");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxGoldCharms)
						.addComponent(chckbxGreenCharms)
						.addComponent(chckbxCrimsonCharms)
						.addComponent(chckbxBlueCharms)
						.addComponent(chckbxRingOfWealth)
						.addComponent(chckbxUsingBonecrusher))
					.addContainerGap(276, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(chckbxGoldCharms)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxGreenCharms)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxCrimsonCharms)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxBlueCharms)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxRingOfWealth)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxUsingBonecrusher)
					.addContainerGap(89, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
	}
}
