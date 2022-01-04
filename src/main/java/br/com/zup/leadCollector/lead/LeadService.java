package br.com.zup.leadCollector.lead;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeadService {

    @Autowired
    private LeadRepository leadRepository;

    public Lead salvarLead(Lead lead){

    }
}
