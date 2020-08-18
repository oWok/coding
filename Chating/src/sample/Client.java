package sample;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class Client {
    Socket socket;

    public Client(Socket socket){
        this.socket = socket;
        recive();
    }

    // 클라이언트로 부터 메세지를 전달 받는 메소드
    public void recive(){
        Runnable thread = new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        InputStream in = socket.getInputStream();
                        byte[] buffer = new byte[512];
                        int length = in.read(buffer);
                        while(length == -1) throw new IOException();
                        System.out.println("[메시지 수신성공]" + socket.getRemoteSocketAddress() + ": " +  Thread.currentThread().getName());
                        String message = new String(buffer, 0, length, "UTF-8");

                        for(Client client : Main.clients){
                            client.send(message);
                        }
                    }
                }
                catch (Exception e){
                    try {
                        System.out.println("[메시지 수신 오류]" + socket.getRemoteSocketAddress() + ": " +  Thread.currentThread().getName());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        };
        Main.threadPool.submit(thread);
    }

    //클라이언트로 메세지를 전달하는 메소드
    public void send(String message){
        Runnable thread = new Runnable() {
            @Override
            public void run() {
                try {
                    OutputStream out = socket.getOutputStream();
                    byte[] buffer = message.getBytes("UTF-8");
                    out.write(buffer);
                    out.flush();
                } catch (Exception e){
                    try{
                        System.out.println("[메시지 송신 오류]" + socket.getRemoteSocketAddress() + ": " +  Thread.currentThread().getName());
                        Main.clients.remove(Client.this);
                        socket.close();
                    } catch (Exception e2){
                        e2.printStackTrace();
                    }
                }
            }
        };
        Main.threadPool.submit(thread);
    }
}
