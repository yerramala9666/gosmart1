package com.gosmart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.gosmart.constans.PropertyImageConstans;
import com.gosmart.exception.GoSmartException;
import com.gosmart.repository.PropertyImageRepository;
import com.gosmart.repository.entity.PropertyImageEntity;
import com.gosmart.service.PropertyImageService;

import lombok.extern.slf4j.Slf4j;
/* *
^<h2>PropertyImageEntity</h2>
* ThisEntityClassMaps to Property_Iamge_Service_Impl
* 
* @author yerramala
* version 1.0
* since 2022-12-17
*/
@Service
@Slf4j
public class PropertyImageServiceImpl  implements PropertyImageService{
	@Autowired
	private PropertyImageRepository propertyImageRepository;

	
	/*
	 * This method is used for the insertPropertyImage
	 * @param PropertyIamgeEmtity
	 * This is the parametortoinsertPropertyImage()
	 * @return Integer this propertyImageId
	 */
	@Override
	public Integer insertPropertyImage(PropertyImageEntity propertyImageEntity) {
		log.info("{}- ServiceImpl insertPropertyImage()started",PropertyImageConstans.PROPERTY_IMAGE);
		Integer propertyImageId=0;
		try {
			log.info("{}-ServiceImpl insertPropertyImage()saving PropertyImage Longers",PropertyImageConstans.PROPERTY_IMAGE);
			PropertyImageEntity prop=propertyImageRepository.save(propertyImageEntity);
			
			if(prop!=null)
			{
				propertyImageId=prop.getPropertyImageId();
			}
		} catch (Exception e) {
			log.error("{}-ServiceImpl insertPropertyImage() exception occured-{}",PropertyImageConstans.PROPERTY_IMAGE,e.getMessage());
			throw new GoSmartException(e.getMessage());
			
		}
		return propertyImageId;
	}

	/*
	 * This method is used for the getPropertyImages
	 * @param PropertyIamgeEmtity
	 * This is the parametortogetPropertyImages()
	 * @return Integer this images
	 */
	@Override
	public List<PropertyImageEntity> getPropertyImages(Integer propertyId) {
		List<PropertyImageEntity> images=null;
		log.info("{}- ServiceImpl getPropertyImages() started",PropertyImageConstans.PROPERTY_IMAGE);
		try {
			
			images=propertyImageRepository.findAllByPropertyId(propertyId);
			
			log.info("{}- ServiceImpl getPropertyImages() images are-{}",PropertyImageConstans.PROPERTY_IMAGE,images);
		} catch (Exception e) {
			log.error("{}-ServiceImpl getPropertyImages() exception occured-{}",PropertyImageConstans.PROPERTY_IMAGE,e.getMessage());
			throw new GoSmartException(e.getMessage());
			
		}
		return images;
	}

}
