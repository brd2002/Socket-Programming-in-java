package SocketProgrammig;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class socketSever {
    public static void main(String[] args) {

        try {
            System.out.println("Waiting for clients......");
            ServerSocket ss = new ServerSocket(9806);
            Socket soc = ss.accept();
            System.out.println("Connection established.......");
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            String str = in.readLine();
            Integer initial = 1; 
            for(Integer i = 1 ; i <= Integer.parseInt(str); i++){
                initial = initial*i ;
            }
            PrintWriter out = new PrintWriter(soc.getOutputStream() , true);
            out.println("Factorial of "+ str + " is : " + initial) ; 
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
