package org.wrex.dto;

/**
 * All DTOs must inherit from this class. Just a way to force to implement theses functions in each class.
 * @author guillermo
 *
 */
public abstract class GenericDTO {

	public abstract String toString();
	
	public abstract boolean equals(Object obj);
	
	public abstract int hashCode();
}
