import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import vo.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportRequest {

    public Map<String, Object> getReport(Report rep) throws IOException, TemplateException {

        HashMap<String, Object> paramsDoc = new HashMap<>();
        HashMap<String, Object> paramsXls = new HashMap<>();



        String dataDate = "USE SYSTEM";

        ReportContent repCon = rep.getReport();

        StatisticsContent statistics = repCon.getStatistics();
        DataContent data = repCon.getData();

//        String dataDate = statistics.getData_date();
        String cino = statistics.getCino();
        String custName = statistics.getCust_name();
        String groupID = statistics.getGroup_id();
        String groupName = statistics.getGroup_name();
        String startDate = statistics.getStart_date();
        String endDate = statistics.getEnd_date();
        String vNumAll = String.valueOf(statistics.getNum_vertices());
        String eNumAll = String.valueOf(statistics.getNum_edges());
        String vNumAllChg = String.valueOf(statistics.getNum_vertices_changed());
        String eNumAllChg = String.valueOf(statistics.getNum_edges_changed());

        paramsDoc.put("dataDate", "使用系统中的日期");
        paramsDoc.put("cino", cino);
        paramsDoc.put("custName", custName);
        paramsDoc.put("groupID", groupID);
        paramsDoc.put("groupName", groupName);
        paramsDoc.put("startDate", startDate);
        paramsDoc.put("endDate", endDate);
        paramsDoc.put("vNumAll", vNumAll);
        paramsDoc.put("eNumAll", eNumAll);
        paramsDoc.put("vNumAllChg", vNumAllChg);
        paramsDoc.put("eNumAllChg", eNumAllChg);

        List<LabelCount> vertices_changes = statistics.getVertices_changes_by_label();
        List<LabelCount> edge_changes = statistics.getEdge_changes_by_label();
        String vNum1 = "Missing";
        String vNum1Chg = "Missing";
        String vNum2 = "Missing";
        String vNum2Chg = "Missing";

        for (LabelCount v : vertices_changes) {
            String vLabel = v.getLabel();
            int vCount = v.getCount();
            int vCountChanged = v.getCount_changed();

            System.out.println(vLabel);

            if (vLabel.equals("1")) {
                vNum1 = String.valueOf(vCount);
                vNum1Chg = String.valueOf(vCountChanged);
            } else if (vLabel.equals("2")) {
                vNum2 = String.valueOf(vCount);
                vNum2Chg = String.valueOf(vCountChanged);
            }
        }

        paramsDoc.put("vNum1", vNum1);
        paramsDoc.put("vNum1Chg", vNum1Chg);
        paramsDoc.put("vNum2", vNum2);
        paramsDoc.put("vNum2Chg", vNum2Chg);

        String eNumGroup = "Missing";
        String eNumGroupChg = "Missing";
        String eNumInve = "Missing";
        String eNumInveChg = "Missing";
        String eNumTx = "Missing";
        String eNumTxChg = "Missing";
        String eNumTrade = "Missing";
        String eNumTradeChg = "Missing";
        String eNumHoder = "Missing";
        String eNumHoderChg = "Missing";
        String eNumThird = "Missing";
        String eNumThirdChg = "Missing";
        String eNumGuar = "Missing";
        String eNumGuarChg = "Missing";
        String eNumManager = "Missing";
        String eNumManagerChg = "Missing";
        String eNumOther = "Missing";
        String eNumOtherChg = "Missing";

        for (LabelCount e : edge_changes) {
            String eLabel = e.getLabel();
            int eCount = e.getCount();
            int eCountChanged = e.getCount_changed();
            switch (eLabel) {
                case "GROUP":
                    eNumGroup = String.valueOf(eCount);
                    eNumGroupChg = String.valueOf(eCountChanged);
                    break;
                case "INVE":
                    eNumInve = String.valueOf(eCount);
                    eNumInveChg = String.valueOf(eCountChanged);
                    break;
                case "TX":
                    eNumTx = String.valueOf(eCount);
                    eNumTxChg = String.valueOf(eCountChanged);
                    break;
                case "TRADE":
                    eNumTrade = String.valueOf(eCount);
                    eNumTradeChg = String.valueOf(eCountChanged);
                    break;
                case "SAME_CARD_HOLDER":
                    eNumHoder = String.valueOf(eCount);
                    eNumHoderChg = String.valueOf(eCountChanged);
                    break;
                case "THIRD_PARTY_GUAR":
                    eNumThird = String.valueOf(eCount);
                    eNumThirdChg = String.valueOf(eCountChanged);
                    break;
                case "GUAR":
                    eNumGuar = String.valueOf(eCount);
                    eNumGuarChg = String.valueOf(eCountChanged);
                    break;
                case "MANAGER":
                    eNumManager = String.valueOf(eCount);
                    eNumManagerChg = String.valueOf(eCountChanged);
                    break;
                case "OTHER":
                    eNumOther = String.valueOf(eCount);
                    eNumOtherChg = String.valueOf(eCountChanged);
                    break;
            }
        }

        paramsDoc.put("eNumGroup", eNumGroup);
        paramsDoc.put("eNumGroupChg", eNumGroupChg);
        paramsDoc.put("eNumInve", eNumInve);
        paramsDoc.put("eNumInveChg", eNumInveChg);
        paramsDoc.put("eNumTx", eNumTx);
        paramsDoc.put("eNumTxChg", eNumTxChg);
        paramsDoc.put("eNumTrade", eNumTrade);
        paramsDoc.put("eNumTradeChg", eNumTradeChg);
        paramsDoc.put("eNumHoder", eNumHoder);
        paramsDoc.put("eNumHoderChg", eNumHoderChg);
        paramsDoc.put("eNumThird", eNumThird);
        paramsDoc.put("eNumThirdChg", eNumThirdChg);
        paramsDoc.put("eNumGuar", eNumGuar);
        paramsDoc.put("eNumGuarChg", eNumGuarChg);
        paramsDoc.put("eNumManager", eNumManager);
        paramsDoc.put("eNumManagerChg", eNumManagerChg);
        paramsDoc.put("eNumOther", eNumOther);
        paramsDoc.put("eNumOtherChg", eNumOtherChg);

        List<EdgeInfo> changed_edges_details = new ArrayList<>(data.getChanged_edges());

        paramsXls.put("tables", changed_edges_details);


        Map<String, Object> params = new HashMap<>();

        params.putAll(paramsDoc);
        params.putAll(paramsXls);


//        for (EdgeInfo e : changed_edges_details) {
//            System.out.println(e.getEdge_status());
//        }


        Configuration cfg = new Configuration(new Version("2.3.28"));

        cfg.setClassForTemplateLoading(ReportRequest.class, "/");
        cfg.setDefaultEncoding("UTF-8");

        Template template = cfg.getTemplate("Report_doc.ftl");

        String fileName = "/Users/junhu/Dropbox/GEN_WORD_REPORT/src/main/resources/关联体变化信息报告.doc";

        File file = new File(fileName);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        System.out.println(file);

        Writer writer = new BufferedWriter(new FileWriter(file));
        template.process(params, writer);
        writer.flush();
        writer.close();



        Configuration cfg2 = new Configuration(new Version("2.3.28"));

        cfg2.setClassForTemplateLoading(ReportRequest.class, "/");
        cfg2.setDefaultEncoding("UTF-8");

        Template template2 = cfg2.getTemplate("Report_xls.ftl");

        String fileName2 = "/Users/junhu/Dropbox/GEN_WORD_REPORT/src/main/resources/关联体变化信息报告附表.xls";

        File file2 = new File(fileName2);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        System.out.println(file);

        Writer writer2 = new BufferedWriter(new FileWriter(file2));
        template2.process(params, writer2);
        writer2.flush();
        writer2.close();

        return params;

    }
}
