package in.sai.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.sai.ExcelGenerator.ExcelGenerator;
import in.sai.requestandresponse.PlanRequest;
import in.sai.requestandresponse.PlanResponse;
import in.sai.service.PlanService;

@RestController
public class PlanController {
	@Autowired
	PlanService planService;
	
	@PostMapping("/planSearch")
	public ResponseEntity<?> getSearchData(@RequestBody PlanRequest request)
	{
		System.out.println("sssssss"+request);
		ResponseEntity<?> pr=null;
		try {
			List<PlanResponse> ll=	planService.getDynamicSearchResult(request);
			pr=new  ResponseEntity<List<PlanResponse>>(ll,HttpStatus.OK);
		}
		catch(Exception e)
		{
			String body="No Data Available";
			pr= new ResponseEntity<String>(body,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return pr;
		
	}
	
	
	@GetMapping("/getPlans")
	public ResponseEntity<?>getAllPlans()
	{
		ResponseEntity<?> pr=null;
		try {
		List<String> lll=planService.getAllPalnName();
		pr=new  ResponseEntity<List<String>>(lll,HttpStatus.OK);
	}
		catch(Exception e)
		{
			String body="No plans Available";
			pr= new ResponseEntity<String>(body,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return pr;
 }
	@GetMapping("/getStatus")
	public ResponseEntity<?>getAllStatus()
	{
		ResponseEntity<?> pr=null;
		try {
		List<String> lll=planService.getAllStatus();
		pr=new  ResponseEntity<List<String>>(lll,HttpStatus.OK);
	}
		catch(Exception e)
		{
			String body="No Status Available";
			pr= new ResponseEntity<String>(body,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return pr;
 }


	@GetMapping("/excel")
    public void exportToExcel(HttpServletResponse response) throws Exception {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=plans_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
         
        List<PlanResponse> plans = planService.getDynamicSearchResult(null);
         
        ExcelGenerator excelExporter = new ExcelGenerator();
         
        
      
        excelExporter.export(plans, response);
    }  
}




