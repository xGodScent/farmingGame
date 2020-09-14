// [PACKAGE]
package farmingGame;

// [LIBS]
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit; 
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


// [SETUP]
public class gameMain extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// window setup
					gameMain frame = new gameMain();
					frame.setTitle("Farming Simulator");
					frame.setVisible(true);
					frame.setResizable(false);
										
					// centers window
					Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
			        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
			        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
			        frame.setLocation(x, y);
			        
			        // code that makes a thread run clock / time
			        
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}	

	// [VARIABLES]
	String tool;
	ArrayList<String> tags = new ArrayList<String>();
	
	// -1 = temp / latest save
	static int current_save = -1;
	static int crop = -1;
	
	// (in seconds)
	int crop1TimeLeft = 256;
	int crop2TimeLeft = 256;
	int crop3TimeLeft = 256;
	int crop4TimeLeft = 256;
	
	
	// [WINDOW]
	public gameMain() {
		setResizable(false);
		// window setup final
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(124, 74, 64, 64);
		getContentPane().add(lblNewLabel);
		
		setDefaultCloseOperation(handleClose(0));
		
		// handles crop updates
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 0));
		contentPane.setForeground(new Color(255, 228, 196));
		contentPane.setBorder(new EmptyBorder(55, 55, 55, 55));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\textures\\icon.png"));
		
		
		// [LABELS]
		JLabel crop1 = new JLabel("PLACEHOLDER");
		crop1.setBackground(new Color(165, 42, 42));
		crop1.setBounds(233, 136, 128, 128);
		contentPane.add(crop1);
		
		JLabel crop2 = new JLabel("PLACEHOLDER");
		crop2.setBackground(new Color(165, 42, 42));
		crop2.setBounds(233, 280, 128, 128);
		contentPane.add(crop2);
		
		JLabel crop3 = new JLabel("PLACEHOLDER");
		crop3.setBackground(new Color(165, 42, 42));
		crop3.setBounds(381, 280, 128, 128);
		contentPane.add(crop3);
		
		JLabel crop4 = new JLabel("PLACEHOLDER");
		crop4.setBackground(new Color(165, 42, 42));
		crop4.setBounds(381, 136, 128, 128);
		contentPane.add(crop4);
	
		
		// replaces "placeholder" text in crop labels to dirt_texture.png image
		ImageIcon dirt_texture = new ImageIcon(".\\textures\\dirt_texture.png");
		ImageIcon dirt_texture_watered = new ImageIcon(".\\textures\\dirt_texture_watered.png");
		
		ImageIcon dirt_seeds_texture = new ImageIcon(".\\textures\\dirt_seeds_texture.png");
		ImageIcon dirt_seeds_texture_watered = new ImageIcon(".\\textures\\dirt_seeds_texture_watered.png");
		
		ImageIcon growth_stage_1 = new ImageIcon(".\\textures\\growth_stage_1.png");
		ImageIcon growth_stage_1_watered = new ImageIcon(".\\textures\\growth_stage_1_watered.png");
		
		crop1.setIcon(dirt_texture);
		crop2.setIcon(dirt_texture);
		crop3.setIcon(dirt_texture);
		crop4.setIcon(dirt_texture);
		
		
		// [BUTTONS]
		// [BUTTON SETUP]
		JLabel showToolLabel = new JLabel("Tool Selected: None");
		showToolLabel.setForeground(Color.WHITE);
		showToolLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		showToolLabel.setBounds(233, 11, 276, 39);
		contentPane.add(showToolLabel);
		
		JToggleButton btnPlantSeed = new JToggleButton("Plant Seed");
		btnPlantSeed.setBackground(new Color(128, 128, 0));
		btnPlantSeed.setBounds(613, 163, 100, 75);
		contentPane.add(btnPlantSeed);
		
		JToggleButton applyWater = new JToggleButton("Water \r\nCrop");
		applyWater.setBackground(new Color(153, 50, 204));
		applyWater.setBounds(613, 249, 100, 75);
		contentPane.add(applyWater);
		
		JToggleButton fertilizePlant = new JToggleButton("Fertilize");
		fertilizePlant.setBackground(new Color(160, 82, 45));
		fertilizePlant.setBounds(613, 333, 100, 75);
		contentPane.add(fertilizePlant);
		
		
		// [ACTION LISTENERS]
		// seeds button
		btnPlantSeed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (btnPlantSeed.isSelected()) {
					
					tool = "seeds";
					showToolLabel.setText("Tool Selected: " + tool);
					
					applyWater.setSelected(false);
					fertilizePlant.setSelected(false);
			
				} 
				else {
					
					tool = "None";
					showToolLabel.setText("Tool Selected: " + tool);
					
					btnPlantSeed.setSelected(false);
					applyWater.setSelected(false);
					fertilizePlant.setSelected(false);
					
				}
											
			}
		});
		
		// water button
		applyWater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (applyWater.isSelected()) {
					
					tool = "water";
					showToolLabel.setText("Tool Selected: " + tool);
					
					btnPlantSeed.setSelected(false);
					fertilizePlant.setSelected(false);
					
				} 
				else {
					
					tool = "None";
					showToolLabel.setText("Tool Selected: " + tool);
					
					btnPlantSeed.setSelected(false);
					applyWater.setSelected(false);
					fertilizePlant.setSelected(false);
					
				}
				
			}
		});
		
		// fertilize button
		fertilizePlant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (fertilizePlant.isSelected()) {
					
					tool = "fertilize";
					showToolLabel.setText("Tool Selected: " + tool);
					
					btnPlantSeed.setSelected(false);
					applyWater.setSelected(false);
				
				}
				else {
					
					tool = "None";
					showToolLabel.setText("Tool Selected: " + tool);
					
					btnPlantSeed.setSelected(false);
					applyWater.setSelected(false);
					fertilizePlant.setSelected(false);

				}
				
			}
		});
		
		
		// [GAME MECHANICS]
		crop1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				crop = 1;
				
				if (tool == "seeds" && gameLoadSave.load(crop, current_save).contains("seed_planted=false")) {
					
					if (crop1.getIcon() == dirt_texture) {
						
						crop1.setIcon(dirt_seeds_texture);
						
					}
					
					else if (gameLoadSave.load(crop, current_save).contains("watered=true")) {
						
						crop1.setIcon(dirt_seeds_texture_watered);
						
					}					
									
					gameLoadSave.save("seed_planted=true", crop, current_save);
					gameLoadSave.save("stage=0", crop, current_save);
					gameLoadSave.save("sick=false", crop, current_save);
					
				}
					
				else if (tool == "water" && gameLoadSave.load(crop, current_save).contains("watered=false")) {
					
					ImageIcon newTexture = new ImageIcon(String.valueOf(crop1.getIcon()).replace(".png", "_watered.png"));
					crop1.setIcon(newTexture);
					
					gameLoadSave.save("watered=true", crop, current_save);
					
				}			
				
				tool = "None";
				showToolLabel.setText("Tool Selected: " + tool);
				btnPlantSeed.setSelected(false);
				applyWater.setSelected(false);
				fertilizePlant.setSelected(false);
				
			}
		});
		
		crop2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				crop = 2;
				
				if (tool == "seeds" && gameLoadSave.load(crop, current_save).contains("seed_planted=false")) {
					
					if (crop2.getIcon() == dirt_texture) {
						
						crop2.setIcon(dirt_seeds_texture);
						
					}
					
					else if (gameLoadSave.load(crop, current_save).contains("watered=true")) {
						
						crop2.setIcon(dirt_seeds_texture_watered);
						
					}					
									
					gameLoadSave.save("seed_planted=true", crop, current_save);
					gameLoadSave.save("stage=0", crop, current_save);
					gameLoadSave.save("sick=false", crop, current_save);
					
				}
					
				else if (tool == "water" && gameLoadSave.load(crop, current_save).contains("watered=false")) {
					
					ImageIcon newTexture = new ImageIcon(String.valueOf(crop2.getIcon()).replace(".png", "_watered.png"));
					crop2.setIcon(newTexture);
					
					gameLoadSave.save("watered=true", crop, current_save);
					
				}			
				
				tool = "None";
				showToolLabel.setText("Tool Selected: " + tool);
				btnPlantSeed.setSelected(false);
				applyWater.setSelected(false);
				fertilizePlant.setSelected(false);
				
			}
		});
		
		crop3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				crop = 3;
				
				if (tool == "seeds" && gameLoadSave.load(crop, current_save).contains("seed_planted=false")) {
					
					if (crop3.getIcon() == dirt_texture) {
						
						crop3.setIcon(dirt_seeds_texture);
						
					}
					
					else if (gameLoadSave.load(crop, current_save).contains("watered=true")) {
						
						crop3.setIcon(dirt_seeds_texture_watered);
						
					}					
									
					gameLoadSave.save("seed_planted=true", crop, current_save);
					gameLoadSave.save("stage=0", crop, current_save);
					gameLoadSave.save("sick=false", crop, current_save);
					
				}
					
				else if (tool == "water" && gameLoadSave.load(crop, current_save).contains("watered=false")) {
					
					ImageIcon newTexture = new ImageIcon(String.valueOf(crop3.getIcon()).replace(".png", "_watered.png"));
					crop3.setIcon(newTexture);
					
					gameLoadSave.save("watered=true", crop, current_save);
					
				}			
				
				tool = "None";
				showToolLabel.setText("Tool Selected: " + tool);
				btnPlantSeed.setSelected(false);
				applyWater.setSelected(false);
				fertilizePlant.setSelected(false);
				
			}
		});
		
		crop4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				crop = 4;
				
				if (tool == "seeds" && gameLoadSave.load(crop, current_save).contains("seed_planted=false")) {
					
					if (crop4.getIcon() == dirt_texture) {
						
						crop4.setIcon(dirt_seeds_texture);
						
					}
					
					else if (gameLoadSave.load(crop, current_save).contains("watered=true")) {
						
						crop4.setIcon(dirt_seeds_texture_watered);
						
					}					
									
					gameLoadSave.save("seed_planted=true", crop, current_save);
					gameLoadSave.save("stage=0", crop, current_save);
					gameLoadSave.save("sick=false", crop, current_save);
					
				}
					
				else if (tool == "water" && gameLoadSave.load(crop, current_save).contains("watered=false")) {
					
					ImageIcon newTexture = new ImageIcon(String.valueOf(crop4.getIcon()).replace(".png", "_watered.png"));
					crop4.setIcon(newTexture);
					
					gameLoadSave.save("watered=true", crop, current_save);
					
				}			
				
				tool = "None";
				showToolLabel.setText("Tool Selected: " + tool);
				btnPlantSeed.setSelected(false);
				applyWater.setSelected(false);
				fertilizePlant.setSelected(false);
				
			}
		});		
		
		
		// !---------------------------------------------------------
		JButton changeWindowSize = new JButton("Toggle Full Screen");
		changeWindowSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("bigger screen");
				
			}
		});
		changeWindowSize.setFont(new Font("Tahoma", Font.BOLD, 8));
		changeWindowSize.setBounds(10, 11, 119, 39);
		contentPane.add(changeWindowSize);
		
		JButton openMenu = new JButton("Menu");
		openMenu.setFont(new Font("Tahoma", Font.BOLD, 11));
		openMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				gameMenu.main(null);
				
			}
		});
		openMenu.setBounds(613, 418, 100, 23);
		contentPane.add(openMenu);
		
		JButton buttonQuit = new JButton("Quit");
		buttonQuit.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				handleClose(1);
				
			}
		});
		buttonQuit.setBounds(613, 455, 100, 23);
		contentPane.add(buttonQuit);
		
		
		
		JButton buttonHelp = new JButton("Help");
		buttonHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonHelp.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonHelp.setBounds(613, 129, 100, 23);
		contentPane.add(buttonHelp);
		
		JLabel timeLabel = new JLabel("Time: null");
		timeLabel.setForeground(Color.WHITE);
		timeLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		timeLabel.setBounds(233, 49, 105, 45);
		contentPane.add(timeLabel);
		
		JButton reloadButton = new JButton("Reload");
		reloadButton.setBounds(613, 49, 100, 23);
		contentPane.add(reloadButton);
		
		JLabel slotLabel = new JLabel("Save Slot: -1");
		slotLabel.setForeground(Color.WHITE);
		slotLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		slotLabel.setBounds(613, 8, 105, 45);
		contentPane.add(slotLabel);
		
		JLabel bgLabel = new JLabel("");
		bgLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bgLabel.setIcon(new ImageIcon(".\\textures\\bg.png"));
		bgLabel.setBounds(0, -268, 804, 893);
		contentPane.add(bgLabel);	
		
	
		// handles game update from save files
		reloadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				slotLabel.setText("Save Slot: " + current_save);
				
				crop = 1;
				
				// seed_planted
				if (gameLoadSave.load(crop, current_save).contains("seed_planted=true")) {
			    		
					crop1.setIcon(dirt_seeds_texture);
						
					if (gameLoadSave.load(crop, current_save).contains("watered=true")) {
				    		
						crop1.setIcon(dirt_seeds_texture_watered);
				    		
				    } 					
												
			    } 
				// stage
				else if (gameLoadSave.load(crop, current_save).contains("stage=")) {
			    		
					if (gameLoadSave.load(crop, current_save).get(0).replace("stage=", "") == "1") {
						
						crop1.setIcon(growth_stage_1);
						
						if (gameLoadSave.load(crop, current_save).contains("watered=true")) {
			
							crop1.setIcon(growth_stage_1_watered);
			
						}
						
					}
			    		
			    }
				// sick
				else if (gameLoadSave.load(crop, current_save).contains("sick=true")) {
		    						
												
			    } 
				// time left
				else if (gameLoadSave.load(crop, current_save).contains("time_left=")) {
					
					
			    } 
					
				
				// duplicate code and change all crop numbers
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
			
		});
		
		
	}
	
	
	// close
	private int handleClose(int handle) {
		
		if (handle == 1) {
			
			int askClose = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?");
			
			if (askClose == 0) {
				System.exit(0);
			}

		}
		
		return 0;
		
	}
}
