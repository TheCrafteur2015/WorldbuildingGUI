/**
 * 
 */
package com.atlonos.actions;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

/**
 * Date : 1 févr. 2023
 * 
 * @author  Gabriel ROCHE
 * @version 1.0
 */
public abstract class GenericActions {

	public static Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
	
}
