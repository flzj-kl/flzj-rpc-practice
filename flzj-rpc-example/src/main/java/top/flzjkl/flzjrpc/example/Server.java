package top.flzjkl.flzjrpc.example;

import top.flzjkl.flzjrpc.server.RpcServer;


public class Server{
    public static void main(String[] args) {
        RpcServer rpcServer = new RpcServer();
        rpcServer.register(CalcService.class,new CalcServiceImpl());
        rpcServer.start();
    }
}
