import java.awt.Color;
import com.spire.ms.System.DateTime;
import com.spire.xls.*;
import com.spire.xls.core.*;
import com.spire.xls.core.spreadsheet.collections.XlsConditionalFormats;
import com.spire.xls.core.spreadsheet.conditionalformatting.TimePeriodType;

public class variousConditionalFormatting {

	public static void main(String[] args) {
		
        //Load the document from disk
        Workbook workbook = new Workbook();
        //Create a blank sheet
        workbook.createEmptySheets(1);
         //Get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);
        AddConditionalFormattingForNewSheet(sheet);

        String result = "output/variousConditionalFormatting_result.xlsx";
        //Save and Launch
        workbook.saveToFile(result, ExcelVersion.Version2010);
	}

	private static void AddConditionalFormattingForNewSheet(Worksheet sheet) {
		
        AddDefaultIconSet(sheet);
        AddIconSet2(sheet);
        AddIconSet3(sheet);
        AddIconSet4(sheet);
        AddIconSet5(sheet);
        AddIconSet6(sheet);
        AddIconSet7(sheet);
        AddIconSet8(sheet);
        AddIconSet9(sheet);
        AddIconSet10(sheet);
        AddIconSet11(sheet);
        AddIconSet12(sheet);
        AddIconSet13(sheet);
        AddIconSet14(sheet);
        AddIconSet15(sheet);
        AddIconSet16(sheet);
        AddIconSet17(sheet);
        AddIconSet18(sheet);
        AddDefaultColorScale(sheet);
        Add3ColorScale(sheet);
        Add2ColorScale(sheet);
        AddEboveEverage(sheet);
        AddEboveEverage2(sheet);
        AddEboveEverage3(sheet);
        AddTop10_1(sheet);
        AddTop10_2(sheet);
        AddTop10_3(sheet);
        AddTop10_4(sheet);
        AddDataBar1(sheet);
        AddDataBar2(sheet);
        AddContainsText(sheet);
        AddNotContainsText(sheet);
        AddContainsBlank(sheet);
        AddNotContainsBlank(sheet);
        AddBeginWith(sheet);
        AddEndWith(sheet);
        AddContainsError(sheet);
        AddNotContainsError(sheet);
        AddDuplicate(sheet);
        AddUnique(sheet);
        AddTimePeriod_1(sheet);
        AddTimePeriod_2(sheet);
        AddTimePeriod_3(sheet);
        AddTimePeriod_4(sheet);
        AddTimePeriod_5(sheet);
        AddTimePeriod_6(sheet);
        AddTimePeriod_7(sheet);
        AddTimePeriod_8(sheet);
        AddTimePeriod_9(sheet);
        AddTimePeriod_10(sheet);
        sheet.getAllocatedRange().setColumnWidth(15);
        sheet.getAllocatedRange().autoFitRows();
		
	}
	
	//This method implements the TimePeriod conditional formatting type with Yesterday attribute.
	private static void AddTimePeriod_10(Worksheet sheet) {
		XlsConditionalFormats conds = sheet.getConditionalFormats().add();
        conds.addRange(sheet.getCellRange("I19:K20"));
        sheet.getCellRange("I19:K20").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("I19:K20").getStyle().setColor(Color.green);
        IConditionalFormat cf = conds.addTimePeriodCondition(TimePeriodType.Yesterday);
        
        cf.setFillPattern(ExcelPatternType.Solid);
        cf.setBackColor(Color.pink);
        
        sheet.getCellRange("I19").setValue(DateTime.getNow().addDays(-2).getDate().toString());
        sheet.getCellRange("J19").setValue(DateTime.getNow().addDays(-1).getDate().toString());
        sheet.getCellRange("K19").setValue(DateTime.getNow().getDate().toString());
        sheet.getCellRange("I20").setText("Yesterday");
        sheet.getCellRange("J20").setValue(DateTime.getNow().addDays(1).getDate().toString());
        sheet.getCellRange("K20").setValue(DateTime.getNow().addDays(2).getDate().toString());
	
	}

	//This method implements the TimePeriod conditional formatting type with Tomorrow attribute.
	private static void AddTimePeriod_9(Worksheet sheet) {
		XlsConditionalFormats conds = sheet.getConditionalFormats().add();
        conds.addRange(sheet.getCellRange("I17:K18"));
        sheet.getCellRange("I17:K18").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("I17:K18").getStyle().setColor(Color.blue);
        IConditionalFormat cf = conds.addTimePeriodCondition(TimePeriodType.Tomorrow);
        
        cf.setFillPattern(ExcelPatternType.Solid);
        cf.setBackColor(Color.pink);
        
        sheet.getCellRange("I17").setValue(DateTime.getNow().addDays(-2).getDate().toString());
        sheet.getCellRange("J17").setValue(DateTime.getNow().addDays(-1).getDate().toString());
        sheet.getCellRange("K17").setValue(DateTime.getNow().getDate().toString());
        sheet.getCellRange("I18").setText("Tomorrow");
        sheet.getCellRange("J18").setValue(DateTime.getNow().addDays(1).getDate().toString());
        sheet.getCellRange("K18").setValue(DateTime.getNow().addDays(2).getDate().toString());
	
	}

	//This method implements the TimePeriod conditional formatting type with ThisWeek attribute.
	private static void AddTimePeriod_8(Worksheet sheet) {
		XlsConditionalFormats conds = sheet.getConditionalFormats().add();
        conds.addRange(sheet.getCellRange("I15:K16"));
        sheet.getCellRange("I15:K16").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("I15:K16").getStyle().setColor(Color.blue);
        IConditionalFormat cf = conds.addTimePeriodCondition(TimePeriodType.ThisWeek);
        
        cf.setFillPattern(ExcelPatternType.Solid);
        cf.setBackColor(Color.pink);
        
        sheet.getCellRange("I15").setValue(DateTime.getNow().addDays(-2).getDate().toString());
        sheet.getCellRange("J15").setValue(DateTime.getNow().addDays(-1).getDate().toString());
        sheet.getCellRange("K15").setValue(DateTime.getNow().getDate().toString());
        sheet.getCellRange("I16").setText("ThisWeek");
        sheet.getCellRange("J16").setValue(DateTime.getNow().addDays(2).getDate().toString());
        sheet.getCellRange("K16").setValue(DateTime.getNow().addDays(3).getDate().toString());
	
	}

