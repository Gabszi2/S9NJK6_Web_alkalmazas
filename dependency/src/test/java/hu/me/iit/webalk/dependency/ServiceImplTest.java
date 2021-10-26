package hu.me.iit.webalk.dependency;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
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

    @Test
    public void testCallHelpAndPassParameter5(){
        //Given
        final int FIVE=5;
        //When
        service.callHelpAndPassParameter5();

        //Then
        ArgumentCaptor<Integer> captor=ArgumentCaptor.forClass(Integer.class);
        verify(dependency,times(1)).helpWithParameterNoReturnValue(captor.capture());
        assertEquals(FIVE,captor.getValue());
    }
    @Test
    public void testGetImportantAbstract(){
        //Given
        final String TEXT="text";
        //When
        service.callImportantAbstract();
        //Then
        ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class);
        verify(dependency,times(1)).helpImportant(captor.capture());
        assertEquals(TEXT,captor.getValue());
    }
}