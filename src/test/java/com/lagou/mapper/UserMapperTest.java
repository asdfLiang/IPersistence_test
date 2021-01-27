package com.lagou.mapper;

import com.lagou.config.XmlConfigBuilder;
import com.lagou.domain.Configuration;
import com.lagou.io.Resources;
import org.dom4j.DocumentException;
import org.junit.jupiter.api.Test;

import java.beans.PropertyVetoException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author liangzj
 * @date 2021/1/24 19:09
 */
class UserMapperTest {

    @Test
    void resourceTest() {
        Resources.getResourceAsStream("sqlMapConfig.xml");
    }

    @Test
    void configParseTest() throws PropertyVetoException, DocumentException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        XmlConfigBuilder xmlConfigBuilder = new XmlConfigBuilder();
        Configuration configuration = xmlConfigBuilder.parseConfig(resourceAsStream);
        System.out.println(configuration);
    }

    @Test
    void selectAll() {
        System.out.println("Hello World!");
    }

    @Test
    void selectOne() {
    }
}