package com.zhgs.tools;

import com.alibaba.fastjson.JSONObject;

/**
 * @Desc: 个性算法 http://www.360doc.com/content/19/1216/16/28554979_880124150.shtml
 * @Author: zhouguangsheng
 * @Date: create by 2020/11/23 10:53
 * @Modify By:
 */
public class Gscalc {
    // 地区：基数、社保比例、公积金比例、社保最高、公积金最高
    private String config =  "{\"nanjing\":{\n" +
            "        \"baseGz\":10000,\n" +
            "        \"shebaoRate\":0.105,\n" +
            "        \"gjjRate\":0.08,\n" +
            "        \"shebaoMax\":19335.00,\n" +
            "        \"gjjMax\":31200.00\n" +
            "    },\"beijing\":{\n" +
            "        \"baseGz\":10000,\n" +
            "        \"shebaoRate\":0.105,\n" +
            "        \"gjjRate\":0.08,\n" +
            "        \"shebaoMax\":26541.00,\n" +
            "        \"gjjMax\":31200.00\n" +
            "    }}";
    private int[] gzArr = {1,2,3,4,5,6,7,8,9,10,11,12};


    public String calc(){
        JSONObject object = JSONObject.parseObject(config);
        JSONObject nanjing = object.getJSONObject("nanjing");

        double shebaoMax = nanjing.getDoubleValue("shebaoMax");
        double gjjMax = nanjing.getDoubleValue("gjjMax");
        double shebaoRate = nanjing.getDoubleValue("shebaoRate");
        double gjjRate = nanjing.getDoubleValue("gjjRate");

        double leijiGz = 0;
        for (int gz : gzArr) {
            leijiGz = leijiGz + gz;
            double shebao = gz>=shebaoMax ? shebaoMax *shebaoRate : gz * shebaoRate;
            double gjj = gz>=gjjMax ? gjjMax * gjjRate: gz * gjjRate;
            double yjse = gz - 5000 - shebao - gjj;
            double sjse = 0;
            if(leijiGz < 36000){
                sjse = yjse * 0.03 - 0;
            } else if(leijiGz > 36000 && leijiGz < 36000){
                sjse = yjse * 0.03 - 0;
            } else

        }




    }

    public static void main(String[] args) {



    }





}
