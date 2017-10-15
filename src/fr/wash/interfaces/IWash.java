package fr.wash.interfaces;

import java.util.List;

import fr.wash.entities.User;

public interface IWash {
	public Object addObject(Object object);
	public void removeObject(Object object);
	public Object findById(Object object,int id);
	public Object updateObject(Object object);
	public List<Object> getAllObject(String object);
	
	public User login(User user);
}