	//This method implements the TimePeriod conditional formatting type with ThisMonth attribute.
	private static void AddTimePeriod_7(Worksheet sheet) {
		XlsConditionalFormats conds = sheet.getConditionalFormats().add();
        conds.addRange(sheet.getCellRange("I13:K14"));
        sheet.getCellRange("I13:K14").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("I13:K14").getStyle().setColor(Color.blue);
        IConditionalFormat cf = conds.addTimePeriodCondition(TimePeriodType.ThisMonth);
        
        cf.setFillPattern(ExcelPatternType.Solid);
        cf.setBackColor(Color.pink);
        
        sheet.getCellRange("I13").setValue(DateTime.getNow().addMonths(-1).getDate().toString());
        sheet.getCellRange("J13").setValue(DateTime.getNow().addDays(-1).getDate().toString());
        sheet.getCellRange("K13").setValue(DateTime.getNow().getDate().toString());
        sheet.getCellRange("I14").setText("ThisMonth");
        sheet.getCellRange("J14").setValue(DateTime.getNow().addMonths(1).getDate().toString());
        sheet.getCellRange("K14").setValue(DateTime.getNow().addMonths(2).getDate().toString());
	
	}

	//This method implements the TimePeriod conditional formatting type with NextWeek attribute.
	private static void AddTimePeriod_6(Worksheet sheet) {
		XlsConditionalFormats conds = sheet.getConditionalFormats().add();
        conds.addRange(sheet.getCellRange("I11:K12"));
        sheet.getCellRange("I11:K12").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("I11:K12").getStyle().setColor(Color.blue);
        IConditionalFormat cf = conds.addTimePeriodCondition(TimePeriodType.NextWeek);
        
        cf.setFillPattern(ExcelPatternType.Solid);
        cf.setBackColor(Color.pink);
        
        sheet.getCellRange("I11").setValue(DateTime.getNow().addDays(-3).getDate().toString());
        sheet.getCellRange("J11").setValue(DateTime.getNow().addDays(-2).getDate().toString());
        sheet.getCellRange("K11").setValue(DateTime.getNow().getDate().toString());
        sheet.getCellRange("I12").setText("NextWeek");
        sheet.getCellRange("J12").setValue(DateTime.getNow().addDays(3).getDate().toString());
        sheet.getCellRange("K12").setValue(DateTime.getNow().addMonths(4).getDate().toString());
	
	}

	//This method implements the TimePeriod conditional formatting type with NextMonth attribute.
	private static void AddTimePeriod_5(Worksheet sheet) {
		XlsConditionalFormats conds = sheet.getConditionalFormats().add();
        conds.addRange(sheet.getCellRange("I9:K10"));
        sheet.getCellRange("I9:K10").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("I9:K10").getStyle().setColor(Color.gray);
        IConditionalFormat cf = conds.addTimePeriodCondition(TimePeriodType.NextMonth);
        
        cf.setFillPattern(ExcelPatternType.Solid);
        cf.setBackColor(Color.pink);
        
        sheet.getCellRange("I9").setValue(DateTime.getNow().addDays(-3).getDate().toString());
        sheet.getCellRange("J9").setValue(DateTime.getNow().addMonths(-1).getDate().toString());
        sheet.getCellRange("K9").setValue(DateTime.getNow().getDate().toString());
        sheet.getCellRange("I10").setText("NextMonth");
        sheet.getCellRange("J10").setValue(DateTime.getNow().addMonths(1).getDate().toString());
        sheet.getCellRange("K10").setValue(DateTime.getNow().addMonths(2).getDate().toString());
	
	}

	//This method implements the TimePeriod conditional formatting type with LastWeek attribute.
	private static void AddTimePeriod_4(Worksheet sheet) {
		XlsConditionalFormats conds = sheet.getConditionalFormats().add();
        conds.addRange(sheet.getCellRange("I7:K8"));
        sheet.getCellRange("I7:K8").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("I7:K8").getStyle().setColor(Color.gray);
        IConditionalFormat cf = conds.addTimePeriodCondition(TimePeriodType.LastWeek);
        
        cf.setFillPattern(ExcelPatternType.Solid);
        cf.setBackColor(Color.pink);
        
        sheet.getCellRange("I7").setValue(DateTime.getNow().addDays(-6).getDate().toString());
        sheet.getCellRange("J7").setValue(DateTime.getNow().addDays(-5).getDate().toString());
        sheet.getCellRange("K7").setValue(DateTime.getNow().getDate().toString());
        sheet.getCellRange("I8").setText("LastWeek");
        sheet.getCellRange("J8").setValue(DateTime.getNow().addDays(3).getDate().toString());
        sheet.getCellRange("K8").setValue(DateTime.getNow().addMonths(4).getDate().toString());
	
	}

	//This method implements the TimePeriod conditional formatting type with LastMonth attribute.
	private static void AddTimePeriod_3(Worksheet sheet) {
		XlsConditionalFormats conds = sheet.getConditionalFormats().add();
        conds.addRange(sheet.getCellRange("I5:K6"));
        sheet.getCellRange("I5:K6").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("I5:K6").getStyle().setColor(Color.gray);
        IConditionalFormat cf = conds.addTimePeriodCondition(TimePeriodType.LastMonth);
        
        cf.setFillPattern(ExcelPatternType.Solid);
        cf.setBackColor(Color.pink);
        
        sheet.getCellRange("I5").setValue(DateTime.getNow().addDays(-6).getDate().toString());
        sheet.getCellRange("J5").setValue(DateTime.getNow().addMonths(-1).getDate().toString());
        sheet.getCellRange("K5").setValue(DateTime.getNow().getDate().toString());
        sheet.getCellRange("I6").setText("LastMonth");
        sheet.getCellRange("J6").setValue(DateTime.getNow().addDays(3).getDate().toString());
        sheet.getCellRange("K6").setValue(DateTime.getNow().addMonths(1).getDate().toString());
	}

	//This method implements the TimePeriod conditional formatting type with Last7Days attribute.
	private static void AddTimePeriod_2(Worksheet sheet) {
		XlsConditionalFormats conds = sheet.getConditionalFormats().add();
        conds.addRange(sheet.getCellRange("I3:K4"));
        sheet.getCellRange("I3:K4").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("I3:K4").getStyle().setColor(Color.blue);
        IConditionalFormat cf = conds.addTimePeriodCondition(TimePeriodType.Last7Days);
        
        cf.setFillPattern(ExcelPatternType.Solid);
        cf.setBackColor(Color.pink);
        
        sheet.getCellRange("I3").setValue(DateTime.getNow().addDays(-8).getDate().toString());
        sheet.getCellRange("J3").setValue(DateTime.getNow().addDays(-7).getDate().toString());
        sheet.getCellRange("K3").setValue(DateTime.getNow().getDate().toString());
        sheet.getCellRange("I4").setText("Last7Days");
        sheet.getCellRange("J4").setValue(DateTime.getNow().addDays(3).getDate().toString());
        sheet.getCellRange("K4").setValue(DateTime.getNow().addMonths(2).getDate().toString());
	}

