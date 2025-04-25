package com.pharmacy.service;


import java.sql.ResultSet;
import java.util.List;

import com.pharmacy.dao.ReportDao;
import com.pharmacy.model.Report;

public class ReportService {
private ReportDao reportdao;

public ReportService() {
	this.reportdao = new ReportDao();
}
public ResultSet ViewReportSale() {
	return reportdao.GenerateReportSale();
	
}
}
