<?xml version="1.0"?>
<?mso-application progid="Excel.Sheet"?>
<Workbook xmlns="urn:schemas-microsoft-com:office:spreadsheet"
 xmlns:o="urn:schemas-microsoft-com:office:office"
 xmlns:x="urn:schemas-microsoft-com:office:excel"
 xmlns:ss="urn:schemas-microsoft-com:office:spreadsheet"
 xmlns:html="http://www.w3.org/TR/REC-html40">
 <DocumentProperties xmlns="urn:schemas-microsoft-com:office:office">
  <Author>Vibrio H</Author>
  <LastAuthor>Vibrio H</LastAuthor>
  <Created>2018-11-14T16:59:09Z</Created>
  <LastSaved>2018-11-14T17:08:17Z</LastSaved>
  <Version>16.00</Version>
 </DocumentProperties>
 <OfficeDocumentSettings xmlns="urn:schemas-microsoft-com:office:office">
  <AllowPNG/>
 </OfficeDocumentSettings>
 <ExcelWorkbook xmlns="urn:schemas-microsoft-com:office:excel">
  <WindowHeight>12165</WindowHeight>
  <WindowWidth>28800</WindowWidth>
  <WindowTopX>32760</WindowTopX>
  <WindowTopY>32760</WindowTopY>
  <ProtectStructure>False</ProtectStructure>
  <ProtectWindows>False</ProtectWindows>
 </ExcelWorkbook>
 <Styles>
  <Style ss:ID="Default" ss:Name="Normal">
   <Alignment ss:Vertical="Bottom"/>
   <Borders/>
   <Font ss:FontName="Calibri" x:Family="Swiss" ss:Size="11" ss:Color="#000000"/>
   <Interior/>
   <NumberFormat/>
   <Protection/>
  </Style>
  <Style ss:ID="s62">
   <Alignment ss:Horizontal="Center" ss:Vertical="Center"/>
  </Style>
 </Styles>
 <Worksheet ss:Name="Sheet1">
  <Table ss:ExpandedColumnCount="11" ss:ExpandedRowCount="2" x:FullColumns="1"
   x:FullRows="1" ss:StyleID="s62" ss:DefaultRowHeight="15">
   <Column ss:StyleID="s62" ss:Width="27.75"/>
   <Column ss:StyleID="s62" ss:Width="73.5"/>
   <Column ss:StyleID="s62" ss:Width="50.25" ss:Span="1"/>
   <Column ss:Index="5" ss:StyleID="s62" ss:Width="73.5" ss:Span="2"/>
   <Column ss:Index="8" ss:StyleID="s62" ss:Width="96.75"/>
   <Column ss:StyleID="s62" ss:Width="50.25" ss:Span="1"/>
   <Column ss:Index="11" ss:StyleID="s62" ss:Width="73.5"/>
   <Row>
    <Cell><Data ss:Type="String">序号</Data></Cell>
    <Cell><Data ss:Type="String">发生变化时间</Data></Cell>
    <Cell><Data ss:Type="String">客户代码</Data></Cell>
    <Cell><Data ss:Type="String">客户名称</Data></Cell>
    <Cell><Data ss:Type="String">客户变化标志</Data></Cell>
    <Cell><Data ss:Type="String">关联客户代码</Data></Cell>
    <Cell><Data ss:Type="String">关联客户名称</Data></Cell>
    <Cell><Data ss:Type="String">关联客户变化标志</Data></Cell>
    <Cell><Data ss:Type="String">关联程度</Data></Cell>
    <Cell><Data ss:Type="String">关系类型</Data></Cell>
    <Cell><Data ss:Type="String">关系变化标志</Data></Cell>
   </Row>
<#list tables as tbl>
   <Row>
    <Cell><Data ss:Type="String">${tbl.seq_num}</Data></Cell>
    <Cell><Data ss:Type="String">${tbl.date_changed}</Data></Cell>
    <Cell><Data ss:Type="String">${tbl.source_id}</Data></Cell>
    <Cell><Data ss:Type="String">${tbl.source_name}</Data></Cell>
    <Cell><Data ss:Type="String">${tbl.source_status}</Data></Cell>
    <Cell><Data ss:Type="String">${tbl.target_id}</Data></Cell>
    <Cell><Data ss:Type="String">${tbl.target_name}</Data></Cell>
    <Cell><Data ss:Type="String">${tbl.target_status}</Data></Cell>
    <Cell><Data ss:Type="String">${tbl.main_rela}</Data></Cell>
    <Cell><Data ss:Type="String">${tbl.edge_label}</Data></Cell>
    <Cell><Data ss:Type="String">${tbl.edge_status}</Data></Cell>
   </Row>
</#list>
  </Table>
  <WorksheetOptions xmlns="urn:schemas-microsoft-com:office:excel">
   <PageSetup>
    <Header x:Margin="0.3"/>
    <Footer x:Margin="0.3"/>
    <PageMargins x:Bottom="0.75" x:Left="0.7" x:Right="0.7" x:Top="0.75"/>
   </PageSetup>
   <Print>
    <ValidPrinterInfo/>
    <HorizontalResolution>600</HorizontalResolution>
    <VerticalResolution>600</VerticalResolution>
   </Print>
   <Selected/>
   <Panes>
    <Pane>
     <Number>3</Number>
     <ActiveRow>7</ActiveRow>
     <ActiveCol>7</ActiveCol>
    </Pane>
   </Panes>
   <ProtectObjects>False</ProtectObjects>
   <ProtectScenarios>False</ProtectScenarios>
  </WorksheetOptions>
 </Worksheet>
</Workbook>
