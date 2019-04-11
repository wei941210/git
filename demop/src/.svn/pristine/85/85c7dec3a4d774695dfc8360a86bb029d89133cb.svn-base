package com.en.adback.controller;

import com.en.adback.entity.Logs;
import com.en.adback.entity.PlayLog;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class PlayLlogExcelCtrl {

    //将数据写入表格里   播出日志表
    public void writeLogExcel(List<PlayLog> logsList, Map<String,Object> map) throws IOException {
        Resource resource=new ClassPathResource("/static/excels/playlog.xls");
        File file=resource.getFile();
        HSSFWorkbook wb=new HSSFWorkbook(new FileInputStream(file));
        HSSFSheet sheet=wb.getSheetAt(0);
        sheet.setDefaultColumnWidth(15);
        for (int i = 5; i <= sheet.getLastRowNum(); i++) {
                sheet.removeRow(sheet.getRow(i));
        }

        //创建表头单元格样式 以及表头的字体样式
        HSSFCellStyle style = wb.createCellStyle();
        style.setWrapText(true);// 设置自动换行
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 创建一个居中格式
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setFillBackgroundColor(HSSFColor.WHITE.index);//设置背景色
        style.setFillForegroundColor(HSSFColor.WHITE.index);//设置前景色
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        HSSFFont headerFont = (HSSFFont) wb.createFont(); // 创建字体样式
        headerFont.setFontName("宋体"); // 设置字体类型
        headerFont.setFontHeightInPoints((short) 12); // 设置字体大小
        headerFont.setColor(HSSFColor.BLACK.index);  //设置字体颜色
        style.setFont(headerFont); // 为标题样式设置字体样式

        HSSFRow rowFirst=sheet.getRow(1);//第一行

//        Cell advertIdTitleCell = rowFirst.createCell(0);
//        advertIdTitleCell.setCellValue("广告编号");

        Cell cellAdvertIdValue = rowFirst.createCell(1);
        cellAdvertIdValue.setCellValue(map.get("advertId").toString());

//        Cell advertNameTitleCell = rowFirst.createCell(2);
//        advertNameTitleCell.setCellValue("广告名称");

        Cell cellAdvertNameValue = rowFirst.createCell(3);
        cellAdvertNameValue.setCellValue(map.get("advertName").toString());

//        Cell putinKindTitleCell = rowFirst.createCell(4);
//        putinKindTitleCell.setCellValue("投放类别");

        Cell cellPutInKindValue = rowFirst.createCell(5);
        cellPutInKindValue.setCellValue("1".equals(map.get("putInKind").toString()) ? "购买": "赠送");

//        Cell dateTitleCell = rowFirst.createCell(6);
//        dateTitleCell.setCellValue("统计日期");

        Cell cellDateValue = rowFirst.createCell(7);
        cellDateValue.setCellValue(map.get("beginDate").toString()+"至"+map.get("endDate").toString());

        HSSFRow rowSecond=sheet.getRow(2);//第二行

//        Cell deviceIdTitleCell = rowSecond.createCell(0);
//        deviceIdTitleCell.setCellValue("设备编号");

        Cell cellDeviceIdValue = rowSecond.createCell(1);
        cellDeviceIdValue.setCellValue(map.get("deviceIds").toString().split("\\|")[0]);

//        Cell deviceNameTitleCell = rowSecond.createCell(2);
//        deviceNameTitleCell.setCellValue("场所名称");

        Cell cellDeviceNameValue = rowSecond.createCell(3);
        cellDeviceNameValue.setCellValue(map.get("deviceIds").toString().split("\\|")[1]);

//        Cell playTypeTitleCell = rowSecond.createCell(4);
//        playTypeTitleCell.setCellValue("播放形式");

        Cell cellPlayAloneName = rowSecond.createCell(5);
        cellPlayAloneName.setCellValue(map.get("playAlone").toString());

//        Cell timeTitleCell = rowSecond.createCell(6);
//        timeTitleCell.setCellValue("统计时间");

        Cell cellTimeValue = rowSecond.createCell(7);
        if(null == map.get("beginPlayTime") || "".equals(map.get("beginPlayTime")) || null == map.get("endPlayTime")
                || "".equals(map.get("endPlayTime"))){
            cellTimeValue.setCellValue(""); // 统计时间
        }else{
            cellTimeValue.setCellValue(map.get("beginPlayTime").toString()+"至"+map.get("endPlayTime").toString()); // 统计时间
        }

        HSSFRow rowThird = sheet.getRow(3);//第三行 建表时间

//        Cell makeExcelTimeTitleCell = rowThird.createCell(0);
//        makeExcelTimeTitleCell.setCellValue("制表时间");

        Cell cellCreateTableValue = rowThird.createCell(1);
        cellCreateTableValue.setCellValue(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        //将信息写入表中
        int rowCount=5;
        for (PlayLog log:logsList){
            HSSFRow row=sheet.createRow(rowCount);

            Cell cellBroadcastDate = row.createCell(0); // 创建指定单元格对象。如本身有数据会替换掉
            cellBroadcastDate.setCellValue(log.getBroadcastDate()); // 日期
            cellBroadcastDate.setCellStyle(style);

            Cell cellAirTime = row.createCell(1);
            cellAirTime.setCellValue(log.getAirTime()); // 时间
            cellAirTime.setCellStyle(style);

            Cell cellDuration = row.createCell(2);
            cellDuration.setCellValue(log.getDuration()); // 时长
            cellDuration.setCellStyle(style);

            Cell cellPolicyName = row.createCell(3);
            cellPolicyName.setCellValue(log.getPolicyName()); // 播放策略
            cellPolicyName.setCellStyle(style);

            Cell cellDetail = row.createCell(4);
            cellDetail.setCellValue(log.getDetail()); // 播放详情
            cellDetail.setCellStyle(style);

            Cell cellScreen = row.createCell(5);
            cellScreen.setCellValue(log.getScreen()); // 屏幕模式
            cellScreen.setCellStyle(style);

            Cell cellScreenPosition = row.createCell(6);
            cellScreenPosition.setCellValue("up".equals(log.getScreenPosition()) ? "上" : ("down".equals(log.getScreenPosition()) ? "下" : "中")); // 屏幕模式
            cellScreenPosition.setCellStyle(style);

            Cell cellFormerAdvertising = row.createCell(7);
            cellFormerAdvertising.setCellValue(log.getFormerAdvertising()); // 前广告
            cellFormerAdvertising.setCellStyle(style);

            Cell cellAfterTheAdvertising = row.createCell(8);
            cellAfterTheAdvertising.setCellValue(log.getAfterTheAdvertising()); // 后广告
            cellAfterTheAdvertising.setCellStyle(style);

            rowCount++;
        }
        FileOutputStream os=new FileOutputStream(file);
        wb.write(os);
    }
}
