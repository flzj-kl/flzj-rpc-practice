package top.flzjkl.flzjrpc.proto;

import lombok.Data;

/**
 * 表示一个PRC请求
 */
@Data
public class Request {
    private ServiceDescriptor serviceDescriptor;
    private Object[] parameters;
}
