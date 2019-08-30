package cn.wishhust.io;



import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

public class HttpServer {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress(8080));
        ssc.configureBlocking(false);

        Selector selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT);

        for(;;) {

            if (selector.select(3000) == 0) {
                continue;
            }
            Iterator<SelectionKey> keyIter = selector.selectedKeys().iterator();
            while (keyIter.hasNext()) {
                SelectionKey key = keyIter.next();
//                new Thread(new HttpHandle())
            }


        }
    }

    private class HttpHandle implements Runnable {

        private int bufferSize = 1024;
        private String localCharset = "UTF-8";



        @Override
        public void run() {

        }
    }


}


