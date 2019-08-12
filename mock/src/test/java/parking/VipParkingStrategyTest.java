package parking;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.Mock;

import java.util.Arrays;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class VipParkingStrategyTest {

    @InjectMocks
    private VipParkingStrategy vipParkingStrategy = new VipParkingStrategy();

    @Mock
    private CarDao carDao;

    @Test
    public void testPark_givenAVipCarAndAFullParkingLog_thenGiveAReceiptWithCarNameAndParkingLotName() {

        /* Exercise 4, Write a test case on VipParkingStrategy.park()
         * With using Mockito spy, verify and doReturn */
        Car car = new Car("ç²¤A 12345");
        ParkingLot parkingLot_full = Mockito.spy(new ParkingLot("Southern Software Park", 10));
        VipParkingStrategy vipParkingStrategy = Mockito.spy(new VipParkingStrategy());
        doReturn(true).when(parkingLot_full).isFull();
        doReturn(true).when(vipParkingStrategy).isAllowOverPark(car);

        vipParkingStrategy.park(Arrays.asList(parkingLot_full), car);

        Mockito.verify(vipParkingStrategy).createReceipt(parkingLot_full, car);
    }

    @Test
    public void testPark_givenCarIsNotVipAndAFullParkingLog_thenGiveNoSpaceReceipt() {

        /* Exercise 4, Write a test case on VipParkingStrategy.park()
         * With using Mockito spy, verify and doReturn */
        Car car = new Car("ç²¤A 12345");
        ParkingLot parkingLot_full = Mockito.spy(new ParkingLot("Southern Software Park", 10));
        VipParkingStrategy vipParkingStrategy = Mockito.spy(new VipParkingStrategy());
        doReturn(true).when(parkingLot_full).isFull();
        doReturn(false).when(vipParkingStrategy).isAllowOverPark(car);

        vipParkingStrategy.park(Arrays.asList(parkingLot_full), car);

        Mockito.verify(vipParkingStrategy).createNoSpaceReceipt(car);
    }

    @Test
    public void testIsAllowOverPark_givenCarNameContainsCharacterAAndIsVipCar_thenReturnTrue(){

        /* Exercise 5, Write a test case on VipParkingStrategy.isAllowOverPark()
         * You may refactor the code, or try to use
         * use @RunWith(MockitoJUnitRunner.class), @Mock (use Mockito, not JMockit) and @InjectMocks
         */
        Car car = new Car("ç²¤A 12345");
        doReturn(true).when(carDao).isVip(car.getName());

        Assert.assertEquals(true, vipParkingStrategy.isAllowOverPark(car));
    }

    @Test
    public void testIsAllowOverPark_givenCarNameDoesNotContainsCharacterAAndIsVipCar_thenReturnFalse(){

        /* Exercise 5, Write a test case on VipParkingStrategy.isAllowOverPark()
         * You may refactor the code, or try to use
         * use @RunWith(MockitoJUnitRunner.class), @Mock (use Mockito, not JMockit) and @InjectMocks
         */
    }

    @Test
    public void testIsAllowOverPark_givenCarNameContainsCharacterAAndIsNotVipCar_thenReturnFalse(){
        /* Exercise 5, Write a test case on VipParkingStrategy.isAllowOverPark()
         * You may refactor the code, or try to use
         * use @RunWith(MockitoJUnitRunner.class), @Mock (use Mockito, not JMockit) and @InjectMocks
         */
    }

    @Test
    public void testIsAllowOverPark_givenCarNameDoesNotContainsCharacterAAndIsNotVipCar_thenReturnFalse() {
        /* Exercise 5, Write a test case on VipParkingStrategy.isAllowOverPark()
         * You may refactor the code, or try to use
         * use @RunWith(MockitoJUnitRunner.class), @Mock (use Mockito, not JMockit) and @InjectMocks
         */
    }

    private Car createMockCar(String carName) {
        Car car = mock(Car.class);
        when(car.getName()).thenReturn(carName);
        return car;
    }

}
