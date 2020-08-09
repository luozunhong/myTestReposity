package com.gem.furniture.security;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101200672452";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCX7bFh97WWwwMNUdEYFPNyr+uuDKnD/X9rbv1Y36eGZUrUfcTt9kWQ40lfrDeaI4zPEM6sEXUs8thLe06nfMMHeZ4FoHqh3uvPhC+xwG1KZe/ZOTd9wMF9nx+SH3Z+V6+k7Hx61xRn+U34duwFhcYxizDh+kUWAV1BcGPOTAm9Fsl/gIe6SlEEmkkR8wDVXpa9ABxPXjlJWY1kpW+bPUTEPa9egRDLMaudDmnvPwbCGYpdswkTw8beOxkNJcRSMUeY6WRGtuV6CIGLF6xByKB3LGAx3FEexFsEwifUJiuA+jiy5gLf7RB8683eM4Vsh23YTtgxXILJ0wQ2xjMKfcSHAgMBAAECggEAWjL/VheX0ssyu6ywhCikJJn3RZ01CSwugx0hAqu+LRdkJuYIjfLheFTIkimP1U534dOrsBKpS6dd7OpnVx7GN2DoBZUyWXoc7FYhbtm8ySfeD0xd+qX++lMHjlxpoDb1C+hvOwsIjXZA6VvJYrn6Yh2uRuusKpVixWAxkSApw/2iL2DUAfVlzqaJaNuaeJ4RcTW2N9NAjsRoSKU+5t4QeazpZqz5q/7UMA5uV17v8u2ZM1LofTCnQ+33ZKHxMnDqLf3kVGnA0PXO7dHsNngXFFloH/Ind95WjWClPx9mFiINRuNeT1LGrMPcPUQwP2+ROi83+AYy7HMHaTBvnPQRKQKBgQDH8HKbEePU3xGF9waGOSVKozZT9tZta3zqCOaqvbG2DoXvhokvJnymlaYTaGi1AwiDvF2Rozvu5iQUbPp7amvj/WMPcMwNRV1TQAgRAtb0PYqLdwXdctCIm03m3GzALP7bP4Q19YsRm2HNW/Xg9AAxQBwp3MvxtSHKJClwYsm2lQKBgQDChw2+h9lezvqvW427jfnKvzAn9iUQAorlBw67aqRLQJ01FeyuT4hj1vIg/2CmdtwnDeTmYAdHMOHanKWZFH9YwjRyrZJUY2RQcxkRRaqO80L92V8BdXMSh9SFL1sdUzseBMHmDsRA0sVw1RYi0zvdW8oAN3TDJW5ExqqtXjTTqwKBgCqou9soOwMtQRDjPuoegT1mi23oyaF5AKLymTyu0p70hFEx1E1SGeB1J4UWjtioOAXbh99OA7iaM/KDugHhF/oCE0O1HmRqe1oK3G28vF5KTygokgDIwYOUF0/9kdqC/zGKYMwegriT/Y8SYujHRs87TYcFDCKbMgVuJ8VJ3p3tAoGAdDzxSI2ypQV3JHvHuHAA+FbANtDNmsB6MJrEAdeabuEgT01XjV02+bnCG1eecDoMGUYjJknxb2fVPaVnCo8F/YqmfnQbQVPW6H+uVfTUEvFncXqHW77L0SHbKu5+Ooq2g5yCJK9kM/v+QQsDXDHuzrn/fZulqMpgFrbD3C6z0FsCgYA2NDxK33PXZbOivvy9eFdQOGj2g9vrGTrKTv6lCEVId3vx8dE4LZVVkH/QngJYfEkxUSh6y/i7LABWWUfLma5bdzkMMG+IQMJK0qJRj2Wn3E3g2+RxmFaFbpNpPEORhq5gU5cvjnX2sxmmWT1dtznejav1AvH05OVTEYDzNzU77A==";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkgNSIkFC99IN1u1PpYu40w9GVYRpaUCchrrcFaAXNtgvrIjlcjHiq8h0f3o5TByvbuFQ7blyeHCTAVOLb6Z3tcOxcCERNIOGSVTwEvTP15CsFWjOOY9R5anS3lHJKDaZ0ThX50JycSAtSUb50GytI9Fd0nQMw3ppdjfbJ+REauk33TnWaexQs7Ogl85dSyfIFTPQt+uOQI9IfaXpIfbQ2jDN7NxjZzedPxWDZMUCOCRM3hseA8Otw9M8FvQQWeduzTptjysBRdMaCwb98umnFIPRg8dcX/ze4/jm8eOu+GT7pl8ZDdI8kNmJ0hbEqF3vjbj04ms8PEqCLPYYLZbIGwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8888/furniture/alipayNotifyNotice";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8888/furniture/alipayReturnNotice";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
