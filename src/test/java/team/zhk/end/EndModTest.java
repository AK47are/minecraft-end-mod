package team.zhk.end;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class EndModTest {
    
    @Test
    public void testOnInitializeNoException() {
        EndMod mod = new EndMod();
        assertDoesNotThrow(mod::onInitialize, "onInitialize 方法不应抛出异常");
    }
}