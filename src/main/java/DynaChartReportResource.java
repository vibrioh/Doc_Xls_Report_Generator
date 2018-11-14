///*
// * IBM Corporation.
// * Copyright (c) 2014 All Rights Reserved.
// */
//
//package com.ibm.risk.irmp.customerlink.rest;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.Writer;
//import java.text.DecimalFormat;
//import java.text.NumberFormat;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.MediaType;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.HierarchicalMessageSource;
//import org.springframework.context.i18n.LocaleContextHolder;
//
//import com.ibm.iisp.common.exception.I18nAppException;
//import com.ibm.iisp.common.rest.RestService;
//import com.ibm.iisp.common.util.FileStoreUtils;
//import com.ibm.iisp.common.web.springmvc.freemarker.NewFreeMarkerConfigurer;
//import com.ibm.iisp.common.web.utils.SessionParameters;
//import com.ibm.risk.irmp.customerlink.vo.dyna_chart.DataContent;
//import com.ibm.risk.irmp.customerlink.vo.dyna_chart.DynaChartReportRequestVO;
//import com.ibm.risk.irmp.customerlink.vo.dyna_chart.EdgeInfo;
//import com.ibm.risk.irmp.customerlink.vo.dyna_chart.LabelCount;
//import com.ibm.risk.irmp.customerlink.vo.dyna_chart.ReportContent;
//import com.ibm.risk.irmp.customerlink.vo.dyna_chart.StatisticsContent;
//
//import freemarker.template.Template;
//
///**
// * 类作用：
// *
// * @author junhu@us.ibm.com 使用说明：
// */
//@RestService
//@Path("/dyna_chart_reports")
//@Produces(MediaType.APPLICATION_JSON)
//public class DynaChartReportResource {
//	private static Logger logger = LoggerFactory.getLogger(DynaChartReportResource.class);
//	private NumberFormat plusMinusNF = new DecimalFormat("+#;-#");
//
//	@Context
//	HttpServletRequest request;
//
//	@Resource
//	NewFreeMarkerConfigurer freeMarkerConfigurer;
//	@Resource
//	FileStoreUtils fileStoreUtils;
//	@Resource
//	HierarchicalMessageSource messageSource;
//	public final static String REPORT_FOLDER = "/irmp-cust-link/dyna_chart/reports";
//
//	@POST
//	@Path("/report")
//	public Map<String, Object> getDynaChartReport(DynaChartReportRequestVO req) throws I18nAppException {
//		String xlsTempPath = "/dyna_chart/Report_xls.ftl";
//		String fileName = messageSource.getMessage("dyna_chart.report.fileName", null, "DYNAMIC_CHART_REPORT",
//				LocaleContextHolder.getLocale());
//		fileName = fileStoreUtils.encodeFileName(fileName);
//		String fullXlsFn = fileStoreUtils.getTempAbsFilePath(REPORT_FOLDER + fileName + ".xls");
//		String dataDate = (String) request.getSession(true).getAttribute(SessionParameters.CURRENT_DATA_DATE);
//
//		HashMap<String, Object> params = new HashMap<>();
//		HashMap<String, Object> paramsDoc = new HashMap<>();
//		HashMap<String, Object> paramsXls = new HashMap<>();
//
//		ReportContent repCon = req.getReport();
//
//		StatisticsContent statistics = repCon.getStatistics();
//		DataContent data = repCon.getData();
//
//		// String dataDate = statistics.getData_date();
//		String cino = statistics.getCino();
//		String custName = statistics.getCust_name();
//		String groupID = statistics.getGroup_id();
//		String groupName = statistics.getGroup_name();
//		String startDate = statistics.getStart_date();
//		String endDate = statistics.getEnd_date();
//		String vNumAll = String.valueOf(statistics.getNum_vertices());
//		String eNumAll = String.valueOf(statistics.getNum_edges());
//		String vNumAllChg = String.valueOf(plusMinusNF.format(statistics.getNum_vertices_changed()));
//		String eNumAllChg = String.valueOf(plusMinusNF.format(statistics.getNum_edges_changed()));
//
//        //######################    Add 111218 start 1    #######################
//        String vNumAllChgAdd = String.valueOf(statistics.getNum_vertices_changed_add());
//        String eNumAllChgAdd = String.valueOf(statistics.getNum_edges_changed_add());
//        String vNumAllChgSub = String.valueOf(statistics.getNum_vertices_changed_minus());
//        String eNumAllChgSub = String.valueOf(statistics.getNum_edges_changed_minus());
//        //######################    Add 111218 end 1      #######################
//        //
//		paramsDoc.put("dataDate", dataDate);
//		paramsDoc.put("cino", cino);
//		paramsDoc.put("custName", custName);
//		paramsDoc.put("groupID", groupID);
//		paramsDoc.put("groupName", groupName);
//		paramsDoc.put("startDate", startDate);
//		paramsDoc.put("endDate", endDate);
//		paramsDoc.put("vNumAll", vNumAll);
//		paramsDoc.put("eNumAll", eNumAll);
//		paramsDoc.put("vNumAllChg", vNumAllChg);
//		paramsDoc.put("eNumAllChg", eNumAllChg);
//
//        //######################    Add 111218 start 2    #######################
//        paramsDoc.put("vNumAllChgAdd", vNumAllChgAdd);
//        paramsDoc.put("eNumAllChgAdd", eNumAllChgAdd);
//        paramsDoc.put("vNumAllChgSub", vNumAllChgSub);
//        paramsDoc.put("eNumAllChgSub", eNumAllChgSub);
//        //######################    Add 111218 end 2      #######################
//
//		List<LabelCount> vertices_changes = statistics.getVertices_changes_by_label();
//		List<LabelCount> edge_changes = statistics.getEdge_changes_by_label();
//		String vNum1 = "N/A";
//		String vNum1Chg = "N/A";
//		String vNum2 = "N/A";
//		String vNum2Chg = "N/A";
//
//        //######################    Add 111218 start 3    #######################
//        String vNum1ChgAdd = "N/A";
//        String vNum1ChgSub = "N/A";
//        String vNum2ChgAdd = "N/A";
//        String vNum2ChgSub = "N/A";
//        //######################    Add 111218 end 3      #######################
//
//		for (LabelCount v : vertices_changes) {
//			String vLabel = v.getLabel();
//			int vCount = v.getCount();
//			int vCountChanged = v.getCount_changed();
//
//            //######################    Add 111218 start 4    #######################
//            int vCountChangedAdd = v.getCount_changed_add();
//            int vCountChangedSub = v.getCount_changed_minus();
//            //######################    Add 111218 end 4      #######################
//
//			System.out.println(vCountChanged);
//
//			if (vLabel.equals("1")) {
//				vNum1 = String.valueOf(vCount);
//				vNum1Chg = String.valueOf(plusMinusNF.format(vCountChanged));
//
//                //######################    Add 111218 start 5    #######################
//                vNum1ChgAdd = String.valueOf(vCountChangedAdd);
//                vNum1ChgSub = String.valueOf(vCountChangedSub);
//                //######################    Add 111218 end 5      #######################
//
//			} else if (vLabel.equals("2")) {
//				vNum2 = String.valueOf(vCount);
//				vNum2Chg = String.valueOf(plusMinusNF.format(vCountChanged));
//
//                //######################    Add 111218 start 6    #######################
//                vNum2ChgAdd = String.valueOf(vCountChangedAdd);
//                vNum2ChgSub = String.valueOf(vCountChangedSub);
//                //######################    Add 111218 end 6      #######################
//
//			}
//		}
//
//		paramsDoc.put("vNum1", vNum1);
//		paramsDoc.put("vNum1Chg", vNum1Chg);
//		paramsDoc.put("vNum2", vNum2);
//		paramsDoc.put("vNum2Chg", vNum2Chg);
//
//        //######################    Add 111218 start 7    #######################
//        paramsDoc.put("vNum1ChgAdd", vNum1ChgAdd);
//        paramsDoc.put("vNum1ChgSub", vNum1ChgSub);
//        paramsDoc.put("vNum2ChgAdd", vNum2ChgAdd);
//        paramsDoc.put("vNum2ChgSub", vNum2ChgSub);
//        //######################    Add 111218 end 7      #######################
//
//		String eNumGroup = "N/A";
//		String eNumGroupChg = "N/A";
//		String eNumInve = "N/A";
//		String eNumInveChg = "N/A";
//		String eNumTx = "N/A";
//		String eNumTxChg = "N/A";
//		String eNumTrade = "N/A";
//		String eNumTradeChg = "N/A";
//		String eNumHoder = "N/A";
//		String eNumHoderChg = "N/A";
//		String eNumThird = "N/A";
//		String eNumThirdChg = "N/A";
//		String eNumGuar = "N/A";
//		String eNumGuarChg = "N/A";
//		String eNumManager = "N/A";
//		String eNumManagerChg = "N/A";
//		String eNumOther = "N/A";
//		String eNumOtherChg = "N/A";
//
//        //######################    Add 111218 start 8    #######################
//        String eNumGroupChgAdd = "N/A";
//        String eNumInveChgAdd = "N/A";
//        String eNumTxChgAdd = "N/A";
//        String eNumTradeChgAdd = "N/A";
//        String eNumHoderChgAdd = "N/A";
//        String eNumThirdChgAdd = "N/A";
//        String eNumGuarChgAdd = "N/A";
//        String eNumManagerChgAdd = "N/A";
//        String eNumOtherChgAdd = "N/A";
//        String eNumGroupChgSub = "N/A";
//        String eNumInveChgSub = "N/A";
//        String eNumTxChgSub = "N/A";
//        String eNumTradeChgSub = "N/A";
//        String eNumHoderChgSub = "N/A";
//        String eNumThirdChgSub = "N/A";
//        String eNumGuarChgSub = "N/A";
//        String eNumManagerChgSub = "N/A";
//        String eNumOtherChgSub = "N/A";
//        //######################    Add 111218 end 8      #######################
//
//		for (LabelCount e : edge_changes) {
//			String eLabel = e.getLabel();
//			int eCount = e.getCount();
//			int eCountChanged = e.getCount_changed();
//
//            //######################    Add 111218 start 9    #######################
//            int eCountChangedAdd = e.getCount_changed_add();
//            int eCountChangedSub = e.getCount_changed_minus();
//            //######################    Add 111218 end 9      #######################
//
//			switch (eLabel) {
//			case "GROUP":
//				eNumGroup = String.valueOf(eCount);
//				eNumGroupChg = String.valueOf(plusMinusNF.format(eCountChanged));
//
//                    //######################    Add 111218 start 10    #######################
//                    eNumGroupChgAdd = String.valueOf(eCountChangedAdd);
//                    eNumGroupChgSub = String.valueOf(eCountChangedSub);
//                    //######################    Add 111218 end 10      #######################
//
//				break;
//			case "INVE":
//				eNumInve = String.valueOf(eCount);
//				eNumInveChg = String.valueOf(plusMinusNF.format(eCountChanged));
//
//                    //######################    Add 111218 start 11    #######################
//                    eNumInveChgAdd = String.valueOf(eCountChangedAdd);
//                    eNumInveChgSub = String.valueOf(eCountChangedSub);
//                    //######################    Add 111218 end 11      #######################
//
//				break;
//			case "TX":
//				eNumTx = String.valueOf(eCount);
//				eNumTxChg = String.valueOf(plusMinusNF.format(eCountChanged));
//
//                    //######################    Add 111218 start 12    #######################
//                    eNumTxChgAdd = String.valueOf(eCountChangedAdd);
//                    eNumTxChgSub = String.valueOf(eCountChangedSub);
//                    //######################    Add 111218 end 12      #######################
//
//				break;
//			case "TRADE":
//				eNumTrade = String.valueOf(eCount);
//				eNumTradeChg = String.valueOf(plusMinusNF.format(eCountChanged));
//
//                    //######################    Add 111218 start 13    #######################
//                    eNumTradeChgAdd = String.valueOf(eCountChangedAdd);
//                    eNumTradeChgSub = String.valueOf(eCountChangedSub);
//                    //######################    Add 111218 end 13      #######################
//
//				break;
//			case "SAME_CARD_HOLDER":
//				eNumHoder = String.valueOf(eCount);
//				eNumHoderChg = String.valueOf(plusMinusNF.format(eCountChanged));
//
//                    //######################    Add 111218 start 14    #######################
//                    eNumHoderChgAdd = String.valueOf(eCountChangedAdd);
//                    eNumHoderChgSub = String.valueOf(eCountChangedSub);
//                    //######################    Add 111218 end 14      #######################
//
//				break;
//			case "THIRD_PARTY_GUAR":
//				eNumThird = String.valueOf(eCount);
//				eNumThirdChg = String.valueOf(plusMinusNF.format(eCountChanged));
//
//                    //######################    Add 111218 start 15    #######################
//                    eNumThirdChgAdd = String.valueOf(eCountChangedAdd);
//                    eNumThirdChgSub = String.valueOf(eCountChangedSub);
//                    //######################    Add 111218 end 15      #######################
//
//				break;
//			case "GUAR":
//				eNumGuar = String.valueOf(eCount);
//				eNumGuarChg = String.valueOf(plusMinusNF.format(eCountChanged));
//
//                    //######################    Add 111218 start 16    #######################
//                    eNumGuarChgAdd = String.valueOf(eCountChangedAdd);
//                    eNumGuarChgSub = String.valueOf(eCountChangedSub);
//                    //######################    Add 111218 end 16      #######################
//
//				break;
//			case "MANAGER":
//				eNumManager = String.valueOf(eCount);
//				eNumManagerChg = String.valueOf(plusMinusNF.format(eCountChanged));
//
//                    //######################    Add 111218 start 17    #######################
//                    eNumManagerChgAdd = String.valueOf(eCountChangedAdd);
//                    eNumManagerChgSub = String.valueOf(eCountChangedSub);
//                    //######################    Add 111218 end 17      #######################
//
//				break;
//			case "OTHER":
//				eNumOther = String.valueOf(eCount);
//				eNumOtherChg = String.valueOf(plusMinusNF.format(eCountChanged));
//
//                    //######################    Add 111218 start 18    #######################
//                    eNumOtherChgAdd = String.valueOf(eCountChangedAdd);
//                    eNumOtherChgSub = String.valueOf(eCountChangedSub);
//                    //######################    Add 111218 end 18      #######################
//
//				break;
//			}
//		}
//
//		paramsDoc.put("eNumGroup", eNumGroup);
//		paramsDoc.put("eNumGroupChg", eNumGroupChg);
//		paramsDoc.put("eNumInve", eNumInve);
//		paramsDoc.put("eNumInveChg", eNumInveChg);
//		paramsDoc.put("eNumTx", eNumTx);
//		paramsDoc.put("eNumTxChg", eNumTxChg);
//		paramsDoc.put("eNumTrade", eNumTrade);
//		paramsDoc.put("eNumTradeChg", eNumTradeChg);
//		paramsDoc.put("eNumHoder", eNumHoder);
//		paramsDoc.put("eNumHoderChg", eNumHoderChg);
//		paramsDoc.put("eNumThird", eNumThird);
//		paramsDoc.put("eNumThirdChg", eNumThirdChg);
//		paramsDoc.put("eNumGuar", eNumGuar);
//		paramsDoc.put("eNumGuarChg", eNumGuarChg);
//		paramsDoc.put("eNumManager", eNumManager);
//		paramsDoc.put("eNumManagerChg", eNumManagerChg);
//		paramsDoc.put("eNumOther", eNumOther);
//		paramsDoc.put("eNumOtherChg", eNumOtherChg);
//
//        //######################    Add 111218 start 19    #######################
//        paramsDoc.put("eNumGroupChgAdd", eNumGroupChgAdd);
//        paramsDoc.put("eNumInveChgAdd", eNumInveChgAdd);
//        paramsDoc.put("eNumTxChgAdd", eNumTxChgAdd);
//        paramsDoc.put("eNumTradeChgAdd", eNumTradeChgAdd);
//        paramsDoc.put("eNumHoderChgAdd", eNumHoderChgAdd);
//        paramsDoc.put("eNumThirdChgAdd", eNumThirdChgAdd);
//        paramsDoc.put("eNumGuarChgAdd", eNumGuarChgAdd);
//        paramsDoc.put("eNumManagerChgAdd", eNumManagerChgAdd);
//        paramsDoc.put("eNumOtherChgAdd", eNumOtherChgAdd);
//        paramsDoc.put("eNumGroupChgSub", eNumGroupChgSub);
//        paramsDoc.put("eNumInveChgSub", eNumInveChgSub);
//        paramsDoc.put("eNumTxChgSub", eNumTxChgSub);
//        paramsDoc.put("eNumTradeChgSub", eNumTradeChgSub);
//        paramsDoc.put("eNumHoderChgSub", eNumHoderChgSub);
//        paramsDoc.put("eNumThirdChgSub", eNumThirdChgSub);
//        paramsDoc.put("eNumGuarChgSub", eNumGuarChgSub);
//        paramsDoc.put("eNumManagerChgSub", eNumManagerChgSub);
//        paramsDoc.put("eNumOtherChgSub", eNumOtherChgSub);
//        //######################    Add 111218 end 19      #######################
//
//		List<EdgeInfo> changed_edges_details = new ArrayList<>(data.getChanged_edges());
//
//		paramsXls.put("tables", changed_edges_details);
//
//		// Map<String, Object> params = new HashMap<>();
//
//		params.putAll(paramsDoc);
//		params.putAll(paramsXls);
//
//		compileTemplate(xlsTempPath, params, fullXlsFn);
//		String docTempPath = "/dyna_chart/Report_doc.ftl";
//		String fullDocFn = fileStoreUtils.getTempAbsFilePath(REPORT_FOLDER + fileName + ".doc");
//		compileTemplate(docTempPath, params, fullDocFn);
//		params.clear();
//		params.put("docFilePath", fileStoreUtils.getRelativeFilePath(fullDocFn));
//		params.put("xlsFilePath", fileStoreUtils.getRelativeFilePath(fullXlsFn));
//		return params;
//	}
//
//	public void compileTemplate(String templateUri, Map<String, Object> params, String fileName)
//			throws I18nAppException {
//		try {
//
//			File file = new File(fileName);
//			if (!file.getParentFile().exists()) {
//				file.getParentFile().mkdirs();
//			}
//			Writer writer = new BufferedWriter(new FileWriter(file));
//			Template temp = freeMarkerConfigurer.getConfiguration().getTemplate(templateUri);
//			temp.process(params, writer);
//			writer.flush();
//			writer.close();
//		} catch (IOException e) {
//			logger.error("Should never come here.", e);
//			throw new I18nAppException("MAIL_TEMPLATE_ERROR", new String[] { e.getMessage() }, e.getMessage(), e);
//		} catch (Exception e) {
//			logger.error("The tempate error:", e);
//			throw new I18nAppException("MAIL_TEMPLATE_ERROR", new String[] { e.getMessage() }, e.getMessage(), e);
//		}
//	}
//
//}
