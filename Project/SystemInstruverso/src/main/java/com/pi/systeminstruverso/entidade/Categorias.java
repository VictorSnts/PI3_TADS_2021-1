package com.pi.systeminstruverso.entidade;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

/**
 *
 * @author victor
 */

public class Categorias {
    
    private String categoria;    

    public Categorias(String categoria) {
        this.categoria = categoria;
    }
}
