package top.flzjkl.flzjrpc.codec;

/**
 * 反序列化
 */
public interface Decoder {
    <T> T decode(byte[] bytes,Class<T> clazz);
}