	//This method implements the TimePeriod conditional formatting type with Today attribute.
	private static void AddTimePeriod_1(Worksheet sheet) {
		XlsConditionalFormats conds = sheet.getConditionalFormats().add();
        conds.addRange(sheet.getCellRange("I1:K2"));
        sheet.getCellRange("I1:K2").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("I1:K2").getStyle().setColor(Color.gray);
        IConditionalFormat cf = conds.addTimePeriodCondition(TimePeriodType.Today);
        
        cf.setFillPattern(ExcelPatternType.Solid);
        cf.setBackColor(Color.pink);
        
        sheet.getCellRange("I1").setValue(DateTime.getNow().addDays(-8).getDate().toString());
        sheet.getCellRange("J1").setValue(DateTime.getNow().addDays(-7).getDate().toString());
        sheet.getCellRange("K1").setValue(DateTime.getNow().getDate().toString());
        sheet.getCellRange("I2").setText("Today");
        sheet.getCellRange("J2").setValue(DateTime.getNow().addDays(3).getDate().toString());
        sheet.getCellRange("K2").setValue(DateTime.getNow().addMonths(2).getDate().toString());
	}

	//This method implements the UniqueValues conditional formatting type.
	private static void AddUnique(Worksheet sheet) {
		XlsConditionalFormats conds = sheet.getConditionalFormats().add();
        conds.addRange(sheet.getCellRange("E21:G22"));
        sheet.getCellRange("E21:G22").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("E21:G22").getStyle().setColor(Color.orange);
        IConditionalFormat cf = conds.addUniqueValuesCondition();
        
        cf.setFillPattern(ExcelPatternType.Solid);
        cf.setBackColor(Color.yellow);
        
        sheet.getCellRange("E21").setText("aa");
        sheet.getCellRange("F21").setText("bb");
        sheet.getCellRange("G21").setText("aa");
        sheet.getCellRange("E22").setText("bbb");
        sheet.getCellRange("F22").setText("bb");
        sheet.getCellRange("G22").setText("ccc");
	}

	//This method implements the NotContainsError conditional formatting type.
	private static void AddNotContainsError(Worksheet sheet) {
		XlsConditionalFormats conds = sheet.getConditionalFormats().add();
        conds.addRange(sheet.getCellRange("E19:G20"));
        sheet.getCellRange("E19:G20").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("E19:G20").getStyle().setColor(Color.green);
        IConditionalFormat cf = conds.addNotContainsErrorsCondition();
        
        cf.setFillPattern(ExcelPatternType.Solid);
        cf.setBackColor(Color.yellow);
        
        sheet.getCellRange("E19").setText("aa");
        sheet.getCellRange("F19").setText("=Sum");
        sheet.getCellRange("G19").setText("aa");
        sheet.getCellRange("E20").setText("bbb");
        sheet.getCellRange("F20").setText("sss");
        sheet.getCellRange("G20").setText("=Max");
	}

	//This method implements the DuplicateValues conditional formatting type.
	private static void AddDuplicate(Worksheet sheet) {
		XlsConditionalFormats conds = sheet.getConditionalFormats().add();
        conds.addRange(sheet.getCellRange("E23:G24"));
        sheet.getCellRange("E23:G24").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("E23:G24").getStyle().setColor(Color.gray);
        IConditionalFormat cf = conds.addDuplicateValuesCondition();
        
        cf.setFillPattern(ExcelPatternType.Solid);
        cf.setBackColor(Color.pink);
        
        sheet.getCellRange("E23").setText("aa");
        sheet.getCellRange("F23").setText("bb");
        sheet.getCellRange("G23").setText("aa");
        sheet.getCellRange("E24").setText("bbb");
        sheet.getCellRange("F24").setText("bb");
        sheet.getCellRange("G24").setText("ccc");
	}

	//This method implements the ContainsErrors conditional formatting type.
	private static void AddContainsError(Worksheet sheet) {
		XlsConditionalFormats conds = sheet.getConditionalFormats().add();
        conds.addRange(sheet.getCellRange("E17:G18"));
        sheet.getCellRange("E17:G18").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("E17:G18").getStyle().setColor(Color.blue);
        IConditionalFormat cf = conds.addContainsErrorsCondition();
        
        cf.setFillPattern(ExcelPatternType.Solid);
        cf.setBackColor(Color.yellow);
        
        sheet.getCellRange("E17").setText("aa");
        sheet.getCellRange("F17").setText("=Sum");
        sheet.getCellRange("G17").setText("aa");
        sheet.getCellRange("E18").setText("bbb");
        sheet.getCellRange("F18").setText("sss");
        sheet.getCellRange("G18").setText("=Max");
	}

	//This method implements the EndWith conditional formatting type.
	private static void AddEndWith(Worksheet sheet) {
		XlsConditionalFormats conds = sheet.getConditionalFormats().add();
        conds.addRange(sheet.getCellRange("E13:G14"));
        sheet.getCellRange("E13:G14").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("E13:G14").getStyle().setColor(Color.gray);
        IConditionalFormat cf = conds.addEndsWithCondition("ab");
        
        cf.setFillPattern(ExcelPatternType.Solid);
        cf.setBackColor(Color.yellow);
        
        sheet.getCellRange("E13").setText("aa");
        sheet.getCellRange("F13").setText("abc");
        sheet.getCellRange("G13").setText("aab");
        sheet.getCellRange("E14").setText("bbbc");
        sheet.getCellRange("F14").setText("sab");
        sheet.getCellRange("G14").setText("abcd");
	}

	//This method implements the BeginWith conditional formatting type.
	private static void AddBeginWith(Worksheet sheet) {
		XlsConditionalFormats conds = sheet.getConditionalFormats().add();
        conds.addRange(sheet.getCellRange("E15:G16"));
        sheet.getCellRange("E15:G16").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("E15:G16").getStyle().setColor(Color.yellow);
        IConditionalFormat cf = conds.addBeginsWithCondition("ab");
        
        cf.setFillPattern(ExcelPatternType.Solid);
        cf.setBackColor(Color.pink);
        
        sheet.getCellRange("E15").setText("aa");
        sheet.getCellRange("F15").setText("abc");
        sheet.getCellRange("G15").setText("aa");
        sheet.getCellRange("E16").setText("bbb");
        sheet.getCellRange("F16").setText("sss");
        sheet.getCellRange("G16").setText("abcd");
		
	}

