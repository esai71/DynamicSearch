package in.sai.service;

import java.util.List;

import in.sai.requestandresponse.PlanRequest;
import in.sai.requestandresponse.PlanResponse;

public interface PlanService {
  public List<PlanResponse> getDynamicSearchResult(PlanRequest planRequest);
  public List<String> getAllStatus();
	public List<String> getAllPalnName();
	
}
