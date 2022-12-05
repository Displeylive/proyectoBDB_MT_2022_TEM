package com.emergentes.dao;

import com.emergentes.modelo.Encargado;
import java.util.List;

public interface EncargadoDAO {
    public void insert(Encargado encargado)throws Exception;
    public void upate(Encargado encargado)throws Exception;
    public void delete(int id_en)throws Exception;
    public Encargado getById(int id_en)throws Exception;
    public List<Encargado> getAll()throws Exception;
}
