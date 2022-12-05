
package com.emergentes.dao;

import com.emergentes.modelo.Destinos;
import java.util.List;

public interface DestinosDAO {
       public void insert(Destinos destinos)throws Exception;
    public void upate(Destinos destinos)throws Exception;
    public void delete(int id_des)throws Exception;
    public Destinos getById(int id_des)throws Exception;
    public List<Destinos> getAll()throws Exception;
}
