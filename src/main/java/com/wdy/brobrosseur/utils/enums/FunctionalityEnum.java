/*
 * Created on 2018-04-14 ( Time 21:52:32 )
 * Generator tool : Telosys Tools Generator ( version 3.0.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdy.brobrosseur.utils.enums;

/**
 * 
 * @author Geo
 *
 */
 public enum FunctionalityEnum {
 	DEFAULT("DEFAULT"),

	// ACTIVITE
	VIEW_ACTIVITE("VIEW_ACTIVITE"),	
	CREATE_ACTIVITE("CREATE_ACTIVITE"),
	UPDATE_ACTIVITE("UPDATE_ACTIVITE"),
	DELETE_ACTIVITE("DELETE_ACTIVITE"),
	// ACTIVITE_PRESTATION
	VIEW_ACTIVITE_PRESTATION("VIEW_ACTIVITE_PRESTATION"),	
	CREATE_ACTIVITE_PRESTATION("CREATE_ACTIVITE_PRESTATION"),
	UPDATE_ACTIVITE_PRESTATION("UPDATE_ACTIVITE_PRESTATION"),
	DELETE_ACTIVITE_PRESTATION("DELETE_ACTIVITE_PRESTATION"),
	// COMMAND
	VIEW_COMMAND("VIEW_COMMAND"),	
	CREATE_COMMAND("CREATE_COMMAND"),
	UPDATE_COMMAND("UPDATE_COMMAND"),
	DELETE_COMMAND("DELETE_COMMAND"),
	// EVALUATION_COMMAND
	VIEW_EVALUATION_COMMAND("VIEW_EVALUATION_COMMAND"),	
	CREATE_EVALUATION_COMMAND("CREATE_EVALUATION_COMMAND"),
	UPDATE_EVALUATION_COMMAND("UPDATE_EVALUATION_COMMAND"),
	DELETE_EVALUATION_COMMAND("DELETE_EVALUATION_COMMAND"),
	// IMAGES_PRESTATION
	VIEW_IMAGES_PRESTATION("VIEW_IMAGES_PRESTATION"),	
	CREATE_IMAGES_PRESTATION("CREATE_IMAGES_PRESTATION"),
	UPDATE_IMAGES_PRESTATION("UPDATE_IMAGES_PRESTATION"),
	DELETE_IMAGES_PRESTATION("DELETE_IMAGES_PRESTATION"),

	//SETTING
	VIEW_SETTING("VIEW_SETTING"),
	CREATE_SETTING("CREATE_SETTING"),
	UPDATE_SETTING("UPDATE_SETTING"),
	DELETE_SETTING("DELETE_SETTING"),

	// MOYEN_DEPLACEMENT
	VIEW_MOYEN_DEPLACEMENT("VIEW_MOYEN_DEPLACEMENT"),	
	CREATE_MOYEN_DEPLACEMENT("CREATE_MOYEN_DEPLACEMENT"),
	UPDATE_MOYEN_DEPLACEMENT("UPDATE_MOYEN_DEPLACEMENT"),
	DELETE_MOYEN_DEPLACEMENT("DELETE_MOYEN_DEPLACEMENT"),
	// PRESTATAIRE_ZONE_LIVRAISON
	VIEW_PRESTATAIRE_ZONE_LIVRAISON("VIEW_PRESTATAIRE_ZONE_LIVRAISON"),	
	CREATE_PRESTATAIRE_ZONE_LIVRAISON("CREATE_PRESTATAIRE_ZONE_LIVRAISON"),
	UPDATE_PRESTATAIRE_ZONE_LIVRAISON("UPDATE_PRESTATAIRE_ZONE_LIVRAISON"),
	DELETE_PRESTATAIRE_ZONE_LIVRAISON("DELETE_PRESTATAIRE_ZONE_LIVRAISON"),
	// PRESTATION
	VIEW_PRESTATION("VIEW_PRESTATION"),	
	CREATE_PRESTATION("CREATE_PRESTATION"),
	UPDATE_PRESTATION("UPDATE_PRESTATION"),
	DELETE_PRESTATION("DELETE_PRESTATION"),
	// PRESTATION_MOYEN_DEPLACEMENT
	VIEW_PRESTATION_MOYEN_DEPLACEMENT("VIEW_PRESTATION_MOYEN_DEPLACEMENT"),	
	CREATE_PRESTATION_MOYEN_DEPLACEMENT("CREATE_PRESTATION_MOYEN_DEPLACEMENT"),
	UPDATE_PRESTATION_MOYEN_DEPLACEMENT("UPDATE_PRESTATION_MOYEN_DEPLACEMENT"),
	DELETE_PRESTATION_MOYEN_DEPLACEMENT("DELETE_PRESTATION_MOYEN_DEPLACEMENT"),
	// RECORD_IMAGE
	VIEW_RECORD_IMAGE("VIEW_RECORD_IMAGE"),	
	CREATE_RECORD_IMAGE("CREATE_RECORD_IMAGE"),
	UPDATE_RECORD_IMAGE("UPDATE_RECORD_IMAGE"),
	DELETE_RECORD_IMAGE("DELETE_RECORD_IMAGE"),
	// ROLE
	VIEW_ROLE("VIEW_ROLE"),	
	CREATE_ROLE("CREATE_ROLE"),
	UPDATE_ROLE("UPDATE_ROLE"),
	DELETE_ROLE("DELETE_ROLE"),
	// TYPE_CLIENT
	VIEW_TYPE_CLIENT("VIEW_TYPE_CLIENT"),	
	CREATE_TYPE_CLIENT("CREATE_TYPE_CLIENT"),
	UPDATE_TYPE_CLIENT("UPDATE_TYPE_CLIENT"),
	DELETE_TYPE_CLIENT("DELETE_TYPE_CLIENT"),
	// UTILISATEUR
	VIEW_UTILISATEUR("VIEW_UTILISATEUR"),	
	CREATE_UTILISATEUR("CREATE_UTILISATEUR"),
	UPDATE_UTILISATEUR("UPDATE_UTILISATEUR"),
	DELETE_UTILISATEUR("DELETE_UTILISATEUR"),
	// UTILISATEUR_ACTIVITE
	VIEW_UTILISATEUR_ACTIVITE("VIEW_UTILISATEUR_ACTIVITE"),	
	CREATE_UTILISATEUR_ACTIVITE("CREATE_UTILISATEUR_ACTIVITE"),
	UPDATE_UTILISATEUR_ACTIVITE("UPDATE_UTILISATEUR_ACTIVITE"),
	DELETE_UTILISATEUR_ACTIVITE("DELETE_UTILISATEUR_ACTIVITE"),
	// UTILISATEUR_ROLE
	VIEW_UTILISATEUR_ROLE("VIEW_UTILISATEUR_ROLE"),	
	CREATE_UTILISATEUR_ROLE("CREATE_UTILISATEUR_ROLE"),
	UPDATE_UTILISATEUR_ROLE("UPDATE_UTILISATEUR_ROLE"),
	DELETE_UTILISATEUR_ROLE("DELETE_UTILISATEUR_ROLE"),
	// ZONE_LIVRAISON
	VIEW_ZONE_LIVRAISON("VIEW_ZONE_LIVRAISON"),	
	CREATE_ZONE_LIVRAISON("CREATE_ZONE_LIVRAISON"),
	UPDATE_ZONE_LIVRAISON("UPDATE_ZONE_LIVRAISON"),
	DELETE_ZONE_LIVRAISON("DELETE_ZONE_LIVRAISON");

	private final String value;
 	public String getValue() {
 		return value;
 	}
 	private FunctionalityEnum(String value) {
 		this.value = value;
 	}
}
