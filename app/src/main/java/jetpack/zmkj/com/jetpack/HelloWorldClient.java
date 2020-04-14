package jetpack.zmkj.com.jetpack;

import android.os.Build;

import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

public class HelloWorldClient {
    HelloReply helloReply = null;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void say(String name) {
        try {
            HelloRequest request = HelloRequest.newBuilder().setName(name).build();
            HelloReply helloReply = sayHello2(request);
        } catch (Exception e) {
        }
    }

    /**
     * Websocket使用和 HTTP 相同的 TCP 端口，可以绕过大多数防火墙的限制。默认情况下，Websocket协议使用80端口；运行在TLS之上时，默认使用443端口。其协议标识符为ws，如果加密使用wss，服务器网址为URL，如：
     *
     * @param request
     * @return
     */
    public HelloReply sayHello2(HelloRequest request) {
        String url = "ws://www.example.com/";
        OkHttpClient client = new OkHttpClient.Builder()
                .writeTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();
        Request request1 = new Request.Builder().url(url).build();
        WebSocket webSocket = client.newWebSocket(request1, new WebSocketListener() {
            @Override
            public void onOpen(WebSocket webSocket, Response response) {
                super.onOpen(webSocket, response);
            }

            @Override
            public void onMessage(WebSocket webSocket, String text) {
                super.onMessage(webSocket, text);
                helloReply = HelloReply.newBuilder().setMessage(text).build();
            }

            @Override
            public void onMessage(WebSocket webSocket, ByteString bytes) {
                super.onMessage(webSocket, bytes);

            }

            @Override
            public void onClosing(WebSocket webSocket, int code, String reason) {
                super.onClosing(webSocket, code, reason);
            }

            @Override
            public void onClosed(WebSocket webSocket, int code, String reason) {
                super.onClosed(webSocket, code, reason);
            }

            @Override
            public void onFailure(WebSocket webSocket, Throwable t, Response response) {
                super.onFailure(webSocket, t, response);
            }

            @Override
            public int hashCode() {
                return super.hashCode();
            }

            @Override
            public boolean equals(@Nullable Object obj) {
                return super.equals(obj);
            }

            @Override
            protected Object clone() throws CloneNotSupportedException {
                return super.clone();
            }

            @NonNull
            @Override
            public String toString() {
                return super.toString();
            }

            @Override
            protected void finalize() throws Throwable {
                super.finalize();
            }
        });

        webSocket.send(request.getName());
        return helloReply;
    }


}
