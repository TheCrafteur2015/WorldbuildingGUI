/**
 * 
 */
package com.atlonos.actions;

import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonModel;
import javax.swing.JRadioButton;

import com.atlonos.pages.RandomVolume;

/**
 * Date : 1 févr. 2023
 * 
 * @author Gabriel ROCHE
 * @since  1.0
 */
public class RandomVolumeActions extends GenericActions implements ActionListener {

	private static final double ROUND = 100;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch ( e.getActionCommand() ) {
			case "Generate" -> this.generate();
			case "Copy"     -> RandomSizeActions.clip.setContents( new StringSelection( RandomVolume.resultTextField.getText() ), null);
			case "Clear"    -> {
				RandomVolume.resultTextField.setText("");
				RandomVolume.radioBtnGroup.clearSelection();
			}
		}
	}
	
	private void generate() {
		
		if ( !this.isAnySelected() )
			return;
		
		SwitchValues<ButtonModel> tabVal = new SwitchValues<ButtonModel>();
		
		final String[] btnId = new String[] { "btn1", "btn2", "btn3", "btn4", "btn5" };
		for (int i = 0; i < btnId.length; i++)
			tabVal.add( btnId[i] , RandomVolume.radioBtns[i].getModel() );
		
		String temp;
		
		switch ( tabVal.getName( RandomVolume.radioBtnGroup.getSelection() ) ) {
			case "btn1" -> temp = String.valueOf( UtilClass.round( UtilClass.randomDouble( 0.005, 0.02), ROUND) );
			case "btn2" -> temp = String.valueOf( UtilClass.round( UtilClass.randomDouble( 0.1,   0.4),  ROUND) );
			case "btn3" -> temp = String.valueOf( UtilClass.round( UtilClass.randomDouble( 0.5,   4.7),  ROUND) );
			case "btn4" -> temp = String.valueOf( UtilClass.round( UtilClass.randomDouble( 1.0,  12.0),  ROUND) );
			case "btn5" -> temp = String.valueOf( UtilClass.round( UtilClass.randomDouble(37.9,  75.7),  ROUND) );
			default -> {
				temp = "";
				return;
			}
		}
		
		RandomVolume.resultTextField.setText( "~".concat(temp).concat( " Liter(s)" ) );
		
	}

	private boolean isAnySelected() {
		for (JRadioButton btn : RandomVolume.radioBtns)
			if ( btn.isSelected() )
				return true;
		return false;
	}

}