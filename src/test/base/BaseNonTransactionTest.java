package base;

import com.qiezi.hermes.api.Bootstrap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Daniel on 15/12/27.
 * 本类作为非事物测试基础类,不建议加入测试单元,所有回滚测试类从此基类继承
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Bootstrap.class)
public class BaseNonTransactionTest extends AbstractJUnit4SpringContextTests {
    @Test
    public void testName() throws Exception {

    }
}
