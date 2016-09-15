/*
 * Created on 22 lug 2016 ( Time 11:43:26 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.mf.business.service.mapping;

import org.mf.bean.Categorie;
import org.mf.bean.jpa.CategorieEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

/**
 * Mapping between entity beans and display beans.
 */
@Service
public class CategorieServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public CategorieServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'CategorieEntity' to 'Categorie'
	 * @param categorieEntity
	 */
	public Categorie mapCategorieEntityToCategorie(CategorieEntity categorieEntity) {
		if (categorieEntity == null) {
			return null;
		}

		//--- Generic mapping 
		Categorie categorie = map(categorieEntity, Categorie.class);

		return categorie;
	}
	
	/**
	 * Mapping from 'Categorie' to 'CategorieEntity'
	 * @param categorie
	 * @param categorieEntity
	 */
	public void mapCategorieToCategorieEntity(Categorie categorie, CategorieEntity categorieEntity) {
		if(categorie == null) {
			return;
		}

		//--- Generic mapping 
		map(categorie, categorieEntity);

	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ModelMapper getModelMapper() {
		return modelMapper;
	}

	protected void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

}