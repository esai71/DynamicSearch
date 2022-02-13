package in.sai.ExcelGenerator;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import in.sai.requestandresponse.PlanResponse;

public class ExcelGenerator {
	public void export(List<PlanResponse> plans, HttpServletResponse response) throws Exception {
	XSSFWorkbook workbook=new XSSFWorkbook();
	XSSFSheet sheet=workbook.createSheet("plans");
	XSSFRow row=sheet.createRow(0);
	row.createCell(0).setCellValue("plan_id");
	row.createCell(1).setCellValue("plan_holder_name");
	row.createCell(2).setCellValue("plan_name");
	row.createCell(3).setCellValue("Status");
	
	for(int i=0;i<plans.size();i++)
		
	{
		PlanResponse plan=plans.get(i);
		XSSFRow datarow=sheet.createRow(i+1);
		datarow.createCell(0).setCellValue(plan.getPlanId());
		datarow.createCell(1).setCellValue(plan.getPlanHolderName());
		datarow.createCell(2).setCellValue(plan.getPlanName());
		datarow.createCell(3).setCellValue(plan.getStatus());
		
	}
	ServletOutputStream sops=response.getOutputStream();
	workbook.write(sops);
	workbook.close();
	sops.close();

}

	

}

