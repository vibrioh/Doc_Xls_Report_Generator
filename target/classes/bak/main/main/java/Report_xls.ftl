<?xml version="1.0"?>
<?mso-application progid="Excel.Sheet"?>
<Workbook xmlns="urn:schemas-microsoft-com:office:spreadsheet"
 xmlns:o="urn:schemas-microsoft-com:office:office"
 xmlns:x="urn:schemas-microsoft-com:office:excel"
 xmlns:ss="urn:schemas-microsoft-com:office:spreadsheet"
 xmlns:html="http://www.w3.org/TR/REC-html40">
 <DocumentProperties xmlns="urn:schemas-microsoft-com:office:office">
  <Author>Jun Hu</Author>
  <LastAuthor>Jun Hu</LastAuthor>
  <Created>2018-05-28T10:25:44Z</Created>
  <LastSaved>2018-05-28T10:26:34Z</LastSaved>
  <Version>16.00</Version>
 </DocumentProperties>
 <OfficeDocumentSettings xmlns="urn:schemas-microsoft-com:office:office">
  <AllowPNG/>
 </OfficeDocumentSettings>
 <ExcelWorkbook xmlns="urn:schemas-microsoft-com:office:excel">
  <WindowHeight>17040</WindowHeight>
  <WindowWidth>27600</WindowWidth>
  <WindowTopX>3420</WindowTopX>
  <WindowTopY>3460</WindowTopY>
  <ProtectStructure>False</ProtectStructure>
  <ProtectWindows>False</ProtectWindows>
 </ExcelWorkbook>
 <Styles>
  <Style ss:ID="Default" ss:Name="Normal">
   <Alignment ss:Vertical="Bottom"/>
   <Borders/>
   <Font ss:FontName="Calibri" x:Family="Swiss" ss:Size="12" ss:Color="#000000"/>
   <Interior/>
   <NumberFormat/>
   <Protection/>
  </Style>
  <Style ss:ID="s62">
   <Font ss:FontName="Calibri" x:Family="Swiss" ss:Size="12" ss:Color="#000000"
    ss:Bold="1"/>
  </Style>
  <Style ss:ID="s63">
   <Font ss:FontName="Calibri" x:Family="Swiss" ss:Size="12" ss:Color="#000000"/>
  </Style>
 </Styles>
 <Worksheet ss:Name="Sheet1">
  <Table ss:ExpandedColumnCount="14" ss:ExpandedRowCount="2" x:FullColumns="1"
   x:FullRows="1" ss:DefaultColumnWidth="65" ss:DefaultRowHeight="16">
   <Row>
    <Cell ss:StyleID="s62"><Data ss:Type="String">报告日期</Data></Cell>
    <Cell ss:StyleID="s63"><Data ss:Type="String">核心客户号</Data></Cell>
    <Cell ss:StyleID="s62"><Data ss:Type="String">核心客户名称</Data></Cell>
    <Cell ss:StyleID="s62"><Data ss:Type="String">序号</Data></Cell>
    <Cell ss:StyleID="s62"><Data ss:Type="String">发生变化时间</Data></Cell>
    <Cell ss:StyleID="s62"><Data ss:Type="String">客户代码</Data></Cell>
    <Cell ss:StyleID="s62"><Data ss:Type="String">客户名称</Data></Cell>
    <Cell ss:StyleID="s62"><Data ss:Type="String">客户变化标志</Data></Cell>
    <Cell ss:StyleID="s62"><Data ss:Type="String">关联客户代码</Data></Cell>
    <Cell ss:StyleID="s62"><Data ss:Type="String">关联客户名称</Data></Cell>
    <Cell ss:StyleID="s62"><Data ss:Type="String">关联客户变化标志</Data></Cell>
    <Cell ss:StyleID="s62"><Data ss:Type="String">关联程度</Data></Cell>
    <Cell ss:StyleID="s62"><Data ss:Type="String">关系类型</Data></Cell>
    <Cell ss:StyleID="s62"><Data ss:Type="String">关系变化标志</Data></Cell>
   </Row>
    <#list tables as tbl>
   <Row>
    <Cell ss:StyleID="s63"><Data ss:Type="String">${dataDate}</Data></Cell>
    <Cell ss:StyleID="s63"><Data ss:Type="String">${cino}</Data></Cell>
    <Cell ss:StyleID="s63"><Data ss:Type="String">${custName} </Data></Cell>
    <Cell ss:StyleID="s63"><Data ss:Type="String">${tbl.seq_num}</Data></Cell>
    <Cell ss:StyleID="s63"><Data ss:Type="String">${tbl.date_changed}</Data></Cell>
    <Cell ss:StyleID="s63"><Data ss:Type="String">${tbl.source_id}</Data></Cell>
    <Cell ss:StyleID="s63"><Data ss:Type="String">${tbl.source_name}</Data></Cell>
    <Cell ss:StyleID="s63"><Data ss:Type="String">${tbl.source_status}</Data></Cell>
    <Cell ss:StyleID="s63"><Data ss:Type="String">${tbl.target_id}</Data></Cell>
    <Cell ss:StyleID="s63"><Data ss:Type="String">${tbl.target_name}</Data></Cell>
    <Cell ss:StyleID="s63"><Data ss:Type="String">${tbl.target_status}</Data></Cell>
    <Cell ss:StyleID="s63"><Data ss:Type="String">${tbl.main_rela}</Data></Cell>
    <Cell ss:StyleID="s63"><Data ss:Type="String">${tbl.edge_label}</Data></Cell>
    <Cell ss:StyleID="s63"><Data ss:Type="String">{tbl.edge_status}</Data></Cell>
   </Row>
    </#list>
  </Table>
  <WorksheetOptions xmlns="urn:schemas-microsoft-com:office:excel">
   <PageSetup>
    <Header x:Margin="0.3"/>
    <Footer x:Margin="0.3"/>
    <PageMargins x:Bottom="0.75" x:Left="0.7" x:Right="0.7" x:Top="0.75"/>
   </PageSetup>
   <Selected/>
   <Panes>
    <Pane>
     <Number>3</Number>
     <RangeSelection>R1C1:R2C14</RangeSelection>
    </Pane>
   </Panes>
   <ProtectObjects>False</ProtectObjects>
   <ProtectScenarios>False</ProtectScenarios>
  </WorksheetOptions>
 </Worksheet>
</Workbook>
