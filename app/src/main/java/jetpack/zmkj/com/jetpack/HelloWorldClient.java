package jetpack.zmkj.com.jetpack;

import android.os.Build;

import java.net.URI;

import androidx.annotation.RequiresApi;

public class HelloWorldClient {
    HelloReply helloReply = null;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void aa(String name) {
        try {
            HelloRequest request = HelloRequest.newBuilder().setName(name).build();
            HelloReply helloReply = sayHello(request);
        } catch (Exception e) {
        }
    }


    public HelloReply sayHello(HelloRequest request) {

        String url = "";
        URI uri = URI.create(url);
        JWebSocketClient jWebSocketClient = new JWebSocketClient(uri) {
            @Override
            public void onMessage(String message) {
                super.onMessage(message);
                helloReply = HelloReply.newBuilder().setMessage(message).build();
            }
        };
        jWebSocketClient.send(request.getName());

        return helloReply;
    }
}
