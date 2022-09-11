package top.flzjkl.flzjrpc.client;

import lombok.extern.slf4j.Slf4j;
import top.flzjkl.flzjrpc.common.utils.ReflectionUtils;
import top.flzjkl.flzjrpc.proto.Peer;
import top.flzjkl.flzjrpc.transport.TransportClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
public class RandomTransportSelector implements TransportSelector {
    /**
     * 已经连接好的client
     */
    private List<TransportClient> clients;

    public RandomTransportSelector () {
        clients = new ArrayList<>();
    }

    @Override
    public synchronized void init (List<Peer> peers, int count, Class<? extends TransportClient> clazz) {
        count = Math.max(count, 1);

        for (Peer peer : peers) {
            for (int i = 0 ; i < count ; i++) {
                TransportClient transportClient = ReflectionUtils.newInstance(clazz);
                transportClient.connect(peer);
                clients.add(transportClient);
            }
            log.info("connect server: {}",peer);
        }

    }

    @Override
    public synchronized TransportClient select() {
        int index = new Random().nextInt(clients.size());
        return clients.remove(index);
    }

    @Override
    public synchronized void release(TransportClient client) {
        clients.add(client);
    }

    @Override
    public synchronized void close() {
        for (TransportClient client : clients) {
            client.close();
        }
        clients.clear();
    }
}
