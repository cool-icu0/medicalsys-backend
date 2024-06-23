//package com.example.medicalsysbackend.listener;
//
//import javax.servlet.ServletRequestEvent;
//import javax.servlet.ServletRequestListener;
//import javax.servlet.annotation.WebListener;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//@WebListener
//  public class RequestListener implements ServletRequestListener {
//
//      public void requestInitialized(ServletRequestEvent sre)  {
//          System.out.println("我是监听器");
//          //将所有request请求都携带上httpSession
//          ((HttpServletRequest) sre.getServletRequest()).getSession();
//          HttpSession session = ((HttpServletRequest) sre.getServletRequest()).getSession();
//          System.out.println(session.getId());
//      }
//      public RequestListener() {
//         // TODO Auto-generated constructor stub
//     }
//
//     public void requestDestroyed(ServletRequestEvent arg0)  {
//         // TODO Auto-generated method stub
//     }
//}
//
