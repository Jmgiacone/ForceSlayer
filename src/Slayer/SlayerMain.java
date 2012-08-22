package Slayer;

import java.awt.GridLayout;
import java.util.Arrays;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.powerbot.game.api.ActiveScript;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Quest;
import org.powerbot.game.api.methods.tab.Quest$QUEST;
import org.powerbot.game.api.methods.tab.Skills;

public class SlayerMain extends ActiveScript {

	@Override
	protected void setup() {
		
	}
	
	private class InitGameDialog extends JDialog {
		private JTextField numberOfStrengthPotions;
		private JTextField numberOfAttackPotions;
		private JTextField numberOfDefensePotions;
		private String[] slayerMasters = new String[7];
		private String[] copy;
		private int slayerLevel = Skills.getRealLevel(Skills.SLAYER);
		private int combatLevel = Players.getLocal().getLevel();
		private int index = 0;
		private JTextField amountOfFood;
		private JTextField amountOfPrayerPotions;
		private JTextField lootAllAbove;

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
			
			JComboBox<String> slayerMasterBox = new JComboBox<>();
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
			slayerMasterBox.setModel(new DefaultComboBoxModel<String>(copy));
			slayerMasterBox.setBounds(90, 8, 88, 20);
			panel.add(slayerMasterBox);
			
			JCheckBox chckbxNpcContactFor = new JCheckBox("NPC contact for new tasks?");
			chckbxNpcContactFor.setBounds(10, 32, 167, 23);
			panel.add(chckbxNpcContactFor);
			
			JCheckBox checkBox = new JCheckBox("Using bone crusher?");
			checkBox.setBounds(10, 58, 123, 23);
			panel.add(checkBox);
			
			JPanel panel_1 = new JPanel();
			tabbedPane.addTab("Combat Options", null, panel_1, null);
			
			JRadioButton rdbtnUseSafespots = new JRadioButton("Use safespots");
			
			JRadioButton rdbtnUseMagic = new JRadioButton("Use magic");
			
			JRadioButton rdbtnUseRange = new JRadioButton("Use range");
			
			JComboBox<String> strengthPotionBox = new JComboBox<String>();
			strengthPotionBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Strength potion", "Super strength potion", "Extreme strength potion", "None"}));
			
			numberOfStrengthPotions = new JTextField();
			numberOfStrengthPotions.setColumns(10);
			
			JLabel lblAmount = new JLabel("Amount:");
			
			JComboBox<String> attackPotionBox = new JComboBox<String>();
			attackPotionBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Attack potion", "Super attack potion", "Extreme attack potion", "None"}));
			
			JLabel lblAmount_1 = new JLabel("Amount:");
			
			numberOfAttackPotions = new JTextField();
			numberOfAttackPotions.setColumns(10);
			
			JComboBox<String> defensePotionBox = new JComboBox<String>();
			defensePotionBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Defense potion", "Super defense potion", "Extreme defense potion", "None"}));
			
			JLabel lblAmount_2 = new JLabel("Amount:");
			
			numberOfDefensePotions = new JTextField();
			numberOfDefensePotions.setColumns(10);
			
			JLabel lblFood = new JLabel("Food:");
			
			JComboBox<String> foodBox = new JComboBox<String>();
			foodBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Trout", "Cod", "Pike", "Salmon", "Tuna", "Bass", "Lobster", "Swordfish", "Monkfish", "Shark", "Cavefish", "Sea turtle", "Manta ray", "Tuna potato", "Rocktail"}));
			
			JLabel lblAmount_3 = new JLabel("Amount:");
			
			amountOfFood = new JTextField();
			amountOfFood.setColumns(10);
			
			JLabel lblSummoningFamiliar = new JLabel("Summoning familiar:");
			
			JComboBox<String> summoningFamiliarBox = new JComboBox<String>();
			summoningFamiliarBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Void spinner (34)", "Bunyip (68)", "Moss titan (79)", "Ice titan (79)", "Fire titan (79)", "Unicorn stallion (88)", "Pack yak (96)"}));
			
			JComboBox<String> prayerPotionBox = new JComboBox<String>();
			prayerPotionBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Prayer potion", "Super prayer potion"}));
			
			JLabel lblAmount_4 = new JLabel("Amount:");
			
			amountOfPrayerPotions = new JTextField();
			amountOfPrayerPotions.setColumns(10);
			
			JCheckBox chckbxPrayerRenewals = new JCheckBox("Prayer renewal potions?");
			
