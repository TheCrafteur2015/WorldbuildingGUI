/**
 * 
 */
package com.atlonos.pages;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.atlonos.actions.RandomSizeActions;
import com.atlonos.main.Main;

/**
 * Date : 1 févr. 2023
 * 
 * @author  Gabriel ROCHE
 * @version 1.0
 */
public class RandomSize extends RandomSizeActions {

	/*  Constants  */
	public static final double DEFAULT_PERCENT = 20.0;
	public static final String DEFAULT_UNIT    = "cm";
	
	
	/**/
	private static GridBagConstraints gbc      = new GridBagConstraints();
	
	
	/*  JPanels  */
	protected static JPanel    mainPanel       = new JPanel();
	protected static JPanel    upperPanel      = new JPanel();
	protected static JPanel    lowerPanel      = new JPanel();
	
	protected static JPanel    submitBtnPanel  = new JPanel();
	protected static JPanel    btnPanel        = new JPanel();
	
	protected static JPanel[]  textPanels      = new JPanel[3];
	protected static JPanel[]  labelPanels     = new JPanel[3];
	
	
	/*  Labels and text fields  */
	protected static JLabel[]  textFieldLabels = new JLabel[3];
	
	public static JTextField   resultTextField = new JTextField();
	public static JTextField[] textFields      = new JTextField[3];
	
	
	/*  Buttons  */
	protected static JButton   submitBtn       = new JButton("Generate");
	protected static JButton   copyBtn         = new JButton("Copy");
	protected static JButton   clearBtn        = new JButton("Clear");
	
	private RandomSize() {
	}
	
	static {
		
		/*  Main panel initialization  */
		mainPanel.setLayout( new GridLayout(2, 1) );
		
		
		/*  Upper panel initialization  */
		upperPanel.setLayout( new GridLayout(3, 2) );
		gbc.gridx  = 0;
		gbc.gridy  = GridBagConstraints.RELATIVE;
		gbc.anchor = GridBagConstraints.WEST;
		
		
		/*  Lower panel initialization  */
		lowerPanel.setLayout( new GridLayout(3, 1) );
		
		
		/*  Submit button panel initialization  */
		submitBtnPanel.setLayout( new GridBagLayout() );
		
		
		/*  Button panel initialization  */
		btnPanel.setLayout( new GridLayout(1, 2) );
		
		
		/*  Text fields and labels initialization  */
		final String[] labelNames = new String[] { "Average size:", 
											       "Variation (optional, default=" + DEFAULT_PERCENT + "):",
											       "Unit (optional, default=" + DEFAULT_UNIT + "):"
											     };
		
		for (int i = 0; i < textFieldLabels.length; i++) {
			textFieldLabels[i] = new JLabel( " ".repeat(5).concat( labelNames[i] ) );
			textPanels[i]      = new JPanel();
			textFields[i]      = new JTextField();
			textPanels[i].setLayout( new GridBagLayout() );
			textFields[i].setPreferredSize( new Dimension( 150, 30 ) );
		}
		
		
		/*  Result text field initialization  */
		resultTextField.setEditable(false);
		resultTextField.setHorizontalAlignment( JTextField.CENTER );
		resultTextField.setFont( new Font(null, 0, 20) );
		
		
		/*  Component placement  */
		mainPanel.add( upperPanel );
		mainPanel.add( lowerPanel );
		
		/*  Upper panel  */
		for (int i = 0; i < textFieldLabels.length; i++) {
			labelPanels[i] = new JPanel();
			labelPanels[i].setLayout( new GridBagLayout() );
			labelPanels[i].add( textFieldLabels[i], gbc );
			upperPanel    .add( labelPanels[i] );
			
			textPanels[i] .add( textFields[i], new GridBagConstraints() );
			upperPanel    .add( textPanels[i] );
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
		RandomSize.actions( frame );
		return mainPanel;
	}
	
	private static void actions(Main frame) {
		submitBtn.addActionListener( new RandomSize() );
		copyBtn  .addActionListener( new RandomSize() );
		clearBtn .addActionListener( new RandomSize() );
	}
	
}