	//This method implements the NotContainsBlank conditional formatting type.
	private static void AddNotContainsBlank(Worksheet sheet) {
		XlsConditionalFormats conds = sheet.getConditionalFormats().add();
        conds.addRange(sheet.getCellRange("E11:G12"));
        sheet.getCellRange("E11:G12").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("E11:G12").getStyle().setColor(Color.orange);
        IConditionalFormat cf = conds.addNotContainsBlanksCondition();
        
        cf.setFillPattern(ExcelPatternType.Solid);
        cf.setBackColor(Color.pink);
        
        sheet.getCellRange("E11").setText("aa");
        sheet.getCellRange("F11").setText("    ");
        sheet.getCellRange("G11").setText("aab");
        sheet.getCellRange("E12").setText("abc");
        sheet.getCellRange("F12").setText("    ");
        sheet.getCellRange("G12").setText("abcd");
		
	}

	//This method implements the ContainsBlank conditional formatting type.
	private static void AddContainsBlank(Worksheet sheet) {
		XlsConditionalFormats conds = sheet.getConditionalFormats().add();
        conds.addRange(sheet.getCellRange("E9:G10"));
        sheet.getCellRange("E9:G10").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("E9:G10").getStyle().setColor(Color.cyan);
        IConditionalFormat cf = conds.addContainsBlanksCondition();
        
        cf.setFillPattern(ExcelPatternType.Solid);
        cf.setBackColor(Color.yellow);
        
        sheet.getCellRange("E9").setText("aa");
        sheet.getCellRange("F9").setText("    ");
        sheet.getCellRange("G9").setText("aab");
        sheet.getCellRange("E10").setText("abc");
        sheet.getCellRange("F10").setText("dvdf");
        sheet.getCellRange("G10").setText("abcd");
		
	}

	//This method implements the NotContainsText conditional formatting type.
	private static void AddNotContainsText(Worksheet sheet) {
		XlsConditionalFormats conds = sheet.getConditionalFormats().add();
        conds.addRange(sheet.getCellRange("E7:G8"));
        sheet.getCellRange("E7:G8").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("E7:G8").getStyle().setColor(Color.green);
        IConditionalFormat cf = conds.addNotContainsTextCondition("abc");
        
        cf.setFillPattern(ExcelPatternType.Solid);
        cf.setBackColor(Color.pink);
        
        sheet.getCellRange("E7").setText("aa");
        sheet.getCellRange("F7").setText("abfd");
        sheet.getCellRange("G7").setText("aab");
        sheet.getCellRange("E8").setText("abc");
        sheet.getCellRange("F8").setText("cedf");
        sheet.getCellRange("G8").setText("abcd");
	}

	//This method implements the DataBars conditional formatting type with Percentile attribute.
	private static void AddDataBar2(Worksheet sheet) {
        XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();
        xcfs.addRange(sheet.getCellRange("E3:G4"));
        sheet.getCellRange("E3:G4").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("E3:G4").getStyle().setColor(Color.green);
        IConditionalFormat cf = xcfs.addCondition();
        
        cf.setFormatType(ConditionalFormatType.DataBar);
        cf.getDataBar().setBarColor(Color.orange);
        cf.getDataBar().getMinPoint().setType(ConditionValueType.Percentile);;
        cf.getDataBar().getMinPoint().setValue(30.78);
        cf.getDataBar().setShowValue(false);
        
        sheet.getCellRange("E3").setNumberValue(6);
        sheet.getCellRange("F3").setNumberValue(9);
        sheet.getCellRange("G3").setNumberValue(12);
        sheet.getCellRange("E4").setNumberValue(8);
        sheet.getCellRange("F4").setNumberValue(11);
        sheet.getCellRange("G4").setNumberValue(14);
	}

	//This method implements the ContainsText conditional formatting type.
	private static void AddContainsText(Worksheet sheet) {
		XlsConditionalFormats conds = sheet.getConditionalFormats().add();
        conds.addRange(sheet.getCellRange("E5:G6"));
        sheet.getCellRange("E5:G6").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("E5:G6").getStyle().setColor(Color.blue);
        IConditionalFormat cf = conds.addContainsTextCondition("abc");
        
        cf.setFillPattern(ExcelPatternType.Solid);
        cf.setBackColor(Color.yellow);
        
        sheet.getCellRange("E5").setText("aa");
        sheet.getCellRange("F5").setText("abfd");
        sheet.getCellRange("G5").setText("aab");
        sheet.getCellRange("E6").setText("abc");
        sheet.getCellRange("F6").setText("cedf");
        sheet.getCellRange("G6").setText("abcd");
	}

	//This method implements BottomPercent 10 conditional formatting type with some custom attributes.
	private static void AddTop10_4(Worksheet sheet) {
		XlsConditionalFormats conds = sheet.getConditionalFormats().add();
        conds.addRange(sheet.getCellRange("A29:C32"));
        sheet.getCellRange("A29:C32").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("A29:C32").getStyle().setColor(Color.yellow);
        IConditionalFormat cf = conds.addTopBottomCondition(TopBottomType.BottomPercent, 10);
        
        cf.setFillPattern(ExcelPatternType.Solid);
        cf.setBackColor(Color.green);
        
        sheet.getCellRange("A29").setNumberValue(22);
        sheet.getCellRange("B29").setNumberValue(33);
        sheet.getCellRange("C29").setNumberValue(38);
        sheet.getCellRange("A30").setNumberValue(30);
        sheet.getCellRange("B30").setNumberValue(35);
        sheet.getCellRange("C30").setNumberValue(39);
        sheet.getCellRange("A31").setNumberValue(32);
        sheet.getCellRange("B31").setNumberValue(37);
        sheet.getCellRange("C31").setNumberValue(43);
        sheet.getCellRange("A32").setNumberValue(34);
        sheet.getCellRange("B32").setNumberValue(28);
        sheet.getCellRange("C32").setNumberValue(32);
		
	}

	//This method implements the DataBars conditional formatting type.
	private static void AddDataBar1(Worksheet sheet) {
        XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();
        xcfs.addRange(sheet.getCellRange("E1:G2"));
        sheet.getCellRange("E1:G2").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("E1:G2").getStyle().setColor(Color.green);
        IConditionalFormat cf = xcfs.addCondition();
        
        cf.setFormatType(ConditionalFormatType.DataBar);
        cf.getDataBar().setBarColor(Color.blue);
        cf.getDataBar().getMinPoint().setType(ConditionValueType.Percent);;
        cf.getDataBar().setShowValue(true);
        
        sheet.getCellRange("E1").setNumberValue(4);
        sheet.getCellRange("F1").setNumberValue(7);
        sheet.getCellRange("G1").setNumberValue(10);
        sheet.getCellRange("E2").setNumberValue(6);
        sheet.getCellRange("F2").setNumberValue(9);
        sheet.getCellRange("G2").setNumberValue(14);
	}

