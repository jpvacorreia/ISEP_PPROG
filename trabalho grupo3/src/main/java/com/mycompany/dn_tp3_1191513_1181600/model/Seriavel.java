package com.mycompany.dn_tp3_1191513_1181600.model;

import java.util.Comparator;

/**
 * Interface Seriavel define um contrato com as classes que a implementarem
 * de forma a que as mesmas implementes um método compare com determinados
 * parâmetros de entrada e de retorno.
 */
public interface Seriavel extends Comparator<Candidatura> {


    @Override
    int compare(Candidatura t, Candidatura t1);

}
