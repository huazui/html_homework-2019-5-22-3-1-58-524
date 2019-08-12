package sales;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SalesApp {

	//时间是否有效
	public boolean isEffective(Sales sales){
		Date today = new Date();
		if (today.after(sales.getEffectiveTo())
				|| today.before(sales.getEffectiveFrom())){
			return false;
		}
		return true;

	}


	//根据报告数据的机密性与访问者的权限过滤生成的销售报告
	public List<SalesReportData>getFilteredReportDataList(List<SalesReportData> reportDataList,boolean isSupervisor){
		List<SalesReportData> filteredReportDataList = new ArrayList<SalesReportData>();
		for (SalesReportData data : reportDataList) {
			if ("SalesActivity".equalsIgnoreCase(data.getType())) {
				if (data.isConfidential()) {
					if (isSupervisor) {
						filteredReportDataList.add(data);
					}
				}else {
					filteredReportDataList.add(data);
				}
			}
		}
		return filteredReportDataList;

	}

	//这个没有必要测试啦，只是生成报表开头
	public List<String>setHeaders(boolean isNatTrade){
		List<String>headers = null;
		if (isNatTrade) {
			headers = Arrays.asList("Sales ID", "Sales Name", "Activity", "Time");
		} else {
			headers = Arrays.asList("Sales ID", "Sales Name", "Activity", "Local Time");
		}
		return headers;

	}

	//这个大概是获取一页报表？根据最大行数
	public List<SalesReportData> getTempList(List<SalesReportData> reportDataList,int maxRow){
		List<SalesReportData> tempList = new ArrayList<SalesReportData>();
		//那个，，，，我觉得这个应该不能是“或”，应该是“与”吧？
		for (int i=0; i < reportDataList.size() || i < maxRow; i++) {
			tempList.add(reportDataList.get(i));
		}
       return tempList;
	}

	public String getXml(SalesActivityReport report) {
		return report.toXml();
	}

	public void generateSalesActivityReport(String salesId, int maxRow, boolean isNatTrade, boolean isSupervisor) {
	 SalesDao salesDao = new SalesDao();
	 SalesReportDao salesReportDao = new SalesReportDao();
	 EcmService ecmService = new EcmService();

		if (salesId == null) {
			return;
		}


		Sales sales = salesDao.getSalesBySalesId(salesId);
		if(!isEffective(sales))
			return;

		List<SalesReportData> reportDataList = salesReportDao.getReportData(sales);

		List<SalesReportData> filteredReportDataList = getFilteredReportDataList(reportDataList,isSupervisor);

		//???我怀疑这里的reportDataList应该是filteredReportDataList才对
		List<SalesReportData> tempList = getTempList(reportDataList,maxRow);

		filteredReportDataList = tempList;
		List<String> headers = setHeaders(isNatTrade);

		//???我怀疑这里的reportDataList应该是filteredReportDataList才对
		SalesActivityReport report = this.generateReport(headers, reportDataList);


		ecmService.uploadDocument(getXml(report));
		
	}

	protected SalesActivityReport generateReport(List<String> headers, List<SalesReportData> reportDataList) {
		// TODO Auto-generated method stub
		return null;
	}

}
