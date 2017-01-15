package com.github.kuros.api.finder.mapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;
import com.fasterxml.jackson.module.jsonSchema.types.StringSchema;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.controller.ComplexRequestBody;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:test-kuros-api-finder-context.xml")
public class MappingInfoImplTest {

    @Autowired
    private MappingInfo mappingInfo;


    @Test
    public void name() throws Exception {
//        mappingInfo.listAll();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonSchemaGenerator schemaGenerator = new JsonSchemaGenerator(objectMapper);

        final JsonSchema jsonSchema = schemaGenerator.generateSchema(Long.class);
        final String s = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonSchema);

        System.out.println(s);
        final StringSchema stringSchema = jsonSchema.asStringSchema();

//        objectMapper.setAnnotationIntrospector(new JacksonAnnotationIntrospector());
//        final boolean b = objectMapper.canSerialize(ComplexRequestBody.class);
//        final JsonSchema jsonSchema = objectMapper.generateJsonSchema(ComplexRequestBody.class);
//        final ObjectNode schemaNode = jsonSchema.getSchemaNode();
//        schemaNode.
    }
}