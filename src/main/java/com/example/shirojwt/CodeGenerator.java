package com.example.shirojwt;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * CodeGenerator:逆向生成表数据启动main方法
 *
 * @author zhangxiaoxiang
 * @date: 2019/07/02
 */
@Slf4j
public class CodeGenerator {


    public static void main(String[] args) {
        //在这里输入你要生成的表名
        boolean b = generateEntity("user");
        if (!b) {
            log.error("==========================逆向生成失败！=================================");
        }

    }


    /**
     * 数据库生成对应entity,dao,service,serviceimpl,controller和XML映射文件
     *
     * @param tableName 数据库表名
     * @return 生成成功与失败的布尔值
     */
    public static boolean generateEntity(String tableName) {
        try {
            // 代码生成器
            AutoGenerator mpg = new AutoGenerator();

            // 全局配置
            GlobalConfig gc = new GlobalConfig();
            String projectPath = System.getProperty("user.dir");
            gc.setOutputDir(projectPath + "/src/main/java");
            gc.setAuthor("zhangxiaoxiang");
            gc.setOpen(false);
            // gc.setSwagger2(true); 实体属性 Swagger2 注解
            mpg.setGlobalConfig(gc);
            // 自定义文件命名，注意 %s 会自动填充表实体属性！
            gc.setMapperName("%sDao");
            gc.setXmlName("%sMapper");
            gc.setServiceName("%sService");
            gc.setServiceImplName("%sServiceImpl");
            gc.setControllerName("%sController");

            // 数据源配置
            DataSourceConfig dsc = new DataSourceConfig();
            dsc.setUrl("jdbc:mysql://localhost:3306/lvyou?useUnicode=true&useSSL=false&characterEncoding=utf8");
            // dsc.setSchemaName("public");
            dsc.setDriverName("com.mysql.jdbc.Driver");
            dsc.setUsername("root");
            dsc.setPassword("root");
            mpg.setDataSource(dsc);

            // 包配置
            PackageConfig pc = new PackageConfig();
            //pc.setModuleName(scanner("单模块不用配置"));
            pc.setParent("com.example.shirojwt");
            pc.setEntity("entity");
            pc.setMapper("dao");
            pc.setService("service");
            pc.setServiceImpl("serviceimpl");
            pc.setController("controller");
            mpg.setPackageInfo(pc);

            // 自定义配置
            InjectionConfig cfg = new InjectionConfig() {
                @Override
                public void initMap() {
                    // to do nothing
                }
            };

            // 如果模板引擎是 freemarker
            String templatePath = "/templates/mapper.xml.ftl";
            // 如果模板引擎是 velocity
            // String templatePath = "/templates/mapper.xml.vm";

            // 自定义输出配置
            List<FileOutConfig> focList = new ArrayList<>();
            // 自定义配置会被优先输出
            focList.add(new FileOutConfig(templatePath) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                    return projectPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                }
            });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */
            cfg.setFileOutConfigList(focList);
            mpg.setCfg(cfg);

            // 配置模板
            TemplateConfig templateConfig = new TemplateConfig();

            // 配置自定义输出模板
            //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
            // templateConfig.setEntity("templates/entity2.java");
            // templateConfig.setService();
            // templateConfig.setController();

            templateConfig.setXml(null);
            mpg.setTemplate(templateConfig);

            // 策略配置(驼峰命名与数据库下划线转换,RestController)
            StrategyConfig strategy = new StrategyConfig();
            strategy.setNaming(NamingStrategy.underline_to_camel);
            strategy.setColumnNaming(NamingStrategy.underline_to_camel);
            //strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
            strategy.setEntityLombokModel(true);
            strategy.setRestControllerStyle(true);

            // 公共父类
            //strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
            // 写于父类中的公共字段
            strategy.setSuperEntityColumns("id");
            strategy.setInclude(tableName);
            strategy.setControllerMappingHyphenStyle(true);
            strategy.setTablePrefix(pc.getModuleName() + "_");
            mpg.setStrategy(strategy);
            mpg.setTemplateEngine(new FreemarkerTemplateEngine());
            mpg.execute();
            return true;
        } catch (Exception e) {
            return false;
        }

    }


}
