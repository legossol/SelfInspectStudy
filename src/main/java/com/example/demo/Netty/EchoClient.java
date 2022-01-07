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
//    serverChannel.writeAndFlush("[Notify To Server] 해당 유저가 채팅방을 나갔습니다.");
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
////여러 채널에서 이 핸들러의 공유가 가능하게 하는 에노테이션
//@Sharable
//class EchoClientHandler extends SimpleChannelInboundHandler {
//  private String receiveMsg;
//  public String getReceiveMsg(){
//    return this.receiveMsg;
//  }
//  //서버에서 메시지를 수신하면 호출됨
//  @Override
//  protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
//    //수신한 메시지 로깅
//    //다른client가 메시지 보내면 클라이언트가 받는지 확인 완료
////    log.info(" 메시지.서버로부터 받은 메시지");
//    log.info(msg.toString());
//  }
//  @Override
//  public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
//    log.info("채널 등록");
//  }
//
//  @Override
//  public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
//    System.out.println("채널 연결이 종료됨.");
//  }
//
//
//  @Override
//  public void channelActive(ChannelHandlerContext ctx)throws Exception{
//    //채널 활성화시 메세지 전송
////    ctx.writeAndFlush(Unpooled.copiedBuffer("다른client에게 message 보낸다.\r\n", CharsetUtil.UTF_8));
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
