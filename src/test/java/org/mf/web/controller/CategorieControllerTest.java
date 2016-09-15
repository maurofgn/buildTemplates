package org.mf.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

//--- Entities
import org.mf.bean.Categorie;
import org.mf.test.CategorieFactoryForTest;

//--- Services 
import org.mf.business.service.CategorieService;


import org.mf.web.common.Message;
import org.mf.web.common.MessageHelper;
import org.mf.web.common.MessageType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.MessageSource;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RunWith(MockitoJUnitRunner.class)
public class CategorieControllerTest {
	
	@InjectMocks
	private CategorieController categorieController;
	@Mock
	private CategorieService categorieService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private CategorieFactoryForTest categorieFactoryForTest = new CategorieFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<Categorie> list = new ArrayList<Categorie>();
		when(categorieService.findAll()).thenReturn(list);
		
		// When
		String viewName = categorieController.list(model);
		
		// Then
		assertEquals("categorie/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = categorieController.formForCreate(model);
		
		// Then
		assertEquals("categorie/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((Categorie)modelMap.get("categorie")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/categorie/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		Categorie categorie = categorieFactoryForTest.newCategorie();
		Integer id = categorie.getId();
		when(categorieService.findById(id)).thenReturn(categorie);
		
		// When
		String viewName = categorieController.formForUpdate(model, id);
		
		// Then
		assertEquals("categorie/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(categorie, (Categorie) modelMap.get("categorie"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/categorie/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		Categorie categorie = categorieFactoryForTest.newCategorie();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		when(categorieService.create(categorie)).thenReturn(categorie); 
		
		// When
		String viewName = categorieController.create(categorie, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/categorie/form/"+categorie.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(categorie, (Categorie) modelMap.get("categorie"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		Categorie categorie = categorieFactoryForTest.newCategorie();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = categorieController.create(categorie, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("categorie/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(categorie, (Categorie) modelMap.get("categorie"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/categorie/create", modelMap.get("saveAction"));
		
	}

	@Test
	public void createException() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(false);

		Categorie categorie = categorieFactoryForTest.newCategorie();
		
		Exception exception = new RuntimeException("test exception");
		when(categorieService.create(categorie)).thenThrow(exception);
		
		// When
		String viewName = categorieController.create(categorie, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("categorie/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(categorie, (Categorie) modelMap.get("categorie"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/categorie/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "categorie.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		Categorie categorie = categorieFactoryForTest.newCategorie();
		Integer id = categorie.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		Categorie categorieSaved = new Categorie();
		categorieSaved.setId(id);
		when(categorieService.update(categorie)).thenReturn(categorieSaved); 
		
		// When
		String viewName = categorieController.update(categorie, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/categorie/form/"+categorie.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(categorieSaved, (Categorie) modelMap.get("categorie"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		Categorie categorie = categorieFactoryForTest.newCategorie();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = categorieController.update(categorie, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("categorie/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(categorie, (Categorie) modelMap.get("categorie"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/categorie/update", modelMap.get("saveAction"));
		
	}

	@Test
	public void updateException() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(false);

		Categorie categorie = categorieFactoryForTest.newCategorie();
		
		Exception exception = new RuntimeException("test exception");
		when(categorieService.update(categorie)).thenThrow(exception);
		
		// When
		String viewName = categorieController.update(categorie, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("categorie/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(categorie, (Categorie) modelMap.get("categorie"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/categorie/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "categorie.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		Categorie categorie = categorieFactoryForTest.newCategorie();
		Integer id = categorie.getId();
		
		// When
		String viewName = categorieController.delete(redirectAttributes, id);
		
		// Then
		verify(categorieService).delete(id);
		assertEquals("redirect:/categorie", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		Categorie categorie = categorieFactoryForTest.newCategorie();
		Integer id = categorie.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(categorieService).delete(id);
		
		// When
		String viewName = categorieController.delete(redirectAttributes, id);
		
		// Then
		verify(categorieService).delete(id);
		assertEquals("redirect:/categorie", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "categorie.error.delete", exception);
	}
	
	
}