	//This method implements TopPercent 10 conditional formatting type with some custom attributes.
	private static void AddTop10_3(Worksheet sheet) {
		XlsConditionalFormats conds = sheet.getConditionalFormats().add();
        conds.addRange(sheet.getCellRange("A25:C28"));
        sheet.getCellRange("A25:C28").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("A25:C28").getStyle().setColor(Color.orange);
        IConditionalFormat cf = conds.addTopBottomCondition(TopBottomType.TopPercent, 10);
        
        cf.setFillPattern(ExcelPatternType.Solid);
        cf.setBackColor(Color.blue);
        
        sheet.getCellRange("A25").setNumberValue(24);
        sheet.getCellRange("B25").setNumberValue(29);
        sheet.getCellRange("C25").setNumberValue(34);
        sheet.getCellRange("A26").setNumberValue(25);
        sheet.getCellRange("B26").setNumberValue(36);
        sheet.getCellRange("C26").setNumberValue(32);
        sheet.getCellRange("A27").setNumberValue(24);
        sheet.getCellRange("B27").setNumberValue(31);
        sheet.getCellRange("C27").setNumberValue(34);
        sheet.getCellRange("A28").setNumberValue(26);
        sheet.getCellRange("B28").setNumberValue(32);
        sheet.getCellRange("C28").setNumberValue(36);
	}

	//This method implements Bottom 10 conditional formatting type.
	private static void AddTop10_2(Worksheet sheet) {
		XlsConditionalFormats conds = sheet.getConditionalFormats().add();
        conds.addRange(sheet.getCellRange("A21:C24"));
        sheet.getCellRange("A21:C24").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("A21:C24").getStyle().setColor(Color.green);
        IConditionalFormat cf = conds.addTopBottomCondition(TopBottomType.Bottom, 10);
        
        cf.setFillPattern(ExcelPatternType.Solid);
        cf.setBackColor(Color.pink);
        
        sheet.getCellRange("A21").setNumberValue(20);
        sheet.getCellRange("B21").setNumberValue(25);
        sheet.getCellRange("C21").setNumberValue(30);
        sheet.getCellRange("A22").setNumberValue(22);
        sheet.getCellRange("B22").setNumberValue(27);
        sheet.getCellRange("C22").setNumberValue(32);
        sheet.getCellRange("A23").setNumberValue(24);
        sheet.getCellRange("B23").setNumberValue(29);
        sheet.getCellRange("C23").setNumberValue(34);
        sheet.getCellRange("A24").setNumberValue(24);
        sheet.getCellRange("B24").setNumberValue(31);
        sheet.getCellRange("C24").setNumberValue(36);
	}

	//This method implements a Top10 conditional formatting type.
	private static void AddTop10_1(Worksheet sheet) {
		XlsConditionalFormats conds = sheet.getConditionalFormats().add();
        conds.addRange(sheet.getCellRange("A17:C20"));
        sheet.getCellRange("A17:C20").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("A17:C20").getStyle().setColor(Color.gray);
        IConditionalFormat cf = conds.addTopBottomCondition(TopBottomType.Top, 10);
        
        cf.setFillPattern(ExcelPatternType.Solid);
        cf.setBackColor(Color.yellow);
        
        sheet.getCellRange("A17").setNumberValue(16);
        sheet.getCellRange("B17").setNumberValue(21);
        sheet.getCellRange("C17").setNumberValue(26);
        sheet.getCellRange("A18").setNumberValue(18);
        sheet.getCellRange("B18").setNumberValue(23);
        sheet.getCellRange("C18").setNumberValue(28);
        sheet.getCellRange("A19").setNumberValue(20);
        sheet.getCellRange("B19").setNumberValue(25);
        sheet.getCellRange("C19").setNumberValue(30);
        sheet.getCellRange("A20").setNumberValue(22);
        sheet.getCellRange("B20").setNumberValue(27);
        sheet.getCellRange("C20").setNumberValue(32);
	}

	// This method implements an AboveStdDev3 conditional formatting type with some custom attributes.
	private static void AddEboveEverage3(Worksheet sheet) {
		XlsConditionalFormats conds = sheet.getConditionalFormats().add();
        conds.addRange(sheet.getCellRange("A15:C16"));
        sheet.getCellRange("A15:C16").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("A15:C16").getStyle().setColor(Color.pink);
        IConditionalFormat cf = conds.addAverageCondition(AverageType.AboveStdDev3);
        
        cf.setFillPattern(ExcelPatternType.Solid);
        cf.setBackColor(Color.blue);
        
        sheet.getCellRange("A15").setNumberValue(12);
        sheet.getCellRange("B15").setNumberValue(15);
        sheet.getCellRange("C15").setNumberValue(18);
        sheet.getCellRange("A16").setNumberValue(16);
        sheet.getCellRange("B16").setNumberValue(17);
        sheet.getCellRange("C16").setNumberValue(20);
	}

	//This method implements an BelowEqualAverage conditional formatting type with some custom attributes.
	private static void AddEboveEverage2(Worksheet sheet) {
        XlsConditionalFormats conds = sheet.getConditionalFormats().add();
        conds.addRange(sheet.getCellRange("A13:C14"));
        sheet.getCellRange("A13:C14").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("A13:C14").getStyle().setColor(Color.pink);
        IConditionalFormat cf = conds.addAverageCondition(AverageType.BelowEqual);
        
        cf.setFillPattern(ExcelPatternType.Solid);
        cf.setBackColor(Color.blue);
        
        sheet.getCellRange("A13").setNumberValue(12);
        sheet.getCellRange("B13").setNumberValue(15);
        sheet.getCellRange("C13").setNumberValue(18);
        sheet.getCellRange("A14").setNumberValue(14);
        sheet.getCellRange("B14").setNumberValue(17);
        sheet.getCellRange("C14").setNumberValue(20);
	}

