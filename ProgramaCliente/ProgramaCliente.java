/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Bruno Ramos
 */
public class ProgramaCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {//Argumento e o servidor
        Socket s = null;
        int serverPort = Integer.parseInt(args[1]);//porta do servidor
        Random i = new Random();
        Cliente c = new Cliente();
        boolean init = false;
        boolean exit = false;

        c.setIdCliente(i.nextInt(Integer.SIZE - 1));//cria o id do cliente para este exemplo

        while (!exit) {



        try {

            s = new Socket(args[0], serverPort);
            //Servidor configurado para loopback
            String msg;//Mensagem a ser enviada
            Operacao op = new Operacao();

            DataInputStream in = new DataInputStream(s.getInputStream());//MENSAGEM DE DADOS  DO SERVIDOR
            DataOutputStream out = new DataOutputStream(s.getOutputStream());//MENSAGEM PARA O SERVIDOR
            String data;

            if (!init) {
                //mensagem de inicio
                msg = op.inicia(c.getIdCliente());
                out.writeUTF(msg);      	// UTF is a string encoding
                data = in.readUTF();	    // read a line of data from the stream
                System.out.println("data" + data);
                if (data.startsWith("CONF")) {
                    init = true;
                    System.out.println("Conectado com sucesso!");//recebe a mensagem de confirmação de inicio
                    //System.out.println("Received: " + data); //resposta do servidor
                } else {
                    System.out.println("Nao foi possivel receber resposta válida do servidor.Tente mais tarde");
                    exit = true;
                }
            } else { //------------------------CONECTADO COM SERVIDOR------------------------
                String Command = new String();

                    System.out.println("-----Sistema de Alocação de Salas-----");
                    System.out.println("Voce é: ClienteID[" + c.getIdCliente() + "]");
                    System.out.println("Que operação desejas ?");
                    System.out.println("\n -Consulta (C); \n -Requisitar sala(R); \n -Sair(S);");
                    System.out.println("\n OPÇÃO >>:");

                    try {
                        Scanner din;
                        din = new Scanner(System.in);
                        Command = din.next();

                        switch (Command.toUpperCase()) {
                            case "C"://CONSULTA SALAS
                                System.out.println("Fazendo consulta\nSalas disponiveis:");
                                msg = op.escreveMensagem(c.getIdCliente());
                                out.writeUTF(msg);
                                data = in.readUTF();
                                if (data.startsWith("LIST")) {
                                    op.mostraConsulta(data);//RESPOSTA DO SERVIDOS COMO ARGUMENTO
                                } else {
                                    System.out.println("Ocorreu um erro na mensagem do servidor!");
                                }
                                break;
                            case "R"://REQUISITA SALA
                                Scanner sid;
                                System.out.println("\nEscreva o id da sala a ser requisitada:\n");
                                sid = new Scanner(System.in);
                                System.out.println("\nFazendo alocacao\n");
                                msg = op.escreveMensagem(sid.next(), c.getIdCliente());
                                out.writeUTF(msg);
                                data = in.readUTF();
                                if (data.startsWith("ALOC")) {
                                    System.out.println("Sala reservada com sucesso!!");
                                } else {
                                    System.out.println("Sala ocupada!!");
                                }
                                break;
                            case "S"://FINALIZANDO
                                System.out.println(op.finaliza(c.getIdCliente()));
                                msg = op.finaliza(c.getIdCliente());
                                out.writeUTF(msg);
                                data = in.readUTF();
                                if (data.startsWith("FIMS")) {
                                    System.out.println("Finalizado com sucesso!\nTenha um bom dia!");
                                    exit = true;
                                } else {
                                    System.out.println("Servidor não finalizou corretamente, procure um tecnico!!");
                                    exit = true;
                                }
                                break;
                            default:
                                System.out.println("\nCliente requisitou Operacao invalida\n");
                        }

                    } catch (Exception ex) {
                        System.err.println("Programa Cliente: exception: " + ex.toString());
                }

            }

        } catch (UnknownHostException e) {
            System.out.println("Socket:" + e.getMessage());
        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("readline:" + e.getMessage());
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (IOException e) {
                    System.out.println("close:" + e.getMessage());
                }
            }
            }
        }

        System.out.println("............");

    }

}
