/**
 * 
 */
package com.atlonos.main;

import java.io.Serial;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.atlonos.actions.MenuBarActions;

/**
 * Date : 1 févr. 2023
 * 
 * @author  Gabriel ROCHE
 * @version 1.0
 */
public class MenuBar {

	@Serial
	private static final long serialVersionUID = 8298788261955881810L;
	
	private static Map<String, JMenuItem> btns = new HashMap<String, JMenuItem>();
	
	private static JMenuBar    menuBar      = new JMenuBar();
	
	private static JMenu[]     menuBtn      = new JMenu[ Main.MenuNames.values().length ];
	
	private static JMenu[]     subMenuBtn   = new JMenu[ Main.SubmenuNames.values().length ];
	
	private MenuBar() {
	}
	
	static {
		
		/*  Place menus  */
		for (Main.MenuNames name : Main.MenuNames.values())
			menuBar.add( menuBtn[ name.ordinal() ] = new JMenu( String.valueOf( name ) ) );
		
		/*  Place menu items  */
		for (Main.MenuNames.MenuItems item : Main.MenuNames.MenuItems.values()) {
			if ( String.valueOf( item ).equals("Quit") )
				menuBtn[ item.getMenu().ordinal() ].addSeparator();
			btns.put( String.valueOf( item ) , new JMenuItem( String.valueOf( item ).replace('_', ' ') ) );
			menuBtn[ item.getMenu().ordinal() ].add( btns.get( String.valueOf( item ) ) );
		}
		
		/*  Place Submenus  */
		for (Main.SubmenuNames submenu : Main.SubmenuNames.values()) {
			menuBtn[ submenu.getMenu().ordinal() ].add( subMenuBtn[ submenu.ordinal() ] = new JMenu( String.valueOf( submenu ).replace('_', ' ') ) );
		}
		
		/*  Place submenu items  */
		for (Main.SubmenuNames.SubmenuItems item : Main.SubmenuNames.SubmenuItems.values()) {
			btns.put( String.valueOf( item ) , new JMenuItem( String.valueOf( item ).replace('_', ' ') ) );
			subMenuBtn[ item.getMenu().ordinal() ].add( btns.get( String.valueOf( item ) ) );
		}
	
	}
	
	public static JMenuBar getMenuBar(Main frame) {
		MenuBar.setActions(frame);
		return menuBar;
	}
	
	private static void setActions(Main frame) {
		btns.forEach( (K, V) -> {
			V.addActionListener( new MenuBarActions(frame) );
		});
	}
	
}