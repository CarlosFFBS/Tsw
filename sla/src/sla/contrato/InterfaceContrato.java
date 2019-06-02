/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sla.contrato;

import java.util.ArrayList;

/**
 *
 * @author Fabiano
 */
public interface InterfaceContrato {

    boolean cadastrarContratoPF(ContratoPF contratopf) throws Exception;

    boolean cadastrarContratoPJ(ContratoPJ contratopj) throws Exception;

    boolean removerContratoPF(ContratoPF contratopf) throws Exception;

    boolean removerContratoPJ(ContratoPJ contratopj) throws Exception;

    boolean alterarContratoPF(ContratoPF contratopf) throws Exception;

    boolean alterarContratoPJ(ContratoPJ contratopj) throws Exception;

    ArrayList<ContratoPF> consultarPFContrato(ContratoPF contratopf) throws Exception;

    ArrayList<ContratoPJ> consultarPJContrato(ContratoPJ contratopj) throws Exception;

    ArrayList<ContratoPF> listarContratoPF() throws Exception;

    ArrayList<ContratoPJ> listarContratoPJ() throws Exception;

    Boolean verificarDuplicidadeContratoPF(ContratoPF filtroPF) throws Exception;

    Boolean verificarDuplicidadeContratoPJ(ContratoPJ filtroPJ) throws Exception;

    Boolean verificarContratoPF(ContratoPF filtroPF) throws Exception;

    Boolean verificarContratoPJ(ContratoPJ filtroPJ) throws Exception;
}
