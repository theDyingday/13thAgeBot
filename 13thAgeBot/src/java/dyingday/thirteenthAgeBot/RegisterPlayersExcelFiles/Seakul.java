package dyingday.thirteenthAgeBot.RegisterPlayersExcelFiles;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class Seakul
{
    public static double hp;
    public static double maxHp;
    public static double recoveries;
    public static double maxRecoveries;

    static String thirteenthagefilepath = "C:\\Users\\Sam\\Desktop\\Discord Bots\\13thAgeBot\\Seakul Mineshadow.xlsx";

    public static void init() throws Exception
    {
        File seakulFile = new File(thirteenthagefilepath);
        FileInputStream fIP = new FileInputStream(seakulFile);
        XSSFWorkbook seakulWorkbook = new XSSFWorkbook(fIP);
        System.out.println(seakulWorkbook.getSheetIndex("Character Sheet"));
        XSSFSheet characterSheet = seakulWorkbook.getSheetAt(0);

        hp = getCell(3, 11, characterSheet).getNumericCellValue();
        maxHp = getCell(3, 12, characterSheet).getNumericCellValue();
        recoveries = getCell(3, 13, characterSheet).getNumericCellValue();
        maxRecoveries = getCell(3, 14, characterSheet).getNumericCellValue();

    }

    private static Cell getCell(int rownum, int cellnum, XSSFSheet sheet)
    {
        Row row = sheet.getRow(rownum);
        Cell cell1 = row.getCell(cellnum);
        return cell1;
    }
}
