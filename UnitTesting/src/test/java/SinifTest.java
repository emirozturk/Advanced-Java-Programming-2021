import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinifTest {

    @Test
    void SinirTesti() {
        assertEquals(2,Sinif.Hesapla("50"));
        assertEquals(150,Sinif.Hesapla("150"));
        assertEquals(1,Sinif.Hesapla("100"));
    }
    @Test
    void DoubleTesti(){
        assertEquals(151.0,Sinif.Hesapla("150.5"));
    }
    @Test
    void BolmeTesti(){
        assertEquals(0,Sinif.Hesapla("0"));
    }
    @Test
    void Metintesti(){
        assertEquals(0,Sinif.Hesapla(""));
    }
}