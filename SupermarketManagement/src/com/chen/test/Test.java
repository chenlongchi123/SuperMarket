package com.chen.test;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


import java.security.MessageDigest;
public class Test {
  
  public void toMD5(String plainText) {
   try {
    //����ʵ��ָ��ժҪ�㷨�� MessageDigest ����
    MessageDigest md = MessageDigest.getInstance("MD5"); 
    //ʹ��ָ�����ֽ��������ժҪ��
    md.update(plainText.getBytes());
    //ͨ��ִ���������֮������ղ�����ɹ�ϣ���㡣
    byte b[] = md.digest();
    //���ɾ����md5���뵽buf����
    int i;
    StringBuffer buf = new StringBuffer("");
    for (int offset = 0; offset < b.length; offset++) {
     i = b[offset];
     if (i < 0)
      i += 256;
     if (i < 16)
      buf.append("0");
     buf.append(Integer.toHexString(i));
    }
    System.out.println("32λ: " + buf.toString());// 32λ�ļ���
    System.out.println("16λ: " + buf.toString().substring(8, 24));// 16λ�ļ��ܣ���ʵ����32λ���ܺ�Ľ�ȡ
   } 
   catch (Exception e) {
    e.printStackTrace();
   }
  }
  public static void main(String agrs[]) {
	    new Test().toMD5("12345678");//����LXD
	  }
}