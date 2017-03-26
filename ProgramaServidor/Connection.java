/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programaservidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Connection extends Thread {

    DataInputStream in;
    DataOutputStream out;
    Socket clientSocket;
    Sala st = new Sala();
    Servicos sv;

    public Connection(Socket aClientSocket, ArrayList<Integer> acl, Servicos asv) {
        try {
            clientSocket = aClientSocket;
            sv = asv;
            sv.setCl(acl);
            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());
            this.start();
        } catch (IOException e) {
            System.out.println("Connection:" + e.getMessage());
        }
    }

    @Override
    public void run() {
        try {			                 // an echo server

            String data = in.readUTF();	                  // read a line of data from the stream
            String msg;
            Integer cid;
            if (data.startsWith("INIT")) {
                cid = Integer.parseInt(data.substring(data.indexOf(" ") + 1, data.indexOf("\n")));
                msg = sv.inicia(cid);
                if (!sv.getCl().contains(cid)) {
                    sv.addCli(cid);//Adicionando cliente a lista de clientes
                    out.writeUTF(msg);//Enviando mensagem de Confirmação
                    //-------------------------Cliente Conectado---------------------
                }

            }
            //Consulta
            if (data.startsWith("CONS")) {
                msg = sv.escreveMensagem();
                out.writeUTF(msg);
            }
            //Requisição de alocação
            if (data.startsWith("REQU")) {
                //Alocou comsucesso
                String ids = data.substring(data.indexOf("\n") + 1);
                cid = Integer.parseInt(data.substring(data.indexOf(" ") + 1, data.indexOf("\n")));
                if (sv.aloca(ids, cid)) {
                    msg = sv.escreveMensagem(cid);
                    out.writeUTF(msg);
                } else {//Sala em uso
                    msg = sv.escreveMensagem(ids, cid);
                    out.writeUTF(msg);
                }
            }
            //Finalizando Sessão
            if (data.startsWith("FIMC")) {
                cid = Integer.parseInt(data.substring(data.indexOf(" ") + 1, data.indexOf("\n")));
                msg = sv.finaliza(cid);
                sv.remCli(cid);
                out.writeUTF(msg);

            }

        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("readline:" + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {/*close failed*/
            }
        }

    }
}
