package com.cognizant.service;

public interface ClassService {

	String getAllClasses();

	String createClass(String classroom);

	String updateClass(Long id, String classToUpdate);

	String deleteClass(Long id);
}