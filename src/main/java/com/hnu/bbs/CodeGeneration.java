package com.hnu.bbs;

import java.util.*;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.ibatis.annotations.Mapper;

/**
 * bbs_billboard, bbs_follow, bbs_post, bbs_comment, bbs_tag, bbs_promotion, bbs_tip, bbs_user,bbs_post_tag
 */
public class CodeGeneration {

    public static void main(String[] args) {
        System.out.println("请输入表名(多个用英文逗号隔开)： ");
        Scanner sc = new Scanner(System.in);
        String tableNames = sc.nextLine();
        sc.close();
        String[] tableNameList = tableNames.split(",");
        for (String tableName : tableNameList) {
            generation(tableName.strip());
            System.out.println(tableName + "表的代码生成成功！");
        }
    }

    /**
     * 根据表名生成相应结构代码
     * 
     * @param tableName 表名
     */
    @SuppressWarnings({"deprecated"})
    public static void generation(String tableName) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/hnubbs", "root", "123456")
                /**
                 * 全局配置
                 */
                .globalConfig(builder -> {
                    builder.author("hnubbs")
                            .disableOpenDir()
                            .dateType(DateType.ONLY_DATE)
                            .outputDir(System.getProperty("user.dir") + "/src/main/java");
                })
                /**
                 * 包配置
                 */
                .packageConfig(builder -> {
                    builder.parent("com.hnu.bbs")// 父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
                            .entity("entity")// 实体类包名
                            .controller("controller")// 控制层包名
                            .mapper("mapper")// mapper层包名
                            .service("service")// service层包名
                            .serviceImpl("service.impl")// service实现类包名
                            .pathInfo(Collections.singletonMap(OutputFile.xml,
                                    System.getProperty("user.dir") + "/src/main/resources/mapper"));
                })
                /**
                 * 策略配置
                 */
                .strategyConfig(builder -> {
                    // 设置要生成的表名
                    builder.addInclude(tableName)
                            .addTablePrefix("bbs_")//设置表前缀过滤
                            /**
                             * 实体配置
                             */
                            .entityBuilder()
                            .enableLombok()
                            .enableFileOverride()// 是否覆盖已有文件
                            .naming(NamingStrategy.underline_to_camel)// 数据表映射实体命名策略：默认下划线转驼峰underline_to_camel
                            .columnNaming(NamingStrategy.underline_to_camel)// 表字段映射实体属性命名规则：默认null，不指定按照naming执行
                            .idType(IdType.AUTO)// 添加全局主键类型
                            .formatFileName("%s")// 格式化实体名称，%s取消首字母I,
                            /**
                             * mapper配置
                             */
                            .mapperBuilder()
                            // .enableFileOverride()// 是否覆盖已有文件
                            .mapperAnnotation(Mapper.class)
                            .enableBaseResultMap()// 启用xml文件中的BaseResultMap 生成
                            .enableBaseColumnList()// 启用xml文件中的BaseColumnList
                            .formatMapperFileName("%sMapper")// 格式化Dao类名称
                            .formatXmlFileName("%sMapper")// 格式化xml文件名称
                            /**
                             * service配置
                             */
                            .serviceBuilder()
                            // .enableFileOverride()// 是否覆盖已有文件
                            .formatServiceFileName("%sService")// 格式化 service 接口文件名称
                            .formatServiceImplFileName("%sServiceImpl")// 格式化 service 接口文件名称
                            .controllerBuilder()
                            .enableRestStyle()
                            /**
                             * controller配置
                             */
                            .controllerBuilder()
                            // .enableFileOverride()// 是否覆盖已有文件
                            .formatFileName("%s")// 格式化文件名称
                            .enableHyphenStyle()// 开启驼峰转连字符
                            .formatFileName("%sController");// 格式化文件名称
                })
                .execute();
    }
}
