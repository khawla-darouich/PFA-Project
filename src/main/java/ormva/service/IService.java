package ormva.service;

import java.security.Principal;

import ormva.entities.Emplacement;

public interface IService<T> {
	
	public T one( Long id);
	public T add(T object,Principal currentUser);
	public T update(T object, Long id,Principal currentUser);
	public void delete(Long id, Principal currentUser);
    public T envoyer(Long dossier_id,Principal currentUser,Long emplacement_id);
}
