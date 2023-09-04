package com.multimotors.controllers;

import java.util.HashMap;

/**
 * @author Fabian
 * @author Sergio
 * @param <E>
 */
public interface GenericController<E> {
    
    public boolean create(E entidad);
    public boolean update(E entidad);
    public boolean delete(int id);
    public E read(int id);
    public HashMap<Integer, E> readAll();    
}