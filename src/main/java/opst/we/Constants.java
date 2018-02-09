package opst.we;

/**
 * @author: chgj
 * @description:
 * @date: create in 2017/11/13 16:18
 * @modified:
 */
public class Constants {

    //公用返回JOSN成功
    public static final String RESULT_JSON_0 = "0";
    //公用返回JOSN失败
    public static final String RESULT_JSON_1 = "1";

    public final static class Stzb {

    }

    /**
     * 返回字段
     */
    public static final String RESULT_CODE = "result_code";
    /**
     * 初始化URL
     */
    public static final String INIT_URL = "https://kyfw.12306.cn/otn/login/init";
    /**
     * 验证码URL
     */
    public static final String IMG_URL= "https://kyfw.12306.cn/passport/captcha/captcha-image?login_site=E&module=login&rand=sjrand&";
    /**
     * 校验验证码url
     */
    public static final String CHECK_CODE_URL = "https://kyfw.12306.cn/passport/captcha/captcha-check";
    /**
     * 登录URL
     */
    public static final String LOGIN_URL = "https://kyfw.12306.cn/passport/web/login";
    /**
     * 验证码校验成功标识
     */
    public static final String CHECK_CODE = "4";
    /**
     * 登录成功标识
     */
    public static final String LOGIN_CODE = "0";
    /**
     * 验证码路径
     */
    public static final String IMG_PATH = "C:\\workspace_git\\githubpj\\weclome\\target\\weclome\\res\\img\\12306.jpg";
    /**
     * 登录首页URL
     */
    public static final String SEND_URL = "https://kyfw.12306.cn/otn/index/initMy12306";
}
