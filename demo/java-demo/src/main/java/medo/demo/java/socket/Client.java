package medo.demo.java.socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
    
    public static void main(String[] args) {
        post("localhost", 4200);
    }
    
    private static void post(String ip, int port) {
        try {
            Socket client = new Socket(ip, port);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            String str = "你好，这是我的第一个sockewt";
            bufferedWriter.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
