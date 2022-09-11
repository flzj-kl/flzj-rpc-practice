package top.flzjkl.flzjrpc.client;

import lombok.Data;
import top.flzjkl.flzjrpc.codec.Decoder;
import top.flzjkl.flzjrpc.codec.Encoder;
import top.flzjkl.flzjrpc.codec.JSONDecoder;
import top.flzjkl.flzjrpc.codec.JSONEncoder;
import top.flzjkl.flzjrpc.proto.Peer;
import top.flzjkl.flzjrpc.transport.HTTPTransportClient;
import top.flzjkl.flzjrpc.transport.TransportClient;

import java.util.Arrays;
import java.util.List;
@Data
public class RpcClientConfig {
    private Class<? extends TransportClient> transportClientClass = HTTPTransportClient.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private Class<? extends TransportSelector> selectorClass = RandomTransportSelector.class;
    private int connectCont = 1;
    private List<Peer> servers = Arrays.asList(new Peer("127.0.0.1",3939));
}
