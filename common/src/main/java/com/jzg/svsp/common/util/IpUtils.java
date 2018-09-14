package com.jzg.svsp.common.util;

public class IpUtils {

    public static void main(String[] args) {

        IpUtils obj = new IpUtils();

        System.out.println("iptoLong  : " + obj.ipToLong("192.168.1.2"));

        System.out.println("longToIp  : " + obj.longToIp(3232237260L));

    }

    // example : 192.168.1.2
    public static long ipToLong(String ipAddress) {
        String[] ipAddressInArray = ipAddress.split("\\.");
        long result = 0;
        for (int i = 0; i < ipAddressInArray.length; i++) {
            int power = 3 - i;
            int ip = Integer.parseInt(ipAddressInArray[i]);

            result += ip * Math.pow(256, power);

        }
        return result;
    }


    public static String longToIp(long i) {
        return ((i >> 24) & 0xFF) +
                "." + ((i >> 16) & 0xFF) +
                "." + ((i >> 8) & 0xFF) +
                "." + (i & 0xFF);

    }


}
