package top.flzjkl.flzjrpc.server;

import lombok.Data;
import top.flzjkl.flzjrpc.codec.Decoder;
import top.flzjkl.flzjrpc.codec.Encoder;
import top.flzjkl.flzjrpc.codec.JSONDecoder;
import top.flzjkl.flzjrpc.codec.JSONEncoder;
import top.flzjkl.flzjrpc.transport.HTTPTransportServer;
import top.flzjkl.flzjrpc.transport.TransportServer;

/**
 * server配置
 */
@Data
public class RpcServerConfig {
    private Class<? extends TransportServer> transportServerClass = HTTPTransportServer.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private int port = 3939;
}
