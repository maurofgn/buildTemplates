/*
 * Created on 8 set 2016 ( Time 16:43:37 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.mf.rest.controller;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.mf.bean.Categorie;
import org.mf.business.service.CategorieService;
import org.mf.web.listitem.CategorieListItem;
import org.mf.web.util.DataTable;


/**
 * Spring MVC controller for 'Categorie' management.
 */
@Controller
public class CategorieRestController {

	@Resource
	private CategorieService categorieService;
	
	@RequestMapping( value="/items/categorie",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<CategorieListItem> findAllAsListItems() {
		List<Categorie> list = categorieService.findAll();
		List<CategorieListItem> items = new LinkedList<CategorieListItem>();
		for ( Categorie categorie : list ) {
			items.add(new CategorieListItem( categorie ) );
		}
		return items;
	}
	
	@RequestMapping( value="/categorie",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Categorie> findAll() {
		return categorieService.findAll();
	}

	@RequestMapping( value="/categorie/page",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public DataTable<Categorie> dataTablePage (
    		@RequestParam(value="draw",   required=false, defaultValue = "1") Integer draw,
    		@RequestParam(value="start",  required=false, defaultValue = "0") Integer start,
    		@RequestParam(value="length", required=false, defaultValue = DataTable.LINES_PER_PAGE) Integer length) {

		Sort sort = new Sort(
			new Order(Direction.ASC, "categoria"),	//TODO: redefine field name and direction type
			new Order(Direction.DESC, "annomin"));	//TODO: redefine field name and direction type
		
		PageRequest pageRequest = new PageRequest(start/length, length, sort);
		Page<Categorie> page = categorieService.findAll(pageRequest);
		Long totRec = page != null ? page.getTotalElements() : categorieService.count();
		DataTable<Categorie> dataTable = new DataTable<Categorie>(totRec, (page != null ? page.getContent().size() : 0),  (page != null ? page.getContent() : Collections.emptyList()), draw);
		return dataTable;
	}

	@RequestMapping( value="/categorie/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Categorie findOne(@PathVariable("id") Integer id) {
		return categorieService.findById(id);
	}
	
	@RequestMapping( value="/categorie",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Categorie create(@RequestBody Categorie categorie) {
		return categorieService.create(categorie);
	}

	@RequestMapping( value="/categorie/{id}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Categorie update(@PathVariable("id") Integer id, @RequestBody Categorie categorie) {
		return categorieService.update(categorie);
	}

	@RequestMapping( value="/categorie/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("id") Integer id) {
		categorieService.delete(id);
	}
	
}