	//This method implements the AboveAverage conditional formatting type.
	private static void AddEboveEverage(Worksheet sheet) {
        XlsConditionalFormats conds = sheet.getConditionalFormats().add();
        conds.addRange(sheet.getCellRange("A11:C12"));
        sheet.getCellRange("A11:C12").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("A11:C12").getStyle().setColor(Color.red);
        IConditionalFormat cf = conds.addAverageCondition(AverageType.Above);
        
        cf.setFillPattern(ExcelPatternType.Solid);
        cf.setBackColor(Color.pink);
        
        sheet.getCellRange("A11").setNumberValue(10);
        sheet.getCellRange("B11").setNumberValue(13);
        sheet.getCellRange("C11").setNumberValue(16);
        sheet.getCellRange("A12").setNumberValue(12);
        sheet.getCellRange("B12").setNumberValue(15);
        sheet.getCellRange("C12").setNumberValue(18);
		
	}

	//This method implements the ColorScale conditional formatting type with some color scale attributes.
	private static void Add2ColorScale(Worksheet sheet) {
        XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();
        xcfs.addRange(sheet.getCellRange("A9:C10"));
        sheet.getCellRange("A9:C10").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("A9:C10").getStyle().setColor(Color.white);
        IConditionalFormat cf = xcfs.addCondition();
        
        cf.setFormatType(ConditionalFormatType.ColorScale);
        cf.getColorScale().setMinColor(Color.yellow);
        cf.getColorScale().setMaxColor(Color.blue);
        
        sheet.getCellRange("A9").setNumberValue(8);
        sheet.getCellRange("B9").setNumberValue(12);
        sheet.getCellRange("C9").setNumberValue(13);
        sheet.getCellRange("A10").setNumberValue(10);
        sheet.getCellRange("B10").setNumberValue(13);
        sheet.getCellRange("C10").setNumberValue(16);
		
	}

	//This method implements the ColorScale conditional formatting type with some color scale attributes.
	private static void Add3ColorScale(Worksheet sheet) {
        XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();
        xcfs.addRange(sheet.getCellRange("A7:C8"));
        sheet.getCellRange("A7:C8").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("A7:C8").getStyle().setColor(Color.green);
        IConditionalFormat cf = xcfs.addCondition();
        
        cf.setFormatType(ConditionalFormatType.ColorScale);
        cf.getColorScale().getMinValue().setType(ConditionValueType.Number);
        cf.getColorScale().getMinValue().setValue(9);
        cf.getColorScale().setMinColor(Color.pink);
        
        sheet.getCellRange("A7").setNumberValue(6);
        sheet.getCellRange("B7").setNumberValue(9);
        sheet.getCellRange("C7").setNumberValue(12);
        sheet.getCellRange("A8").setNumberValue(8);
        sheet.getCellRange("B8").setNumberValue(11);
        sheet.getCellRange("C8").setNumberValue(14);
	}

	//This method implements the ColorScale conditional formatting type.
	private static void AddDefaultColorScale(Worksheet sheet) {
        XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();
        xcfs.addRange(sheet.getCellRange("A5:C6"));
        sheet.getCellRange("A5:C6").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("A5:C6").getStyle().setColor(Color.pink);
        IConditionalFormat cf = xcfs.addCondition();
        cf.setFormatType(ConditionalFormatType.ColorScale);
        
        sheet.getCellRange("A5").setNumberValue(4);
        sheet.getCellRange("B5").setNumberValue(7);
        sheet.getCellRange("C5").setNumberValue(10);
        sheet.getCellRange("A6").setNumberValue(6);
        sheet.getCellRange("B6").setNumberValue(9);
        sheet.getCellRange("C6").setNumberValue(12);
	}

	//This method implements the IconSet conditional formatting type with FourTrafficLights attribute.
	private static void AddIconSet18(Worksheet sheet) {
		XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();
        xcfs.addRange(sheet.getCellRange("M33:O35"));
        sheet.getCellRange("M33:O35").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("M33:O35").getStyle().setColor(Color.blue);
        IConditionalFormat cf = xcfs.addCondition();
        cf.setFormatType(ConditionalFormatType.IconSet);
        cf.getIconSet().setIconSetType(IconSetType.FourTrafficLights);
        
        sheet.getCellRange("M33").setText("FourTrafficLights");
        sheet.getCellRange("N33").setNumberValue(48);
        sheet.getCellRange("O33").setNumberValue(52);
        sheet.getCellRange("M34").setNumberValue(46);
        sheet.getCellRange("N34").setNumberValue(50);
        sheet.getCellRange("O34").setNumberValue(54);	
        sheet.getCellRange("M35").setNumberValue(48);
        sheet.getCellRange("N35").setNumberValue(52);
        sheet.getCellRange("O35").setNumberValue(56);	
	}
	
	//This method implements the IconSet conditional formatting type with ThreeTrafficLights2 attribute.
	private static void AddIconSet17(Worksheet sheet) {
		XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();
        xcfs.addRange(sheet.getCellRange("M31:O32"));
        sheet.getCellRange("M31:O32").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("M31:O32").getStyle().setColor(Color.orange);
        IConditionalFormat cf = xcfs.addCondition();
        cf.setFormatType(ConditionalFormatType.IconSet);
        cf.getIconSet().setIconSetType(IconSetType.ThreeTrafficLights2);
        
        sheet.getCellRange("M31").setText("ThreeTrafficLights2");
        sheet.getCellRange("N31").setNumberValue(45);
        sheet.getCellRange("O31").setNumberValue(48);
        sheet.getCellRange("M32").setNumberValue(44);
        sheet.getCellRange("N32").setNumberValue(47);
        sheet.getCellRange("O32").setNumberValue(50);	
	}
	
	//This method implements the IconSet conditional formatting type with ThreeTrafficLights1 attribute.
	private static void AddIconSet16(Worksheet sheet) {
		XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();
        xcfs.addRange(sheet.getCellRange("M29:O30"));
        sheet.getCellRange("M29:O30").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("M29:O30").getStyle().setColor(Color.gray);
        IConditionalFormat cf = xcfs.addCondition();
        cf.setFormatType(ConditionalFormatType.IconSet);
        cf.getIconSet().setIconSetType(IconSetType.ThreeTrafficLights1);
        
        sheet.getCellRange("M29").setText("ThreeTrafficLights1");
        sheet.getCellRange("N29").setNumberValue(43);
        sheet.getCellRange("O29").setNumberValue(46);
        sheet.getCellRange("M30").setNumberValue(42);
        sheet.getCellRange("N30").setNumberValue(45);
        sheet.getCellRange("O30").setNumberValue(48);	
	}

