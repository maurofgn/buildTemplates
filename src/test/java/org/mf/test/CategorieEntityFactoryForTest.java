package org.mf.test;

import org.mf.bean.jpa.CategorieEntity;

public class CategorieEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public CategorieEntity newCategorieEntity() {

		Integer id = mockValues.nextInteger();

		CategorieEntity categorieEntity = new CategorieEntity();
		categorieEntity.setId(id);
		return categorieEntity;
	}
	
}
