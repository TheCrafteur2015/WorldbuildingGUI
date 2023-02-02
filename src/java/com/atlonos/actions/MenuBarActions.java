/**
 * 
 */
package com.atlonos.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.atlonos.main.Main;

/**
 * Date : 1 févr. 2023
 * 
 * @author  Gabriel ROCHE
 * @version 1.0
 */
public class MenuBarActions extends GenericActions implements ActionListener {

	private Main frame;
	
	public MenuBarActions(Main frame) {
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch ( e.getActionCommand() ) {
			case "Home" -> {
				this.frame.crdlt.show( this.frame.centerPanel, "Home");
				this.frame.setTitle( "Home" );
			}
			case "Random Size Generator" -> {
				this.frame.crdlt.show( this.frame.centerPanel, "Random Size");
				this.frame.setTitle( "Random Size Generator" );
			}
			case "Random Volume Generator" -> {
				this.frame.crdlt.show( this.frame.centerPanel, "Random Volume");
				this.frame.setTitle( "Random Volume Generator" );
			}
			case "Quit" -> {
				this.frame.dispose();
			}
			default -> {
				System.out.println( "NullPointerException" );
			}
		}
	}

}
