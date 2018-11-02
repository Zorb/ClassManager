package com.cognizant.service;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.cognizant.repository.ClassRepo;

public class ClassImpl implements ClassService {

	private static final Logger LOGGER = Logger.getLogger(ClassService.class);

	@Inject
	private ClassRepo repo;

	public String getAllClasses() {
		LOGGER.info("In ClassImpl getAllClasses ");
		return repo.getAllClasses();
	}

	public String getAllTrainees() {
		LOGGER.info("In ClassImpl getAllTrainees ");
		return repo.getAllTrainees();
	}
	public String createClass(String classroom) {
		return repo.createClass(classroom);
	}

	public String createTrainee(String trainee) {
		return repo.createTrainee(trainee);
	}
	public String updateClass(Long id, String classToUpdate) {
		return repo.updateClass(id, classToUpdate);
	}

	public String deleteClass(Long id) {
		return repo.deleteClass(id);

	}

	public void setRepo(ClassRepo repo) {
		this.repo = repo;
	}

	@Override
	public String updateTrainee(Long id, String traineeToUpdate) {
		return repo.updateTrainee(id, traineeToUpdate);
	}

	@Override
	public String deleteTrainee(Long id) {
		return repo.deleteTrainee(id);
	}
}
