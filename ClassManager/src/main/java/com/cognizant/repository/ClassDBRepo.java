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

import com.cognizant.domain.Classroom;
import com.cognizant.domain.Trainee;
import com.cognizant.util.JSONUtil;


@Transactional(SUPPORTS)
@Default
public class ClassDBRepo implements ClassRepo {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public String getAllClasses() {
		Query query = manager.createQuery("Select c FROM Classroom c");
		Collection<Classroom> classes = (Collection<Classroom>) query.getResultList();
		return util.getJSONForObject(classes);
	}

	public String getAllTrainees() {
		Query query = manager.createQuery("Select c FROM Trainee c");
		Collection<Trainee> trainees = (Collection<Trainee>) query.getResultList();
		return util.getJSONForObject(trainees);
	}

	@Transactional(REQUIRED)
	public String createClass(String classroom) {
		Classroom aClass = util.getObjectForJSON(classroom, Classroom.class);
		manager.persist(aClass);
		return "{\"message\": \"Class has been sucessfully added\"}";
	}
	
	@Transactional(REQUIRED)
	public String createTrainee(String trainee) {
		Trainee aTrainee = util.getObjectForJSON(trainee, Trainee.class);
		manager.persist(aTrainee);
		return "{\"message\": \"Trainee has been sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	public String updateClass(Long id, String classToUpdate) {
		Classroom updatedClass = util.getObjectForJSON(classToUpdate, Classroom.class);
		Classroom classFromDB = findClass(id);
		if (classToUpdate != null) {
			classFromDB = updatedClass;
			manager.merge(classFromDB);
		}
		return "{\"message\": \"Class sucessfully updated\"}";
	}

	@Transactional(REQUIRED)
	public String deleteClass(Long id) {
		Classroom classInDB = findClass(id);
		if (classInDB != null) {
			manager.remove(classInDB);
		}
		return "{\"message\": \"Class sucessfully deleted\"}";
	}

	private Classroom findClass(Long id) {
		return manager.find(Classroom.class, id);
	}

	private Trainee findTrainee(Long id) {
		return manager.find(Trainee.class, id);
	}
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}


}