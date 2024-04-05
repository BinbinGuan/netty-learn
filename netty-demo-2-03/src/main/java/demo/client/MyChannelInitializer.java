package demo.client;

import demo.codec.ObjDecoder;
import demo.codec.ObjEncoder;
import demo.domain.MsgInfo;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;



public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        //对象传输处理
        channel.pipeline().addLast(new ObjDecoder(MsgInfo.class));
        channel.pipeline().addLast(new ObjEncoder(MsgInfo.class));
        // 在管道中添加我们自己的接收数据实现方法
        channel.pipeline().addLast(new MyClientHandler());
    }

}
