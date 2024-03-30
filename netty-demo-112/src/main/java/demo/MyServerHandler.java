package demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.EmptyByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;

import java.nio.charset.Charset;


public class MyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 当通道有可读数据时进行处理。
     *
     * @param ctx 通道上下文，用于执行与通道相关的操作。
     * @param msg 从通道读取到的消息对象。
     * @throws Exception 如果处理过程中发生异常。
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 检查消息是否为HTTP请求
        if (msg instanceof HttpRequest) {
            DefaultHttpRequest request = (DefaultHttpRequest) msg;
            System.out.println("URI:" + request.getUri());
            System.err.println(msg);//System.err.println和System.out.println的区别是什么？回答：
        }

        // 检查消息是否为HTTP内容
        if (msg instanceof HttpContent) {
            LastHttpContent httpContent = (LastHttpContent) msg;
            ByteBuf byteData = httpContent.content();
            if (!(byteData instanceof EmptyByteBuf)) {
                // 处理HTTP内容数据
                byte[] msgByte = new byte[byteData.readableBytes()];
                byteData.readBytes(msgByte);
                System.out.println(new String(msgByte, Charset.forName("UTF-8")));
            }
        }

        // 准备发送的消息
        String sendMsg = "test001";

        // 构建响应
        FullHttpResponse response = new DefaultFullHttpResponse(
                HttpVersion.HTTP_1_1,
                HttpResponseStatus.OK,
                Unpooled.wrappedBuffer(sendMsg.getBytes()));
        // 设置响应头信息
        response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain;charset=UTF-8");
        response.headers().set(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes());
        response.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);

        // 写入响应并刷新
        ctx.write(response);
        ctx.flush();
    }

    /**
     * 当通道读取操作完成时被调用。
     * 这个方法是Netty框架中的回调方法，用于处理通道读取操作完成后的清理工作。
     *
     * @param ctx 通道上下文，提供了与通道相关的操作和属性。它是Netty框架中用于交互的中心对象。
     * @throws Exception 如果在处理过程中发生异常，则抛出异常。
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        // 刷新通道，将缓冲区中的数据写入到通道中
        ctx.flush();
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        cause.printStackTrace();
    }

}
