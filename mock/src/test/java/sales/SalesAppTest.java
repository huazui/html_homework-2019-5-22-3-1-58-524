package sales;

import mockit.integration.junit4.JMockit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.Mock;
import parking.CarDao;
import parking.VipParkingStrategy;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.mockito.Mockito.*;

@RunWith(JMockit.class)
public class SalesAppTest {

	@Test
	public void testIsEffective() {
		SalesApp saleApp = new SalesApp();
		Sales sales = mock(Sales.class);
		when(sales.getEffectiveFrom()).thenReturn(new Date(0));
		when(sales.getEffectiveTo()).thenReturn(new Date());
		Assert.assertEquals(true,saleApp.isEffective(sales));

	}

	@Test
	public void testGetFilteredReportDataListWhenIsSuperVisor(){
		SalesApp saleApp = new SalesApp();
		SalesReportData data1 = mock(SalesReportData.class);
		SalesReportData data2 = mock(SalesReportData.class);
		when(data1.isConfidential()).thenReturn(true);
		when(data2.isConfidential()).thenReturn(false);
		when(data1.getType()).thenReturn("SalesActivity");
		when(data2.getType()).thenReturn("SalesActivity");
		List<SalesReportData> myList = new ArrayList<SalesReportData>();
		myList.add(data1);
		myList.add(data2);
		boolean isSuperVisor = true;
		List<SalesReportData> filterList = saleApp.getFilteredReportDataList(myList,isSuperVisor);
		Assert.assertEquals(2,filterList.size());
	}
	@Test
	public void testGetFilteredReportDataListWhenIsnotSuperVisor(){
		SalesApp saleApp = new SalesApp();
		SalesReportData data1 = mock(SalesReportData.class);
		SalesReportData data2 = mock(SalesReportData.class);
		when(data1.isConfidential()).thenReturn(true);
		when(data2.isConfidential()).thenReturn(false);
		when(data1.getType()).thenReturn("SalesActivity");
		when(data2.getType()).thenReturn("SalesActivity");
		List<SalesReportData> myList = new ArrayList<SalesReportData>();
		myList.add(data1);
		myList.add(data2);
		boolean isSuperVisor = false;
		List<SalesReportData> filterList = saleApp.getFilteredReportDataList(myList,isSuperVisor);
		Assert.assertEquals(1,filterList.size());
	}

	@Test
	public void testGetTempList(){
		SalesApp saleApp = new SalesApp();
		SalesReportData data1 = mock(SalesReportData.class);
		SalesReportData data2 = mock(SalesReportData.class);
		SalesReportData data3 = mock(SalesReportData.class);
		SalesReportData data4 = mock(SalesReportData.class);
		List<SalesReportData> myList = new ArrayList<SalesReportData>();
		myList.add(data1);
		myList.add(data2);
		myList.add(data3);
		myList.add(data4);
		int maxRow = 5;
		Assert.assertEquals(4,saleApp.getTempList(myList,3).size());
	}


	private SalesApp salesApp = new SalesApp();



@Test
//测试是否能够执行函数，调用里面的小函数。采用同学建议用了JMockit，赋予了前面函数的返回值
	public void testGenerateSalesActivityReport(){
	SalesApp salesApp = spy(new SalesApp());

	new mockit.MockUp<SalesApp>(){
		@mockit.Mock
		public List<SalesReportData> getFilteredReportDataList
				(  List<SalesReportData> reportDataList,boolean isSupervisor){
			return null;
		}
	};

	new mockit.MockUp<SalesApp>(){
		@mockit.Mock
		public List<SalesReportData>  getTempList
				( List<SalesReportData> reportDataList,int maxRow){
			return null;
		}
	};
	doReturn(true).when(salesApp).isEffective(any());
	doReturn("Null").when(salesApp).getXml(any());
	salesApp.generateSalesActivityReport("DUMMY", 1000, false, false);

	// 调用
	verify(salesApp,times(1)).generateReport(any(), any());
}
}
