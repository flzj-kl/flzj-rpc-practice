package top.flzjkl.flzjrpc.proto;

import lombok.Data;

/**
 * 表示PRC的返回
 *
 */
@Data
public class Response {
    /**
     * 服务返回编码,0-成功。非0失败
     */
    private int code = 0;
    private String message;
    private Object data;
}
