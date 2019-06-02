package sla.contrato;

import java.util.ArrayList;
import java.util.Date;
import sla.Equipamento.Equipamento;

public  class Contrato {

    private int idContrato;
    private Date inicioContrato;
    private Date fimContrato;
    private int umAtendimento;
    private int fimAtendimento;
    private int totalEquipamento;
    private float valor;
    private boolean cobrePeca;
    private ArrayList<Equipamento> equipamento;

    /**
     * @return the idContrato
     */
    public int getIdContrato() {
        return idContrato;
    }

    /**
     * @param idContrato the idContrato to set
     */
    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    /**
     * @return the prazo
     */
    /**
     * @return the umAtendimento
     */
    public int getUmAtendimento() {
        return umAtendimento;
    }

    /**
     * @param umAtendimento the umAtendimento to set
     */
    public void setUmAtendimento(int umAtendimento) {
        this.umAtendimento = umAtendimento;
    }

    /**
     * @return the fimAtendimento
     */
    public int getFimAtendimento() {
        return fimAtendimento;
    }

    public void setFimAtendimento(int fimAtendimento) {
        this.fimAtendimento = fimAtendimento;
    }

    public int getTotalEquipamento() {
        return totalEquipamento;
    }

    public void setTotalEquipamento(int totalEquipamento) {
        this.totalEquipamento = totalEquipamento;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public boolean isCobrePeca() {
        return cobrePeca;
    }

    public void setCobrePeca(boolean cobrePeca) {
        this.cobrePeca = cobrePeca;
    }

    /**
     * @return the inicioContrato
     */
    public Date getInicioContrato() {
        return inicioContrato;
    }

    /**
     * @param inicioContrato the inicioContrato to set
     */
    public void setInicioContrato(Date inicioContrato) {
        this.inicioContrato = inicioContrato;
    }

    /**
     * @return the fimContrato
     */
    public Date getFimContrato() {
        return fimContrato;
    }

    /**
     * @param fimContrato the fimContrato to set
     */
    public void setFimContrato(Date fimContrato) {
        this.fimContrato = fimContrato;
    }

}
