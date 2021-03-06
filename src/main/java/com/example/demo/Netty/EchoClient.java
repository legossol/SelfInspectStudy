package com.example.demo.Netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.concurrent.DefaultThreadFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import lombok.extern.slf4j.Slf4j;

//@Slf4j
//public class EchoClient {
//  private static final int PORT = 8888;
//  private final String host;
//  private final int port;
//
//  public EchoClient(String host, int port){
//    this.host = host;
//    this.port = port;
//  }
//
//  private EventLoopGroup eventLoopGroup;
//  public Channel serverChannel;
//
//  public void start() throws InterruptedException{
//
//    try{
//      eventLoopGroup = new NioEventLoopGroup(1,new DefaultThreadFactory("client"));
//      Bootstrap bootstrap = new Bootstrap().group(eventLoopGroup);
//      bootstrap.channel(NioSocketChannel.class);
//      bootstrap.remoteAddress(new InetSocketAddress(host,port));
//      bootstrap.handler(new ClientInitializer());
////      bootstrap.handler(new ReadTimeoutHandler(300));
////      bootstrap.handler(new WriteTimeoutHandler(300));
//
//
//      serverChannel = bootstrap.connect().sync().channel();
//
//      ChannelFuture lastWriteFuture = null;
//      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//      //eventLoop
//      for(;;){
//        String line = in.readLine();
//        if(line == null){
//          break;
//        }
//        // Sends the received line to the server.
//        lastWriteFuture = serverChannel.writeAndFlush(line + "\r\n");
//
//        if("quit".equals(line.toLowerCase())){
//          serverChannel.closeFuture().sync();
//          log.info("DISCONNECT CONNECTION WITH SERVER");
//          break;
//        }
//
//      }
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//  }
//
//  public void close() throws InterruptedException {
//    serverChannel.writeAndFlush("[Notify To Server] ?????? ????????? ???????????? ???????????????.");
//    eventLoopGroup.shutdownGracefully().sync();
//  }
//
//  public static void main(String[] args) throws Exception {
//    EchoClient client = new EchoClient("127.0.0.1", PORT);
//    try{
//      client.start();
//    }finally {
//      client.close();
//    }
//  }
//
//}
//
//class ClientInitializer extends ChannelInitializer<SocketChannel>{
//
//  @Override
//  protected void initChannel(SocketChannel ch) throws Exception {
//    ChannelPipeline pipeline = ch.pipeline();
//    pipeline.addLast("IdleChecker", new IdleStateHandler(60,30,0));
//    pipeline.addLast(new LineBasedFrameDecoder(65536));
//    pipeline.addLast("Decoder",new StringDecoder());
//    pipeline.addLast(new StringEncoder());
//    pipeline.addLast(new EchoClientHandler());
//
//  }
//
//}
//
//@Slf4j
////?????? ???????????? ??? ???????????? ????????? ???????????? ?????? ???????????????
//@Sharable
//class EchoClientHandler extends SimpleChannelInboundHandler {
//  private String receiveMsg;
//  public String getReceiveMsg(){
//    return this.receiveMsg;
//  }
//  //???????????? ???????????? ???????????? ?????????
//  @Override
//  protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
//    //????????? ????????? ??????
//    //??????client??? ????????? ????????? ?????????????????? ????????? ?????? ??????
////    log.info(" ?????????.??????????????? ?????? ?????????");
//    log.info(msg.toString());
//  }
//  @Override
//  public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
//    log.info("?????? ??????");
//  }
//
//  @Override
//  public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
//    System.out.println("?????? ????????? ?????????.");
//  }
//
//
//  @Override
//  public void channelActive(ChannelHandlerContext ctx)throws Exception{
//    //?????? ???????????? ????????? ??????
////    ctx.writeAndFlush(Unpooled.copiedBuffer("??????client?????? message ?????????.\r\n", CharsetUtil.UTF_8));
//  }
//
//  @Override
//  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception{
//    cause.printStackTrace();
//    log.info("ERROR : Server Disconnected");
//    ctx.close();
//  }
//
//
//}
