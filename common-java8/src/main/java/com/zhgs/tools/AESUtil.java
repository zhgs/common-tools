package com.zgs.com.zgs.tools;


import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.PropertyNamingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: 加密解密
 * @Author: sunjian
 * @Date: 2019/3/23
 */
public final class AESUtil {

    private static Logger logger = LoggerFactory.getLogger(AESUtil.class);
    private static SecretKeySpec skey;

    static {
        try {
            skey = new SecretKeySpec("DAL100@tuniu.COM".getBytes("UTF-8"), "AES");
        } catch (UnsupportedEncodingException e) {
            logger.warn("ciphe get instance error,error:{}", e);
        }
    }

    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * 加密
     */
    private static Cipher encryptCipher = null;

    /**
     * 解密
     */
    private static Cipher decryptCipher = null;


    private static Pattern pattern = Pattern.compile("[0-9]*");

    static {
        try {
            //加密算法初始化
            encryptCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");// NOSONAR
            encryptCipher.init(Cipher.ENCRYPT_MODE, skey);

            //解密算法初始化
            decryptCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");// NOSONAR
            decryptCipher.init(Cipher.DECRYPT_MODE, skey);
        } catch (Exception e) {
            logger.error("ciphe get instance error,error:{}", e);
        }
        // 反序列化遇到bean 中没有的属性时跳过,不抛出异常
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
    }

    public static String aesEncrypt(String data) {
        if (null == data) {
            return null;
        }
        try {
            return bytes2Hex(encryptCipher.doFinal(data.getBytes("utf-8")));
        } catch (Exception e) {
            return null;
        }
    }

    public static String bytes2Hex(byte[] data) {
        StringBuffer buffer = new StringBuffer();
        String hexData = null;
        for (int i = 0; i < data.length; i++) {
            hexData = (Integer.toHexString(data[i] & 0XFF));
            if (hexData.length() < 2) {
                buffer.append("0").append(hexData);
            } else {
                buffer.append(hexData);
            }
        }

        return buffer.toString();
    }

    public static byte[] hex2Bytes(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        }

        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    public static String aesDecrypt(String data) {
        if (null == data) {
            return null;
        }
        try {
            byte content[] = hex2Bytes(data);
            byte[] result = decryptCipher.doFinal(content);
            return new String(result, "utf-8");
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 解析入参获取想要的字段value
     *
     * @param jsonStr
     * @return Long类型
     */
    public static Long analyRequestDeserialize(String jsonStr, String key) {
        String res = null;
        if (!StringUtils.isBlank(jsonStr)) {
            try {
                JsonNode rootNode = mapper.readTree(jsonStr);
                List<String> resList = rootNode.findValuesAsText(key);
                if (!CollectionUtils.isEmpty(resList) && resList.size() >= 1) {
                    res = resList.get(0);
                }
            } catch (Exception e) {
                logger.warn("interSerial: can't parse {} from request or response json,original json:{},error:{}", key, jsonStr, e);
            }
        }
        return toLong(res, "0");
    }

    /**
     * 解析入参获取想要的字段value
     *
     * @param jsonStr
     * @return Long类型
     */
    public static String analyRequestDeserializeToString(String jsonStr, String key) {
        String res = null;
        if (!StringUtils.isBlank(jsonStr)) {
            try {
                JsonNode rootNode = mapper.readTree(jsonStr);
                List<String> resList = rootNode.findValuesAsText(key);
                if (!CollectionUtils.isEmpty(resList) && resList.size() >= 1) {
                    res = resList.get(0);
                }
            } catch (Exception e) {
                logger.warn("interSerial: can't parse {} from request or response json,original json:{},error:{}", key, jsonStr, e);
            }
        }
        return res;
    }

    /**
     * 字符传转成整型
     *
     * @param str
     * @param defaultValue
     * @return
     */
    public static Long toLong(String str, String defaultValue) {
        if (isNumeric(str)) {
            return Long.valueOf(str);
        }
        return Long.valueOf(defaultValue);
    }

    /**
     * 判断整数型字符串
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        if (str == null || "".equals(str.trim())) {
            return false;
        }

        Matcher isNum = pattern.matcher(str);
        return isNum.matches();
    }

    public static void main(String[] args) {
	    String tel = "139139237500000999";

        System.out.println(aesEncrypt(tel).length());
        System.out.println(aesDecrypt(aesEncrypt(tel)));

	    long t1 = System.currentTimeMillis();
	    for (int a=0;a<10000;a++) {

            aesEncrypt(tel);
            aesDecrypt(aesEncrypt(tel));
        }
        System.out.println(System.currentTimeMillis()-t1);
    }
}
