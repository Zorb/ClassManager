package com.cognizant.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.cognizant.domain.Trainer;
import com.cognizant.util.JSONUtil;


@Transactional(SUPPORTS)
@Default
public class ClassDBRepo implements ClassRepo {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public String getAllTrainers() {
		Query query = manager.createQuery("Select a FROM Account a");
		Collection<Trainer> accounts = (Collection<Trainer>) query.getResultList();
		return util.getJSONForObject(accounts);
	}

	@Transactional(REQUIRED)
	public String createTrainer(String trainer) {
		Trainer aTrainer = util.getObjectForJSON(trainer, Trainer.class);
		manager.persist(aTrainer);
		return "{\"message\": \"account has been sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	public String updateTrainer(Long id, String trainerToUpdate) {
		Trainer updatedTrainer = util.getObjectForJSON(trainerToUpdate, Trainer.class);
		Trainer trainerFromDB = findTrainer(id);
		if (trainerToUpdate != null) {
			trainerFromDB = updatedTrainer;
			manager.merge(trainerFromDB);
		}
		return "{\"message\": \"account sucessfully updated\"}";
	}

	@Transactional(REQUIRED)
	public String deleteTrainer(Long id) {
		Trainer trainertInDB = findTrainer(id);
		if (trainertInDB != null) {
			manager.remove(trainertInDB);
		}
		return "{\"message\": \"account sucessfully deleted\"}";
	}

	private Trainer findTrainer(Long id) {
		return manager.find(Trainer.class, id);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}