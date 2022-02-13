package in.sai.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.sai.entity.PalnInsuranceEntity;
import in.sai.repository.PlanRepository;
import in.sai.requestandresponse.PlanRequest;
import in.sai.requestandresponse.PlanResponse;
import in.sai.service.PlanService;

@Service
public class PlanServiceImpl implements PlanService {
	@Autowired
	PlanRepository planRepository;


	@Override
	public List<PlanResponse> getDynamicSearchResult(PlanRequest request) {

		PalnInsuranceEntity entity=new PalnInsuranceEntity();
		if(request!=null && request.getPlanName()!=null && !request.getPlanName().equals("")) {
			entity.setPlanName(request.getPlanName());
			
		}
		if(request!=null && request.getStatus()!=null && !request.getStatus().equals("")) {
			entity.setStatus(request.getStatus());
			
		}
		Example<PalnInsuranceEntity> of = Example.of(entity);
		List<PalnInsuranceEntity> findAll = planRepository.findAll(of);
		List<PlanResponse> plan=new ArrayList<>();
		for(PalnInsuranceEntity res:findAll)
			
		{
			
			PlanResponse pr=new PlanResponse();
			BeanUtils.copyProperties(res, pr);
			plan.add(pr);
		}
		return plan;
	}


	@Override
	public List<String> getAllStatus() {
		// TODO Auto-generated method stub
		return planRepository.getAllStatus();
	}


	@Override
	public List<String> getAllPalnName() {
		// TODO Auto-generated method stub
		return planRepository.getAllPalnName();
	}

}
