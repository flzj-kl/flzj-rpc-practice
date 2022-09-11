package top.flzjkl.flzjrpc.transport;

import org.apache.commons.io.IOUtils;
import top.flzjkl.flzjrpc.proto.Peer;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class HTTPTransportClient implements TransportClient{
    private String url;

    @Override
    public void connect(Peer peer) {
        this.url = "http://" + peer.getHost() + ":" + peer.getPort();
    }

    @Override
    public InputStream write(InputStream data) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection)new URL(url).openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(true);
            httpURLConnection.setRequestMethod("POST");

            httpURLConnection.connect();

            IOUtils.copy(data,httpURLConnection.getOutputStream());

            int resultCode = httpURLConnection.getResponseCode();
            if(resultCode == HttpURLConnection.HTTP_OK)
                return httpURLConnection.getInputStream();
            else
                return httpURLConnection.getErrorStream();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() {

    }
}
