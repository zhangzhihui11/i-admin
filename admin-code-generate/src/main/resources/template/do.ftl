package ${packageName};


@Data
public class ${basePrefix}DO {

    <#list fieldList as field>
        private ${field.javaType} ${field.name};

    </#list>
}