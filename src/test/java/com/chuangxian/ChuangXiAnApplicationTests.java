package com.chuangxian;

import com.chuangxian.entity.Policy;
import com.chuangxian.entity.PolicyLevel;
import com.chuangxian.service.PolicyLevelService;
import com.chuangxian.service.PolicyService;
import com.chuangxian.util.String2DateUtils;
import com.chuangxian.util.XiAnPolicyCrawler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChuangXiAnApplicationTests {

    @Resource
    private PolicyLevelService policyLevelService;

    @Test
    public void test() {
       Set<String> levels = new HashSet<>();


        levels.add("yi");
        levels.add("er");
            //policyLevelService.addNewPolicyLevel(policyLevel);

        try {
            policyLevelService.addNewPolicyLevels(levels);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
