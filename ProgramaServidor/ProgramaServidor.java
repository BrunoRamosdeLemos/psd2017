/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programaservidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ProgramaServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Servicos sv = new Servicos();//Serviços do servidor
        ArrayList<Sala> ls = new ArrayList();//lista de salas
        sv.setLs(ls);//recebe a lista de salas

        //Setando para teste
        Sala s = new Sala();
        s.setIdSala("A1");
        s.setDescricao("Sala de Aula");
        ls.add(s);

        s = new Sala();
        s.setIdSala("A2");
        s.setDescricao("Sala de Aula");
        ls.add(s);

        s = new Sala();
        s.setIdSala("A3");
        s.setDescricao("Sala de Aula");
        ls.add(s);

        s = new Sala();
        s.setIdSala("A4");
        s.setDescricao("Laboratorio");
        ls.add(s);

        s = new Sala();
        s.setIdSala("B1");
        s.setDescricao("Auditorio");
        ls.add(s);

        s = new Sala();
        s.setIdSala("B2");
        s.setDescricao("Laboratorio");
        ls.add(s);

        s = new Sala();
        s.setIdSala("B3");
        s.setDescricao("Sala de Aula");
        ls.add(s);
        //fimmmmmm
        System.out.println("--------Iniciando o Sevidor---------------");

        try {
            int serverPort = 7777; // the server port
            ArrayList<Integer> cl = new ArrayList();//lista de clientes

            ServerSocket listenSocket = new ServerSocket(serverPort);

            System.out.println("Servidor iniciado com sucesso:\nEscutando por conexões na porta:" + serverPort);
            while (true) {
                Socket clientSocket = listenSocket.accept();
                Connection c = new Connection(clientSocket, cl, sv); //conexão , lista de clientes, e serviços
            }
        } catch (IOException e) {
            System.out.println("Listen socket:" + e.getMessage());
        }

        System.out.println("--------Finalizando o Sevidor---------------");

    }

}
