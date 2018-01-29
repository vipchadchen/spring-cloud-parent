/*
 * Copyright (C) 2011 Fhpt All Rights Reserved.
 * 
 * yuxin
 */
package opst.we.util;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * [文件名称]<br>
 * StringUtil <br>
 * <br>
 * [文件描述]<br>
 * 内容摘要.<br>
 * <br>
 * [修改记录]<br>
 * 
 * @author KYLE
 * @version 1.00
 */
public class StringUtils {

	/**
	 * 隐藏构造函数
	 */
	private StringUtils() {

	}

	/**
	 * String null-->""
	 * 
	 * @param value
	 *            传入的字符串
	 * @return String null-->""
	 */
	public static String nvl(String value) {
		if (value == null) {
			return "";
		} else {
			return value.trim();
		}
	}

	// /**
	// * 汉字转换位汉语拼音首字母，英文字符不变
	// *
	// * @param chines
	// * 汉字
	// * @return 拼音
	// */
	// public static String converterToFirstSpell(String chines) {
	// String pinyinName = "";
	// char[] nameChar = chines.toCharArray();
	// HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
	// defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
	// defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
	// for (int i = 0; i < nameChar.length; i++) {
	// if (nameChar[i] > 128) {
	// try {
	// String[] cs = PinyinHelper.toHanyuPinyinStringArray(nameChar[i],
	// defaultFormat);
	// if (cs != null) {
	// pinyinName += cs[0].charAt(0);
	// }
	// } catch (BadHanyuPinyinOutputFormatCombination e) {
	// e.printStackTrace();
	// }
	// } else {
	// pinyinName += nameChar[i];
	// }
	// }
	// return pinyinName;
	// }

	/**
	 * @param value
	 *            字符串
	 * @return String ""-->null
	 * 
	 */
	public static String nvlNull(String value) {
		if (value == null || "".equals(value.trim())) {
			return null;
		} else {
			return value.trim();
		}
	}

	/**
	 * 两个字符串比较
	 * 
	 * @param s1
	 *            字符串1
	 * @param s2
	 *            字符串2
	 * @return 如果两个字符串相同返回true，否则返回false
	 * 
	 */
	public static boolean isEqual(String s1, String s2) {
		if (s1 == null && s2 == null) {
			// 两个字符串都是null，返回true
			return true;
		}
		if (s1 == null) {
			return false;
		}
		if (s2 == null) {
			return false;
		}
		return s1.equals(s2);
	}

	/**
	 * 判断字符串是否为null或者空串
	 * 
	 * @param value
	 *            传入的字符串
	 * @return 如果为null或者空串，返回true，否则返回false
	 */
	public static boolean isEmpty(String value) {
		if (value == null || "".equals(value.trim())) {
			return true;
		} else {
			return false;
		}
	}

	public static String getStringHashCode(String str) {
		int machineId = 1;//最大支持1-9个集群机器部署
		int hashCodeV = str.hashCode();
		if(hashCodeV < 0) {//有可能是负数
			hashCodeV = - hashCodeV;
		}
		// 0 代表前面补充0
		// 15 代表长度为15
		// d 代表参数为正数型
		return  machineId+ String.format("%015d", hashCodeV);
	}

	/**
	 * 返回加密的银行账号作显示
	 * 
	 * @param memberBankAcct
	 * @return
	 */
	public static String getMemberBankAcctAlias(String memberBankAcct) {
		int l = memberBankAcct.length();
		return "********" + memberBankAcct.substring(l - 4);
	}

	/**
	 * 移除字符串
	 * 
	 * @param str
	 * @param regex
	 * @return
	 */
	public static String remove(String str, String regex) {
		return str.replace(regex, "");
	}