	//This method implements the IconSet conditional formatting type with ThreeSymbols2 attribute.
	private static void AddIconSet15(Worksheet sheet) {
		XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();
        xcfs.addRange(sheet.getCellRange("M27:O28"));
        sheet.getCellRange("M27:O28").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("M27:O28").getStyle().setColor(Color.black);
        IConditionalFormat cf = xcfs.addCondition();
        cf.setFormatType(ConditionalFormatType.IconSet);
        cf.getIconSet().setIconSetType(IconSetType.ThreeSymbols2);
        
        sheet.getCellRange("M27").setText("ThreeSymbols2");
        sheet.getCellRange("N27").setNumberValue(41);
        sheet.getCellRange("O27").setNumberValue(44);
        sheet.getCellRange("M28").setNumberValue(40);
        sheet.getCellRange("N28").setNumberValue(43);
        sheet.getCellRange("O28").setNumberValue(46);	
	}
	
	//This method implements the IconSet conditional formatting type with ThreeSymbols attribute.
	private static void AddIconSet14(Worksheet sheet) {
		XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();
        xcfs.addRange(sheet.getCellRange("M25:O26"));
        sheet.getCellRange("M25:O26").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("M25:O26").getStyle().setColor(Color.blue);
        IConditionalFormat cf = xcfs.addCondition();
        cf.setFormatType(ConditionalFormatType.IconSet);
        cf.getIconSet().setIconSetType(IconSetType.ThreeSymbols);
        
        sheet.getCellRange("M25").setText("ThreeSymbols");
        sheet.getCellRange("N25").setNumberValue(39);
        sheet.getCellRange("O25").setNumberValue(42);
        sheet.getCellRange("M26").setNumberValue(38);
        sheet.getCellRange("N26").setNumberValue(41);
        sheet.getCellRange("O26").setNumberValue(44);	
	}
	
	//This method implements the IconSet conditional formatting type with ThreeSigns attribute.
	private static void AddIconSet13(Worksheet sheet) {
		XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();
        xcfs.addRange(sheet.getCellRange("M23:O24"));
        sheet.getCellRange("M23:O24").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("M23:O24").getStyle().setColor(Color.gray);
        IConditionalFormat cf = xcfs.addCondition();
        cf.setFormatType(ConditionalFormatType.IconSet);
        cf.getIconSet().setIconSetType(IconSetType.ThreeSigns);
        
        sheet.getCellRange("M23").setText("ThreeSigns");
        sheet.getCellRange("N23").setNumberValue(37);
        sheet.getCellRange("O23").setNumberValue(40);
        sheet.getCellRange("M24").setNumberValue(36);
        sheet.getCellRange("N24").setNumberValue(39);
        sheet.getCellRange("O24").setNumberValue(42);	
	}
	
	 //This method implements the IconSet conditional formatting type with FourRedToBlack attribute.
	private static void AddIconSet12(Worksheet sheet) {
		XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();
        xcfs.addRange(sheet.getCellRange("M21:O22"));
        sheet.getCellRange("M21:O22").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("M21:O22").getStyle().setColor(Color.green);
        IConditionalFormat cf = xcfs.addCondition();
        cf.setFormatType(ConditionalFormatType.IconSet);
        cf.getIconSet().setIconSetType(IconSetType.FourRedToBlack);
        
        sheet.getCellRange("M21").setText("FourRedToBlack");
        sheet.getCellRange("N21").setNumberValue(35);
        sheet.getCellRange("O21").setNumberValue(38);
        sheet.getCellRange("M22").setNumberValue(34);
        sheet.getCellRange("N22").setNumberValue(37);
        sheet.getCellRange("O22").setNumberValue(40);	
	}

	//This method implements the IconSet conditional formatting type with FiveRating attribute.
	private static void AddIconSet11(Worksheet sheet) {
		XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();
        xcfs.addRange(sheet.getCellRange("M19:O20"));
        sheet.getCellRange("M19:O20").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("M19:O20").getStyle().setColor(Color.blue);
        IConditionalFormat cf = xcfs.addCondition();
        cf.setFormatType(ConditionalFormatType.IconSet);
        cf.getIconSet().setIconSetType(IconSetType.FiveRating);
        
        sheet.getCellRange("M19").setText("FiveRating");
        sheet.getCellRange("N19").setNumberValue(33);
        sheet.getCellRange("O19").setNumberValue(36);
        sheet.getCellRange("M20").setNumberValue(32);
        sheet.getCellRange("N20").setNumberValue(35);
        sheet.getCellRange("O20").setNumberValue(38);	
	}

	//This method implements the IconSet conditional formatting type with FourRating attribute.
	private static void AddIconSet10(Worksheet sheet) {
		XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();
        xcfs.addRange(sheet.getCellRange("M17:O18"));
        sheet.getCellRange("M17:O18").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("M17:O18").getStyle().setColor(Color.blue);
        IConditionalFormat cf = xcfs.addCondition();
        cf.setFormatType(ConditionalFormatType.IconSet);
        cf.getIconSet().setIconSetType(IconSetType.FourRating);
        
        sheet.getCellRange("M17").setText("FourRating");
        sheet.getCellRange("N17").setNumberValue(31);
        sheet.getCellRange("O17").setNumberValue(34);
        sheet.getCellRange("M18").setNumberValue(30);
        sheet.getCellRange("N18").setNumberValue(33);
        sheet.getCellRange("O18").setNumberValue(36);	
		
	}

	//This method implements the IconSet conditional formatting type with FiveQuarters attribute.
	private static void AddIconSet9(Worksheet sheet) {
		XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();
        xcfs.addRange(sheet.getCellRange("M15:O16"));
        sheet.getCellRange("M15:O16").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("M15:O16").getStyle().setColor(Color.cyan);
        IConditionalFormat cf = xcfs.addCondition();
        cf.setFormatType(ConditionalFormatType.IconSet);
        cf.getIconSet().setIconSetType(IconSetType.FiveQuarters);
        
        sheet.getCellRange("M15").setText("FiveQuarters");
        sheet.getCellRange("N15").setNumberValue(29);
        sheet.getCellRange("O15").setNumberValue(32);
        sheet.getCellRange("M16").setNumberValue(28);
        sheet.getCellRange("N16").setNumberValue(31);
        sheet.getCellRange("O16").setNumberValue(34);		
	}

	//This method implements the IconSet conditional formatting type with ThreeFlags attribute.
	private static void AddIconSet8(Worksheet sheet) {
		XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();
        xcfs.addRange(sheet.getCellRange("M13:O14"));
        sheet.getCellRange("M13:O14").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("M13:O14").getStyle().setColor(Color.yellow);
        IConditionalFormat cf = xcfs.addCondition();
        cf.setFormatType(ConditionalFormatType.IconSet);
        cf.getIconSet().setIconSetType(IconSetType.ThreeFlags);
        
        sheet.getCellRange("M13").setText("ThreeFlags");
        sheet.getCellRange("N13").setNumberValue(27);
        sheet.getCellRange("O13").setNumberValue(30);
        sheet.getCellRange("M14").setNumberValue(26);
        sheet.getCellRange("N14").setNumberValue(29);
        sheet.getCellRange("O14").setNumberValue(32);
	}

