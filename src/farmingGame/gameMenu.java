// [PACKAGE]
package farmingGame;

// [LIBS]
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class gameMenu extends JFrame {

	JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gameMenu frame = new gameMenu();
					frame.setVisible(true);
					frame.setResizable(false);
					
					Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
			        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
			        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
			        frame.setLocation(x, y);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public gameMenu() {
		setAlwaysOnTop(true);
		setTitle("Menu");
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel menuTextLabel = new JLabel("Menu");
		menuTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
		menuTextLabel.setFont(new Font("Playball", Font.BOLD, 48));
		menuTextLabel.setBounds(100, 0, 200, 100);
		contentPane.add(menuTextLabel);
		
		JButton loadSaveButton = new JButton("Load Save");
		loadSaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				gameMain.applySaveData();
			
			}
		});
		loadSaveButton.setBounds(150, 110, 100, 25);
		contentPane.add(loadSaveButton);
		
		JButton closeMenu = new JButton("Close Menu");
		closeMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		closeMenu.setBounds(275, 227, 100, 20);
		contentPane.add(closeMenu);
		
		JButton sourceCodeButton = new JButton("Source Code");
		sourceCodeButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sourceCodeButton.setBounds(150, 145, 100, 25);
		contentPane.add(sourceCodeButton);
		
	}
	
}

