package com.grp.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2019/10/20 0020.
 */
public class MD5Util {
    public static final String DIGEST_MD5 = "MD5";
    public static final String DIGEST_SHA = "SHA";

    public static String md5(String digest, String key, String value) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(digest);
        md.update((key + value).getBytes());
        String digest_ = new BigInteger(1, md.digest()).toString(16);
        return digest_;
    }
}
