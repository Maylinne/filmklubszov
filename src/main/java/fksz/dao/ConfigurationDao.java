package fksz.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import fksz.domain.ConfigItem;

@Component
public interface ConfigurationDao extends CrudRepository<ConfigItem, Integer>
{
	
	ConfigItem findById(Integer id);
	
	ConfigItem findByItemName(String itemName);

}
