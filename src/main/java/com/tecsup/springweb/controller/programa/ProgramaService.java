package com.tecsup.springweb.controller.programa;

import com.tecsup.springweb.model.Programa;
import java.util.List;

public interface ProgramaService {
    
    List<Programa> listPrograma();
    
    Programa get(Long id);
    
    void save(Programa programa);
    
    void delete(Programa programa);
    
}
