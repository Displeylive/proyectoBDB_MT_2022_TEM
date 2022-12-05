package com.emergentes.dao;

import com.emergentes.modelo.Buses;
import java.util.List;

public interface BusesDAO {
    public void insert(Buses buses)throws Exception;
    public void upate(Buses buses)throws Exception;
    public void delete(int id_bus)throws Exception;
    public Buses getById(int id_bus)throws Exception;
    public List<Buses> getAll()throws Exception;
}