	/**
	 * 填充字符
	 * 
	 * @param str
	 * @param length
	 * @return
	 */
	public static String padLeft(String str, int length, char ch) {
		if (str.length() >= length) {
			return str;
		}
		int len = length - str.length();
		if (len <= 0) {
			return str;
		}
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < len; i++) {
			builder.append(ch);
		}
		builder.append(str);
		return builder.toString();
	}

	/**
	 * 右填充字符
	 * 
	 * @param str
	 * @param length
	 * @return
	 */
	public static String padRight(String str, int length, char ch) {
		if (str.length() >= length) {
			return str;
		}
		int len = length - str.length();
		if (len <= 0) {
			return str;
		}
		StringBuilder builder = new StringBuilder(str);
		for (int i = 0; i < len; i++) {
			builder.append(ch);
		}
		return builder.toString();
	}

	/**
	 * 首字母大写
	 * 
	 * @param str
	 * @return
	 */
	public static String capitalize(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	/**
	 * 首字母小写
	 * 
	 * @param str
	 * @return
	 */
	public static String uncapitalize(String str) {
		return str.substring(0, 1).toLowerCase() + str.substring(1);
	}

	public static String subStr(String str, int length) {
		if (!StringUtils.isEmpty(str)) {
			if (str.length() > length) {
				return str.substring(0, length) + "...";
			}
			return str;
		}
		return "";
	}

	/**
	 * 把一个数组转换成数据库参数，例如 new Integer[]{1,2,3} == 1,2,3
	 * 
	 * @param objs
	 * @param spilt
	 *            分隔符
	 * @param isString
	 * @return
	 */
	public static String toParams(Object[] objs, String spilt, boolean isString) {
		StringBuilder builder = new StringBuilder();
		if (isString) {
			for (int i = 0; i < objs.length; i++) {
				builder.append("'" + objs[i] + "'");
				if (i != objs.length - 1) {
					builder.append(spilt);
				}
			}
		} else {
			for (int i = 0; i < objs.length; i++) {
				builder.append(objs[i]);
				if (i != objs.length - 1) {
					builder.append(spilt);
				}
			}
		}
		return builder.toString();
	}

	/**
	 * 把一个数组转换成数据库参数，例如 new Integer[]{1,2,3} == 1,2,3
	 * 
	 * @param objs
	 * @param isString
	 * @return
	 */
	public static String toParams(Object[] objs, boolean isString) {
		return StringUtils.toParams(objs, ",", isString);
	}

	/**
	 * 把一个List转换成数据库参数，例如 new Integer[]{1,2,3} == 1,2,3
	 * 
	 * @param objs
	 * @param isString
	 * @return
	 */
	public static String toParams(List<?> objs, boolean isString) {
		return toParams(objs.toArray(), isString);
	}

	/**
	 * 解码 ISO-8859-1 -> UTF-8
	 * 
	 * @param str
	 *            str
	 * @return
	 */
	public static String urldecode(String str) {
		try {
			if (str != null && !str.trim().isEmpty()) {
				return new String(str.getBytes("ISO-8859-1"), "UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 截取字符串
	 * 
	 * @param str
	 * @param length
	 * @return
	 */
	public static String substr(String str, int length) {
		if (str != null && str.length() > length) {
			return str.substring(0, length);
		}
		return str;
	}

	/**
	 * 支持表达式${}
	 * 
	 * @param is
	 * @param args
	 * @return
	 * @throws IOException
	 */
	public static String parseString(InputStream is, Map<String, Object> args, boolean dVal) {
		try {
			if(is != null){
				return parseString(IOUtils.toString(is,"UTF-8"), args, dVal);
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 支持表达式${}
	 * 
	 * @param str
	 * @param args
	 * @return
	 * @throws IOException
	 */
	public static String parseString(String str, Map<String, Object> args, boolean dVal) {
		if (!StringUtils.isEmpty(str)) {
			String temp = str.replaceAll("<!--.[^-]*(?=-->)-->", "").replace("\r\n", "");
			for (String key : args.keySet()) {
				if (args.get(key) != null) {
					temp = temp.replace("${" + key + "}", args.get(key).toString());
				} else {
					if (dVal) {
						temp = temp.replace("${" + key + "}", "");
					} else {
						temp = temp.replaceAll("<" + key + ">(.*?)</" + key + ">", "");
					}
				}
			}
			return temp;
		}
		return "";
	}

	public static String parseString(String str, Map<String, Object> args) {
		return parseString(str, args, true);
	}
	
	public static String getRandom(int n) {
		Random rnd = new Random();
		String pass = "0";
		int x = rnd.nextInt(9);
		/** 过滤第一位为0 */
		while (x == 0) {
			x = rnd.nextInt(9);
		}
		pass = String.valueOf(x);
		for (int i = 1; i < n; i++) {
			pass = pass + String.valueOf(rnd.nextInt(9));
		}
		return pass;
	}
	
	public static String getRandomString(int pwd_len) {
		// 35是因为数组是从0开始的，26个字母+10个 数字
		int i; // 生成的随机数
		int count = 0; // 生成的密码的长度
		char[] str = { 'a','b', 'c', 'd', 'e', 'f',
				'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		final int maxNum = str.length;
		StringBuffer pwd = new StringBuffer("");
		Random r = new Random();
		while (count < pwd_len) {
			// 生成随机数，取绝对值，防止 生成负数，

			i = Math.abs(r.nextInt(maxNum)); // 生成的数最大为36-1

			if (i >= 0 && i < str.length) {
				pwd.append(str[i]);
				count++;
			}
		}
		return pwd.toString();
	}
	/**
	 * 全角转半角的 转换函数
	 * 
	 * @param QJstr
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static final String full2HalfChange(String QJstr) throws UnsupportedEncodingException {
		StringBuffer outStrBuf = new StringBuffer("");
		String Tstr = "";
		byte[] b = null;
		for (int i = 0; i < QJstr.length(); i++) {
			Tstr = QJstr.substring(i, i + 1);
			// 全角空格转换成半角空格
			if (Tstr.equals("　")) {
				outStrBuf.append(" ");
				continue;
			}
			b = Tstr.getBytes("unicode");
			// 得到 unicode 字节数据
			if (b[2] == -1) {
				// 表示全角？
				b[3] = (byte) (b[3] + 32);
				b[2] = 0;
				outStrBuf.append(new String(b, "unicode"));
			} else {
				outStrBuf.append(Tstr);
			}
		} // end for.
		return outStrBuf.toString();
	}

	/**
	 * 半角转全角
	 * 
	 * @param QJstr
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static final String half2Fullchange(String QJstr) throws UnsupportedEncodingException {
		StringBuffer outStrBuf = new StringBuffer("");
		String Tstr = "";
		byte[] b = null;
		for (int i = 0; i < QJstr.length(); i++) {
			Tstr = QJstr.substring(i, i + 1);
			if (Tstr.equals(" ")) {
				// 半角空格
				outStrBuf.append(Tstr);
				continue;
			}
			b = Tstr.getBytes("unicode");
			if (b[2] == 0) {
				// 半角?
				b[3] = (byte) (b[3] - 32);
				b[2] = -1;
				outStrBuf.append(new String(b, "unicode"));
			} else {
				outStrBuf.append(Tstr);
			}
		}
		return outStrBuf.toString();
	}
	public static String getSerialNo(int randomLenth){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return dateFormat.format(new Date())+ String.format("%0"+randomLenth+"d",(new Random().nextInt(999999)));
	}
}
