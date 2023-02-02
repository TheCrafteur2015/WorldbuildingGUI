/**
 * 
 */
package com.atlonos.pages;

import java.awt.Color;

import javax.swing.JPanel;

import com.atlonos.main.Main;

/**
 * Date : 1 févr. 2023
 * 
 * @author  Gabriel ROCHE
 * @version 1.0
 */
public class Home {

	private static JPanel mainPanel = new JPanel();
	
	static {
		mainPanel.setBackground( Color.BLUE );
	}
	
	public static JPanel getPanel(Main frame) {
		return mainPanel;
	}
	
}
