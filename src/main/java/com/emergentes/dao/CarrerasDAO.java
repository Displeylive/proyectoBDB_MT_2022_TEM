
package com.emergentes.dao;

import com.emergentes.modelo.Carreras;
import java.util.List;

public interface CarrerasDAO {
    public void insert(Carreras carreras)throws Exception;
    public void upate(Carreras carreras)throws Exception;
    public void delete(int id_c)throws Exception;
    public Carreras getById(int id_c)throws Exception;
    public List<Carreras> getAll()throws Exception;
}
