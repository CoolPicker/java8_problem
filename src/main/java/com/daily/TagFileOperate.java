package com.daily;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.*;

/**
 * @Description 图片标签数据规整
 * @Author nya
 * @Date 2020/5/12 下午3:45
 **/
public class TagFileOperate {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("/home/lab/tag.txt"));
        Map<String,Integer> map = new TreeMap<>();
        final Long[] count = {0l};

        reader.lines().forEach(each -> {
            String[] tags = each.split(",");
            for (String tag :
                    tags) {
                if (map.containsKey(tag)) {
                    map.put(tag,map.get(tag) + 1);
                } else {
                    if (StringUtils.isNotBlank(StringUtils.strip(tag)) && isChinese(tag)) {
                        map.put(tag,1);
                        count[0] = count[0] + 1;
                        System.out.println(count[0]);
                    }
                }
            }
        });


        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>((Collection<? extends Map.Entry<String, Integer>>) map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                Integer v2 = o2.getValue();
                Integer v1 = o1.getValue();
                return v2 - v1;
            }
        });

        BufferedWriter bw = new BufferedWriter(new FileWriter("/home/lab/tag_count.txt"));
        for(Map.Entry<String,Integer> mapping:list){
            bw.write(mapping.getKey());
            bw.write("\t");
            bw.write(mapping.getValue().toString());
            bw.newLine();
            bw.flush();
            count[0] = count[0] - 1;
            System.out.println(count[0]);
        }
//        map.keySet().stream().forEach(e -> {
//            try {
//                bw.write(e);
//                bw.write("\t");
//                bw.write(map.get(e).toString());
//                bw.newLine();
//                bw.flush();
//                count[0] = count[0] - 1;
//                System.out.println(count[0]);
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        });
        reader.close();
        bw.close();
    }

    // 根据Unicode编码完美的判断中文汉字和符号
    private static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
            return true;
        }
        return false;
    }

    // 完整的判断中文汉字和符号
    public static boolean isChinese(String strName) {
        char[] ch = strName.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (isChinese(c)) {
                return true;
            }
        }
        return false;
    }

    private class Tag {
        private String tag;
        private Integer count;

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }
    }

}
