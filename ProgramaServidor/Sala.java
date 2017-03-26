/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programaservidor;

/**
 *
 * @author User
 */
public class Sala {

    private String idSala;
    private String descricao;
    private int usadaPor;

    public Sala() {
        this.usadaPor = -1;
    }

    /**
     * @return the idSala
     */
    public String getIdSala() {
        return idSala;
    }

    /**
     * @param idSala the idSala to set
     */
    public void setIdSala(String idSala) {
        this.idSala = idSala;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the usadaPor
     */
    public int getUsadaPor() {
        return usadaPor;
    }

    /**
     * @param usadaPor the usadaPor to set
     */
    public void setUsadaPor(int usadaPor) {
        this.usadaPor = usadaPor;
    }

}
