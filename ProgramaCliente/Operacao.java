/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacliente;

/**
 *
 * @author User
 */
public class Operacao {

    public void mostraConsulta(String m) {

        System.out.println("\n--------------\nResultado da consulta:\n" + m.substring(4));

    }

    public String inicia(Integer cid) {
        String msg;
        msg = "INIT " + Integer.toString(cid) + "\n";
        return msg;
    }

    public String finaliza(Integer cid) {//mensagem de finalização
        String msg;
        msg = "FIMC " + Integer.toString(cid) + "\n";
        return msg;
    }

    public String escreveMensagem(Integer cid) {//mensagem de lista de salas
        String msg;
        msg = "CONS " + Integer.toString(cid) + "\n";
        return msg;
    }

    public String escreveMensagem(String sid, Integer cid) {//mensagem de Requisição de sala
        String msg;
        msg = "REQU " + Integer.toString(cid) + "\n" + sid;
        return msg;

    }


}
