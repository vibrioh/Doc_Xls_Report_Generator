import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.TemplateException;
import vo.Report;

import java.io.IOException;
import java.util.Map;

public class test {

    public static void main(String args[]) throws IOException, TemplateException {
        ReportRequest report = new ReportRequest();

        ObjectMapper om = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String testJson = "{\n" +
                "  \"report\": {\n" +
                "    \"statistics\": {\n" +
                "      \"num_vertices\": 17,\n" +
                "      \"num_edges\": 30,\n" +
                "      \"num_vertices_changed\": 7,\n" +
                "      \"num_edges_changed\": -5,\n" +
                "      \"num_vertices_changed_add\": 999,\n" +
                "      \"num_edges_changed_add\": 999,\n" +
                "      \"num_vertices_changed_minus\": 999,\n" +
                "      \"num_edges_changed_minus\": 999,\n" +
                "      \"cust_name\": \"33\",\n" +
                "      \"cino\": \"missing\",\n" +
                "      \"group_id\": \"missing\",\n" +
                "      \"group_name\": \"missing\",\n" +
                "      \"start_date\": \"20180301\",\n" +
                "      \"end_date\": \"20180307\",\n" +
                "      \"vertices_changes_by_label\": [\n" +
                "        {\n" +
                "          \"label\": \"1\",\n" +
                "          \"count\": 16,\n" +
                "          \"count_changed\": 7,\n" +
                "          \"count_changed_add\": 999,\n" +
                "          \"count_changed_minus\": 999\n" +
                "        },\n" +
                "        {\n" +
                "          \"label\": \"2\",\n" +
                "          \"count\": 1,\n" +
                "          \"count_changed\": -7,\n" +
                "          \"count_changed_add\": 999,\n" +
                "          \"count_changed_minus\": 999\n" +
                "        }\n" +
                "      ],\n" +
                "      \"edge_changes_by_label\": [\n" +
                "        {\n" +
                "          \"label\": \"GROUP\",\n" +
                "          \"count\": 0,\n" +
                "          \"count_changed\": 5,\n" +
                "          \"count_changed_add\": 999,\n" +
                "          \"count_changed_minus\": 999\n" +
                "        },\n" +
                "        {\n" +
                "          \"label\": \"INVE\",\n" +
                "          \"count\": 12,\n" +
                "          \"count_changed\": -5,\n" +
                "          \"count_changed_add\": 999,\n" +
                "          \"count_changed_minus\": 999\n" +
                "        },\n" +
                "        {\n" +
                "          \"label\": \"TX\",\n" +
                "          \"count\": 3,\n" +
                "          \"count_changed\": 4,\n" +
                "          \"count_changed_add\": 999,\n" +
                "          \"count_changed_minus\": 999\n" +
                "        },\n" +
                "        {\n" +
                "          \"label\": \"TRADE\",\n" +
                "          \"count\": 2,\n" +
                "          \"count_changed\": -4,\n" +
                "          \"count_changed_add\": 999,\n" +
                "          \"count_changed_minus\": 999\n" +
                "        },\n" +
                "        {\n" +
                "          \"label\": \"SAME_CARD_HOLDER\",\n" +
                "          \"count\": 0,\n" +
                "          \"count_changed\": 3,\n" +
                "          \"count_changed_add\": 999,\n" +
                "          \"count_changed_minus\": 999\n" +
                "        },\n" +
                "        {\n" +
                "          \"label\": \"THIRD_PARTY_GUAR\",\n" +
                "          \"count\": 1,\n" +
                "          \"count_changed\": -3,\n" +
                "          \"count_changed_add\": 999,\n" +
                "          \"count_changed_minus\": 999\n" +
                "        },\n" +
                "        {\n" +
                "          \"label\": \"GUAR\",\n" +
                "          \"count\": 2,\n" +
                "          \"count_changed\": 2,\n" +
                "          \"count_changed_add\": 999,\n" +
                "          \"count_changed_minus\": 999\n" +
                "        },\n" +
                "        {\n" +
                "          \"label\": \"MANAGER\",\n" +
                "          \"count\": 4,\n" +
                "          \"count_changed\": -1,\n" +
                "          \"count_changed_add\": 999,\n" +
                "          \"count_changed_minus\": 999\n" +
                "        },\n" +
                "        {\n" +
                "          \"label\": \"OTHER\",\n" +
                "          \"count\": 6,\n" +
                "          \"count_changed\": 0,\n" +
                "          \"count_changed_add\": 999,\n" +
                "          \"count_changed_minus\": 999\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    \"data\": {\n" +
                "      \"changed_edges\": [\n" +
                "        {\n" +
                "          \"seq_num\": \"1\",\n" +
                "          \"date_changed\": \"20180307\",\n" +
                "          \"source_id\": \"n3\",\n" +
                "          \"target_id\": \"n33\",\n" +
                "          \"source_status\": \"新增\",\n" +
                "          \"target_status\": \"不变\",\n" +
                "          \"source_name\": \"同兴万点传媒有限公司\",\n" +
                "          \"target_name\": \"天益传媒有限公司\",\n" +
                "          \"main_rela\": \"其他\",\n" +
                "          \"edge_status\": \"支持\",\n" +
                "          \"edge_label\": \"SPOUSE\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"seq_num\": \"2\",\n" +
                "          \"date_changed\": \"20180307\",\n" +
                "          \"source_id\": \"n5\",\n" +
                "          \"target_id\": \"n33\",\n" +
                "          \"source_status\": \"新增\",\n" +
                "          \"target_status\": \"不变\",\n" +
                "          \"source_name\": \"佳禾传媒有限公司\",\n" +
                "          \"target_name\": \"天益传媒有限公司\",\n" +
                "          \"main_rela\": \"其他\",\n" +
                "          \"edge_status\": \"支持\",\n" +
                "          \"edge_label\": \"BACKUP1\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"seq_num\": \"3\",\n" +
                "          \"date_changed\": \"20180307\",\n" +
                "          \"source_id\": \"n33\",\n" +
                "          \"target_id\": \"n34\",\n" +
                "          \"source_status\": \"不变\",\n" +
                "          \"target_status\": \"新增\",\n" +
                "          \"source_name\": \"天益传媒有限公司\",\n" +
                "          \"target_name\": \"开发区世创网络有限公司\",\n" +
                "          \"main_rela\": \"其他\",\n" +
                "          \"edge_status\": \"支持\",\n" +
                "          \"edge_label\": \"BACKUP1\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"seq_num\": \"4\",\n" +
                "          \"date_changed\": \"20180307\",\n" +
                "          \"source_id\": \"n28\",\n" +
                "          \"target_id\": \"n33\",\n" +
                "          \"source_status\": \"不变\",\n" +
                "          \"target_status\": \"不变\",\n" +
                "          \"source_name\": \"我是谁\",\n" +
                "          \"target_name\": \"天益传媒有限公司\",\n" +
                "          \"main_rela\": \"保证\",\n" +
                "          \"edge_status\": \"支持\",\n" +
                "          \"edge_label\": \"JOINT_GUAR\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"seq_num\": \"5\",\n" +
                "          \"date_changed\": \"20180307\",\n" +
                "          \"source_id\": \"n33\",\n" +
                "          \"target_id\": \"n3\",\n" +
                "          \"source_status\": \"不变\",\n" +
                "          \"target_status\": \"新增\",\n" +
                "          \"source_name\": \"天益传媒有限公司\",\n" +
                "          \"target_name\": \"同兴万点传媒有限公司\",\n" +
                "          \"main_rela\": \"保证\",\n" +
                "          \"edge_status\": \"支持\",\n" +
                "          \"edge_label\": \"JOINT_GUAR\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"seq_num\": \"6\",\n" +
                "          \"date_changed\": \"20180307\",\n" +
                "          \"source_id\": \"n25\",\n" +
                "          \"target_id\": \"n33\",\n" +
                "          \"source_status\": \"不变\",\n" +
                "          \"target_status\": \"不变\",\n" +
                "          \"source_name\": \"九方传媒有限公司\",\n" +
                "          \"target_name\": \"天益传媒有限公司\",\n" +
                "          \"main_rela\": \"资金\",\n" +
                "          \"edge_status\": \"支持\",\n" +
                "          \"edge_label\": \"INV_TOPNONCONTROL\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"seq_num\": \"7\",\n" +
                "          \"date_changed\": \"20180307\",\n" +
                "          \"source_id\": \"n28\",\n" +
                "          \"target_id\": \"n33\",\n" +
                "          \"source_status\": \"不变\",\n" +
                "          \"target_status\": \"不变\",\n" +
                "          \"source_name\": \"\",\n" +
                "          \"target_name\": \"天益传媒有限公司\",\n" +
                "          \"main_rela\": \"资金\",\n" +
                "          \"edge_status\": \"支持\",\n" +
                "          \"edge_label\": \"INV_CONTROL\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"seq_num\": \"8\",\n" +
                "          \"date_changed\": \"20180307\",\n" +
                "          \"source_id\": \"n46\",\n" +
                "          \"target_id\": \"n34\",\n" +
                "          \"source_status\": \"新增\",\n" +
                "          \"target_status\": \"新增\",\n" +
                "          \"source_name\": \"黄石金承科技有限公司\",\n" +
                "          \"target_name\": \"开发区世创网络有限公司\",\n" +
                "          \"main_rela\": \"股权\",\n" +
                "          \"edge_status\": \"支持\",\n" +
                "          \"edge_label\": \"TX\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"seq_num\": \"9\",\n" +
                "          \"date_changed\": \"20180307\",\n" +
                "          \"source_id\": \"n34\",\n" +
                "          \"target_id\": \"n41\",\n" +
                "          \"source_status\": \"新增\",\n" +
                "          \"target_status\": \"不变\",\n" +
                "          \"source_name\": \"开发区世创网络有限公司\",\n" +
                "          \"target_name\": \"群英科技有限公司\",\n" +
                "          \"main_rela\": \"股权\",\n" +
                "          \"edge_status\": \"支持\",\n" +
                "          \"edge_label\": \"TX\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"seq_num\": \"10\",\n" +
                "          \"date_changed\": \"20180307\",\n" +
                "          \"source_id\": \"n41\",\n" +
                "          \"target_id\": \"n46\",\n" +
                "          \"source_status\": \"不变\",\n" +
                "          \"target_status\": \"新增\",\n" +
                "          \"source_name\": \"群英科技有限公司\",\n" +
                "          \"target_name\": \"黄石金承科技有限公司\",\n" +
                "          \"main_rela\": \"股权\",\n" +
                "          \"edge_status\": \"支持\",\n" +
                "          \"edge_label\": \"TX\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"seq_num\": \"11\",\n" +
                "          \"date_changed\": \"20180307\",\n" +
                "          \"source_id\": \"n25\",\n" +
                "          \"target_id\": \"n47\",\n" +
                "          \"source_status\": \"不变\",\n" +
                "          \"target_status\": \"新增\",\n" +
                "          \"source_name\": \"九方传媒有限公司\",\n" +
                "          \"target_name\": \"诺依曼软件传媒有限公司\",\n" +
                "          \"main_rela\": \"股权\",\n" +
                "          \"edge_status\": \"支持\",\n" +
                "          \"edge_label\": \"TX\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"seq_num\": \"12\",\n" +
                "          \"date_changed\": \"20180307\",\n" +
                "          \"source_id\": \"n47\",\n" +
                "          \"target_id\": \"n14\",\n" +
                "          \"source_status\": \"新增\",\n" +
                "          \"target_status\": \"新增\",\n" +
                "          \"source_name\": \"诺依曼软件传媒有限公司\",\n" +
                "          \"target_name\": \"和泰科技有限公司\",\n" +
                "          \"main_rela\": \"股权\",\n" +
                "          \"edge_status\": \"支持\",\n" +
                "          \"edge_label\": \"TX\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"seq_num\": \"13\",\n" +
                "          \"date_changed\": \"20180307\",\n" +
                "          \"source_id\": \"n14\",\n" +
                "          \"target_id\": \"n31\",\n" +
                "          \"source_status\": \"新增\",\n" +
                "          \"target_status\": \"新增\",\n" +
                "          \"source_name\": \"和泰科技有限公司\",\n" +
                "          \"target_name\": \"开发区世创网络有限公司\",\n" +
                "          \"main_rela\": \"股权\",\n" +
                "          \"edge_status\": \"支持\",\n" +
                "          \"edge_label\": \"TX\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"seq_num\": \"14\",\n" +
                "          \"date_changed\": \"20180307\",\n" +
                "          \"source_id\": \"n31\",\n" +
                "          \"target_id\": \"n25\",\n" +
                "          \"source_status\": \"新增\",\n" +
                "          \"target_status\": \"不变\",\n" +
                "          \"source_name\": \"开发区世创网络有限公司\",\n" +
                "          \"target_name\": \"九方传媒有限公司\",\n" +
                "          \"main_rela\": \"股权\",\n" +
                "          \"edge_status\": \"支持\",\n" +
                "          \"edge_label\": \"TX\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"seq_num\": \"15\",\n" +
                "          \"date_changed\": \"20180307\",\n" +
                "          \"source_id\": \"n18\",\n" +
                "          \"target_id\": \"n33\",\n" +
                "          \"source_status\": \"不变\",\n" +
                "          \"target_status\": \"不变\",\n" +
                "          \"source_name\": \"时空盒数字网络有限公司\",\n" +
                "          \"target_name\": \"天益传媒有限公司\",\n" +
                "          \"main_rela\": \"人员\",\n" +
                "          \"edge_status\": \"支持\",\n" +
                "          \"edge_label\": \"CORP_TWO_LEGAL_PERSON\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"seq_num\": \"16\",\n" +
                "          \"date_changed\": \"20180307\",\n" +
                "          \"source_id\": \"n9\",\n" +
                "          \"target_id\": \"n33\",\n" +
                "          \"source_status\": \"不变\",\n" +
                "          \"target_status\": \"不变\",\n" +
                "          \"source_name\": \"联通时科信息有限公司\",\n" +
                "          \"target_name\": \"天益传媒有限公司\",\n" +
                "          \"main_rela\": \"人员\",\n" +
                "          \"edge_status\": \"支持\",\n" +
                "          \"edge_label\": \"CORP_TWO_LEGAL_PERSON\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"seq_num\": \"17\",\n" +
                "          \"date_changed\": \"20180307\",\n" +
                "          \"source_id\": \"n4\",\n" +
                "          \"target_id\": \"n33\",\n" +
                "          \"source_status\": \"不变\",\n" +
                "          \"target_status\": \"不变\",\n" +
                "          \"source_name\": \"\",\n" +
                "          \"target_name\": \"天益传媒有限公司\",\n" +
                "          \"main_rela\": \"第三方抵押\",\n" +
                "          \"edge_status\": \"支持\",\n" +
                "          \"edge_label\": \"CORP_THIRD_PARTY\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"seq_num\": \"18\",\n" +
                "          \"date_changed\": \"20180307\",\n" +
                "          \"source_id\": \"n19\",\n" +
                "          \"target_id\": \"n33\",\n" +
                "          \"source_status\": \"不变\",\n" +
                "          \"target_status\": \"不变\",\n" +
                "          \"source_name\": \"南康信息有限公司\",\n" +
                "          \"target_name\": \"天益传媒有限公司\",\n" +
                "          \"main_rela\": \"贸易\",\n" +
                "          \"edge_status\": \"支持\",\n" +
                "          \"edge_label\": \"LOC\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  }\n" +
                "}";
        Report readJson = om.readValue(testJson, Report.class);
        Map<String, Object> result = report.getReport(readJson);

        for (String name : result.keySet()) {

            String value = result.get(name).toString();
            System.out.println(name + " " + value);


        }
    }
}
