/**
 * 
 */
package com.atlonos.pages;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.atlonos.actions.RandomVolumeActions;
import com.atlonos.main.Main;

/**
 * Date : 1 févr. 2023
 * 
 * @author  Gabriel ROCHE
 * @version 1.0
 */
public class RandomVolume extends RandomVolumeActions {

	/*  Constraints  */
	private static GridBagConstraints gbc             = new GridBagConstraints();
	
	
	/*  JPanels  */
	protected static JPanel           mainPanel       = new JPanel();
	protected static JPanel           upperPanel      = new JPanel();
	protected static JPanel           lowerPanel      = new JPanel();
	
	protected static JPanel           submitBtnPanel  = new JPanel();
	protected static JPanel           btnPanel        = new JPanel();
	
	
	/*  Buttons  */
	protected static JButton          submitBtn       = new JButton("Generate");
	protected static JButton          copyBtn         = new JButton("Copy");
	protected static JButton          clearBtn        = new JButton("Clear");
	
	public static ButtonGroup         radioBtnGroup   = new ButtonGroup();
	public static JRadioButton[]      radioBtns       = new JRadioButton[5];
	
	
	/*  Text fields  */
	public static JTextField          resultTextField = new JTextField();
	
	private RandomVolume() {
	}
	
	static {
		
		/*  Main panel initialization  */
		mainPanel.setLayout( new GridLayout(2, 1) );
		
		
		/*  Upper panel initialization  */
//		upperPanel.setLayout( new GridLayout(5, 1) );
		upperPanel.setLayout( new GridBagLayout() );
		gbc.gridx  = 0;
		gbc.gridy  = GridBagConstraints.RELATIVE;
		gbc.anchor = GridBagConstraints.WEST;
		
		
		/*  Lower panel initialization  */
		lowerPanel.setLayout( new GridLayout(3, 1) );
		
		
		/*  Submit button panel initialization  */
		submitBtnPanel.setLayout( new GridBagLayout() );
		
		
		/*  Button panel initialization  */
		btnPanel.setLayout( new GridLayout(1, 2) );
		
		
		final String[] names = new String[] { "Realistic", "Semi-realistic", "Pints", "Liters/Gallons", "Dozen of Gallons" };
		
		for (int i = 0; i < radioBtns.length; i++)
			radioBtnGroup.add( radioBtns[i] = new JRadioButton( names[i] ) );
		
		
		/*  Result text field initialization  */
		resultTextField.setEditable(false);
		resultTextField.setHorizontalAlignment( JTextField.CENTER );
		resultTextField.setFont( new Font(null, 0, 20) );
		
		
		/*  Component placement  */
		mainPanel.add( upperPanel );
		mainPanel.add( lowerPanel );
		
		/*  Upper panel  */
		for (int i = 0; i < radioBtns.length; i++) {
			upperPanel.add( radioBtns[i], gbc );
			/*radioBtns[i].setHorizontalAlignment(0);*/
		}
		
		/*  Lower panel  */
		submitBtnPanel.add( submitBtn, new GridBagConstraints() );
		lowerPanel    .add( submitBtnPanel  );
		
		lowerPanel    .add( resultTextField );
		
		btnPanel      .add( copyBtn  );
		btnPanel      .add( clearBtn );
		lowerPanel    .add( btnPanel );
		
	}
	
	public static JPanel getPanel(Main frame) {
		RandomVolume.setActions( frame );
		return mainPanel;
	}
	
	private static void setActions(Main frame) {
		submitBtn.addActionListener( new RandomVolume() );
		copyBtn  .addActionListener( new RandomVolume() );
		clearBtn .addActionListener( new RandomVolume() );
	}
	
}