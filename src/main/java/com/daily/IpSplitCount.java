package com.daily;

import com.ip2region.DataBlock;
import com.ip2region.DbConfig;
import com.ip2region.DbSearcher;
import com.ip2region.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author nya
 * @Date 2020/4/17 上午10:19
 **/
public class IpSplitCount {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new FileReader("/home/lab/IP.txt"));
        Map<String,Integer> map = new HashMap<>();

        reader.lines().forEach(each -> {
            String[] ips = each.split("IP");
            String ip = ips[1].trim().replace("[","").replace("]","");
            if (map.containsKey(ip)) {
                map.put(ip,map.get(ip) + 1);
            } else {
                map.put(ip,1);
            }
        });
        System.out.println(map);
        map.keySet().forEach(item -> {
            System.out.println(item + " - "+ map.get(item) + " - " + getCityInfo(item));
        });

    }

    private static String getCityInfo(String ip) {
        File file = new File("/home/lab/git_0/ip2region-1.3-release/data/ip2region.db");

        int algorithm = DbSearcher.BTREE_ALGORITHM;

        try {
            DbConfig config = new DbConfig();
            DbSearcher searcher = new DbSearcher(config,"/home/lab/git_0/ip2region-1.3-release/data/ip2region.db");

            Method method = null;
            switch ( algorithm )
            {
                case DbSearcher.BTREE_ALGORITHM:
                    method = searcher.getClass().getMethod("btreeSearch", String.class);
                    break;
                case DbSearcher.BINARY_ALGORITHM:
                    method = searcher.getClass().getMethod("binarySearch", String.class);
                    break;
                case DbSearcher.MEMORY_ALGORITYM:
                    method = searcher.getClass().getMethod("memorySearch", String.class);
                    break;
            }

            DataBlock dataBlock = null;
            if (!Util.isIpAddress(ip)) {
                System.out.println("Error: Invalid ip address");
            }

            dataBlock = (DataBlock) method.invoke(searcher,ip);
            return dataBlock.getRegion();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
