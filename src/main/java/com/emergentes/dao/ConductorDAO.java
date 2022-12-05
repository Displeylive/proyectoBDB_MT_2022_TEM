package com.emergentes.dao;

import com.emergentes.modelo.Conductor;
import java.util.List;

public interface ConductorDAO {
    public void insert(Conductor conductor)throws Exception;
    public void upate(Conductor conductor)throws Exception;
    public void delete(int id_con)throws Exception;
    public Conductor getById(int id_con)throws Exception;
    public List<Conductor> getAll()throws Exception;
}
