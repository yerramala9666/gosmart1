
package com.gosmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gosmart.constans.PropertyImageConstans;
import com.gosmart.repository.entity.PropertyImageEntity;
import com.gosmart.service.PropertyImageService;

import lombok.extern.slf4j.Slf4j;
/* *
^<h2>PropertyImageController</h2>
* ThisEntityClassMaps to Property_Iamge_Controller
* 
* @author yerramala
* version 1.0
* since 2022-12-17
*/
@RestController
@Slf4j
@RequestMapping("/api/v1")
public class PropertyImageController {
	@Autowired
	private PropertyImageService propertyImageService;
	/*
	 * This method is used for the insertPropertyImage
	 * @param PropertyIamgeEmtity
	 * This is the parametortoinsertPropertyImage()
	 * @return Integer this propertyImageId
	 */
	@PostMapping("property/image/save")
	public ResponseEntity<Integer> insertPropertyImage(@RequestBody PropertyImageEntity propertyImageEntity)
	{
		log.info("{}- PropertyImageController insertPropertyImage()started",PropertyImageConstans.PROPERTY_IMAGE);
		try {
			log.info("{}-PropertyImageController insertPropertyImage()saving PropertyImage ",PropertyImageConstans.PROPERTY_IMAGE);
			Integer propertyImageId=propertyImageService.insertPropertyImage(propertyImageEntity);
			return new ResponseEntity<>(propertyImageId,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<List<PropertyImageEntity>> getPropertyImages(@PathVariable Integer propertyId)
	{
		log.info("{}- PropertyImageController getPropertyImages ()started",PropertyImageConstans.PROPERTY_IMAGE);
		try {
			log.info("{}-PropertyImageController getPropertyImages()getting PropertyImages",PropertyImageConstans.PROPERTY_IMAGE);
			List<PropertyImageEntity> propertyImages=propertyImageService.getPropertyImages(propertyId);
			return new ResponseEntity<>(propertyImages,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}