package com.tq.udf.person;

/**
 * @author tq
 * 浙江只精确到地级市，其它地区精确到省/直辖市
 */

import org.apache.hadoop.hive.ql.exec.UDF;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import java.util.Map;


public class GetArea extends UDF {

    private static Map<String, String> fTM() {
        Map<String, String> map = new HashMap();
  /*      File file = new File("src/map");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                String[] strArray = tempString.split(":");
                //   System.out.println(tempString);
                map.put(strArray[0], strArray[1]);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        map.put("上城","浙江_杭州市");
        map.put("下城","浙江_杭州市");
        map.put("江干","浙江_杭州市");
        map.put("拱墅","浙江_杭州市");
        map.put("西湖","浙江_杭州市");
        map.put("滨江","浙江_杭州市");
        map.put("萧山","浙江_杭州市");
        map.put("余杭","浙江_杭州市");
        map.put("富阳","浙江_杭州市");
        map.put("良渚","浙江_杭州市");
        map.put("杭州","浙江_杭州市");
        map.put("桐庐","浙江_杭州市");
        map.put("淳安","浙江_杭州市");
        map.put("临安","浙江_杭州市");
        map.put("景宁","浙江_丽水市");
        map.put("龙泉","浙江_丽水市");
        map.put("丽水","浙江_丽水市");
        map.put("青田","浙江_丽水市");
        map.put("云和","浙江_丽水市");
        map.put("庆元","浙江_丽水市");
        map.put("缙云","浙江_丽水市");
        map.put("遂昌","浙江_丽水市");
        map.put("松阳","浙江_丽水市");
        map.put("莲都","浙江_丽水市");
        map.put("台州","浙江_台州市");
        map.put("临海","浙江_台州市");
        map.put("温岭","浙江_台州市");
        map.put("仙居","浙江_台州市");
        map.put("天台","浙江_台州市");
        map.put("三门","浙江_台州市");
        map.put("玉环","浙江_台州市");
        map.put("安吉","浙江_湖州市");
        map.put("湖州","浙江_湖州市");
        map.put("德清","浙江_湖州市");
        map.put("长兴","浙江_湖州市");
        map.put("上虞","浙江_绍兴市");
        map.put("嵊州","浙江_绍兴市");
        map.put("新昌","浙江_绍兴市");
        map.put("诸暨","浙江_绍兴市");
        map.put("绍兴","浙江_绍兴市");
        map.put("金华","浙江_金华市");
        map.put("永康","浙江_金华市");
        map.put("武义","浙江_金华市");
        map.put("东阳","浙江_金华市");
        map.put("磐安","浙江_金华市");
        map.put("浦江","浙江_金华市");
        map.put("义乌","浙江_金华市");
        map.put("兰溪","浙江_金华市");
        map.put("江山","浙江_衢州市");
        map.put("衢州","浙江_衢州市");
        map.put("开化","浙江_衢州市");
        map.put("常山","浙江_衢州市");
        map.put("龙游","浙江_衢州市");
        map.put("舟山","浙江_舟山市");
        map.put("岱山","浙江_舟山市");
        map.put("嵊泗","浙江_舟山市");
        map.put("嘉兴","浙江_嘉兴市");
        map.put("嘉善","浙江_嘉兴市");
        map.put("平湖","浙江_嘉兴市");
        map.put("海盐","浙江_嘉兴市");
        map.put("桐乡","浙江_嘉兴市");
        map.put("海宁","浙江_嘉兴市");
        map.put("宁波","浙江_宁波市");
        map.put("象山","浙江_宁波市");
        map.put("宁海","浙江_宁波市");
        map.put("慈溪","浙江_宁波市");
        map.put("余姚","浙江_宁波市");
        map.put("乐清","浙江_温州市");
        map.put("瑞安","浙江_温州市");
        map.put("永嘉","浙江_温州市");
        map.put("平阳","浙江_温州市");
        map.put("苍南","浙江_温州市");
        map.put("文成","浙江_温州市");
        map.put("泰顺","浙江_温州市");
        map.put("河南","河南");
        map.put("重庆","重庆");
        map.put("山东","山东");
        map.put("内蒙古","内蒙古");
        map.put("山西","山西");
        map.put("陕西","陕西");
        map.put("上海","上海");
        map.put("四川","四川");
        map.put("天津","天津");
        map.put("西藏","西藏");
        map.put("云南","云南");
        map.put("浙江","浙江");
        map.put("黑龙江","黑龙江");
        map.put("湖北","湖北");
        map.put("湖南","湖南");
        map.put("江苏","江苏");
        map.put("江西","江西");
        map.put("辽宁","辽宁");
        map.put("新疆","新疆");
        map.put("宁夏","宁夏");
        map.put("青海","青海");
        map.put("安庆","安徽");
        map.put("蚌埠","安徽");
        map.put("亳州","安徽");
        map.put("巢湖","安徽");
        map.put("池州","安徽");
        map.put("滁州","安徽");
        map.put("阜阳","安徽");
        map.put("合肥","安徽");
        map.put("淮北","安徽");
        map.put("淮南","安徽");
        map.put("黄山","安徽");
        map.put("六安","安徽");
        map.put("马鞍山","安徽");
        map.put("宿州","安徽");
        map.put("铜陵","安徽");
        map.put("芜湖","安徽");
        map.put("宣城","安徽");
        map.put("北京","北京");
        map.put("福州","福建");
        map.put("龙岩","福建");
        map.put("南平","福建");
        map.put("宁德","福建");
        map.put("莆田","福建");
        map.put("泉州","福建");
        map.put("三明","福建");
        map.put("厦门","福建");
        map.put("漳州","福建");
        map.put("白银","甘肃");
        map.put("定西","甘肃");
        map.put("甘南藏族自治州","甘肃");
        map.put("嘉峪关","甘肃");
        map.put("金昌","甘肃");
        map.put("酒泉","甘肃");
        map.put("兰州","甘肃");
        map.put("临夏回族自治州","甘肃");
        map.put("陇南","甘肃");
        map.put("平凉","甘肃");
        map.put("庆阳","甘肃");
        map.put("天水","甘肃");
        map.put("武威","甘肃");
        map.put("张掖","甘肃");
        map.put("甘南","甘肃");
        map.put("临夏","甘肃");
        map.put("潮州","广东");
        map.put("东莞","广东");
        map.put("佛山","广东");
        map.put("广州","广东");
        map.put("河源","广东");
        map.put("惠州","广东");
        map.put("江门","广东");
        map.put("揭阳","广东");
        map.put("茂名","广东");
        map.put("梅州","广东");
        map.put("清远","广东");
        map.put("汕头","广东");
        map.put("汕尾","广东");
        map.put("韶关","广东");
        map.put("深圳","广东");
        map.put("阳江","广东");
        map.put("云浮","广东");
        map.put("湛江","广东");
        map.put("肇庆","广东");
        map.put("中山","广东");
        map.put("珠海","广东");
        map.put("百色","广西");
        map.put("北海","广西");
        map.put("崇左","广西");
        map.put("防城港","广西");
        map.put("贵港","广西");
        map.put("桂林","广西");
        map.put("河池","广西");
        map.put("贺州","广西");
        map.put("来宾","广西");
        map.put("柳州","广西");
        map.put("南宁","广西");
        map.put("钦州","广西");
        map.put("梧州","广西");
        map.put("玉林","广西");
        map.put("安顺","贵州");
        map.put("毕节地区","贵州");
        map.put("贵阳","贵州");
        map.put("六盘水","贵州");
        map.put("黔东南苗族侗族自治州","贵州");
        map.put("黔南布依族苗族自治州","贵州");
        map.put("黔西南布依族苗族自治州","贵州");
        map.put("铜仁地区","贵州");
        map.put("遵义","贵州");
        map.put("白沙黎族自治县","海南");
        map.put("保亭黎族苗族自治县","海南");
        map.put("昌江黎族自治县","海南");
        map.put("澄迈县","海南");
        map.put("儋州","海南");
        map.put("定安县","海南");
        map.put("东方","海南");
        map.put("海口","海南");
        map.put("乐东黎族自治县","海南");
        map.put("临高县","海南");
        map.put("陵水黎族自治县","海南");
        map.put("琼海","海南");
        map.put("琼中黎族苗族自治县","海南");
        map.put("三亚","海南");
        map.put("屯昌县","海南");
        map.put("万宁","海南");
        map.put("文昌","海南");
        map.put("五指山","海南");
        map.put("西沙群岛","海南");
        map.put("保定","河北");
        map.put("沧州","河北");
        map.put("承德","河北");
        map.put("邯郸","河北");
        map.put("衡水","河北");
        map.put("廊坊","河北");
        map.put("秦皇岛","河北");
        map.put("石家庄","河北");
        map.put("唐山","河北");
        map.put("邢台","河北");
        map.put("张家口","河北");
        map.put("安阳","河南");
        map.put("鹤壁","河南");
        map.put("济源","河南");
        map.put("焦作","河南");
        map.put("开封","河南");
        map.put("洛阳","河南");
        map.put("漯河","河南");
        map.put("南阳","河南");
        map.put("平顶山","河南");
        map.put("濮阳","河南");
        map.put("三门峡","河南");
        map.put("商丘","河南");
        map.put("新乡","河南");
        map.put("信阳","河南");
        map.put("许昌","河南");
        map.put("郑州","河南");
        map.put("周口","河南");
        map.put("驻马店","河南");
        map.put("大庆","黑龙江");
        map.put("大兴安岭地区","黑龙江");
        map.put("哈尔滨","黑龙江");
        map.put("鹤岗","黑龙江");
        map.put("黑河","黑龙江");
        map.put("鸡西","黑龙江");
        map.put("佳木斯","黑龙江");
        map.put("牡丹江","黑龙江");
        map.put("七台河","黑龙江");
        map.put("齐齐哈尔","黑龙江");
        map.put("双鸭山","黑龙江");
        map.put("绥化","黑龙江");
        map.put("伊春","黑龙江");
        map.put("鄂州","湖北");
        map.put("恩施","湖北");
        map.put("黄冈","湖北");
        map.put("黄石","湖北");
        map.put("荆门","湖北");
        map.put("荆州","湖北");
        map.put("潜江","湖北");
        map.put("神农架林区","湖北");
        map.put("十堰","湖北");
        map.put("随州","湖北");
        map.put("天门","湖北");
        map.put("武汉","湖北");
        map.put("仙桃","湖北");
        map.put("咸宁","湖北");
        map.put("襄樊","湖北");
        map.put("孝感","湖北");
        map.put("宜昌","湖北");
        map.put("长沙","湖南");
        map.put("常德","湖南");
        map.put("郴州","湖南");
        map.put("衡阳","湖南");
        map.put("怀化","湖南");
        map.put("娄底","湖南");
        map.put("邵阳","湖南");
        map.put("湘潭","湖南");
        map.put("湘西土家族苗族自治州","湖南");
        map.put("益阳","湖南");
        map.put("永州","湖南");
        map.put("岳阳","湖南");
        map.put("张家界","湖南");
        map.put("株洲","湖南");
        map.put("白城","吉林");
        map.put("白山","吉林");
        map.put("长春","吉林");
        map.put("吉林","吉林");
        map.put("辽源","吉林");
        map.put("四平","吉林");
        map.put("松原","吉林");
        map.put("通化","吉林");
        map.put("延边朝鲜族自治州","吉林");
        map.put("常州","江苏");
        map.put("淮安","江苏");
        map.put("连云港","江苏");
        map.put("南京","江苏");
        map.put("南通","江苏");
        map.put("苏州","江苏");
        map.put("宿迁","江苏");
        map.put("泰州","江苏");
        map.put("无锡","江苏");
        map.put("徐州","江苏");
        map.put("盐城","江苏");
        map.put("扬州","江苏");
        map.put("镇江","江苏");
        map.put("抚州","江西");
        map.put("赣州","江西");
        map.put("吉安","江西");
        map.put("景德镇","江西");
        map.put("九江","江西");
        map.put("南昌","江西");
        map.put("萍乡","江西");
        map.put("上饶","江西");
        map.put("新余","江西");
        map.put("宜春","江西");
        map.put("鹰潭","江西");
        map.put("鞍山","辽宁");
        map.put("本溪","辽宁");
        map.put("朝阳","辽宁");
        map.put("大连","辽宁");
        map.put("丹东","辽宁");
        map.put("抚顺","辽宁");
        map.put("阜新","辽宁");
        map.put("葫芦岛","辽宁");
        map.put("锦州","辽宁");
        map.put("辽阳","辽宁");
        map.put("盘锦","辽宁");
        map.put("沈阳","辽宁");
        map.put("铁岭","辽宁");
        map.put("营口","辽宁");
        map.put("阿拉善盟","内蒙古");
        map.put("巴彦淖尔","内蒙古");
        map.put("包头","内蒙古");
        map.put("赤峰","内蒙古");
        map.put("鄂尔多斯","内蒙古");
        map.put("呼和浩特","内蒙古");
        map.put("呼伦贝尔","内蒙古");
        map.put("通辽","内蒙古");
        map.put("乌海","内蒙古");
        map.put("乌兰察布","内蒙古");
        map.put("锡林郭勒盟","内蒙古");
        map.put("兴安盟","内蒙古");
        map.put("固原","宁夏回族");
        map.put("石嘴山","宁夏回族");
        map.put("吴忠","宁夏回族");
        map.put("银川","宁夏回族");
        map.put("中卫","宁夏回族");
        map.put("果洛藏族自治州","青海");
        map.put("海北藏族自治州","青海");
        map.put("海东地区","青海");
        map.put("海南藏族自治州","青海");
        map.put("海西蒙古族藏族自治州","青海");
        map.put("黄南藏族自治州","青海");
        map.put("西宁","青海");
        map.put("玉树藏族自治州","青海");
        map.put("滨州","山东");
        map.put("德州","山东");
        map.put("东营","山东");
        map.put("菏泽","山东");
        map.put("济南","山东");
        map.put("济宁","山东");
        map.put("莱芜","山东");
        map.put("聊城","山东");
        map.put("临沂","山东");
        map.put("青岛","山东");
        map.put("日照","山东");
        map.put("泰安","山东");
        map.put("威海","山东");
        map.put("潍坊","山东");
        map.put("烟台","山东");
        map.put("枣庄","山东");
        map.put("淄博","山东");
        map.put("长治","山西");
        map.put("大同","山西");
        map.put("晋城","山西");
        map.put("晋中","山西");
        map.put("临汾","山西");
        map.put("吕梁","山西");
        map.put("朔州","山西");
        map.put("太原","山西");
        map.put("忻州","山西");
        map.put("阳泉","山西");
        map.put("运城","山西");
        map.put("安康","陕西");
        map.put("宝鸡","陕西");
        map.put("汉中","陕西");
        map.put("商洛","陕西");
        map.put("铜川","陕西");
        map.put("渭南","陕西");
        map.put("西安","陕西");
        map.put("咸阳","陕西");
        map.put("延安","陕西");
        map.put("榆林","陕西");
        map.put("阿坝藏族羌族自治州","四川");
        map.put("巴中","四川");
        map.put("成都","四川");
        map.put("达州","四川");
        map.put("德阳","四川");
        map.put("甘孜藏族自治州","四川");
        map.put("广安","四川");
        map.put("广元","四川");
        map.put("乐山","四川");
        map.put("凉山彝族自治州","四川");
        map.put("泸州","四川");
        map.put("眉山","四川");
        map.put("绵阳","四川");
        map.put("内江","四川");
        map.put("南充","四川");
        map.put("攀枝花","四川");
        map.put("遂宁","四川");
        map.put("雅安","四川");
        map.put("宜宾","四川");
        map.put("资阳","四川");
        map.put("自贡","四川");
        map.put("阿里地区","西藏");
        map.put("昌都地区","西藏");
        map.put("拉萨","西藏");
        map.put("林芝地区","西藏");
        map.put("那曲地区","西藏");
        map.put("日喀则地区","西藏");
        map.put("山南地区","西藏");
        map.put("阿克苏地区","新疆");
        map.put("阿拉尔","新疆");
        map.put("阿勒泰地区","新疆");
        map.put("巴音郭楞蒙古自治州","新疆");
        map.put("博尔塔拉蒙古自治州","新疆");
        map.put("昌吉回族自治州","新疆");
        map.put("哈密地区","新疆");
        map.put("和田地区","新疆");
        map.put("喀什地区","新疆");
        map.put("克拉玛依","新疆");
        map.put("克孜勒苏柯尔克孜自治州","新疆");
        map.put("石河子","新疆");
        map.put("塔城地区","新疆");
        map.put("图木舒克","新疆");
        map.put("吐鲁番地区","新疆");
        map.put("乌鲁木齐","新疆");
        map.put("伊犁哈萨克自治州","新疆");
        map.put("保山","云南");
        map.put("楚雄彝族自治州","云南");
        map.put("大理白族自治州","云南");
        map.put("德宏傣族景颇族自治州","云南");
        map.put("迪庆藏族自治州","云南");
        map.put("红河哈尼族彝族自治州","云南");
        map.put("昆明","云南");
        map.put("丽江","云南");
        map.put("临沧","云南");
        map.put("怒江傈僳族自治州","云南");
        map.put("普洱","云南");
        map.put("曲靖","云南");
        map.put("文山壮族苗族自治州","云南");
        map.put("西双版纳傣族自治州","云南");
        map.put("玉溪","云南");
        map.put("昭通","云南");
        return map;
    }

    public static String evaluate(String words) {

        Map<String, String> c2 = fTM();

        Object[] arrayCity = c2.keySet().toArray();
        arrayCity[243]=arrayCity[444];
        arrayCity[444]=c2.keySet().toArray()[243];
        String city = "未知";
        if (words == null) {

            return city;
        } else {
            for (int i = 0; i < arrayCity.length; i++) {
                String k = arrayCity[i].toString();

                    if(words.contains(k)){
                        city = c2.get(k);
                        break;
                    }
            }
        }
        return city;
    }


    public static void main(String[] args) {

      System.out.println(evaluate("嘉兴"));

        Map<String, String> c2 = fTM();

        Object[] arrayCity = c2.keySet().toArray();

        for (int i = 0; i <arrayCity.length ; i++) {
            System.out.println(arrayCity[i].toString());
        }
    }


}
