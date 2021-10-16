package hu.me.iit.webalk.dependency;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ServiceImplTest {

    @Mock Dependency dependency;

    @InjectMocks ServiceImpl service;

    @Test
    void testCalculate() {
        //Given
        //When
        service.calculate();
        //Then
        verify(dependency,times(1)).helpNoParameterNoReturnValue();
    }

    @Test
    void return5() {
        //Given
        final int FIVE=5;
        //When
        int result=service.return5();
        //then
        assertEquals(FIVE,result);
    }
    @Test
    void dependencyReturnValueIsUsed() {
        //Given
        final int FIVE=5;
        when(dependency.helpNoParameterReturnValue()).thenReturn(FIVE);
        //When
        int result=service.callHelpAndUseReturnValue();
        //then
        verify(dependency,times(1)).helpNoParameterNoReturnValue();
        assertEquals(FIVE,result);
    }
}