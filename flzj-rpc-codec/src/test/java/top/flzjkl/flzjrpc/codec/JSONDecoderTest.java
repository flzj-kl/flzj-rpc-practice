package top.flzjkl.flzjrpc.codec;

import org.junit.Test;

import static org.junit.Assert.*;

public class JSONDecoderTest {

    @Test
    public void decode() {
        Encoder encoder = new JSONEncoder();
        TestBean testBean1 = new TestBean();
        testBean1.setAge(18);
        testBean1.setName("flzj");
        byte[] encode = encoder.encode(testBean1);
        assertNotNull(encode);

        Decoder decoder = new JSONDecoder();
        TestBean testBean2 = decoder.decode(encode,TestBean.class);

        assertEquals(testBean1.getAge(),testBean2.getAge());
        assertEquals(testBean1.getName(),testBean2.getName());
    }
}