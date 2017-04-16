package com.example.dell.mybraodcast;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * All rights Reserved, Designed By www.lawyee.com
 *
 * @version V 1.0 xxxxxxxx
 * @Title: MyBraodcast
 * @Package com.example.dell.mybraodcast
 * @Description: $todo$
 * @author: YFL
 * @date: 2017/4/16 13:19
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2017 www.lawyee.com Inc. All rights reserved.
 * 注意：本内容仅限于北京法意科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */


public class ActivityCollector {


    public static List<Activity> activitys=new ArrayList<>();

   public static void addActivity(Activity activity){
       activitys.add(activity);
   }
   public static void removeActivity(Activity activity){
       activitys.remove(activity);
   }
   public static void finishAll(){
       for (Activity activity : activitys) {
           if (!activity.isFinishing()){
               activity.finish();
           }
       }
   }

}
