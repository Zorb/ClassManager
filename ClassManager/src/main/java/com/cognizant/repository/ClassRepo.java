package com.cognizant.repository;

public interface ClassRepo {

	String getAllClasses();

	String getAllTrainees();

	String createClass(String classroom);

	String createTrainee(String trainee);

	String updateClass(Long id, String classToUpdate);

	String deleteClass(Long id);

}