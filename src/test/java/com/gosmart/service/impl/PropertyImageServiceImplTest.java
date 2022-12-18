package com.gosmart.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gosmart.exception.GoSmartException;
import com.gosmart.repository.PropertyImageRepository;
import com.gosmart.repository.entity.PropertyImageEntity;
import com.gosmart.service.PropertyImageService;

@RunWith(SpringJUnit4ClassRunner.class)
public class PropertyImageServiceImplTest {
	@InjectMocks
	private PropertyImageServiceImpl service;
	@Mock
	private PropertyImageRepository repository;
	@Test
	public void testInsertPropertyImage()throws Exception
	{
		PropertyImageEntity propertyImageEntity=new PropertyImageEntity();
		PropertyImageEntity propertyImageEntity2=Mockito.any();
		when(repository.save(propertyImageEntity)).thenReturn(propertyImageEntity2);
		Integer propertyImageId=service.insertPropertyImage(propertyImageEntity);
		assertNotNull(propertyImageId);
	}
	@Test(expected = GoSmartException.class)
	public void testInsertPropertyImage_Exception()throws Exception
	{
		
		PropertyImageEntity propertyImageEntity=new PropertyImageEntity();
		when(repository.save(propertyImageEntity)).thenThrow(NullPointerException.class);
		service.insertPropertyImage(propertyImageEntity);
		
	}
	@Test
	public void testGetPropertyImages()throws Exception
	{
		Integer propertyId=1;
		List<PropertyImageEntity> propertyImageList=new ArrayList<>();
		when(repository.findAllByPropertyId(propertyId)).thenReturn(propertyImageList);
		List<PropertyImageEntity> propertyImages=service.getPropertyImages(1);
		assertNotNull(propertyImages);

	}
	
	@Test(expected = GoSmartException.class)
	public void testGetPropertyImages_Exception()throws Exception
	{
		Integer propertyId=1;
		when(repository.findAllByPropertyId(propertyId)).thenThrow(NullPointerException.class);
		service.getPropertyImages(1);
		

	}

}
