package top.flzjkl.flzjrpc.example;


import top.flzjkl.flzjrpc.client.PpcClient;

public class Client {
    public static void main(String[] args) {
        PpcClient client = new PpcClient();
        CalcService service = client.getProxy(CalcService.class);
        int r1 = service.add(1, 2);
        int r2 = service.minus(10, 8);

        System.out.println(r1);
        System.out.println(r2);
    }
}
