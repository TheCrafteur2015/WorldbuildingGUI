/**
 * 
 */
package com.atlonos.actions;

import java.util.HashMap;

/**
 * Date : 30 janv. 2023
 * 
 * @author  Gabriel ROCHE
 * @version 1.0
 */
public class SwitchValues<T> {

	private HashMap<String, T> dataMap;
	
	public SwitchValues() {
		this.dataMap   = new HashMap<String, T>();
	}
	
	public void add(String name, T target) {
		this.dataMap  .put( name,    target );
	}
	
	public T getValue(String name) {
		return this.dataMap.get( name );
	}
	
	public String getName(T value) {
		for ( HashMap.Entry<String, T> val : this.dataMap.entrySet() ) {
		    String key    = val.getKey();
		    T      sValue = val.getValue();
		    if ( sValue == value )
		    	return key;
		}
		return null;
	}

}
