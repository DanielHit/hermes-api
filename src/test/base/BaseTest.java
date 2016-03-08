package base;

import com.qiezi.hermes.api.Bootstrap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * 本类作为事物测试基础类,不建议加入测试单元,所有回滚测试类从此基类继承
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Bootstrap.class)
@Transactional
//AbstractTransactionalJUnit4SpringContextTests
public class BaseTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testName() throws Exception {
        System.out.println("initial test");
    }
}
