package top.flzjkl.flzjrpc.client;

import lombok.Data;
import top.flzjkl.flzjrpc.codec.Decoder;
import top.flzjkl.flzjrpc.codec.Encoder;
import top.flzjkl.flzjrpc.common.utils.ReflectionUtils;

import java.lang.reflect.Proxy;

@Data
public class PpcClient {
    private RpcClientConfig config;
    private Encoder encoder;
    private Decoder decoder;
    private TransportSelector selector;

    public PpcClient () {
        this(new RpcClientConfig());
    }

    public PpcClient (RpcClientConfig config) {
        this.config = config;
        this.encoder = ReflectionUtils.newInstance(this.config.getEncoderClass());
        this.decoder = ReflectionUtils.newInstance(this.config.getDecoderClass());
        this.selector = ReflectionUtils.newInstance(this.config.getSelectorClass());

        this.selector.init(
                this.config.getServers(),
                this.config.getConnectCont(),
                this.config.getTransportClientClass()
        );
    }
    public <T> T getProxy (Class<T> clazz) {
        return (T)Proxy.newProxyInstance (
                getClass().getClassLoader(),
                new Class[] {clazz},
                new RemoteInvoker(clazz, encoder, decoder, selector)
        );
    }
}
