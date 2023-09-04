package com.multimotors;

import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Fabian
 * @author Sergio
 * @param <E>
 */
public class ViewTester<E> {
    
    public void showEntity(E entity) {
        if(entity == null){
            System.out.println("No existe");
        } else {
            System.out.println(entity.toString());	
        }
    }
	
    public void showEntities(HashMap<Integer, E> entities) {			
	if(!entities.isEmpty()) {
            System.out.println("======================\nDatos encontrados:");
            SortedSet<Integer> keys = new TreeSet<>(entities.keySet());
            for(int key : keys) {
	        System.out.println(entities.get(key).toString());
            }
        } else {
		System.out.println("No se han encontrado datos");	
	}
    }    
}