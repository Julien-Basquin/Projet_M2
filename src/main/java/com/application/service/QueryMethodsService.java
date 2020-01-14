package com.application.service;

import java.util.Collection;
import java.util.List;

import com.application.entity.Data;

public interface QueryMethodsService {
	/**
	 * Vérifie si une requête est valide (pas de modification en base)
	 * 
	 * @param query	Requête à vérifier
	 * 
	 * @return True si la requête est valide, false sinon
	 */
	boolean checkQueryValidity(String query);
	
	/**
	 * Exécute la requête indiquée en paramètre.
	 * La requête ne peut pas modifier la base de données (récupération de données uniquement).
	 * 
	 * @param query	Requête
	 * 
	 * @return	La liste des résultats de la requête
	 */
	List<Data> executeQuery(String query);
	
	long createData(Data data);
}
