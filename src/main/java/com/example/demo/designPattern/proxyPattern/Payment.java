package com.example.demo.designPattern.proxyPattern;

//
//public class Payment {
//
//    public static void main(String[] args) {
//        PaymentServiceImpl proxy = new PaymentServiceImpl();
//        System.out.println(proxy.payMoney());
//    }
//
//
//}
//
//interface PaymentService{
//    String payMoney();
//}
//class PaymentServiceImpl implements PaymentService{
//
//    @Override
//    public String payMoney() {
//        //some logic
//        String success = "SUCCESS PAYMENT";
//        return success;
//    }
//}
//class Proxy implements PaymentService{
//    PaymentServiceImpl impl;
//    @Override
//    public String payMoney() {
//        System.out.println("호출에 대한 흐름 제어가 주 목적이며, 반환 결과를 그대로 전달");
//        impl = new PaymentServiceImpl();
//        return impl.payMoney();
//    }
//}