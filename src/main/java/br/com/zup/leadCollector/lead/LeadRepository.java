package br.com.zup.leadCollector.lead;

import org.springframework.data.repository.CrudRepository;

public interface LeadRepository extends CrudRepository<Lead, String> {
}
