package com.test.demo.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test {

//    public static void main(String[] args) {
//        try {
//            String command = "dir";
//            // 构建ProcessBuilder对象
//            ProcessBuilder processBuilder = new ProcessBuilder();
//            // 设置Linux命令
////            processBuilder.command("bash", "-c", command);
//            processBuilder.command("cmd","/C", command);
//            // 开始执行命令
//            Process process = processBuilder.start();
//            // 读取Linux命令执行的结果
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            StringBuilder stringBuilder = new StringBuilder();
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                stringBuilder.append(line).append("\n");
//            }
//            // 关闭流
//            bufferedReader.close();
//            // 返回Linux命令执行的结果
//            System.out.println(stringBuilder.toString());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

//    public static void main(String[] args) {
//        String convert = convert("}\\n{");
//        System.out.println(convert);
//    }

    public static void main(String[] args) {
        if (true == false){
            // Test Method Escape
            // \u000d\u007d\u000d\u007b\u000d
            System.out.println("哈哈");
        }
    }

    public static String convert(String str)
    {
        str = (str == null ? "" : str);
        String tmp;
        StringBuffer sb = new StringBuffer(1000);
        char c;
        int i, j;
        sb.setLength(0);
        for (i = 0; i < str.length(); i++)
        {
            c = str.charAt(i);
            sb.append("\\u");
            j = (c >>>8); //取出高8位
            tmp = Integer.toHexString(j);
            if (tmp.length() == 1)
                sb.append("0");
            sb.append(tmp);
            j = (c & 0xFF); //取出低8位
            tmp = Integer.toHexString(j);
            if (tmp.length() == 1)
                sb.append("0");
            sb.append(tmp);

        }
        return (new String(sb));
    }

}
