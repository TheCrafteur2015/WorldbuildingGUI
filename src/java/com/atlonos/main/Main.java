/**
 * 
 */
package com.atlonos.main;

import static java.awt.BorderLayout.NORTH;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.Serial;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.atlonos.interfaces.ISelf;
import com.atlonos.pages.Home;
import com.atlonos.pages.RandomSize;
import com.atlonos.pages.RandomVolume;

/**
 * Date : 1 févr. 2023
 * 
 * @author  Gabriel ROCHE
 * @version 1.0
 */
public class Main extends JFrame implements ISelf {

	@Serial
	private static final long serialVersionUID = -1843074214224065824L;
	
	/*  Layout Managers  */
	public final CardLayout crdlt;
	
	/*  JPanels  */
	public final JPanel centerPanel;
	
	private Main() {
		this.setDefaultCloseOperation( EXIT_ON_CLOSE );
		this.setSize( new Dimension(600, 450) );
		this.setLocationRelativeTo(null);
		this.setTitle("Home");
		
		this.setIconImage( new ImageIcon( "/src/resources/infoicon-3.png" ).getImage() );
		
		this.add( MenuBar.getMenuBar(this), NORTH );
		
		this.centerPanel = new JPanel();
		this.centerPanel.setLayout( this.crdlt = new CardLayout() );
		this.centerPanel.add( "Home",          Home        .getPanel(this) );
		this.centerPanel.add( "Random Size",   RandomSize  .getPanel(this) );
		this.centerPanel.add( "Random Volume", RandomVolume.getPanel(this) );
		
		this.add( this.centerPanel );
		
	}
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
					
					Main frame = new Main();
					frame.setVisible(true);
					
				} catch (Exception e) {
					
					e.printStackTrace();
					
				}
				
			}
			
		});
		
	}
	
	@Override
	public Main getSelf() {
		return this;
	}
	
	protected enum MenuNames {
		File(),
		Navigation(),
		Help();
		
		protected enum MenuItems {
			Home(MenuNames.File),
			Open(MenuNames.File),
			
			Hide(MenuNames.Help),
			Help(MenuNames.Help),
			Quit(MenuNames.Help);
			
			private MenuNames name;
			
			private static final Map<MenuItems, MenuNames> BY_MENU = new HashMap<MenuItems, MenuNames>();
			
			private MenuItems(MenuNames name) {
				this.name = name;
			}
			
			static {
		        for (MenuItems e: values()) {
		            BY_MENU.put(e, e.name);
		        }
		    }
			
			public MenuNames getMenu() {
		        return BY_MENU.get(this);
		    }
		}
		
	}
	
	protected enum SubmenuNames {
		Decimal_Generators(MenuNames.Navigation),
		Names_Generators  (MenuNames.Navigation);
		
		private MenuNames menu;
		
		private static final Map<SubmenuNames, MenuNames> BY_MENU = new HashMap<SubmenuNames, MenuNames>();
		
		private SubmenuNames(MenuNames menu) {
			this.menu = menu;
		}
		
		static {
	        for (SubmenuNames e: values()) {
	            BY_MENU.put(e, e.menu);
	        }
	    }
		
		public MenuNames getMenu() {
	        return BY_MENU.get(this);
	    }
		
		protected enum SubmenuItems {
			Random_Size_Generator (SubmenuNames.Decimal_Generators),
			Random_Volume_Generator (SubmenuNames.Decimal_Generators),
			Draconian_Name_Generator(SubmenuNames.Names_Generators),
			Drakanian_Name_Generator(SubmenuNames.Names_Generators),
			/*
			T1(SubmenuNames.Names_Generators),
			T2(SubmenuNames.Names_Generators),
			T3(SubmenuNames.Names_Generators),
			T4(SubmenuNames.Names_Generators),
			T5(SubmenuNames.Names_Generators),
			T6(SubmenuNames.Names_Generators),
			T7(SubmenuNames.Names_Generators),
			T8(SubmenuNames.Names_Generators),
			T9(SubmenuNames.Names_Generators),
			T10(SubmenuNames.Names_Generators),
			T11(SubmenuNames.Names_Generators),
			T12(SubmenuNames.Names_Generators),
			T13(SubmenuNames.Names_Generators),
			T14(SubmenuNames.Names_Generators),
			T15(SubmenuNames.Names_Generators),
			T16(SubmenuNames.Names_Generators),
			T17(SubmenuNames.Names_Generators)*/;
			
			private SubmenuNames submenu;
			
			private static final Map<SubmenuItems, SubmenuNames> BY_SUBMENU = new HashMap<SubmenuItems, SubmenuNames>();
			
			private SubmenuItems(SubmenuNames submenu) {
				this.submenu = submenu;
			}
			
			static {
		        for (SubmenuItems e: values()) {
		            BY_SUBMENU.put(e, e.submenu);
		        }
		    }
			
			public SubmenuNames getMenu() {
		        return BY_SUBMENU.get(this);
		    }
			
		}
		
	}

}