			JCheckBox chckbxQuickPrayers = new JCheckBox("Quick prayers?");
			GroupLayout gl_panel_1 = new GroupLayout(panel_1);
			gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(chckbxPrayerRenewals)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(chckbxQuickPrayers))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(prayerPotionBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblAmount_4)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(amountOfPrayerPotions, 0, 0, Short.MAX_VALUE))
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(rdbtnUseMagic)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblSummoningFamiliar))
									.addComponent(rdbtnUseRange)
									.addComponent(rdbtnUseSafespots)
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(strengthPotionBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblAmount)
										.addGap(4)
										.addComponent(numberOfStrengthPotions, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(attackPotionBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblAmount_1)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(numberOfAttackPotions, 0, 0, Short.MAX_VALUE))
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(defensePotionBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblAmount_2)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(numberOfDefensePotions, 0, 0, Short.MAX_VALUE))
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(lblFood)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(foodBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblAmount_3)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(amountOfFood, 0, 0, Short.MAX_VALUE)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(summoningFamiliarBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(65, Short.MAX_VALUE))
			);
			gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(rdbtnUseMagic)
							.addComponent(lblSummoningFamiliar)
							.addComponent(summoningFamiliarBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(rdbtnUseRange)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(rdbtnUseSafespots)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(strengthPotionBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblAmount)
							.addComponent(numberOfStrengthPotions, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(attackPotionBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblAmount_1)
							.addComponent(numberOfAttackPotions, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(defensePotionBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblAmount_2)
							.addComponent(numberOfDefensePotions, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblFood)
							.addComponent(foodBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblAmount_3)
							.addComponent(amountOfFood, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(prayerPotionBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblAmount_4)
							.addComponent(amountOfPrayerPotions, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(chckbxPrayerRenewals)
							.addComponent(chckbxQuickPrayers))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			panel_1.setLayout(gl_panel_1);
			
			JPanel panel_2 = new JPanel();
			tabbedPane.addTab("Loot options", null, panel_2, null);
			
			JCheckBox chckbxGoldCharms = new JCheckBox("Gold charms");
			
			JCheckBox chckbxGreenCharms = new JCheckBox("Green charms");
			
			JCheckBox chckbxCrimsonCharms = new JCheckBox("Crimson charms");
			
			JCheckBox chckbxBlueCharms = new JCheckBox("Blue charms");
			
			JCheckBox chckbxRingOfWealth = new JCheckBox("Ring of wealth drop table");
			
			JLabel lblLootAllItems = new JLabel("Loot all items above:");
			
			lootAllAbove = new JTextField();
			lootAllAbove.setColumns(10);
			
			JLabel lblGp = new JLabel("gp");
			
			JCheckBox chckbxBuryBonesscatterAshes = new JCheckBox("Bury bones/scatter ashes");
			GroupLayout gl_panel_2 = new GroupLayout(panel_2);
			gl_panel_2.setHorizontalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_2.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
							.addComponent(chckbxCrimsonCharms)
							.addComponent(chckbxBlueCharms)
							.addComponent(chckbxRingOfWealth)
							.addGroup(gl_panel_2.createSequentialGroup()
								.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
									.addComponent(chckbxGoldCharms)
									.addComponent(chckbxGreenCharms))
								.addGap(18)
								.addComponent(lblLootAllItems)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lootAllAbove, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblGp))
							.addComponent(chckbxBuryBonesscatterAshes))
						.addContainerGap(138, Short.MAX_VALUE))
			);
			gl_panel_2.setVerticalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_2.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
							.addComponent(chckbxGoldCharms)
							.addComponent(lblLootAllItems)
							.addComponent(lootAllAbove, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblGp))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(chckbxGreenCharms)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(chckbxCrimsonCharms)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(chckbxBlueCharms)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(chckbxRingOfWealth)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(chckbxBuryBonesscatterAshes)
						.addContainerGap(86, Short.MAX_VALUE))
			);
			panel_2.setLayout(gl_panel_2);
			
			JPanel panel_3 = new JPanel();
			tabbedPane.addTab("Startup", null, panel_3, null);
			
			JLabel lblBeforeStartingThe = new JLabel("Before starting the script, make sure you have all of your settings setup correctly.");
			
			JLabel lblForceSlayerIs = new JLabel("Force Slayer is in alpha, therefore you should expect bugs. If you encounter any");
			
			JLabel lblBugsPleaseReport = new JLabel("bugs, please report them to 9Ox or Jdog653 via private message on powerbot or");
			
			JLabel lblCreateANew = new JLabel("create a new post on the official script topic explaining the bug in detail.");
			
			JButton btnVisitOfficialScript = new JButton("Visit official script thread");
			
			JButton btnStartScript = new JButton("Start script");
			GroupLayout gl_panel_3 = new GroupLayout(panel_3);
			gl_panel_3.setHorizontalGroup(
				gl_panel_3.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_3.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_3.createSequentialGroup()
								.addComponent(btnVisitOfficialScript, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnStartScript, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
							.addComponent(lblBeforeStartingThe)
							.addComponent(lblForceSlayerIs)
							.addComponent(lblBugsPleaseReport)
							.addComponent(lblCreateANew))
						.addContainerGap())
			);
			gl_panel_3.setVerticalGroup(
				gl_panel_3.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_3.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblBeforeStartingThe)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblForceSlayerIs)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblBugsPleaseReport)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblCreateANew)
						.addGap(86)
						.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnVisitOfficialScript, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
							.addComponent(btnStartScript, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
						.addContainerGap())
			);
			panel_3.setLayout(gl_panel_3);
		}
	}
}
