package com.example.erp;

import com.example.erp.entity.Leave;
import com.example.erp.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author qzp
 * @date 2020/2/17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTest {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void test(){
        Leave leave = new Leave();
        leave.setId(12);
        leave.setReason("无原因");
        redisUtil.set("leave",leave);
        System.out.println(redisUtil.get("leave"));
    }


    /*将数组打乱*/
    @Test
    public void testRandom(){
        int []a = new int[]{1,2,3,4,5,6,7,8,9};
        int []b = new int[a.length];
        for (int i = 0 ; i<a.length;i++){
            int index = (int)(Math.random()*(a.length-i-1));
            b[i] = a[index];
            int temp  = a[a.length-i-1];
            a[a.length-i-1] = a[index];
            a[index] = temp;
        }
        for (int i : b) {
            System.out.print(i+",");
        }
    }

}
