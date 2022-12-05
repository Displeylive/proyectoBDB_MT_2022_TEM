
package com.emergentes.dao;

import com.emergentes.modelo.Tipo_buses;
import java.util.List;

public interface Tipo_busesDAO {
    public void insert(Tipo_buses tipo_buses)throws Exception;
    public void upate(Tipo_buses tipo_buses)throws Exception;
    public void delete(int id_t)throws Exception;
    public Tipo_buses getById(int id_t)throws Exception;
    public List<Tipo_buses> getAll()throws Exception;
}
