/**
 * 
 */
package com.atlonos.actions;

import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import com.atlonos.pages.RandomSize;

/**
 * Date : 1 févr. 2023
 * 
 * @author  Gabriel ROCHE
 * @version 1.0
 */
public class RandomSizeActions extends GenericActions implements ActionListener {

	protected static Random rd = new Random();
	
	public RandomSizeActions() {
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch ( e.getActionCommand() ) {
			case "Generate" -> this.generate();
			case "Copy"     -> RandomSizeActions.clip.setContents( new StringSelection( RandomSize.resultTextField.getText() ), null);
			case "Clear"    -> { /*RandomSizeActions.resetTextFields( RandomSizeGUI.mainPanel );*/
				RandomSize.textFields[0]  .setText("");
				RandomSize.textFields[1]  .setText("");
				RandomSize.textFields[2]  .setText("");
				RandomSize.resultTextField.setText("");
			}
		}
	}

	private void generate() {
		
		if ( RandomSize.textFields[0].getText() == null || RandomSize.textFields[0].getText().equals("") )
			return;
		
		try {
			Double.parseDouble( RandomSize.textFields[0].getText() );
		} catch (NumberFormatException e) {
			RandomSize.resultTextField.setText( "Exception: " + e.getMessage() );
			return;
		}
		
		double avgHeight = Double.parseDouble( RandomSize.textFields[0].getText() );
		double percent   = 0.0;
		
		String res       = "";
		
		if ( RandomSize.textFields[1].getText() == null    ||
			 RandomSize.textFields[1].getText().equals("") ||
			 !UtilClass.isDouble( RandomSize.textFields[1].getText() ) )
			percent = RandomSize.DEFAULT_PERCENT;
		else
			percent = Double.parseDouble( RandomSize.textFields[1].getText() );
		
		if ( ( percent <= 0.0 || percent > 100.0 ) || percent == 0.0 )
			percent = RandomSize.DEFAULT_PERCENT;
		
		if ( RandomSize.rd.nextBoolean() )
			res = String.valueOf( Math.round( ( avgHeight + ( avgHeight * rd.nextDouble( percent ) + 1.0 ) / 100.0 ) * 100.0 ) / 100.0 );  
		else
			res = String.valueOf( Math.round( ( avgHeight - ( avgHeight * rd.nextDouble( percent ) + 1.0 ) / 100.0 ) * 100.0 ) / 100.0 );
		
		if ( RandomSize.textFields[2].getText().matches("0*") || RandomSize.textFields[2].getText() == "" ) {
			res += " " + RandomSize.DEFAULT_UNIT;
			RandomSize.resultTextField.setText( res );
			return;
		}
		
		if ( RandomSize.textFields[2].getText().matches("^[0-9]*$") ) {
			RandomSize.resultTextField.setText( "Exception: Illegal argument: " + RandomSize.textFields[2].getText() );
			return;
		}
		
		res = res.concat( " " + RandomSize.textFields[2].getText() );
		
		RandomSize.resultTextField.setText( res );
		
	}
	
}