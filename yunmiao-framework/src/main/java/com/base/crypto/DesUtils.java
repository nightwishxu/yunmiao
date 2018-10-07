package com.base.crypto;

import com.base.lang.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.IOException;
import java.security.SecureRandom;

public class DesUtils {

    public final static String DES = "DES";
    private static final String KEY = "glavesoft!@#$";
    private static final byte[] iv1 = new byte[]{1, 2, 3, 4, 5, 6, 7, 8};

    /**
     * Description 根据键值进行加密
     *
     * @param data
     * @param key
     * 加密键byte数组
     * @return
     * @throws Exception
     */
    public static String encrypt(String data){
        return encrypt(data,KEY);
    }

    /**
     * Description 根据键值进行加密
     *
     * @param data
     * @param key
     * 加密键byte数组
     * @return
     * @throws Exception
     */
    public static String encrypt(String data, String key){
        byte[] bt = new byte[0];
        try {
            bt = encrypt(data.getBytes(), key.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Base64.encode(bt);
    }

    /**
     * Description 根据键值进行解密
     *
     * @param data
     * @param key
     * 加密键byte数组
     * @return
     * @throws IOException
     * @throws Exception
     */
    public static String decrypt(String data){
        try {
            return decrypt(data,KEY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Description 根据键值进行解密
     *
     * @param data
     * @param key
     * 加密键byte数组
     * @return
     * @throws IOException
     * @throws Exception
     */
    public static String decrypt(String data, String key) throws IOException, Exception {
        if (data == null)
            return null;
        byte[] buf = Base64.decode(data);
        byte[] bt = decrypt(buf, key.getBytes());
        return new String(bt);
    }

    /**
     * Description 根据键值进行加密
     *
     * @param data
     * @param key
     * 加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec(iv1);
        // 用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, iv);

        return cipher.doFinal(data);
    }

    /**
     * Description 根据键值进行解密
     *
     * @param data
     * @param key
     * 加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec(iv1);
        // 用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, iv);

        return cipher.doFinal(data);
    }
}
