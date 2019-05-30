package com.kumo.payplugin.paymethod;
import android.app.Notification;
import com.kumo.payplugin.common.IDoPost;
import java.util.Map;
import java.util.HashMap;
/**
 * 支付宝通知
 */
public class AlipayNotificationHandle extends NotificationHandle {

        public AlipayNotificationHandle(String pkgtype,Notification notification,IDoPost postpush){
                super(pkgtype,notification,postpush);
        }

        public void handleNotification(){
                if(title.contains("支付宝")){
                        if(content.contains("成功收款") | content.contains("向你付款")){
                                Map<String,String> postmap=new HashMap<String,String>();
                                postmap.put("type","alipay");
                                postmap.put("time",notitime);
                                postmap.put("title","支付宝支付");
                                postmap.put("money",extractMoney(content));
                                postmap.put("content",content);
                                postpush.doPost(postmap);
                                return ;
                        }
                }
        }
}
