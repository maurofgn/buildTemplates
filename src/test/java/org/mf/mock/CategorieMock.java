
/*
 * Created on 29 ago 2016 ( Time 11:02:38 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.mf.mock;

import java.util.LinkedList;
import java.util.List;

import org.mf.bean.Categorie;
import org.mf.test.MockValues;

public class CategorieMock {

	private MockValues mockValues = new MockValues();
	
	/**
	 * Creates an instance with random Primary Key
	 * @return
	 */
	public Categorie createInstance() {
		// Primary Key values

		return createInstance( mockValues.nextInteger() );
	}

	/**
	 * Creates an instance with a specific Primary Key
	 * @param id1
	 * @return
	 */
	public Categorie createInstance( Integer id ) {
		Categorie categorie = createNewInstance();
		// Init Primary Key fields
		categorie.setId( id) ;
		return categorie;
	}

	/**
	 * Creates an instance without Primary Key
	 * @param id1
	 * @return
	 */
	public Categorie createNewInstance() {
		Categorie categorie = new Categorie();
		// Init Data fields
		categorie.setCategoria( mockValues.nextString(30) ) ; // java.lang.String 
		categorie.setAnnomin( mockValues.nextInteger() ) ; // java.lang.Integer 
		categorie.setAnnomax( mockValues.nextInteger() ) ; // java.lang.Integer 
		categorie.setPunti( mockValues.nextInteger() ) ; // java.lang.Integer 
		categorie.setPuntimax( mockValues.nextInteger() ) ; // java.lang.Integer 
		categorie.setNrset( mockValues.nextInteger() ) ; // java.lang.Integer 
		categorie.setNote( mockValues.nextString(255) ) ; // java.lang.String 
		categorie.setActive( mockValues.nextBoolean() ) ; // java.lang.Boolean 
		categorie.setCategoriecol( mockValues.nextString(45) ) ; // java.lang.String 
		// Init Link fields (if any)
		// setListOfIscrizioni( TODO ) ; // List<Iscrizioni> 
		// setListOfCategorieaccept( TODO ) ; // List<Categorieaccept> 
		return categorie;
	}

	/**
	 * Creates a list of instances
	 * @param count number of instances to be created
	 * @return
	 */
	public List<Categorie> createList(int count) {
		List<Categorie> list = new LinkedList<Categorie>();		
		for ( int i = 1 ; i <= count ; i++ ) {
			list.add( createInstance() );
		}
		return list;
	}
}