package org.mf.dao;

import java.util.List;

import org.dbunit.dataset.CompositeDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.junit.Assert;
import org.junit.Test;
import org.mf.bean.jpa.CategorieEntity;
import org.mf.data.repository.jpa.CategorieJpaRepository;
import org.mf.mock.CategorieEntityMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

/**
 * JUnit test case for Categorie Jpa Repository service
 * 
 */
public class CategorieDaoImplTest extends EntityDaoImplTest {
	
	@Autowired
	private CategorieJpaRepository categorieJpaRepository;
	
//	private MockValues mockValues = new MockValues();
	
	CategorieEntityMock categorieEntityMock = new CategorieEntityMock();


	/* In case you need multiple datasets (mapping different tables) and you do prefer to keep them in separate XML's */
	@Override
	protected IDataSet getDataSet() throws Exception {
		
		FlatXmlDataSetBuilder flatXmlDataSetBuilder = new FlatXmlDataSetBuilder();
		
		/**
		 * without this flag the columns are defined only from first row,
		 * therefore columns without value in the first row are not defined
		 *
		 */
		flatXmlDataSetBuilder.setColumnSensing(true);
		
		IDataSet[] datasets = new IDataSet[] {
				flatXmlDataSetBuilder.build(this.getClass().getClassLoader().getResourceAsStream("categorie.xml"))
			  };

		CompositeDataSet retValue = new CompositeDataSet(datasets);
		
		return retValue;
	}

	/**
	 * count the existing records, create a new instance, save, read, re count, delete the record created and check it not exist
	 */
	@Test
	public void findById() {

		long totalCount = categorieJpaRepository.count();
//		System.out.println("Record/s found in categorie: " + totalCount);

		CategorieEntity mock = categorieEntityMock.createNewInstance();
		mock = categorieJpaRepository.save(mock);

		CategorieEntity categorieEntity = categorieJpaRepository.findOne(mock.getId());

		Assert.assertNotNull(categorieEntity);

		long c2 = categorieJpaRepository.count();
		Assert.assertEquals("", totalCount+1, c2);

		categorieJpaRepository.delete(mock);

		categorieEntity = categorieJpaRepository.findOne(mock.getId());

		Assert.assertNull(categorieEntity);
	}

	@Test
	public void firstPage() {
		
		long totalCount = categorieJpaRepository.count();

		PageRequest pageable = new PageRequest(0, 20,
				new Sort(
						new Order(Direction.ASC, "categoria"),
						new Order(Direction.DESC, "annomin")
						)
		);

		Page<CategorieEntity> page = categorieJpaRepository.findAll(pageable);
		Assert.assertTrue(page.getNumberOfElements() <= totalCount);	//elements in page are less or equal of the total

//		int nrRows = 0;
//		for (CategorieEntity categorieEntity : page) {
//			System.out.println(categorieEntity);
//			nrRows++;
//		}
//		Assert.assertEquals(nrRows, page.getNumberOfElements());
	}

	@Test
	public void select() {
		
		Criteria criteria = getSession().createCriteria(CategorieEntity.class, "e")
				.setMaxResults(10)
				.add(Restrictions.ilike("e.categoria", addPercentage("n")))
				.addOrder(org.hibernate.criterion.Order.asc("categoria"))
				;
		
		@SuppressWarnings("unchecked")
		List<CategorieEntity> critList = criteria.list();
		
		Assert.assertTrue(critList.size() >= 0);
		critList.forEach(c -> System.out.println(c));


		Query query = getSession().getNamedQuery("CategorieEntity.countAll");
		long totRec = (Long)query.uniqueResult();
		Assert.assertTrue(totRec >= 0);

		
		Query q = getSession().createQuery("Select x from CategorieEntity x order by x.categoria");
		
		@SuppressWarnings("unchecked")
		List<CategorieEntity> l = q.list();
		
		Assert.assertTrue(l.size() >= 0);
		l.forEach(c -> System.out.println(c));
	}

}
