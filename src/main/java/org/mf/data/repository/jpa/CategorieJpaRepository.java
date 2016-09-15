package org.mf.data.repository.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.mf.bean.jpa.CategorieEntity;

/**
 * Repository : Categorie.
 */
public interface CategorieJpaRepository extends PagingAndSortingRepository<CategorieEntity, Integer> {

	/**
	 * @param pageable
	 * @return pagina di tutte le città
	 */
	@Query(value="select c from CategorieEntity c", countQuery="select count(c) from CategorieEntity c")
	Page<CategorieEntity> listPage(Pageable pageable);
	

}
