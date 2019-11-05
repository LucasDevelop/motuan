package com.futrue.huomai.main.my.usercenter;


import com.contrarywind.interfaces.IPickerViewData;

import java.util.List;

public class JsonBean implements IPickerViewData {


    /**
     * city : [{"area":["东城区","西城区","崇文区","宣武区","朝阳区","丰台区","石景山区","海淀区","门头沟区","房山区","通州区","顺义区","昌平区","大兴区","平谷区","怀柔区","密云县","延庆县"],"name":"北京市"}]
     * name : 北京市
     */

    public String name;
    public List<CityBean> city;

    @Override
    public String getPickerViewText() {
        return name;
    }

    public static class CityBean {
        /**
         * area : ["东城区","西城区","崇文区","宣武区","朝阳区","丰台区","石景山区","海淀区","门头沟区","房山区","通州区","顺义区","昌平区","大兴区","平谷区","怀柔区","密云县","延庆县"]
         * name : 北京市
         */

        public String name;
        public List<String> area;
    }
}
