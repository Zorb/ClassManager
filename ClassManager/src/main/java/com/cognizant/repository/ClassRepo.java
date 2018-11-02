package com.cognizant.repository;

public interface ClassRepo {

	String getAllClasses();

	String getAllTrainees();

	String createClass(String classroom);

	String createTrainee(String trainee);

	String updateClass(Long id, String classToUpdate);

	String updateTrainee(Long id, String traineeToUpdate);

	String deleteTrainee(Long id);

	String deleteClass(Long id);
}