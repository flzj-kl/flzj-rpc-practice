package top.flzjkl.flzjrpc.transport;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 处理网络请求handler
 */
public interface RequestHandler {
    void onRequest(InputStream recive, OutputStream toResp);
}
