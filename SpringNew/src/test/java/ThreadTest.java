import com.alibaba.fastjson.JSONObject;
import org.spring.entities.MyInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @Created by Administrator on 2018/10/30.
 * @DESC
 * @DATE 30
 */
public class ThreadTest {

    public static void main(String args[]){

        Thread thread=new Thread(()->{System.out.println("12323");});
        thread.start();
       MyInfo myInfo=new MyInfo();
        List list= new LinkedList<>();
        list.add("123");
        list.add("12321");
        list.add("1111");
        //遍历
        list.forEach( (str)->System.out.println(str));

        List<MyInfo> persions=new LinkedList<MyInfo>();
        persions.add(myInfo);
        Consumer<MyInfo> infos=e->{e.setPassword("21321") ;e.setUsername("1");};

        persions.forEach(infos);

        MyInfo myInfo2=new MyInfo();
        myInfo2.setUsername("3");
        persions.add(myInfo2);

        MyInfo myInfo3=new MyInfo();
        myInfo3.setUsername("2");
        persions.add(myInfo3);

         List<MyInfo> myinfos=persions.stream().sorted((a, b) -> {
            return a.getUsername().compareTo(b.getUsername());
        }).filter(info->info.getUsername().compareTo("1")>0)
                 .limit(1)
                 .collect(Collectors.toList()) ;
        System.out.println(JSONObject.toJSONString(myinfos)+"     ");
    }
}
