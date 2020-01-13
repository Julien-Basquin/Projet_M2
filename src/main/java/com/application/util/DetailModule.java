package com.application.util;

import org.springframework.stereotype.Component;

@Component
public class DetailModule {
	
	private boolean moduleAccueil;
	
	public DetailModule() {
		setModuleAccueil(false);
	}
	
	public void reset() {
		this.moduleAccueil = false;
	}
	
	// -------------------- Getter ----------------------
	
	public boolean isModuleAccueil() {
		return moduleAccueil;
	}
	
	//--------------------- Setter -----------------------
	public void setModuleAccueil(boolean moduleAccueil) {
		reset();
		this.moduleAccueil = moduleAccueil;
	}
}