	//This method implements the IconSet conditional formatting type with FiveArrowsGray colored attribute.
	private static void AddIconSet7(Worksheet sheet) {
		XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();
        xcfs.addRange(sheet.getCellRange("M11:O12"));
        sheet.getCellRange("M11:O12").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("M11:O12").getStyle().setColor(Color.yellow);
        IConditionalFormat cf = xcfs.addCondition();
        cf.setFormatType(ConditionalFormatType.IconSet);
        cf.getIconSet().setIconSetType(IconSetType.FiveArrowsGray);
        
        sheet.getCellRange("M11").setText("FiveErrowsGray");
        sheet.getCellRange("N11").setNumberValue(25);
        sheet.getCellRange("O11").setNumberValue(28);
        sheet.getCellRange("M12").setNumberValue(24);
        sheet.getCellRange("N12").setNumberValue(27);
        sheet.getCellRange("O12").setNumberValue(30);
		
	}

	//This method implements the IconSet conditional formatting type with FourArrowsGray colored attribute.
	private static void AddIconSet6(Worksheet sheet) {
		XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();
        xcfs.addRange(sheet.getCellRange("M9:O10"));
        sheet.getCellRange("M9:O10").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("M9:O10").getStyle().setColor(Color.blue);
        IConditionalFormat cf = xcfs.addCondition();
        cf.setFormatType(ConditionalFormatType.IconSet);
        cf.getIconSet().setIconSetType(IconSetType.FiveArrowsGray);
        
        sheet.getCellRange("M9").setText("FourErrowsGray");
        sheet.getCellRange("N9").setNumberValue(23);
        sheet.getCellRange("O9").setNumberValue(26);
        sheet.getCellRange("M10").setNumberValue(22);
        sheet.getCellRange("N10").setNumberValue(25);
        sheet.getCellRange("O10").setNumberValue(28);
	}

	//This method implements the IconSet conditional formatting type with ThreeArrowsGray colored attribute.
	private static void AddIconSet5(Worksheet sheet) {
		XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();
        xcfs.addRange(sheet.getCellRange("M7:O8"));
        sheet.getCellRange("M7:O8").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("M7:O8").getStyle().setColor(Color.blue);
        IConditionalFormat cf = xcfs.addCondition();
        cf.setFormatType(ConditionalFormatType.IconSet);
        cf.getIconSet().setIconSetType(IconSetType.ThreeArrowsGray);
        
        sheet.getCellRange("M7").setText("ThreeErrowsGray");
        sheet.getCellRange("N7").setNumberValue(21);
        sheet.getCellRange("O7").setNumberValue(24);
        sheet.getCellRange("M8").setNumberValue(20);
        sheet.getCellRange("N8").setNumberValue(23);
        sheet.getCellRange("O8").setNumberValue(26);
		
	}

	//This method implements the IconSet conditional formatting type with FiveArrows colored attribute.
	private static void AddIconSet4(Worksheet sheet) {
		XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();
        xcfs.addRange(sheet.getCellRange("M5:O6"));
        sheet.getCellRange("M5:O6").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("M5:O6").getStyle().setColor(Color.white);
        IConditionalFormat cf = xcfs.addCondition();
        cf.setFormatType(ConditionalFormatType.IconSet);
        cf.getIconSet().setIconSetType(IconSetType.FiveArrows);
        
        sheet.getCellRange("M5").setText("FiveErrows");
        sheet.getCellRange("N5").setNumberValue(17);
        sheet.getCellRange("O5").setNumberValue(20);
        sheet.getCellRange("M6").setNumberValue(16);
        sheet.getCellRange("N6").setNumberValue(19);
        sheet.getCellRange("O6").setNumberValue(22);
		
	}
	
	//This method implements the IconSet conditional formatting type with FourArrows colored attribute.
	private static void AddIconSet3(Worksheet sheet) {
		
        XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();
        xcfs.addRange(sheet.getCellRange("M3:O4"));
        sheet.getCellRange("M3:O4").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("M3:O4").getStyle().setColor(Color.white);
        IConditionalFormat cf = xcfs.addCondition();
        cf.setFormatType(ConditionalFormatType.IconSet);
        cf.getIconSet().setIconSetType(IconSetType.FourArrows);
        
        sheet.getCellRange("M3").setText("FourErrows");
        sheet.getCellRange("N3").setNumberValue(17);
        sheet.getCellRange("O3").setNumberValue(20);
        sheet.getCellRange("M4").setNumberValue(16);
        sheet.getCellRange("N4").setNumberValue(19);
        sheet.getCellRange("O4").setNumberValue(22);
		
	}

	//This method implements the IconSet conditional formatting type with ThreeArrows colored attribute.
	private static void AddIconSet2(Worksheet sheet) {
		
        XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();
        xcfs.addRange(sheet.getCellRange("M1:O2"));
        sheet.getCellRange("M1:O2").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("M1:O2").getStyle().setColor(Color.blue);
        IConditionalFormat cf = xcfs.addCondition();
        cf.setFormatType(ConditionalFormatType.IconSet);
        cf.getIconSet().setIconSetType(IconSetType.ThreeArrows);
        
        sheet.getCellRange("M1").setText("ThreeErrows");
        sheet.getCellRange("N1").setNumberValue(15);
        sheet.getCellRange("O1").setNumberValue(18);
        sheet.getCellRange("M2").setNumberValue(14);
        sheet.getCellRange("N2").setNumberValue(17);
        sheet.getCellRange("O2").setNumberValue(20);
		
	}

	//This method implements the IconSet conditional formatting type.
	private static void AddDefaultIconSet(Worksheet sheet) {

        XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();
        xcfs.addRange(sheet.getCellRange("A1:C2"));
        sheet.getCellRange("A1:C2").getStyle().setFillPattern(ExcelPatternType.Solid);
        sheet.getCellRange("A1:C2").getStyle().setColor(Color.yellow);
        IConditionalFormat cf = xcfs.addCondition();
        
        cf.setFormatType(ConditionalFormatType.IconSet);
        
        sheet.getCellRange("A1").setNumberValue(0);
        sheet.getCellRange("B1").setNumberValue(3);
        sheet.getCellRange("C1").setNumberValue(6);
        sheet.getCellRange("A2").setNumberValue(2);
        sheet.getCellRange("B2").setNumberValue(5);
        sheet.getCellRange("C2").setNumberValue(8);
	}

}
