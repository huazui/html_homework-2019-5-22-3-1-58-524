package parking;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static parking.ParkingStrategy.NO_PARKING_LOT;

public class InOrderParkingStrategyTest {

    @Test
    public void testCreateReceipt_givenACarAndAParkingLog_thenGiveAReceiptWithCarNameAndParkingLotName() {

        /* Exercise 1, Write a test case on InOrderParkingStrategy.createReceipt()
         * With using Mockito to mock the input parameter */
        Car car = mock(Car.class);
        ParkingLot parkingLot = mock(ParkingLot.class);
        InOrderParkingStrategy inOrderParkingStrategy = new InOrderParkingStrategy();
        when(parkingLot.getName()).thenReturn("Southern Software Park");
        when(car.getName()).thenReturn("ç²¤A 12345");

        Receipt receipt = inOrderParkingStrategy.createReceipt(parkingLot, car);

        Assert.assertEquals(receipt.getCarName(), car.getName());
        Assert.assertEquals(receipt.getParkingLotName(), parkingLot.getName());
    }

    @Test
    public void testCreateNoSpaceReceipt_givenACar_thenGiveANoSpaceReceipt() {

        /* Exercise 1, Write a test case on InOrderParkingStrategy.createNoSpaceReceipt()
         * With using Mockito to mock the input parameter */
        Car car = mock(Car.class);
        InOrderParkingStrategy inOrderParkingStrategy = new InOrderParkingStrategy();
        when(car.getName()).thenReturn("ç²¤A 12345");

        Receipt receipt = inOrderParkingStrategy.createNoSpaceReceipt(car);

        Assert.assertEquals(receipt.getCarName(), car.getName());
        Assert.assertEquals(receipt.getParkingLotName(), NO_PARKING_LOT);
    }

    @Test
    public void testPark_givenNoAvailableParkingLot_thenCreateNoSpaceReceipt(){

        /* Exercise 2: Test park() method. Use Mockito.spy and Mockito.verify to test the situation for no available parking lot */
        Car car = new Car("ç²¤A 12345");
        InOrderParkingStrategy inOrderParkingStrategy = Mockito.spy(new InOrderParkingStrategy());

        inOrderParkingStrategy.park(null, car);

        Mockito.verify(inOrderParkingStrategy).createNoSpaceReceipt(car);
    }

    @Test
    public void testPark_givenThereIsOneParkingLotWithSpace_thenCreateReceipt(){

        /* Exercise 2: Test park() method. Use Mockito.spy and Mockito.verify to test the situation for one available parking lot */
        Car car = new Car("ç²¤A 12345");
        ParkingLot availableParkingLot = Mockito.spy(new ParkingLot("Southern Software Park", 10));
        InOrderParkingStrategy inOrderParkingStrategy = Mockito.spy(new InOrderParkingStrategy());
        doReturn(false).when(availableParkingLot).isFull();

        inOrderParkingStrategy.park(Arrays.asList(availableParkingLot), car);

        Mockito.verify(inOrderParkingStrategy).createReceipt(availableParkingLot, car);
    }

    @Test
    public void testPark_givenThereIsOneFullParkingLot_thenCreateReceipt(){

        /* Exercise 2: Test park() method. Use Mockito.spy and Mockito.verify to test the situation for one available parking lot but it is full */
        Car car = new Car("ç²¤A 12345");
        ParkingLot parkingLot = Mockito.spy(new ParkingLot("Southern Software Park", 10));
        InOrderParkingStrategy inOrderParkingStrategy = Mockito.spy(new InOrderParkingStrategy());
        doReturn(true).when(parkingLot).isFull();

        inOrderParkingStrategy.park(Arrays.asList(parkingLot), car);

        Mockito.verify(inOrderParkingStrategy).createNoSpaceReceipt(car);

    }

    @Test
    public void testPark_givenThereIsMultipleParkingLotAndFirstOneIsFull_thenCreateReceiptWithUnfullParkingLot(){

        /* Exercise 3: Test park() method. Use Mockito.spy and Mockito.verify to test the situation for multiple parking lot situation */
        Car car = new Car("ç²¤A 12345");
        ParkingLot parkingLot_first = Mockito.spy(new ParkingLot("Southern Software Park", 10));
        ParkingLot parkingLot_second = new ParkingLot("Yang Ming Park", 15);
        ParkingLot parkingLot_three = new ParkingLot("Ao yuan Park", 20);
        InOrderParkingStrategy inOrderParkingStrategy = Mockito.spy(new InOrderParkingStrategy());
        doReturn(true).when(parkingLot_first).isFull();

        inOrderParkingStrategy.park(Arrays.asList(parkingLot_first, parkingLot_second, parkingLot_three), car);

        Mockito.verify(inOrderParkingStrategy).createReceipt(parkingLot_second, car);
    }
}
