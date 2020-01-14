package com.application.service;

public interface QueryMethodsService {
	/**
	 * Vérifie si une requête est valide (pas de modification en base)
	 * 
	 * @param query	Requête à vérifier
	 * 
	 * @return True si la requête est valide, false sinon
	 */
	boolean checkQueryValidity(String query);
}
