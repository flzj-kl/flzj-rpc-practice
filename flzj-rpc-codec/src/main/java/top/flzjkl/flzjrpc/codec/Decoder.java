package top.flzjkl.flzjrpc.codec;

/**
 * εεΊεε
 */
public interface Decoder {
    <T> T decode(byte[] bytes,Class<T> clazz);
}
