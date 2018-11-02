package com.cognizant.repository;

public interface ClassRepo {

	String getAllTrainers();

	String createTrainer(String accout);

	String updateTrainer(Long id, String accountToUpdate);

	String deleteTrainer(Long id);

}