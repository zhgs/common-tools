package com.common.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @Desc:
 * @Author: zhouguangsheng
 * @Date: create by 2020/6/23 17:01
 * @Modify By:
 */
@Service
public class ProducterTest {

    @Resource
    private KafkaTemplate kafkaTemplate;

    private static int num = 12;
    private static int productId = 113;
    private static String month = "202008";
    private static String day = "20200826";
    private static String corpId = "84";


    public void process(){
        List<String> days = Arrays.asList("20200826","20200827","20200828","20200829","20200830","20200831","20200901");
        days.forEach(d -> {
            day = d;
            month = d.substring(0,6);
            System.out.println(month);
//            view();
            share();
//            takeover();
        });
//        for (int i = 0; i < 100; i++) {
//            bot("callcallcallcallcallcallcallcall"+i);
//        }
    }

    public void view() {
        int week = 36;
        for (int i = 0; i < num; i++) {
            String json = "{\n" +
                    "            \"biz_stamp\": \"1598505231564\",\n" +
                    "            \"corp_id\": \""+corpId+"\",\n" +
                    "            \"product_id\": \""+productId+"\",\n" +
                    "            \"username\": \"18751919737\",\n" +
                    "            \"invitation_code\": \"KDJLFA3\",\n" +
                    "            \"open_id\": \"dsfjaslfjewrwr32324324"+i+"\",\n" +
                    "            \"nickname\": \"浏览a" + i + "\",\n" +
                    "            \"year\": \"2020\",\n" +
                    "            \"month\": \""+month+"\",\n" +
                    "            \"day\": \""+day+"\",\n" +
                    "            \"week\": "+ week-- +"\n" +
                    "        }";
            kafkaTemplate.send("ss-view-record-dev", json);
        }
    }

    public void share() {
        int week = 36;
        for (int i = 0; i < num; i++) {
            String json = "{\n" +
                    "            \"biz_stamp\": \"1598505231564\",\n" +
                    "            \"corp_id\": \""+corpId+"\",\n" +
                    "            \"product_id\": \""+productId+"\",\n" +
                    "            \"username\": \"18751919737\",\n" +
                    "            \"invitation_code\": \"KDJLFA3\",\n" +
                    "            \"open_id\": \"dsfjaslfjewrwr32324324"+i+"\",\n" +
                    "            \"nickname\": \"分享a" + i + "\",\n" +
                    "            \"year\": \"2020\",\n" +
                    "            \"month\": \""+month+"\",\n" +
                    "            \"day\": \""+day+"\",\n" +
                    "            \"week\": "+ week-- +"\n" +
                    "        }";
            kafkaTemplate.send("ss-share-record-local", json);
        }
    }

    public void takeover() {
        int week = 36;
        for (int i = 0; i < num; i++) {
            String json = "{\n" +
                    "            \"biz_stamp\": \"1598505231564\",\n" +
                    "            \"corp_id\": \""+corpId+"\",\n" +
                    "            \"product_id\": \""+productId+"\",\n" +
                    "            \"username\": \"zhou\",\n" +
                    "            \"invitation_code\": \"KDJLFA3\",\n" +
                    "            \"open_id\": \"dsfjaslfjewrwr32324324"+i+"\",\n" +
                    "            \"nickname\": \"接管a" + i + "\",\n" +
                    "            \"year\": \"2020\",\n" +
                    "            \"month\": \""+month+"\",\n" +
                    "            \"day\": \""+day+"\",\n" +
                    "            \"week\": "+ week-- +"\n" +
                    "        }";
            kafkaTemplate.send("ss-takeover-record-dev", json);
        }
    }

    public void bot(String callUUid) {

            kafkaTemplate.send("bot-interact-dev", "{\n" +
                    "   \"kb_answer_strategy\": \"order\",\n" +
                    "   \"type\": \"Say\",\n" +
                    "   \"intelligence_match_after_play\": 0,\n" +
                    "   \"sum_mark\": 1,\n" +
                    "   \"intelligence_match\": 0,\n" +
                    "   \"number\": 22,\n" +
                    "   \"kb_id\": \"\",\n" +
                    "   \"event_type\": \"bot-cmd\",\n" +
                    "   \"sms\": \"\",\n" +
                    "   \"ignore\": 0,\n" +
                    "   \"if_intelligence_match\": 1,\n" +
                    "   \"dnis\": \"vx-publish\",\n" +
                    "   \"command_time\": 1598081430680,\n" +
                    "   \"calluuid\": \""+callUUid+"\",\n" +
                    "   \"section_types\": [\n" +
                    "      \"custom\",\n" +
                    "      \"text\"\n" +
                    "   ],\n" +
                    "   \"ani\": \"wx210d4a90472848d292bc0a5e18f1a8\",\n" +
                    "   \"cmd_id\": \"a3d1c694-9e8d-440c-a483-5764f40464dd\",\n" +
                    "   \"key\": \"7D0F6A977729607F4ED8E4E465E92575_22\",\n" +
                    "   \"node_skip\": 0,\n" +
                    "   \"timestamp\": 1598081430680,\n" +
                    "   \"intelligence_break_max_word_count\": 1000,\n" +
                    "   \"interface_code\": \"\",\n" +
                    "   \"node_name\": \"人群\",\n" +
                    "   \"intelligence_break_last_no_input_timeout\": 1,\n" +
                    "   \"sections\": [\n" +
                    "      \"live-push://smts?/vse/common/613739388186271744.flv?background=613728307975954432.flv\",\n" +
                    "      \"无论你是企业家、创业者还是公司高管；甚至是初入职场的小白，都能从中获得最具指导意义的帮助，\"\n" +
                    "   ],\n" +
                    "   \"intention\": \"\",\n" +
                    "   \"none_answer\": false,\n" +
                    "   \"if_ignore\": 0,\n" +
                    "   \"previous_match_words\": \"适合,人\",\n" +
                    "   \"event_id\": \"a3d1c694-9e8d-440c-a483-5764f40464dd\",\n" +
                    "   \"img_url\": \"\",\n" +
                    "   \"node_start_time\": 1598081430678,\n" +
                    "   \"intelligence_break_min_word_count\": 0,\n" +
                    "   \"event_name\": \"Say\",\n" +
                    "   \"sections_description\": \"live-push://smts?/vse/common/613739388186271744.flv?background=613728307975954432.flv无论你是企业家、创业者还是公司高管；甚至是初入职场的小白，都能从中获得最具指导意义的帮助，\",\n" +
                    "   \"biz_id\": \"746418743894216704\",\n" +
                    "   \"corp_id\": \"84\",\n" +
                    "   \"if_say\": \"1\",\n" +
                    "   \"say_number\": 1,\n" +
                    "   \"node_id\": \"opt_1200c10f-4707-43b7-be92-db26339de6c2\",\n" +
                    "   \"status\": \"AfterOperate\"\n" +
                    "}");
    }
}
