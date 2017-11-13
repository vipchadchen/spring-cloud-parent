package testcc;

import opst.we.util.TticketUtil;

import java.util.Scanner;

/**
 * @author: chgj
 * @description:
 * @date: create in 2017/11/13 13:03
 * @modified:
 */
public class HttpTest {
    public static void main(String[] args) {
        try {
            /**
             * 初始cookie
             */
            String responseText = TticketUtil.get("https://kyfw.12306.cn/otn/login/init");
            /**
             * 获取验证码,下载到本地
             */
            TticketUtil.getFile("https://kyfw.12306.cn/passport/captcha/captcha-image?login_site=E&module=login&rand=sjrand&" + Math.random());
            String vcode = new Scanner(System.in).next();
            System.out.println("您输入的验证码是:" + vcode + "  正在校验...");
            String checkcodeurl = "https://kyfw.12306.cn/passport/captcha/captcha-check";
            TticketUtil.post(checkcodeurl, "answer=" + vcode + "&login_site=E&" + "rand=sjrand");

            String loginurl = "https://kyfw.12306.cn/passport/web/login";
            TticketUtil.post(loginurl,"username=chgj121@163.com"+"&password=Cc2213574"+"&appid=otn");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
