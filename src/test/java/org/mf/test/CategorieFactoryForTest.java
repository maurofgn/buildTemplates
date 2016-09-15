package org.mf.test;

import org.mf.bean.Categorie;

public class CategorieFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Categorie newCategorie() {

		Integer id = mockValues.nextInteger();

		Categorie categorie = new Categorie();
		categorie.setId(id);
		return categorie;
	}
	
}
