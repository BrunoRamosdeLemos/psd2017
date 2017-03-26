/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programaservidor;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Servicos {

    private ArrayList<Sala> ls;//lista de salas
    private ArrayList<Integer> cl;//lista de clientes conectados

    /**
     * @return the ls
     */
    public ArrayList<Sala> getLs() {
        return ls;
    }

    /**
     * @param ls the ls to set
     */
    public void setLs(ArrayList<Sala> ls) {
        this.ls = ls;
    }

    public void addSala(Sala s) {//Adiciona sala a lista de salas
        if (ls.contains(s)) {
            System.out.println("ERRO,SALA JA EXISTE");
        } else {
            this.ls.add(s);
        }

    }

    public void remSala(Sala s) {//Remove sala da lista de salas
        this.ls.remove(s);
    }

    public boolean aloca(String sid, int cid) {//Aloca sala para cliente
        for (int i = 0; i < this.ls.size(); i++) {
            if (this.ls.get(i).getIdSala().equalsIgnoreCase(sid)) {
                if (this.ls.get(i).getUsadaPor() == -1) {//Sala não está em uso
                    this.ls.get(i).setUsadaPor(cid);
                    return true;
                }
            }
        }
        return false;//sala em uso
    }

    public void desaloca(String sid) {//desaloca sala
        for (int i = 0; i < this.ls.size(); i++) {
            if (this.ls.get(i).getIdSala().equalsIgnoreCase(sid)) {
                this.ls.get(i).setUsadaPor(-1);//idCliente é sempre positivo
            }
        }
    }

    public String inicia(int cid) {//mesagem de confirmação de inicio
        String msg;
        msg = "CONF " + Integer.toString(cid) + "\n\n";
        return msg;
    }

    public String finaliza(int cid) {//mensagem de finalização
        String msg;
        msg = "FIMS " + Integer.toString(cid);
        return msg;
    }

    public String escreveMensagem(int cid) {//mensagem confirmação de alocação sala
        String msg;
        msg = "ALOC " + Integer.toString(cid) + "\n\n";
        return msg;
    }

    public String escreveMensagem() {
        String msg = "LIST ";
        for (int i = 0; i < ls.size(); i++) {
            if (ls.get(i).getUsadaPor() == -1) {
                msg = msg + "|id: " + ls.get(i).getIdSala() + "|\n|descrição:" + ls.get(i).getDescricao() + "|\n";
            }
        }
        return msg;
    }

    public String escreveMensagem(String sid, Integer cid) {
        String msg;
        return msg = "USED" + sid + Integer.toString(cid) + "\n\n";
    }

    /**
     * @return the cl
     */
    public ArrayList<Integer> getCl() {
        return cl;
    }

    /**
     * @param cl the cl to set
     */
    public void setCl(ArrayList<Integer> cl) {
        this.cl = cl;
    }

    public void addCli(Integer c) {//Adiciona cli a lista de cli
        if (cl.contains(c)) {
            System.out.println("ERRO,Cliente JA EXISTE");
        } else {
            this.cl.add(c);
        }

    }

    public void remCli(Integer c) {//Remove cliente da lista de cliente
        this.cl.remove(c);
    }

}
